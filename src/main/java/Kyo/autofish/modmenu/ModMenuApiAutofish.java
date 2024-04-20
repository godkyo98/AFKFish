package Kyo.autofish.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import Kyo.autofish.FabricModAutofish;
import Kyo.autofish.gui.AutofishScreenBuilder;

public class ModMenuApiAutofish implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> AutofishScreenBuilder.buildScreen(FabricModAutofish.getInstance(), parent);
    }
}
