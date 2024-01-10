package com.squareup.moshi.adapters;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.JsonLexerKt;

final class Iso8601Utils {
    static final String GMT_ID = "GMT";
    static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone(GMT_ID);

    Iso8601Utils() {
    }

    public static String format(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TIMEZONE_Z, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(24);
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(JsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(JsonLexerKt.COLON);
        padInt(sb, gregorianCalendar.get(13), 2);
        sb.append('.');
        padInt(sb, gregorianCalendar.get(14), 3);
        sb.append('Z');
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d2 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019b A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException -> 0x01a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r18) {
        /*
            r1 = r18
            r0 = 4
            r2 = 0
            int r3 = parseInt(r1, r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r4 = 45
            boolean r5 = checkOffset(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r5 == 0) goto L_0x0011
            r0 = 5
        L_0x0011:
            int r5 = r0 + 2
            int r0 = parseInt(r1, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            boolean r7 = checkOffset(r1, r5, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r7 == 0) goto L_0x001f
            int r5 = r5 + 1
        L_0x001f:
            int r7 = r5 + 2
            int r5 = parseInt(r1, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r8 = 84
            boolean r8 = checkOffset(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r9 = 1
            if (r8 != 0) goto L_0x003f
            int r10 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r10 > r7) goto L_0x003f
            java.util.GregorianCalendar r2 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            int r0 = r0 - r9
            r2.<init>(r3, r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.util.Date r0 = r2.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            return r0
        L_0x003f:
            r10 = 43
            r11 = 90
            if (r8 == 0) goto L_0x00c4
            int r7 = r7 + 1
            int r8 = r7 + 2
            int r7 = parseInt(r1, r7, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r12 = 58
            boolean r13 = checkOffset(r1, r8, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r13 == 0) goto L_0x0057
            int r8 = r8 + 1
        L_0x0057:
            int r13 = r8 + 2
            int r8 = parseInt(r1, r8, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            boolean r12 = checkOffset(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r12 == 0) goto L_0x0065
            int r13 = r13 + 1
        L_0x0065:
            int r12 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r12 <= r13) goto L_0x00bc
            char r12 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r12 == r11) goto L_0x00bc
            if (r12 == r10) goto L_0x00bc
            if (r12 == r4) goto L_0x00bc
            int r12 = r13 + 2
            int r13 = parseInt(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r14 = 59
            if (r13 <= r14) goto L_0x0085
            r15 = 63
            if (r13 >= r15) goto L_0x0085
            r13 = 59
        L_0x0085:
            r14 = 46
            boolean r14 = checkOffset(r1, r12, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r14 == 0) goto L_0x00b4
            int r12 = r12 + 1
            int r14 = r12 + 1
            int r14 = indexOfNonDigit(r1, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            int r15 = r12 + 3
            int r15 = java.lang.Math.min(r14, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            int r6 = parseInt(r1, r12, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r16 = r3
            r2 = 4621819117588971520(0x4024000000000000, double:10.0)
            int r15 = r15 - r12
            int r12 = 3 - r15
            r17 = r5
            double r4 = (double) r12     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            double r2 = java.lang.Math.pow(r2, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            double r4 = (double) r6     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            double r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r3 = r7
            r7 = r14
            goto L_0x00cc
        L_0x00b4:
            r16 = r3
            r17 = r5
            r3 = r7
            r7 = r12
            r2 = 0
            goto L_0x00cc
        L_0x00bc:
            r16 = r3
            r17 = r5
            r3 = r7
            r7 = r13
            r2 = 0
            goto L_0x00cb
        L_0x00c4:
            r16 = r3
            r17 = r5
            r2 = 0
            r3 = 0
            r8 = 0
        L_0x00cb:
            r13 = 0
        L_0x00cc:
            int r4 = r18.length()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r4 <= r7) goto L_0x019b
            char r4 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r4 != r11) goto L_0x00dc
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            goto L_0x0169
        L_0x00dc:
            if (r4 == r10) goto L_0x00ff
            r5 = 45
            if (r4 != r5) goto L_0x00e3
            goto L_0x00ff
        L_0x00e3:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r3 = "Invalid time zone indicator '"
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r2.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r3 = "'"
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
        L_0x00ff:
            java.lang.String r4 = r1.substring(r7)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r5 = "+0000"
            boolean r5 = r5.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r5 != 0) goto L_0x0167
            java.lang.String r5 = "+00:00"
            boolean r5 = r5.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r5 == 0) goto L_0x0114
            goto L_0x0167
        L_0x0114:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r5.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r6 = "GMT"
            r5.append(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r5.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r4 = r5.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r6 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            boolean r7 = r6.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r7 != 0) goto L_0x0165
            java.lang.String r7 = ":"
            java.lang.String r10 = ""
            java.lang.String r6 = r6.replace(r7, r10)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            boolean r6 = r6.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            if (r6 == 0) goto L_0x0142
            goto L_0x0165
        L_0x0142:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r2.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r3 = "Mismatching time zone indicator: "
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r2.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r3 = " given, resolves to "
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r3 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r2.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
        L_0x0165:
            r4 = r5
            goto L_0x0169
        L_0x0167:
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
        L_0x0169:
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r5.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r4 = 0
            r5.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r4 = r16
            r5.set(r9, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            int r0 = r0 - r9
            r4 = 2
            r5.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0 = r17
            r4 = 5
            r5.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0 = 11
            r5.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0 = 12
            r5.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0 = 13
            r5.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            r0 = 14
            r5.set(r0, r2)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.util.Date r0 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            return r0
        L_0x019b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            java.lang.String r2 = "No time zone indicator"
            r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01a5, IllegalArgumentException -> 0x01a3 }
        L_0x01a3:
            r0 = move-exception
            goto L_0x01a6
        L_0x01a5:
            r0 = move-exception
        L_0x01a6:
            com.squareup.moshi.JsonDataException r2 = new com.squareup.moshi.JsonDataException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Not an RFC 3339 date: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.adapters.Iso8601Utils.parse(java.lang.String):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
