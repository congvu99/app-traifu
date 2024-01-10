package io.intercom.android.sdk.conversation.composer.galleryinput;

import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryLightBoxFragment;

public class GifLightBoxFragment extends GalleryLightBoxFragment {
    /* access modifiers changed from: protected */
    public GalleryLightBoxFragment.Injector getInjector(GalleryLightBoxFragment galleryLightBoxFragment) {
        return new GalleryLightBoxFragment.Injector() {
            public ImageLoader getImageLoader(GalleryLightBoxFragment galleryLightBoxFragment) {
                return GalleryImageLoader.create();
            }
        };
    }
}
