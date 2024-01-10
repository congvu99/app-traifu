package com.facebook.internal.instrument.errorreport;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "o1", "Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "kotlin.jvm.PlatformType", "o2", "compare"}, k = 3, mv = {1, 4, 0})
/* compiled from: ErrorReportHandler.kt */
final class ErrorReportHandler$sendErrorReports$1<T> implements Comparator<ErrorReportData> {
    public static final ErrorReportHandler$sendErrorReports$1 INSTANCE = new ErrorReportHandler$sendErrorReports$1();

    ErrorReportHandler$sendErrorReports$1() {
    }

    public final int compare(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
        Intrinsics.checkNotNullExpressionValue(errorReportData2, "o2");
        return errorReportData.compareTo(errorReportData2);
    }
}
