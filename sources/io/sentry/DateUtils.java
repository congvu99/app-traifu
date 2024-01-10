package io.sentry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtils {
    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String ISO_FORMAT_WITH_MILLIS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final ThreadLocal<SimpleDateFormat> SDF_ISO_FORMAT_UTC = new ThreadLocal<SimpleDateFormat>() {
        /* access modifiers changed from: protected */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT, Locale.ROOT);
            simpleDateFormat.setTimeZone(DateUtils.UTC_TIMEZONE);
            return simpleDateFormat;
        }
    };
    private static final ThreadLocal<SimpleDateFormat> SDF_ISO_FORMAT_WITH_MILLIS_UTC = new ThreadLocal<SimpleDateFormat>() {
        /* access modifiers changed from: protected */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO_FORMAT_WITH_MILLIS, Locale.ROOT);
            simpleDateFormat.setTimeZone(DateUtils.UTC_TIMEZONE);
            return simpleDateFormat;
        }
    };
    private static final String UTC = "UTC";
    /* access modifiers changed from: private */
    public static final TimeZone UTC_TIMEZONE = TimeZone.getTimeZone(UTC);

    private DateUtils() {
    }

    public static Date getCurrentDateTime() {
        return Calendar.getInstance(UTC_TIMEZONE).getTime();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        return SDF_ISO_FORMAT_UTC.get().parse(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        throw new java.lang.IllegalArgumentException("timestamp is not ISO format " + r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date getDateTime(java.lang.String r3) throws java.lang.IllegalArgumentException {
        /*
            java.lang.ThreadLocal<java.text.SimpleDateFormat> r0 = SDF_ISO_FORMAT_WITH_MILLIS_UTC     // Catch:{ ParseException -> 0x000d }
            java.lang.Object r0 = r0.get()     // Catch:{ ParseException -> 0x000d }
            java.text.SimpleDateFormat r0 = (java.text.SimpleDateFormat) r0     // Catch:{ ParseException -> 0x000d }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x000d }
            return r3
        L_0x000d:
            java.lang.ThreadLocal<java.text.SimpleDateFormat> r0 = SDF_ISO_FORMAT_UTC     // Catch:{ ParseException -> 0x001a }
            java.lang.Object r0 = r0.get()     // Catch:{ ParseException -> 0x001a }
            java.text.SimpleDateFormat r0 = (java.text.SimpleDateFormat) r0     // Catch:{ ParseException -> 0x001a }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x001a }
            return r3
        L_0x001a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "timestamp is not ISO format "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.DateUtils.getDateTime(java.lang.String):java.util.Date");
    }

    public static Date getDateTimeWithMillisPrecision(String str) throws IllegalArgumentException {
        try {
            String[] split = str.split("\\.", -1);
            return getDateTime((Long.parseLong(split[0]) * 1000) + (split.length > 1 ? Long.parseLong(split[1]) : 0));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("timestamp is not millis format " + str);
        }
    }

    public static String getTimestamp(Date date) {
        return SDF_ISO_FORMAT_WITH_MILLIS_UTC.get().format(date);
    }

    public static Date getDateTime(long j) {
        Calendar instance = Calendar.getInstance(UTC_TIMEZONE);
        instance.setTimeInMillis(j);
        return instance.getTime();
    }
}
