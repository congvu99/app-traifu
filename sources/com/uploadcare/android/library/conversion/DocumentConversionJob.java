package com.uploadcare.android.library.conversion;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0003H\u0016J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/uploadcare/android/library/conversion/DocumentConversionJob;", "Lcom/uploadcare/android/library/conversion/ConversionJob;", "fileId", "", "(Ljava/lang/String;)V", "format", "Lcom/uploadcare/android/library/conversion/DocumentFormat;", "page", "getPath", "number", "", "setFormat", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConversionJob.kt */
public final class DocumentConversionJob extends ConversionJob {
    private DocumentFormat format = DocumentFormat.PDF;
    private String page;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentConversionJob(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "fileId");
    }

    public final DocumentConversionJob setFormat(DocumentFormat documentFormat) {
        Intrinsics.checkNotNullParameter(documentFormat, "format");
        this.format = documentFormat;
        return this;
    }

    public final DocumentConversionJob page(int i) {
        if (this.format == DocumentFormat.JPG || this.format == DocumentFormat.PNG) {
            this.page = String.valueOf(i);
        }
        return this;
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(getFileId() + "/document/-/format/" + this.format.getRawValue() + '/');
        String str = this.page;
        if (str != null) {
            sb.append("-/page/" + str + '/');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
