package net.zffu.nokick;

import net.zffu.nokick.listeners.KickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoKickPlugin extends JavaPlugin {

    private static NoKickPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        saveDefaultConfig();

        if(getConfig().getBoolean("enabled") == true) {
            getServer().getPluginManager().registerEvents(new KickListener(), this);
        }
        else {
            Bukkit.getLogger().info("the enabled setting was set to false, the plugin will not do anything!");
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static NoKickPlugin getInstance() {return INSTANCE;}
}
