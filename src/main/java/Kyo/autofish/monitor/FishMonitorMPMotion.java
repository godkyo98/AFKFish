package Kyo.autofish.monitor;

import Kyo.autofish.Autofish;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class FishMonitorMPMotion implements FishMonitorMP {

  // The threshold of detecting a bobber moving downwards, to detect as a fish.
  public static final int PACKET_MOTION_Y_THRESHOLD = -350;

  // Start catching fish after a 1 second threshold of hitting water.
  public static final int START_CATCHING_AFTER_THRESHOLD = 1000;

  // True if the bobber is in the water.
  private boolean hasHitWater = false;

  // Time at which bobber begins to rise in the water.
  // 0 if the bobber has not rose in the water yet.
  private long bobberRiseTimestamp = 0;

  @Override
  public void hookTick(
    Autofish autofish,
    Minecraft minecraft,
    FishingHook hook
  ) {
    if (
      worldContainsBlockWithMaterial(hook.level(), hook.getBoundingBox())
    ) {
      hasHitWater = true;
    }
  }

  @Override
  public void handleHookRemoved() {
    hasHitWater = false;
    bobberRiseTimestamp = 0;
  }

  @Override
  public void handlePacket(
    Autofish autofish,
    Packet<?> packet,
    Minecraft minecraft
  ) {
    if (packet instanceof ClientboundSetEntityMotionPacket velocityPacket) {
        if (
        minecraft.player != null &&
        minecraft.player.fishing != null &&
        minecraft.player.fishing.getId() == velocityPacket.getId()
      ) {
            // TỐI ƯU: Lấy đối tượng velocity một lần và dùng lại
            Vec3 velocity = velocityPacket.getMovement();
          // Chờ cho đến khi phao nổi lên trong nước.
          // Ngăn việc đánh dấu lại thời gian phao nổi cho đến khi nó được reset bằng cách câu cá.
        if (
          hasHitWater &&
          bobberRiseTimestamp == 0 &&
          velocity.y() > 0
        ) {
          // Đánh dấu thời gian phao bắt đầu nổi lên.
          bobberRiseTimestamp = autofish.timeMillis;
        }

        // Tính thời gian phao đã ở trong nước
        long timeInWater = autofish.timeMillis - bobberRiseTimestamp;

        // Nếu phao đã ở trong nước đủ lâu, bắt đầu phát hiện chuyển động của phao.
        if (
          hasHitWater &&
          bobberRiseTimestamp != 0 &&
          timeInWater > START_CATCHING_AFTER_THRESHOLD
        ) {
          if (
            velocity.x() == 0 &&
            velocity.z() == 0 &&
            velocity.y() < PACKET_MOTION_Y_THRESHOLD
          ) {
            // Câu cá
            autofish.catchFish();

            // Reset các thuộc tính của lớp về mặc định.
            this.handleHookRemoved();
          }
        }
      }
    }
  }

  public static boolean worldContainsBlockWithMaterial(
    Level world,
    AABB box
    /*, Material material*/
  ) {
    int i = Mth.floor(box.minX);
    int j = Mth.ceil(box.maxX);
    int k = Mth.floor(box.minY);
    int l = Mth.ceil(box.maxY);
    int m = Mth.floor(box.minZ);
    int n = Mth.ceil(box.maxZ);
    // MaterialPredicate materialPredicate = MaterialPredicate.create(material);
    return BlockPos
      .betweenClosedStream(i, k, m, j - 1, l - 1, n - 1)
      .anyMatch(blockPos -> {
        // world.getBlockState(blockPos).contains(new Property<T>() {});
        return world.getBlockState(blockPos).hasProperty(BlockStateProperties.LEVEL_COMPOSTER);
        // return materialPredicate.test(world.getBlockState(blockPos));
      });
  }
}
