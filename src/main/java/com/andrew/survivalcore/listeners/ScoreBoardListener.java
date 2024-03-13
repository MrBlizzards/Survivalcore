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

    public ScoreBoardListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        createBoard(e.getPlayer());
    }

    public void createBoard(Player player) {
        // CREATE THE SCOREBOARD
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        // CREATE THE SIDEBAR
        createSidebar(board, player);

        // CREATE THE PLAYER LIST SCOREBOARD
        createPlayerList(board, player);

        // SETS THE SCOREBOARD
        player.setScoreboard(board);
    }

    public void createSidebar(Scoreboard board, Player player) {
        Objective obj = board.registerNewObjective("Sidebar-Rank", "dummy", ChatColorUtil.colorize("&b&lFrosted&f&lNetwork"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        // RIGHT UNDER THE TITLE
        Score line2 = obj.getScore(ChatColorUtil.colorize(("&7&l-----------------")));
        line2.setScore(7);

        // SPACE #2
        Score space2 = obj.getScore("   ");
        space2.setScore(6);

        // PLAYER NAME
        Score playerName = obj.getScore(ChatColorUtil.colorize("&7&lName: &7" + player.getName()));
        playerName.setScore(5);

        // RANK TEAM SYSTEM
        Team team1 = board.registerNewTeam("team1");
        String teamKey = ChatColor.GOLD.toString();

        team1.addEntry(teamKey);
        team1.setPrefix(ChatColorUtil.colorize("&7&lRank: "));
        team1.setSuffix(main.getRankManager().getRank(player.getUniqueId()).getDisplay());

        obj.getScore(teamKey).setScore(4);

        // SPACE #1
        Score space1 = obj.getScore(" ");
        space1.setScore(3);

        // RIGHT ABOVE THE WEBSITE
        Score line1 = obj.getScore(ChatColorUtil.colorize(("&7&l----------------- ")));
        line1.setScore(2);

        // WEBSITE AT THE BOTTOM
        Score website = obj.getScore(ChatColorUtil.colorize(("&7www.frostednetwork.com")));
        website.setScore(1);
    }

    private void createPlayerList(Scoreboard board, Player player) {
        Objective playerListObj = board.registerNewObjective("playerlist", "dummy");
        playerListObj.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        Team team2 = board.registerNewTeam("team2");

        team2.setPrefix(main.getRankManager().getRank(player.getUniqueId()).getDisplay());

        player.setPlayerListName(team2.getPrefix() + " " + ChatColor.GRAY + player.getName());

    }
}


