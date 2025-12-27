package Kyo.autofish.gui;

import me.shedaniel.clothconfig2.api.AbstractConfigListEntry;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.impl.builders.SubCategoryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import Kyo.autofish.FabricModAutofish;
import Kyo.autofish.config.Config;

import java.util.function.Function;

public class AutofishScreenBuilder {

    private static final Function<Boolean, Component> yesNoTextSupplier = bool -> {
        if (bool) return Component.translatable("options.autofish.toggle.on");
        else return Component.translatable("options.autofish.toggle.off");
    };

    public static Screen buildScreen(FabricModAutofish modAutofish, Screen parentScreen) {

        Config defaults = new Config();
        Config config;
        config = modAutofish.getConfig();

        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parentScreen)
                .setTitle(Component.translatable("options.autofish.title"))
                .transparentBackground()
                .setDoesConfirmSave(true)
                .setSavingRunnable(() -> {
                    modAutofish.getConfig().enforceConstraints();
                    modAutofish.getConfigManager().writeConfig(true);
                });

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        ConfigCategory configCat = builder.getOrCreateCategory(Component.translatable("options.autofish.config"));


        //Enable Autofish
        AbstractConfigListEntry<Boolean> toggleAutofish = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.enable.title"), config.isAutofishEnabled())
                .setDefaultValue(defaults.isAutofishEnabled())
                .setTooltip(Component.translatable("options.autofish.enable.tooltip"))
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setAutofishEnabled(newValue);
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();

        //Enable MultiRod
        AbstractConfigListEntry<Boolean> toggleMultiRod = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.multirod.title"), config.isMultiRod())
                .setDefaultValue(defaults.isMultiRod())
                .setTooltip(
                        Component.translatable("options.autofish.multirod.tooltip_0"),
                        Component.translatable("options.autofish.multirod.tooltip_1"),
                        Component.translatable("options.autofish.multirod.tooltip_2")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setMultiRod(newValue);
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();

        //Enable Break Protection
        AbstractConfigListEntry<Boolean> toggleBreakProtection = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.break_protection.title"), config.isNoBreak())
                .setDefaultValue(defaults.isNoBreak())
                .setTooltip(
                        Component.translatable("options.autofish.break_protection.tooltip_0"),
                        Component.translatable("options.autofish.break_protection.tooltip_1")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setNoBreak(newValue);
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();

        //Enable Persistent Mode
        AbstractConfigListEntry<Boolean> togglePersistentMode = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.persistent.title"), config.isPersistentMode())
                .setDefaultValue(defaults.isPersistentMode())
                .setTooltip(
                        Component.translatable("options.autofish.persistent.tooltip_0"),
                        Component.translatable("options.autofish.persistent.tooltip_1"),
                        Component.translatable("options.autofish.persistent.tooltip_2"),
                        Component.translatable("options.autofish.persistent.tooltip_3"),
                        Component.translatable("options.autofish.persistent.tooltip_4"),
                        Component.translatable("options.autofish.persistent.tooltip_5")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setPersistentMode(newValue);
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();


        //Enable Sound Detection
        AbstractConfigListEntry<Boolean> toggleSoundDetection = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.sound.title"), config.isUseSoundDetection())
                .setDefaultValue(defaults.isUseSoundDetection())
                .setTooltip(
                        Component.translatable("options.autofish.sound.tooltip_0"),
                        Component.translatable("options.autofish.sound.tooltip_1"),
                        Component.translatable("options.autofish.sound.tooltip_2"),
                        Component.translatable("options.autofish.sound.tooltip_3"),
                        Component.translatable("options.autofish.sound.tooltip_4"),
                        Component.translatable("options.autofish.sound.tooltip_5"),
                        Component.translatable("options.autofish.sound.tooltip_6"),
                        Component.translatable("options.autofish.sound.tooltip_7"),
                        Component.translatable("options.autofish.sound.tooltip_8"),
                        Component.translatable("options.autofish.sound.tooltip_9")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setUseSoundDetection(newValue);
                    modAutofish.getAutofish().setDetection();
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();

        //Enable Force MP Detection
        AbstractConfigListEntry<Boolean> toggleForceMPDetection = entryBuilder.startBooleanToggle(Component.translatable("options.autofish.multiplayer_compat.title"), config.isForceMPDetection())
                .setDefaultValue(defaults.isPersistentMode())
                .setTooltip(
                        Component.translatable("options.autofish.multiplayer_compat.tooltip_0"),
                        Component.translatable("options.autofish.multiplayer_compat.tooltip_1"),
                        Component.translatable("options.autofish.multiplayer_compat.tooltip_2")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setForceMPDetection(newValue);
                })
                .setYesNoTextSupplier(yesNoTextSupplier)
                .build();

        //Recast Delay
        AbstractConfigListEntry<Long> recastDelaySlider = entryBuilder.startLongSlider(Component.translatable("options.autofish.recast_delay.title"), config.getRecastDelay(), 500, 5000)
                .setDefaultValue(defaults.getRecastDelay())
                .setTooltip(
                        Component.translatable("options.autofish.recast_delay.tooltip_0"),
                        Component.translatable("options.autofish.recast_delay.tooltip_1")
                )
                .setTextGetter(value -> Component.translatable("options.autofish.recast_delay.value", value))
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setRecastDelay(newValue);
                })
                .build();

        //ClearLag Regex
        AbstractConfigListEntry<String> clearLagRegexField = entryBuilder.startTextField(Component.translatable("options.autofish.clear_regex.title"), config.getClearLagRegex())
                .setDefaultValue(defaults.getClearLagRegex())
                .setTooltip(
                        Component.translatable("options.autofish.clear_regex.tooltip_0"),
                        Component.translatable("options.autofish.clear_regex.tooltip_1"),
                        Component.translatable("options.autofish.clear_regex.tooltip_2")
                )
                .setSaveConsumer(newValue -> {
                    modAutofish.getConfig().setClearLagRegex(newValue);
                })
                .build();


        SubCategoryBuilder subCatBuilderBasic = entryBuilder.startSubCategory(Component.translatable("options.autofish.basic.title"));
        subCatBuilderBasic.add(toggleAutofish);
        subCatBuilderBasic.add(toggleMultiRod);
        subCatBuilderBasic.add(toggleBreakProtection);
        subCatBuilderBasic.add((togglePersistentMode));
        subCatBuilderBasic.setExpanded(true);

        SubCategoryBuilder subCatBuilderAdvanced = entryBuilder.startSubCategory(Component.translatable("options.autofish.advanced.title"));
        subCatBuilderAdvanced.add(toggleSoundDetection);
        subCatBuilderAdvanced.add(toggleForceMPDetection);
        subCatBuilderAdvanced.add(recastDelaySlider);
        subCatBuilderAdvanced.add(clearLagRegexField);
        subCatBuilderAdvanced.setExpanded(true);

        configCat.addEntry(subCatBuilderBasic.build());
        configCat.addEntry(subCatBuilderAdvanced.build());

        return builder.build();

    }
}
