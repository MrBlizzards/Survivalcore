package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.GUI.LauncherMenuGUI;
import com.andrew.survivalcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MainMenuListener implements Listener {

    private Main main;

    public MainMenuListener(Main main) {
        this.main = main;
    }

    LauncherMenuGUI launcherMenuGUI = new LauncherMenuGUI();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player target = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "Main Menu") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            if (e.getSlot() == 20) {
                target.openInventory(launcherMenuGUI.getLauncherMenuInventory());
            }
        }
    }
}
