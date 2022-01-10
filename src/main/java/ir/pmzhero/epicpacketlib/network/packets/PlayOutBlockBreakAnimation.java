package ir.pmzhero.epicpacketlib.network.packets;

import ir.pmzhero.epicpacketlib.network.Packet;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockBreakAnimation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PlayOutBlockBreakAnimation implements Packet {

    private final PacketPlayOutBlockBreakAnimation packet;
    private final Location location;
    private final int level;

    public PlayOutBlockBreakAnimation(Location location, int level) {
        this.location = location;
        this.level = level;
        packet = new PacketPlayOutBlockBreakAnimation(location.getBlockX() ^ location.getBlockZ() << 12 ^ location.getBlockY() << 24
                , new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ()), level);
    }

    public PlayOutBlockBreakAnimation(Block block, int level) {
        this.location = block.getLocation();
        this.level = level;
        packet = new PacketPlayOutBlockBreakAnimation(location.getBlockX() ^ location.getBlockZ() << 12 ^ location.getBlockY() << 24
                , new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ()), level);
    }

    public void send(Player player) {
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    public void send(Player... players) {
        for (Player p : players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void send(List<Player> players) {
        for (Player p : players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void send(Set<Player> players) {
        for (Player p : players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void send(Collection<Player> players) {
        for (Player p : players) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void sendToAllPlayers() {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player player : players) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public void sendToAllPlayersInWorld(World world) {
        for (Player player : world.getPlayers()) {
            ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        }
    }

    public Location getLocation() {
        return location;
    }

    public int getLevel() {
        return level;
    }

    public String toString() {
        return "PlayOutBlockBreakAnimation{" +
                "location=" + location +
                ", level=" + level +
                '}';
    }
}
