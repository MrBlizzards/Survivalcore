package com.andrew.survivalcore.enums;

import com.andrew.survivalcore.utils.ChatColorUtil;

public enum RankEnum {

    // MEMBER RANKS
    MEMBER(ChatColorUtil.colorize("&8[&7&lMember&8]"), "Member", 1),
    KNIGHT(ChatColorUtil.colorize("&8[&8&lKnight&8]"), "Knight", 2),
    HERO(ChatColorUtil.colorize("&8[&3&lHero&8]"), "Hero",3),
    ELITE(ChatColorUtil.colorize("&8[&e&lElite&8]"), "Elite",4),
    ULTRA(ChatColorUtil.colorize("&8[&d&lUltra&8]"), "Ultra", 5),
    LEGEND(ChatColorUtil.colorize("&8[&b&lLegend&8]"), "Legend", 6),
    TITAN(ChatColorUtil.colorize("&8[&6&lTitan&8]"), "Titan", 7),
    WIZARD(ChatColorUtil.colorize("&8[&3&lWizard&8]"), "Wizard", 8),

    // STAFF RANKS
    HELPER(ChatColorUtil.colorize("&8[&e&lHELPER&8]"), "Helper", 9),
    MOD(ChatColorUtil.colorize("&8[&d&lModerator&8]"), "Mod", 10),
    ADMIN(ChatColorUtil.colorize("&8[&c&lAdministrator&8]"), "Admin", 11),
    OWNER(ChatColorUtil.colorize("&8[&4&lOwner&8]"), "Owner", 12);

    private String display;
    private String name;
    private int rankRanking;

    RankEnum(String display, String name, int rankRanking ) {
        this.name = name;
        this.display = display;
        this.rankRanking = rankRanking;
    }

    public String getDisplay() { return display; }
    public String getName() { return name; }
    public int getRankRanking() { return rankRanking; }
}
