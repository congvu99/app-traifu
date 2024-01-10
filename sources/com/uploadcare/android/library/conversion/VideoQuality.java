package com.uploadcare.android.library.conversion;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/uploadcare/android/library/conversion/VideoQuality;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "NORMAL", "BETTER", "BEST", "LIGHTER", "LIGHTEST", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: Converter.kt */
public enum VideoQuality {
    NORMAL("normal"),
    BETTER("better"),
    BEST("best"),
    LIGHTER("lighter"),
    LIGHTEST("lightest");
    
    private final String rawValue;

    private VideoQuality(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
