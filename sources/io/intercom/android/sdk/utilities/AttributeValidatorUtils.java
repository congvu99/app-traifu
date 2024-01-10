package io.intercom.android.sdk.utilities;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;

public class AttributeValidatorUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])", 2);
    private static final Pattern VALID_FLOAT_REGEX = Pattern.compile("^[-+]?\\d*\\.?\\d*$");
    private static final Pattern VALID_NUMBER_REGEX = Pattern.compile("^[-+]?\\d+$");
    private static final Pattern VALID_WEBSITE_REGEX = Pattern.compile("^(https?://)?(www\\.)?([\\w]+\\.)+[‌​\\w]{2,63}/?$");

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeResponseCode {
        public static final int INVALID_COUNTRY_CODE = 6;
        public static final int INVALID_EMAIL = 2;
        public static final int INVALID_NUMBER = 3;
        public static final int INVALID_NUMBER_HAS_TOO_MANY_DIGITS = 5;
        public static final int INVALID_NUMBER_NEEDS_PREFIX = 4;
        public static final int INVALID_NUMBER_NOT_ENOUGH_DIGITS = 7;
        public static final int INVALID_STRING = 1;
        public static final int OK = 0;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int validateAttribute(java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 2
            r4 = 1
            r5 = 3
            r6 = 0
            switch(r0) {
                case -1034364087: goto L_0x0040;
                case 75849770: goto L_0x0036;
                case 96619420: goto L_0x002c;
                case 97526364: goto L_0x0022;
                case 106642798: goto L_0x0018;
                case 1958052158: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "integer"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 5
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "phone"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 4
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "float"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 3
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "email"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "company.website"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 1
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "number"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x004a
            r8 = 2
            goto L_0x004b
        L_0x004a:
            r8 = -1
        L_0x004b:
            if (r8 == 0) goto L_0x008a
            if (r8 == r4) goto L_0x007e
            if (r8 == r3) goto L_0x0070
            if (r8 == r5) goto L_0x0062
            if (r8 == r2) goto L_0x005d
            if (r8 == r1) goto L_0x0058
            return r6
        L_0x0058:
            java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x005c }
            return r6
        L_0x005c:
            return r5
        L_0x005d:
            int r7 = io.intercom.android.sdk.utilities.PhoneNumberValidator.validatePhoneNumber(r7)
            return r7
        L_0x0062:
            java.util.regex.Pattern r8 = VALID_FLOAT_REGEX
            java.util.regex.Matcher r7 = r8.matcher(r7)
            boolean r7 = r7.matches()
            if (r7 == 0) goto L_0x006f
            r5 = 0
        L_0x006f:
            return r5
        L_0x0070:
            java.util.regex.Pattern r8 = VALID_NUMBER_REGEX
            java.util.regex.Matcher r7 = r8.matcher(r7)
            boolean r7 = r7.matches()
            if (r7 == 0) goto L_0x007d
            r5 = 0
        L_0x007d:
            return r5
        L_0x007e:
            java.util.regex.Pattern r8 = VALID_WEBSITE_REGEX
            java.util.regex.Matcher r7 = r8.matcher(r7)
            boolean r7 = r7.matches()
            r7 = r7 ^ r4
            return r7
        L_0x008a:
            java.util.regex.Pattern r8 = VALID_EMAIL_ADDRESS_REGEX
            java.util.regex.Matcher r7 = r8.matcher(r7)
            boolean r7 = r7.matches()
            if (r7 == 0) goto L_0x0097
            r3 = 0
        L_0x0097:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.utilities.AttributeValidatorUtils.validateAttribute(java.lang.String, java.lang.String):int");
    }
}
