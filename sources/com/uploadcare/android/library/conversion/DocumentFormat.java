package com.uploadcare.android.library.conversion;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/uploadcare/android/library/conversion/DocumentFormat;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "PDF", "DOC", "DOCX", "XLS", "XLSX", "ODT", "ODS", "RTF", "TXT", "JPG", "ENHANCED_JPG", "PNG", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Converter.kt */
public enum DocumentFormat {
    PDF("pdf"),
    DOC("doc"),
    DOCX("docx"),
    XLS("xls"),
    XLSX("xlsx"),
    ODT("odt"),
    ODS("ods"),
    RTF("rtf"),
    TXT("txt"),
    JPG("jpg"),
    ENHANCED_JPG("enhanced.jpg"),
    PNG("png");
    
    private final String rawValue;

    private DocumentFormat(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
