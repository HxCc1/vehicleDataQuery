package org.xgqc.util;

import java.util.Arrays;
import java.util.function.Function;

public class ParseFieldUtil {
    public ParseFieldUtil() {
    }

    public static String parseScaledValue(byte[] data, int offset, int byteSize, double scale) {
        long rawValue = byteSize == 2 ? (long)ParseWordUtil.parseWord(data, offset) : ParseWordUtil.parseDWord(data, offset);
        double value = (double)rawValue * scale;
        return String.format("%.1f", value);
    }

    public static <T extends Enum<T>> String parseEnum(byte[] data, int offset, Function<Integer, T> enumResolver) {
        int rawValue = ParseWordUtil.parseByte(data, offset);
        T state = (T)(enumResolver.apply(rawValue));
        return state != null ? state.toString() : String.valueOf(rawValue);
    }

    public static String parseScaledValue(byte[] data, int offset, int byteSize, double scale, long errorValue, long invalidValue) {
        long rawValue = byteSize == 2 ? (long)ParseWordUtil.parseWord(data, offset) : ParseWordUtil.parseDWord(data, offset);
        if (rawValue == errorValue) {
            return "异常";
        } else if (rawValue == invalidValue) {
            return "无效";
        } else {
            double value = (double)rawValue * scale;
            return String.format("%.1f", value);
        }
    }

    public static String parseCurrentValue(byte[] data, int offset) {
        int rawValue = ParseWordUtil.parseWord(data, offset);
        if (rawValue == 65534) {
            return "异常";
        } else {
            return rawValue == 65535 ? "无效" : String.format("%.1f", (double)(rawValue - 10000) * 0.1);
        }
    }

    public static String parseByteValue(byte[] data, int offset) {
        int rawValue = ParseWordUtil.parseByte(data, offset);
        return String.format("%d", rawValue);
    }

    public static String parseWordValue(byte[] data, int offset) {
        int rawValue = ParseWordUtil.parseWord(data, offset);
        return String.valueOf(rawValue);
    }

    public static String parseIccid(byte[] data, int offset, int length) {
        byte[] iccidBytes = Arrays.copyOfRange(data, offset, offset + length);
        String iccid = (new String(iccidBytes)).trim();
        iccid = iccid.replaceAll("[^\\x20-\\x7E]", "");
        return iccid;
    }

    public static int getBitsFromByte(byte b, int startBit, int length) {
        if (startBit >= 0 && startBit <= 7 && length > 0 && startBit + length <= 8) {
            int mask = (1 << length) - 1;
            return b >> startBit & mask;
        } else {
            throw new IllegalArgumentException("Invalid bit range");
        }
    }
}
