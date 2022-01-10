package ir.pmzhero.epicpacketlib.network.packets.server;

import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PlayOutSpawnEntityLiving implements ServerPacket {

    private final PacketPlayOutSpawnEntityLiving packet;
    private final LivingEntity entity;

    public PlayOutSpawnEntityLiving(LivingEntity entity) {
        this.entity = entity;
        packet = new PacketPlayOutSpawnEntityLiving(((CraftLivingEntity) entity).getHandle());
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

    public LivingEntity getEntity() {
        return entity;
    }

    public String toString() {
        return "PlayOutSpawnEntityLiving{" +
                "packet=" + packet +
                ", entity=" + entity +
                '}';
    }
}
