package org.xgqc.pojo;

public enum BrakeStateEnum {
    BRAKE_OFF(0, "制动关"),
    BRAKE_ON(101, "制动有效"),
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private BrakeStateEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static BrakeStateEnum fromCode(int code) {
        for(BrakeStateEnum state : values()) {
            if (state.code == code) {
                return state;
            }
        }

        return null;
    }

    public String toString() {
        return this.description;
    }

    public String getDescription() {
        return this.description;
    }
}
