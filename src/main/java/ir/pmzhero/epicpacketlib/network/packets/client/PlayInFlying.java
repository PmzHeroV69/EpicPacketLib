package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInFlyingEvent;
import net.minecraft.server.v1_8_R3.PacketPlayInFlying;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayInFlying implements ClientPacket {

    private final PacketEvent event;

    public PlayInFlying(Object msg, Player player) {

        PacketPlayInFlying p = (PacketPlayInFlying) msg;
        event = new PlayInFlyingEvent(player, new Location(
                player.getWorld(),
                p.a(),
                p.b(),
                p.c(),
                p.d(),
                p.e()
        ), p instanceof PacketPlayInFlying.PacketPlayInPosition ? PlayInFlyingEvent.MoveType.POSITION
                : p instanceof PacketPlayInFlying.PacketPlayInPositionLook ? PlayInFlyingEvent.MoveType.POSITION_LOOK
                : p instanceof PacketPlayInFlying.PacketPlayInLook ? PlayInFlyingEvent.MoveType.LOOK : PlayInFlyingEvent.MoveType.UNKNOWN);
    }

    @Override
    public PacketEvent getEvent() {
        return event;
    }
}
