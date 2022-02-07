package me.devu.util.render;

import me.devu.util.Wrapper;

public class ScaleUtil implements Wrapper {
    public static double alignV(String text, double x, double width) {
        return x + (width / 2.0) - (mc.fontRenderer.getStringWidth(text) / 2.0);
    }

    public static double alignH(double y, double height) {
        return (y + (height / 2.0)) - mc.fontRenderer.FONT_HEIGHT / 2.0;
    }
}