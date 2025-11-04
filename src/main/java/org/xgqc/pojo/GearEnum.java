package org.xgqc.pojo;

public enum GearEnum {
    NEUTRAL(0, "空档"),
    GEAR_1(1, "1档"),
    GEAR_2(2, "2档"),
    GEAR_3(3, "3档"),
    GEAR_4(4, "4档"),
    GEAR_5(5, "5档"),
    GEAR_6(6, "6档"),
    REVERSE(13, "倒档"),
    DRIVE(14, "自动D档"),
    PARK(15, "停车P档"),
    UNKNOWN(-1, "未知档位");

    private final int value;
    private final String description;

    private GearEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static GearEnum fromValue(int value) {
        for(GearEnum gearEnum : values()) {
            if (gearEnum.value == (value & 15)) {
                return gearEnum;
            }
        }

        return UNKNOWN;
    }

    public String toString() {
        return this.description;
    }

    public String getDescription() {
        return this.description;
    }
}
