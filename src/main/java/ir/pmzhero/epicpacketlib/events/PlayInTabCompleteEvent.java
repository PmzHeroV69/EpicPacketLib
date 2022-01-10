package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayInTabCompleteEvent extends PlayerEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final String completion;

    public PlayInTabCompleteEvent(Player player, String completion) {
        super(player);
        this.completion = completion;
    }

    public String getCompletion() {
        return completion;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}

