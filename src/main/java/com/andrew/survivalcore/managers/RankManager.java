package com.andrew.survivalcore.managers;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.RankEnum;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RankManager {

    private Main main;
    private File file;
    private YamlConfiguration config;

    public RankManager(Main main) {
        this.main = main;
        if (!main.getDataFolder().exists()) {
            main.getDataFolder().mkdir();
        }

        file = new File(main.getDataFolder(), "ranks.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void setRank(UUID uuid, RankEnum rankEnum) {
        config.set(uuid.toString(), rankEnum.name());
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Bukkit.getOfflinePlayer(uuid).isOnline()) {
            Player player = Bukkit.getPlayer(uuid);
            main.getNameTagManager().removeTag(player);
            main.getNameTagManager().newTag(player);
        }

    }

    public RankEnum getRank(UUID uuid) {
        return RankEnum.valueOf(config.getString(uuid.toString()));
    }
}
