package com.andrew.survivalcore.enums;

import com.andrew.survivalcore.utils.ChatColorUtil;

public enum RankEnum {

    MEMBER(ChatColorUtil.colorize("&8[&7&lMember&8]"), "Member"),
    KNIGHT(ChatColorUtil.colorize("&8[&8&lKnight&8]"), "Knight"),
    HERO(ChatColorUtil.colorize("&8[&3&lHero&8]"), "Hero"),
    ELITE(ChatColorUtil.colorize("&8[&e&lElite&8]"), "Elite"),
    ULTRA(ChatColorUtil.colorize("&8[&d&lUltra&8]"), "Ultra"),
    LEGEND(ChatColorUtil.colorize("&8[&b&lLegend&8]"), "Legend"),
    TITAN(ChatColorUtil.colorize("&8[&6&lTitan&8]"), "Titan"),
    WIZARD(ChatColorUtil.colorize("&8[&3&lWizard&8]"), "Wizard");

    private String display;
    private String name;

    RankEnum(String display, String name ) {
        this.name = name;
        this.display = display;
    }

    public String getDisplay() { return display; }
    public String getName() { return name; }
}
