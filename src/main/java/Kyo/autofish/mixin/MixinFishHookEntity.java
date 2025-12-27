package Kyo.autofish.mixin;

import Kyo.autofish.FabricModAutofish;
import net.minecraft.core.BlockPos; // QUAN TRỌNG: Mojang dùng package 'core'
import net.minecraft.world.entity.projectile.FishingHook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingHook.class)
public class MixinFishHookEntity {

    // Mojang name: nibble (thay cho hookCountdown)
    @Shadow private int nibble;

    // Mojang name: catchingFish (thay cho tickFishingLogic)
    @Inject(method = "catchingFish", at = @At("TAIL"))
    private void catchingFish(BlockPos pos, CallbackInfo ci) {
        FabricModAutofish.getInstance().tickFishingLogic(((FishingHook) (Object) this).getOwner(), nibble);
    }
}