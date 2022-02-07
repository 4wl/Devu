package me.devu.ui.click.components.buttons;

import me.devu.ui.base.AbstractButton;
import me.devu.setting.Setting;
import me.devu.util.render.RenderUtil;
import me.devu.util.render.ScaleUtil;

import static me.devu.ui.click.components.buttons.ModuleButton.BACKGROUND;

public class BooleanButton extends AbstractButton {
    protected final Setting<Boolean> setting;

    public BooleanButton(Setting<Boolean> setting) {
        super(setting.getName());

        this.setting = setting;
    }

    @Override
    public void render(int mouseX, int mouseY) {
        RenderUtil.drawRectangle(x, y, width, height, setting.getValue() ? BACKGROUND.darker().darker().getRGB() : BACKGROUND.getRGB());
        mc.fontRenderer.drawStringWithShadow(name, (float) (x + 3.0), (float) ScaleUtil.alignH(y, height), -1);
    }

    @Override
    public void onClick(int button) {
        if (button == 0) {
            setting.setValue(!setting.getValue());
        }
    }
}