package org.xgqc.pojo;

public enum CarStateEnum {
    KEY_ON(1, "启动"),
    KEY_OFF(2, "熄火"),
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private CarStateEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CarStateEnum fromCode(int code) {
        for(CarStateEnum state : values()) {
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
