package io.sentry.util;

import io.sentry.hints.ApplyScopeData;
import io.sentry.hints.Cached;

public final class ApplyScopeUtils {
    private ApplyScopeUtils() {
    }

    public static boolean shouldApplyScopeData(Object obj) {
        return !(obj instanceof Cached) || (obj instanceof ApplyScopeData);
    }
}
