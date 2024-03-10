package com.andrew.survivalcore;

import com.andrew.survivalcore.manager.NameTagManager;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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


        // Register Commands
        new RankCommand(this);

        rankManager = new RankManager(this);
        nameTagManager = new NameTagManager(this);

    }

    public RankManager getRankManager() { return rankManager; }
    public NameTagManager getNameTagManager() { return nameTagManager; }
    
}
