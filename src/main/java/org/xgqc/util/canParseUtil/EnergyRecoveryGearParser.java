package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;

@Component
public class EnergyRecoveryGearParser implements CanDataParser {
    private static final String CAN_ID = "0x18FF21A6";

    public EnergyRecoveryGearParser() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String value = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(value.toCharArray());
            int firstByteAsDecimal = bytes[0];
            canData.setEnergyRecoveryGear(String.valueOf(firstByteAsDecimal));
        }
    }

    public String getSupportedCanId() {
        return "0x18FF21A6";
    }
}