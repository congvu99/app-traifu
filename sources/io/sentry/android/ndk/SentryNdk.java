package io.sentry.android.ndk;

import io.sentry.android.core.SentryAndroidOptions;

public final class SentryNdk {
    private static native void initSentryNative(SentryAndroidOptions sentryAndroidOptions);

    private SentryNdk() {
    }

    static {
        System.loadLibrary("log");
        System.loadLibrary("sentry");
        System.loadLibrary("sentry-android");
    }

    public static void init(SentryAndroidOptions sentryAndroidOptions) {
        SentryNdkUtil.addPackage(sentryAndroidOptions.getSdkVersion());
        initSentryNative(sentryAndroidOptions);
        sentryAndroidOptions.addScopeObserver(new NdkScopeObserver(sentryAndroidOptions));
        sentryAndroidOptions.setDebugImagesLoader(new DebugImagesLoader(sentryAndroidOptions, new NativeModuleListLoader()));
    }
}
