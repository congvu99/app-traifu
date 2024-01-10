package com.anggrayudi.storage.extension;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.FileUtils;
import com.anggrayudi.storage.file.StorageId;
import com.anggrayudi.storage.media.MediaFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a \u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\u001a\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003¨\u0006\u0016"}, d2 = {"isDownloadsDocument", "", "Landroid/net/Uri;", "(Landroid/net/Uri;)Z", "isExternalStorageDocument", "isMediaDocument", "isMediaFile", "isRawFile", "isTreeDocumentFile", "getStorageId", "", "context", "Landroid/content/Context;", "openInputStream", "Ljava/io/InputStream;", "openOutputStream", "Ljava/io/OutputStream;", "append", "toDocumentFile", "Landroidx/documentfile/provider/DocumentFile;", "toMediaFile", "Lcom/anggrayudi/storage/media/MediaFile;", "storage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UriExt.kt */
public final class UriUtils {
    public static final OutputStream openOutputStream(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return openOutputStream$default(uri, context, false, 2, (Object) null);
    }

    public static final String getStorageId(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        if (isRawFile(uri)) {
            return FileUtils.getStorageId(new File(path), context);
        }
        if (isExternalStorageDocument(uri)) {
            return StringsKt.substringAfterLast$default(StringsKt.substringBefore(path, (char) JsonLexerKt.COLON, ""), '/', (String) null, 2, (Object) null);
        }
        if (isDownloadsDocument(uri)) {
            return StorageId.PRIMARY;
        }
        return "";
    }

    public static final boolean isTreeDocumentFile(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String path = uri.getPath();
        return path != null && StringsKt.startsWith$default(path, "/tree/", false, 2, (Object) null);
    }

    public static final boolean isExternalStorageDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) DocumentFileCompat.EXTERNAL_STORAGE_AUTHORITY);
    }

    public static final boolean isDownloadsDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) DocumentFileCompat.DOWNLOADS_FOLDER_AUTHORITY);
    }

    public static final boolean isMediaDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) DocumentFileCompat.MEDIA_FOLDER_AUTHORITY);
    }

    public static final boolean isRawFile(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "file");
    }

    public static final boolean isMediaFile(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual((Object) uri.getAuthority(), (Object) "media");
    }

    public static final MediaFile toMediaFile(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isMediaFile(uri)) {
            return new MediaFile(context, uri);
        }
        return null;
    }

    public static final DocumentFile toDocumentFile(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return DocumentFileCompat.fromUri(context, uri);
    }

    public static /* synthetic */ OutputStream openOutputStream$default(Uri uri, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return openOutputStream(uri, context, z);
    }

    public static final OutputStream openOutputStream(Uri uri, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (isRawFile(uri)) {
                String path = uri.getPath();
                if (path == null) {
                    return null;
                }
                return new FileOutputStream(new File(path), z);
            }
            return context.getContentResolver().openOutputStream(uri, (!z || !isTreeDocumentFile(uri)) ? "w" : "wa");
        } catch (IOException unused) {
            return null;
        }
    }

    public static final InputStream openInputStream(Uri uri, Context context) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (!isRawFile(uri)) {
                return context.getContentResolver().openInputStream(uri);
            }
            String path = uri.getPath();
            if (path == null) {
                return null;
            }
            return new FileInputStream(new File(path));
        } catch (IOException unused) {
            return null;
        }
    }
}
