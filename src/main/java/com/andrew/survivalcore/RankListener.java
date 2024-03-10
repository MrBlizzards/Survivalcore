package com.andrew.survivalcore;

import com.andrew.survivalcore.util.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.UUID;

public class RankListener implements Listener {

    private Main main;

    public RankListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();


        // SETS THE PLAYER RANK TO MEMBER IF THEY HAVE NEVER JOINED BEFORE. IF IT DOES IT'LL SKIP THEM,
        if (!player.hasPlayedBefore()) {
            main.getRankManager().setRank(player.getUniqueId(), RankEnum.MEMBER);
        }

        main.getNameTagManager().setNameTags(player);
        main.getNameTagManager().newTag(player);

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("testboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColorUtil.colorize("&3&lFrosted&f&lNetwork"));

        Score space1 = obj.getScore("  ");
        space1.setScore(5);

        Score name = obj.getScore(ChatColorUtil.colorize("&7&lName: &f" + player.getName()));
        name.setScore(4);

        Score rank = obj.getScore(ChatColorUtil.colorize("&7&lRank: " + main.getRankManager().getRank(player.getUniqueId()).getDisplay()));
        rank.setScore(3);

        Score space = obj.getScore(" ");
        space.setScore(2);

        Score website = obj.getScore(ChatColorUtil.colorize("&ewww.frostednetwork.net"));
        website.setScore(1);

        player.setScoreboard(board);


    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        main.getNameTagManager().removeTag(e.getPlayer());

    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        e.setCancelled(true);

        Player player = e.getPlayer();

        Bukkit.broadcastMessage(main.getRankManager().getRank(player.getUniqueId()).getDisplay() + " " + ChatColor.GRAY + player.getName() + ": " + ChatColor.GRAY + e.getMessage());

    }
}
