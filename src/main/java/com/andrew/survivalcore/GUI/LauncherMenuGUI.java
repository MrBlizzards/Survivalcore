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

public class LauncherMenuGUI {

    private ItemStack createItemStack(Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(name).addLoreArray(lore.toArray(new String[0])).setAmount(amount).build();
        return itemStack;
    }

    public Inventory getLauncherMenuInventory() {

        List<MaterialEnum> launchers = MaterialEnum.getAllMaterialEnum();

        Inventory LauncherMenu = Bukkit.createInventory(null, 45, MaterialEnum.LAUNCHERMENU.getName());

        // FRAME
        ItemStack frame = createItemStack(MaterialEnum.FRAME.getMaterial(), MaterialEnum.FRAME.getName(), Arrays.asList(MaterialEnum.FRAME.getLore()), 1);
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,37,38,39,40,41,42,43,44}) {
            LauncherMenu.setItem(i, frame);
        }

        // ARROW LAUNCHER
        ItemStack arrowLauncher = createItemStack(MaterialEnum.DRAGONFIREBALLLAUNCHER.getMaterial(), MaterialEnum.DRAGONFIREBALLLAUNCHER.getName(), Arrays.asList(MaterialEnum.DRAGONFIREBALLLAUNCHER.getLore()), 1);
        LauncherMenu.setItem(11, arrowLauncher);

        // EGG LAUNCHER
        ItemStack eggLauncher = createItemStack(MaterialEnum.EGG.getMaterial(), MaterialEnum.EGG.getName(), Arrays.asList(MaterialEnum.EGG.getLore()), 1);
        LauncherMenu.setItem(12, eggLauncher);

        // SNOWBALL LAUNCHER
        ItemStack snowballLauncher = createItemStack(MaterialEnum.SNOWBALL.getMaterial(), MaterialEnum.SNOWBALL.getName(), Arrays.asList(MaterialEnum.SNOWBALL.getLore()), 1);
        LauncherMenu.setItem(13, snowballLauncher);

        // FIREBALL LAUNCHER
        ItemStack fireballLauncher = createItemStack(MaterialEnum.FIREBALL.getMaterial(), MaterialEnum.FIREBALL.getName(), Arrays.asList(MaterialEnum.FIREBALL.getLore()), 1);
        LauncherMenu.setItem(14, fireballLauncher);

        // TRIDENT LAUNCHER
        ItemStack tridentLauncher = createItemStack(MaterialEnum.TRIDENT.getMaterial(), MaterialEnum.TRIDENT.getName(), Arrays.asList(MaterialEnum.TRIDENT.getLore()), 1);
        LauncherMenu.setItem(15, tridentLauncher);

        // TELEPORT BOW
        ItemStack teleportBow = createItemStack(MaterialEnum.TELEPORTBOW.getMaterial(),MaterialEnum.TELEPORTBOW.getName(), Arrays.asList(MaterialEnum.TELEPORTBOW.getLore()), 1);
        LauncherMenu.setItem(22, teleportBow);

        return LauncherMenu;
    }
}

