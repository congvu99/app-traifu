package com.anggrayudi.storage.file;

import android.webkit.MimeTypeMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/anggrayudi/storage/file/MimeType;", "", "()V", "APPLICATION", "", "AUDIO", "BINARY_FILE", "CHEMICAL", "FONT", "IMAGE", "MODEL", "TEXT", "UNKNOWN", "VIDEO", "getExtensionFromFileName", "filename", "getExtensionFromMimeType", "mimeType", "getExtensionFromMimeTypeOrFileName", "getFullFileName", "name", "getMimeTypeFromExtension", "fileExtension", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MimeType.kt */
public final class MimeType {
    public static final String APPLICATION = "application/*";
    public static final String AUDIO = "audio/*";
    public static final String BINARY_FILE = "application/octet-stream";
    public static final String CHEMICAL = "chemical/*";
    public static final String FONT = "font/*";
    public static final String IMAGE = "image/*";
    public static final MimeType INSTANCE = new MimeType();
    public static final String MODEL = "model/*";
    public static final String TEXT = "text/*";
    public static final String UNKNOWN = "*/*";
    public static final String VIDEO = "video/*";

    private MimeType() {
    }

    @JvmStatic
    public static final String getFullFileName(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (Intrinsics.areEqual((Object) str2, (Object) "application/octet-stream")) {
            if (getExtensionFromFileName(str).length() > 0) {
                return str;
            }
        }
        String extensionFromMimeType = getExtensionFromMimeType(str2);
        if ((extensionFromMimeType.length() == 0) || StringsKt.endsWith$default(str, Intrinsics.stringPlus(".", extensionFromMimeType), false, 2, (Object) null)) {
            return str;
        }
        return StringsKt.trimEnd(str + '.' + extensionFromMimeType, '.');
    }

    @JvmStatic
    public static final String getExtensionFromMimeType(String str) {
        String extensionFromMimeType = str == null ? null : Intrinsics.areEqual((Object) str, (Object) "application/octet-stream") ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        return extensionFromMimeType == null ? "" : extensionFromMimeType;
    }

    @JvmStatic
    public static final String getExtensionFromFileName(String str) {
        String substringAfterLast = str == null ? null : StringsKt.substringAfterLast(str, '.', "");
        return substringAfterLast == null ? "" : substringAfterLast;
    }

    @JvmStatic
    public static final String getExtensionFromMimeTypeOrFileName(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "filename");
        return (str == null || Intrinsics.areEqual((Object) str, (Object) UNKNOWN)) ? getExtensionFromFileName(str2) : getExtensionFromMimeType(str);
    }

    @JvmStatic
    public static final String getMimeTypeFromExtension(String str) {
        Intrinsics.checkNotNullParameter(str, "fileExtension");
        if (Intrinsics.areEqual((Object) str, (Object) "bin")) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        return mimeTypeFromExtension == null ? UNKNOWN : mimeTypeFromExtension;
    }
}
