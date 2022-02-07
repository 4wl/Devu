package me.devu.util;

import me.devu.Devu;
import net.minecraft.client.Minecraft;

public interface Wrapper {
    Minecraft mc = Minecraft.getMinecraft();

    default boolean nullCheck() {
        return mc.world != null && mc.player != null;
    }

    default Devu getDevu() {
        return Devu.INSTANCE;
    }
}