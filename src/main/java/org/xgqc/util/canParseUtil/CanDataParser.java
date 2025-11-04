package org.xgqc.util.canParseUtil;

import org.apache.commons.codec.DecoderException;
import org.xgqc.entity.CanRedisData;

public interface CanDataParser {
    void parse(String var1, CanRedisData var2) throws DecoderException;

    String getSupportedCanId();
}