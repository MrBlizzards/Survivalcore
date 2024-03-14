package com.andrew.survivalcore.enums;

import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public enum MaterialEnum {

    // FRAME
    FRAME(" ", " ", Material.BLACK_STAINED_GLASS_PANE),

    // MAIN MENU GUIS
    LAUNCHERMENU(ChatColorUtil.colorize("&b&lLauncher Menu"), ChatColorUtil.colorize("&7Opens the launcher menu"), Material.DIAMOND_HOE),

    // LAUNCHER ENUMS
    DRAGONFIREBALLLAUNCHER(ChatColorUtil.colorize("&5&lDragonfireball Launcher"), ChatColorUtil.colorize("&7This launches a fireball like the enderdragon!"), Material.WOODEN_HOE),
    EGG(ChatColorUtil.colorize("&e&lEgg Launcher"), ChatColorUtil.colorize("&7This launches an egg!"), Material.STONE_HOE),
    SNOWBALL(ChatColorUtil.colorize("&f&lSnowball Launcher"), ChatColorUtil.colorize("&7This launches a snowball!"), Material.IRON_HOE),
    FIREBALL(ChatColorUtil.colorize("&6&lFireball Launcher"), ChatColorUtil.colorize("&7This launches a fireball!"), Material.GOLDEN_HOE),
    TRIDENT(ChatColorUtil.colorize("&b&lTrident Launcher"), ChatColorUtil.colorize("&7This launches a trident!"), Material.DIAMOND_HOE),
    TELEPORTBOW(ChatColorUtil.colorize("&c&lTeleport Bow"), ChatColorUtil.colorize("&7This teleports you to where ever the arrow lands!"), Material.BOW);

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
