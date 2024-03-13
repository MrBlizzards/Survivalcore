package com.andrew.survivalcore.GUI;

import com.andrew.survivalcore.enums.MaterialEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import com.andrew.survivalcore.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class MainMenuGUI {

    private ItemStack createItemStack(Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(name).addLoreArray(lore.toArray(new String[0])).setAmount(amount).build();
        return itemStack;
    }

    public Inventory getMainMenuInventory() {

        Inventory mainMenu = Bukkit.createInventory(null, 45, ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "Main Menu");

        // FRAME
        ItemStack frame = createItemStack(MaterialEnum.FRAME.getMaterial(), MaterialEnum.FRAME.getName(), Arrays.asList(MaterialEnum.FRAME.getLore()), 1);
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
            mainMenu.setItem(i, frame);
        }

        // LAUNCHER MENU
        ItemStack launcherMenuGUI = createItemStack(MaterialEnum.LAUNCHERMENU.getMaterial(), MaterialEnum.LAUNCHERMENU.getName(), Arrays.asList(MaterialEnum.LAUNCHERMENU.getLore()), 1);
        mainMenu.setItem(20, launcherMenuGUI);

        return mainMenu;
    }
}
