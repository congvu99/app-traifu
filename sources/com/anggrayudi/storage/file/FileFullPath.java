package com.anggrayudi.storage.file;

import android.content.Context;
import android.net.Uri;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/anggrayudi/storage/file/FileFullPath;", "", "context", "Landroid/content/Context;", "fullPath", "", "(Landroid/content/Context;Ljava/lang/String;)V", "storageId", "basePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Landroid/content/Context;Ljava/io/File;)V", "absolutePath", "getAbsolutePath", "()Ljava/lang/String;", "getBasePath", "simplePath", "getSimplePath", "getStorageId", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileFullPath.kt */
public final class FileFullPath {
    private final String absolutePath;
    private final String basePath;
    private final String simplePath;
    private final String storageId;

    public final String getAbsolutePath() {
        return this.absolutePath;
    }

    public final String getSimplePath() {
        return this.simplePath;
    }

    public final String getStorageId() {
        return this.storageId;
    }

    public final String getBasePath() {
        return this.basePath;
    }

    public FileFullPath(Context context, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        if (!StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            this.simplePath = str;
            this.storageId = StringsKt.substringAfterLast$default(StringsKt.substringBefore(str, (char) JsonLexerKt.COLON, ""), '/', (String) null, 2, (Object) null);
            this.basePath = TextUtils.trimFileSeparator(StringsKt.substringAfter(str, (char) JsonLexerKt.COLON, ""));
            String str3 = this.storageId;
            if (Intrinsics.areEqual((Object) str3, (Object) StorageId.PRIMARY)) {
                str2 = StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + '/' + this.basePath, '/');
            } else if (Intrinsics.areEqual((Object) str3, (Object) "data")) {
                str2 = StringsKt.trimEnd(FileUtils.getDataDirectory(context).getPath() + '/' + this.basePath, '/');
            } else {
                str2 = StringsKt.trimEnd("/storage/" + this.storageId + '/' + this.basePath, '/');
            }
            this.absolutePath = str2;
        } else if (StringsKt.startsWith$default(str, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
            this.storageId = StorageId.PRIMARY;
            String externalStoragePath = SimpleStorage.Companion.getExternalStoragePath();
            this.basePath = TextUtils.trimFileSeparator(StringsKt.substringAfter(str, externalStoragePath, ""));
            this.simplePath = this.storageId + JsonLexerKt.COLON + this.basePath;
            this.absolutePath = StringsKt.trimEnd(externalStoragePath + '/' + this.basePath, '/');
        } else {
            String path = FileUtils.getDataDirectory(context).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.dataDirectory.path");
            if (StringsKt.startsWith$default(str, path, false, 2, (Object) null)) {
                this.storageId = "data";
                String path2 = FileUtils.getDataDirectory(context).getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "dataPath");
                this.basePath = TextUtils.trimFileSeparator(StringsKt.substringAfter(str, path2, ""));
                this.simplePath = this.storageId + JsonLexerKt.COLON + this.basePath;
                this.absolutePath = StringsKt.trimEnd(path2 + '/' + this.basePath, '/');
                return;
            }
            String substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter(str, "/storage/", ""), '/', (String) null, 2, (Object) null);
            this.storageId = substringBefore$default;
            this.basePath = TextUtils.trimFileSeparator(StringsKt.substringAfter(str, Intrinsics.stringPlus("/storage/", substringBefore$default), ""));
            this.simplePath = this.storageId + JsonLexerKt.COLON + this.basePath;
            this.absolutePath = StringsKt.trimEnd("/storage/" + this.storageId + '/' + this.basePath, '/');
        }
    }

    public FileFullPath(Context context, String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        this.storageId = str;
        this.basePath = TextUtils.trimFileSeparator(str2);
        this.simplePath = str + JsonLexerKt.COLON + str2;
        if (Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY)) {
            str3 = StringsKt.trimEnd(SimpleStorage.Companion.getExternalStoragePath() + '/' + str2, '/');
        } else if (Intrinsics.areEqual((Object) str, (Object) "data")) {
            str3 = StringsKt.trimEnd(FileUtils.getDataDirectory(context).getPath() + '/' + str2, '/');
        } else {
            str3 = StringsKt.trimEnd("/storage/" + str + '/' + str2, '/');
        }
        this.absolutePath = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FileFullPath(android.content.Context r2, java.io.File r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r3.getPath()
            if (r3 != 0) goto L_0x0012
            java.lang.String r3 = ""
        L_0x0012:
            r1.<init>((android.content.Context) r2, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileFullPath.<init>(android.content.Context, java.io.File):void");
    }

    public final Uri getUri() {
        return DocumentFileCompat.createDocumentUri(this.storageId, this.basePath);
    }
}
