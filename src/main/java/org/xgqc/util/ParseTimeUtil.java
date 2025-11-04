package org.xgqc.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ParseTimeUtil {
    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Shanghai");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ParseTimeUtil() {
    }

    public static String parseTime(byte[] data, int offset) {
        long seconds = ParseWordUtil.parseDWord(data, offset);
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), DEFAULT_ZONE).format(TIME_FORMATTER);
    }

    public static String parseTime(String timestampStr) {
        try {
            long seconds = Long.parseLong(timestampStr);
            return LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), DEFAULT_ZONE).format(TIME_FORMATTER);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid timestamp: " + timestampStr, e);
        }
    }
}
