package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInBlockDigEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import net.minecraft.server.v1_8_R3.BlockPosition;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayInBlockDig implements ClientPacket {

    private final PacketEvent event;

    public PlayInBlockDig(Object msg, Player player) {
        BlockPosition position = (BlockPosition) PacketReader.getValue(msg, "a");
        event = new PlayInBlockDigEvent(player, PlayInBlockDigEvent.DigType.valueOf(PacketReader.getValue(msg, "c").toString()),
                new Location(
                        player.getWorld(),
                        position.getX(),
                        position.getY(),
                        position.getZ()
                )
        );
    }

    @Override
    public PacketEvent getEvent() {
        return event;
    }
}
