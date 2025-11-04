package org.xgqc.entity;

import org.xgqc.util.ParseWordUtil;

public class GPSRedisData {
    private String vin;
    private String dataTime;          // GPS数据时间
    private String positioningStatus; // 定位状态
    private String longitudeDirection; // 东经西经
    private String latitudeDirection; // 南纬北纬
    private Long longitude;        // 经度
    private Long latitude;         // 纬度
    private String receTime;     // GPS接收时间

    // 新增地址相关字段
    private String formattedAddress;  // 完整格式化地址
    private String province;          // 省
    private String city;              // 市
    private String district;          // 区/县
    private String township;          // 乡镇/街道办
    private String street;            // 街道
    private String streetNumber;      // 门牌号
    private static final byte VALID_POSITION_MASK = 1;
    private static final byte LATITUDE_DIRECTION_MASK = 2;
    private static final byte LONGITUDE_DIRECTION_MASK = 4;

    public static String parseCurrentValue(byte[] data, int offset) {
        int rawValue = ParseWordUtil.parseWord(data, offset);
        return String.format("%.1f", (double)(rawValue - 10000) * 0.1);
    }

    public GPSRedisData() {
    }

    public String getVin() {
        return this.vin;
    }

    public String getDataTime() {
        return this.dataTime;
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
        } else if (!(o instanceof GPSRedisData)) {
            return false;
        } else {
            GPSRedisData other = (GPSRedisData)o;
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

    protected boolean canEqual(Object other) {
        return other instanceof GPSRedisData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $vin = this.getVin();
        result = result * 59 + ($vin == null ? 43 : $vin.hashCode());
        Object $dataTime = this.getDataTime();
        result = result * 59 + ($dataTime == null ? 43 : $dataTime.hashCode());
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
        return "GPSRedisData(vin=" + this.getVin() + ", dataTime=" + this.getDataTime() + ", positioningStatus=" + this.getPositioningStatus() + ", longitudeDirection=" + this.getLongitudeDirection() + ", latitudeDirection=" + this.getLatitudeDirection() + ", longitude=" + this.getLongitude() + ", latitude=" + this.getLatitude() + ", receTime=" + this.getReceTime() + ", formattedAddress=" + this.getFormattedAddress() + ", province=" + this.getProvince() + ", city=" + this.getCity() + ", district=" + this.getDistrict() + ", township=" + this.getTownship() + ", street=" + this.getStreet() + ", streetNumber=" + this.getStreetNumber() + ")";
    }
}
