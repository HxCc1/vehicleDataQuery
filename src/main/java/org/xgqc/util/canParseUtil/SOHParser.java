package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;

@Component
public class SOHParser implements CanDataParser {
    private static final String CAN_ID = "0x18FF62F3";

    public SOHParser() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String realData = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(realData.toCharArray());
            int firstByteAsDecimal = bytes[0];
            canData.setSoh(String.valueOf(firstByteAsDecimal));
        }
    }

    public String getSupportedCanId() {
        return "0x18FF62F3";
    }
}