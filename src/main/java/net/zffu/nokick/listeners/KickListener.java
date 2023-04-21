package net.zffu.nokick.listeners;

import net.zffu.nokick.NoKickPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class KickListener implements Listener {

    @EventHandler
    public void onKick(PlayerKickEvent event) {

        if(NoKickPlugin.getInstance().getConfig().getBoolean("actions.title.enabled")) {
            Player player = event.getPlayer();

            String title = translate(NoKickPlugin.getInstance().getConfig().getString("actions.title.title"));
            title = title.replaceAll("%reason%", event.getReason());

            String subtitle = translate(NoKickPlugin.getInstance().getConfig().getString("actions.title.subtitle"));
            subtitle = subtitle.replaceAll("%reason%", event.getReason());

            player.sendTitle(title, subtitle);
        }

        event.setCancelled(true);

    }

    public String translate(final String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
