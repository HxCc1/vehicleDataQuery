package org.xgqc.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import org.xgqc.pojo.GearState;

@Schema(
        description = "整车数据实体"
)
public class VehicleData {
    private String vin;
    @Schema(
            description = "数据时间，格式为yyyy-MM-dd HH:mm:ss"
    )
    private String dataTime;

    private String recvTime;
    private String carState;
    private String fillingState;
    private String runningModel;
    private String speed;
    private String mileage;
    private String totalV;
    private String totalA;
    private String soc;
    private String dcDcState;
    private GearState gearState;
    private int plusR;
    private String accelerator;
    private String breakState;
    private String positioningStatus;
    private String longitudeDirection;
    private String latitudeDirection;
    private Long longitude;
    private Long latitude;
    private String receTime;
    private String formattedAddress;
    private String province;
    private String city;
    private String district;
    private String township;
    private String street;
    private String streetNumber;

    public VehicleData() {
    }

    public String getVin() {
        return this.vin;
    }

    public String getDataTime() {
        return this.dataTime;
    }

    public String getRecvTime() {
        return this.recvTime;
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

    public String getPositioningStatus() {
        return this.positioningStatus;
    }

    public String getLongitudeDirection() {
        return this.longitudeDirection;
    }

    public String getLatitudeDirection() {
        return this.latitudeDirection;
    }

    public Long getLongitude() {
        return this.longitude;
    }

    public Long getLatitude() {
        return this.latitude;
    }

    public String getReceTime() {
        return this.receTime;
    }

    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    public String getProvince() {
        return this.province;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getTownship() {
        return this.township;
    }

    public String getStreet() {
        return this.street;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public void setRecvTime(String recvTime) {
        this.recvTime = recvTime;
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

    public void setPositioningStatus(String positioningStatus) {
        this.positioningStatus = positioningStatus;
    }

    public void setLongitudeDirection(String longitudeDirection) {
        this.longitudeDirection = longitudeDirection;
    }

    public void setLatitudeDirection(String latitudeDirection) {
        this.latitudeDirection = latitudeDirection;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public void setReceTime(String receTime) {
        this.receTime = receTime;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof VehicleData)) {
            return false;
        } else {
            VehicleData other = (VehicleData)o;
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

                Object this$recvTime = this.getRecvTime();
                Object other$recvTime = other.getRecvTime();
                if (this$recvTime == null) {
                    if (other$recvTime != null) {
                        return false;
                    }
                } else if (!this$recvTime.equals(other$recvTime)) {
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

                    Object this$positioningStatus = this.getPositioningStatus();
                    Object other$positioningStatus = other.getPositioningStatus();
                    if (this$positioningStatus == null) {
                        if (other$positioningStatus != null) {
                            return false;
                        }
                    } else if (!this$positioningStatus.equals(other$positioningStatus)) {
                        return false;
                    }

                    Object this$longitudeDirection = this.getLongitudeDirection();
                    Object other$longitudeDirection = other.getLongitudeDirection();
                    if (this$longitudeDirection == null) {
                        if (other$longitudeDirection != null) {
                            return false;
                        }
                    } else if (!this$longitudeDirection.equals(other$longitudeDirection)) {
                        return false;
                    }

                    Object this$latitudeDirection = this.getLatitudeDirection();
                    Object other$latitudeDirection = other.getLatitudeDirection();
                    if (this$latitudeDirection == null) {
                        if (other$latitudeDirection != null) {
                            return false;
                        }
                    } else if (!this$latitudeDirection.equals(other$latitudeDirection)) {
                        return false;
                    }

                    Object this$longitude = this.getLongitude();
                    Object other$longitude = other.getLongitude();
                    if (this$longitude == null) {
                        if (other$longitude != null) {
                            return false;
                        }
                    } else if (!this$longitude.equals(other$longitude)) {
                        return false;
                    }

                    Object this$latitude = this.getLatitude();
                    Object other$latitude = other.getLatitude();
                    if (this$latitude == null) {
                        if (other$latitude != null) {
                            return false;
                        }
                    } else if (!this$latitude.equals(other$latitude)) {
                        return false;
                    }

                    Object this$receTime = this.getReceTime();
                    Object other$receTime = other.getReceTime();
                    if (this$receTime == null) {
                        if (other$receTime != null) {
                            return false;
                        }
                    } else if (!this$receTime.equals(other$receTime)) {
                        return false;
                    }

                    Object this$formattedAddress = this.getFormattedAddress();
                    Object other$formattedAddress = other.getFormattedAddress();
                    if (this$formattedAddress == null) {
                        if (other$formattedAddress != null) {
                            return false;
                        }
                    } else if (!this$formattedAddress.equals(other$formattedAddress)) {
                        return false;
                    }

                    Object this$province = this.getProvince();
                    Object other$province = other.getProvince();
                    if (this$province == null) {
                        if (other$province != null) {
                            return false;
                        }
                    } else if (!this$province.equals(other$province)) {
                        return false;
                    }

                    Object this$city = this.getCity();
                    Object other$city = other.getCity();
                    if (this$city == null) {
                        if (other$city != null) {
                            return false;
                        }
                    } else if (!this$city.equals(other$city)) {
                        return false;
                    }

                    Object this$district = this.getDistrict();
                    Object other$district = other.getDistrict();
                    if (this$district == null) {
                        if (other$district != null) {
                            return false;
                        }
                    } else if (!this$district.equals(other$district)) {
                        return false;
                    }

                    Object this$township = this.getTownship();
                    Object other$township = other.getTownship();
                    if (this$township == null) {
                        if (other$township != null) {
                            return false;
                        }
                    } else if (!this$township.equals(other$township)) {
                        return false;
                    }

                    Object this$street = this.getStreet();
                    Object other$street = other.getStreet();
                    if (this$street == null) {
                        if (other$street != null) {
                            return false;
                        }
                    } else if (!this$street.equals(other$street)) {
                        return false;
                    }

                    Object this$streetNumber = this.getStreetNumber();
                    Object other$streetNumber = other.getStreetNumber();
                    if (this$streetNumber == null) {
                        if (other$streetNumber != null) {
                            return false;
                        }
                    } else if (!this$streetNumber.equals(other$streetNumber)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof VehicleData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $vin = this.getVin();
        result = result * 59 + ($vin == null ? 43 : $vin.hashCode());
        Object $dataTime = this.getDataTime();
        result = result * 59 + ($dataTime == null ? 43 : $dataTime.hashCode());
        Object $recvTime = this.getRecvTime();
        result = result * 59 + ($recvTime == null ? 43 : $recvTime.hashCode());
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
        Object $positioningStatus = this.getPositioningStatus();
        result = result * 59 + ($positioningStatus == null ? 43 : $positioningStatus.hashCode());
        Object $longitudeDirection = this.getLongitudeDirection();
        result = result * 59 + ($longitudeDirection == null ? 43 : $longitudeDirection.hashCode());
        Object $latitudeDirection = this.getLatitudeDirection();
        result = result * 59 + ($latitudeDirection == null ? 43 : $latitudeDirection.hashCode());
        Object $longitude = this.getLongitude();
        result = result * 59 + ($longitude == null ? 43 : $longitude.hashCode());
        Object $latitude = this.getLatitude();
        result = result * 59 + ($latitude == null ? 43 : $latitude.hashCode());
        Object $receTime = this.getReceTime();
        result = result * 59 + ($receTime == null ? 43 : $receTime.hashCode());
        Object $formattedAddress = this.getFormattedAddress();
        result = result * 59 + ($formattedAddress == null ? 43 : $formattedAddress.hashCode());
        Object $province = this.getProvince();
        result = result * 59 + ($province == null ? 43 : $province.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $district = this.getDistrict();
        result = result * 59 + ($district == null ? 43 : $district.hashCode());
        Object $township = this.getTownship();
        result = result * 59 + ($township == null ? 43 : $township.hashCode());
        Object $street = this.getStreet();
        result = result * 59 + ($street == null ? 43 : $street.hashCode());
        Object $streetNumber = this.getStreetNumber();
        result = result * 59 + ($streetNumber == null ? 43 : $streetNumber.hashCode());
        return result;
    }

    public String toString() {
        return "VehicleData(vin=" + this.getVin() + ", dataTime=" + this.getDataTime() + ", recvTime=" + this.getRecvTime() + ", carState=" + this.getCarState() + ", fillingState=" + this.getFillingState() + ", runningModel=" + this.getRunningModel() + ", speed=" + this.getSpeed() + ", mileage=" + this.getMileage() + ", totalV=" + this.getTotalV() + ", totalA=" + this.getTotalA() + ", soc=" + this.getSoc() + ", dcDcState=" + this.getDcDcState() + ", gearState=" + this.getGearState() + ", plusR=" + this.getPlusR() + ", accelerator=" + this.getAccelerator() + ", breakState=" + this.getBreakState() + ", positioningStatus=" + this.getPositioningStatus() + ", longitudeDirection=" + this.getLongitudeDirection() + ", latitudeDirection=" + this.getLatitudeDirection() + ", longitude=" + this.getLongitude() + ", latitude=" + this.getLatitude() + ", receTime=" + this.getReceTime() + ", formattedAddress=" + this.getFormattedAddress() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", district=" + this.getDistrict() + ", township=" + this.getTownship() + ", street=" + this.getStreet() + ", streetNumber=" + this.getStreetNumber() + ")";
    }
}
