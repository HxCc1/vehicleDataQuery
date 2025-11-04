package org.xgqc.entity;

public class LoginAndLoginoutData {
    private String vin;
    private String logoutDataTime;
    private String logoutSerialNumber;
    private String logoutReceiveTime;
    private String loginDataTime;
    private String loginSequenceNumber;
    private String loginReceiveTime;
    private String iccid;
    private String batteryTotalUnits;
    private String batteryPackCodeLength;
    private String batteryCodes;

    public LoginAndLoginoutData() {
    }

    public String getVin() {
        return this.vin;
    }

    public String getLogoutDataTime() {
        return this.logoutDataTime;
    }

    public String getLogoutSerialNumber() {
        return this.logoutSerialNumber;
    }

    public String getLogoutReceiveTime() {
        return this.logoutReceiveTime;
    }

    public String getLoginDataTime() {
        return this.loginDataTime;
    }

    public String getLoginSequenceNumber() {
        return this.loginSequenceNumber;
    }

    public String getLoginReceiveTime() {
        return this.loginReceiveTime;
    }

    public String getIccid() {
        return this.iccid;
    }

    public String getBatteryTotalUnits() {
        return this.batteryTotalUnits;
    }

    public String getBatteryPackCodeLength() {
        return this.batteryPackCodeLength;
    }

    public String getBatteryCodes() {
        return this.batteryCodes;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setLogoutDataTime(String logoutDataTime) {
        this.logoutDataTime = logoutDataTime;
    }

    public void setLogoutSerialNumber(String logoutSerialNumber) {
        this.logoutSerialNumber = logoutSerialNumber;
    }

    public void setLogoutReceiveTime(String logoutReceiveTime) {
        this.logoutReceiveTime = logoutReceiveTime;
    }

    public void setLoginDataTime(String loginDataTime) {
        this.loginDataTime = loginDataTime;
    }

    public void setLoginSequenceNumber(String loginSequenceNumber) {
        this.loginSequenceNumber = loginSequenceNumber;
    }

    public void setLoginReceiveTime(String loginReceiveTime) {
        this.loginReceiveTime = loginReceiveTime;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public void setBatteryTotalUnits(String batteryTotalUnits) {
        this.batteryTotalUnits = batteryTotalUnits;
    }

    public void setBatteryPackCodeLength(String batteryPackCodeLength) {
        this.batteryPackCodeLength = batteryPackCodeLength;
    }

    public void setBatteryCodes(String batteryCodes) {
        this.batteryCodes = batteryCodes;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof LoginAndLoginoutData)) {
            return false;
        } else {
            LoginAndLoginoutData other = (LoginAndLoginoutData)o;
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

                Object this$logoutDataTime = this.getLogoutDataTime();
                Object other$logoutDataTime = other.getLogoutDataTime();
                if (this$logoutDataTime == null) {
                    if (other$logoutDataTime != null) {
                        return false;
                    }
                } else if (!this$logoutDataTime.equals(other$logoutDataTime)) {
                    return false;
                }

                Object this$logoutSerialNumber = this.getLogoutSerialNumber();
                Object other$logoutSerialNumber = other.getLogoutSerialNumber();
                if (this$logoutSerialNumber == null) {
                    if (other$logoutSerialNumber != null) {
                        return false;
                    }
                } else if (!this$logoutSerialNumber.equals(other$logoutSerialNumber)) {
                    return false;
                }

                Object this$logoutReceiveTime = this.getLogoutReceiveTime();
                Object other$logoutReceiveTime = other.getLogoutReceiveTime();
                if (this$logoutReceiveTime == null) {
                    if (other$logoutReceiveTime != null) {
                        return false;
                    }
                } else if (!this$logoutReceiveTime.equals(other$logoutReceiveTime)) {
                    return false;
                }

                Object this$loginDataTime = this.getLoginDataTime();
                Object other$loginDataTime = other.getLoginDataTime();
                if (this$loginDataTime == null) {
                    if (other$loginDataTime != null) {
                        return false;
                    }
                } else if (!this$loginDataTime.equals(other$loginDataTime)) {
                    return false;
                }

                Object this$loginSequenceNumber = this.getLoginSequenceNumber();
                Object other$loginSequenceNumber = other.getLoginSequenceNumber();
                if (this$loginSequenceNumber == null) {
                    if (other$loginSequenceNumber != null) {
                        return false;
                    }
                } else if (!this$loginSequenceNumber.equals(other$loginSequenceNumber)) {
                    return false;
                }

                Object this$loginReceiveTime = this.getLoginReceiveTime();
                Object other$loginReceiveTime = other.getLoginReceiveTime();
                if (this$loginReceiveTime == null) {
                    if (other$loginReceiveTime != null) {
                        return false;
                    }
                } else if (!this$loginReceiveTime.equals(other$loginReceiveTime)) {
                    return false;
                }

                Object this$iccid = this.getIccid();
                Object other$iccid = other.getIccid();
                if (this$iccid == null) {
                    if (other$iccid != null) {
                        return false;
                    }
                } else if (!this$iccid.equals(other$iccid)) {
                    return false;
                }

                Object this$batteryTotalUnits = this.getBatteryTotalUnits();
                Object other$batteryTotalUnits = other.getBatteryTotalUnits();
                if (this$batteryTotalUnits == null) {
                    if (other$batteryTotalUnits != null) {
                        return false;
                    }
                } else if (!this$batteryTotalUnits.equals(other$batteryTotalUnits)) {
                    return false;
                }

                Object this$batteryPackCodeLength = this.getBatteryPackCodeLength();
                Object other$batteryPackCodeLength = other.getBatteryPackCodeLength();
                if (this$batteryPackCodeLength == null) {
                    if (other$batteryPackCodeLength != null) {
                        return false;
                    }
                } else if (!this$batteryPackCodeLength.equals(other$batteryPackCodeLength)) {
                    return false;
                }

                Object this$batteryCodes = this.getBatteryCodes();
                Object other$batteryCodes = other.getBatteryCodes();
                if (this$batteryCodes == null) {
                    if (other$batteryCodes != null) {
                        return false;
                    }
                } else if (!this$batteryCodes.equals(other$batteryCodes)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof LoginAndLoginoutData;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $vin = this.getVin();
        result = result * 59 + ($vin == null ? 43 : $vin.hashCode());
        Object $logoutDataTime = this.getLogoutDataTime();
        result = result * 59 + ($logoutDataTime == null ? 43 : $logoutDataTime.hashCode());
        Object $logoutSerialNumber = this.getLogoutSerialNumber();
        result = result * 59 + ($logoutSerialNumber == null ? 43 : $logoutSerialNumber.hashCode());
        Object $logoutReceiveTime = this.getLogoutReceiveTime();
        result = result * 59 + ($logoutReceiveTime == null ? 43 : $logoutReceiveTime.hashCode());
        Object $loginDataTime = this.getLoginDataTime();
        result = result * 59 + ($loginDataTime == null ? 43 : $loginDataTime.hashCode());
        Object $loginSequenceNumber = this.getLoginSequenceNumber();
        result = result * 59 + ($loginSequenceNumber == null ? 43 : $loginSequenceNumber.hashCode());
        Object $loginReceiveTime = this.getLoginReceiveTime();
        result = result * 59 + ($loginReceiveTime == null ? 43 : $loginReceiveTime.hashCode());
        Object $iccid = this.getIccid();
        result = result * 59 + ($iccid == null ? 43 : $iccid.hashCode());
        Object $batteryTotalUnits = this.getBatteryTotalUnits();
        result = result * 59 + ($batteryTotalUnits == null ? 43 : $batteryTotalUnits.hashCode());
        Object $batteryPackCodeLength = this.getBatteryPackCodeLength();
        result = result * 59 + ($batteryPackCodeLength == null ? 43 : $batteryPackCodeLength.hashCode());
        Object $batteryCodes = this.getBatteryCodes();
        result = result * 59 + ($batteryCodes == null ? 43 : $batteryCodes.hashCode());
        return result;
    }

    public String toString() {
        return "LoginAndLoginoutData(vin=" + this.getVin() + ", logoutDataTime=" + this.getLogoutDataTime() + ", logoutSerialNumber=" + this.getLogoutSerialNumber() + ", logoutReceiveTime=" + this.getLogoutReceiveTime() + ", loginDataTime=" + this.getLoginDataTime() + ", loginSequenceNumber=" + this.getLoginSequenceNumber() + ", loginReceiveTime=" + this.getLoginReceiveTime() + ", iccid=" + this.getIccid() + ", batteryTotalUnits=" + this.getBatteryTotalUnits() + ", batteryPackCodeLength=" + this.getBatteryPackCodeLength() + ", batteryCodes=" + this.getBatteryCodes() + ")";
    }
}
