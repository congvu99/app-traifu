package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.LockableScrollView;

public final class IntercomRowPostBinding implements ViewBinding {
    public final ImageView avatarView;
    public final LockableScrollView cellContent;
    public final LinearLayout cellLayout;
    public final TextView intercomContainerCardTitle;
    public final View intercomContainerFadeView;
    public final ComposeView intercomContainerFooter;
    private final LinearLayout rootView;

    private IntercomRowPostBinding(LinearLayout linearLayout, ImageView imageView, LockableScrollView lockableScrollView, LinearLayout linearLayout2, TextView textView, View view, ComposeView composeView) {
        this.rootView = linearLayout;
        this.avatarView = imageView;
        this.cellContent = lockableScrollView;
        this.cellLayout = linearLayout2;
        this.intercomContainerCardTitle = textView;
        this.intercomContainerFadeView = view;
        this.intercomContainerFooter = composeView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowPostBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowPostBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_post, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = io.intercom.android.sdk.R.id.intercom_container_fade_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomRowPostBinding bind(android.view.View r10) {
        /*
            int r0 = io.intercom.android.sdk.R.id.avatarView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.cell_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            io.intercom.android.sdk.views.LockableScrollView r5 = (io.intercom.android.sdk.views.LockableScrollView) r5
            if (r5 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.cellLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.intercom_container_card_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.intercom_container_fade_view
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r8 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.intercom_container_footer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            androidx.compose.ui.platform.ComposeView r9 = (androidx.compose.ui.platform.ComposeView) r9
            if (r9 == 0) goto L_0x0049
            io.intercom.android.sdk.databinding.IntercomRowPostBinding r0 = new io.intercom.android.sdk.databinding.IntercomRowPostBinding
            r3 = r10
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0049:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomRowPostBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomRowPostBinding");
    }
}
