package com.andrew.survivalcore.enums;

import com.andrew.survivalcore.utils.ChatColorUtil;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public enum StringEnum {

    SURVIVALCORE_PREFIX(ChatColorUtil.colorize("&8[&a&lSurvivalCore&8]")),
    PLAYER_NOT_FOUND(ChatColorUtil.colorize("&cPlayer not found!")),
    PLAYER_ONLY_COMMAND(ChatColorUtil.colorize("Only a player may execute this command.")),
    OP_ONLY_COMMAND(ChatColorUtil.colorize("&cYou must be OP to use this command!")),

    // GUI STRINGS
    MAINMENU(ChatColorUtil.colorize("&8&lMain Menu")),
    WARPMENU(ChatColorUtil.colorize("&8&lWarps Menu"));

    private String value;

    StringEnum(String value) {
        this.value = value;
    }

    List<StringEnum> getAllStringEnum() { return Arrays.asList(StringEnum.values()); }

    public String getValue() { return value; }

}


