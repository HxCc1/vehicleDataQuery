package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;
import org.xgqc.util.ParseFieldUtil;
import org.xgqc.util.ParseTimeUtil;

@Component
public class CumChargeDischargeParser implements CanDataParser {
    private static final String CAN_ID = "0x18FF61F3";

    public CumChargeDischargeParser() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String realData = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(realData.toCharArray());
            int offset = 0;
            canData.setCharge(ParseFieldUtil.parseScaledValue(bytes, offset, 4, 0.1));
            canData.setDischarge(ParseFieldUtil.parseScaledValue(bytes, offset + 4, 4, 0.1));
            String dataTime = rawData.split(",")[0];
            canData.setDataTime(ParseTimeUtil.parseTime(dataTime));
        }
    }

    public String getSupportedCanId() {
        return "0x18FF61F3";
    }
}