package com.anggrayudi.storage.media;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.file.CreateMode;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.file.PublicDirectory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J$\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J.\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J2\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J,\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J.\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\"\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\"\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J&\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0004H\u0007J&\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0007J\"\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)H\u0007J\"\u0010'\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0004H\u0007J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J&\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0004H\u0007J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0007J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\"2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0004H\u0007J\"\u0010-\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0012\u00101\u001a\u0004\u0018\u00010\u00172\u0006\u00102\u001a\u00020\u0004H\u0003R\u001a\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u00063"}, d2 = {"Lcom/anggrayudi/storage/media/MediaStoreCompat;", "", "()V", "volumeName", "", "getVolumeName$annotations", "getVolumeName", "()Ljava/lang/String;", "createAudio", "Lcom/anggrayudi/storage/media/MediaFile;", "context", "Landroid/content/Context;", "file", "Lcom/anggrayudi/storage/media/FileDescription;", "relativeParentDirectory", "Lcom/anggrayudi/storage/media/AudioMediaDirectory;", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "createDownload", "createImage", "Lcom/anggrayudi/storage/media/ImageMediaDirectory;", "createMedia", "mediaType", "Lcom/anggrayudi/storage/media/MediaType;", "folderName", "fullPath", "createVideo", "Lcom/anggrayudi/storage/media/VideoMediaDirectory;", "fromBasePath", "basePath", "fromCursorToMediaFile", "cursor", "Landroid/database/Cursor;", "fromCursorToMediaFiles", "", "fromFileName", "name", "fromFileNameContains", "containsName", "fromMediaId", "id", "", "fromMediaType", "fromMimeType", "mimeType", "fromRelativePath", "publicDirectory", "Lcom/anggrayudi/storage/file/PublicDirectory;", "relativePath", "mediaTypeFromRelativePath", "cleanRelativePath", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaStoreCompat.kt */
public final class MediaStoreCompat {
    public static final MediaStoreCompat INSTANCE = new MediaStoreCompat();

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription fileDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        return createAudio$default(context, fileDescription, (AudioMediaDirectory) null, (CreateMode) null, 12, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription fileDescription, AudioMediaDirectory audioMediaDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(audioMediaDirectory, "relativeParentDirectory");
        return createAudio$default(context, fileDescription, audioMediaDirectory, (CreateMode) null, 8, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createDownload(Context context, FileDescription fileDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        return createDownload$default(context, fileDescription, (CreateMode) null, 4, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription fileDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        return createImage$default(context, fileDescription, (ImageMediaDirectory) null, (CreateMode) null, 12, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription fileDescription, ImageMediaDirectory imageMediaDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(imageMediaDirectory, "relativeParentDirectory");
        return createImage$default(context, fileDescription, imageMediaDirectory, (CreateMode) null, 8, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createMedia(Context context, String str, FileDescription fileDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        return createMedia$default(context, str, fileDescription, (CreateMode) null, 8, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription fileDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        return createVideo$default(context, fileDescription, (VideoMediaDirectory) null, (CreateMode) null, 12, (Object) null);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription fileDescription, VideoMediaDirectory videoMediaDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(videoMediaDirectory, "relativeParentDirectory");
        return createVideo$default(context, fileDescription, videoMediaDirectory, (CreateMode) null, 8, (Object) null);
    }

    @JvmStatic
    public static /* synthetic */ void getVolumeName$annotations() {
    }

    private MediaStoreCompat() {
    }

    public static final String getVolumeName() {
        return Build.VERSION.SDK_INT < 29 ? "external" : "external_primary";
    }

    public static /* synthetic */ MediaFile createDownload$default(Context context, FileDescription fileDescription, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createDownload(context, fileDescription, createMode);
    }

    @JvmStatic
    public static final MediaFile createDownload(Context context, FileDescription fileDescription, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        MediaStoreCompat mediaStoreCompat = INSTANCE;
        MediaType mediaType = MediaType.DOWNLOADS;
        String str = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(str, "DIRECTORY_DOWNLOADS");
        return mediaStoreCompat.createMedia(context, mediaType, str, fileDescription, createMode);
    }

    public static /* synthetic */ MediaFile createImage$default(Context context, FileDescription fileDescription, ImageMediaDirectory imageMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            imageMediaDirectory = ImageMediaDirectory.PICTURES;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createImage(context, fileDescription, imageMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createImage(Context context, FileDescription fileDescription, ImageMediaDirectory imageMediaDirectory, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(imageMediaDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        return INSTANCE.createMedia(context, MediaType.IMAGE, imageMediaDirectory.getFolderName(), fileDescription, createMode);
    }

    public static /* synthetic */ MediaFile createAudio$default(Context context, FileDescription fileDescription, AudioMediaDirectory audioMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            audioMediaDirectory = AudioMediaDirectory.MUSIC;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createAudio(context, fileDescription, audioMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createAudio(Context context, FileDescription fileDescription, AudioMediaDirectory audioMediaDirectory, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(audioMediaDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        return INSTANCE.createMedia(context, MediaType.AUDIO, audioMediaDirectory.getFolderName(), fileDescription, createMode);
    }

    public static /* synthetic */ MediaFile createVideo$default(Context context, FileDescription fileDescription, VideoMediaDirectory videoMediaDirectory, CreateMode createMode, int i, Object obj) {
        if ((i & 4) != 0) {
            videoMediaDirectory = VideoMediaDirectory.MOVIES;
        }
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createVideo(context, fileDescription, videoMediaDirectory, createMode);
    }

    @JvmStatic
    public static final MediaFile createVideo(Context context, FileDescription fileDescription, VideoMediaDirectory videoMediaDirectory, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(videoMediaDirectory, "relativeParentDirectory");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        return INSTANCE.createMedia(context, MediaType.VIDEO, videoMediaDirectory.getFolderName(), fileDescription, createMode);
    }

    public static /* synthetic */ MediaFile createMedia$default(Context context, String str, FileDescription fileDescription, CreateMode createMode, int i, Object obj) {
        if ((i & 8) != 0) {
            createMode = CreateMode.CREATE_NEW;
        }
        return createMedia(context, str, fileDescription, createMode);
    }

    @JvmStatic
    public static final MediaFile createMedia(Context context, String str, FileDescription fileDescription, CreateMode createMode) {
        MediaType mediaType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fullPath");
        Intrinsics.checkNotNullParameter(fileDescription, "file");
        Intrinsics.checkNotNullParameter(createMode, "mode");
        String trimFileSeparator = TextUtils.trimFileSeparator(DocumentFileCompat.getBasePath(context, str));
        int i = 0;
        if (trimFileSeparator.length() == 0) {
            return null;
        }
        String substringBefore$default = StringsKt.substringBefore$default(trimFileSeparator, '/', (String) null, 2, (Object) null);
        if (Intrinsics.areEqual((Object) substringBefore$default, (Object) Environment.DIRECTORY_DOWNLOADS)) {
            mediaType = MediaType.DOWNLOADS;
        } else {
            ImageMediaDirectory[] values = ImageMediaDirectory.values();
            Collection arrayList = new ArrayList(values.length);
            int length = values.length;
            int i2 = 0;
            while (i2 < length) {
                ImageMediaDirectory imageMediaDirectory = values[i2];
                i2++;
                arrayList.add(imageMediaDirectory.getFolderName());
            }
            if (((List) arrayList).contains(substringBefore$default)) {
                mediaType = MediaType.IMAGE;
            } else {
                AudioMediaDirectory[] values2 = AudioMediaDirectory.values();
                Collection arrayList2 = new ArrayList(values2.length);
                int length2 = values2.length;
                int i3 = 0;
                while (i3 < length2) {
                    AudioMediaDirectory audioMediaDirectory = values2[i3];
                    i3++;
                    arrayList2.add(audioMediaDirectory.getFolderName());
                }
                if (((List) arrayList2).contains(substringBefore$default)) {
                    mediaType = MediaType.AUDIO;
                } else {
                    VideoMediaDirectory[] values3 = VideoMediaDirectory.values();
                    Collection arrayList3 = new ArrayList(values3.length);
                    int length3 = values3.length;
                    while (i < length3) {
                        VideoMediaDirectory videoMediaDirectory = values3[i];
                        i++;
                        arrayList3.add(videoMediaDirectory.getFolderName());
                    }
                    if (!((List) arrayList3).contains(substringBefore$default)) {
                        return null;
                    }
                    mediaType = MediaType.VIDEO;
                }
            }
        }
        MediaType mediaType2 = mediaType;
        String substringAfter = StringsKt.substringAfter(trimFileSeparator, '/', "");
        fileDescription.setSubFolder(TextUtils.trimFileSeparator(substringAfter + '/' + fileDescription.getSubFolder()));
        return INSTANCE.createMedia(context, mediaType2, substringBefore$default, fileDescription, createMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x0176 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.anggrayudi.storage.media.MediaFile createMedia(android.content.Context r21, com.anggrayudi.storage.media.MediaType r22, java.lang.String r23, com.anggrayudi.storage.media.FileDescription r24, com.anggrayudi.storage.file.CreateMode r25) {
        /*
            r20 = this;
            r0 = r21
            r1 = r22
            r2 = r25
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 47
            r5 = 0
            r6 = 29
            if (r3 < r6) goto L_0x02ae
            long r6 = java.lang.System.currentTimeMillis()
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r8 = r24.getName()
            java.lang.String r9 = "_display_name"
            r3.put(r9, r8)
            java.lang.String r8 = r24.getMimeType()
            java.lang.String r10 = "mime_type"
            r3.put(r10, r8)
            java.lang.Long r8 = java.lang.Long.valueOf(r6)
            java.lang.String r10 = "date_added"
            r3.put(r10, r8)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            java.lang.String r7 = "date_modified"
            r3.put(r7, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = r23
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = r24.getSubFolder()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r6)
            java.lang.String r7 = r21.getPackageName()
            java.lang.String r8 = "owner_package_name"
            r3.put(r8, r7)
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r8 = kotlin.text.StringsKt.isBlank(r7)
            r10 = 1
            r8 = r8 ^ r10
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = "relative_path"
            r3.put(r8, r6)
        L_0x0071:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r8.append(r4)
            java.lang.String r4 = r24.getName()
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.anggrayudi.storage.media.MediaFile r4 = fromBasePath(r0, r1, r4)
            if (r4 != 0) goto L_0x008f
        L_0x008d:
            r11 = 0
            goto L_0x0096
        L_0x008f:
            boolean r11 = r4.isEmpty()
            if (r11 != r10) goto L_0x008d
            r11 = 1
        L_0x0096:
            if (r11 == 0) goto L_0x009b
        L_0x0098:
            r5 = r4
            goto L_0x0320
        L_0x009b:
            if (r4 != 0) goto L_0x009f
        L_0x009d:
            r11 = 0
            goto L_0x00a6
        L_0x009f:
            boolean r11 = r4.getExists()
            if (r11 != r10) goto L_0x009d
            r11 = 1
        L_0x00a6:
            if (r11 == 0) goto L_0x0293
            com.anggrayudi.storage.file.CreateMode r11 = com.anggrayudi.storage.file.CreateMode.REUSE
            if (r2 != r11) goto L_0x00ad
            return r4
        L_0x00ad:
            com.anggrayudi.storage.file.CreateMode r11 = com.anggrayudi.storage.file.CreateMode.REPLACE
            if (r2 != r11) goto L_0x00cc
            r4.delete()
            com.anggrayudi.storage.media.MediaFile r2 = new com.anggrayudi.storage.media.MediaFile
            android.content.ContentResolver r4 = r21.getContentResolver()
            android.net.Uri r1 = r22.getWriteUri()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.net.Uri r1 = r4.insert(r1, r3)
            if (r1 != 0) goto L_0x00c8
            return r5
        L_0x00c8:
            r2.<init>((android.content.Context) r0, (android.net.Uri) r1)
            return r2
        L_0x00cc:
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r4 = r24.getMimeType()
            java.lang.String r2 = r2.getExtensionFromMimeType(r4)
            java.lang.String r4 = ""
            r11 = 46
            if (r2 != 0) goto L_0x00e6
            java.lang.String r2 = r24.getName()
            java.lang.String r2 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r2, (char) r11, (java.lang.String) r4)
        L_0x00e6:
            java.lang.String r12 = "MimeTypeMap.getSingleton…bstringAfterLast('.', \"\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r12)
            java.lang.String r12 = r24.getName()
            r13 = 2
            java.lang.String r12 = kotlin.text.StringsKt.substringBeforeLast$default((java.lang.String) r12, (char) r11, (java.lang.String) r5, (int) r13, (java.lang.Object) r5)
            java.lang.String r14 = " ("
            java.lang.String r15 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r14)
            java.util.List r16 = fromFileNameContains(r0, r1, r12)
            java.lang.Iterable r16 = (java.lang.Iterable) r16
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            r11 = r17
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r16 = r16.iterator()
        L_0x010d:
            boolean r17 = r16.hasNext()
            if (r17 == 0) goto L_0x0141
            java.lang.Object r10 = r16.next()
            r18 = r10
            com.anggrayudi.storage.media.MediaFile r18 = (com.anggrayudi.storage.media.MediaFile) r18
            boolean r19 = kotlin.text.StringsKt.isBlank(r7)
            if (r19 != 0) goto L_0x0138
            java.lang.String r5 = r18.getRelativePath()
            java.lang.String r18 = "/"
            r8 = r18
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r5 = kotlin.text.StringsKt.removeSuffix((java.lang.String) r5, (java.lang.CharSequence) r8)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r5 = 0
            goto L_0x0139
        L_0x0138:
            r5 = 1
        L_0x0139:
            if (r5 == 0) goto L_0x013e
            r11.add(r10)
        L_0x013e:
            r5 = 0
            r10 = 1
            goto L_0x010d
        L_0x0141:
            java.util.List r11 = (java.util.List) r11
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r6 = r11.iterator()
        L_0x0150:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0167
            java.lang.Object r7 = r6.next()
            com.anggrayudi.storage.media.MediaFile r7 = (com.anggrayudi.storage.media.MediaFile) r7
            java.lang.String r7 = r7.getName()
            if (r7 != 0) goto L_0x0163
            goto L_0x0150
        L_0x0163:
            r5.add(r7)
            goto L_0x0150
        L_0x0167:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x0176:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x01ae
            java.lang.Object r7 = r5.next()
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            r10 = 0
            r11 = 0
            boolean r16 = kotlin.text.StringsKt.startsWith$default(r8, r15, r11, r13, r10)
            if (r16 == 0) goto L_0x01a7
            com.anggrayudi.storage.file.DocumentFileCompat r10 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r10 = r10.getFILE_NAME_DUPLICATION_REGEX_WITH_EXTENSION()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r10 = r10.matches(r8)
            if (r10 != 0) goto L_0x01a5
            com.anggrayudi.storage.file.DocumentFileCompat r10 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            kotlin.text.Regex r10 = r10.getFILE_NAME_DUPLICATION_REGEX_WITHOUT_EXTENSION()
            boolean r8 = r10.matches(r8)
            if (r8 == 0) goto L_0x01a7
        L_0x01a5:
            r8 = 1
            goto L_0x01a8
        L_0x01a7:
            r8 = 0
        L_0x01a8:
            if (r8 == 0) goto L_0x0176
            r6.add(r7)
            goto L_0x0176
        L_0x01ae:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            boolean r6 = r5.hasNext()
            if (r6 != 0) goto L_0x01be
            r6 = 0
            goto L_0x01dc
        L_0x01be:
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Comparable r6 = (java.lang.Comparable) r6
        L_0x01c6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x01dc
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Comparable r7 = (java.lang.Comparable) r7
            int r8 = r6.compareTo(r7)
            if (r8 >= 0) goto L_0x01c6
            r6 = r7
            goto L_0x01c6
        L_0x01dc:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 != 0) goto L_0x01e1
            r6 = r4
        L_0x01e1:
            r5 = 40
            java.lang.String r5 = kotlin.text.StringsKt.substringAfterLast((java.lang.String) r6, (char) r5, (java.lang.String) r4)
            r6 = 41
            java.lang.String r4 = kotlin.text.StringsKt.substringBefore((java.lang.String) r5, (char) r6, (java.lang.String) r4)
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)
            if (r4 != 0) goto L_0x01f5
            r11 = 0
            goto L_0x01fa
        L_0x01f5:
            int r4 = r4.intValue()
            r11 = r4
        L_0x01fa:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            r4.append(r14)
            r4.append(r11)
            java.lang.String r5 = ")."
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r6 = 1
            char[] r7 = new char[r6]
            r6 = 46
            r8 = 0
            r7[r8] = r6
            java.lang.String r4 = kotlin.text.StringsKt.trimEnd((java.lang.String) r4, (char[]) r7)
            com.anggrayudi.storage.media.MediaFile r4 = fromFileName(r0, r1, r4)
            if (r4 != 0) goto L_0x0229
        L_0x0226:
            r6 = 1
        L_0x0227:
            r7 = 0
            goto L_0x0246
        L_0x0229:
            java.io.InputStream r6 = r4.openInputStream()
            if (r6 != 0) goto L_0x0230
            goto L_0x0226
        L_0x0230:
            java.io.Closeable r6 = (java.io.Closeable) r6
            r7 = r6
            java.io.InputStream r7 = (java.io.InputStream) r7     // Catch:{ all -> 0x028a }
            int r7 = r7.available()     // Catch:{ all -> 0x028a }
            if (r7 != 0) goto L_0x023d
            r7 = 1
            goto L_0x023e
        L_0x023d:
            r7 = 0
        L_0x023e:
            r8 = 0
            kotlin.io.CloseableKt.closeFinally(r6, r8)
            r6 = 1
            if (r7 != r6) goto L_0x0227
            r7 = 1
        L_0x0246:
            if (r7 == 0) goto L_0x024a
            goto L_0x0098
        L_0x024a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            r4.append(r14)
            int r11 = r11 + r6
            r4.append(r11)
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            char[] r4 = new char[r6]
            r5 = 46
            r6 = 0
            r4[r6] = r5
            java.lang.String r2 = kotlin.text.StringsKt.trimEnd((java.lang.String) r2, (char[]) r4)
            r3.put(r9, r2)
            com.anggrayudi.storage.media.MediaFile r2 = new com.anggrayudi.storage.media.MediaFile
            android.content.ContentResolver r4 = r21.getContentResolver()
            android.net.Uri r1 = r22.getWriteUri()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.net.Uri r1 = r4.insert(r1, r3)
            if (r1 != 0) goto L_0x0286
            r3 = 0
            return r3
        L_0x0286:
            r2.<init>((android.content.Context) r0, (android.net.Uri) r1)
            goto L_0x02ab
        L_0x028a:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x028d }
        L_0x028d:
            r0 = move-exception
            r2 = r0
            kotlin.io.CloseableKt.closeFinally(r6, r1)
            throw r2
        L_0x0293:
            com.anggrayudi.storage.media.MediaFile r2 = new com.anggrayudi.storage.media.MediaFile
            android.content.ContentResolver r4 = r21.getContentResolver()
            android.net.Uri r1 = r22.getWriteUri()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.net.Uri r1 = r4.insert(r1, r3)
            if (r1 != 0) goto L_0x02a8
            r3 = 0
            return r3
        L_0x02a8:
            r2.<init>((android.content.Context) r0, (android.net.Uri) r1)
        L_0x02ab:
            r5 = r2
            goto L_0x0320
        L_0x02ae:
            r7 = r23
            java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r23)
            java.lang.String r3 = "publicDirectory"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r3 = com.anggrayudi.storage.file.FileUtils.canModify(r1, r0)
            if (r3 == 0) goto L_0x031c
            java.lang.String r3 = r24.getFullName()
            java.io.File r5 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r1)
            r6.append(r4)
            java.lang.String r1 = r24.getSubFolder()
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r5.<init>(r1, r3)
            java.io.File r1 = r5.getParentFile()
            if (r1 != 0) goto L_0x02e6
            r4 = 0
            return r4
        L_0x02e6:
            r1.mkdirs()
            boolean r4 = r5.exists()
            if (r4 == 0) goto L_0x02fb
            com.anggrayudi.storage.file.CreateMode r4 = com.anggrayudi.storage.file.CreateMode.CREATE_NEW
            if (r2 != r4) goto L_0x02fb
            java.lang.String r3 = com.anggrayudi.storage.file.FileUtils.autoIncrementFileName(r1, r3)
            java.io.File r5 = com.anggrayudi.storage.file.FileUtils.child(r1, r3)
        L_0x02fb:
            com.anggrayudi.storage.file.CreateMode r1 = com.anggrayudi.storage.file.CreateMode.REPLACE
            if (r2 != r1) goto L_0x0307
            boolean r1 = com.anggrayudi.storage.file.FileUtils.recreateFile(r5)
            if (r1 != 0) goto L_0x0307
            r1 = 0
            return r1
        L_0x0307:
            boolean r1 = com.anggrayudi.storage.file.FileUtils.createNewFileIfPossible(r5)
            if (r1 == 0) goto L_0x031a
            boolean r1 = r5.canRead()
            if (r1 == 0) goto L_0x031a
            com.anggrayudi.storage.media.MediaFile r1 = new com.anggrayudi.storage.media.MediaFile
            r1.<init>((android.content.Context) r0, (java.io.File) r5)
            r5 = r1
            goto L_0x0320
        L_0x031a:
            r5 = 0
            goto L_0x0320
        L_0x031c:
            r0 = 0
            r5 = r0
            com.anggrayudi.storage.media.MediaFile r5 = (com.anggrayudi.storage.media.MediaFile) r5
        L_0x0320:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.createMedia(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String, com.anggrayudi.storage.media.FileDescription, com.anggrayudi.storage.file.CreateMode):com.anggrayudi.storage.media.MediaFile");
    }

    @JvmStatic
    public static final MediaFile fromMediaId(Context context, MediaType mediaType, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(str, "id");
        Uri writeUri = mediaType.getWriteUri();
        if (writeUri == null) {
            return null;
        }
        Uri build = writeUri.buildUpon().appendPath(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "it.buildUpon().appendPath(id).build()");
        return new MediaFile(context, build);
    }

    @JvmStatic
    public static final MediaFile fromMediaId(Context context, MediaType mediaType, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return fromMediaId(context, mediaType, String.valueOf(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        throw r9;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.anggrayudi.storage.media.MediaFile fromFileName(android.content.Context r8, com.anggrayudi.storage.media.MediaType r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "mediaType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r0 >= r2) goto L_0x0033
            java.io.File r9 = new java.io.File
            java.lang.String r0 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            r9.<init>(r0, r10)
            boolean r10 = r9.isFile()
            if (r10 == 0) goto L_0x0063
            boolean r10 = r9.canRead()
            if (r10 == 0) goto L_0x0063
            com.anggrayudi.storage.media.MediaFile r1 = new com.anggrayudi.storage.media.MediaFile
            r1.<init>((android.content.Context) r8, (java.io.File) r9)
            goto L_0x0063
        L_0x0033:
            android.content.ContentResolver r2 = r8.getContentResolver()
            android.net.Uri r3 = r9.getReadUri()
            if (r3 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.String r0 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]
            r0 = 0
            r6[r0] = r10
            r7 = 0
            java.lang.String r5 = "_display_name = ?"
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)
            if (r10 != 0) goto L_0x0054
            goto L_0x0063
        L_0x0054:
            java.io.Closeable r10 = (java.io.Closeable) r10
            r0 = r10
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0064 }
            com.anggrayudi.storage.media.MediaStoreCompat r2 = INSTANCE     // Catch:{ all -> 0x0064 }
            com.anggrayudi.storage.media.MediaFile r8 = r2.fromCursorToMediaFile(r8, r9, r0)     // Catch:{ all -> 0x0064 }
            kotlin.io.CloseableKt.closeFinally(r10, r1)
            r1 = r8
        L_0x0063:
            return r1
        L_0x0064:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r9 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromFileName(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String):com.anggrayudi.storage.media.MediaFile");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        kotlin.io.CloseableKt.closeFinally(r14, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        throw r13;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.anggrayudi.storage.media.MediaFile fromBasePath(android.content.Context r12, com.anggrayudi.storage.media.MediaType r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "mediaType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "basePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.anggrayudi.storage.file.DocumentFileCompat r0 = com.anggrayudi.storage.file.DocumentFileCompat.INSTANCE
            java.lang.String r14 = r0.removeForbiddenCharsFromFilename$storage_release(r14)
            java.lang.String r14 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r14)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 29
            if (r0 >= r2) goto L_0x003b
            java.io.File r13 = new java.io.File
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()
            r13.<init>(r0, r14)
            boolean r14 = r13.isFile()
            if (r14 == 0) goto L_0x008f
            boolean r14 = r13.canRead()
            if (r14 == 0) goto L_0x008f
            com.anggrayudi.storage.media.MediaFile r1 = new com.anggrayudi.storage.media.MediaFile
            r1.<init>((android.content.Context) r12, (java.io.File) r13)
            goto L_0x008f
        L_0x003b:
            r0 = 47
            java.lang.String r2 = ""
            java.lang.String r2 = kotlin.text.StringsKt.substringBeforeLast((java.lang.String) r14, (char) r0, (java.lang.String) r2)
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0050
            r3 = 1
            goto L_0x0051
        L_0x0050:
            r3 = 0
        L_0x0051:
            if (r3 == 0) goto L_0x0054
            return r1
        L_0x0054:
            r3 = 2
            java.lang.String r14 = kotlin.text.StringsKt.substringAfterLast$default((java.lang.String) r14, (char) r0, (java.lang.String) r1, (int) r3, (java.lang.Object) r1)
            android.content.ContentResolver r6 = r12.getContentResolver()
            android.net.Uri r7 = r13.getReadUri()
            if (r7 != 0) goto L_0x0064
            return r1
        L_0x0064:
            java.lang.String r0 = "_id"
            java.lang.String[] r8 = new java.lang.String[]{r0}
            java.lang.String[] r10 = new java.lang.String[r3]
            r10[r5] = r14
            java.lang.String r14 = "/"
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r14)
            r10[r4] = r14
            r11 = 0
            java.lang.String r9 = "_display_name = ? AND relative_path = ?"
            android.database.Cursor r14 = r6.query(r7, r8, r9, r10, r11)
            if (r14 != 0) goto L_0x0080
            goto L_0x008f
        L_0x0080:
            java.io.Closeable r14 = (java.io.Closeable) r14
            r0 = r14
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0090 }
            com.anggrayudi.storage.media.MediaStoreCompat r2 = INSTANCE     // Catch:{ all -> 0x0090 }
            com.anggrayudi.storage.media.MediaFile r12 = r2.fromCursorToMediaFile(r12, r13, r0)     // Catch:{ all -> 0x0090 }
            kotlin.io.CloseableKt.closeFinally(r14, r1)
            r1 = r12
        L_0x008f:
            return r1
        L_0x0090:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0092 }
        L_0x0092:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r14, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromBasePath(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String):com.anggrayudi.storage.media.MediaFile");
    }

    private final MediaType mediaTypeFromRelativePath(String str) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_DCIM) ? true : Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_PICTURES)) {
            return MediaType.IMAGE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_MOVIES) ? true : Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_DCIM)) {
            return MediaType.VIDEO;
        }
        if (Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_MUSIC) ? true : Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_PODCASTS) ? true : Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_RINGTONES)) {
            z = true;
        } else {
            z = Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_ALARMS);
        }
        if (!z) {
            z2 = Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_NOTIFICATIONS);
        }
        if (z2) {
            return MediaType.AUDIO;
        }
        if (Intrinsics.areEqual((Object) str, (Object) Environment.DIRECTORY_DOWNLOADS)) {
            return MediaType.DOWNLOADS;
        }
        return null;
    }

    @JvmStatic
    public static final List<MediaFile> fromRelativePath(Context context, PublicDirectory publicDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(publicDirectory, "publicDirectory");
        return fromRelativePath(context, publicDirectory.getFolderName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cc, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
        kotlin.io.CloseableKt.closeFinally(r13, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        throw r0;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.anggrayudi.storage.media.MediaFile> fromRelativePath(android.content.Context r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "relativePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r13)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 >= r2) goto L_0x006e
            java.io.File r13 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            r13.<init>(r1, r0)
            androidx.documentfile.provider.DocumentFile r2 = androidx.documentfile.provider.DocumentFile.fromFile(r13)
            java.lang.String r13 = "fromFile(File(Environmen…ry(), cleanRelativePath))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            r3 = 1
            com.anggrayudi.storage.file.DocumentFileType r4 = com.anggrayudi.storage.file.DocumentFileType.FILE
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 28
            r9 = 0
            java.util.List r13 = com.anggrayudi.storage.file.DocumentFileUtils.search$default(r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r13 = r13.iterator()
        L_0x0046:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x006b
            java.lang.Object r1 = r13.next()
            androidx.documentfile.provider.DocumentFile r1 = (androidx.documentfile.provider.DocumentFile) r1
            com.anggrayudi.storage.media.MediaFile r2 = new com.anggrayudi.storage.media.MediaFile
            java.io.File r3 = new java.io.File
            android.net.Uri r1 = r1.getUri()
            java.lang.String r1 = r1.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r3.<init>(r1)
            r2.<init>((android.content.Context) r12, (java.io.File) r3)
            r0.add(r2)
            goto L_0x0046
        L_0x006b:
            java.util.List r0 = (java.util.List) r0
            return r0
        L_0x006e:
            com.anggrayudi.storage.media.MediaStoreCompat r1 = INSTANCE
            com.anggrayudi.storage.media.MediaType r1 = r1.mediaTypeFromRelativePath(r0)
            if (r1 != 0) goto L_0x007b
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            return r12
        L_0x007b:
            r2 = 1
            char[] r3 = new char[r2]
            r4 = 47
            r5 = 0
            r3[r5] = r4
            java.lang.String r13 = kotlin.text.StringsKt.trimEnd((java.lang.String) r13, (char[]) r3)
            java.lang.String r3 = "/"
            java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r3)
            r3 = 2
            java.lang.String[] r10 = new java.lang.String[r3]
            r10[r5] = r13
            r10[r2] = r0
            android.content.ContentResolver r6 = r12.getContentResolver()
            android.net.Uri r7 = r1.getReadUri()
            if (r7 != 0) goto L_0x00a3
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            return r12
        L_0x00a3:
            java.lang.String r13 = "_id"
            java.lang.String[] r8 = new java.lang.String[]{r13}
            r11 = 0
            java.lang.String r9 = "relative_path IN(?, ?)"
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)
            r0 = 0
            if (r13 != 0) goto L_0x00b4
            goto L_0x00c3
        L_0x00b4:
            java.io.Closeable r13 = (java.io.Closeable) r13
            r2 = r13
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x00ca }
            com.anggrayudi.storage.media.MediaStoreCompat r3 = INSTANCE     // Catch:{ all -> 0x00ca }
            java.util.List r12 = r3.fromCursorToMediaFiles(r12, r1, r2)     // Catch:{ all -> 0x00ca }
            kotlin.io.CloseableKt.closeFinally(r13, r0)
            r0 = r12
        L_0x00c3:
            if (r0 != 0) goto L_0x00c9
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00c9:
            return r0
        L_0x00ca:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r13, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromRelativePath(android.content.Context, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cc, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cd, code lost:
        kotlin.io.CloseableKt.closeFinally(r14, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d0, code lost:
        throw r15;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.anggrayudi.storage.media.MediaFile fromRelativePath(android.content.Context r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "relativePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = com.anggrayudi.storage.extension.TextUtils.trimFileSeparator(r14)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r1 >= r2) goto L_0x0079
            java.io.File r14 = new java.io.File
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            r14.<init>(r1, r0)
            androidx.documentfile.provider.DocumentFile r2 = androidx.documentfile.provider.DocumentFile.fromFile(r14)
            java.lang.String r14 = "fromFile(File(Environmen…ry(), cleanRelativePath))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            r3 = 1
            com.anggrayudi.storage.file.DocumentFileType r4 = com.anggrayudi.storage.file.DocumentFileType.FILE
            r5 = 0
            r7 = 0
            r8 = 20
            r9 = 0
            r6 = r15
            java.util.List r14 = com.anggrayudi.storage.file.DocumentFileUtils.search$default(r2, r3, r4, r5, r6, r7, r8, r9)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r15 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r0)
            r15.<init>(r0)
            java.util.Collection r15 = (java.util.Collection) r15
            java.util.Iterator r14 = r14.iterator()
        L_0x004b:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x0070
            java.lang.Object r0 = r14.next()
            androidx.documentfile.provider.DocumentFile r0 = (androidx.documentfile.provider.DocumentFile) r0
            com.anggrayudi.storage.media.MediaFile r1 = new com.anggrayudi.storage.media.MediaFile
            java.io.File r2 = new java.io.File
            android.net.Uri r0 = r0.getUri()
            java.lang.String r0 = r0.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r2.<init>(r0)
            r1.<init>((android.content.Context) r13, (java.io.File) r2)
            r15.add(r1)
            goto L_0x004b
        L_0x0070:
            java.util.List r15 = (java.util.List) r15
            java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r15)
            com.anggrayudi.storage.media.MediaFile r13 = (com.anggrayudi.storage.media.MediaFile) r13
            return r13
        L_0x0079:
            com.anggrayudi.storage.media.MediaStoreCompat r1 = INSTANCE
            com.anggrayudi.storage.media.MediaType r1 = r1.mediaTypeFromRelativePath(r0)
            r2 = 0
            if (r1 != 0) goto L_0x0083
            return r2
        L_0x0083:
            r3 = 1
            char[] r4 = new char[r3]
            r5 = 47
            r6 = 0
            r4[r6] = r5
            java.lang.String r14 = kotlin.text.StringsKt.trimEnd((java.lang.String) r14, (char[]) r4)
            java.lang.String r4 = "/"
            java.lang.String r14 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r4)
            r4 = 3
            java.lang.String[] r11 = new java.lang.String[r4]
            r11[r6] = r15
            r11[r3] = r14
            r14 = 2
            r11[r14] = r0
            android.content.ContentResolver r7 = r13.getContentResolver()
            android.net.Uri r8 = r1.getReadUri()
            if (r8 != 0) goto L_0x00aa
            return r2
        L_0x00aa:
            java.lang.String r14 = "_id"
            java.lang.String[] r9 = new java.lang.String[]{r14}
            r12 = 0
            java.lang.String r10 = "_display_name = ? AND relative_path IN(?, ?)"
            android.database.Cursor r14 = r7.query(r8, r9, r10, r11, r12)
            if (r14 != 0) goto L_0x00ba
            goto L_0x00c9
        L_0x00ba:
            java.io.Closeable r14 = (java.io.Closeable) r14
            r15 = r14
            android.database.Cursor r15 = (android.database.Cursor) r15     // Catch:{ all -> 0x00ca }
            com.anggrayudi.storage.media.MediaStoreCompat r0 = INSTANCE     // Catch:{ all -> 0x00ca }
            com.anggrayudi.storage.media.MediaFile r13 = r0.fromCursorToMediaFile(r13, r1, r15)     // Catch:{ all -> 0x00ca }
            kotlin.io.CloseableKt.closeFinally(r14, r2)
            r2 = r13
        L_0x00c9:
            return r2
        L_0x00ca:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r15 = move-exception
            kotlin.io.CloseableKt.closeFinally(r14, r13)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromRelativePath(android.content.Context, java.lang.String, java.lang.String):com.anggrayudi.storage.media.MediaFile");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0102, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0103, code lost:
        kotlin.io.CloseableKt.closeFinally(r14, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0106, code lost:
        throw r13;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.anggrayudi.storage.media.MediaFile> fromFileNameContains(android.content.Context r12, com.anggrayudi.storage.media.MediaType r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "mediaType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "containsName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x00b5
            java.util.List r0 = r13.getDirectories()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x002c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00ac
            java.lang.Object r3 = r0.next()
            java.io.File r3 = (java.io.File) r3
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r3)
            kotlin.text.Regex r9 = new kotlin.text.Regex
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "^.*"
            r3.append(r5)
            r3.append(r14)
            java.lang.String r5 = ".*$"
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r9.<init>((java.lang.String) r3)
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            java.lang.String r5 = r13.getMimeType()
            r7[r3] = r5
            java.lang.String r3 = "fromFile(directory)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            r5 = 1
            r6 = 0
            r8 = 0
            r10 = 10
            r11 = 0
            java.util.List r3 = com.anggrayudi.storage.file.DocumentFileUtils.search$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r2)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0081:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00a6
            java.lang.Object r5 = r3.next()
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            com.anggrayudi.storage.media.MediaFile r6 = new com.anggrayudi.storage.media.MediaFile
            java.io.File r7 = new java.io.File
            android.net.Uri r5 = r5.getUri()
            java.lang.String r5 = r5.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r7.<init>(r5)
            r6.<init>((android.content.Context) r12, (java.io.File) r7)
            r4.add(r6)
            goto L_0x0081
        L_0x00a6:
            java.util.List r4 = (java.util.List) r4
            r1.add(r4)
            goto L_0x002c
        L_0x00ac:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r12 = kotlin.collections.CollectionsKt.flatten(r1)
            return r12
        L_0x00b5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "_display_name LIKE '%"
            r0.append(r1)
            r0.append(r14)
            java.lang.String r14 = "%'"
            r0.append(r14)
            java.lang.String r4 = r0.toString()
            android.content.ContentResolver r1 = r12.getContentResolver()
            android.net.Uri r2 = r13.getReadUri()
            if (r2 != 0) goto L_0x00da
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            return r12
        L_0x00da:
            java.lang.String r14 = "_id"
            java.lang.String[] r3 = new java.lang.String[]{r14}
            r5 = 0
            r6 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6)
            r0 = 0
            if (r14 != 0) goto L_0x00ea
            goto L_0x00f9
        L_0x00ea:
            java.io.Closeable r14 = (java.io.Closeable) r14
            r1 = r14
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x0100 }
            com.anggrayudi.storage.media.MediaStoreCompat r2 = INSTANCE     // Catch:{ all -> 0x0100 }
            java.util.List r12 = r2.fromCursorToMediaFiles(r12, r13, r1)     // Catch:{ all -> 0x0100 }
            kotlin.io.CloseableKt.closeFinally(r14, r0)
            r0 = r12
        L_0x00f9:
            if (r0 != 0) goto L_0x00ff
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00ff:
            return r0
        L_0x0100:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x0102 }
        L_0x0102:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r14, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromFileNameContains(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d9, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
        kotlin.io.CloseableKt.closeFinally(r15, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dd, code lost:
        throw r14;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.anggrayudi.storage.media.MediaFile> fromMimeType(android.content.Context r13, com.anggrayudi.storage.media.MediaType r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "mediaType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "mimeType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 29
            if (r0 >= r3) goto L_0x0098
            java.util.List r14 = r14.getDirectories()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r3)
            r0.<init>(r4)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r14 = r14.iterator()
        L_0x002e:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = r14.next()
            java.io.File r4 = (java.io.File) r4
            androidx.documentfile.provider.DocumentFile r5 = androidx.documentfile.provider.DocumentFile.fromFile(r4)
            java.lang.String r4 = "fromFile(directory)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            r6 = 1
            com.anggrayudi.storage.file.DocumentFileType r7 = com.anggrayudi.storage.file.DocumentFileType.FILE
            java.lang.String[] r8 = new java.lang.String[r2]
            r8[r1] = r15
            r9 = 0
            r10 = 0
            r11 = 24
            r12 = 0
            java.util.List r4 = com.anggrayudi.storage.file.DocumentFileUtils.search$default(r5, r6, r7, r8, r9, r10, r11, r12)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r3)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x0064:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0089
            java.lang.Object r6 = r4.next()
            androidx.documentfile.provider.DocumentFile r6 = (androidx.documentfile.provider.DocumentFile) r6
            com.anggrayudi.storage.media.MediaFile r7 = new com.anggrayudi.storage.media.MediaFile
            java.io.File r8 = new java.io.File
            android.net.Uri r6 = r6.getUri()
            java.lang.String r6 = r6.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r8.<init>(r6)
            r7.<init>((android.content.Context) r13, (java.io.File) r8)
            r5.add(r7)
            goto L_0x0064
        L_0x0089:
            java.util.List r5 = (java.util.List) r5
            r0.add(r5)
            goto L_0x002e
        L_0x008f:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r13 = kotlin.collections.CollectionsKt.flatten(r0)
            return r13
        L_0x0098:
            android.content.ContentResolver r0 = r13.getContentResolver()
            android.net.Uri r3 = r14.getReadUri()
            if (r3 != 0) goto L_0x00a7
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
            return r13
        L_0x00a7:
            java.lang.String r4 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            java.lang.String[] r5 = new java.lang.String[r2]
            r5[r1] = r15
            r15 = 0
            java.lang.String r6 = "mime_type = ?"
            r1 = r3
            r2 = r4
            r3 = r6
            r4 = r5
            r5 = r15
            android.database.Cursor r15 = r0.query(r1, r2, r3, r4, r5)
            r0 = 0
            if (r15 != 0) goto L_0x00c1
            goto L_0x00d0
        L_0x00c1:
            java.io.Closeable r15 = (java.io.Closeable) r15
            r1 = r15
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch:{ all -> 0x00d7 }
            com.anggrayudi.storage.media.MediaStoreCompat r2 = INSTANCE     // Catch:{ all -> 0x00d7 }
            java.util.List r13 = r2.fromCursorToMediaFiles(r13, r14, r1)     // Catch:{ all -> 0x00d7 }
            kotlin.io.CloseableKt.closeFinally(r15, r0)
            r0 = r13
        L_0x00d0:
            if (r0 != 0) goto L_0x00d6
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00d6:
            return r0
        L_0x00d7:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00d9 }
        L_0x00d9:
            r14 = move-exception
            kotlin.io.CloseableKt.closeFinally(r15, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromMimeType(android.content.Context, com.anggrayudi.storage.media.MediaType, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ce, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
        throw r13;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.anggrayudi.storage.media.MediaFile> fromMediaType(android.content.Context r12, com.anggrayudi.storage.media.MediaType r13) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "mediaType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x0096
            java.util.List r0 = r13.getDirectories()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x008d
            java.lang.Object r3 = r0.next()
            java.io.File r3 = (java.io.File) r3
            androidx.documentfile.provider.DocumentFile r4 = androidx.documentfile.provider.DocumentFile.fromFile(r3)
            java.lang.String r3 = "fromFile(directory)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            r5 = 1
            r6 = 0
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            java.lang.String r8 = r13.getMimeType()
            r7[r3] = r8
            r8 = 0
            r9 = 0
            r10 = 26
            r11 = 0
            java.util.List r3 = com.anggrayudi.storage.file.DocumentFileUtils.search$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r2)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x0062:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0087
            java.lang.Object r5 = r3.next()
            androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
            com.anggrayudi.storage.media.MediaFile r6 = new com.anggrayudi.storage.media.MediaFile
            java.io.File r7 = new java.io.File
            android.net.Uri r5 = r5.getUri()
            java.lang.String r5 = r5.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r7.<init>(r5)
            r6.<init>((android.content.Context) r12, (java.io.File) r7)
            r4.add(r6)
            goto L_0x0062
        L_0x0087:
            java.util.List r4 = (java.util.List) r4
            r1.add(r4)
            goto L_0x0027
        L_0x008d:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r12 = kotlin.collections.CollectionsKt.flatten(r1)
            return r12
        L_0x0096:
            android.content.ContentResolver r0 = r12.getContentResolver()
            android.net.Uri r1 = r13.getReadUri()
            if (r1 != 0) goto L_0x00a5
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            return r12
        L_0x00a5:
            java.lang.String r2 = "_id"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)
            r1 = 0
            if (r0 != 0) goto L_0x00b6
            goto L_0x00c5
        L_0x00b6:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x00cc }
            com.anggrayudi.storage.media.MediaStoreCompat r3 = INSTANCE     // Catch:{ all -> 0x00cc }
            java.util.List r12 = r3.fromCursorToMediaFiles(r12, r13, r2)     // Catch:{ all -> 0x00cc }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            r1 = r12
        L_0x00c5:
            if (r1 != 0) goto L_0x00cb
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00cb:
            return r1
        L_0x00cc:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.media.MediaStoreCompat.fromMediaType(android.content.Context, com.anggrayudi.storage.media.MediaType):java.util.List");
    }

    private final List<MediaFile> fromCursorToMediaFiles(Context context, MediaType mediaType, Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return CollectionsKt.emptyList();
        }
        int columnIndex = cursor.getColumnIndex(APEZProvider.FILEID);
        ArrayList arrayList = new ArrayList(cursor.getCount());
        do {
            String string = cursor.getString(columnIndex);
            Intrinsics.checkNotNullExpressionValue(string, "mediaId");
            MediaFile fromMediaId = fromMediaId(context, mediaType, string);
            if (fromMediaId != null) {
                arrayList.add(fromMediaId);
            }
        } while (cursor.moveToNext());
        return arrayList;
    }

    private final MediaFile fromCursorToMediaFile(Context context, MediaType mediaType, Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndex(APEZProvider.FILEID));
        Intrinsics.checkNotNullExpressionValue(string, "mediaId");
        return fromMediaId(context, mediaType, string);
    }
}
