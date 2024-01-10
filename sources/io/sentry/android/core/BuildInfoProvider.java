package io.sentry.android.core;

import android.os.Build;

public final class BuildInfoProvider implements IBuildInfoProvider {
    public int getSdkInfoVersion() {
        return Build.VERSION.SDK_INT;
    }

    public String getBuildTags() {
        return Build.TAGS;
    }
}
