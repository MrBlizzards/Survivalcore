package com.andrew.survivalcore.commands;

import com.andrew.survivalcore.GUI.MainMenuGUI;
import com.andrew.survivalcore.Main;
import com.andrew.survivalcore.enums.StringEnum;
import com.andrew.survivalcore.managers.CommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class MenuCommand extends CommandManager {

    private Main main;

    public MenuCommand(Main main) {
        super(
                "menu",
                new String[]{" "},
                "Opens the main menu for the server",
                "survivalcore.menu.main",
                "Error! No permission node found for this command.");
        this.main = main;
    }

    MainMenuGUI mainMenuGUI = new MainMenuGUI();

    @Override
    public void execute(CommandSender sender, String[] args) {

        // Main menu command /menu

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        player.openInventory(mainMenuGUI.getMainMenuInventory());
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}