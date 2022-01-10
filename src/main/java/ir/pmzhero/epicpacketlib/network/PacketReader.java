package ir.pmzhero.epicpacketlib.network;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import ir.pmzhero.epicpacketlib.events.PacketEvent;
import ir.pmzhero.epicpacketlib.network.packets.client.*;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class PacketReader {

    private final Player player;

    public PacketReader(Player player) {
        this.player = player;
    }

    public void inject() {

        ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline().addBefore("packet_handler", "epic", new ChannelDuplexHandler() {

            PacketEvent event;

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                if (msg instanceof PacketPlayInUseEntity) {

                    event = new PlayInUseEntity(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInChat) {

                    event = new PlayInChat(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInBlockDig) {

                    event = new PlayInBlockDig(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInTabComplete) {

                    event = new PlayInTabComplete(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInFlying) {

                    event = new PlayInFlying(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInBlockPlace) {

                    event = new PlayInBlockPlace(msg, player).getEvent();

                } else if (msg instanceof PacketPlayInAbilities) {

                    event = new PlayInAbilities(msg, player).getEvent();

                }

                if (event != null)
                    Bukkit.getPluginManager().callEvent(event);
                super.channelRead(ctx, msg);
            }

            @Override
            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise channelPromise) throws Exception {
                if (event != null && event.isCancelled()) {
                    System.out.println("cancelled " + event.isCancelled());
                    return;
                }
                super.write(ctx, msg, channelPromise);
            }
        });
    }

    public static Object getValue(Object instance, String name) {
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

}
