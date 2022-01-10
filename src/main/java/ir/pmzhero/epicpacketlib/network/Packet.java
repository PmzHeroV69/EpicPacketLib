package ir.pmzhero.epicpacketlib.network;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Packet {

    void send(Player player);
    void send(Player... players);
    void send(List<Player> players);
    void send(Set<Player> players);
    void send(Collection<Player> players);
    void sendToAllPlayers();
    void sendToAllPlayersInWorld(World world);
    String toString();

}
