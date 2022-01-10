package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public abstract class PacketEvent extends Event implements Cancellable {

    protected Player player;
    protected boolean cancelled = false;

    public PacketEvent(Player who) {
        this.player = who;
    }

    PacketEvent(Player who, boolean async) {
        super(async);
        this.player = who;
    }

    public final Player getPlayer() {
        return this.player;
    }
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean b) {
        cancelled = b;
    }
}
