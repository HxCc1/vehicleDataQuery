package org.xgqc.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "CAN数据实体类，表示车辆的CAN总线数据")
public class CanRedisData {
    private String vin;
    // can数据时间
    private String dataTime;
    // 累计放电量
    private String discharge;
    // 累计充电量
    private String charge;
    // 能量回收挡位
    private String energyRecoveryGear;
    // 累计回馈电量
    private String feedbackElectric;
    // soh
    private String soh;
    // 搅拌车罐体旋转速度
    private String mixerTruckRotationSpeed;
    // 搅拌车罐体旋转方向
    private String mixerTruckRotationDirection;
    // 空载状态
    private String emptyLoadState;

    public CanRedisData() {
    }

    public String getVin() {
        return this.vin;
    }

    public String getDataTime() {
        return this.dataTime;
    }

    public String getDischarge() {
        return this.discharge;
    }

    public String getCharge() {
        return this.charge;
    }

    public String getEnergyRecoveryGear() {
        return this.energyRecoveryGear;
    }

    public String getFeedbackElectric() {
        return this.feedbackElectric;
    }

    public String getSoh() {
        return this.soh;
    }

    public String getMixerTruckRotationSpeed() {
        return this.mixerTruckRotationSpeed;
    }

    public String getMixerTruckRotationDirection() {
        return this.mixerTruckRotationDirection;
    }

    public String getEmptyLoadState() {
        return this.emptyLoadState;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setEnergyRecoveryGear(String energyRecoveryGear) {
        this.energyRecoveryGear = energyRecoveryGear;
    }

    public void setFeedbackElectric(String feedbackElectric) {
        this.feedbackElectric = feedbackElectric;
    }

    public void setSoh(String soh) {
        this.soh = soh;
    }

    public void setMixerTruckRotationSpeed(String mixerTruckRotationSpeed) {
        this.mixerTruckRotationSpeed = mixerTruckRotationSpeed;
    }

    public void setMixerTruckRotationDirection(String mixerTruckRotationDirection) {
        this.mixerTruckRotationDirection = mixerTruckRotationDirection;
    }

    public void setEmptyLoadState(String emptyLoadState) {
        this.emptyLoadState = emptyLoadState;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CanRedisData)) {
            return false;
        } else {
            CanRedisData other = (CanRedisData)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$vin = this.getVin();
                Object other$vin = other.getVin();
                if (this$vin == null) {
                    if (other$vin != null) {
                        return false;
                    }
                } else if (!this$vin.equals(other$vin)) {
                    return false;
                }

                Object this$dataTime = this.getDataTime();
                Object other$dataTime = other.getDataTime();
                if (this$dataTime == null) {
                    if (other$dataTime != null) {
                        return false;
                    }
                } else if (!this$dataTime.equals(other$dataTime)) {
                    return false;
                }

                Object this$discharge = this.getDischarge();
                Object other$discharge = other.getDischarge();
                if (this$discharge == null) {
                    if (other$discharge != null) {
                        return false;
                    }
                } else if (!this$discharge.equals(other$discharge)) {
                    return false;
                }

                Object this$charge = this.getCharge();
                Object other$charge = other.getCharge();
                if (this$charge == null) {
                    if (other$charge != null) {
                        return false;
                    }
                } else if (!this$charge.equals(other$charge)) {
                    return false;
                }

                Object this$energyRecoveryGear = this.getEnergyRecoveryGear();
                Object other$energyRecoveryGear = other.getEnergyRecoveryGear();
                if (this$energyRecoveryGear == null) {
                    if (other$energyRecoveryGear != null) {
                        return false;
                    }
                } else if (!this$energyRecoveryGear.equals(other$energyRecoveryGear)) {
                    return false;
                }

                Object this$feedbackElectric = this.getFeedbackElectric();
                Object other$feedbackElectric = other.getFeedbackElectric();
                if (this$feedbackElectric == null) {
                    if (other$feedbackElectric != null) {
                        return false;
                    }
                } else if (!this$feedbackElectric.equals(other$feedbackElectric)) {
                    return false;
                }

                Object this$soh = this.getSoh();
                Object other$soh = other.getSoh();
                if (this$soh == null) {
                    if (other$soh != null) {
                        return false;
                    }
                } else if (!this$soh.equals(other$soh)) {
                    return false;
                }

                Object this$mixerTruckRotationSpeed = this.getMixerTruckRotationSpeed();
                Object other$mixerTruckRotationSpeed = other.getMixerTruckRotationSpeed();
                if (this$mixerTruckRotationSpeed == null) {
                    if (other$mixerTruckRotationSpeed != null) {
                        return false;
                    }
                } else if (!this$mixerTruckRotationSpeed.equals(other$mixerTruckRotationSpeed)) {
                    return false;
                }

                Object this$mixerTruckRotationDirection = this.getMixerTruckRotationDirection();
                Object other$mixerTruckRotationDirection = other.getMixerTruckRotationDirection();
                if (this$mixerTruckRotationDirection == null) {
                    if (other$mixerTruckRotationDirection != null) {
                        return false;
                    }
                } else if (!this$mixerTruckRotationDirection.equals(other$mixerTruckRotationDirection)) {
                    return false;
                }

                Object this$emptyLoadState = this.getEmptyLoadState();
                Object other$emptyLoadState = other.getEmptyLoadState();
                if (this$emptyLoadState == null) {
                    if (other$emptyLoadState != null) {
                        return false;
                    }
                } else if (!this$emptyLoadState.equals(other$emptyLoadState)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CanRedisData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $vin = this.getVin();
        result = result * 59 + ($vin == null ? 43 : $vin.hashCode());
        Object $dataTime = this.getDataTime();
        result = result * 59 + ($dataTime == null ? 43 : $dataTime.hashCode());
        Object $discharge = this.getDischarge();
        result = result * 59 + ($discharge == null ? 43 : $discharge.hashCode());
        Object $charge = this.getCharge();
        result = result * 59 + ($charge == null ? 43 : $charge.hashCode());
        Object $energyRecoveryGear = this.getEnergyRecoveryGear();
        result = result * 59 + ($energyRecoveryGear == null ? 43 : $energyRecoveryGear.hashCode());
        Object $feedbackElectric = this.getFeedbackElectric();
        result = result * 59 + ($feedbackElectric == null ? 43 : $feedbackElectric.hashCode());
        Object $soh = this.getSoh();
        result = result * 59 + ($soh == null ? 43 : $soh.hashCode());
        Object $mixerTruckRotationSpeed = this.getMixerTruckRotationSpeed();
        result = result * 59 + ($mixerTruckRotationSpeed == null ? 43 : $mixerTruckRotationSpeed.hashCode());
        Object $mixerTruckRotationDirection = this.getMixerTruckRotationDirection();
        result = result * 59 + ($mixerTruckRotationDirection == null ? 43 : $mixerTruckRotationDirection.hashCode());
        Object $emptyLoadState = this.getEmptyLoadState();
        result = result * 59 + ($emptyLoadState == null ? 43 : $emptyLoadState.hashCode());
        return result;
    }

    public String toString() {
        return "CanRedisData(vin=" + this.getVin() + ", dataTime=" + this.getDataTime() + ", discharge=" + this.getDischarge() + ", charge=" + this.getCharge() + ", energyRecoveryGear=" + this.getEnergyRecoveryGear() + ", feedbackElectric=" + this.getFeedbackElectric() + ", soh=" + this.getSoh() + ", mixerTruckRotationSpeed=" + this.getMixerTruckRotationSpeed() + ", mixerTruckRotationDirection=" + this.getMixerTruckRotationDirection() + ", emptyLoadState=" + this.getEmptyLoadState() + ")";
    }
}
