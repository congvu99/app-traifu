package io.intercom.android.sdk.conversation.composer.galleryinput;

import com.intercom.input.gallery.GalleryInputFragment;

public class LocalGalleryInputFragment extends GalleryInputFragment {
    /* access modifiers changed from: protected */
    public GalleryInputFragment.Injector getInjector(GalleryInputFragment galleryInputFragment) {
        return new LocalGalleryInputInjector();
    }
}
