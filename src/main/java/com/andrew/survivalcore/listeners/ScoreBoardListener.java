package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.RankEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.HashMap;

public class ScoreBoardListener implements Listener {

    private Main main;

    public ScoreBoardListener(Main main) {
        this.main = main;

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("testboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("Test Board!");

        Score website = obj.getScore("www.test-website");
        website.setScore(1);

        Score space = obj.getScore(" ");
        space.setScore(2);

        Score name = obj.getScore(player.getName());
        name.setScore(3);

        Score rank = obj.getScore(main.getRankManager().getRank(player.getUniqueId()).getDisplay());
        rank.setScore(4);

        player.setScoreboard(board);

    }
}

