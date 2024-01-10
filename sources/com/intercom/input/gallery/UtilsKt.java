package com.intercom.input.gallery;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"millisecondsToFormatTime", "", "milliseconds", "", "input-gallery_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final String millisecondsToFormatTime(long j) {
        long j2 = j / ((long) 1000);
        long j3 = (long) 60;
        long j4 = j2 % j3;
        long j5 = (j2 / j3) % j3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
