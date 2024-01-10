package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomNewConversationCardBinding implements ViewBinding {
    public final TextView botExpectationTitle;
    public final LinearLayout expectationLayout;
    public final TextView newConversationButton;
    public final IntercomNewConversationCardAvatarsBinding newConversationCardAvatars;
    public final Barrier newConversationCardBottomBarrier;
    public final TextView newConversationCardExpectationHours;
    public final TextView newConversationCardExpectationTitle;
    public final ConstraintLayout newConversationCardLayout;
    public final TextView newConversationCardTitle;
    public final View newConversationDivider;
    public final TextView newConversationSeePrevious;
    public final Group newConversationTeammateElements;
    private final ConstraintLayout rootView;
    public final Group seeAllLayout;

    private IntercomNewConversationCardBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, TextView textView2, IntercomNewConversationCardAvatarsBinding intercomNewConversationCardAvatarsBinding, Barrier barrier, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, TextView textView5, View view, TextView textView6, Group group, Group group2) {
        this.rootView = constraintLayout;
        this.botExpectationTitle = textView;
        this.expectationLayout = linearLayout;
        this.newConversationButton = textView2;
        this.newConversationCardAvatars = intercomNewConversationCardAvatarsBinding;
        this.newConversationCardBottomBarrier = barrier;
        this.newConversationCardExpectationHours = textView3;
        this.newConversationCardExpectationTitle = textView4;
        this.newConversationCardLayout = constraintLayout2;
        this.newConversationCardTitle = textView5;
        this.newConversationDivider = view;
        this.newConversationSeePrevious = textView6;
        this.newConversationTeammateElements = group;
        this.seeAllLayout = group2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomNewConversationCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomNewConversationCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_new_conversation_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        r1 = io.intercom.android.sdk.R.id.new_conversation_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = io.intercom.android.sdk.R.id.new_conversation_card_avatars;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomNewConversationCardBinding bind(android.view.View r18) {
        /*
            r0 = r18
            int r1 = io.intercom.android.sdk.R.id.bot_expectation_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.expectation_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_card_avatars
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x0091
            io.intercom.android.sdk.databinding.IntercomNewConversationCardAvatarsBinding r8 = io.intercom.android.sdk.databinding.IntercomNewConversationCardAvatarsBinding.bind(r2)
            int r1 = io.intercom.android.sdk.R.id.new_conversation_card_bottom_barrier
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.Barrier r9 = (androidx.constraintlayout.widget.Barrier) r9
            if (r9 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_card_expectation_hours
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_card_expectation_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0091
            r12 = r0
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            int r1 = io.intercom.android.sdk.R.id.new_conversation_card_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_divider
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_see_previous
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.new_conversation_teammate_elements
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Group r16 = (androidx.constraintlayout.widget.Group) r16
            if (r16 == 0) goto L_0x0091
            int r1 = io.intercom.android.sdk.R.id.see_all_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.Group r17 = (androidx.constraintlayout.widget.Group) r17
            if (r17 == 0) goto L_0x0091
            io.intercom.android.sdk.databinding.IntercomNewConversationCardBinding r0 = new io.intercom.android.sdk.databinding.IntercomNewConversationCardBinding
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        L_0x0091:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomNewConversationCardBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomNewConversationCardBinding");
    }
}
