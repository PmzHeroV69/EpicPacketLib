package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInTabCompleteEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import org.bukkit.entity.Player;

public class PlayInTabComplete implements ClientPacket {

    private final PacketEvent event;

    public PlayInTabComplete(Object msg, Player player) {

        event = new PlayInTabCompleteEvent(player, (String) PacketReader.getValue(msg, "a"));
    }

    @Override
    public PacketEvent getEvent() {
        return event;
    }
}
