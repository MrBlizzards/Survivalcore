package com.andrew.survivalcore;

import com.andrew.survivalcore.commands.MenuCommand;
import com.andrew.survivalcore.commands.RankCommand;
import com.andrew.survivalcore.listeners.MainMenuListener;
import com.andrew.survivalcore.listeners.RankListener;
import com.andrew.survivalcore.listeners.ScoreBoardListener;
import com.andrew.survivalcore.managers.NameTagManager;
import com.andrew.survivalcore.managers.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private RankManager rankManager;
    private NameTagManager nameTagManager;

    @Override
    public void onEnable() {

        // Register Listener
        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoardListener(this), this);
        Bukkit.getPluginManager().registerEvents(new MainMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new LauncherMenuListener(this), this);

        // Register Commands
        new RankCommand(this);
        new MenuCommand(this);

        rankManager = new RankManager(this);
        nameTagManager = new NameTagManager(this);

    }

    public RankManager getRankManager() { return rankManager; }
    public NameTagManager getNameTagManager() { return nameTagManager; }

}
