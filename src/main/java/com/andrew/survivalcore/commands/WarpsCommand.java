package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.GUI.Warps;
import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class WarpsCommand extends CommandManager {

    private Main main;

    public WarpsCommand(Main main) {
        super(
                "warps",
                new String[]{" "},
                "",
                "",
                "");
        this.main = main;
    }

    Warps warps = new Warps();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        player.openInventory(warps.getInventory());


    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
