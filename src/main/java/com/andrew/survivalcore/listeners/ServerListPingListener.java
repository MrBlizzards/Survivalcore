package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class ServerListPingListener implements Listener {

    private Main main;

    public ServerListPingListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) {

        // SETS THE MAX PLAYER
        e.setMaxPlayers(200);

        // SETS THE MOTD
        e.setMotd(ChatColor.AQUA.toString() + ChatColor.BOLD + "Frosted" + ChatColor.WHITE.toString() + ChatColor.BOLD + "Network\n" +
                ChatColor.WHITE + "Official FrostedNetwork development server.");

        // SETS THE SERVER ICON
        try {
            e.setServerIcon(Bukkit.loadServerIcon(new File("server-icon.png")));
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    }
}
