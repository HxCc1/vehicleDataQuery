package org.xgqc.pojo;

public enum SocEnum {
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private SocEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static SocEnum fromCode(int code) {
        for(SocEnum state : values()) {
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
