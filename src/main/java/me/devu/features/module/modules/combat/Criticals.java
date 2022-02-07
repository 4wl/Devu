package me.devu.features.module.modules.combat;

import me.devu.api.event.events.PacketEvent;
import me.devu.features.module.Category;
import me.devu.features.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;

public class Criticals extends Module {

    public Criticals() {
        super("Criticals", Category.COMBAT, "Criticals hits.");
    }

    @EventHandler
    private final Listener<PacketEvent.Receive> onPacketSend = new Listener<>(event -> {
        {
            if (nullCheck()) return;

            if (event.getPacket() instanceof CPacketUseEntity && ((CPacketUseEntity) event.getPacket()).getAction() == CPacketUseEntity.Action.ATTACK && mc.player.onGround) {
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1, mc.player.posZ, false));
                mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
            }
        }
     });
}
