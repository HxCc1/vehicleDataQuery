package org.xgqc.pojo;

import com.fasterxml.jackson.annotation.JsonValue;

public class GearState {
    private final boolean hasDriveForce;
    private final boolean hasBrakeForce;
    private final GearEnum gearEnum;

    public GearState(byte gearByte) {
        this.hasDriveForce = (gearByte & 32) != 0;
        this.hasBrakeForce = (gearByte & 16) != 0;
        this.gearEnum = GearEnum.fromValue(gearByte);
    }

    @JsonValue
    public String getGearDescription() {
        return this.gearEnum.getDescription();
    }

    public String toString() {
        return String.format("驱动力: %s, 制动力: %s, 档位: %s", this.hasDriveForce ? "有" : "无", this.hasBrakeForce ? "有" : "无", this.gearEnum.getDescription());
    }
}
