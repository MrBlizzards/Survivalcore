package com.andrew.survivalcore.enums;

import java.util.Arrays;
import java.util.List;

public enum StringEnum {

    SURVIVALCORE_PREFIX("&8[&a&lSurvivalCore&8]"),
    PLAYER_NOT_FOUND("&cPlayer not found!");

    private String value;

    StringEnum(String value) {
        this.value = value;
    }

    List<StringEnum> getAllStringEnum() { return Arrays.asList(StringEnum.values()); }

    public String getValue() { return value; }

}


