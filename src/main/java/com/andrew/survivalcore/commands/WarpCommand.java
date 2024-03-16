package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class WarpCommand extends CommandManager {

    private Main main;

    public WarpCommand(Main main) {
        super(
                "warp",
                new String[]{"w"},
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
            player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() + " &cUsage: /warp <name>"));
            return;
        }

        if (warps.contains(args[0].toLowerCase())) {
            player.teleport(main.getWarpManager().getWarp(args[0]));
            player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() +" &aTeleported to " + args[0]));
            return;
        }

        player.sendMessage(ChatColorUtil.colorize(StringEnum.SURVIVALCORE_PREFIX.getValue() +" &cWarp not found"));

        }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {

        if (args.length == 1) {
            List<String> warps = new ArrayList<>(main.getWarpManager().getWarps().getKeys(false));
            return StringUtil.copyPartialMatches(args[0], warps, new ArrayList<>());

        }
        return new ArrayList<>();
    }
}
