package com.github.scribejava.core.utils;

import com.github.scribejava.core.model.OAuthConstants;
import java.util.Locale;
import java.util.regex.Pattern;

public abstract class Preconditions {
    private static final String DEFAULT_MESSAGE = "Received an invalid parameter";
    private static final String URL_REGEXP = "^[a-zA-Z][a-zA-Z0-9+.-]*://\\S+";

    public static void checkNotNull(Object obj, String str) {
        check(obj != null, str);
    }

    public static void checkEmptyString(String str, String str2) {
        check(str != null && !str.trim().isEmpty(), str2);
    }

    public static void checkValidUrl(String str, String str2) {
        checkEmptyString(str, str2);
        check(isUrl(str), str2);
    }

    public static void checkValidOAuthCallback(String str, String str2) {
        checkEmptyString(str, str2);
        if (str.toLowerCase(Locale.getDefault()).compareToIgnoreCase(OAuthConstants.OUT_OF_BAND) != 0) {
            check(isUrl(str), str2);
        }
    }

    private static boolean isUrl(String str) {
        return Pattern.compile(URL_REGEXP).matcher(str).matches();
    }

    private static void check(boolean z, String str) {
        if (!z) {
            if (str == null || str.trim().length() <= 0) {
                str = DEFAULT_MESSAGE;
            }
            throw new IllegalArgumentException(str);
        }
    }
}
