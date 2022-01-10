package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayInChatEvent extends PlayerEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final String chat;

    public PlayInChatEvent(Player player, String chat) {
        super(player);
        this.chat = chat;
    }

    public String getChat() {
        return chat;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}
