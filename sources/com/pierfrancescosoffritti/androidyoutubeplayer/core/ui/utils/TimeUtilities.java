package com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/ui/utils/TimeUtilities;", "", "()V", "formatTime", "", "timeInSeconds", "", "core_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: TimeUtilities.kt */
public final class TimeUtilities {
    public static final TimeUtilities INSTANCE = new TimeUtilities();

    private TimeUtilities() {
    }

    @JvmStatic
    public static final String formatTime(float f) {
        float f2 = (float) 60;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf((int) (f / f2)), Integer.valueOf((int) (f % f2))}, 2));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
