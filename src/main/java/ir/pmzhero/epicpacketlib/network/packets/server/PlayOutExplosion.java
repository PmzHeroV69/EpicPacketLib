package ir.pmzhero.epicpacketlib.network.packets.server;

import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class PlayOutExplosion implements ServerPacket {

    private final PacketPlayOutExplosion packet;

    private final Location location;
    private final float power;
    private final Vector velocity;

    public PlayOutExplosion(Location location, float power, Vector velocity) {
        this.location = location;
        this.power = power;
        this.velocity = velocity;
        packet = new PacketPlayOutExplosion(location.getX(), location.getY(), location.getZ(), power, Collections.emptyList(), new Vec3D(velocity.getX(), velocity.getY(), velocity.getZ()));
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

    public Vector getVelocity() {
        return velocity;
    }

    public float getPower() {
        return power;
    }

    public String toString() {
        return "PlayOutExplosion{" +
                "packet=" + packet +
                ", location=" + location +
                ", power=" + power +
                ", velocity=" + velocity +
                '}';
    }
}
