package org.xgqc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ParseHex2Timestamp {
    public ParseHex2Timestamp() {
    }

    public static String extractAndConvertTime(String longHexString) {
        try {
            if (longHexString != null && longHexString.length() > 16) {
                String timeHex = longHexString.substring(8, 16);
                System.out.println("提取的8位时间十六进制字符串: " + timeHex);
                String part1 = timeHex.substring(6, 8);
                String part2 = timeHex.substring(4, 6);
                String part3 = timeHex.substring(2, 4);
                String part4 = timeHex.substring(0, 2);
                String reorderedHex = part1 + part2 + part3 + part4;
                System.out.println("重组后的十六进制字符串: " + reorderedHex);
                long timestamp = Long.parseLong(reorderedHex, 16);
                System.out.println("转换后的时间戳: " + timestamp);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                Date date = new Date(timestamp * 1000L);
                return sdf.format(date);
            } else {
                throw new IllegalArgumentException("输入的十六进制字符串长度必须大于16");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String inputHex = "3F579C3B95F07E68E8657F680100E8";
        String result = extractAndConvertTime(inputHex);
        System.out.println("格式化后的日期时间: " + result);
    }
}
