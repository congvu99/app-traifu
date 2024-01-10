package io.sentry.android.ndk;

import io.sentry.protocol.SdkVersion;

final class SentryNdkUtil {
    private SentryNdkUtil() {
    }

    static void addPackage(SdkVersion sdkVersion) {
        if (sdkVersion != null) {
            sdkVersion.addPackage("maven:sentry-android-ndk", "4.1.0");
        }
    }
}
