package me.devu.features.module.modules.render;

import me.devu.features.module.Category;
import me.devu.features.module.Module;

public class FullBright extends Module {

    public FullBright() {
        super("FullBright", Category.RENDER, "Fully bright");
    }

    @Override
    public void onEnable() {
        mc.gameSettings.gammaSetting = 100f;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = 1f;
    }
}
