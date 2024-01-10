package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomHomeToolbarBinding implements ViewBinding {
    public final Space bottomPadding;
    public final AppCompatTextView intercomToolbarGreeting;
    public final AppCompatTextView intercomToolbarIntro;
    public final ImageView intercomToolbarLogo;
    private final FrameLayout rootView;
    public final RelativeLayout toolbarContentContainer;
    public final Space topPadding;
    public final ImageView wallpaperImage;

    private IntercomHomeToolbarBinding(FrameLayout frameLayout, Space space, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ImageView imageView, RelativeLayout relativeLayout, Space space2, ImageView imageView2) {
        this.rootView = frameLayout;
        this.bottomPadding = space;
        this.intercomToolbarGreeting = appCompatTextView;
        this.intercomToolbarIntro = appCompatTextView2;
        this.intercomToolbarLogo = imageView;
        this.toolbarContentContainer = relativeLayout;
        this.topPadding = space2;
        this.wallpaperImage = imageView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomHomeToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomHomeToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_home_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomHomeToolbarBinding bind(View view) {
        int i = R.id.bottom_padding;
        Space space = (Space) ViewBindings.findChildViewById(view, i);
        if (space != null) {
            i = R.id.intercom_toolbar_greeting;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatTextView != null) {
                i = R.id.intercom_toolbar_intro;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatTextView2 != null) {
                    i = R.id.intercom_toolbar_logo;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.toolbar_content_container;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = R.id.top_padding;
                            Space space2 = (Space) ViewBindings.findChildViewById(view, i);
                            if (space2 != null) {
                                i = R.id.wallpaper_image;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    return new IntercomHomeToolbarBinding((FrameLayout) view, space, appCompatTextView, appCompatTextView2, imageView, relativeLayout, space2, imageView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
