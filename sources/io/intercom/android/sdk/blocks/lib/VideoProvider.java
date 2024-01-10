package io.intercom.android.sdk.blocks.lib;

import java.util.Locale;

public enum VideoProvider {
    YOUTUBE,
    VIMEO,
    WISTIA,
    LOOM,
    VIDYARD,
    UNKNOWN;

    public static VideoProvider videoValueOf(String str) {
        try {
            return valueOf(str.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException unused) {
            return UNKNOWN;
        }
    }
}