package com.andrew.survivalcore.GUI;

import com.andrew.survivalcore.enums.MaterialEnum;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import com.andrew.survivalcore.utils.GUI;
import com.andrew.survivalcore.utils.GUIBuilder;
import com.andrew.survivalcore.utils.ItemBuilder;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Warps implements GUI {
    private static Warps instance;
    HashMap<Integer, ItemStack> items = Maps.newHashMap();
    Player player;
    public static Warps getInstance() {
        return instance;
    }

    @Override
    public void registerActions(Player player, ItemStack itemStack, ClickType clickType) {
        if (itemStack.getType() == Material.GRASS_BLOCK) {
            Bukkit.dispatchCommand(player,"warp spawn");
            player.closeInventory();
            return;
        }
        if (itemStack.getItemMeta().getDisplayName().contains("Overworld")) {
            Bukkit.dispatchCommand(player,"warp overworld");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.STONE_HOE) {
            Bukkit.dispatchCommand(player,"warp farms");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.ENCHANTING_TABLE) {
            Bukkit.dispatchCommand(player,"warp enchant");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.CHEST) {
            Bukkit.dispatchCommand(player,"warp shops");
            player.closeInventory();
            return;
        }
        if (itemStack.getItemMeta().getDisplayName().contains("Nether")) {
            Bukkit.dispatchCommand(player,"warp nether");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.TRIPWIRE_HOOK) {
            Bukkit.dispatchCommand(player,"warp crates");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.SPAWNER) {
            Bukkit.dispatchCommand(player,"warp spawners");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.CHEST) {
            Bukkit.dispatchCommand(player,"warp shops");
            player.closeInventory();
            return;
        }
        if (itemStack.getItemMeta().getDisplayName().contains("Jobs")) {
            Bukkit.dispatchCommand(player,"warp jobs");
            player.closeInventory();
            return;
        }
        if (itemStack.getItemMeta().getDisplayName().contains("End")) {
            Bukkit.dispatchCommand(player,"warp end");
            player.closeInventory();
            return;
        }
        if (itemStack.getItemMeta().getDisplayName().contains("Wild")) {
            Bukkit.dispatchCommand(player,"warp wild");
            player.closeInventory();
            return;
        }
        if (itemStack.getType() == Material.NETHER_STAR) {
            Bukkit.dispatchCommand(player,"warp event");
            player.closeInventory();
            return;
        }
    }

    @Override
    public HashMap<Integer, ItemStack> registerItems() {
        ItemStack border = (new GUIBuilder(Material.GRAY_STAINED_GLASS_PANE)).setName(" ").toItemStack();
        items.put(0, border);
        items.put(1, border);
        items.put(2, border);
        items.put(3, border);
        items.put(4, border);
        items.put(5, border);
        items.put(6, border);
        items.put(7, border);
        items.put(8, border);
        items.put(9, border);
        items.put(10, border);
        items.put(11, border);
        items.put(12, getWarpIcon(Material.GRASS_BLOCK, ChatColorUtil.colorize("&2&lOverworld Spawn"),"1 Minute", null));
        items.put(13, border);
        items.put(14, border);
        items.put(15, border);
        //items.put(16, getWarpIconRandom(Skull.getCustomSkull("http://textures.minecraft.net/texture/" + "c69196b330c6b8962f23ad5627fb6ecce472eaf5c9d44f791f6709c7d0f4dece"),ChatUtil.color("&2&lOverworld"),"1 Minute", ChatUtil.color("&7Overworld Size: &26,000 x 6,000")));
        items.put(17, border);
        items.put(18, border);
        items.put(19, border);
        items.put(20, getWarpIcon(Material.STONE_HOE,ChatColorUtil.colorize("&a&lPlayer Farms"),"1 Minute",null));
        items.put(21, getWarpIcon(Material.ENCHANTING_TABLE,ChatColorUtil.colorize("&5&lWarp Enchant"),"1 Minute",null));
        items.put(22, getWarpIcon(Material.CHEST,ChatColorUtil.colorize("&3&lPlayer Shops"),"1 Minute", null));
        items.put(24, border);
        //items.put(25, getWarpIcon(Skull.getCustomSkull("http://textures.minecraft.net/texture/" + "d83571ff589f1a59bb02b80800fc736116e27c3dcf9efebede8cf1fdde"),ChatUtil.color("&c&lNether"),"1 Minute", ChatUtil.color("&7Nether Size: &c3,000 x 3,000")));
        items.put(26, border);
        items.put(27, border);
        items.put(28, border);
        items.put(29, getWarpIcon(Material.TRIPWIRE_HOOK,ChatColorUtil.colorize("&6&lWarp Crates"),"1 Minute",null));
        items.put(30, getWarpIcon(Material.SPAWNER,ChatColorUtil.colorize("&d&lWarp Spawners"),"1 Minute",null));
        //items.put(31, getWarpIcon(Skull.getCustomSkull("http://textures.minecraft.net/texture/" + "19b9717e290df585dd4c8938eb9c085b1892e4c306288c134fcc9ce9ee9742"),ChatUtil.color("&6&lJobs"),"1 Minute", null));
        items.put(32, border);
        items.put(33, border);
        //items.put(34, getWarpIcon(Skull.getCustomSkull("http://textures.minecraft.net/texture/" + "c6cac59b2aae489aa0687b5d802b2555eb14a40bd62b21eb116fa569cdb756"),ChatUtil.color("&e&lEnd"),"1 Minute", ChatUtil.color("&7The End Size: &c3,000 x 3,000")));
        items.put(35, border);
        items.put(36, border);
        items.put(37, border);
        items.put(38, border);
        //items.put(39, getWarpIcon(Skull.getCustomSkull("http://textures.minecraft.net/texture/" + "b1dd4fe4a429abd665dfdb3e21321d6efa6a6b5e7b956db9c5d59c9efab25"),ChatUtil.color("&6&lWild"),"1 Minute", null));
        items.put(40, border);
        items.put(41, border);
        items.put(42, border);

        items.put(43, getEventIcon(Material.NETHER_STAR,ChatColorUtil.colorize("&6Event"),"N/A", "Build Battle (2v2)"));
        items.put(44, border);
        items.put(45, border);
        items.put(46, border);
        items.put(47, border);
        items.put(48, border);
        items.put(49, border);
        items.put(50, border);
        items.put(51, border);
        items.put(52, border);
        items.put(53, border);
        return items;
    }

    @Override
    public Inventory getInventory() {
        instance = this;
        Inventory gui = Bukkit.createInventory(getInstance(), 6 * 9, StringEnum.SURVIVALCORE_PREFIX.getValue() + ChatColorUtil.colorize("&7Warps"));
        for (Integer i : registerItems().keySet())
            gui.setItem(i, this.items.get(i));
        return gui;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private ItemStack getWarpIcon(Material mat,String name, String cooldown, String worldSize) {
        final boolean b = name.contains("Player Farms") || name.contains("Jobs") || name.contains("Warp Spawners");
        if (worldSize == null) {
            if (b) {
                return new GUIBuilder(mat).setName(name).setLore(
                        "",
                        ChatColorUtil.colorize("&7Teleports to the"),
                        ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                        "",
                        ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                        "",
                        ChatColorUtil.colorize("&f&o>> Click To Teleport <<"),
                        "",
                        ChatColorUtil.colorize("&e&l*COMING SOON*")
                ).hideEnchants().hideItemAttributes().toItemStack();
            } else {
                return new GUIBuilder(mat).setName(name).setLore(
                        "",
                        ChatColorUtil.colorize("&7Teleports to the"),
                        ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                        "",
                        ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                        "",
                        ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
                ).hideEnchants().hideItemAttributes().toItemStack();
            }
        } else {
            if (b) {
                return new GUIBuilder(mat).setName(name).setLore(
                        "",
                        ChatColorUtil.colorize("&7Teleports to the"),
                        ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                        "",
                        worldSize,
                        ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                        "",
                        ChatColorUtil.colorize("&f&o>> Click To Teleport <<"),
                        "",
                        ChatColorUtil.colorize("&e&l*COMING SOON*")
                ).hideEnchants().hideItemAttributes().toItemStack();

            } else {
                return new GUIBuilder(mat).setName(name).setLore(
                        "",
                        ChatColorUtil.colorize("&7Teleports to the"),
                        ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                        "",
                        worldSize,
                        ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                        "",
                        ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
                ).hideEnchants().hideItemAttributes().toItemStack();
            }
        }
    }

    private ItemStack getWarpIcon(ItemStack mat,String name, String cooldown, String worldsize) {
        if (worldsize == null) {
            return new GUIBuilder(mat).setName(name).setLore(
                    "",
                    ChatColorUtil.colorize("&7Teleports to the"),
                    ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                    "",
                    ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                    "",
                    ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
            ).hideEnchants().hideItemAttributes().toItemStack();
        } else {
            return new GUIBuilder(mat).setName(name).setLore(
                    "",
                    ChatColorUtil.colorize("&7Teleports to the"),
                    ChatColorUtil.colorize("&7" + ChatColorUtil.removeColors(name)),
                    "",
                    worldsize,
                    ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                    "",
                    ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
            ).hideEnchants().hideItemAttributes().toItemStack();
        }
    }

    private ItemStack getEventIcon(Material mat, String name, String time, String nextEvent) {
        return new GUIBuilder(mat).setName(name).setLore(
                "",
                ChatColorUtil.colorize("&7Teleports to the"),
                ChatColorUtil.colorize("&7Event world spawn"),
                "",
                ChatColorUtil.colorize("&7Next Event: &6" + nextEvent),
                ChatColorUtil.colorize("&7Time: &6" + time),
                "",
                ChatColorUtil.colorize("&f&o>> Click To Teleport <<"),
                "",
                ChatColorUtil.colorize("&e&l*COMING SOON*")
        ).hideEnchants().hideItemAttributes().toItemStack();
    }

    private ItemStack getWarpIconRandom(ItemStack mat,String name, String cooldown, String worldSize) {
        if (worldSize == null) {
            return new GUIBuilder(mat).setName(name).setLore(
                    "",
                    ChatColorUtil.colorize("&7Teleports to a random"),
                    ChatColorUtil.colorize("&7location in the " + ChatColorUtil.removeColors(name)),
                    "",
                    ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                    "",
                    ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
            ).hideEnchants().hideItemAttributes().toItemStack();
        } else {
            return new GUIBuilder(mat).setName(name).setLore(
                    "",
                    ChatColorUtil.colorize("&7Teleports to a random"),
                    ChatColorUtil.colorize("&7location in the " + ChatColorUtil.removeColors(name)),
                    "",
                    worldSize,
                    ChatColorUtil.colorize("&7Cooldown: &a" + cooldown),
                    "",
                    ChatColorUtil.colorize("&f&o>> Click To Teleport <<")
            ).hideEnchants().hideItemAttributes().toItemStack();
        }
    }
}
