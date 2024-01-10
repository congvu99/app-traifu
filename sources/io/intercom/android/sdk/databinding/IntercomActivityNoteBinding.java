package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.views.ContentAwareScrollView;
import io.intercom.android.sdk.views.IntercomToolbar;

public final class IntercomActivityNoteBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final IntercomToolbar intercomToolbar;
    public final FrameLayout noteComposerContainer;
    public final LinearLayout noteLayout;
    public final View noteTouchTarget;
    public final ContentAwareScrollView noteView;
    public final ReactionInputView reactionInputView;
    private final FrameLayout rootView;

    private IntercomActivityNoteBinding(FrameLayout frameLayout, AppBarLayout appBarLayout2, IntercomToolbar intercomToolbar2, FrameLayout frameLayout2, LinearLayout linearLayout, View view, ContentAwareScrollView contentAwareScrollView, ReactionInputView reactionInputView2) {
        this.rootView = frameLayout;
        this.appBarLayout = appBarLayout2;
        this.intercomToolbar = intercomToolbar2;
        this.noteComposerContainer = frameLayout2;
        this.noteLayout = linearLayout;
        this.noteTouchTarget = view;
        this.noteView = contentAwareScrollView;
        this.reactionInputView = reactionInputView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityNoteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_note, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = io.intercom.android.sdk.R.id.note_touch_target;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomActivityNoteBinding bind(android.view.View r11) {
        /*
            int r0 = io.intercom.android.sdk.R.id.app_bar_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
            if (r4 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.intercom_toolbar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            io.intercom.android.sdk.views.IntercomToolbar r5 = (io.intercom.android.sdk.views.IntercomToolbar) r5
            if (r5 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.note_composer_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.note_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.note_touch_target
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r8 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.note_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            io.intercom.android.sdk.views.ContentAwareScrollView r9 = (io.intercom.android.sdk.views.ContentAwareScrollView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = io.intercom.android.sdk.R.id.reaction_input_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            io.intercom.android.sdk.conversation.ReactionInputView r10 = (io.intercom.android.sdk.conversation.ReactionInputView) r10
            if (r10 == 0) goto L_0x0054
            io.intercom.android.sdk.databinding.IntercomActivityNoteBinding r0 = new io.intercom.android.sdk.databinding.IntercomActivityNoteBinding
            r3 = r11
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomActivityNoteBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomActivityNoteBinding");
    }
}
