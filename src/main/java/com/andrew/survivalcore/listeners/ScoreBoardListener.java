package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class ScoreBoardListener implements Listener {

    private Main main;

    public ScoreBoardListener(Main main) { this.main = main; }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        createBoard(e.getPlayer());
    }

    public void createBoard(Player player) {

        // CREATE THE SCOREBOARD
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("SurvivalCore-Rank", "dummy", ChatColorUtil.colorize("&b&lFrosted&f&lNetwork"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        // RIGHT UNDER THE TITLE
        Score score = obj.getScore(ChatColorUtil.colorize(("&7&l-----------------")));
        score.setScore(6);

        // SPACE #2
        Score space2 = obj.getScore("   ");
        space2.setScore(5);

        // PLAYER NAME
        Score playerName = obj.getScore(ChatColorUtil.colorize("&7&lName: &7" + player.getName()));
        playerName.setScore(4);

        // RANK TEAM SYSTEM
        Team team1 = board.registerNewTeam("team1");
        String teamKey = ChatColor.GOLD.toString();

        team1.addEntry(teamKey);
        team1.setPrefix(ChatColorUtil.colorize("&7&lRank: "));
        team1.setSuffix(main.getRankManager().getRank(player.getUniqueId()).getDisplay());

        obj.getScore(teamKey).setScore(3);

        // SPACE #1
        Score space1 = obj.getScore(" ");
        space1.setScore(2);

        // WEBSTIE AT THE BOTTOM
        Score website = obj.getScore(ChatColorUtil.colorize(("&7www.frostednetwork.com")));
        website.setScore(1);

        // SETS THE SCOREBOARD
        player.setScoreboard(board);

    }

}


