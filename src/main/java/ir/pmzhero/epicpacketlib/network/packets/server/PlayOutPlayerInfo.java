package ir.pmzhero.epicpacketlib.network.packets.server;

import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PlayOutPlayerInfo implements ServerPacket {

    private final PacketPlayOutPlayerInfo packet;
    private final Player player;
    private final InfoType type;

    public PlayOutPlayerInfo(InfoType type, Player player) {
        packet = new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.valueOf(type.toString()), ((CraftPlayer) player).getHandle());
        this.player = player;
        this.type = type;
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

    public String toString() {
        return "PlayOutPlayerInfo{" +
                "player=" + player +
                ", type=" + type +
                '}';
    }

    public InfoType getType() {
        return type;
    }

    public Player getPlayer() {
        return player;
    }

    public enum InfoType {
        ADD_PLAYER,
        UPDATE_GAME_MODE,
        UPDATE_LATENCY,
        UPDATE_DISPLAY_NAME,
        REMOVE_PLAYER
    }
}
