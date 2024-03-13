package com.andrew.survivalcore;

import com.andrew.survivalcore.enums.MaterialEnum;
import com.andrew.survivalcore.utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class LauncherMenuListener implements Listener {

    // ItemBuilder Util
    private ItemStack createItemStack(Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(name).addLoreArray(lore.toArray(new String[0])).setAmount(amount).build();
        return itemStack;
    }

    private Main main;

    public LauncherMenuListener(Main main) { this.main = main; }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        List<MaterialEnum> launchers = MaterialEnum.getAllMaterialEnum();
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        if (e.hasItem() && e.getItem() != null) {
            for (MaterialEnum launcher : launchers) {
                if (item.getItemMeta().getDisplayName().equals(launcher.getName())) {
                    switch (launcher.getMaterial()) {
                        case WOODEN_HOE:
                            player.launchProjectile(DragonFireball.class);
                            player.playSound(player.getLocation(), Sound.ENTITY_ARROW_SHOOT, 1.0F, 1.0F);
                            break;
                        case STONE_HOE:
                            player.launchProjectile(Egg.class);
                            player.playSound(player.getLocation(), Sound.ENTITY_EGG_THROW, 1.0F, 1.0F);
                            break;
                        case IRON_HOE:
                            player.launchProjectile(Snowball.class);
                            player.playSound(player.getLocation(), Sound.ENTITY_SNOWBALL_THROW, 1.0F, 1.0F);
                            break;
                        case GOLDEN_HOE:
                            player.launchProjectile(Fireball.class);
                            player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
                            break;
                        case DIAMOND_HOE:
                            player.launchProjectile(Trident.class);
                            player.playSound(player.getLocation(), Sound.ITEM_TRIDENT_THROW, 1.0F, 1.0F);
                            break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent e) {

        List<MaterialEnum> launchers = MaterialEnum.getAllMaterialEnum();

        if (e.getEntity().getShooter() instanceof Player) {
            Player player = (Player) e.getEntity().getShooter();
            ItemStack item = player.getInventory().getItemInMainHand();

            for (MaterialEnum launcher : launchers) {
                if (item.getItemMeta().getDisplayName().equals(launcher.getName())) {
                    switch (launcher.getMaterial()) {
                        case WOODEN_HOE:
                            break;
                        case STONE_HOE:
                            if (e.getHitBlock() != null) {
                                player.playSound(e.getHitBlock().getLocation(), Sound.BLOCK_ANCIENT_DEBRIS_BREAK, 1.0F, 1.0F);
                                e.getHitBlock().breakNaturally();
                            } else if (e.getHitEntity() != null) {
                                player.playSound(e.getHitEntity().getLocation(), Sound.ENTITY_PLAYER_HURT, 1.0F, 1.0F);
                            }
                            break;
                        case IRON_HOE:
                            if (e.getHitBlock() != null) {
                                Snowman snowman = (Snowman) Bukkit.getWorld("world").spawnEntity(e.getHitBlock().getLocation().add(0, 1, 0), EntityType.SNOWMAN);
                            }
                            break;
                        case DIAMOND_HOE:
                            if (e.getHitBlock() != null) {
                                Bukkit.getWorld("world").strikeLightning(e.getHitBlock().getLocation());
                            }
                            break;
                        case BOW:
                            if (e.getHitBlock() != null) {
                                player.teleport(e.getHitBlock().getLocation().add(0, 1, 0));
                                player.spawnParticle(Particle.PORTAL, player.getLocation(), 5);
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                            } else if (e.getHitEntity() != null) {
                                player.teleport(e.getHitEntity().getLocation().add(0, 1, 0));
                                player.spawnParticle(Particle.PORTAL, player.getLocation(), 5);
                                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                                break;
                            }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        List<MaterialEnum> launchers = MaterialEnum.getAllMaterialEnum();
        Player target = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();

        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.DARK_AQUA.toString() + ChatColor.BOLD + "Launcher Menu") && e.getCurrentItem() != null) {
            e.setCancelled(true);

                    for (MaterialEnum launcher : launchers) {
                        if (item.getItemMeta().getDisplayName().equals(launcher.getName())) {
                            ItemStack itemStack = createItemStack(launcher.getMaterial(), launcher.getName(), Arrays.asList(launcher.getLore()), 1);

                            switch (e.getRawSlot()) {
                                case 11:
                                    if (target.hasPermission("commands.launcher.dragonfireball")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                case 12:
                                    if (target.hasPermission("commands.launcher.egg")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                case 13:
                                    if (target.hasPermission("commands.launcher.snowball")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                case 14:
                                    if (target.hasPermission("commands.launcher.fireball")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                case 15:
                                    if (target.hasPermission("commands.launcher.trident")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                case 22:
                                    if (target.hasPermission("commands.launcher.arrow")) {
                                        target.getInventory().addItem(itemStack);
                                        target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    }
                                    break;
                                default:
                                    target.getInventory().addItem(itemStack);
                                    target.sendMessage(ChatColor.GRAY + "You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColor.GRAY + ".");
                                    return;
                            }

                        }
                    }
        }
    }
}