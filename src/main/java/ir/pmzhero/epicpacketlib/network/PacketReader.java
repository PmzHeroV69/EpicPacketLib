package ir.pmzhero.epicpacketlib.network;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import ir.pmzhero.epicpacketlib.events.*;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.lang.reflect.Field;

public class PacketReader {

    private final Player player;

    public PacketReader(Player player) {
        this.player = player;
    }

    public void inject() {

        ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline().addBefore("packet_handler", "epic", new ChannelDuplexHandler() {

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

                if (msg instanceof PacketPlayInUseEntity) {

                    call(new PlayInUseEntityEvent(player, PlayInUseEntityEvent.ActionType.valueOf(getValue(msg, "action").toString()),
                            (int) getValue(msg, "a")));

                } else if (msg instanceof PacketPlayInChat) {

                    call(new PlayInChatEvent(player, (String) getValue(msg, "a")));

                } else if (msg instanceof PacketPlayInBlockDig) {

                    BlockPosition position = (BlockPosition) getValue(msg, "a");
                    call(new PlayInBlockDigEvent(player, PlayInBlockDigEvent.DigType.valueOf(getValue(msg, "c").toString()),
                            new Location(
                                    player.getWorld(),
                                    position.getX(),
                                    position.getY(),
                                    position.getZ()
                            )
                            ));

                } else if (msg instanceof PacketPlayInTabComplete) {

                    call(new PlayInTabCompleteEvent(player, (String) getValue(msg, "a")));

                } else if (msg instanceof PacketPlayInFlying) {

                    PacketPlayInFlying p = (PacketPlayInFlying) msg;
                    call(new PlayInFlyingEvent(player, new Location(
                            player.getWorld(),
                            p.a(),
                            p.b(),
                            p.c(),
                            p.d(),
                            p.e()
                    ), p instanceof PacketPlayInFlying.PacketPlayInPosition ? PlayInFlyingEvent.MoveType.POSITION
                            : p instanceof PacketPlayInFlying.PacketPlayInPositionLook ? PlayInFlyingEvent.MoveType.POSITION_LOOK
                            : p instanceof PacketPlayInFlying.PacketPlayInLook ? PlayInFlyingEvent.MoveType.LOOK : PlayInFlyingEvent.MoveType.UNKNOWN));

                } else if (msg instanceof PacketPlayInBlockPlace) {

                    BlockPosition position = (BlockPosition) getValue(msg, "b");
                    call(new PlayInBlockPlaceEvent(player, new Location(
                            player.getWorld(),
                            position.getX(),
                            position.getY(),
                            position.getZ()

                    ), CraftItemStack.asBukkitCopy(((PacketPlayInBlockPlace) msg).getItemStack())));

                } else if (msg instanceof PacketPlayInAbilities) {
                    call(new PlayInAbilitiesEvent(
                            player,
                            (boolean) getValue(msg, "a"),
                            (boolean) getValue(msg, "b"),
                            (boolean) getValue(msg, "c"),
                            (boolean) getValue(msg, "d"),
                            (float) getValue(msg, "e"),
                            (float) getValue(msg, "f")
                    ));
                }

                super.channelRead(ctx, msg);
            }

        });
    }

    private Object getValue(Object instance, String name) {
        Object result = null;
        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            result = field.get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void call(Event event) {
        Bukkit.getPluginManager().callEvent(event);
    }

}
