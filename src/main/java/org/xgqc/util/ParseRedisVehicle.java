package org.xgqc.util;

import org.xgqc.entity.GPSRedisData;
import org.xgqc.entity.VehicleData;
import org.xgqc.entity.VehicleRedisData;
import org.xgqc.pojo.AcceleratorStateEnum;
import org.xgqc.pojo.BrakeStateEnum;
import org.xgqc.pojo.CarStateEnum;
import org.xgqc.pojo.DcDcStateEnum;
import org.xgqc.pojo.FillingStateEnum;
import org.xgqc.pojo.GearState;
import org.xgqc.pojo.RunningModelEnum;
import org.xgqc.pojo.SocEnum;

public class ParseRedisVehicle {
    private static final byte VALID_POSITION_MASK = 1;
    private static final byte LATITUDE_DIRECTION_MASK = 2;
    private static final byte LONGITUDE_DIRECTION_MASK = 4;

    public ParseRedisVehicle() {
    }

    public static VehicleRedisData parseVehRedisData(byte[] data) {
        if (data != null && data.length >= 29) {
            VehicleRedisData result = new VehicleRedisData();
            int offset = 0;
            result.setDataTime(ParseTimeUtil.parseTime(data, offset));
            offset += 4;
            result.setCarState(ParseFieldUtil.parseEnum(data, offset, CarStateEnum::fromCode));
            ++offset;
            result.setFillingState(ParseFieldUtil.parseEnum(data, offset, FillingStateEnum::fromCode));
            ++offset;
            result.setRunningModel(ParseFieldUtil.parseEnum(data, offset, RunningModelEnum::fromCode));
            ++offset;
            result.setSpeed(ParseFieldUtil.parseScaledValue(data, offset, 2, 0.1, 65534L, 65535L));
            offset += 2;
            result.setMileage(ParseFieldUtil.parseScaledValue(data, offset, 4, 0.1, 4294967294L, 4294967295L));
            offset += 4;
            result.setTotalV(ParseFieldUtil.parseScaledValue(data, offset, 2, 0.1, 65534L, 65535L));
            offset += 2;
            result.setTotalA(ParseFieldUtil.parseCurrentValue(data, offset));
            offset += 2;
            result.setSoc(ParseFieldUtil.parseEnum(data, offset, SocEnum::fromCode));
            ++offset;
            result.setDcDcState(ParseFieldUtil.parseEnum(data, offset, DcDcStateEnum::fromCode));
            ++offset;
            result.setGearState(new GearState((byte)ParseWordUtil.parseByte(data, offset)));
            ++offset;
            result.setPlusR(ParseWordUtil.parseWord(data, offset));
            offset += 2;
            result.setAccelerator(ParseFieldUtil.parseEnum(data, offset, AcceleratorStateEnum::fromCode));
            ++offset;
            result.setBreakState(ParseFieldUtil.parseEnum(data, offset, BrakeStateEnum::fromCode));
            ++offset;
            result.setRecvTime(ParseTimeUtil.parseTime(data, offset));
            return result;
        } else {
            throw new IllegalArgumentException("数据无效或长度不足");
        }
    }

    public static GPSRedisData parseGPSRedisData(byte[] data, int offset) {
        GPSRedisData gpsRedisData = new GPSRedisData();
        gpsRedisData.setDataTime(ParseTimeUtil.parseTime(data, offset));
        offset += 4;
        int parseByte = ParseWordUtil.parseByte(data, offset);
        ++offset;
        if ((parseByte & 1) == 0) {
            gpsRedisData.setPositioningStatus("有效");
            gpsRedisData.setLongitude(ParseWordUtil.parseDWord(data, offset));
            offset += 4;
            gpsRedisData.setLatitude(ParseWordUtil.parseDWord(data, offset));
            offset += 4;
            gpsRedisData.setReceTime(ParseTimeUtil.parseTime(data, offset));
        } else {
            gpsRedisData.setPositioningStatus("无效");
        }

        if ((parseByte & 2) == 0) {
            gpsRedisData.setLatitudeDirection("北纬");
        } else {
            gpsRedisData.setLatitudeDirection("南纬");
        }

        if ((parseByte & 4) == 0) {
            gpsRedisData.setLongitudeDirection("东经");
        } else {
            gpsRedisData.setLongitudeDirection("西经");
        }

        return gpsRedisData;
    }

    public static VehicleData parseVehicleData(byte[] data) {
        if (data != null && data.length >= 29) {
            VehicleData result = new VehicleData();
            int offset = 0;
            result.setDataTime(ParseTimeUtil.parseTime(data, offset));
            offset += 4;
            result.setCarState(ParseFieldUtil.parseEnum(data, offset, CarStateEnum::fromCode));
            ++offset;
            result.setFillingState(ParseFieldUtil.parseEnum(data, offset, FillingStateEnum::fromCode));
            ++offset;
            result.setRunningModel(ParseFieldUtil.parseEnum(data, offset, RunningModelEnum::fromCode));
            ++offset;
            result.setSpeed(ParseFieldUtil.parseScaledValue(data, offset, 2, 0.1, 65534L, 65535L));
            offset += 2;
            result.setMileage(ParseFieldUtil.parseScaledValue(data, offset, 4, 0.1, 4294967294L, 4294967295L));
            offset += 4;
            result.setTotalV(ParseFieldUtil.parseScaledValue(data, offset, 2, 0.1, 65534L, 65535L));
            offset += 2;
            result.setTotalA(ParseFieldUtil.parseCurrentValue(data, offset));
            offset += 2;
            result.setSoc(ParseFieldUtil.parseEnum(data, offset, SocEnum::fromCode));
            ++offset;
            result.setDcDcState(ParseFieldUtil.parseEnum(data, offset, DcDcStateEnum::fromCode));
            ++offset;
            result.setGearState(new GearState((byte)ParseWordUtil.parseByte(data, offset)));
            ++offset;
            result.setPlusR(ParseWordUtil.parseWord(data, offset));
            offset += 2;
            result.setAccelerator(ParseFieldUtil.parseEnum(data, offset, AcceleratorStateEnum::fromCode));
            ++offset;
            result.setBreakState(ParseFieldUtil.parseEnum(data, offset, BrakeStateEnum::fromCode));
            ++offset;
            result.setRecvTime(ParseTimeUtil.parseTime(data, offset));
            offset += 4;
            result.setDataTime(ParseTimeUtil.parseTime(data, offset));
            offset += 4;
            int parseByte = ParseWordUtil.parseByte(data, offset);
            ++offset;
            if ((parseByte & 1) == 0) {
                result.setPositioningStatus("有效");
                result.setLongitude(ParseWordUtil.parseDWord(data, offset));
                offset += 4;
                result.setLatitude(ParseWordUtil.parseDWord(data, offset));
                offset += 4;
                result.setReceTime(ParseTimeUtil.parseTime(data, offset));
            } else {
                result.setPositioningStatus("无效");
            }

            if ((parseByte & 2) == 0) {
                result.setLatitudeDirection("北纬");
            } else {
                result.setLatitudeDirection("南纬");
            }

            if ((parseByte & 4) == 0) {
                result.setLongitudeDirection("东经");
            } else {
                result.setLongitudeDirection("西经");
            }

            return result;
        } else {
            throw new IllegalArgumentException("数据无效或长度不足");
        }
    }
}
