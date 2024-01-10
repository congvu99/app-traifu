package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.ContentAwareScrollView;

public final class IntercomFragmentCarouselScreenBinding implements ViewBinding {
    public final LinearLayout intercomCarouselActionLayout;
    public final FrameLayout intercomCarouselContentContainer;
    public final LinearLayout intercomCarouselFragmentRoot;
    public final View intercomCarouselGradient;
    public final ContentAwareScrollView intercomCarouselScrollView;
    private final LinearLayout rootView;

    private IntercomFragmentCarouselScreenBinding(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, LinearLayout linearLayout3, View view, ContentAwareScrollView contentAwareScrollView) {
        this.rootView = linearLayout;
        this.intercomCarouselActionLayout = linearLayout2;
        this.intercomCarouselContentContainer = frameLayout;
        this.intercomCarouselFragmentRoot = linearLayout3;
        this.intercomCarouselGradient = view;
        this.intercomCarouselScrollView = contentAwareScrollView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomFragmentCarouselScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomFragmentCarouselScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_fragment_carousel_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomFragmentCarouselScreenBinding bind(View view) {
        int i = R.id.intercom_carousel_action_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.intercom_carousel_content_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view;
                i = R.id.intercom_carousel_gradient;
                View findChildViewById = ViewBindings.findChildViewById(view, i);
                if (findChildViewById != null) {
                    i = R.id.intercom_carousel_scroll_view;
                    ContentAwareScrollView contentAwareScrollView = (ContentAwareScrollView) ViewBindings.findChildViewById(view, i);
                    if (contentAwareScrollView != null) {
                        return new IntercomFragmentCarouselScreenBinding(linearLayout2, linearLayout, frameLayout, linearLayout2, findChildViewById, contentAwareScrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
