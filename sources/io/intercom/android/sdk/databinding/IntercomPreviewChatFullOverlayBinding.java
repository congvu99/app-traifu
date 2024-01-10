package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomPreviewChatFullOverlayBinding implements ViewBinding {
    public final FrameLayout chatAvatarContainer;
    public final FrameLayout chatFullBody;
    public final View chatOverlayOverflowFade;
    public final ImageView chatheadAvatar;
    public final FrameLayout chatheadRoot;
    public final LinearLayout chatheadTextContainer;
    public final TextView chatheadTextHeader;
    private final FrameLayout rootView;

    private IntercomPreviewChatFullOverlayBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, View view, ImageView imageView, FrameLayout frameLayout4, LinearLayout linearLayout, TextView textView) {
        this.rootView = frameLayout;
        this.chatAvatarContainer = frameLayout2;
        this.chatFullBody = frameLayout3;
        this.chatOverlayOverflowFade = view;
        this.chatheadAvatar = imageView;
        this.chatheadRoot = frameLayout4;
        this.chatheadTextContainer = linearLayout;
        this.chatheadTextHeader = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomPreviewChatFullOverlayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomPreviewChatFullOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_preview_chat_full_overlay, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = io.intercom.android.sdk.R.id.chat_overlay_overflow_fade;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomPreviewChatFullOverlayBinding bind(android.view.View r11) {
        /*
            int r0 = io.intercom.android.sdk.R.id.chat_avatar_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.chat_full_body
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.chat_overlay_overflow_fade
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r6 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.chathead_avatar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x004a
            r8 = r11
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            int r0 = io.intercom.android.sdk.R.id.chathead_text_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x004a
            int r0 = io.intercom.android.sdk.R.id.chathead_text_header
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x004a
            io.intercom.android.sdk.databinding.IntercomPreviewChatFullOverlayBinding r11 = new io.intercom.android.sdk.databinding.IntercomPreviewChatFullOverlayBinding
            r2 = r11
            r3 = r8
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
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomPreviewChatFullOverlayBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomPreviewChatFullOverlayBinding");
    }
}
