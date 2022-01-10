package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInUseEntityEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import org.bukkit.entity.Player;

public class PlayInUseEntity implements ClientPacket {

    private final PacketEvent event;

    public PlayInUseEntity(Object msg, Player player) {

        event = new PlayInUseEntityEvent(player, PlayInUseEntityEvent.ActionType.valueOf(PacketReader.getValue(msg, "action").toString()),
                (int) PacketReader.getValue(msg, "a"));
    }

    @Override
    public PacketEvent getEvent() {
        return event;
    }
}
