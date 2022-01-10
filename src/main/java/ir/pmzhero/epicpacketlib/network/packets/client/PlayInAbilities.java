package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInAbilitiesEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import org.bukkit.entity.Player;

public class PlayInAbilities implements ClientPacket {

    private final PacketEvent event;

    public PlayInAbilities(Object msg, Player player) {
        event = new PlayInAbilitiesEvent(
                player,
                (boolean) PacketReader.getValue(msg, "a"),
                (boolean) PacketReader.getValue(msg, "b"),
                (boolean) PacketReader.getValue(msg, "c"),
                (boolean) PacketReader.getValue(msg, "d"),
                (float) PacketReader.getValue(msg, "e"),
                (float) PacketReader.getValue(msg, "f"),
                msg
        );
    }

    public PacketEvent getEvent() {
        return event;
    }
}
