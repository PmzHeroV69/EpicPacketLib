package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.lang.reflect.Field;

public class PlayInChatEvent extends PacketEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private String chat;
    private final Object msg;

    public PlayInChatEvent(Player player, String chat, Object msg) {
        super(player);
        this.chat = chat;
        this.msg = msg;

    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        try {
            Field field = msg.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(msg, chat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.chat = chat;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}
