package io.sentry.util;

import java.util.Locale;

public final class StringUtils {
    private StringUtils() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r0 = r0 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringAfterDot(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0017
            java.lang.String r0 = "."
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0016
            int r1 = r2.length()
            int r0 = r0 + 1
            if (r1 <= r0) goto L_0x0016
            java.lang.String r2 = r2.substring(r0)
        L_0x0016:
            return r2
        L_0x0017:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.util.StringUtils.getStringAfterDot(java.lang.String):java.lang.String");
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1).toLowerCase(Locale.ROOT);
    }

    public static String removeSurrounding(String str, String str2) {
        return (str == null || str2 == null || !str.startsWith(str2) || !str.endsWith(str2)) ? str : str.substring(str2.length(), str.length() - str2.length());
    }
}
