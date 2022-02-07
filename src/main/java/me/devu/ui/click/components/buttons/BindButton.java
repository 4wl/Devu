package me.devu.ui.click.components.buttons;

import com.mojang.realmsclient.gui.ChatFormatting;
import  me.devu.ui.base.AbstractButton;
import me.devu.setting.Bind;
import me.devu.util.render.RenderUtil;
import me.devu.util.render.ScaleUtil;
import org.lwjgl.input.Keyboard;

import static me.devu.ui.click.components.buttons.ModuleButton.BACKGROUND;

public class BindButton extends AbstractButton {
    private final Bind bind;

    private boolean listening = false;

    public BindButton(Bind bind) {
        super(bind.getName());
        this.bind = bind;
    }

    @Override
    public void render(int mouseX, int mouseY) {
        String text = listening ? "Listening..." : (name + ": " + ChatFormatting.GRAY + Keyboard.getKeyName(bind.getValue()));
        RenderUtil.drawRectangle(x, y, width, height, BACKGROUND.getRGB());

        mc.fontRenderer.drawStringWithShadow(text, (float) (x + 2.3), (float) ScaleUtil.alignH(y, height), -1);
    }

    @Override
    public void onClick(int button) {
        listening = !listening;
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        if (listening) {
            listening = false;

            if (keyCode == Keyboard.KEY_ESCAPE) {
                return;
            }

            if (keyCode == Keyboard.KEY_DELETE) {
                bind.setValue(Keyboard.KEY_NONE);
                return;
            }

            bind.setValue(keyCode);
        }
    }
}