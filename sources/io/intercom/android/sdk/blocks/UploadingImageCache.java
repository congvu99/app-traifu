package io.intercom.android.sdk.blocks;

import android.net.Uri;
import com.intercom.input.gallery.GalleryImage;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class UploadingImageCache {
    private final Map<String, Uri> localImageUris;

    public UploadingImageCache() {
        this(new HashMap());
    }

    UploadingImageCache(Map<String, Uri> map) {
        this.localImageUris = map;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Uri getLocalImageUriForRemoteUrl(String str) {
        return this.localImageUris.get(str);
    }

    public void put(String str, GalleryImage galleryImage) {
        this.localImageUris.put(str, galleryImage.getUri());
    }
}
