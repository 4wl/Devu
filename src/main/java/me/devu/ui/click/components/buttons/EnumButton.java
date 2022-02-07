package me.devu.ui.click.components.buttons;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.devu.ui.base.AbstractButton;
import me.devu.setting.Setting;
import me.devu.util.render.RenderUtil;
import me.devu.util.render.ScaleUtil;
import me.devu.util.text.FormatUtil;

import static me.devu.ui.click.components.buttons.ModuleButton.BACKGROUND;

public class EnumButton extends AbstractButton {
    private final Setting<Enum> setting;

    public EnumButton(Setting<Enum> setting) {
        super(setting.getName());

        this.setting = setting;
    }

    @Override
    public void render(int mouseX, int mouseY) {
        RenderUtil.drawRectangle(x, y, width, height, BACKGROUND.getRGB());
        mc.fontRenderer.drawStringWithShadow(
                setting.getName() + ": " + ChatFormatting.GRAY + FormatUtil.formatName(setting.getValue().name()),
                (float) (x + 2.3),
                (float) ScaleUtil.alignH(y, height),
                -1
        );
    }

    @Override
    public void onClick(int button) {
        setting.setValue(Setting.increase(setting.getValue()));
    }
}