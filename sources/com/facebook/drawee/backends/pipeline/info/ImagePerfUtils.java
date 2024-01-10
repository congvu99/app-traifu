package com.facebook.drawee.backends.pipeline.info;

import io.intercom.android.sdk.metrics.MetricTracker;

public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : "canceled" : "success" : "intermediate_available" : "origin_available" : MetricTracker.Action.REQUESTED;
    }

    private ImagePerfUtils() {
    }
}
