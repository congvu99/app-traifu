package com.anggrayudi.storage.file;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.ImageMediaDirectory;
import com.anggrayudi.storage.media.MediaFile;
import com.anggrayudi.storage.media.MediaStoreCompat;
import com.facebook.internal.security.CertificateUtil;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.JsonLexerKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J8\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u001a\u0010\"\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u001dH\u0007J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J:\u0010&\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017H\u0002J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040+H\u0007J$\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/H\u0007J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040/H\u0007J8\u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J8\u00102\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J8\u00103\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007JD\u00107\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u001a\u00108\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u001bH\u0007J.\u0010:\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u001b\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010=\u001a\u00020\u0004H\u0000¢\u0006\u0002\b>J\u001a\u0010?\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0004H\u0007J\u0018\u0010C\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0012\u0010E\u001a\u0004\u0018\u00010\u00042\u0006\u0010=\u001a\u00020\u0004H\u0002J.\u0010F\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J$\u0010G\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0017H\u0007J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010I\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010J\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040+2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010L\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0018\u0010M\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010O\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u001bH\u0007J\"\u0010P\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J.\u0010Q\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J?\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0R2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040+2\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010SJ*\u0010T\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0017H\u0002J8\u0010U\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0017H\u0007J\u0011\u0010V\u001a\u00020\u0004*\u00020\u0004H\u0000¢\u0006\u0002\bWR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/anggrayudi/storage/file/DocumentFileCompat;", "", "()V", "DOWNLOADS_FOLDER_AUTHORITY", "", "DOWNLOADS_TREE_URI", "EXTERNAL_STORAGE_AUTHORITY", "FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "Lkotlin/text/Regex;", "getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION", "()Lkotlin/text/Regex;", "FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION", "MEDIA_FOLDER_AUTHORITY", "buildAbsolutePath", "context", "Landroid/content/Context;", "simplePath", "storageId", "basePath", "buildSimplePath", "absolutePath", "create", "", "file", "Ljava/io/File;", "createDocumentUri", "Landroid/net/Uri;", "createDownloadWithMediaStoreFallback", "Lcom/anggrayudi/storage/media/FileDescription;", "createFile", "Landroidx/documentfile/provider/DocumentFile;", "mimeType", "considerRawFile", "createPictureWithMediaStoreFallback", "delete", "fullPath", "doesExist", "exploreFile", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "requiresWriteAccess", "findInaccessibleStorageLocations", "", "fullPaths", "findUniqueDeepestSubFolders", "folderFullPaths", "", "findUniqueParents", "fromFile", "fromFullPath", "fromPublicFolder", "type", "Lcom/anggrayudi/storage/file/PublicDirectory;", "subFile", "fromSimplePath", "fromUri", "uri", "getAccessibleRootDocumentFile", "getBasePath", "getDirectorySequence", "path", "getDirectorySequence$storage_release", "getDocumentFileForStorageInfo", "getFileNameFromPath", "getFileNameFromUrl", "url", "getFreeSpace", "", "getParentPath", "getRootDocumentFile", "getRootRawFile", "getSdCardIds", "getStorageCapacity", "getStorageId", "getStorageIds", "getUsedSpace", "isAccessGranted", "isDownloadsUriPermissionGranted", "isRootUri", "isStorageUriPermissionGranted", "mkdirs", "", "(Landroid/content/Context;Ljava/util/List;ZZ)[Landroidx/documentfile/provider/DocumentFile;", "mkdirsParentDirectory", "recreate", "removeForbiddenCharsFromFilename", "removeForbiddenCharsFromFilename$storage_release", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileCompat.kt */
public final class DocumentFileCompat {
    public static final String DOWNLOADS_FOLDER_AUTHORITY = "com.android.providers.downloads.documents";
    public static final String DOWNLOADS_TREE_URI = "content://com.android.providers.downloads.documents/tree/downloads";
    public static final String EXTERNAL_STORAGE_AUTHORITY = "com.android.externalstorage.documents";
    private static final Regex FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION = new Regex("(.*?) \\(\\d+\\)");
    private static final Regex FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION = new Regex("(.*?) \\(\\d+\\)\\.[a-zA-Z0-9]+");
    public static final DocumentFileCompat INSTANCE = new DocumentFileCompat();
    public static final String MEDIA_FOLDER_AUTHORITY = "com.android.providers.media.documents";

    @JvmStatic
    public static final Uri createDocumentUri(String str) {
        Intrinsics.checkNotNullParameter(str, "storageId");
        return createDocumentUri$default(str, (String) null, 2, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "basePath");
        return createFile$default(context, (String) null, str, (String) null, false, 26, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        return createFile$default(context, str, str2, (String) null, false, 24, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(str3, "mimeType");
        return createFile$default(context, str, str2, str3, false, 16, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        return fromFile$default(context, file, (DocumentFileType) null, false, false, 28, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentFileType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromFile$default(context, file, documentFileType, false, false, 24, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentFileType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromFile$default(context, file, documentFileType, z, false, 16, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        return fromFullPath$default(context, str, (DocumentFileType) null, false, false, 28, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String str, DocumentFileType documentFileType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromFullPath$default(context, str, documentFileType, false, false, 24, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String str, DocumentFileType documentFileType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromFullPath$default(context, str, documentFileType, z, false, 16, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory publicDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "type");
        return fromPublicFolder$default(context, publicDirectory, (String) null, false, false, 28, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory publicDirectory, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "type");
        Intrinsics.checkNotNullParameter(str, "subFile");
        return fromPublicFolder$default(context, publicDirectory, str, false, false, 24, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory publicDirectory, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "type");
        Intrinsics.checkNotNullParameter(str, "subFile");
        return fromPublicFolder$default(context, publicDirectory, str, z, false, 16, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return fromSimplePath$default(context, (String) null, (String) null, (DocumentFileType) null, false, false, 62, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return fromSimplePath$default(context, str, (String) null, (DocumentFileType) null, false, false, 60, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        return fromSimplePath$default(context, str, str2, (DocumentFileType) null, false, false, 56, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String str, String str2, DocumentFileType documentFileType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromSimplePath$default(context, str, str2, documentFileType, false, false, 48, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String str, String str2, DocumentFileType documentFileType, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        return fromSimplePath$default(context, str, str2, documentFileType, z, false, 32, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile getAccessibleRootDocumentFile(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        return getAccessibleRootDocumentFile$default(context, str, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile getAccessibleRootDocumentFile(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        return getAccessibleRootDocumentFile$default(context, str, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return getRootDocumentFile$default(context, str, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return getRootDocumentFile$default(context, str, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final File getRootRawFile(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return getRootRawFile$default(context, str, false, 4, (Object) null);
    }

    @JvmStatic
    public static final boolean isStorageUriPermissionGranted(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return isStorageUriPermissionGranted$default(context, str, (String) null, 4, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile mkdirs(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        return mkdirs$default(context, str, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile mkdirs(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        return mkdirs$default(context, str, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fullPaths");
        return mkdirs$default(context, (List) list, false, false, 12, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> list, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fullPaths");
        return mkdirs$default(context, (List) list, z, false, 8, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "basePath");
        return recreate$default(context, (String) null, str, (String) null, false, 26, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        return recreate$default(context, str, str2, (String) null, false, 24, (Object) null);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(str3, "mimeType");
        return recreate$default(context, str, str2, str3, false, 16, (Object) null);
    }

    private DocumentFileCompat() {
    }

    public final Regex getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION() {
        return FILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION;
    }

    public final Regex getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION() {
        return FILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION;
    }

    @JvmStatic
    public static final boolean isRootUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String path = uri.getPath();
        if (path != null && UriUtils.isExternalStorageDocument(uri) && StringsKt.indexOf$default((CharSequence) path, (char) JsonLexerKt.COLON, 0, false, 6, (Object) null) == path.length() - 1) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final String getStorageId(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        if (!StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            return StringsKt.substringAfterLast$default(StringsKt.substringBefore(str, (char) JsonLexerKt.COLON, ""), '/', (String) null, 2, (Object) null);
        }
        if (StringsKt.startsWith$default(str, SimpleStorage.Companion.getExternalStoragePath(), false, 2, (Object) null)) {
            return StorageId.PRIMARY;
        }
        String path = FileUtils.getDataDirectory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "context.dataDirectory.path");
        if (StringsKt.startsWith$default(str, path, false, 2, (Object) null)) {
            return "data";
        }
        return StringsKt.substringBefore$default(StringsKt.substringAfter(str, "/storage/", ""), '/', (String) null, 2, (Object) null);
    }

    @JvmStatic
    public static final String getBasePath(Context context, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            String path = FileUtils.getDataDirectory(context).getPath();
            String externalStoragePath = SimpleStorage.Companion.getExternalStoragePath();
            if (StringsKt.startsWith$default(str, externalStoragePath, false, 2, (Object) null)) {
                str2 = StringsKt.substringAfter$default(str, externalStoragePath, (String) null, 2, (Object) null);
            } else {
                Intrinsics.checkNotNullExpressionValue(path, "dataDir");
                if (StringsKt.startsWith$default(str, path, false, 2, (Object) null)) {
                    str2 = StringsKt.substringAfter$default(str, path, (String) null, 2, (Object) null);
                } else {
                    str2 = StringsKt.substringAfter(StringsKt.substringAfter(str, "/storage/", ""), '/', "");
                }
            }
        } else {
            str2 = StringsKt.substringAfter(str, (char) JsonLexerKt.COLON, "");
        }
        return INSTANCE.removeForbiddenCharsFromFilename$storage_release(TextUtils.trimFileSeparator(str2));
    }

    @JvmStatic
    public static final DocumentFile fromUri(Context context, Uri uri) {
        DocumentFile writableDownloadsDocumentFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (UriUtils.isRawFile(uri)) {
            String path = uri.getPath();
            if (path == null) {
                return null;
            }
            File file = new File(path);
            if (!file.canRead()) {
                return null;
            }
            writableDownloadsDocumentFile = DocumentFile.fromFile(file);
        } else if (!UriUtils.isTreeDocumentFile(uri)) {
            return ContextUtils.fromSingleUri(context, uri);
        } else {
            DocumentFile fromTreeUri = ContextUtils.fromTreeUri(context, uri);
            if (fromTreeUri == null) {
                return null;
            }
            if (!DocumentFileUtils.isDownloadsDocument(fromTreeUri)) {
                return fromTreeUri;
            }
            writableDownloadsDocumentFile = DocumentFileUtils.toWritableDownloadsDocumentFile(fromTreeUri, context);
        }
        return writableDownloadsDocumentFile;
    }

    public static /* synthetic */ DocumentFile fromSimplePath$default(Context context, String str, String str2, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        return fromSimplePath(context, str, str3, documentFileType, (i & 16) != 0 ? false : z, (i & 32) != 0 ? true : z2);
    }

    @JvmStatic
    public static final DocumentFile fromSimplePath(Context context, String str, String str2, DocumentFileType documentFileType, boolean z, boolean z2) {
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        DocumentFileType documentFileType2 = documentFileType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str4, "basePath");
        Intrinsics.checkNotNullParameter(documentFileType2, "documentType");
        if (Intrinsics.areEqual((Object) str, (Object) "data")) {
            return DocumentFile.fromFile(FileUtils.child(FileUtils.getDataDirectory(context), str4));
        }
        boolean z3 = true;
        if (str4.length() == 0) {
            return getRootDocumentFile(context, str, z, z2);
        }
        DocumentFile exploreFile = INSTANCE.exploreFile(context, str, str2, documentFileType, z, z2);
        if (exploreFile == null) {
            String str5 = Environment.DIRECTORY_DOWNLOADS;
            Intrinsics.checkNotNullExpressionValue(str5, "DIRECTORY_DOWNLOADS");
            if (StringsKt.startsWith$default(str4, str5, false, 2, (Object) null) && Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY)) {
                Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(DOWNLOADS_TREE_URI)");
                DocumentFile fromTreeUri = ContextUtils.fromTreeUri(context, parse);
                if (fromTreeUri == null || !fromTreeUri.canRead()) {
                    fromTreeUri = null;
                }
                if (fromTreeUri == null || (exploreFile = DocumentFileUtils.child$default(fromTreeUri, context, StringsKt.substringAfter(str4, '/', ""), false, 4, (Object) null)) == null) {
                    return null;
                }
                if (documentFileType2 != DocumentFileType.ANY && ((documentFileType2 != DocumentFileType.FILE || !exploreFile.isFile()) && (documentFileType2 != DocumentFileType.FOLDER || !exploreFile.isDirectory()))) {
                    z3 = false;
                }
                if (!z3) {
                    return null;
                }
            }
        }
        return exploreFile;
    }

    public static /* synthetic */ DocumentFile fromFullPath$default(Context context, String str, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromFullPath(context, str, documentFileType, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromFullPath(Context context, String str, DocumentFileType documentFileType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        if (StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null)) {
            return fromFile(context, new File(str), documentFileType, z, z2);
        }
        return fromSimplePath(context, StringsKt.substringBefore$default(str, (char) JsonLexerKt.COLON, (String) null, 2, (Object) null), StringsKt.substringAfter$default(str, (char) JsonLexerKt.COLON, (String) null, 2, (Object) null), documentFileType, z, z2);
    }

    public static /* synthetic */ DocumentFile fromFile$default(Context context, File file, DocumentFileType documentFileType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            documentFileType = DocumentFileType.ANY;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromFile(context, file, documentFileType, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromFile(Context context, File file, DocumentFileType documentFileType, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(documentFileType, "documentType");
        if (!FileUtils.checkRequirements(file, context, z, z2)) {
            String trimFileSeparator = TextUtils.trimFileSeparator(INSTANCE.removeForbiddenCharsFromFilename$storage_release(FileUtils.getBasePath(file, context)));
            DocumentFile exploreFile = INSTANCE.exploreFile(context, FileUtils.getStorageId(file, context), trimFileSeparator, documentFileType, z, z2);
            if (exploreFile != null) {
                return exploreFile;
            }
            return fromSimplePath(context, FileUtils.getStorageId(file, context), trimFileSeparator, documentFileType, z, z2);
        } else if ((documentFileType != DocumentFileType.FILE || file.isFile()) && (documentFileType != DocumentFileType.FOLDER || file.isDirectory())) {
            return DocumentFile.fromFile(file);
        } else {
            return null;
        }
    }

    public static /* synthetic */ DocumentFile fromPublicFolder$default(Context context, PublicDirectory publicDirectory, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = true;
        }
        return fromPublicFolder(context, publicDirectory, str, z, z2);
    }

    @JvmStatic
    public static final DocumentFile fromPublicFolder(Context context, PublicDirectory publicDirectory, String str, boolean z, boolean z2) {
        DocumentFile documentFile;
        boolean z3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "type");
        Intrinsics.checkNotNullParameter(str, "subFile");
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(publicDirectory.getFolderName());
        boolean z4 = true;
        if (str.length() > 0) {
            externalStoragePublicDirectory = new File(StringsKt.trimEnd(externalStoragePublicDirectory + '/' + str, '/'));
        }
        Intrinsics.checkNotNullExpressionValue(externalStoragePublicDirectory, "rawFile");
        if (FileUtils.checkRequirements(externalStoragePublicDirectory, context, z, z2)) {
            return DocumentFile.fromFile(externalStoragePublicDirectory);
        }
        if (publicDirectory == PublicDirectory.DOWNLOADS) {
            Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(DOWNLOADS_TREE_URI)");
            DocumentFile fromTreeUri = ContextUtils.fromTreeUri(context, parse);
            if (fromTreeUri != null && fromTreeUri.canRead()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                documentFile = DocumentFileUtils.child(fromTreeUri, context, str, z);
            } else {
                String absolutePath = externalStoragePublicDirectory.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "rawFile.absolutePath");
                documentFile = fromFullPath$default(context, absolutePath, (DocumentFileType) null, false, false, 12, (Object) null);
            }
        } else {
            String absolutePath2 = externalStoragePublicDirectory.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "rawFile.absolutePath");
            documentFile = fromFullPath$default(context, absolutePath2, (DocumentFileType) null, false, false, 12, (Object) null);
        }
        if (documentFile != null) {
            if (!documentFile.canRead() || ((!z || !DocumentFileUtils.isWritable(documentFile, context)) && z)) {
                z4 = false;
            }
            if (z4) {
                return documentFile;
            }
        }
        return null;
    }

    public static /* synthetic */ DocumentFile getRootDocumentFile$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return getRootDocumentFile(context, str, z, z2);
    }

    @JvmStatic
    public static final DocumentFile getRootDocumentFile(Context context, String str, boolean z, boolean z2) {
        DocumentFile documentFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        if (Intrinsics.areEqual((Object) str, (Object) "data")) {
            return DocumentFile.fromFile(FileUtils.getDataDirectory(context));
        }
        if (z2) {
            File rootRawFile = getRootRawFile(context, str, z);
            documentFile = rootRawFile == null ? null : DocumentFile.fromFile(rootRawFile);
            if (documentFile == null) {
                documentFile = ContextUtils.fromTreeUri(context, createDocumentUri$default(str, (String) null, 2, (Object) null));
            }
        } else {
            documentFile = ContextUtils.fromTreeUri(context, createDocumentUri$default(str, (String) null, 2, (Object) null));
        }
        if (documentFile == null) {
            return null;
        }
        if (documentFile.canRead() && ((z && DocumentFileUtils.isWritable(documentFile, context)) || !z)) {
            return documentFile;
        }
        return null;
    }

    public static /* synthetic */ DocumentFile getAccessibleRootDocumentFile$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return getAccessibleRootDocumentFile(context, str, z, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x007c A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.documentfile.provider.DocumentFile getAccessibleRootDocumentFile(android.content.Context r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "fullPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 47
            r3 = 2
            r4 = 0
            r5 = 0
            if (r19 == 0) goto L_0x0030
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.startsWith$default((java.lang.CharSequence) r6, (char) r2, (boolean) r4, (int) r3, (java.lang.Object) r5)
            if (r6 == 0) goto L_0x0030
            java.io.File r6 = new java.io.File
            r6.<init>(r1)
            r7 = r18
            java.io.File r6 = com.anggrayudi.storage.file.FileUtils.getRootRawFile(r6, r0, r7)
            if (r6 == 0) goto L_0x0030
            androidx.documentfile.provider.DocumentFile r0 = androidx.documentfile.provider.DocumentFile.fromFile(r6)
            return r0
        L_0x0030:
            java.lang.String r6 = getStorageId(r16, r17)
            java.lang.String r7 = "data"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0045
            java.io.File r0 = com.anggrayudi.storage.file.FileUtils.getDataDirectory(r16)
            androidx.documentfile.provider.DocumentFile r0 = androidx.documentfile.provider.DocumentFile.fromFile(r0)
            return r0
        L_0x0045:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            r8 = 1
            if (r7 <= 0) goto L_0x0051
            r7 = 1
            goto L_0x0052
        L_0x0051:
            r7 = 0
        L_0x0052:
            if (r7 == 0) goto L_0x013a
            java.lang.String r7 = getBasePath(r16, r17)
            java.lang.String r9 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r9 = android.os.Environment.getExternalStoragePublicDirectory(r9)
            java.lang.String r9 = r9.getAbsolutePath()
            android.content.ContentResolver r10 = r16.getContentResolver()
            java.util.List r10 = r10.getPersistedUriPermissions()
            java.lang.String r11 = "context.contentResolver.persistedUriPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r10 = r10.iterator()
        L_0x007c:
            boolean r12 = r10.hasNext()
            java.lang.String r13 = "it.uri"
            if (r12 == 0) goto L_0x00ad
            java.lang.Object r12 = r10.next()
            r14 = r12
            android.content.UriPermission r14 = (android.content.UriPermission) r14
            boolean r15 = r14.isReadPermission()
            if (r15 == 0) goto L_0x00a6
            boolean r15 = r14.isWritePermission()
            if (r15 == 0) goto L_0x00a6
            android.net.Uri r14 = r14.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r13)
            boolean r13 = com.anggrayudi.storage.extension.UriUtils.isTreeDocumentFile(r14)
            if (r13 == 0) goto L_0x00a6
            r13 = 1
            goto L_0x00a7
        L_0x00a6:
            r13 = 0
        L_0x00a7:
            if (r13 == 0) goto L_0x007c
            r11.add(r12)
            goto L_0x007c
        L_0x00ad:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r10 = r11.iterator()
        L_0x00b5:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x013a
            java.lang.Object r11 = r10.next()
            android.content.UriPermission r11 = (android.content.UriPermission) r11
            java.lang.String r12 = "downloadPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r12)
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r1, r9, r4, r3, r5)
            if (r12 == 0) goto L_0x00e9
            android.net.Uri r12 = r11.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            boolean r12 = com.anggrayudi.storage.extension.UriUtils.isDownloadsDocument(r12)
            if (r12 == 0) goto L_0x00e9
            java.lang.String r1 = "content://com.android.providers.downloads.documents/tree/downloads"
            android.net.Uri r1 = android.net.Uri.parse(r1)
            java.lang.String r2 = "parse(DOWNLOADS_TREE_URI)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r0, r1)
            return r0
        L_0x00e9:
            android.net.Uri r12 = r11.getUri()
            java.lang.String r12 = r12.getPath()
            if (r12 == 0) goto L_0x0136
            android.net.Uri r14 = r11.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r13)
            boolean r14 = com.anggrayudi.storage.extension.UriUtils.isExternalStorageDocument(r14)
            if (r14 == 0) goto L_0x0136
            r14 = 58
            java.lang.String r15 = kotlin.text.StringsKt.substringBefore$default((java.lang.String) r12, (char) r14, (java.lang.String) r5, (int) r3, (java.lang.Object) r5)
            java.lang.String r15 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r15, (char) r2, (java.lang.String) r5, (int) r3, (java.lang.Object) r5)
            java.lang.String r2 = ""
            java.lang.String r2 = kotlin.text.StringsKt.substringAfter((java.lang.String) r12, (char) r14, (java.lang.String) r2)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r6)
            if (r12 == 0) goto L_0x0136
            r12 = r2
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0121
            r12 = 1
            goto L_0x0122
        L_0x0121:
            r12 = 0
        L_0x0122:
            if (r12 != 0) goto L_0x012a
            boolean r2 = com.anggrayudi.storage.extension.TextUtils.hasParent(r7, r2)
            if (r2 == 0) goto L_0x0136
        L_0x012a:
            android.net.Uri r1 = r11.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.extension.ContextUtils.fromTreeUri(r0, r1)
            return r0
        L_0x0136:
            r2 = 47
            goto L_0x00b5
        L_0x013a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getAccessibleRootDocumentFile(android.content.Context, java.lang.String, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ File getRootRawFile$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getRootRawFile(context, str, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (com.anggrayudi.storage.file.FileUtils.isWritable(r3, r2) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r4 == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r2 = true;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File getRootRawFile(android.content.Context r2, java.lang.String r3, boolean r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "storageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "primary"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0017
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            goto L_0x0030
        L_0x0017:
            java.lang.String r0 = "data"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0024
            java.io.File r3 = com.anggrayudi.storage.file.FileUtils.getDataDirectory(r2)
            goto L_0x0030
        L_0x0024:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/storage/"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r3)
            r0.<init>(r3)
            r3 = r0
        L_0x0030:
            boolean r0 = r3.canRead()
            if (r0 == 0) goto L_0x0047
            if (r4 == 0) goto L_0x0043
            java.lang.String r0 = "rootFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            boolean r2 = com.anggrayudi.storage.file.FileUtils.isWritable(r3, r2)
            if (r2 != 0) goto L_0x0045
        L_0x0043:
            if (r4 != 0) goto L_0x0047
        L_0x0045:
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r2 == 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getRootRawFile(android.content.Context, java.lang.String, boolean):java.io.File");
    }

    @JvmStatic
    public static final String buildAbsolutePath(Context context, String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        String removeForbiddenCharsFromFilename$storage_release = INSTANCE.removeForbiddenCharsFromFilename$storage_release(str2);
        if (Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY)) {
            str3 = SimpleStorage.Companion.getExternalStoragePath();
        } else if (Intrinsics.areEqual((Object) str, (Object) "data")) {
            str3 = FileUtils.getDataDirectory(context).getPath();
        } else {
            str3 = Intrinsics.stringPlus("/storage/", str);
        }
        return StringsKt.trimEnd(str3 + '/' + removeForbiddenCharsFromFilename$storage_release, '/');
    }

    @JvmStatic
    public static final String buildAbsolutePath(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "simplePath");
        String trimEnd = StringsKt.trimEnd(str, '/');
        if (StringsKt.startsWith$default((CharSequence) trimEnd, '/', false, 2, (Object) null)) {
            return INSTANCE.removeForbiddenCharsFromFilename$storage_release(trimEnd);
        }
        return buildAbsolutePath(context, getStorageId(context, trimEnd), getBasePath(context, trimEnd));
    }

    @JvmStatic
    public static final String buildSimplePath(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        String trimFileSeparator = TextUtils.trimFileSeparator(INSTANCE.removeForbiddenCharsFromFilename$storage_release(str2));
        return str + JsonLexerKt.COLON + trimFileSeparator;
    }

    @JvmStatic
    public static final String buildSimplePath(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "absolutePath");
        return buildSimplePath(getStorageId(context, str), getBasePath(context, str));
    }

    public static /* synthetic */ Uri createDocumentUri$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return createDocumentUri(str, str2);
    }

    @JvmStatic
    public static final Uri createDocumentUri(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(EXTERNAL_STORAGE_AUTHORITY);
        sb.append("/tree/");
        sb.append(Uri.encode(str + JsonLexerKt.COLON + str2));
        Uri parse = Uri.parse(sb.toString());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://$EXTERN…(\"$storageId:$basePath\"))");
        return parse;
    }

    @JvmStatic
    public static final boolean isAccessGranted(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        return Intrinsics.areEqual((Object) str, (Object) "data") || (Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY) && Build.VERSION.SDK_INT < 29) || getRootDocumentFile$default(context, str, true, false, 8, (Object) null) != null;
    }

    @JvmStatic
    public static final boolean doesExist(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        DocumentFile fromFullPath$default = fromFullPath$default(context, str, (DocumentFileType) null, false, false, 28, (Object) null);
        return fromFullPath$default != null && fromFullPath$default.exists();
    }

    @JvmStatic
    public static final boolean delete(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        DocumentFile fromFullPath$default = fromFullPath$default(context, str, (DocumentFileType) null, false, false, 28, (Object) null);
        return fromFullPath$default != null && fromFullPath$default.delete();
    }

    public static /* synthetic */ boolean isStorageUriPermissionGranted$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return isStorageUriPermissionGranted(context, str, str2);
    }

    @JvmStatic
    public static final boolean isStorageUriPermissionGranted(Context context, String str, String str2) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Uri createDocumentUri = createDocumentUri(str, str2);
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "context.contentResolver.persistedUriPermissions");
        Iterable<UriPermission> iterable = persistedUriPermissions;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (UriPermission uriPermission : iterable) {
                if (!uriPermission.isReadPermission() || !uriPermission.isWritePermission() || !Intrinsics.areEqual((Object) uriPermission.getUri(), (Object) createDocumentUri)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isDownloadsUriPermissionGranted(Context context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Uri parse = Uri.parse(DOWNLOADS_TREE_URI);
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "context.contentResolver.persistedUriPermissions");
        Iterable<UriPermission> iterable = persistedUriPermissions;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (UriPermission uriPermission : iterable) {
                if (!uriPermission.isReadPermission() || !uriPermission.isWritePermission() || !Intrinsics.areEqual((Object) uriPermission.getUri(), (Object) parse)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082 A[SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.lang.String> getStorageIds(android.content.Context r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.anggrayudi.storage.SimpleStorage$Companion r0 = com.anggrayudi.storage.SimpleStorage.Companion
            java.lang.String r0 = r0.getExternalStoragePath()
            r1 = 0
            java.io.File[] r2 = androidx.core.content.ContextCompat.getExternalFilesDirs(r9, r1)
            java.lang.String r3 = "getExternalFilesDirs(context, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.util.List r2 = kotlin.collections.ArraysKt.filterNotNull(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x002e:
            boolean r4 = r2.hasNext()
            r5 = 47
            r6 = 0
            r7 = 2
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r2.next()
            java.io.File r4 = (java.io.File) r4
            java.lang.String r4 = r4.getPath()
            java.lang.String r8 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r4, r0, r6, r7, r1)
            if (r6 == 0) goto L_0x0050
            java.lang.String r4 = "primary"
            goto L_0x005a
        L_0x0050:
            java.lang.String r6 = "/storage/"
            java.lang.String r4 = kotlin.text.StringsKt.substringAfter$default((java.lang.String) r4, (java.lang.String) r6, (java.lang.String) r1, (int) r7, (java.lang.Object) r1)
            java.lang.String r4 = kotlin.text.StringsKt.substringBefore$default((java.lang.String) r4, (char) r5, (java.lang.String) r1, (int) r7, (java.lang.Object) r1)
        L_0x005a:
            r3.add(r4)
            goto L_0x002e
        L_0x005e:
            java.util.List r3 = (java.util.List) r3
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r0 < r2) goto L_0x0068
            goto L_0x00fe
        L_0x0068:
            android.content.ContentResolver r9 = r9.getContentResolver()
            java.util.List r9 = r9.getPersistedUriPermissions()
            java.lang.String r0 = "context.contentResolver.persistedUriPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r9 = r9.iterator()
        L_0x0082:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00b3
            java.lang.Object r2 = r9.next()
            r4 = r2
            android.content.UriPermission r4 = (android.content.UriPermission) r4
            boolean r8 = r4.isReadPermission()
            if (r8 == 0) goto L_0x00ac
            boolean r8 = r4.isWritePermission()
            if (r8 == 0) goto L_0x00ac
            android.net.Uri r4 = r4.getUri()
            java.lang.String r8 = "it.uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            boolean r4 = com.anggrayudi.storage.extension.UriUtils.isExternalStorageDocument(r4)
            if (r4 == 0) goto L_0x00ac
            r4 = 1
            goto L_0x00ad
        L_0x00ac:
            r4 = 0
        L_0x00ad:
            if (r4 == 0) goto L_0x0082
            r0.add(r2)
            goto L_0x0082
        L_0x00b3:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r0 = r0.iterator()
        L_0x00c2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00eb
            java.lang.Object r2 = r0.next()
            android.content.UriPermission r2 = (android.content.UriPermission) r2
            android.net.Uri r2 = r2.getUri()
            java.lang.String r2 = r2.getPath()
            if (r2 != 0) goto L_0x00da
            r2 = r1
            goto L_0x00e4
        L_0x00da:
            r4 = 58
            java.lang.String r2 = kotlin.text.StringsKt.substringBefore$default((java.lang.String) r2, (char) r4, (java.lang.String) r1, (int) r7, (java.lang.Object) r1)
            java.lang.String r2 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r2, (char) r5, (java.lang.String) r1, (int) r7, (java.lang.Object) r1)
        L_0x00e4:
            if (r2 != 0) goto L_0x00e7
            goto L_0x00c2
        L_0x00e7:
            r9.add(r2)
            goto L_0x00c2
        L_0x00eb:
            java.util.List r9 = (java.util.List) r9
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r3)
            java.util.Collection r9 = (java.util.Collection) r9
            r0.addAll(r9)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r3 = kotlin.collections.CollectionsKt.distinct(r0)
        L_0x00fe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getStorageIds(android.content.Context):java.util.List");
    }

    @JvmStatic
    public static final List<String> getSdCardIds(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Collection arrayList = new ArrayList();
        for (Object next : getStorageIds(context)) {
            if (!Intrinsics.areEqual((Object) (String) next, (Object) StorageId.PRIMARY)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public static /* synthetic */ DocumentFile mkdirs$default(Context context, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return mkdirs(context, str, z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (kotlin.text.StringsKt.startsWith$default(r7, r4, false, 2, (java.lang.Object) null) != false) goto L_0x0034;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.documentfile.provider.DocumentFile mkdirs(android.content.Context r6, java.lang.String r7, boolean r8, boolean r9) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fullPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.anggrayudi.storage.file.DocumentFileCompat$mkdirs$tryCreateWithRawFile$1 r0 = new com.anggrayudi.storage.file.DocumentFileCompat$mkdirs$tryCreateWithRawFile$1
            r0.<init>(r7, r8, r6)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 2
            r2 = 0
            r3 = 0
            if (r9 == 0) goto L_0x0021
            r4 = r7
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5 = 47
            boolean r4 = kotlin.text.StringsKt.startsWith$default((java.lang.CharSequence) r4, (char) r5, (boolean) r2, (int) r1, (java.lang.Object) r3)
            if (r4 != 0) goto L_0x0034
        L_0x0021:
            java.io.File r4 = com.anggrayudi.storage.file.FileUtils.getDataDirectory(r6)
            java.lang.String r4 = r4.getPath()
            java.lang.String r5 = "context.dataDirectory.path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r4, r2, r1, r3)
            if (r1 == 0) goto L_0x003e
        L_0x0034:
            java.lang.Object r1 = r0.invoke()
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            if (r1 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            return r1
        L_0x003e:
            androidx.documentfile.provider.DocumentFile r9 = getAccessibleRootDocumentFile(r6, r7, r8, r9)
            if (r9 != 0) goto L_0x0045
            return r3
        L_0x0045:
            boolean r1 = com.anggrayudi.storage.file.DocumentFileUtils.isRawFile(r9)
            if (r1 == 0) goto L_0x0052
            java.lang.Object r6 = r0.invoke()
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            return r6
        L_0x0052:
            android.content.ContentResolver r0 = r6.getContentResolver()
            com.anggrayudi.storage.file.DocumentFileCompat r1 = INSTANCE
            java.lang.String r7 = getBasePath(r6, r7)
            java.util.List r7 = r1.getDirectorySequence$storage_release(r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0066:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0093
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "resolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ Exception -> 0x0092 }
            androidx.documentfile.provider.DocumentFile r2 = com.anggrayudi.storage.file.DocumentFileUtils.quickFindTreeFile(r9, r6, r0, r1)     // Catch:{ Exception -> 0x0092 }
            if (r2 != 0) goto L_0x0084
            androidx.documentfile.provider.DocumentFile r9 = r9.createDirectory(r1)     // Catch:{ Exception -> 0x0092 }
            if (r9 != 0) goto L_0x0066
            return r3
        L_0x0084:
            boolean r9 = r2.isDirectory()     // Catch:{ Exception -> 0x0092 }
            if (r9 == 0) goto L_0x0092
            boolean r9 = r2.canRead()     // Catch:{ Exception -> 0x0092 }
            if (r9 == 0) goto L_0x0092
            r9 = r2
            goto L_0x0066
        L_0x0092:
            return r3
        L_0x0093:
            androidx.documentfile.provider.DocumentFile r6 = com.anggrayudi.storage.file.DocumentFileUtils.takeIfWritable(r9, r6, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.mkdirs(android.content.Context, java.lang.String, boolean, boolean):androidx.documentfile.provider.DocumentFile");
    }

    public static /* synthetic */ DocumentFile[] mkdirs$default(Context context, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return mkdirs(context, (List<String>) list, z, z2);
    }

    @JvmStatic
    public static final DocumentFile[] mkdirs(Context context, List<String> list, boolean z, boolean z2) {
        DocumentFile documentFile;
        Context context2 = context;
        List<String> list2 = list;
        boolean z3 = z;
        boolean z4 = z2;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list2, "fullPaths");
        String path = FileUtils.getDataDirectory(context).getPath();
        DocumentFile[] documentFileArr = new DocumentFile[list.size()];
        Iterable<String> iterable = list2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String buildAbsolutePath : iterable) {
            arrayList.add(buildAbsolutePath(context2, buildAbsolutePath));
        }
        List list3 = (List) arrayList;
        for (String next : findUniqueDeepestSubFolders(context2, list3)) {
            File file = new File(next);
            file.mkdirs();
            int i = 0;
            if (!z4 || !file.isDirectory() || !file.canRead()) {
                Intrinsics.checkNotNullExpressionValue(path, "dataDir");
                if (!StringsKt.startsWith$default(next, path, false, 2, (Object) null)) {
                    DocumentFile accessibleRootDocumentFile = getAccessibleRootDocumentFile(context2, next, z3, z4);
                    if (accessibleRootDocumentFile != null) {
                        boolean isRawFile = DocumentFileUtils.isRawFile(accessibleRootDocumentFile);
                        ContentResolver contentResolver = context.getContentResolver();
                        for (String str : INSTANCE.getDirectorySequence$storage_release(getBasePath(context2, next))) {
                            if (isRawFile) {
                                try {
                                    documentFile = DocumentFileUtils.quickFindRawFile(accessibleRootDocumentFile, str);
                                } catch (Throwable unused) {
                                }
                            } else {
                                Intrinsics.checkNotNullExpressionValue(contentResolver, "resolver");
                                documentFile = DocumentFileUtils.quickFindTreeFile(accessibleRootDocumentFile, context2, contentResolver, str);
                            }
                            if (documentFile == null) {
                                DocumentFile createDirectory = accessibleRootDocumentFile.createDirectory(str);
                                if (createDirectory != null) {
                                    try {
                                        String absolutePath = DocumentFileUtils.getAbsolutePath(createDirectory, context2);
                                        int i2 = 0;
                                        for (Object next2 : list3) {
                                            int i3 = i2 + 1;
                                            if (i2 < 0) {
                                                CollectionsKt.throwIndexOverflow();
                                            }
                                            if (Intrinsics.areEqual((Object) absolutePath, (Object) (String) next2)) {
                                                documentFileArr[i2] = createDirectory;
                                            }
                                            i2 = i3;
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                    accessibleRootDocumentFile = createDirectory;
                                }
                            } else if (documentFile.isDirectory() && documentFile.canRead()) {
                                try {
                                    String absolutePath2 = DocumentFileUtils.getAbsolutePath(documentFile, context2);
                                    int i4 = 0;
                                    for (Object next3 : list3) {
                                        int i5 = i4 + 1;
                                        if (i4 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        if (Intrinsics.areEqual((Object) absolutePath2, (Object) (String) next3)) {
                                            documentFileArr[i4] = documentFile;
                                        }
                                        i4 = i5;
                                    }
                                } catch (Throwable unused3) {
                                }
                                accessibleRootDocumentFile = documentFile;
                            }
                        }
                    }
                }
            }
            for (Object next4 : list3) {
                int i6 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) next4;
                if (TextUtils.hasParent(next, str2)) {
                    documentFileArr[i] = DocumentFile.fromFile(new File(CollectionsKt.joinToString$default(INSTANCE.getDirectorySequence$storage_release(str2), "/", "/", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null)));
                }
                i = i6;
            }
        }
        Iterator it = ArraysKt.getIndices((T[]) documentFileArr).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            DocumentFile documentFile2 = documentFileArr[nextInt];
            documentFileArr[nextInt] = documentFile2 == null ? null : DocumentFileUtils.takeIfWritable(documentFile2, context2, z3);
        }
        return documentFileArr;
    }

    @JvmStatic
    public static final Uri createDownloadWithMediaStoreFallback(Context context, FileDescription fileDescription) {
        DocumentFile makeFile$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        DocumentFile fromPublicFolder$default = fromPublicFolder$default(context, PublicDirectory.DOWNLOADS, (String) null, true, false, 20, (Object) null);
        if (fromPublicFolder$default == null && Build.VERSION.SDK_INT > 28) {
            MediaFile createDownload$default = MediaStoreCompat.createDownload$default(context, fileDescription, (CreateMode) null, 4, (Object) null);
            if (createDownload$default == null) {
                return null;
            }
            return createDownload$default.getUri();
        } else if (fromPublicFolder$default == null || (makeFile$default = DocumentFileUtils.makeFile$default(fromPublicFolder$default, context, fileDescription.getName(), fileDescription.getMimeType(), (CreateMode) null, 8, (Object) null)) == null) {
            return null;
        } else {
            return makeFile$default.getUri();
        }
    }

    @JvmStatic
    public static final Uri createPictureWithMediaStoreFallback(Context context, FileDescription fileDescription) {
        DocumentFile makeFile$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        DocumentFile fromPublicFolder$default = fromPublicFolder$default(context, PublicDirectory.PICTURES, (String) null, true, false, 20, (Object) null);
        if (fromPublicFolder$default == null && Build.VERSION.SDK_INT > 28) {
            MediaFile createImage$default = MediaStoreCompat.createImage$default(context, fileDescription, (ImageMediaDirectory) null, (CreateMode) null, 12, (Object) null);
            if (createImage$default == null) {
                return null;
            }
            return createImage$default.getUri();
        } else if (fromPublicFolder$default == null || (makeFile$default = DocumentFileUtils.makeFile$default(fromPublicFolder$default, context, fileDescription.getName(), fileDescription.getMimeType(), (CreateMode) null, 8, (Object) null)) == null) {
            return null;
        } else {
            return makeFile$default.getUri();
        }
    }

    public static /* synthetic */ DocumentFile createFile$default(Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 8) != 0) {
            str3 = MimeType.UNKNOWN;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return createFile(context, str, str2, str3, z);
    }

    @JvmStatic
    public static final DocumentFile createFile(Context context, String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(str3, "mimeType");
        if (Intrinsics.areEqual((Object) str, (Object) "data") || (z && Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY) && Build.VERSION.SDK_INT < 29)) {
            File file = new File(buildAbsolutePath(context, str, str2));
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            if (INSTANCE.create(file)) {
                return DocumentFile.fromFile(file);
            }
            return null;
        }
        try {
            DocumentFile mkdirsParentDirectory = INSTANCE.mkdirsParentDirectory(context, str, str2, z);
            String removeForbiddenCharsFromFilename$storage_release = INSTANCE.removeForbiddenCharsFromFilename$storage_release(INSTANCE.getFileNameFromPath(str2));
            if (removeForbiddenCharsFromFilename$storage_release.length() == 0) {
                return null;
            }
            if (mkdirsParentDirectory == null) {
                return null;
            }
            return DocumentFileUtils.makeFile$default(mkdirsParentDirectory, context, removeForbiddenCharsFromFilename$storage_release, str3, (CreateMode) null, 8, (Object) null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final String getParentPath(String str) {
        List<String> directorySequence$storage_release = getDirectorySequence$storage_release(str);
        return (String) CollectionsKt.getOrNull(directorySequence$storage_release, directorySequence$storage_release.size() - 2);
    }

    private final DocumentFile mkdirsParentDirectory(Context context, String str, String str2, boolean z) {
        String parentPath = getParentPath(str2);
        if (parentPath == null) {
            return getRootDocumentFile(context, str, true, z);
        }
        return mkdirs$default(context, buildAbsolutePath(context, str, parentPath), z, false, 8, (Object) null);
    }

    private final String getFileNameFromPath(String str) {
        return StringsKt.substringAfterLast$default(StringsKt.trimEnd(str, '/'), '/', (String) null, 2, (Object) null);
    }

    public static /* synthetic */ DocumentFile recreate$default(Context context, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str = StorageId.PRIMARY;
        }
        if ((i & 8) != 0) {
            str3 = MimeType.UNKNOWN;
        }
        if ((i & 16) != 0) {
            z = true;
        }
        return recreate(context, str, str2, str3, z);
    }

    @JvmStatic
    public static final DocumentFile recreate(Context context, String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "storageId");
        Intrinsics.checkNotNullParameter(str2, "basePath");
        Intrinsics.checkNotNullParameter(str3, "mimeType");
        File file = new File(buildAbsolutePath(context, str, str2));
        file.delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if ((z || Intrinsics.areEqual((Object) str, (Object) "data")) && INSTANCE.create(file)) {
            return DocumentFile.fromFile(file);
        }
        DocumentFile mkdirsParentDirectory = INSTANCE.mkdirsParentDirectory(context, str, str2, z);
        String name = file.getName();
        CharSequence charSequence = name;
        if ((charSequence == null || charSequence.length() == 0) || mkdirsParentDirectory == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(name, "filename");
        DocumentFile child$default = DocumentFileUtils.child$default(mkdirsParentDirectory, context, name, false, 4, (Object) null);
        if (child$default != null) {
            child$default.delete();
        }
        return DocumentFileUtils.makeFile$default(mkdirsParentDirectory, context, name, str3, (CreateMode) null, 8, (Object) null);
    }

    private final boolean create(File file) {
        try {
            return (file.isFile() && file.length() == 0) || file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    public final String removeForbiddenCharsFromFilename$storage_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return TextUtils.replaceCompletely(StringsKt.replace$default(str, CertificateUtil.DELIMITER, "_", false, 4, (Object) null), "//", "/");
    }

    private final DocumentFile exploreFile(Context context, String str, String str2, DocumentFileType documentFileType, boolean z, boolean z2) {
        DocumentFile documentFile;
        boolean z3;
        Context context2 = context;
        String str3 = str;
        DocumentFileType documentFileType2 = documentFileType;
        boolean z4 = z;
        boolean z5 = z2;
        File file = new File(buildAbsolutePath(context, str, str2));
        if ((!z5 && !Intrinsics.areEqual((Object) str3, (Object) "data")) || !file.canRead() || !FileUtils.shouldWritable(file, context2, z4)) {
            boolean z6 = false;
            if (Build.VERSION.SDK_INT < 30) {
                DocumentFile rootDocumentFile = getRootDocumentFile(context2, str3, z4, z5);
                documentFile = rootDocumentFile == null ? null : DocumentFileUtils.child$default(rootDocumentFile, context, str2, false, 4, (Object) null);
                if (documentFile == null) {
                    return null;
                }
            } else {
                List mutableList = CollectionsKt.toMutableList(getDirectorySequence$storage_release(str2));
                ArrayList arrayList = new ArrayList(mutableList.size());
                DocumentFile documentFile2 = null;
                while (!mutableList.isEmpty()) {
                    arrayList.add(CollectionsKt.removeFirst(mutableList));
                    try {
                        documentFile2 = ContextUtils.fromTreeUri(context2, createDocumentUri(str3, CollectionsKt.joinToString$default(arrayList, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
                        if (documentFile2 != null && documentFile2.canRead()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            break;
                        }
                    } catch (SecurityException unused) {
                    }
                }
                documentFile = documentFile2;
                if (documentFile != null && !mutableList.isEmpty()) {
                    Uri parse = Uri.parse(Intrinsics.stringPlus(documentFile.getUri().toString(), Uri.encode(CollectionsKt.joinToString$default(mutableList, "/", "/", (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null))));
                    Intrinsics.checkNotNullExpressionValue(parse, "parse(grantedFile.uri.to…) + Uri.encode(fileTree))");
                    documentFile = ContextUtils.fromTreeUri(context2, parse);
                }
            }
            if (documentFile == null) {
                return null;
            }
            if (documentFile.canRead() && (documentFileType2 == DocumentFileType.ANY || ((documentFileType2 == DocumentFileType.FILE && documentFile.isFile()) || (documentFileType2 == DocumentFileType.FOLDER && documentFile.isDirectory())))) {
                z6 = true;
            }
            if (z6) {
                return documentFile;
            }
            return null;
        } else if (documentFileType2 == DocumentFileType.ANY || ((documentFileType2 == DocumentFileType.FILE && file.isFile()) || (documentFileType2 == DocumentFileType.FOLDER && file.isDirectory()))) {
            return DocumentFile.fromFile(file);
        } else {
            return null;
        }
    }

    public final List<String> getDirectorySequence$storage_release(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        Collection arrayList = new ArrayList();
        for (Object next : StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null)) {
            if (!StringsKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    @JvmStatic
    public static final List<String> findUniqueDeepestSubFolders(Context context, Collection<String> collection) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(collection, "folderFullPaths");
        Iterable<String> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String buildAbsolutePath : iterable) {
            arrayList.add(buildAbsolutePath(context, buildAbsolutePath));
        }
        List distinct = CollectionsKt.distinct((List) arrayList);
        ArrayList arrayList2 = new ArrayList(distinct);
        Iterable<String> iterable2 = distinct;
        for (String str : iterable2) {
            Iterator it = iterable2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str2 = (String) obj;
                if (Intrinsics.areEqual((Object) str2, (Object) str) || !TextUtils.hasParent(str, str2)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            String str3 = (String) obj;
            if (str3 != null) {
                arrayList2.remove(str3);
            }
        }
        return arrayList2;
    }

    @JvmStatic
    public static final List<String> findUniqueParents(Context context, Collection<String> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(collection, "folderFullPaths");
        Iterable<String> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String buildAbsolutePath : iterable) {
            arrayList.add(buildAbsolutePath(context, buildAbsolutePath));
        }
        List distinct = CollectionsKt.distinct((List) arrayList);
        ArrayList arrayList2 = new ArrayList(distinct.size());
        Iterable<String> iterable2 = distinct;
        for (String str : iterable2) {
            boolean z2 = true;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it = iterable2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    if (Intrinsics.areEqual((Object) str2, (Object) str) || !TextUtils.hasParent(str, str2)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2) {
                arrayList2.add(str);
            }
        }
        return arrayList2;
    }

    @JvmStatic
    public static final List<String> findInaccessibleStorageLocations(Context context, List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "fullPaths");
        if (SimpleStorage.Companion.hasStoragePermission(context)) {
            List<String> findUniqueParents = findUniqueParents(context, list);
            ArrayList arrayList = new ArrayList(findUniqueParents.size());
            DocumentFile[] mkdirs$default = mkdirs$default(context, (List) findUniqueParents, false, false, 12, (Object) null);
            int length = mkdirs$default.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                DocumentFile documentFile = mkdirs$default[i];
                i++;
                int i3 = i2 + 1;
                if (documentFile == null) {
                    arrayList.add(findUniqueParents.get(i2));
                }
                i2 = i3;
            }
            return arrayList;
        }
        Iterable<String> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String buildAbsolutePath : iterable) {
            arrayList2.add(buildAbsolutePath(context, buildAbsolutePath));
        }
        return (List) arrayList2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        throw r2;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getFreeSpace(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "storageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            com.anggrayudi.storage.file.DocumentFileCompat r2 = INSTANCE     // Catch:{ all -> 0x0068 }
            androidx.documentfile.provider.DocumentFile r8 = r2.getDocumentFileForStorageInfo(r7, r8)     // Catch:{ all -> 0x0068 }
            if (r8 != 0) goto L_0x0015
            return r0
        L_0x0015:
            boolean r2 = com.anggrayudi.storage.file.DocumentFileUtils.isRawFile(r8)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0031
            android.os.StatFs r7 = new android.os.StatFs     // Catch:{ all -> 0x0068 }
            android.net.Uri r8 = r8.getUri()     // Catch:{ all -> 0x0068 }
            java.lang.String r8 = r8.getPath()     // Catch:{ all -> 0x0068 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x0068 }
            r7.<init>(r8)     // Catch:{ all -> 0x0068 }
            long r7 = r7.getAvailableBytes()     // Catch:{ all -> 0x0068 }
            r0 = r7
            goto L_0x0068
        L_0x0031:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0068 }
            r3 = 21
            if (r2 < r3) goto L_0x0068
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0068 }
            android.net.Uri r8 = r8.getUri()     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r7 = r7.openFileDescriptor(r8, r2)     // Catch:{ all -> 0x0068 }
            if (r7 != 0) goto L_0x0048
            goto L_0x0068
        L_0x0048:
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x0068 }
            r8 = 0
            r2 = r7
            android.os.ParcelFileDescriptor r2 = (android.os.ParcelFileDescriptor) r2     // Catch:{ all -> 0x0061 }
            java.io.FileDescriptor r2 = r2.getFileDescriptor()     // Catch:{ all -> 0x0061 }
            android.system.StructStatVfs r2 = android.system.Os.fstatvfs(r2)     // Catch:{ all -> 0x0061 }
            long r3 = r2.f_bavail     // Catch:{ all -> 0x0061 }
            long r5 = r2.f_frsize     // Catch:{ all -> 0x0061 }
            long r3 = r3 * r5
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x0068 }
            r0 = r3
            goto L_0x0068
        L_0x0061:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x0068 }
            throw r2     // Catch:{ all -> 0x0068 }
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getFreeSpace(android.content.Context, java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        throw r2;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getUsedSpace(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "storageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            com.anggrayudi.storage.file.DocumentFileCompat r2 = INSTANCE     // Catch:{ all -> 0x0077 }
            androidx.documentfile.provider.DocumentFile r10 = r2.getDocumentFileForStorageInfo(r9, r10)     // Catch:{ all -> 0x0077 }
            if (r10 != 0) goto L_0x0015
            return r0
        L_0x0015:
            boolean r2 = com.anggrayudi.storage.file.DocumentFileUtils.isRawFile(r10)     // Catch:{ all -> 0x0077 }
            if (r2 == 0) goto L_0x0036
            android.os.StatFs r9 = new android.os.StatFs     // Catch:{ all -> 0x0077 }
            android.net.Uri r10 = r10.getUri()     // Catch:{ all -> 0x0077 }
            java.lang.String r10 = r10.getPath()     // Catch:{ all -> 0x0077 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)     // Catch:{ all -> 0x0077 }
            r9.<init>(r10)     // Catch:{ all -> 0x0077 }
            long r2 = r9.getTotalBytes()     // Catch:{ all -> 0x0077 }
            long r9 = r9.getAvailableBytes()     // Catch:{ all -> 0x0077 }
            long r2 = r2 - r9
            r0 = r2
            goto L_0x0077
        L_0x0036:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0077 }
            r3 = 21
            if (r2 < r3) goto L_0x0077
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch:{ all -> 0x0077 }
            android.net.Uri r10 = r10.getUri()     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r9 = r9.openFileDescriptor(r10, r2)     // Catch:{ all -> 0x0077 }
            if (r9 != 0) goto L_0x004d
            goto L_0x0077
        L_0x004d:
            java.io.Closeable r9 = (java.io.Closeable) r9     // Catch:{ all -> 0x0077 }
            r10 = 0
            r2 = r9
            android.os.ParcelFileDescriptor r2 = (android.os.ParcelFileDescriptor) r2     // Catch:{ all -> 0x0070 }
            java.io.FileDescriptor r2 = r2.getFileDescriptor()     // Catch:{ all -> 0x0070 }
            android.system.StructStatVfs r2 = android.system.Os.fstatvfs(r2)     // Catch:{ all -> 0x0070 }
            long r3 = r2.f_blocks     // Catch:{ all -> 0x0070 }
            long r5 = r2.f_frsize     // Catch:{ all -> 0x0070 }
            long r3 = r3 * r5
            long r5 = r2.f_bavail     // Catch:{ all -> 0x0070 }
            long r7 = r2.f_frsize     // Catch:{ all -> 0x0070 }
            java.lang.Long.signum(r5)
            long r5 = r5 * r7
            long r3 = r3 - r5
            kotlin.io.CloseableKt.closeFinally(r9, r10)     // Catch:{ all -> 0x0077 }
            r0 = r3
            goto L_0x0077
        L_0x0070:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r9, r10)     // Catch:{ all -> 0x0077 }
            throw r2     // Catch:{ all -> 0x0077 }
        L_0x0077:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getUsedSpace(android.content.Context, java.lang.String):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0063, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0067, code lost:
        throw r2;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long getStorageCapacity(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "storageId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            com.anggrayudi.storage.file.DocumentFileCompat r2 = INSTANCE     // Catch:{ all -> 0x0068 }
            androidx.documentfile.provider.DocumentFile r8 = r2.getDocumentFileForStorageInfo(r7, r8)     // Catch:{ all -> 0x0068 }
            if (r8 != 0) goto L_0x0015
            return r0
        L_0x0015:
            boolean r2 = com.anggrayudi.storage.file.DocumentFileUtils.isRawFile(r8)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x0031
            android.os.StatFs r7 = new android.os.StatFs     // Catch:{ all -> 0x0068 }
            android.net.Uri r8 = r8.getUri()     // Catch:{ all -> 0x0068 }
            java.lang.String r8 = r8.getPath()     // Catch:{ all -> 0x0068 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x0068 }
            r7.<init>(r8)     // Catch:{ all -> 0x0068 }
            long r7 = r7.getTotalBytes()     // Catch:{ all -> 0x0068 }
            r0 = r7
            goto L_0x0068
        L_0x0031:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0068 }
            r3 = 21
            if (r2 < r3) goto L_0x0068
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0068 }
            android.net.Uri r8 = r8.getUri()     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = "r"
            android.os.ParcelFileDescriptor r7 = r7.openFileDescriptor(r8, r2)     // Catch:{ all -> 0x0068 }
            if (r7 != 0) goto L_0x0048
            goto L_0x0068
        L_0x0048:
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x0068 }
            r8 = 0
            r2 = r7
            android.os.ParcelFileDescriptor r2 = (android.os.ParcelFileDescriptor) r2     // Catch:{ all -> 0x0061 }
            java.io.FileDescriptor r2 = r2.getFileDescriptor()     // Catch:{ all -> 0x0061 }
            android.system.StructStatVfs r2 = android.system.Os.fstatvfs(r2)     // Catch:{ all -> 0x0061 }
            long r3 = r2.f_blocks     // Catch:{ all -> 0x0061 }
            long r5 = r2.f_frsize     // Catch:{ all -> 0x0061 }
            long r3 = r3 * r5
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x0068 }
            r0 = r3
            goto L_0x0068
        L_0x0061:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r8)     // Catch:{ all -> 0x0068 }
            throw r2     // Catch:{ all -> 0x0068 }
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileCompat.getStorageCapacity(android.content.Context, java.lang.String):long");
    }

    private final DocumentFile getDocumentFileForStorageInfo(Context context, String str) {
        if (Intrinsics.areEqual((Object) str, (Object) StorageId.PRIMARY)) {
            File externalFilesDir = context.getExternalFilesDir((String) null);
            if (externalFilesDir == null) {
                return null;
            }
            return DocumentFile.fromFile(externalFilesDir);
        } else if (Intrinsics.areEqual((Object) str, (Object) "data")) {
            return DocumentFile.fromFile(FileUtils.getDataDirectory(context));
        } else {
            File file = new File("/storage/" + str + "/Android/data/" + context.getPackageName() + "/files");
            file.mkdirs();
            if (file.canRead()) {
                return DocumentFile.fromFile(file);
            }
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "folder.absolutePath");
            return getAccessibleRootDocumentFile$default(context, absolutePath, false, false, 4, (Object) null);
        }
    }

    @JvmStatic
    public static final String getFileNameFromUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        try {
            String decode = URLDecoder.decode(str, "UTF-8");
            Intrinsics.checkNotNullExpressionValue(decode, "decode(url, \"UTF-8\")");
            return StringsKt.substringAfterLast$default(decode, '/', (String) null, 2, (Object) null);
        } catch (Exception unused) {
            return str;
        }
    }
}
