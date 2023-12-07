package com.rosed.oldpvp;

import com.rosed.oldpvp.listener.FishingRodListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Old_PvP_Mechanics extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new FishingRodListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
