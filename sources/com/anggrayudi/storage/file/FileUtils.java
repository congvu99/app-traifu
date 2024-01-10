package com.anggrayudi.storage.file;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.extension.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000b\u001a\u0012\u0010\u0014\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a$\u0010\u0016\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000b\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010\u001c\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u001f\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010 \u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a \u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020%*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u001a\u0010'\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0001\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010*\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010+\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010,\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a4\u0010-\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a(\u00101\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a\n\u00107\u001a\u00020\u0006*\u00020\u0001\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u001e\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0014\u0010:\u001a\u0004\u0018\u00010;*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\n\u0010<\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u0001H\u0002\u001a\u001c\u0010?\u001a\u00020@*\u00020\u00012\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006C"}, d2 = {"dataDirectory", "Ljava/io/File;", "Landroid/content/Context;", "getDataDirectory", "(Landroid/content/Context;)Ljava/io/File;", "inPrimaryStorage", "", "getInPrimaryStorage", "(Ljava/io/File;)Z", "isEmpty", "mimeType", "", "getMimeType", "(Ljava/io/File;)Ljava/lang/String;", "writableDirs", "", "getWritableDirs", "(Landroid/content/Context;)Ljava/util/Set;", "autoIncrementFileName", "filename", "canModify", "context", "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "createNewFileIfPossible", "deleteEmptyFolders", "forceDelete", "childrenOnly", "getBasePath", "getRootPath", "getRootRawFile", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "inDataStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isExternalStorageManager", "isReadOnly", "isWritable", "makeFile", "name", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "makeFolder", "moveTo", "targetFolder", "newFileNameInTarget", "conflictResolution", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "recreateFile", "shouldWritable", "takeIfWritable", "toDocumentFile", "Landroidx/documentfile/provider/DocumentFile;", "tryCreateNewFile", "walkFileTreeAndDeleteEmptyFolders", "", "walkFileTreeForMove", "", "srcPath", "destFolderPath", "storage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileExt.kt */
public final class FileUtils {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileExt.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileCallback.ConflictResolution.values().length];
            iArr[FileCallback.ConflictResolution.SKIP.ordinal()] = 1;
            iArr[FileCallback.ConflictResolution.REPLACE.ordinal()] = 2;
            iArr[FileCallback.ConflictResolution.CREATE_NEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean forceDelete(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return forceDelete$default(file, false, 1, (Object) null);
    }

    public static final File getRootRawFile(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getRootRawFile$default(file, context, false, 2, (Object) null);
    }

    public static final File makeFile(File file, Context context, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFile$default(file, context, str, (String) null, (CreateMode) null, 12, (Object) null);
    }

    public static final File makeFile(File file, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFile$default(file, context, str, str2, (CreateMode) null, 8, (Object) null);
    }

    public static final File makeFolder(File file, Context context, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        return makeFolder$default(file, context, str, (CreateMode) null, 4, (Object) null);
    }

    public static final File moveTo(File file, Context context, File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file2, "targetFolder");
        return moveTo$default(file, context, file2, (String) null, (FileCallback.ConflictResolution) null, 12, (Object) null);
    }

    public static final File moveTo(File file, Context context, File file2, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file2, "targetFolder");
        return moveTo$default(file, context, file2, str, (FileCallback.ConflictResolution) null, 8, (Object) null);
    }

    public static final File moveTo(File file, Context context, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "targetFolder");
        return moveTo$default(file, context, str, (String) null, (FileCallback.ConflictResolution) null, 12, (Object) null);
    }

    public static final File moveTo(File file, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "targetFolder");
        return moveTo$default(file, context, str, str2, (FileCallback.ConflictResolution) null, 8, (Object) null);
    }

    public static final String getStorageId(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
            return StorageId.PRIMARY;
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String path3 = getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "context.dataDirectory.path");
        if (StringsKt.startsWith$default(path2, path3, false, 2, (Object) null)) {
            return "data";
        }
        String path4 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "path");
        return StringsKt.substringBefore$default(StringsKt.substringAfter(path4, "/storage/", ""), '/', (String) null, 2, (Object) null);
    }

    public static final boolean getInPrimaryStorage(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null);
    }

    public static final boolean inDataStorage(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String path2 = getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "context.dataDirectory.path");
        return StringsKt.startsWith$default(path, path2, false, 2, (Object) null);
    }

    public static final boolean inSdCardStorage(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(file, context);
        if (Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId, (Object) "data")) {
            return false;
        }
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        return StringsKt.startsWith$default(path, Intrinsics.stringPlus("/storage/", storageId), false, 2, (Object) null);
    }

    public static final boolean inSameMountPointWith(File file, Context context, File file2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file2, "file");
        String storageId = getStorageId(file, context);
        String storageId2 = getStorageId(file2, context);
        return Intrinsics.areEqual((Object) storageId, (Object) storageId2) || ((Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId, (Object) "data")) && (Intrinsics.areEqual((Object) storageId2, (Object) StorageId.PRIMARY) || Intrinsics.areEqual((Object) storageId2, (Object) "data")));
    }

    public static final StorageType getStorageType(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (getInPrimaryStorage(file)) {
            return StorageType.EXTERNAL;
        }
        if (inDataStorage(file, context)) {
            return StorageType.DATA;
        }
        if (inSdCardStorage(file, context)) {
            return StorageType.SD_CARD;
        }
        return StorageType.UNKNOWN;
    }

    public static final File child(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(str, "path");
        return new File(file, str);
    }

    public static final File getDataDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT > 23) {
            File dataDir = context.getDataDir();
            Intrinsics.checkNotNullExpressionValue(dataDir, "dataDir");
            return dataDir;
        }
        File parentFile = context.getFilesDir().getParentFile();
        Intrinsics.checkNotNull(parentFile);
        return parentFile;
    }

    public static final String getBasePath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String externalStoragePath = SimpleStorage.Companion.getExternalStoragePath();
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (StringsKt.startsWith$default(path, externalStoragePath, false, 2, (Object) null)) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "path");
            return TextUtils.trimFileSeparator(StringsKt.substringAfter(path2, externalStoragePath, ""));
        }
        String path3 = getDataDirectory(context).getPath();
        String path4 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "path");
        Intrinsics.checkNotNullExpressionValue(path3, "dataDir");
        if (StringsKt.startsWith$default(path4, path3, false, 2, (Object) null)) {
            String path5 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path5, "path");
            return TextUtils.trimFileSeparator(StringsKt.substringAfter(path5, path3, ""));
        }
        String storageId = getStorageId(file, context);
        String path6 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path6, "path");
        return TextUtils.trimFileSeparator(StringsKt.substringAfter(path6, Intrinsics.stringPlus("/storage/", storageId), ""));
    }

    public static final String getRootPath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String storageId = getStorageId(file, context);
        if (Intrinsics.areEqual((Object) storageId, (Object) StorageId.PRIMARY)) {
            return SimpleStorage.Companion.getExternalStoragePath();
        }
        if (Intrinsics.areEqual((Object) storageId, (Object) "data")) {
            String path = getDataDirectory(context).getPath();
            Intrinsics.checkNotNullExpressionValue(path, "context.dataDirectory.path");
            return path;
        }
        return storageId.length() > 0 ? Intrinsics.stringPlus("/storage/", storageId) : "";
    }

    public static final String getSimplePath(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return StringsKt.removePrefix(getStorageId(file, context) + JsonLexerKt.COLON + getBasePath(file, context), (CharSequence) CertificateUtil.DELIMITER);
    }

    public static final String getMimeType(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        if (file.isFile()) {
            return MimeType.getMimeTypeFromExtension(FilesKt.getExtension(file));
        }
        return null;
    }

    public static final File getRootRawFile(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String rootPath = getRootPath(file, context);
        if (rootPath.length() == 0) {
            return null;
        }
        File file2 = new File(rootPath);
        if (file2.canRead()) {
            return takeIfWritable(file2, context, z);
        }
        return null;
    }

    public static /* synthetic */ File getRootRawFile$default(File file, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return getRootRawFile(file, context, z);
    }

    public static final boolean isReadOnly(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && !isWritable(file, context);
    }

    public static final boolean canModify(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && isWritable(file, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEmpty(java.io.File r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.isFile()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            long r3 = r7.length()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0033
        L_0x0017:
            boolean r0 = r7.isDirectory()
            if (r0 == 0) goto L_0x0032
            java.lang.String[] r7 = r7.list()
            if (r7 == 0) goto L_0x002e
            int r7 = r7.length
            if (r7 != 0) goto L_0x0028
            r7 = 1
            goto L_0x0029
        L_0x0028:
            r7 = 0
        L_0x0029:
            if (r7 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r7 = 0
            goto L_0x002f
        L_0x002e:
            r7 = 1
        L_0x002f:
            if (r7 == 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.isEmpty(java.io.File):boolean");
    }

    public static final boolean shouldWritable(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return (z && isWritable(file, context)) || !z;
    }

    public static final File takeIfWritable(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (shouldWritable(file, context, z)) {
            return file;
        }
        return null;
    }

    public static final boolean checkRequirements(File file, Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canRead() && (z2 || isExternalStorageManager(file, context)) && shouldWritable(file, context, z);
    }

    public static final boolean createNewFileIfPossible(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            return file.isFile() || file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public static final boolean isWritable(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return file.canWrite() && (file.isFile() || isExternalStorageManager(file, context));
    }

    public static final boolean isExternalStorageManager(File file, Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT > 29 && Environment.isExternalStorageManager(file)) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 29) {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "path");
            if (StringsKt.startsWith$default(path, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null) && SimpleStorage.Companion.hasStoragePermission(context)) {
                return true;
            }
        }
        Iterable writableDirs = getWritableDirs(context);
        if (!(writableDirs instanceof Collection) || !((Collection) writableDirs).isEmpty()) {
            Iterator it = writableDirs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String path2 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "path");
                String path3 = ((File) it.next()).getPath();
                Intrinsics.checkNotNullExpressionValue(path3, "it.path");
                if (StringsKt.startsWith$default(path2, path3, false, 2, (Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return true;
        }
        return false;
    }

    public static final Set<File> getWritableDirs(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i = 0;
        Set<File> mutableSetOf = SetsKt.mutableSetOf(getDataDirectory(context));
        File[] obbDirs = ContextCompat.getObbDirs(context);
        Intrinsics.checkNotNullExpressionValue(obbDirs, "getObbDirs(this)");
        mutableSetOf.addAll(ArraysKt.filterNotNull((Object[]) obbDirs));
        File[] externalFilesDirs = ContextCompat.getExternalFilesDirs(context, (String) null);
        Intrinsics.checkNotNullExpressionValue(externalFilesDirs, "getExternalFilesDirs(this, null)");
        Object[] objArr = (Object[]) externalFilesDirs;
        Collection arrayList = new ArrayList();
        int length = objArr.length;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            File file = (File) obj;
            File parentFile = file == null ? null : file.getParentFile();
            if (parentFile != null) {
                arrayList.add(parentFile);
            }
        }
        mutableSetOf.addAll((List) arrayList);
        return mutableSetOf;
    }

    public static /* synthetic */ File makeFile$default(File file, Context context, String str, String str2, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = MimeType.UNKNOWN;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFile(file, context, str, str2, createMode);
    }

    public static final File makeFile(File file, Context context, String str, String str2, CreateMode createMode) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        if (!file.isDirectory() || !isWritable(file, context)) {
            return null;
        }
        String trimFileSeparator = TextUtils.trimFileSeparator(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(str));
        String substringBeforeLast = StringsKt.substringBeforeLast(trimFileSeparator, '/', "");
        if (substringBeforeLast.length() == 0) {
            file2 = file;
        } else {
            file2 = new File(file, substringBeforeLast);
            file2.mkdirs();
        }
        String substringAfterLast$default = StringsKt.substringAfterLast$default(trimFileSeparator, '/', (String) null, 2, (Object) null);
        String substringAfterLast = StringsKt.substringAfterLast(trimFileSeparator, '.', "");
        if (!(substringAfterLast.length() > 0) || (str2 != null && !Intrinsics.areEqual((Object) str2, (Object) MimeType.UNKNOWN) && !Intrinsics.areEqual((Object) str2, (Object) "application/octet-stream"))) {
            substringAfterLast = MimeType.getExtensionFromMimeTypeOrFileName(str2, trimFileSeparator);
        }
        String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", substringAfterLast));
        String trimEnd = StringsKt.trimEnd(removeSuffix + '.' + substringAfterLast, '.');
        if (createMode != CreateMode.CREATE_NEW) {
            File file3 = new File(file2, trimEnd);
            if (file3.exists()) {
                if (createMode == CreateMode.REPLACE) {
                    if (!recreateFile(file3)) {
                        return null;
                    }
                } else if (!file3.isFile()) {
                    return null;
                }
                return file3;
            }
        }
        try {
            File file4 = new File(file2, autoIncrementFileName(file, trimEnd));
            if (file4.createNewFile()) {
                return file4;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static /* synthetic */ File makeFolder$default(File file, Context context, String str, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return makeFolder(file, context, str, createMode);
    }

    public static final File makeFolder(File file, Context context, String str, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        if (!file.isDirectory() || !isWritable(file, context)) {
            return null;
        }
        List mutableList = CollectionsKt.toMutableList(DocumentFileCompat.INSTANCE.getDirectorySequence$storage_release(DocumentFileCompat.INSTANCE.removeForbiddenCharsFromFilename$storage_release(str)));
        String str2 = (String) CollectionsKt.removeFirstOrNull(mutableList);
        if (str2 == null) {
            return null;
        }
        if (createMode == CreateMode.CREATE_NEW) {
            str2 = autoIncrementFileName(file, str2);
        }
        File child = child(file, str2);
        if (createMode == CreateMode.REPLACE) {
            forceDelete(child, true);
        }
        child.mkdir();
        if (!mutableList.isEmpty()) {
            child = child(child, CollectionsKt.joinToString$default(mutableList, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            child.mkdirs();
        }
        if (child.isDirectory()) {
            return child;
        }
        return null;
    }

    public static final DocumentFile toDocumentFile(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (file.canRead()) {
            return DocumentFileCompat.fromFile$default(context, file, (DocumentFileType) null, false, false, 28, (Object) null);
        }
        return null;
    }

    public static final boolean deleteEmptyFolders(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!file.isDirectory() || !isWritable(file, context)) {
            return false;
        }
        for (File delete : CollectionsKt.reversed(walkFileTreeAndDeleteEmptyFolders(file))) {
            delete.delete();
        }
        return true;
    }

    private static final List<File> walkFileTreeAndDeleteEmptyFolders(File file) {
        List<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int i = 0;
            int length = listFiles.length;
            while (i < length) {
                File file2 = listFiles[i];
                i++;
                if (file2.isDirectory() && !file2.delete()) {
                    Intrinsics.checkNotNullExpressionValue(file2, "it");
                    arrayList.add(file2);
                    arrayList.addAll(walkFileTreeAndDeleteEmptyFolders(file2));
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ boolean forceDelete$default(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return forceDelete(file, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean forceDelete(java.io.File r3, boolean r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3.isDirectory()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0033
            boolean r0 = kotlin.io.FilesKt.deleteRecursively(r3)
            if (r4 == 0) goto L_0x0031
            r3.mkdir()
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L_0x0040
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L_0x002d
            int r3 = r3.length
            if (r3 != 0) goto L_0x0027
            r3 = 1
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            if (r3 == 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = 0
            goto L_0x002e
        L_0x002d:
            r3 = 1
        L_0x002e:
            if (r3 == 0) goto L_0x0040
            goto L_0x003f
        L_0x0031:
            r1 = r0
            goto L_0x0040
        L_0x0033:
            boolean r4 = r3.delete()
            if (r4 != 0) goto L_0x003f
            boolean r3 = r3.exists()
            if (r3 != 0) goto L_0x0040
        L_0x003f:
            r1 = 1
        L_0x0040:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.forceDelete(java.io.File, boolean):boolean");
    }

    public static final boolean recreateFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        forceDelete$default(file, false, 1, (Object) null);
        return tryCreateNewFile(file);
    }

    public static final boolean tryCreateNewFile(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0069, code lost:
        if (com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION().matches(r3) == false) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0072 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String autoIncrementFileName(java.io.File r16, java.lang.String r17) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "filename"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.io.File r1 = child(r16, r17)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0109
            r1 = 46
            r3 = 0
            r4 = 2
            java.lang.String r5 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r0, (char) r1, (java.lang.String) r3, (int) r4, (java.lang.Object) r3)
            java.lang.String r6 = ""
            java.lang.String r0 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r0, (char) r1, (java.lang.String) r6)
            java.lang.String r7 = " ("
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r7)
            java.lang.String[] r2 = r16.list()
            r9 = 0
            if (r2 != 0) goto L_0x0035
            java.lang.String[] r2 = new java.lang.String[r9]
        L_0x0035:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            int r11 = r2.length
            r12 = 0
        L_0x003e:
            java.lang.String r13 = "it"
            r14 = 1
            if (r12 >= r11) goto L_0x0074
            r15 = r2[r12]
            int r12 = r12 + 1
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r13)
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r15, r8, r9, r4, r3)
            if (r13 == 0) goto L_0x006c
            com.anggrayudi.storage.file.DocumentFileCompat r13 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r13 = r13.getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION()
            r3 = r15
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r13 = r13.matches(r3)
            if (r13 != 0) goto L_0x006d
            com.anggrayudi.storage.file.DocumentFileCompat r13 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r13 = r13.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION()
            boolean r3 = r13.matches(r3)
            if (r3 == 0) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r14 = 0
        L_0x006d:
            if (r14 == 0) goto L_0x0072
            r10.add(r15)
        L_0x0072:
            r3 = 0
            goto L_0x003e
        L_0x0074:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r2 = r10.iterator()
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x0084
            r3 = 0
            goto L_0x00dc
        L_0x0084:
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 40
            java.lang.String r3 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r3, (char) r4, (java.lang.String) r6)
            r8 = 41
            java.lang.String r3 = kotlin.text.StringsKt.substringBefore((java.lang.String) r3, (char) r8, (java.lang.String) r6)
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            if (r3 != 0) goto L_0x00a1
            r3 = 0
            goto L_0x00a5
        L_0x00a1:
            int r3 = r3.intValue()
        L_0x00a5:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
        L_0x00ab:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L_0x00dc
            java.lang.Object r10 = r2.next()
            java.lang.String r10 = (java.lang.String) r10
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
            java.lang.String r10 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r10, (char) r4, (java.lang.String) r6)
            java.lang.String r10 = kotlin.text.StringsKt.substringBefore((java.lang.String) r10, (char) r8, (java.lang.String) r6)
            java.lang.Integer r10 = kotlin.text.StringsKt.toIntOrNull(r10)
            if (r10 != 0) goto L_0x00ca
            r10 = 0
            goto L_0x00ce
        L_0x00ca:
            int r10 = r10.intValue()
        L_0x00ce:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Comparable r10 = (java.lang.Comparable) r10
            int r11 = r3.compareTo(r10)
            if (r11 >= 0) goto L_0x00ab
            r3 = r10
            goto L_0x00ab
        L_0x00dc:
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 != 0) goto L_0x00e2
            r2 = 0
            goto L_0x00e6
        L_0x00e2:
            int r2 = r3.intValue()
        L_0x00e6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r7)
            int r2 = r2 + r14
            r3.append(r2)
            java.lang.String r2 = ")."
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            char[] r2 = new char[r14]
            r2[r9] = r1
            java.lang.String r0 = kotlin.text.StringsKt.trimEnd((java.lang.String) r0, (char[]) r2)
        L_0x0109:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.autoIncrementFileName(java.io.File, java.lang.String):java.lang.String");
    }

    public static /* synthetic */ File moveTo$default(File file, Context context, String str, String str2, FileCallback.ConflictResolution conflictResolution, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            conflictResolution = FileCallback.ConflictResolution.CREATE_NEW;
        }
        return moveTo(file, context, str, str2, conflictResolution);
    }

    public static final File moveTo(File file, Context context, String str, String str2, FileCallback.ConflictResolution conflictResolution) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "targetFolder");
        Intrinsics.checkNotNullParameter(conflictResolution, "conflictResolution");
        return moveTo(file, context, new File(str), str2, conflictResolution);
    }

    public static /* synthetic */ File moveTo$default(File file, Context context, File file2, String str, FileCallback.ConflictResolution conflictResolution, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            conflictResolution = FileCallback.ConflictResolution.CREATE_NEW;
        }
        return moveTo(file, context, file2, str, conflictResolution);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (forceDelete$default(r0, false, 1, (java.lang.Object) null) == false) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File moveTo(java.io.File r4, android.content.Context r5, java.io.File r6, java.lang.String r7, com.anggrayudi.storage.callback.FileCallback.ConflictResolution r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "targetFolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "conflictResolution"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 == 0) goto L_0x00b9
            boolean r0 = isWritable(r4, r5)
            if (r0 != 0) goto L_0x0023
            goto L_0x00b9
        L_0x0023:
            r6.mkdirs()
            boolean r0 = r6.isDirectory()
            if (r0 == 0) goto L_0x00b9
            boolean r0 = isWritable(r6, r5)
            if (r0 != 0) goto L_0x0034
            goto L_0x00b9
        L_0x0034:
            if (r7 != 0) goto L_0x003a
            java.lang.String r7 = r4.getName()
        L_0x003a:
            java.lang.String r0 = "filename"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.io.File r0 = child(r6, r7)
            java.lang.String r2 = r4.getParent()
            java.lang.String r3 = r6.getPath()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0059
            boolean r4 = r4.renameTo(r0)
            if (r4 == 0) goto L_0x0058
            r1 = r0
        L_0x0058:
            return r1
        L_0x0059:
            boolean r5 = inSameMountPointWith(r4, r5, r6)
            if (r5 != 0) goto L_0x0060
            return r1
        L_0x0060:
            boolean r5 = r0.exists()
            r2 = 1
            if (r5 == 0) goto L_0x0089
            int[] r5 = com.anggrayudi.storage.file.FileUtils.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r5 = r5[r8]
            if (r5 == r2) goto L_0x0088
            r8 = 2
            if (r5 == r8) goto L_0x0081
            r8 = 3
            if (r5 == r8) goto L_0x0078
            goto L_0x0089
        L_0x0078:
            java.lang.String r5 = autoIncrementFileName(r6, r7)
            java.io.File r0 = child(r6, r5)
            goto L_0x0089
        L_0x0081:
            r5 = 0
            boolean r5 = forceDelete$default(r0, r5, r2, r1)
            if (r5 != 0) goto L_0x0089
        L_0x0088:
            return r1
        L_0x0089:
            boolean r5 = r4.renameTo(r0)
            if (r5 == 0) goto L_0x0090
            return r0
        L_0x0090:
            boolean r5 = r4.isDirectory()
            if (r5 == 0) goto L_0x00b9
            r0.mkdirs()
            java.lang.String r5 = r4.getPath()
            java.lang.String r6 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.lang.String r6 = r0.getPath()
            java.lang.String r7 = "dest.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            walkFileTreeForMove(r4, r5, r6)
            kotlin.io.FilesKt.deleteRecursively(r4)
            boolean r4 = isEmpty(r0)
            r4 = r4 ^ r2
            if (r4 == 0) goto L_0x00b9
            r1 = r0
        L_0x00b9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.moveTo(java.io.File, android.content.Context, java.io.File, java.lang.String, com.anggrayudi.storage.callback.FileCallback$ConflictResolution):java.io.File");
    }

    private static final void walkFileTreeForMove(File file, String str, String str2) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                i++;
                String path = file2.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "it.path");
                File file3 = new File(str2, StringsKt.trim(StringsKt.substringAfter$default(path, str, (String) null, 2, (Object) null), '/'));
                if (file2.isFile()) {
                    file2.renameTo(file3);
                } else {
                    file3.mkdirs();
                    Intrinsics.checkNotNullExpressionValue(file2, "it");
                    walkFileTreeForMove(file2, str, str2);
                }
            }
        }
    }
}
