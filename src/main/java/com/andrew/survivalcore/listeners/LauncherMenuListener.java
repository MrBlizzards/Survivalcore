package com.andrew.survivalcore.listeners;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.MaterialEnum;
import com.andrew.survivalcore.utils.ChatColorUtil;
import com.andrew.survivalcore.utils.ItemBuilder;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LauncherMenuListener implements Listener {

    // Cooldown
    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();

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

        if (item == null) {
            return;
        }

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000);
            for (MaterialEnum launcher : launchers) {

                if (item.getType() == launcher.getMaterial() && item.getItemMeta().getDisplayName().equals(launcher.getName())) {
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
        } else {
            long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to use this again.");
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

        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(MaterialEnum.LAUNCHERMENU.getName()) && e.getCurrentItem() != null) {
            e.setCancelled(true);

            if (!cooldown.asMap().containsKey(target.getUniqueId())) {
                cooldown.put(target.getUniqueId(), System.currentTimeMillis() + 3000);
                for (MaterialEnum launcher : launchers) {
                    if (item.getItemMeta().getDisplayName().equals(launcher.getName())) {

                        ItemStack itemStack = createItemStack(launcher.getMaterial(), launcher.getName(), Arrays.asList(launcher.getLore()), 1);
                        String message = ChatColorUtil.colorize("&7You have selected the " + itemStack.getItemMeta().getDisplayName() + ChatColorUtil.colorize("&7."));

                        switch (e.getRawSlot()) {
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 22:
                                target.getInventory().addItem(itemStack);
                                    target.sendMessage(message);
                                break;
                            default:
                                return;
                        }

                    }
                }
            } else {
                long distance = cooldown.asMap().get(target.getUniqueId()) - System.currentTimeMillis();
                target.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to use this again.");
            }
        }

    }
}