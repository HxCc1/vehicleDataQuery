package org.xgqc.pojo;

public enum DcDcStateEnum {
    WORKING(1, "工作"),
    DISCONNECTED(2, "断开"),
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private DcDcStateEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DcDcStateEnum fromCode(int code) {
        for(DcDcStateEnum state : values()) {
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
