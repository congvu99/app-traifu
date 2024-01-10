package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.LockableScrollView;

public final class IntercomRowNoteBinding implements ViewBinding {
    public final ImageView avatarView;
    public final LockableScrollView cellContent;
    public final LinearLayout cellLayout;
    public final ImageView expandArrow;
    public final TextView intercomContainerCardTitle;
    public final View intercomContainerFadeView;
    private final RelativeLayout rootView;

    private IntercomRowNoteBinding(RelativeLayout relativeLayout, ImageView imageView, LockableScrollView lockableScrollView, LinearLayout linearLayout, ImageView imageView2, TextView textView, View view) {
        this.rootView = relativeLayout;
        this.avatarView = imageView;
        this.cellContent = lockableScrollView;
        this.cellLayout = linearLayout;
        this.expandArrow = imageView2;
        this.intercomContainerCardTitle = textView;
        this.intercomContainerFadeView = view;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowNoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_note, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = io.intercom.android.sdk.R.id.intercom_container_fade_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomRowNoteBinding bind(android.view.View r10) {
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
            int r0 = io.intercom.android.sdk.R.id.expand_arrow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.intercom_container_card_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0049
            int r0 = io.intercom.android.sdk.R.id.intercom_container_fade_view
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r9 == 0) goto L_0x0049
            io.intercom.android.sdk.databinding.IntercomRowNoteBinding r0 = new io.intercom.android.sdk.databinding.IntercomRowNoteBinding
            r3 = r10
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomRowNoteBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomRowNoteBinding");
    }
}
