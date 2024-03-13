package com.andrew.survivalcore.managers;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.RankEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NameTagManager {

    private Main main;

    public NameTagManager(Main main) {
        this.main = main;
    }

    public void setNameTags(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        for (RankEnum ranks : RankEnum.values()) {
            Team team = player.getScoreboard().registerNewTeam(ranks.name());
            team.setPrefix(ranks.getDisplay() + " ");
        }

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (player.getUniqueId() != target.getUniqueId()) {
                player.getScoreboard().getTeam(main.getRankManager().getRank(target.getUniqueId()).name()).addEntry(target.getName());
            }
        }
    }

    public void newTag(Player player) {
        RankEnum rank = main.getRankManager().getRank(player.getUniqueId());
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.getScoreboard().getTeam(rank.name()) == null) continue;
            target.getScoreboard().getTeam(rank.name()).addEntry(player.getName());
        }
    }

    public void removeTag(Player player) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.getScoreboard().getEntryTeam(player.getName()) == null) continue;
            target.getScoreboard().getEntryTeam(player.getName()).removeEntry(player.getName());
        }
    }

    public void updateScoreBoard(Player player) {
        Scoreboard board = player.getScoreboard();
        Team team1 = board.getTeam("team1");

        team1.setSuffix(main.getRankManager().getRank(player.getUniqueId()).getDisplay());
    }
}



