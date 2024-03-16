package com.andrew.survivalcore.utils;

import com.andrew.survivalcore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIUtil implements Listener {

    private Main main;

    public GUIUtil(Main main) { this.main = main; }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof GUI) {
            if (e.getClick() == null || e.getCurrentItem() == null)
                return;
            e.setCancelled(true);
            GUI gui = (GUI) e.getInventory().getHolder();
            gui.registerActions((Player) e.getWhoClicked(), e.getCurrentItem(), e.getClick());
        }
    }
}