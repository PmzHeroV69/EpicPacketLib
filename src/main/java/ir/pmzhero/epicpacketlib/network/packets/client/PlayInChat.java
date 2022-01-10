package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInChatEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import org.bukkit.entity.Player;

public class PlayInChat implements ClientPacket {

    private final PacketEvent event;

    public PlayInChat(Object msg, Player player) {
        event = new PlayInChatEvent(player, (String) PacketReader.getValue(msg, "a"), msg);
    }

    public PacketEvent getEvent() {
        return event;
    }
}
