package com.andrew.survivalcore;

import com.andrew.survivalcore.commands.*;
import com.andrew.survivalcore.listeners.*;
import com.andrew.survivalcore.managers.NameTagManager;
import com.andrew.survivalcore.managers.RankManager;
import com.andrew.survivalcore.managers.WarpManager;
import com.andrew.survivalcore.utils.GUIUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private RankManager rankManager;
    private NameTagManager nameTagManager;
    private WarpManager warpManager;

    // OnPlayerInteract Method in LauncherMenuListener is broken. Need to find another to detect what launcher the player is holding.

    @Override
    public void onEnable() {

        // Register Listeners
        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ScoreBoardListener(this), this);
        Bukkit.getPluginManager().registerEvents(new MainMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new LauncherMenuListener(this), this);
        Bukkit.getPluginManager().registerEvents(new ServerListPingListener(this), this);
        Bukkit.getPluginManager().registerEvents(new InvSeeCommand(this), this);
        Bukkit.getPluginManager().registerEvents(new GUIUtil(this), this);

        // Register Managers
        rankManager = new RankManager(this);
        nameTagManager = new NameTagManager(this);
        warpManager = new WarpManager(this);

        // Register Commands
        new RankCommand(this);
        new MenuCommand(this);
        new CraftCommand(this);
        new EnderChestCommand(this);
        new InvSeeCommand(this);
        new WarpsCommand(this);

        // Register Warp commands
        new SetWarpCommand(this);
        new DeleteWarpCommand(this);
        new WarpCommand(this);

        // Register Gamemode commands
        new GamemodeCreative(this);
        new GamemodeSurvival(this);
        new GamemodeAdventure(this);
        new GamemodeSpectator(this);

    }

    public RankManager getRankManager() { return rankManager; }
    public NameTagManager getNameTagManager() { return nameTagManager; }
    public WarpManager getWarpManager() { return warpManager;}

}
