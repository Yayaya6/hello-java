package com.dimon.tryjava.utils;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static final String DATETIME_FORMATTER_STR = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_DATETIME_FORMATTER_STR = "EEE MMM dd kk:mm:ss yyyy";
    public static final String ZONE_DATETIME_FORMATTER_STR = "EEE MMM dd kk:mm:ss z yyyy";

    public static String getCurrentUTCTimeString() {
        OffsetDateTime odt = Instant.now().atOffset(ZoneOffset.UTC);
        DateTimeFormatter fm = DateTimeFormatter.ofPattern(DATETIME_FORMATTER_STR);
        return odt.format(fm);
    }
}