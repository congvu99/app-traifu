package io.sentry.util;

import androidx.compose.material.TextFieldImplKt;
import io.sentry.ILogger;
import io.sentry.SentryLevel;

public final class LogUtils {
    public static void logIfNotFlushable(ILogger iLogger, Object obj) {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Object[] objArr = new Object[1];
        objArr[0] = obj != null ? obj.getClass().getCanonicalName() : TextFieldImplKt.PlaceholderId;
        iLogger.log(sentryLevel, "%s is not Flushable", objArr);
    }

    public static void logIfNotRetryable(ILogger iLogger, Object obj) {
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Object[] objArr = new Object[1];
        objArr[0] = obj != null ? obj.getClass().getCanonicalName() : TextFieldImplKt.PlaceholderId;
        iLogger.log(sentryLevel, "%s is not Retryable", objArr);
    }
}
