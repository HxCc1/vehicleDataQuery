package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;
import org.xgqc.entity.CanRedisData;
import org.xgqc.util.ParseFieldUtil;

@Component
public class MixerTruckRotationDirection implements CanDataParser {
    private static final String CAN_ID = "0x188915D0";

    public MixerTruckRotationDirection() {
    }

    public void parse(String rawData, CanRedisData canData) throws DecoderException {
        if (rawData != null) {
            String realData = rawData.split(",")[1];
            byte[] bytes = Hex.decodeHex(realData.toCharArray());
            int tankDirection = ParseFieldUtil.getBitsFromByte(bytes[1], 0, 2);
            String direction;
            switch (tankDirection) {
                case 0:
                    direction = "停转";
                    break;
                case 1:
                    direction = "进料";
                    break;
                case 2:
                    direction = "出料";
                    break;
                case 3:
                    direction = "保留";
                    break;
                default:
                    direction = "未知";
            }

            canData.setMixerTruckRotationDirection(direction);
        }
    }

    public String getSupportedCanId() {
        return "0x188915D0";
    }
}

