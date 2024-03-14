package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import com.andrew.survivalcore.utils.ChatColorUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class EnderChestCommand extends CommandManager {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();

    private Main main;

    public EnderChestCommand(Main main) {
        super(
                "enderchest",
                new String[]{"ec"},
                "Opens a virtual furnace",
                " ",
                " ");
        this.main = main;

    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000);
            if (args.length == 0) {
                player.openInventory(player.getEnderChest());
                return;
            }

            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColorUtil.colorize(StringEnum.PLAYER_NOT_FOUND.getValue()));
                    return;
                }
                player.openInventory(target.getInventory());
                player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() + " &7Opening " + target.getName() + "'s enderchest..."));
            }

            if (args.length != 0 && args.length != 1) {
                player.sendMessage(ChatColorUtil.colorize("&cUsage: /enderchest [player]"));
            }
        } else {
            long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to use this again.");
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

        }
        return new ArrayList<>();
    }
}
