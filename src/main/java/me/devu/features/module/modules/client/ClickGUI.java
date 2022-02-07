package me.devu.features.module.modules.client;

import me.devu.features.module.Category;
import me.devu.features.module.Module;
import me.devu.setting.Setting;
import me.devu.ui.click.ClickGUIScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {
    public static ClickGUI INSTANCE;

    public ClickGUI() {
        super("ClickGUI", Category.CLIENT, "ClickGUI and balls.", Keyboard.KEY_Y);
        INSTANCE = this;
    }

    public static final Setting<Boolean> pause = new Setting<>("Pause", false);

    @Override
    protected void onEnable() {
        if (nullCheck()) {
            mc.displayGuiScreen(ClickGUIScreen.getInstance());
        } else {
            toggle();
        }
    }

    @Override
    protected void onDisable() {
        if (nullCheck()) {
            mc.displayGuiScreen(null);
        }
    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event) {
        if (!(event.getGui() instanceof ClickGUIScreen)) {
            toggle();
        }
    }

}