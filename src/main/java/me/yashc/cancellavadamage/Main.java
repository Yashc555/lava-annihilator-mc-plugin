package me.yashc.cancellavadamage;

import me.yashc.cancellavadamage.me.yashc.cancellavadamage.commands.LavaOff;
import org.bukkit.plugin.java.JavaPlugin;
import me.yashc.cancellavadamage.MyListen;

public final class Main extends JavaPlugin {

    private static Main plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("lavadamage").setExecutor(new LavaOff(this));
        getServer().getPluginManager().registerEvents(new MyListen(this), this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}
