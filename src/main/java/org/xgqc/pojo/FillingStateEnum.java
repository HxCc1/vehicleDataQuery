package org.xgqc.pojo;

public enum FillingStateEnum {
    PARKING_CHARGE(1, "停车充电"),
    DRIVING_CHARGE(2, "行驶充电"),
    NOT_CHARGING(3, "未充电状态"),
    CHARGE_COMPLETE(4, "充电完成"),
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private FillingStateEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static FillingStateEnum fromCode(int code) {
        for(FillingStateEnum state : values()) {
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
