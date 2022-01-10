package ir.pmzhero.epicpacketlib.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayInFlyingEvent extends PacketEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final Location location;
    private final MoveType type;

    public PlayInFlyingEvent(Player player, Location location, MoveType type) {
        super(player);
        this.location = location;
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public MoveType getType() {
        return type;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public enum MoveType {
        POSITION,
        POSITION_LOOK,
        LOOK,
        UNKNOWN
    }

}
