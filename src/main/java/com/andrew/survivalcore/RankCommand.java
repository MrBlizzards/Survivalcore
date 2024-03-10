package com.andrew.survivalcore;

import com.andrew.survivalcore.manager.CommandManager;
import com.andrew.survivalcore.util.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class RankCommand extends CommandManager {


    // private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    private Main main;

    public RankCommand(Main main) {
        super(
                "rank",
                new String[]{"cake", "banana"},
                "A really cool command!",
                "",
                "");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        // Rank <player> <rank <type>

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only a player may execute this command.");
            return;
        }

        // Checks to see if the player is op or not.
        if (!player.isOp()) {
            sender.sendMessage(ChatColorUtil.colorize("&cYou must be OP to use this command!"));
            return;
        }

        // Checks the argument length to see if it is 2.
        if (args.length != 2) {
            player.sendMessage(ChatColorUtil.colorize("&cInvaild usage! Please use /rank <player> <rank>."));
            return;
        }

        // NEED TO FIND A BETTER METHOD OF RETURNING A VALID PLAYER.
        // MAYBE JUST DOING ONLINE PLAYERS AND NOT ALL PLAYERS BECAUSE getOfflinePlayers RETURNS ALL PLAYERS EVEN IF THEY ARE NOT VALID.

        // Checks to see if the first argument, which would be the player, is null or not.
        if (Bukkit.getOfflinePlayer(args[0]) != null) {
            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

            for (RankEnum rank : RankEnum.values()) {
                if (rank.name().equalsIgnoreCase(args[1])) {

                    main.getRankManager().setRank(target.getUniqueId(), rank);
                    if (player == target) {
                        player.sendMessage(ChatColorUtil.colorize("&aYou have changed your rank to " + rank.getDisplay()));
                        return;
                    }
                    if (target.isOnline()) {
                        target.getPlayer().sendMessage(ChatColorUtil.colorize("&a" + player.getName() + " &ahas changed your rank to " + rank.getDisplay()));
                        player.sendMessage(ChatColorUtil.colorize("&aYou changed " + target.getName() + "&a's rank to " + rank.getDisplay() + "&a."));
                        return;
                    }
                    player.sendMessage(ChatColorUtil.colorize("&aYou changed " + target.getName() + "&a's rank to " + rank.getDisplay() + "&a."));
                }
            }
        } else {
            player.sendMessage(ChatColorUtil.colorize("&cThis user has never joined the server before!"));
        }
    }




    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {

        if (args.length == 1) {
            List<String> names = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                names.add(player.getName());
            }
            return StringUtil.copyPartialMatches(args[0], names, new ArrayList<>());
        } else if (args.length == 2) {
            List<String> ranks = new ArrayList<>();
            for (RankEnum rank : RankEnum.values()) {
                ranks.add(rank.getName());
            }
            return StringUtil.copyPartialMatches(args[1], ranks, new ArrayList<>());
        }
        return new ArrayList<>();
    }

}
