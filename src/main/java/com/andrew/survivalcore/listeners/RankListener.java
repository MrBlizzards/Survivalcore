package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.RankEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class RankListener implements Listener {

    private Main main;

    public RankListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        // REPLACES GENERIC JOIN MESSAGE
        e.setJoinMessage(ChatColorUtil.colorize(main.getRankManager().getRank(player.getUniqueId()).getDisplay() + ChatColor.GRAY + " " + player.getName() + " &7has joined the server."));

        // SETS THE PLAYER RANK TO MEMBER IF THEY HAVE NEVER JOINED BEFORE. IF IT DOES IT'LL SKIP THEM,
        if (!player.hasPlayedBefore()) {
            main.getRankManager().setRank(player.getUniqueId(), RankEnum.MEMBER);
        }

        main.getNameTagManager().setNameTags(player);
        main.getNameTagManager().newTag(player);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        // REPLACES GENERIC LEAVE MESSAGE
        e.setQuitMessage(ChatColorUtil.colorize(main.getRankManager().getRank(player.getUniqueId()).getDisplay() + ChatColor.GRAY + " " + player.getName() + " &7has left the server."));

        main.getNameTagManager().removeTag(e.getPlayer());

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        e.setCancelled(true);

        Player player = e.getPlayer();

        Bukkit.broadcastMessage(main.getRankManager().getRank(player.getUniqueId()).getDisplay() + " " + ChatColor.GRAY + player.getName() + ": " + ChatColor.GRAY + e.getMessage());

    }
}
