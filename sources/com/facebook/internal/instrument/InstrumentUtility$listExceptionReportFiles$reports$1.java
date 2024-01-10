package com.facebook.internal.instrument;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "kotlin.jvm.PlatformType", "name", "", "accept"}, k = 3, mv = {1, 4, 0})
/* compiled from: InstrumentUtility.kt */
final class InstrumentUtility$listExceptionReportFiles$reports$1 implements FilenameFilter {
    public static final InstrumentUtility$listExceptionReportFiles$reports$1 INSTANCE = new InstrumentUtility$listExceptionReportFiles$reports$1();

    InstrumentUtility$listExceptionReportFiles$reports$1() {
    }

    public final boolean accept(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^(%s|%s|%s)[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.CRASH_REPORT_PREFIX, InstrumentUtility.CRASH_SHIELD_PREFIX, InstrumentUtility.THREAD_CHECK_PREFIX}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(str);
    }
}
