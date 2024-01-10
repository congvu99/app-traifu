package com.intercom.input.gallery;

import com.intercom.composer.Creator;
import com.intercom.composer.input.IconProvider;
import com.intercom.composer.input.Input;

public class GalleryInput extends Input<GalleryInputFragment> {
    private final Creator<GalleryInputFragment> fragmentCreator;
    private final GalleryInputExpandedListener galleryInputExpandedListener;
    private final GalleryOutputListener galleryOutputListener;

    public GalleryInput(String str, IconProvider iconProvider, GalleryOutputListener galleryOutputListener2, GalleryInputExpandedListener galleryInputExpandedListener2, Creator<GalleryInputFragment> creator) {
        super(str, iconProvider);
        this.galleryOutputListener = galleryOutputListener2;
        this.galleryInputExpandedListener = galleryInputExpandedListener2;
        this.fragmentCreator = creator;
    }

    public GalleryInputFragment createFragment() {
        GalleryInputFragment create = this.fragmentCreator.create();
        create.setArguments(GalleryInputFragment.createArguments(false));
        create.setGalleryListener(this.galleryOutputListener);
        create.setGalleryExpandedListener(this.galleryInputExpandedListener);
        return create;
    }
}
