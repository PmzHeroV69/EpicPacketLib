package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayInUseEntityEvent extends PlayerEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final ActionType actionType;
    private final int id;

    public PlayInUseEntityEvent(Player player, ActionType actionType, int id) {
        super(player);
        this.actionType = actionType;
        this.id = id;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public int getId() {
        return id;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public enum ActionType {
        INTERACT,
        ATTACK,
        INTERACT_AT
    }
}
