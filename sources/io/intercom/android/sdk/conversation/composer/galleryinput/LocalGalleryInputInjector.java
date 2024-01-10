package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryInputDataSource;
import com.intercom.input.gallery.GalleryInputFragment;
import com.intercom.input.gallery.GalleryLightBoxFragment;
import com.intercom.input.gallery.LocalImagesDataSource;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.ColorUtils;

class LocalGalleryInputInjector implements GalleryInputFragment.Injector {
    public String getErrorViewSubtitle(Resources resources) {
        return null;
    }

    public String getErrorViewTitle(Resources resources) {
        return null;
    }

    public View getSearchView(ViewGroup viewGroup) {
        return null;
    }

    public View getExpanderButton(ViewGroup viewGroup) {
        ImageButton imageButton = (ImageButton) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_expander_button, viewGroup, false);
        imageButton.setColorFilter(getThemeColor(imageButton.getContext()));
        return imageButton;
    }

    public Toolbar getToolbar(ViewGroup viewGroup) {
        return (Toolbar) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_gallery_input_toolbar, viewGroup, false);
    }

    public int getThemeColor(Context context) {
        return ColorUtils.primaryOrDarkColor(context, Injector.get().getAppConfigProvider().get());
    }

    public GalleryInputDataSource getDataSource(GalleryInputFragment galleryInputFragment) {
        return LocalImagesDataSource.create(galleryInputFragment, true);
    }

    public ImageLoader getImageLoader(GalleryInputFragment galleryInputFragment) {
        return GalleryImageLoader.create();
    }

    public Class<? extends GalleryLightBoxFragment> getLightBoxFragmentClass(GalleryInputFragment galleryInputFragment) {
        return LocalGalleryLightBoxFragment.class;
    }

    public String getEmptyViewTitle(Resources resources) {
        return resources.getString(R.string.intercom_no_photos);
    }

    public String getEmptyViewSubtitle(Resources resources) {
        return resources.getString(R.string.intercom_no_photos_on_device);
    }
}
