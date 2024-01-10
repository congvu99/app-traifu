package com.uploadcare.android.library.upload;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.uploadcare.android.library.exceptions.UploadFailureException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.MediaType;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/uploadcare/android/library/upload/UploadUtils;", "", "()V", "Companion", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadUtils.kt */
public final class UploadUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MediaType MEDIA_TYPE_TEXT_PLAIN = MediaType.Companion.parse("text/plain");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/uploadcare/android/library/upload/UploadUtils$Companion;", "", "()V", "MEDIA_TYPE_TEXT_PLAIN", "Lokhttp3/MediaType;", "getBytes", "", "inputStream", "Ljava/io/InputStream;", "getFileName", "", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getFileSize", "", "(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/Long;", "getMimeType", "contentResolver", "Landroid/content/ContentResolver;", "file", "Ljava/io/File;", "fileName", "chunkedSequence", "Lkotlin/sequences/Sequence;", "chunk", "", "library_release"}, k = 1, mv = {1, 4, 0})
    /* compiled from: UploadUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] getBytes(InputStream inputStream) {
            if (inputStream != null) {
                return ByteStreamsKt.readBytes(inputStream);
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
            kotlin.io.CloseableKt.closeFinally(r11, r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getFileName(android.net.Uri r10, android.content.Context r11) throws com.uploadcare.android.library.exceptions.UploadFailureException {
            /*
                r9 = this;
                java.lang.String r0 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                r0 = 0
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r2 = r10.getScheme()
                java.lang.String r3 = "content"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                if (r2 == 0) goto L_0x004e
                android.content.ContentResolver r3 = r11.getContentResolver()
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r4 = r10
                android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)
                java.io.Closeable r11 = (java.io.Closeable) r11
                r2 = r0
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                r3 = r11
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x0047 }
                if (r3 == 0) goto L_0x0041
                boolean r4 = r3.moveToFirst()     // Catch:{ all -> 0x0047 }
                if (r4 == 0) goto L_0x0041
                java.lang.String r1 = "_display_name"
                int r1 = r3.getColumnIndex(r1)     // Catch:{ all -> 0x0047 }
                java.lang.String r1 = r3.getString(r1)     // Catch:{ all -> 0x0047 }
            L_0x0041:
                kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0047 }
                kotlin.io.CloseableKt.closeFinally(r11, r2)
                goto L_0x004e
            L_0x0047:
                r10 = move-exception
                throw r10     // Catch:{ all -> 0x0049 }
            L_0x0049:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r11, r10)
                throw r0
            L_0x004e:
                if (r1 != 0) goto L_0x0081
                java.lang.String r1 = r10.getPath()
                r10 = -1
                if (r1 == 0) goto L_0x0065
                r2 = r1
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r3 = 47
                r4 = 0
                r5 = 0
                r6 = 6
                r7 = 0
                int r11 = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
                goto L_0x0066
            L_0x0065:
                r11 = -1
            L_0x0066:
                if (r11 == r10) goto L_0x0081
                if (r1 == 0) goto L_0x0080
                int r11 = r11 + 1
                if (r1 == 0) goto L_0x0078
                java.lang.String r0 = r1.substring(r11)
                java.lang.String r10 = "(this as java.lang.String).substring(startIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r10)
                goto L_0x0080
            L_0x0078:
                java.lang.NullPointerException r10 = new java.lang.NullPointerException
                java.lang.String r11 = "null cannot be cast to non-null type java.lang.String"
                r10.<init>(r11)
                throw r10
            L_0x0080:
                r1 = r0
            L_0x0081:
                if (r1 == 0) goto L_0x0084
                return r1
            L_0x0084:
                com.uploadcare.android.library.exceptions.UploadFailureException r10 = new com.uploadcare.android.library.exceptions.UploadFailureException
                java.lang.String r11 = "Cannot get file name, from Uri"
                r10.<init>((java.lang.String) r11)
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.upload.UploadUtils.Companion.getFileName(android.net.Uri, android.content.Context):java.lang.String");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            kotlin.io.CloseableKt.closeFinally(r10, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Long getFileSize(android.net.Uri r10, android.content.Context r11) {
            /*
                r9 = this;
                java.lang.String r0 = "uri"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                r0 = 0
                r1 = r0
                java.lang.Long r1 = (java.lang.Long) r1
                java.lang.String r2 = r10.getScheme()
                java.lang.String r3 = "content"
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
                if (r2 == 0) goto L_0x0052
                android.content.ContentResolver r3 = r11.getContentResolver()
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r4 = r10
                android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
                java.io.Closeable r10 = (java.io.Closeable) r10
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r11 = r10
                android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ all -> 0x004b }
                if (r11 == 0) goto L_0x0045
                boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x004b }
                if (r2 == 0) goto L_0x0045
                java.lang.String r1 = "_size"
                int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x004b }
                long r1 = r11.getLong(r1)     // Catch:{ all -> 0x004b }
                java.lang.Long r11 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x004b }
                r1 = r11
            L_0x0045:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
                kotlin.io.CloseableKt.closeFinally(r10, r0)
                goto L_0x0052
            L_0x004b:
                r11 = move-exception
                throw r11     // Catch:{ all -> 0x004d }
            L_0x004d:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r10, r11)
                throw r0
            L_0x0052:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uploadcare.android.library.upload.UploadUtils.Companion.getFileSize(android.net.Uri, android.content.Context):java.lang.Long");
        }

        public final MediaType getMimeType(File file) {
            if (file == null) {
                return UploadUtils.MEDIA_TYPE_TEXT_PLAIN;
            }
            return getMimeType(file.getName());
        }

        public final MediaType getMimeType(String str) {
            if (str == null) {
                return UploadUtils.MEDIA_TYPE_TEXT_PLAIN;
            }
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String substring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
            if (substring != null) {
                String lowerCase = substring.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(lowerCase);
                if (mimeTypeFromExtension == null) {
                    return UploadUtils.MEDIA_TYPE_TEXT_PLAIN;
                }
                Intrinsics.checkNotNullExpressionValue(mimeTypeFromExtension, "mime.getMimeTypeFromExte…urn MEDIA_TYPE_TEXT_PLAIN");
                return MediaType.Companion.parse(mimeTypeFromExtension);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public final MediaType getMimeType(ContentResolver contentResolver, Uri uri) {
            Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
            if (uri == null) {
                return UploadUtils.MEDIA_TYPE_TEXT_PLAIN;
            }
            if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) "content")) {
                String type = contentResolver.getType(uri);
                if (type != null) {
                    return MediaType.Companion.parse(type);
                }
                return null;
            }
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(path)).toString()));
            if (mimeTypeFromExtension == null) {
                return UploadUtils.MEDIA_TYPE_TEXT_PLAIN;
            }
            Intrinsics.checkNotNullExpressionValue(mimeTypeFromExtension, "mime.getMimeTypeFromExte…urn MEDIA_TYPE_TEXT_PLAIN");
            return MediaType.Companion.parse(mimeTypeFromExtension);
        }

        public final Sequence<byte[]> chunkedSequence(File file, int i) {
            Intrinsics.checkNotNullParameter(file, "$this$chunkedSequence");
            InputStream fileInputStream = new FileInputStream(file);
            return SequencesKt.generateSequence(new UploadUtils$Companion$chunkedSequence$1(fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192), new byte[i]));
        }

        public final Sequence<byte[]> chunkedSequence(InputStream inputStream, int i) {
            Intrinsics.checkNotNullParameter(inputStream, "$this$chunkedSequence");
            return SequencesKt.generateSequence(new UploadUtils$Companion$chunkedSequence$2(inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8192), new byte[i]));
        }

        public final Sequence<byte[]> chunkedSequence(Uri uri, Context context, int i) {
            InputStream openInputStream;
            Intrinsics.checkNotNullParameter(uri, "$this$chunkedSequence");
            Intrinsics.checkNotNullParameter(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null || (openInputStream = contentResolver.openInputStream(uri)) == null) {
                throw new UploadFailureException((Throwable) new IllegalArgumentException());
            }
            return SequencesKt.generateSequence(new UploadUtils$Companion$chunkedSequence$3(openInputStream instanceof BufferedInputStream ? (BufferedInputStream) openInputStream : new BufferedInputStream(openInputStream, 8192), new byte[i]));
        }

        public final Sequence<byte[]> chunkedSequence(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "$this$chunkedSequence");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return SequencesKt.generateSequence(new UploadUtils$Companion$chunkedSequence$4(new ByteArrayInputStream(bytes), new byte[i]));
        }

        public final Sequence<byte[]> chunkedSequence(byte[] bArr, int i) {
            Intrinsics.checkNotNullParameter(bArr, "$this$chunkedSequence");
            return SequencesKt.generateSequence(new UploadUtils$Companion$chunkedSequence$5(new ByteArrayInputStream(bArr), new byte[i]));
        }
    }
}
