package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;
import org.xgqc.util.ParseFieldUtil;

@Component
public class CumFeedbackElectric implements CanDataParser {
    private static final String CAN_ID = "0x18FF63F3";

    public CumFeedbackElectric() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String realData = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(realData.toCharArray());
            int offset = 0;
            canData.setFeedbackElectric(ParseFieldUtil.parseScaledValue(bytes, offset + 4, 4, 0.1));
        }
    }

    public String getSupportedCanId() {
        return "0x18FF63F3";
    }
}
