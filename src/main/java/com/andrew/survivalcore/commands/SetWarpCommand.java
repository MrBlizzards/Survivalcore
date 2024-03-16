package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class SetWarpCommand extends CommandManager {

    private Main main;

    public SetWarpCommand(Main main) {
        super(
                "setwarp",
                new String[]{"sw"},
                "",
                "",
                "");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        YamlConfiguration warps = main.getWarpManager().getWarps();

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() +" Usage: /setwarp <name>"));
            return;
        }

        if (warps.contains(args[0])) {
            player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() +" &cWarp already exists"));
            return;
        }

        Location loc = player.getLocation();

        main.getWarpManager().setWarp(args[0], loc);
        main.getWarpManager().saveWarps();

        player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() +" &aWarp " + args[0] + " has been set"));

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
