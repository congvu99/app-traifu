package com.anggrayudi.storage.media;

import android.app.RecoverableSecurityException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.text.format.Formatter;
import androidx.core.content.FileProvider;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.extension.IOUtils;
import com.anggrayudi.storage.extension.PrimitivesExtKt;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.file.CreateMode;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.DocumentFileType;
import com.anggrayudi.storage.file.DocumentFileUtils;
import com.anggrayudi.storage.file.MimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001qB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ@\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020+2\u0006\u0010H\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020JH\u0002J$\u0010K\u001a\u00020?2\u0006\u0010L\u001a\u00020E2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010I\u001a\u00020JH\u0007J3\u0010O\u001a\u00020?2\u0006\u0010D\u001a\u00020E2\u0006\u0010I\u001a\u00020J2\u0018\u0010P\u001a\u0014\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020?0QH\bJ4\u0010R\u001a\u0004\u0018\u00010E2\u0006\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u000b2\u0006\u0010U\u001a\u00020V2\u0006\u0010I\u001a\u00020JH\u0002J\u0006\u0010W\u001a\u00020\u001aJ\u0013\u0010X\u001a\u00020\u001a2\b\u0010Y\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0010\u0010]\u001a\u00020+2\u0006\u0010\\\u001a\u00020\u000bH\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\\\u001a\u00020\u000bH\u0002J \u0010_\u001a\u00020`2\u0006\u0010L\u001a\u00020E2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020JH\u0002J\u001c\u0010a\u001a\u00020?2\u0006\u0010b\u001a\u00020c2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010d\u001a\u00020[H\u0016J$\u0010e\u001a\u00020?2\u0006\u0010L\u001a\u00020E2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010I\u001a\u00020JH\u0007J\u0010\u0010e\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u000bH\u0007J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u000bH\u0007J\n\u0010i\u001a\u0004\u0018\u00010AH\u0007J\u0014\u0010j\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010k\u001a\u00020\u001aH\u0007J\u000e\u0010l\u001a\u00020\u001a2\u0006\u0010m\u001a\u00020\u000bJ\b\u0010n\u001a\u0004\u0018\u00010EJ\n\u0010o\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010p\u001a\u00020\u000bH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0016\u0010\u0002\u001a\n \u0018*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0011\u0010\u001f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0011\u0010!\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0011\u0010#\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001cR\u0011\u0010$\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR$\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a8G@GX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001cR\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R$\u0010.\u001a\u00020+2\u0006\u0010%\u001a\u00020+8F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010-\"\u0004\b0\u00101R\u0013\u00102\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b3\u0010\rR\u0013\u00104\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b5\u0010\rR\u0013\u00106\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b7\u0010\rR\u0011\u00108\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b9\u0010\rR\u0013\u0010:\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b;\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=¨\u0006r"}, d2 = {"Lcom/anggrayudi/storage/media/MediaFile;", "", "context", "Landroid/content/Context;", "rawFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "absolutePath", "", "getAbsolutePath", "()Ljava/lang/String;", "accessCallback", "Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "getAccessCallback", "()Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "setAccessCallback", "(Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;)V", "baseName", "getBaseName", "basePath", "getBasePath", "kotlin.jvm.PlatformType", "exists", "", "getExists", "()Z", "extension", "getExtension", "formattedSize", "getFormattedSize", "fullName", "getFullName", "isEmpty", "isMine", "value", "isPending", "setPending", "(Z)V", "isRawFile", "lastModified", "", "getLastModified", "()J", "length", "getLength", "setLength", "(J)V", "mimeType", "getMimeType", "name", "getName", "owner", "getOwner", "relativePath", "getRelativePath", "type", "getType", "getUri", "()Landroid/net/Uri;", "copyFileStream", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "targetFile", "Landroidx/documentfile/provider/DocumentFile;", "watchProgress", "reportInterval", "deleteSourceFileWhenComplete", "callback", "Lcom/anggrayudi/storage/callback/FileCallback;", "copyTo", "targetFolder", "fileDescription", "Lcom/anggrayudi/storage/media/FileDescription;", "createFileStreams", "onStreamsReady", "Lkotlin/Function2;", "createTargetFile", "targetDirectory", "fileName", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "delete", "equals", "other", "getColumnInfoInt", "", "column", "getColumnInfoLong", "getColumnInfoString", "handleFileConflict", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "handleSecurityException", "e", "Ljava/lang/SecurityException;", "hashCode", "moveTo", "openFileIntent", "Landroid/content/Intent;", "authority", "openInputStream", "openOutputStream", "append", "renameTo", "newName", "toDocumentFile", "toRawFile", "toString", "AccessCallback", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaFile.kt */
public final class MediaFile {
    private AccessCallback accessCallback;
    private final Context context;
    private final Uri uri;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/anggrayudi/storage/media/MediaFile$AccessCallback;", "", "onWriteAccessDenied", "", "mediaFile", "Lcom/anggrayudi/storage/media/MediaFile;", "sender", "Landroid/content/IntentSender;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MediaFile.kt */
    public interface AccessCallback {
        void onWriteAccessDenied(MediaFile mediaFile, IntentSender intentSender);
    }

    public final OutputStream openOutputStream() {
        return openOutputStream$default(this, false, 1, (Object) null);
    }

    public MediaFile(Context context2, Uri uri2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        this.uri = uri2;
        this.context = context2.getApplicationContext();
    }

    public final Uri getUri() {
        return this.uri;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MediaFile(android.content.Context r2, java.io.File r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "rawFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.net.Uri r3 = android.net.Uri.fromFile(r3)
            java.lang.String r0 = "fromFile(rawFile)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r1.<init>((android.content.Context) r2, (android.net.Uri) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.<init>(android.content.Context, java.io.File):void");
    }

    public final AccessCallback getAccessCallback() {
        return this.accessCallback;
    }

    public final void setAccessCallback(AccessCallback accessCallback2) {
        this.accessCallback = accessCallback2;
    }

    public final String getFullName() {
        String str = "";
        if (isRawFile()) {
            File rawFile = toRawFile();
            String name = rawFile == null ? null : rawFile.getName();
            if (name == null) {
                return str;
            }
            return name;
        }
        String columnInfoString = getColumnInfoString("mime_type");
        String columnInfoString2 = getColumnInfoString("_display_name");
        if (columnInfoString2 != null) {
            str = columnInfoString2;
        }
        return MimeType.getFullFileName(str, columnInfoString);
    }

    public final String getName() {
        File rawFile = toRawFile();
        String name = rawFile == null ? null : rawFile.getName();
        return name == null ? getColumnInfoString("_display_name") : name;
    }

    public final String getBaseName() {
        return StringsKt.substringBeforeLast$default(getFullName(), '.', (String) null, 2, (Object) null);
    }

    public final String getExtension() {
        return StringsKt.substringAfterLast(getFullName(), '.', "");
    }

    public final String getType() {
        String name;
        File rawFile = toRawFile();
        String str = null;
        if (!(rawFile == null || (name = rawFile.getName()) == null)) {
            str = MimeType.getMimeTypeFromExtension(StringsKt.substringAfterLast(name, '.', ""));
        }
        return str == null ? getColumnInfoString("mime_type") : str;
    }

    public final String getMimeType() {
        if (!getExists()) {
            return null;
        }
        String columnInfoString = getColumnInfoString("mime_type");
        return columnInfoString == null ? MimeType.getMimeTypeFromExtension(getExtension()) : columnInfoString;
    }

    public final long getLength() {
        File rawFile = toRawFile();
        Long valueOf = rawFile == null ? null : Long.valueOf(rawFile.length());
        return valueOf == null ? getColumnInfoLong("_size") : valueOf.longValue();
    }

    public final void setLength(long j) {
        try {
            ContentValues contentValues = new ContentValues(1);
            contentValues.put("_size", Long.valueOf(j));
            this.context.getContentResolver().update(this.uri, contentValues, (String) null, (String[]) null);
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, (FileCallback) null, 2, (Object) null);
        }
    }

    public final String getFormattedSize() {
        String formatFileSize = Formatter.formatFileSize(this.context, getLength());
        Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(context, length)");
        return formatFileSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean getExists() {
        /*
            r4 = this;
            java.io.File r0 = r4.toRawFile()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = r1
            goto L_0x0011
        L_0x0009:
            boolean r0 = r0.exists()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0011:
            if (r0 != 0) goto L_0x0036
            android.net.Uri r0 = r4.uri
            android.content.Context r2 = r4.context
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.io.InputStream r0 = com.anggrayudi.storage.extension.UriUtils.openInputStream(r0, r2)
            if (r0 != 0) goto L_0x0024
            r0 = 0
            goto L_0x003a
        L_0x0024:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x002f }
            r2 = 1
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            r0 = 1
            goto L_0x003a
        L_0x002f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x0036:
            boolean r0 = r0.booleanValue()
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getExists():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isEmpty() {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            android.content.ContentResolver r1 = r0.getContentResolver()
            android.net.Uri r2 = r7.uri
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            r1 = 0
            if (r0 != 0) goto L_0x0014
            goto L_0x002a
        L_0x0014:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = 0
            r3 = r0
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x002b }
            int r3 = r3.getCount()     // Catch:{ all -> 0x002b }
            if (r3 <= 0) goto L_0x0027
            boolean r3 = r7.getExists()     // Catch:{ all -> 0x002b }
            if (r3 != 0) goto L_0x0027
            r1 = 1
        L_0x0027:
            kotlin.io.CloseableKt.closeFinally(r0, r2)
        L_0x002a:
            return r1
        L_0x002b:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002d }
        L_0x002d:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.isEmpty():boolean");
    }

    public final boolean isRawFile() {
        return UriUtils.isRawFile(this.uri);
    }

    public final long getLastModified() {
        File rawFile = toRawFile();
        Long valueOf = rawFile == null ? null : Long.valueOf(rawFile.lastModified());
        if (valueOf == null) {
            return getColumnInfoLong("date_modified");
        }
        return valueOf.longValue();
    }

    public final String getOwner() {
        if (Build.VERSION.SDK_INT >= 29) {
            return getColumnInfoString("owner_package_name");
        }
        return null;
    }

    public final boolean isMine() {
        return Intrinsics.areEqual((Object) getOwner(), (Object) this.context.getPackageName());
    }

    @Deprecated(message = "Accessing files with java.io.File only works on app private directory since Android 10.")
    public final File toRawFile() {
        String path;
        if (!isRawFile() || (path = this.uri.getPath()) == null) {
            return null;
        }
        return new File(path);
    }

    public final DocumentFile toDocumentFile() {
        String absolutePath = getAbsolutePath();
        if (absolutePath.length() == 0) {
            return null;
        }
        Context context2 = this.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        return DocumentFileCompat.fromFullPath$default(context2, absolutePath, (DocumentFileType) null, false, false, 28, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getAbsolutePath() {
        /*
            r11 = this;
            java.lang.String r0 = "_data"
            java.io.File r1 = r11.toRawFile()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0015
            java.lang.String r2 = r1.getPath()
            java.lang.String r0 = "file.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            goto L_0x00cd
        L_0x0015:
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            r4 = 0
            if (r1 >= r3) goto L_0x0056
            android.content.Context r1 = r11.context     // Catch:{ Exception -> 0x00cd }
            android.content.ContentResolver r5 = r1.getContentResolver()     // Catch:{ Exception -> 0x00cd }
            android.net.Uri r6 = r11.uri     // Catch:{ Exception -> 0x00cd }
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x00cd }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00cd }
            if (r1 != 0) goto L_0x0032
            goto L_0x004b
        L_0x0032:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x00cd }
            r3 = r1
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x004f }
            boolean r5 = r3.moveToFirst()     // Catch:{ all -> 0x004f }
            if (r5 == 0) goto L_0x0046
            int r0 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x004f }
            goto L_0x0047
        L_0x0046:
            r0 = r2
        L_0x0047:
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ Exception -> 0x00cd }
            r4 = r0
        L_0x004b:
            if (r4 != 0) goto L_0x00cc
            goto L_0x00cd
        L_0x004f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x00cd }
            throw r3     // Catch:{ Exception -> 0x00cd }
        L_0x0056:
            java.lang.String r0 = "relative_path"
            java.lang.String r1 = "_display_name"
            java.lang.String[] r7 = new java.lang.String[]{r0, r1}
            android.content.Context r3 = r11.context
            android.content.ContentResolver r5 = r3.getContentResolver()
            android.net.Uri r6 = r11.uri
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)
            if (r3 != 0) goto L_0x0070
            goto L_0x00c9
        L_0x0070:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r5 = r3
            android.database.Cursor r5 = (android.database.Cursor) r5     // Catch:{ all -> 0x00ce }
            boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x00ce }
            if (r6 == 0) goto L_0x00c4
            int r0 = r5.getColumnIndex(r0)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = r5.getString(r0)     // Catch:{ all -> 0x00ce }
            if (r0 != 0) goto L_0x0089
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            return r2
        L_0x0089:
            int r1 = r5.getColumnIndex(r1)     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = r5.getString(r1)     // Catch:{ all -> 0x00ce }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ce }
            r5.<init>()     // Catch:{ all -> 0x00ce }
            com.anggrayudi.storage.SimpleStorage$Companion r6 = com.anggrayudi.storage.SimpleStorage.Companion     // Catch:{ all -> 0x00ce }
            java.lang.String r6 = r6.getExternalStoragePath()     // Catch:{ all -> 0x00ce }
            r5.append(r6)     // Catch:{ all -> 0x00ce }
            r6 = 47
            r5.append(r6)     // Catch:{ all -> 0x00ce }
            r5.append(r0)     // Catch:{ all -> 0x00ce }
            r5.append(r6)     // Catch:{ all -> 0x00ce }
            r5.append(r1)     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00ce }
            r1 = 1
            char[] r1 = new char[r1]     // Catch:{ all -> 0x00ce }
            r5 = 0
            r1[r5] = r6     // Catch:{ all -> 0x00ce }
            java.lang.String r0 = kotlin.text.StringsKt.trimEnd((java.lang.String) r0, (char[]) r1)     // Catch:{ all -> 0x00ce }
            java.lang.String r1 = "//"
            java.lang.String r5 = "/"
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.replaceCompletely(r0, r1, r5)     // Catch:{ all -> 0x00ce }
            goto L_0x00c5
        L_0x00c4:
            r0 = r2
        L_0x00c5:
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            r4 = r0
        L_0x00c9:
            if (r4 != 0) goto L_0x00cc
            goto L_0x00cd
        L_0x00cc:
            r2 = r4
        L_0x00cd:
            return r2
        L_0x00ce:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getAbsolutePath():java.lang.String");
    }

    public final String getBasePath() {
        return TextUtils.trimFileSeparator(StringsKt.substringAfter$default(getAbsolutePath(), SimpleStorage.Companion.getExternalStoragePath(), (String) null, 2, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0090, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00cd, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ce, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d1, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getRelativePath() {
        /*
            r14 = this;
            java.lang.String r0 = "_data"
            java.io.File r1 = r14.toRawFile()
            java.lang.String r2 = "/"
            r3 = 2
            r4 = 47
            java.lang.String r5 = ""
            r6 = 0
            if (r1 == 0) goto L_0x0036
            java.lang.String r0 = r1.getPath()
            java.lang.String r1 = "file.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r7 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r0, (char) r4, (java.lang.String) r6, (int) r3, (java.lang.Object) r6)
            com.anggrayudi.storage.SimpleStorage$Companion r0 = com.anggrayudi.storage.SimpleStorage.Companion
            java.lang.String r8 = r0.getExternalStoragePath()
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r9 = ""
            java.lang.String r0 = kotlin.text.StringsKt.replaceFirst$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r0)
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r2)
            goto L_0x00ca
        L_0x0036:
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 29
            if (r1 >= r7) goto L_0x0095
            android.content.Context r1 = r14.context     // Catch:{ Exception -> 0x00ca }
            android.content.ContentResolver r7 = r1.getContentResolver()     // Catch:{ Exception -> 0x00ca }
            android.net.Uri r8 = r14.uri     // Catch:{ Exception -> 0x00ca }
            java.lang.String[] r9 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x00ca }
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r1 = r7.query(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x00ca }
            if (r1 != 0) goto L_0x0052
            goto L_0x008b
        L_0x0052:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x00ca }
            r7 = r1
            android.database.Cursor r7 = (android.database.Cursor) r7     // Catch:{ all -> 0x008e }
            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x008e }
            if (r8 == 0) goto L_0x0086
            int r0 = r7.getColumnIndex(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r7 = "cursor.getString(cursor.…Store.MediaColumns.DATA))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r7)     // Catch:{ all -> 0x008e }
            java.lang.String r8 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r0, (char) r4, (java.lang.String) r6, (int) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x008e }
            com.anggrayudi.storage.SimpleStorage$Companion r0 = com.anggrayudi.storage.SimpleStorage.Companion     // Catch:{ all -> 0x008e }
            java.lang.String r9 = r0.getExternalStoragePath()     // Catch:{ all -> 0x008e }
            java.lang.String r10 = ""
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r0 = kotlin.text.StringsKt.replaceFirst$default((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r0)     // Catch:{ all -> 0x008e }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r2)     // Catch:{ all -> 0x008e }
            goto L_0x0087
        L_0x0086:
            r0 = r5
        L_0x0087:
            kotlin.io.CloseableKt.closeFinally(r1, r6)     // Catch:{ Exception -> 0x00ca }
            r6 = r0
        L_0x008b:
            if (r6 != 0) goto L_0x00c9
            goto L_0x00ca
        L_0x008e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x00ca }
            throw r2     // Catch:{ Exception -> 0x00ca }
        L_0x0095:
            java.lang.String r0 = "relative_path"
            java.lang.String[] r9 = new java.lang.String[]{r0}
            android.content.Context r1 = r14.context
            android.content.ContentResolver r7 = r1.getContentResolver()
            android.net.Uri r8 = r14.uri
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r1 = r7.query(r8, r9, r10, r11, r12)
            if (r1 != 0) goto L_0x00ad
            goto L_0x00c6
        L_0x00ad:
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x00cb }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x00cb }
            if (r3 == 0) goto L_0x00c1
            int r0 = r2.getColumnIndex(r0)     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x00cb }
            goto L_0x00c2
        L_0x00c1:
            r0 = r5
        L_0x00c2:
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            r6 = r0
        L_0x00c6:
            if (r6 != 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r5 = r6
        L_0x00ca:
            return r5
        L_0x00cb:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x00cd }
        L_0x00cd:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getRelativePath():java.lang.String");
    }

    public final boolean delete() {
        File rawFile = toRawFile();
        if (rawFile == null) {
            try {
                if (this.context.getContentResolver().delete(this.uri, (String) null, (String[]) null) > 0) {
                    return true;
                }
            } catch (SecurityException e) {
                handleSecurityException$default(this, e, (FileCallback) null, 2, (Object) null);
            }
        } else if (rawFile.delete() || !rawFile.exists()) {
            return true;
        }
        return false;
    }

    public final boolean renameTo(String str) {
        Intrinsics.checkNotNullParameter(str, "newName");
        File rawFile = toRawFile();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("_display_name", str);
        if (rawFile == null) {
            try {
                if (this.context.getContentResolver().update(this.uri, contentValues, (String) null, (String[]) null) > 0) {
                    return true;
                }
            } catch (SecurityException e) {
                handleSecurityException$default(this, e, (FileCallback) null, 2, (Object) null);
            }
        } else if (!rawFile.renameTo(new File(rawFile.getParent(), str)) || this.context.getContentResolver().update(this.uri, contentValues, (String) null, (String[]) null) <= 0) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    public final boolean isPending() {
        return getColumnInfoInt("is_pending") == 1;
    }

    public final void setPending(boolean z) {
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("is_pending", Integer.valueOf(PrimitivesExtKt.toInt(Boolean.valueOf(z))));
        try {
            this.context.getContentResolver().update(this.uri, contentValues, (String) null, (String[]) null);
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, (FileCallback) null, 2, (Object) null);
        }
    }

    static /* synthetic */ void handleSecurityException$default(MediaFile mediaFile, SecurityException securityException, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileCallback = null;
        }
        mediaFile.handleSecurityException(securityException, fileCallback);
    }

    private final void handleSecurityException(SecurityException securityException, FileCallback fileCallback) {
        CoroutineScope uiScope;
        if (Build.VERSION.SDK_INT >= 29 && (securityException instanceof RecoverableSecurityException)) {
            AccessCallback accessCallback2 = this.accessCallback;
            if (accessCallback2 != null) {
                IntentSender intentSender = ((RecoverableSecurityException) securityException).getUserAction().getActionIntent().getIntentSender();
                Intrinsics.checkNotNullExpressionValue(intentSender, "e.userAction.actionIntent.intentSender");
                accessCallback2.onWriteAccessDenied(this, intentSender);
            }
        } else if (fileCallback != null && (uiScope = fileCallback.getUiScope()) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(uiScope, Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$handleSecurityException$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
        }
    }

    public final Intent openFileIntent(String str) {
        Uri uri2;
        Intrinsics.checkNotNullParameter(str, "authority");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (isRawFile()) {
            Context context2 = this.context;
            String path = this.uri.getPath();
            Intrinsics.checkNotNull(path);
            uri2 = FileProvider.getUriForFile(context2, str, new File(path));
        } else {
            uri2 = this.uri;
        }
        Intent addFlags = intent.setData(uri2).addFlags(1).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
        return addFlags;
    }

    public static /* synthetic */ OutputStream openOutputStream$default(MediaFile mediaFile, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return mediaFile.openOutputStream(z);
    }

    public final OutputStream openOutputStream(boolean z) {
        try {
            File rawFile = toRawFile();
            if (rawFile != null) {
                return new FileOutputStream(rawFile, z);
            }
            return this.context.getContentResolver().openOutputStream(this.uri, z ? "wa" : "w");
        } catch (IOException unused) {
            return null;
        }
    }

    public final InputStream openInputStream() {
        try {
            File rawFile = toRawFile();
            if (rawFile != null) {
                return new FileInputStream(rawFile);
            }
            return this.context.getContentResolver().openInputStream(this.uri);
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean moveTo(String str) {
        Intrinsics.checkNotNullParameter(str, "relativePath");
        boolean z = true;
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("relative_path", str);
        try {
            if (this.context.getContentResolver().update(this.uri, contentValues, (String) null, (String[]) null) <= 0) {
                z = false;
            }
            return z;
        } catch (SecurityException e) {
            handleSecurityException$default(this, e, (FileCallback) null, 2, (Object) null);
            return false;
        }
    }

    public static /* synthetic */ void moveTo$default(MediaFile mediaFile, DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDescription = null;
        }
        mediaFile.moveTo(documentFile, fileDescription, fileCallback);
    }

    public final void moveTo(DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback) {
        String str;
        String str2;
        DocumentFile documentFile2 = documentFile;
        FileDescription fileDescription2 = fileDescription;
        FileCallback fileCallback2 = fileCallback;
        Intrinsics.checkNotNullParameter(documentFile2, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback2, "callback");
        DocumentFile documentFile3 = toDocumentFile();
        if (documentFile3 != null) {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            DocumentFileUtils.moveFileTo(documentFile3, context2, documentFile2, fileDescription2, fileCallback2);
            return;
        }
        try {
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            Context context4 = this.context;
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            if (!fileCallback2.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context3, DocumentFileUtils.getStorageId(documentFile2, context4)), getLength())) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$moveTo$$inlined$postToUi$1((Continuation) null, fileCallback2), 2, (Object) null);
                return;
            }
            CharSequence subFolder = fileDescription2 == null ? null : fileDescription.getSubFolder();
            boolean z = true;
            String str3 = "";
            if (!(subFolder == null || subFolder.length() == 0)) {
                Context context5 = this.context;
                Intrinsics.checkNotNullExpressionValue(context5, "context");
                String subFolder2 = fileDescription2 == null ? null : fileDescription.getSubFolder();
                if (subFolder2 == null) {
                    subFolder2 = str3;
                }
                documentFile2 = DocumentFileUtils.makeFolder(documentFile2, context5, subFolder2, CreateMode.REUSE);
                if (documentFile2 == null) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$moveTo$$inlined$postToUi$3((Continuation) null, fileCallback2), 2, (Object) null);
                    return;
                }
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
            if (fileDescription2 == null) {
                str = null;
            } else {
                str = fileDescription.getName();
            }
            if (!(str == null && (str = getName()) == null)) {
                str3 = str;
            }
            String mimeType = fileDescription2 == null ? null : fileDescription.getMimeType();
            if (mimeType == null) {
                mimeType = getType();
            }
            String trimFileSeparator = TextUtils.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str3, mimeType)));
            FileCallback.ConflictResolution handleFileConflict = handleFileConflict(documentFile2, trimFileSeparator, fileCallback2);
            if (handleFileConflict != FileCallback.ConflictResolution.SKIP) {
                long longValue = ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MediaFile$moveTo$$inlined$awaitUiResult$1(fileCallback.getUiScope(), (Continuation) null, fileCallback, this, Thread.currentThread()), 1, (Object) null)).longValue();
                if (longValue <= 0) {
                    z = false;
                }
                if (fileDescription2 == null) {
                    str2 = null;
                } else {
                    try {
                        str2 = fileDescription.getMimeType();
                    } catch (SecurityException e) {
                        handleSecurityException(e, fileCallback2);
                        return;
                    } catch (Exception e2) {
                        Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$moveTo$$inlined$postToUi$4((Continuation) null, fileCallback2, e2), 2, (Object) null);
                        return;
                    }
                }
                if (str2 == null) {
                    str2 = getType();
                }
                DocumentFile createTargetFile = createTargetFile(documentFile2, trimFileSeparator, str2, handleFileConflict.toCreateMode(), fileCallback);
                if (createTargetFile != null) {
                    Context context6 = this.context;
                    Intrinsics.checkNotNullExpressionValue(context6, "context");
                    OutputStream openOutputStream$default = DocumentFileUtils.openOutputStream$default(createTargetFile, context6, false, 2, (Object) null);
                    if (openOutputStream$default == null) {
                        Job unused4 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$1((Continuation) null, fileCallback2), 2, (Object) null);
                        return;
                    }
                    InputStream openInputStream = openInputStream();
                    if (openInputStream == null) {
                        Job unused5 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$2((Continuation) null, fileCallback2), 2, (Object) null);
                        IOUtils.closeStream(openOutputStream$default);
                        return;
                    }
                    copyFileStream(openInputStream, openOutputStream$default, createTargetFile, z, longValue, true, fileCallback);
                }
            }
        } catch (Throwable unused6) {
            Job unused7 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$moveTo$$inlined$postToUi$2((Continuation) null, fileCallback2), 2, (Object) null);
        }
    }

    public static /* synthetic */ void copyTo$default(MediaFile mediaFile, DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            fileDescription = null;
        }
        mediaFile.copyTo(documentFile, fileDescription, fileCallback);
    }

    public final void copyTo(DocumentFile documentFile, FileDescription fileDescription, FileCallback fileCallback) {
        String str;
        String str2;
        DocumentFile documentFile2 = documentFile;
        FileDescription fileDescription2 = fileDescription;
        FileCallback fileCallback2 = fileCallback;
        Intrinsics.checkNotNullParameter(documentFile2, "targetFolder");
        Intrinsics.checkNotNullParameter(fileCallback2, "callback");
        DocumentFile documentFile3 = toDocumentFile();
        if (documentFile3 != null) {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            DocumentFileUtils.copyFileTo(documentFile3, context2, documentFile2, fileDescription2, fileCallback2);
            return;
        }
        try {
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            Context context4 = this.context;
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            if (!fileCallback2.onCheckFreeSpace(DocumentFileCompat.getFreeSpace(context3, DocumentFileUtils.getStorageId(documentFile2, context4)), getLength())) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$copyTo$$inlined$postToUi$1((Continuation) null, fileCallback2), 2, (Object) null);
                return;
            }
            CharSequence subFolder = fileDescription2 == null ? null : fileDescription.getSubFolder();
            boolean z = true;
            String str3 = "";
            if (!(subFolder == null || subFolder.length() == 0)) {
                Context context5 = this.context;
                Intrinsics.checkNotNullExpressionValue(context5, "context");
                String subFolder2 = fileDescription2 == null ? null : fileDescription.getSubFolder();
                if (subFolder2 == null) {
                    subFolder2 = str3;
                }
                documentFile2 = DocumentFileUtils.makeFolder(documentFile2, context5, subFolder2, CreateMode.REUSE);
                if (documentFile2 == null) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$copyTo$$inlined$postToUi$3((Continuation) null, fileCallback2), 2, (Object) null);
                    return;
                }
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.INSTANCE;
            if (fileDescription2 == null) {
                str = null;
            } else {
                str = fileDescription.getName();
            }
            if (!(str == null && (str = getName()) == null)) {
                str3 = str;
            }
            String mimeType = fileDescription2 == null ? null : fileDescription.getMimeType();
            if (mimeType == null) {
                mimeType = getType();
            }
            String trimFileSeparator = TextUtils.trimFileSeparator(documentFileCompat.removeForbiddenCharsFromFilename$storage_release(MimeType.getFullFileName(str3, mimeType)));
            FileCallback.ConflictResolution handleFileConflict = handleFileConflict(documentFile2, trimFileSeparator, fileCallback2);
            if (handleFileConflict != FileCallback.ConflictResolution.SKIP) {
                long longValue = ((Number) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MediaFile$copyTo$$inlined$awaitUiResult$1(fileCallback.getUiScope(), (Continuation) null, fileCallback, this, Thread.currentThread()), 1, (Object) null)).longValue();
                if (longValue <= 0) {
                    z = false;
                }
                if (fileDescription2 == null) {
                    str2 = null;
                } else {
                    try {
                        str2 = fileDescription.getMimeType();
                    } catch (SecurityException e) {
                        handleSecurityException(e, fileCallback2);
                        return;
                    } catch (Exception e2) {
                        Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$copyTo$$inlined$postToUi$4((Continuation) null, fileCallback2, e2), 2, (Object) null);
                        return;
                    }
                }
                if (str2 == null) {
                    str2 = getType();
                }
                DocumentFile createTargetFile = createTargetFile(documentFile2, trimFileSeparator, str2, handleFileConflict.toCreateMode(), fileCallback);
                if (createTargetFile != null) {
                    Context context6 = this.context;
                    Intrinsics.checkNotNullExpressionValue(context6, "context");
                    OutputStream openOutputStream$default = DocumentFileUtils.openOutputStream$default(createTargetFile, context6, false, 2, (Object) null);
                    if (openOutputStream$default == null) {
                        Job unused4 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$1((Continuation) null, fileCallback2), 2, (Object) null);
                        return;
                    }
                    InputStream openInputStream = openInputStream();
                    if (openInputStream == null) {
                        Job unused5 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$2((Continuation) null, fileCallback2), 2, (Object) null);
                        IOUtils.closeStream(openOutputStream$default);
                        return;
                    }
                    copyFileStream(openInputStream, openOutputStream$default, createTargetFile, z, longValue, false, fileCallback);
                }
            }
        } catch (Throwable unused6) {
            Job unused7 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$copyTo$$inlined$postToUi$2((Continuation) null, fileCallback2), 2, (Object) null);
        }
    }

    private final DocumentFile createTargetFile(DocumentFile documentFile, String str, String str2, CreateMode createMode, FileCallback fileCallback) {
        try {
            Context context2 = this.context;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            String storageId = DocumentFileUtils.getStorageId(documentFile, context3);
            Context context4 = this.context;
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            String buildAbsolutePath = DocumentFileCompat.buildAbsolutePath(context2, storageId, DocumentFileUtils.getBasePath(documentFile, context4));
            Context context5 = this.context;
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            DocumentFile mkdirs$default = DocumentFileCompat.mkdirs$default(context5, buildAbsolutePath, false, false, 12, (Object) null);
            if (mkdirs$default == null) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createTargetFile$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
                return null;
            }
            Context context6 = this.context;
            Intrinsics.checkNotNullExpressionValue(context6, "context");
            DocumentFile makeFile = DocumentFileUtils.makeFile(mkdirs$default, context6, str, str2, createMode);
            if (makeFile != null) {
                return makeFile;
            }
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createTargetFile$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
            return null;
        } catch (SecurityException e) {
            handleSecurityException(e, fileCallback);
        } catch (Exception e2) {
            Job unused3 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createTargetFile$$inlined$postToUi$3((Continuation) null, fileCallback, e2), 2, (Object) null);
        }
    }

    private final void createFileStreams(DocumentFile documentFile, FileCallback fileCallback, Function2<? super InputStream, ? super OutputStream, Unit> function2) {
        Context context2 = this.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        OutputStream openOutputStream$default = DocumentFileUtils.openOutputStream$default(documentFile, context2, false, 2, (Object) null);
        if (openOutputStream$default == null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
            return;
        }
        InputStream openInputStream = openInputStream();
        if (openInputStream == null) {
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$createFileStreams$$inlined$postToUi$2((Continuation) null, fileCallback), 2, (Object) null);
            IOUtils.closeStream(openOutputStream$default);
            return;
        }
        function2.invoke(openInputStream, openOutputStream$default);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void copyFileStream(java.io.InputStream r20, java.io.OutputStream r21, androidx.documentfile.provider.DocumentFile r22, boolean r23, long r24, boolean r26, com.anggrayudi.storage.callback.FileCallback r27) {
        /*
            r19 = this;
            r1 = r20
            r2 = 1
            r3 = 0
            kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x00a0 }
            r0.<init>()     // Catch:{ all -> 0x00a0 }
            kotlin.jvm.internal.Ref$IntRef r10 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x00a0 }
            r10.<init>()     // Catch:{ all -> 0x00a0 }
            long r6 = r19.getLength()     // Catch:{ all -> 0x00a0 }
            if (r23 == 0) goto L_0x0037
            r4 = 10485760(0xa00000, double:5.180654E-317)
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x0037
            r11 = 0
            r15 = 0
            com.anggrayudi.storage.media.MediaFile$copyFileStream$1 r13 = new com.anggrayudi.storage.media.MediaFile$copyFileStream$1     // Catch:{ all -> 0x00a0 }
            r4 = r13
            r5 = r0
            r8 = r10
            r9 = r27
            r4.<init>(r5, r6, r8, r9)     // Catch:{ all -> 0x00a0 }
            r16 = r13
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16     // Catch:{ all -> 0x00a0 }
            r17 = 5
            r18 = 0
            r13 = r24
            kotlinx.coroutines.Job r4 = com.anggrayudi.storage.extension.CoroutineExtKt.startCoroutineTimer$default(r11, r13, r15, r16, r17, r18)     // Catch:{ all -> 0x00a0 }
            goto L_0x0038
        L_0x0037:
            r4 = r3
        L_0x0038:
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x009c }
            int r6 = r1.read(r5)     // Catch:{ all -> 0x009c }
        L_0x0040:
            r7 = -1
            if (r6 == r7) goto L_0x005b
            r7 = 0
            r8 = r21
            r8.write(r5, r7, r6)     // Catch:{ all -> 0x0059 }
            long r11 = r0.element     // Catch:{ all -> 0x0059 }
            long r13 = (long) r6     // Catch:{ all -> 0x0059 }
            long r11 = r11 + r13
            r0.element = r11     // Catch:{ all -> 0x0059 }
            int r7 = r10.element     // Catch:{ all -> 0x0059 }
            int r7 = r7 + r6
            r10.element = r7     // Catch:{ all -> 0x0059 }
            int r6 = r1.read(r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0040
        L_0x0059:
            r0 = move-exception
            goto L_0x00a4
        L_0x005b:
            r8 = r21
            if (r4 != 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)     // Catch:{ all -> 0x0059 }
        L_0x0063:
            if (r26 == 0) goto L_0x0068
            r19.delete()     // Catch:{ all -> 0x0059 }
        L_0x0068:
            kotlinx.coroutines.CoroutineScope r0 = r27.getUiScope()     // Catch:{ all -> 0x0059 }
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ all -> 0x0059 }
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5     // Catch:{ all -> 0x0059 }
            r6 = 0
            com.anggrayudi.storage.media.MediaFile$copyFileStream$$inlined$postToUi$1 r7 = new com.anggrayudi.storage.media.MediaFile$copyFileStream$$inlined$postToUi$1     // Catch:{ all -> 0x0059 }
            r9 = r22
            r10 = r27
            r7.<init>(r3, r10, r9)     // Catch:{ all -> 0x0059 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ all -> 0x0059 }
            r9 = 2
            r10 = 0
            r22 = r0
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r9
            r27 = r10
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0059 }
            if (r4 != 0) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x0095:
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.InputStream) r20)
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.OutputStream) r21)
            return
        L_0x009c:
            r0 = move-exception
            r8 = r21
            goto L_0x00a4
        L_0x00a0:
            r0 = move-exception
            r8 = r21
            r4 = r3
        L_0x00a4:
            if (r4 != 0) goto L_0x00a7
            goto L_0x00aa
        L_0x00a7:
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r4, (java.util.concurrent.CancellationException) r3, (int) r2, (java.lang.Object) r3)
        L_0x00aa:
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.InputStream) r20)
            com.anggrayudi.storage.extension.IOUtils.closeStream((java.io.OutputStream) r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.copyFileStream(java.io.InputStream, java.io.OutputStream, androidx.documentfile.provider.DocumentFile, boolean, long, boolean, com.anggrayudi.storage.callback.FileCallback):void");
    }

    private final FileCallback.ConflictResolution handleFileConflict(DocumentFile documentFile, String str, FileCallback fileCallback) {
        Context context2 = this.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        DocumentFile child$default = DocumentFileUtils.child$default(documentFile, context2, str, false, 4, (Object) null);
        if (child$default == null) {
            return FileCallback.ConflictResolution.CREATE_NEW;
        }
        FileCallback.ConflictResolution conflictResolution = (FileCallback.ConflictResolution) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new MediaFile$handleFileConflict$lambda34$$inlined$awaitUiResultWithPending$1(fileCallback.getUiScope(), (Continuation) null, fileCallback, child$default), 1, (Object) null);
        if (conflictResolution == FileCallback.ConflictResolution.REPLACE) {
            Context context3 = this.context;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            if (!DocumentFileUtils.forceDelete$default(child$default, context3, false, 2, (Object) null)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(fileCallback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$handleFileConflict$lambda34$$inlined$postToUi$1((Continuation) null, fileCallback), 2, (Object) null);
                return FileCallback.ConflictResolution.SKIP;
            }
        }
        return conflictResolution;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getColumnInfoString(java.lang.String r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            android.content.ContentResolver r1 = r0.getContentResolver()
            android.net.Uri r2 = r7.uri
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            r3[r0] = r8
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            r1 = 0
            if (r0 != 0) goto L_0x0019
            goto L_0x0038
        L_0x0019:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x0039 }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0033
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x0039 }
            r3 = -1
            if (r8 == r3) goto L_0x0033
            java.lang.String r8 = r2.getString(r8)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r8
        L_0x0033:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
        L_0x0038:
            return r1
        L_0x0039:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003b }
        L_0x003b:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getColumnInfoString(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long getColumnInfoLong(java.lang.String r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            android.content.ContentResolver r1 = r0.getContentResolver()
            android.net.Uri r2 = r7.uri
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            r3[r0] = r8
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0018
            goto L_0x0038
        L_0x0018:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x003b }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0033
            int r8 = r2.getColumnIndex(r8)     // Catch:{ all -> 0x003b }
            r3 = -1
            if (r8 == r3) goto L_0x0033
            long r2 = r2.getLong(r8)     // Catch:{ all -> 0x003b }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r2
        L_0x0033:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003b }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
        L_0x0038:
            r0 = 0
            return r0
        L_0x003b:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003d }
        L_0x003d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getColumnInfoLong(java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int getColumnInfoInt(java.lang.String r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            android.content.ContentResolver r1 = r0.getContentResolver()
            android.net.Uri r2 = r7.uri
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            r3[r0] = r8
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x0018
            goto L_0x0038
        L_0x0018:
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = 0
            r3 = r1
            android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x0039 }
            boolean r4 = r3.moveToFirst()     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0033
            int r8 = r3.getColumnIndex(r8)     // Catch:{ all -> 0x0039 }
            r4 = -1
            if (r8 == r4) goto L_0x0033
            int r8 = r3.getInt(r8)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            return r8
        L_0x0033:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)
        L_0x0038:
            return r0
        L_0x0039:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaFile.getColumnInfoInt(java.lang.String):int");
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof MediaFile) && Intrinsics.areEqual((Object) ((MediaFile) obj).uri, (Object) this.uri));
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        String uri2 = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return uri2;
    }
}
