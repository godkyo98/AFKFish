package Kyo.autofish.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import Kyo.autofish.FabricModAutofish;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.FishingHook;

@Mixin(FishingHook.class)
public class MixinFishHookEntity {

    //field_7173;
    @Shadow private int hookCountdown;

    //method_6949
    @Inject(method = "tickFishingLogic", at = @At("TAIL"))
    private void tickFishingLogic(BlockPos blockPos_1, CallbackInfo ci) {
        FabricModAutofish.getInstance().tickFishingLogic(((FishingHook) (Object) this).getOwner(), hookCountdown);
    }
}
