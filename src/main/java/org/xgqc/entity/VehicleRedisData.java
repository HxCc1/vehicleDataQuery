package org.xgqc.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.xgqc.pojo.GearState;
@Schema(description = "车辆实时整车数据实体类，表示车辆的实时整车数据")
public class VehicleRedisData {
    private String vin;
    // 数据时间
    private String dataTime;
    // 车辆状态
    private String carState;
    // 充放电状态
    private String fillingState;
    // 运行模式
    private String runningModel;
    // 车速
    private String speed;
    // 里程
    private String mileage;
    // 总电压
    private String totalV;
    // 总电流
    private String totalA;
    // SOC
    private String soc;
    // DC-DC状态
    private String dcDcState;
    // 挡位
    private GearState gearState;
    // 绝缘电阻
    private int plusR;
    // 加速踏板行程值
    private String accelerator;
    // 制动踏板状态
    private String breakState;
    // 整车数据接收时间
    private String recvTime;

    public VehicleRedisData() {
    }

    public String getVin() {
        return this.vin;
    }

    public String getDataTime() {
        return this.dataTime;
    }

    public String getCarState() {
        return this.carState;
    }

    public String getFillingState() {
        return this.fillingState;
    }

    public String getRunningModel() {
        return this.runningModel;
    }

    public String getSpeed() {
        return this.speed;
    }

    public String getMileage() {
        return this.mileage;
    }

    public String getTotalV() {
        return this.totalV;
    }

    public String getTotalA() {
        return this.totalA;
    }

    public String getSoc() {
        return this.soc;
    }

    public String getDcDcState() {
        return this.dcDcState;
    }

    public GearState getGearState() {
        return this.gearState;
    }

    public int getPlusR() {
        return this.plusR;
    }

    public String getAccelerator() {
        return this.accelerator;
    }

    public String getBreakState() {
        return this.breakState;
    }

    public String getRecvTime() {
        return this.recvTime;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public void setCarState(String carState) {
        this.carState = carState;
    }

    public void setFillingState(String fillingState) {
        this.fillingState = fillingState;
    }

    public void setRunningModel(String runningModel) {
        this.runningModel = runningModel;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setTotalV(String totalV) {
        this.totalV = totalV;
    }

    public void setTotalA(String totalA) {
        this.totalA = totalA;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public void setDcDcState(String dcDcState) {
        this.dcDcState = dcDcState;
    }

    public void setGearState(GearState gearState) {
        this.gearState = gearState;
    }

    public void setPlusR(int plusR) {
        this.plusR = plusR;
    }

    public void setAccelerator(String accelerator) {
        this.accelerator = accelerator;
    }

    public void setBreakState(String breakState) {
        this.breakState = breakState;
    }

    public void setRecvTime(String recvTime) {
        this.recvTime = recvTime;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VehicleRedisData)) {
            return false;
        } else {
            VehicleRedisData other = (VehicleRedisData)o;
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

                Object this$carState = this.getCarState();
                Object other$carState = other.getCarState();
                if (this$carState == null) {
                    if (other$carState != null) {
                        return false;
                    }
                } else if (!this$carState.equals(other$carState)) {
                    return false;
                }

                Object this$fillingState = this.getFillingState();
                Object other$fillingState = other.getFillingState();
                if (this$fillingState == null) {
                    if (other$fillingState != null) {
                        return false;
                    }
                } else if (!this$fillingState.equals(other$fillingState)) {
                    return false;
                }

                Object this$runningModel = this.getRunningModel();
                Object other$runningModel = other.getRunningModel();
                if (this$runningModel == null) {
                    if (other$runningModel != null) {
                        return false;
                    }
                } else if (!this$runningModel.equals(other$runningModel)) {
                    return false;
                }

                Object this$speed = this.getSpeed();
                Object other$speed = other.getSpeed();
                if (this$speed == null) {
                    if (other$speed != null) {
                        return false;
                    }
                } else if (!this$speed.equals(other$speed)) {
                    return false;
                }

                Object this$mileage = this.getMileage();
                Object other$mileage = other.getMileage();
                if (this$mileage == null) {
                    if (other$mileage != null) {
                        return false;
                    }
                } else if (!this$mileage.equals(other$mileage)) {
                    return false;
                }

                Object this$totalV = this.getTotalV();
                Object other$totalV = other.getTotalV();
                if (this$totalV == null) {
                    if (other$totalV != null) {
                        return false;
                    }
                } else if (!this$totalV.equals(other$totalV)) {
                    return false;
                }

                Object this$totalA = this.getTotalA();
                Object other$totalA = other.getTotalA();
                if (this$totalA == null) {
                    if (other$totalA != null) {
                        return false;
                    }
                } else if (!this$totalA.equals(other$totalA)) {
                    return false;
                }

                Object this$soc = this.getSoc();
                Object other$soc = other.getSoc();
                if (this$soc == null) {
                    if (other$soc != null) {
                        return false;
                    }
                } else if (!this$soc.equals(other$soc)) {
                    return false;
                }

                Object this$dcDcState = this.getDcDcState();
                Object other$dcDcState = other.getDcDcState();
                if (this$dcDcState == null) {
                    if (other$dcDcState != null) {
                        return false;
                    }
                } else if (!this$dcDcState.equals(other$dcDcState)) {
                    return false;
                }

                Object this$gearState = this.getGearState();
                Object other$gearState = other.getGearState();
                if (this$gearState == null) {
                    if (other$gearState != null) {
                        return false;
                    }
                } else if (!this$gearState.equals(other$gearState)) {
                    return false;
                }

                if (this.getPlusR() != other.getPlusR()) {
                    return false;
                } else {
                    Object this$accelerator = this.getAccelerator();
                    Object other$accelerator = other.getAccelerator();
                    if (this$accelerator == null) {
                        if (other$accelerator != null) {
                            return false;
                        }
                    } else if (!this$accelerator.equals(other$accelerator)) {
                        return false;
                    }

                    Object this$breakState = this.getBreakState();
                    Object other$breakState = other.getBreakState();
                    if (this$breakState == null) {
                        if (other$breakState != null) {
                            return false;
                        }
                    } else if (!this$breakState.equals(other$breakState)) {
                        return false;
                    }

                    Object this$recvTime = this.getRecvTime();
                    Object other$recvTime = other.getRecvTime();
                    if (this$recvTime == null) {
                        if (other$recvTime != null) {
                            return false;
                        }
                    } else if (!this$recvTime.equals(other$recvTime)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleRedisData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $vin = this.getVin();
        result = result * 59 + ($vin == null ? 43 : $vin.hashCode());
        Object $dataTime = this.getDataTime();
        result = result * 59 + ($dataTime == null ? 43 : $dataTime.hashCode());
        Object $carState = this.getCarState();
        result = result * 59 + ($carState == null ? 43 : $carState.hashCode());
        Object $fillingState = this.getFillingState();
        result = result * 59 + ($fillingState == null ? 43 : $fillingState.hashCode());
        Object $runningModel = this.getRunningModel();
        result = result * 59 + ($runningModel == null ? 43 : $runningModel.hashCode());
        Object $speed = this.getSpeed();
        result = result * 59 + ($speed == null ? 43 : $speed.hashCode());
        Object $mileage = this.getMileage();
        result = result * 59 + ($mileage == null ? 43 : $mileage.hashCode());
        Object $totalV = this.getTotalV();
        result = result * 59 + ($totalV == null ? 43 : $totalV.hashCode());
        Object $totalA = this.getTotalA();
        result = result * 59 + ($totalA == null ? 43 : $totalA.hashCode());
        Object $soc = this.getSoc();
        result = result * 59 + ($soc == null ? 43 : $soc.hashCode());
        Object $dcDcState = this.getDcDcState();
        result = result * 59 + ($dcDcState == null ? 43 : $dcDcState.hashCode());
        Object $gearState = this.getGearState();
        result = result * 59 + ($gearState == null ? 43 : $gearState.hashCode());
        result = result * 59 + this.getPlusR();
        Object $accelerator = this.getAccelerator();
        result = result * 59 + ($accelerator == null ? 43 : $accelerator.hashCode());
        Object $breakState = this.getBreakState();
        result = result * 59 + ($breakState == null ? 43 : $breakState.hashCode());
        Object $recvTime = this.getRecvTime();
        result = result * 59 + ($recvTime == null ? 43 : $recvTime.hashCode());
        return result;
    }

    public String toString() {
        return "VehicleRedisData(vin=" + this.getVin() + ", dataTime=" + this.getDataTime() + ", carState=" + this.getCarState() + ", fillingState=" + this.getFillingState() + ", runningModel=" + this.getRunningModel() + ", speed=" + this.getSpeed() + ", mileage=" + this.getMileage() + ", totalV=" + this.getTotalV() + ", totalA=" + this.getTotalA() + ", soc=" + this.getSoc() + ", dcDcState=" + this.getDcDcState() + ", gearState=" + this.getGearState() + ", plusR=" + this.getPlusR() + ", accelerator=" + this.getAccelerator() + ", breakState=" + this.getBreakState() + ", recvTime=" + this.getRecvTime() + ")";
    }
}
