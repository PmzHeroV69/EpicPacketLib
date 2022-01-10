package ir.pmzhero.epicpacketlib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.lang.reflect.Field;

public class PlayInAbilitiesEvent extends PacketEvent {

    private static final HandlerList HANDLERS_LIST = new HandlerList();

    private boolean isInvulnerable;
    private boolean isFlying;
    private boolean canFly;
    private boolean canInstantlyBuild;
    private float flySpeed;
    private float walkSpeed;
    private final Object msg;


    public PlayInAbilitiesEvent(Player player, boolean isInvulnerable, boolean isFlying, boolean canFly, boolean canInstantlyBuild, float flySpeed, float walkSpeed, Object msg) {
        super(player);
        this.isInvulnerable = isInvulnerable;
        this.isFlying = isFlying;
        this.canFly = canFly;
        this.canInstantlyBuild = canInstantlyBuild;
        this.flySpeed = flySpeed;
        this.walkSpeed = walkSpeed;
        this.msg = msg;
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

    public void setInvulnerable(boolean b) {
        setValue(msg, "a", b);
        isInvulnerable = b;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean b) {
        setValue(msg, "b", b);
        isFlying = b;
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean b) {
        setValue(msg, "c", b);
        canFly = b;
    }

    public boolean canInstantlyBuild() {
        return canInstantlyBuild;
    }

    public void setCanInstantlyBuild(boolean b) {
        setValue(msg, "d", b);
        canInstantlyBuild = b;
    }

    public float getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(float speed) {
        setValue(msg, "e", speed);
        flySpeed = speed;
    }

    public float getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(float speed) {
        setValue(msg, "f", speed);
        walkSpeed = speed;
    }

    private void setValue(Object obj, String val, Object to) {
        try {
            Field field = obj.getClass().getDeclaredField(val);
            field.setAccessible(true);
            field.set(obj, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
