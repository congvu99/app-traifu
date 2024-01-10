package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.lightbox.LightBoxImageView;

public final class IntercomActivityLightboxBinding implements ViewBinding {
    public final LightBoxImageView fullImage;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;

    private IntercomActivityLightboxBinding(RelativeLayout relativeLayout, LightBoxImageView lightBoxImageView, RelativeLayout relativeLayout2) {
        this.rootView_ = relativeLayout;
        this.fullImage = lightBoxImageView;
        this.rootView = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static IntercomActivityLightboxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityLightboxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_lightbox, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomActivityLightboxBinding bind(View view) {
        int i = R.id.full_image;
        LightBoxImageView lightBoxImageView = (LightBoxImageView) ViewBindings.findChildViewById(view, i);
        if (lightBoxImageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new IntercomActivityLightboxBinding(relativeLayout, lightBoxImageView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
