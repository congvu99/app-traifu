package com.trainerfu.utils;

import java.util.Calendar;

public class Duration {
    public int days;
    public int hours;
    public int minutes;
    public int seconds;
    public int sign = 1;
    public int weeks;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r9) throws java.lang.Exception {
        /*
            r8 = this;
            r0 = 1
            r8.sign = r0
            r1 = 0
            r8.weeks = r1
            r8.days = r1
            r8.hours = r1
            r8.minutes = r1
            r8.seconds = r1
            int r2 = r9.length()
            if (r2 >= r0) goto L_0x0015
            return
        L_0x0015:
            char r3 = r9.charAt(r1)
            r4 = 45
            if (r3 != r4) goto L_0x0022
            r3 = -1
            r8.sign = r3
        L_0x0020:
            r3 = 1
            goto L_0x0028
        L_0x0022:
            r4 = 43
            if (r3 != r4) goto L_0x0027
            goto L_0x0020
        L_0x0027:
            r3 = 0
        L_0x0028:
            if (r2 >= r3) goto L_0x002b
            return
        L_0x002b:
            char r4 = r9.charAt(r3)
            r5 = 80
            java.lang.String r6 = "Duration.parse(str='"
            if (r4 != r5) goto L_0x00a4
            int r3 = r3 + r0
            char r0 = r9.charAt(r3)
            r4 = 84
            if (r0 != r4) goto L_0x0040
            int r3 = r3 + 1
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r3 >= r2) goto L_0x00a3
            char r5 = r9.charAt(r3)
            r7 = 48
            if (r5 < r7) goto L_0x0055
            r7 = 57
            if (r5 > r7) goto L_0x0055
            int r0 = r0 * 10
            int r5 = r5 + -48
            int r0 = r0 + r5
            goto L_0x007b
        L_0x0055:
            r7 = 87
            if (r5 != r7) goto L_0x005d
            r8.weeks = r0
        L_0x005b:
            r0 = 0
            goto L_0x007b
        L_0x005d:
            r7 = 72
            if (r5 != r7) goto L_0x0064
            r8.hours = r0
            goto L_0x005b
        L_0x0064:
            r7 = 77
            if (r5 != r7) goto L_0x006b
            r8.minutes = r0
            goto L_0x005b
        L_0x006b:
            r7 = 83
            if (r5 != r7) goto L_0x0072
            r8.seconds = r0
            goto L_0x005b
        L_0x0072:
            r7 = 68
            if (r5 != r7) goto L_0x0079
            r8.days = r0
            goto L_0x005b
        L_0x0079:
            if (r5 != r4) goto L_0x007e
        L_0x007b:
            int r3 = r3 + 1
            goto L_0x0041
        L_0x007e:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r9)
            java.lang.String r9 = "') unexpected char '"
            r1.append(r9)
            r1.append(r5)
            java.lang.String r9 = "' at index="
            r1.append(r9)
            r1.append(r3)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        L_0x00a3:
            return
        L_0x00a4:
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            r1.append(r9)
            java.lang.String r9 = "') expected 'P' at index="
            r1.append(r9)
            r1.append(r3)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.utils.Duration.parse(java.lang.String):void");
    }

    public void addTo(Calendar calendar) {
        calendar.add(5, this.sign * this.weeks * 7);
        calendar.add(5, this.sign * this.days);
        calendar.add(10, this.sign * this.hours);
        calendar.add(12, this.sign * this.minutes);
        calendar.add(13, this.sign * this.seconds);
    }

    public long addTo(long j) {
        return j + getMillis();
    }

    public long getMillis() {
        return ((long) (this.sign * 1000)) * ((long) ((this.weeks * 604800) + (this.days * 86400) + (this.hours * 3600) + (this.minutes * 60) + this.seconds));
    }
}
