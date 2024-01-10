package io.intercom.android.sdk.conversation.composer.galleryinput;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import com.intercom.composer.ImageLoader;
import com.intercom.input.gallery.GalleryInputDataSource;
import com.intercom.input.gallery.GalleryInputFragment;
import com.intercom.input.gallery.GalleryLightBoxFragment;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.ColorUtils;

class GifInputInjector implements GalleryInputFragment.Injector {
    /* access modifiers changed from: private */
    public final GifInputDataSource dataSource = new GifInputDataSource(Injector.get().getApi(), Injector.get().getMetricTracker());

    public View getExpanderButton(ViewGroup viewGroup) {
        return null;
    }

    public View getSearchView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_gif_input_search, viewGroup, false);
    }

    public Toolbar getToolbar(ViewGroup viewGroup) {
        Toolbar toolbar = (Toolbar) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.intercom_gif_input_toolbar, viewGroup, false);
        final ImageButton imageButton = (ImageButton) toolbar.findViewById(R.id.clear_search);
        final EditText editText = (EditText) toolbar.findViewById(R.id.search_bar);
        editText.requestFocus();
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                imageButton.setVisibility(TextUtils.isEmpty(editable) ? 8 : 0);
                GifInputInjector.this.dataSource.getImages(0, editable.toString());
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                editText.setText((CharSequence) null);
            }
        });
        return toolbar;
    }

    public int getThemeColor(Context context) {
        return ColorUtils.primaryOrDarkColor(context, Injector.get().getAppConfigProvider().get());
    }

    public GalleryInputDataSource getDataSource(GalleryInputFragment galleryInputFragment) {
        return this.dataSource;
    }

    public ImageLoader getImageLoader(GalleryInputFragment galleryInputFragment) {
        return GalleryImageLoader.create();
    }

    public Class<? extends GalleryLightBoxFragment> getLightBoxFragmentClass(GalleryInputFragment galleryInputFragment) {
        return GifLightBoxFragment.class;
    }

    public String getEmptyViewTitle(Resources resources) {
        return resources.getString(R.string.intercom_no_gifs_found);
    }

    public String getEmptyViewSubtitle(Resources resources) {
        return resources.getString(R.string.intercom_no_gifs_matching_query);
    }

    public String getErrorViewTitle(Resources resources) {
        return resources.getString(R.string.intercom_gifs_load_error);
    }

    public String getErrorViewSubtitle(Resources resources) {
        return resources.getString(R.string.intercom_try_again_minute);
    }
}
