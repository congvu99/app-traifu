package com.anggrayudi.storage.media;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/anggrayudi/storage/media/MediaType;", "", "readUri", "Landroid/net/Uri;", "writeUri", "(Ljava/lang/String;ILandroid/net/Uri;Landroid/net/Uri;)V", "directories", "", "Ljava/io/File;", "getDirectories$annotations", "()V", "getDirectories", "()Ljava/util/List;", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "getReadUri", "()Landroid/net/Uri;", "getWriteUri", "IMAGE", "AUDIO", "VIDEO", "DOWNLOADS", "storage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaType.kt */
public enum MediaType {
    IMAGE(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.getContentUri(MediaStoreCompat.getVolumeName())),
    AUDIO(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MediaStore.Audio.Media.getContentUri(MediaStoreCompat.getVolumeName())),
    VIDEO(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.getContentUri(MediaStoreCompat.getVolumeName()));
    
    private final Uri readUri;
    private final Uri writeUri;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MediaType.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[MediaType.values().length];
            iArr[MediaType.IMAGE.ordinal()] = 1;
            iArr[MediaType.AUDIO.ordinal()] = 2;
            iArr[MediaType.VIDEO.ordinal()] = 3;
            iArr[MediaType.DOWNLOADS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MediaType(Uri uri, Uri uri2) {
        this.readUri = uri;
        this.writeUri = uri2;
    }

    public final Uri getReadUri() {
        return this.readUri;
    }

    public final Uri getWriteUri() {
        return this.writeUri;
    }

    static {
        IMAGE = new MediaType(ShareConstants.IMAGE_URL, 0, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.getContentUri(MediaStoreCompat.getVolumeName()));
        AUDIO = new MediaType("AUDIO", 1, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MediaStore.Audio.Media.getContentUri(MediaStoreCompat.getVolumeName()));
        VIDEO = new MediaType(ShareConstants.VIDEO_URL, 2, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.getContentUri(MediaStoreCompat.getVolumeName()));
        Uri uri = null;
        Uri uri2 = Build.VERSION.SDK_INT < 29 ? null : MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        if (Build.VERSION.SDK_INT >= 29) {
            uri = MediaStore.Downloads.getContentUri(MediaStoreCompat.getVolumeName());
        }
        DOWNLOADS = new MediaType("DOWNLOADS", 3, uri2, uri);
        $VALUES = $values();
    }

    public final List<File> getDirectories() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 0;
        if (i == 1) {
            ImageMediaDirectory[] values = ImageMediaDirectory.values();
            Collection arrayList = new ArrayList(values.length);
            int length = values.length;
            while (i2 < length) {
                ImageMediaDirectory imageMediaDirectory = values[i2];
                i2++;
                arrayList.add(Environment.getExternalStoragePublicDirectory(imageMediaDirectory.getFolderName()));
            }
            return (List) arrayList;
        } else if (i == 2) {
            AudioMediaDirectory[] values2 = AudioMediaDirectory.values();
            Collection arrayList2 = new ArrayList(values2.length);
            int length2 = values2.length;
            while (i2 < length2) {
                AudioMediaDirectory audioMediaDirectory = values2[i2];
                i2++;
                arrayList2.add(Environment.getExternalStoragePublicDirectory(audioMediaDirectory.getFolderName()));
            }
            return (List) arrayList2;
        } else if (i == 3) {
            VideoMediaDirectory[] values3 = VideoMediaDirectory.values();
            Collection arrayList3 = new ArrayList(values3.length);
            int length3 = values3.length;
            while (i2 < length3) {
                VideoMediaDirectory videoMediaDirectory = values3[i2];
                i2++;
                arrayList3.add(Environment.getExternalStoragePublicDirectory(videoMediaDirectory.getFolderName()));
            }
            return (List) arrayList3;
        } else if (i == 4) {
            return CollectionsKt.listOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String getMimeType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return MimeType.IMAGE;
        }
        if (i != 2) {
            return i != 3 ? MimeType.UNKNOWN : MimeType.VIDEO;
        }
        return MimeType.AUDIO;
    }
}
