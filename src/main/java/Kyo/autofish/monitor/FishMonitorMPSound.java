package Kyo.autofish.monitor;

import Kyo.autofish.Autofish;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSoundEntityPacket;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.projectile.FishingHook;

public class FishMonitorMPSound implements FishMonitorMP {

    public static final double HOOKSOUND_DISTANCESQ_THRESHOLD = 25D;

    @Override
    public void hookTick(Autofish autofish, Minecraft minecraft, FishingHook hook) {
    }

    @Override
    public void handleHookRemoved() {
    }

    @Override
    public void handlePacket(Autofish autofish, Packet<?> packet, Minecraft minecraft) {

        if (packet instanceof ClientboundSoundPacket || packet instanceof ClientboundSoundEntityPacket) {
            //TODO investigate PlaySoundFromEntityS2CPacket; i dont think its ever used for fishing but whatever

            String soundName;
            double x, y, z;

            if (packet instanceof ClientboundSoundPacket) {
                ClientboundSoundPacket soundPacket = (ClientboundSoundPacket) packet;
                SoundEvent soundEvent = soundPacket.getSound().value();
                soundName = soundEvent.location().toString();
                x = soundPacket.getX();
                y = soundPacket.getY();
                z = soundPacket.getZ();
            } else {
                return;
            }

            if (soundName.equalsIgnoreCase("minecraft:entity.fishing_bobber.splash") || soundName.equalsIgnoreCase("entity.fishing_bobber.splash")) {
                if(minecraft.player != null) {
                    FishingHook hook = minecraft.player.fishing;
                    if (hook != null) {
                        if (hook.distanceToSqr(x, y, z) < HOOKSOUND_DISTANCESQ_THRESHOLD) {
                            autofish.catchFish();
                        }
                    }
                }
            }
        }

    }
}
