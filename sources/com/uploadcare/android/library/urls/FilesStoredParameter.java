package com.uploadcare.android.library.urls;

import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/uploadcare/android/library/urls/FilesStoredParameter;", "Lcom/uploadcare/android/library/urls/UrlParameter;", "stored", "", "(Z)V", "getParam", "", "getValue", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UrlParameters.kt */
public final class FilesStoredParameter implements UrlParameter {
    private final boolean stored;

    public String getParam() {
        return "stored";
    }

    public FilesStoredParameter(boolean z) {
        this.stored = z;
    }

    public String getValue() {
        return this.stored ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }
}
