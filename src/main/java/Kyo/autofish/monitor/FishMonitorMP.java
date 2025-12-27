package Kyo.autofish.monitor;

import Kyo.autofish.Autofish;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.projectile.FishingHook;

public interface FishMonitorMP {

    void hookTick(Autofish autofish, Minecraft minecraft, FishingHook hook);

    void handleHookRemoved();

    void handlePacket(Autofish autofish, Packet<?> packet, Minecraft minecraft);

}
