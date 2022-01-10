package ir.pmzhero.epicpacketlib.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayInBlockPlaceEvent extends PacketEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final Location location;
    private final ItemStack placedItem;

    public PlayInBlockPlaceEvent(Player player, Location location, ItemStack placedItem) {
        super(player);
        this.location = location;
        this.placedItem = placedItem;
    }

    public Location getLocation() {
        return location;
    }

    public ItemStack getPlacedItem() {
        return placedItem;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

}
