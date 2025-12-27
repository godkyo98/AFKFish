package Kyo.autofish;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.world.entity.Entity;
import org.lwjgl.glfw.GLFW;
import Kyo.autofish.config.Config;
import Kyo.autofish.config.ConfigManager;
import Kyo.autofish.gui.AutofishScreenBuilder;
import Kyo.autofish.scheduler.AutofishScheduler;
import com.mojang.blaze3d.platform.InputConstants;

public class FabricModAutofish implements ClientModInitializer {

    private static FabricModAutofish instance;
    private Autofish autofish;
    private AutofishScheduler scheduler;
    private KeyMapping autofishGuiKey;
    private ConfigManager configManager;

    @Override
    public void onInitializeClient() {

        if (instance == null) instance = this;

        //Create ConfigManager
        this.configManager = new ConfigManager(this);
        //Register Keybinding
        autofishGuiKey = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.autofish.open_gui", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V, KeyMapping.Category.MISC));
        //Register Tick Callback
        ClientTickEvents.END_CLIENT_TICK.register(this::tick);
        //Create Scheduler instance
        this.scheduler = new AutofishScheduler(this);
        //Create Autofisher instance
        this.autofish = new Autofish(this);

    }

    public void tick(Minecraft client) {
        if (autofishGuiKey.consumeClick()) {
            client.setScreen(AutofishScreenBuilder.buildScreen(this, client.screen));
        }
        autofish.tick(client);
        scheduler.tick(client);
    }

    /**
     * Mixin callback for Sound and EntityVelocity packets (multiplayer detection)
     */
    public void handlePacket(Packet<?> packet) {
        autofish.handlePacket(packet);
    }

    /**
     * Mixin callback for chat packets
     */
    public void handleChat(ClientboundSystemChatPacket packet) {
        autofish.handleChat(packet);
    }

    /**
     * Mixin callback for catchingFish method of EntityFishHook (singleplayer detection)
     */
    public void tickFishingLogic(Entity owner, int ticksCatchable) {
        autofish.tickFishingLogic(owner, ticksCatchable);
    }

    public static FabricModAutofish getInstance() {
        return instance;
    }

    public Autofish getAutofish() {
        return autofish;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public Config getConfig() {
        return configManager.getConfig();
    }

    public AutofishScheduler getScheduler() {
        return scheduler;
    }
}
