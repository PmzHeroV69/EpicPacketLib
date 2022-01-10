package ir.pmzhero.epicpacketlib;

import ir.pmzhero.epicpacketlib.events.PlayInChatEvent;
import ir.pmzhero.epicpacketlib.network.PacketReader;
import ir.pmzhero.epicpacketlib.network.packets.server.PlayOutPlayerInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicPacketLib extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        for (Player player : getServer().getOnlinePlayers()) {
            new PacketReader(player).inject();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        new PacketReader(e.getPlayer()).inject();
    }

}
