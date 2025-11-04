package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;

@Component
public class EmptyParse implements CanDataParser {
    private static final String CAN_ID = "0x18FFCF03";

    public EmptyParse() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String value = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(value.toCharArray());
            int offset = 0;
            canData.setEmptyLoadState("");
        }
    }

    public String getSupportedCanId() {
        return "0x18FFCF03";
    }
}
