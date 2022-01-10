package ir.pmzhero.epicpacketlib.network.packets;

import ir.pmzhero.epicpacketlib.network.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class PlayOutEntityHeadRotation implements Packet {

    private final PacketPlayOutEntityHeadRotation packet;
    private final Entity entity;
    private final byte rotation;

    public PlayOutEntityHeadRotation(Entity entity, byte rotation) {
        this.entity = entity;
        this.rotation = rotation;
        this.packet = new PacketPlayOutEntityHeadRotation(((CraftEntity) entity).getHandle(), rotation);
    }

    public PlayOutEntityHeadRotation(Entity entity, float yaw) {
        this.entity = entity;
        this.rotation = (byte) ((yaw * 256.0F) / 360.0F);
        this.packet = new PacketPlayOutEntityHeadRotation(((CraftEntity) entity).getHandle(), rotation);
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

    public Entity getEntity() {
        return entity;
    }

    public byte getRotation() {
        return rotation;
    }

    @Override
    public String toString() {
        return "PlayOutEntityHeadRotation{" +
                "entity=" + entity +
                ", rotation=" + rotation +
                '}';
    }
}
