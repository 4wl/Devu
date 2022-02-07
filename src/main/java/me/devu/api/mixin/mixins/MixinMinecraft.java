package me.devu.api.mixin.mixins;

import me.devu.api.mixin.mixins.accessors.IMinecraft;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public final class MixinMinecraft implements IMinecraft {
    @Shadow
    private int rightClickDelayTimer;

    @Override
    public void setRightClickDelayTimer(final int rightClickDelayTimer) {
        this.rightClickDelayTimer = rightClickDelayTimer;
    }
}
