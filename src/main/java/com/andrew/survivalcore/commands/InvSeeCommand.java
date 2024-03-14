package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.MaterialEnum;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import com.andrew.survivalcore.utils.ChatColorUtil;
import com.andrew.survivalcore.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InvSeeCommand extends CommandManager implements Listener {

    private ItemStack createItemStack(Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(name).addLoreArray(lore.toArray(new String[0])).setAmount(amount).build();
        return itemStack;
    }

    private Main main;

    public InvSeeCommand(Main main) {
        super(
                "invsee",
                new String[]{"inv"},
                "Opens the target player's inventory",
                "",
                "");
        this.main = main;
    }
    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColorUtil.colorize("&cUsage: /invsee <player>"));
            return;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            player.sendMessage(StringEnum.PLAYER_NOT_FOUND.getValue());
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        player.openInventory(getInventory(target));
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().contains("'s Inventory")) {
            e.setCancelled(true);
        }
    }

    private Inventory getInventory(Player target) {
        Inventory inv = Bukkit.createInventory(null, 54, target.getName() + "'s Inventory");
        Inventory playerInventory = target.getInventory();
        ItemStack[] playerArmor = target.getInventory().getArmorContents();

        // Fill the empty slots with black stained glass panes
        ItemStack frame = createItemStack(MaterialEnum.FRAME.getMaterial(), MaterialEnum.FRAME.getName(), Arrays.asList(MaterialEnum.FRAME.getLore()), 1);
        for (int i : new int[]{36,37,38,39,40,41,42,43,44}) {
            inv.setItem(i, frame);
        }

        // Loop through the player's main inventory (excluding the armor slots)
        for (int i = 0; i < 36; i++) {
            ItemStack item = playerInventory.getItem(i);
            inv.setItem(i, item);
        }

        // Loop through the player's armor slots
        for (int i = 0; i < 4; i++) {
            ItemStack item = playerArmor[i];
            inv.setItem(i + 45, item);
        }

        // Adds the player's offhand item to the inventory
        inv.setItem(53, target.getInventory().getItemInOffHand());

        return inv;
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