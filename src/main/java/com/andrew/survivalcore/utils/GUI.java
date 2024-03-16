package com.andrew.survivalcore.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public interface GUI extends InventoryHolder {
    void registerActions(Player whoClicked, ItemStack clickedItem, ClickType clickType);

    HashMap<Integer, ItemStack> registerItems();
}