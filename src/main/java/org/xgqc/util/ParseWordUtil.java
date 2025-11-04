package org.xgqc.util;

public class ParseWordUtil {
    public ParseWordUtil() {
    }

    public static int parseByte(byte[] data, int offset) {
        return data[offset] & 255;
    }

    public static int parseWord(byte[] data, int offset) {
        return data[offset] & 255 | (data[offset + 1] & 255) << 8;
    }

    public static long parseDWord(byte[] data, int offset) {
        return (long)data[offset] & 255L | ((long)data[offset + 1] & 255L) << 8 | ((long)data[offset + 2] & 255L) << 16 | ((long)data[offset + 3] & 255L) << 24;
    }
}