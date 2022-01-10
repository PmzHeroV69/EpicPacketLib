package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class PlayInAbilitiesEvent extends PlayerEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private final boolean isInvulnerable;
    private final boolean isFlying;
    private final boolean canFly;
    private final boolean canInstantlyBuild;
    private final float flySpeed;
    private final float walkSpeed;


    public PlayInAbilitiesEvent(Player player, boolean isInvulnerable, boolean isFlying, boolean canFly, boolean canInstantlyBuild, float flySpeed, float walkSpeed) {

        super(player);
        this.isInvulnerable = isInvulnerable;
        this.isFlying = isFlying;
        this.canFly = canFly;
        this.canInstantlyBuild = canInstantlyBuild;
        this.flySpeed = flySpeed;
        this.walkSpeed = walkSpeed;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public boolean isInvulnerable() {
        return isInvulnerable;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean canInstantlyBuild() {
        return canInstantlyBuild;
    }

    public float getFlySpeed() {
        return flySpeed;
    }

    public float getWalkSpeed() {
        return walkSpeed;
    }

}
