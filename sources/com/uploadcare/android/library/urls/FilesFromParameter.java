package com.uploadcare.android.library.urls;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\r"}, d2 = {"Lcom/uploadcare/android/library/urls/FilesFromParameter;", "Lcom/uploadcare/android/library/urls/UrlParameter;", "fromDate", "Ljava/util/Date;", "(Ljava/util/Date;)V", "fromSize", "", "(J)V", "(Ljava/util/Date;Ljava/lang/Long;)V", "Ljava/lang/Long;", "getParam", "", "getValue", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlParameters.kt */
public final class FilesFromParameter implements UrlParameter {
    private final Date fromDate;
    private final Long fromSize;

    public FilesFromParameter() {
        this((Date) null, (Long) null, 3, (DefaultConstructorMarker) null);
    }

    public String getParam() {
        return "from";
    }

    public FilesFromParameter(Date date, Long l) {
        this.fromDate = date;
        this.fromSize = l;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilesFromParameter(Date date, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : date, (i & 2) != 0 ? null : l);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilesFromParameter(Date date) {
        this(date, (Long) null);
        Intrinsics.checkNotNullParameter(date, "fromDate");
    }

    public FilesFromParameter(long j) {
        this((Date) null, Long.valueOf(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r0 = java.lang.String.valueOf(r0.longValue());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValue() {
        /*
            r2 = this;
            java.util.Date r0 = r2.fromDate
            if (r0 == 0) goto L_0x0012
            com.uploadcare.android.library.api.RequestHelper$Companion r0 = com.uploadcare.android.library.api.RequestHelper.Companion
            java.util.Date r1 = r2.fromDate
            java.lang.String r0 = r0.iso8601$library_release(r1)
            java.lang.String r1 = "RequestHelper.iso8601(fromDate)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            goto L_0x0023
        L_0x0012:
            java.lang.Long r0 = r2.fromSize
            if (r0 == 0) goto L_0x0021
            long r0 = r0.longValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            if (r0 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            java.lang.String r0 = "0"
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.urls.FilesFromParameter.getValue():java.lang.String");
    }
}
