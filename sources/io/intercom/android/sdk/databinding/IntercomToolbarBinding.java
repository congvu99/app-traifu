package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomToolbarBinding implements ViewBinding {
    public final FrameLayout intercomLeftItemLayout;
    public final ImageView intercomToolbarAvatar;
    public final View intercomToolbarAvatarActiveState;
    public final ImageButton intercomToolbarClose;
    public final View intercomToolbarDivider;
    public final ImageButton intercomToolbarInbox;
    public final TextView intercomToolbarSubtitle;
    public final TextView intercomToolbarTitle;
    public final LinearLayout intercomToolbarTitleContainer;
    private final FrameLayout rootView;
    public final RelativeLayout toolbarContentContainer;
    public final ProgressBar toolbarProgressBar;
    public final ImageView wallpaperImage;

    private IntercomToolbarBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, View view, ImageButton imageButton, View view2, ImageButton imageButton2, TextView textView, TextView textView2, LinearLayout linearLayout, RelativeLayout relativeLayout, ProgressBar progressBar, ImageView imageView2) {
        this.rootView = frameLayout;
        this.intercomLeftItemLayout = frameLayout2;
        this.intercomToolbarAvatar = imageView;
        this.intercomToolbarAvatarActiveState = view;
        this.intercomToolbarClose = imageButton;
        this.intercomToolbarDivider = view2;
        this.intercomToolbarInbox = imageButton2;
        this.intercomToolbarSubtitle = textView;
        this.intercomToolbarTitle = textView2;
        this.intercomToolbarTitleContainer = linearLayout;
        this.toolbarContentContainer = relativeLayout;
        this.toolbarProgressBar = progressBar;
        this.wallpaperImage = imageView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = io.intercom.android.sdk.R.id.intercom_toolbar_avatar_active_state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        r1 = io.intercom.android.sdk.R.id.intercom_toolbar_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomToolbarBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = io.intercom.android.sdk.R.id.intercom_left_item_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_avatar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_avatar_active_state
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageButton r8 = (android.widget.ImageButton) r8
            if (r8 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_divider
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_inbox
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            if (r10 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.intercom_toolbar_title_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.toolbar_content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.toolbar_progress_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ProgressBar r15 = (android.widget.ProgressBar) r15
            if (r15 == 0) goto L_0x008b
            int r1 = io.intercom.android.sdk.R.id.wallpaper_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x008b
            io.intercom.android.sdk.databinding.IntercomToolbarBinding r1 = new io.intercom.android.sdk.databinding.IntercomToolbarBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x008b:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomToolbarBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomToolbarBinding");
    }
}
