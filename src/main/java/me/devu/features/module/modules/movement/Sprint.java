package me.devu.features.module.modules.movement;

import me.devu.features.module.Category;
import me.devu.features.module.Module;
import me.devu.setting.Setting;


public class Sprint extends Module {

    public Sprint() {
        super("Sprint", Category.MOVEMENT, "Auto sprint for lazy people.");
    }

    public static final Setting<Mode> mode = new Setting<>("Mode", Mode.LEGIT);

    @Override
    protected void onDisable() {
        if (nullCheck()) {
            mc.player.setSprinting(false);
        }
    }

    @Override
    public void onUpdate() {
        if (mode.getValue().equals(Mode.LEGIT) && (!mc.gameSettings.keyBindForward.isKeyDown() || mc.player.isSneaking() || mc.player.isHandActive() || mc.player.getFoodStats().getFoodLevel() <= 6 || mc.player.collidedHorizontally)) {
            return;
        }

        if (!mc.player.isSprinting()) {
            mc.player.setSprinting(true);
        }
    }

    public enum Mode {

        LEGIT,

        RAGE
    }
}
