package com.andrew.survivalcore;

import com.andrew.survivalcore.commands.RankCommand;
import com.andrew.survivalcore.listeners.RankListener;
import com.andrew.survivalcore.listeners.ScoreBoardListener;
import com.andrew.survivalcore.managers.NameTagManager;
import com.andrew.survivalcore.managers.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    /*
    Rank System:
        - /rank command
        - Save in .yml file
        - Custom Permission
        - Nametags & Chat display
     */

    private RankManager rankManager;
    private NameTagManager nameTagManager;

    @Override
    public void onEnable() {

        // Register Listener
        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoardListener(this), this);


        // Register Commands
        new RankCommand(this);

        rankManager = new RankManager(this);
        nameTagManager = new NameTagManager(this);

    }

    public RankManager getRankManager() { return rankManager; }
    public NameTagManager getNameTagManager() { return nameTagManager; }
    
}
