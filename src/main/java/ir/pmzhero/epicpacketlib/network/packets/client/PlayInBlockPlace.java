package ir.pmzhero.epicpacketlib.network.packets.client;

import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.events.PlayInBlockPlaceEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayInBlockPlace;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;

public class PlayInBlockPlace implements ClientPacket {

    private final PacketEvent event;

    public PlayInBlockPlace(Object msg, Player player) {

        BlockPosition position = (BlockPosition) PacketReader.getValue(msg, "b");
        event = new PlayInBlockPlaceEvent(player, new Location(
                player.getWorld(),
                position.getX(),
                position.getY(),
                position.getZ()

        ), CraftItemStack.asBukkitCopy(((PacketPlayInBlockPlace) msg).getItemStack()));
    }

    @Override
    public PacketEvent getEvent() {
        return event;
    }
}
