package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import io.intercom.android.sdk.R;

public final class IntercomActivityCarouselBinding implements ViewBinding {
    public final ConstraintLayout intercomCarouselCloseContainer;
    public final ConstraintLayout intercomCarouselRoot;
    public final ImageButton intercomClose;
    public final View intercomCloseBackground;
    public final LinearLayout intercomPageNavigationLayout;
    public final FrameLayout intercomStateContainer;
    public final ViewPager intercomViewPager;
    private final ConstraintLayout rootView;

    private IntercomActivityCarouselBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageButton imageButton, View view, LinearLayout linearLayout, FrameLayout frameLayout, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.intercomCarouselCloseContainer = constraintLayout2;
        this.intercomCarouselRoot = constraintLayout3;
        this.intercomClose = imageButton;
        this.intercomCloseBackground = view;
        this.intercomPageNavigationLayout = linearLayout;
        this.intercomStateContainer = frameLayout;
        this.intercomViewPager = viewPager;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityCarouselBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityCarouselBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_carousel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = io.intercom.android.sdk.R.id.intercom_close_background;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomActivityCarouselBinding bind(android.view.View r11) {
        /*
            int r0 = io.intercom.android.sdk.R.id.intercom_carousel_close_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x004a
            r5 = r11
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r0 = io.intercom.android.sdk.R.id.intercom_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.ImageButton r6 = (android.widget.ImageButton) r6
            if (r6 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.intercom_close_background
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r7 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.intercom_page_navigation_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.intercom_state_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            if (r9 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.intercom_view_pager
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            androidx.viewpager.widget.ViewPager r10 = (androidx.viewpager.widget.ViewPager) r10
            if (r10 == 0) goto L_0x004a
            io.intercom.android.sdk.databinding.IntercomActivityCarouselBinding r11 = new io.intercom.android.sdk.databinding.IntercomActivityCarouselBinding
            r2 = r11
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x004a:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomActivityCarouselBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomActivityCarouselBinding");
    }
}
