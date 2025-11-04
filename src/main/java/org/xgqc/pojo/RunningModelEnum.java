package org.xgqc.pojo;

public enum RunningModelEnum {
    ELECTRIC(1, "纯电"),
    HYBRID(2, "混动"),
    FUEL(3, "燃油"),
    ABNORMAL(254, "异常"),
    INVALID(255, "无效");

    private final int code;
    private final String description;

    private RunningModelEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RunningModelEnum fromCode(int code) {
        for(RunningModelEnum model : values()) {
            if (model.code == code) {
                return model;
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
