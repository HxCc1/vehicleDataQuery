package org.xgqc.service;

import org.apache.commons.codec.DecoderException;
import org.xgqc.entity.CanRedisData;
import org.xgqc.entity.GPSRedisData;
import org.xgqc.entity.VehicleData;

public interface IRedisVehService {
    VehicleData getVehicleData(String var1);

    GPSRedisData getGPSValue(String var1);

    CanRedisData getCanValue(String var1) throws DecoderException;

    String getDataNumber(String var1);
}
