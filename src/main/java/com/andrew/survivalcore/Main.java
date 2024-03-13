package com.andrew.survivalcore;

import com.andrew.survivalcore.commands.*;
import com.andrew.survivalcore.listeners.*;
import com.andrew.survivalcore.managers.NameTagManager;
import com.andrew.survivalcore.managers.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private RankManager rankManager;
    private NameTagManager nameTagManager;

    @Override
    public void onEnable() {

        // Register Listeners
        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoardListener(this), this);
        Bukkit.getPluginManager().registerEvents(new MainMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new LauncherMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ServerListPingListener(this), this);

        // Register Managers
        rankManager = new RankManager(this);
        nameTagManager = new NameTagManager(this);

        // Register Commands
        new RankCommand(this);
        new MenuCommand(this);
        new CraftCommand(this);
        new EnderChestCommand(this);

        // Register Gamemode commands
        new GamemodeCreative(this);
        new GamemodeSurvival(this);
        new GamemodeAdventure(this);
        new GamemodeSpectator(this);

    }

    public RankManager getRankManager() { return rankManager; }
    public NameTagManager getNameTagManager() { return nameTagManager; }

}
