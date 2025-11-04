package org.xgqc.pojo;

public enum DataTypeEnum {
    REAL_TIME_DATA(1, "实时数据"),
    HISTORICAL_DATA(2, "补发数据");

    private final int code;
    private final String description;

    private DataTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DataTypeEnum fromCode(int code) {
        for(DataTypeEnum type : values()) {
            if (type.code == code) {
                return type;
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
