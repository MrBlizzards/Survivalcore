package com.andrew.survivalcore.enums;

import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum MaterialEnum {

    // FRAME
    FRAME(" ", " ", Material.GRAY_STAINED_GLASS_PANE),

    // MAIN MENU GUIS
    LAUNCHERMENU(ChatColor.GREEN.toString() + ChatColor.BOLD + "Launcher Menu", ChatColor.GRAY + "Opens the launcher menu", Material.DIAMOND_HOE),

    // LAUNCHER ENUMS
    DRAGONFIREBALLLAUNCHER(ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "Dragonfireball Launcher", ChatColor.GRAY + "This launches a fireball like the enderdragon!", Material.WOODEN_HOE),
    EGG(ChatColor.YELLOW.toString() + ChatColor.BOLD + "Egg Launcher", ChatColor.GRAY + "This launches an egg!",  Material.STONE_HOE),
    SNOWBALL(ChatColor.WHITE.toString() + ChatColor.BOLD + "Snowball Launcher", ChatColor.GRAY + "This launches a snowball!", Material.IRON_HOE),
    FIREBALL(ChatColor.GOLD.toString() + ChatColor.BOLD + "Fireball Launcher", ChatColor.GRAY + "This launches a fireball!", Material.GOLDEN_HOE),
    TRIDENT(ChatColor.AQUA.toString() + ChatColor.BOLD + "Trident Launcher", ChatColor.GRAY + "This launches a trident!", Material.DIAMOND_HOE),
    TELEPORTBOW(ChatColor.RED.toString() + ChatColor.BOLD + "Teleport Bow", ChatColor.GRAY + "This teleports you to where ever the arrow lands!", Material.BOW);

    private String name;
    private String lore;
    private Material material;

    MaterialEnum(String name, String lore, Material material) {
        this.name = name;
        this.lore = lore;
        this.material = material;

    }

    public static List<MaterialEnum> getAllMaterialEnum() { return Arrays.asList(MaterialEnum.values()); }

    public String getName() { return name; }
    public String getLore() { return lore; }
    public Material getMaterial() { return material; }

}
