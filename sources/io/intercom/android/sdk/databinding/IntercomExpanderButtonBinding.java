package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomExpanderButtonBinding implements ViewBinding {
    public final ImageButton galleryExpandButton;
    private final ImageButton rootView;

    private IntercomExpanderButtonBinding(ImageButton imageButton, ImageButton imageButton2) {
        this.rootView = imageButton;
        this.galleryExpandButton = imageButton2;
    }

    public ImageButton getRoot() {
        return this.rootView;
    }

    public static IntercomExpanderButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomExpanderButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_expander_button, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomExpanderButtonBinding bind(View view) {
        if (view != null) {
            ImageButton imageButton = (ImageButton) view;
            return new IntercomExpanderButtonBinding(imageButton, imageButton);
        }
        throw new NullPointerException("rootView");
    }
}
