package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.conversation.ReactionInputView;
import io.intercom.android.sdk.m5.components.NewConversationCard;

public final class IntercomComposerHolderBinding implements ViewBinding {
    public final FrameLayout composerContainer;
    public final View composerHolderDivider;
    public final View disabledView;
    public final NewConversationCard newConversationCard;
    public final ReactionInputView reactionInputView;
    private final RelativeLayout rootView;

    private IntercomComposerHolderBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, View view, View view2, NewConversationCard newConversationCard2, ReactionInputView reactionInputView2) {
        this.rootView = relativeLayout;
        this.composerContainer = frameLayout;
        this.composerHolderDivider = view;
        this.disabledView = view2;
        this.newConversationCard = newConversationCard2;
        this.reactionInputView = reactionInputView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IntercomComposerHolderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomComposerHolderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_composer_holder, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = io.intercom.android.sdk.R.id.composer_holder_divider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = io.intercom.android.sdk.R.id.disabled_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.intercom.android.sdk.databinding.IntercomComposerHolderBinding bind(android.view.View r9) {
        /*
            int r0 = io.intercom.android.sdk.R.id.composer_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x003b
            int r0 = io.intercom.android.sdk.R.id.composer_holder_divider
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x003b
            int r0 = io.intercom.android.sdk.R.id.disabled_view
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003b
            int r0 = io.intercom.android.sdk.R.id.new_conversation_card
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            io.intercom.android.sdk.m5.components.NewConversationCard r7 = (io.intercom.android.sdk.m5.components.NewConversationCard) r7
            if (r7 == 0) goto L_0x003b
            int r0 = io.intercom.android.sdk.R.id.reaction_input_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            io.intercom.android.sdk.conversation.ReactionInputView r8 = (io.intercom.android.sdk.conversation.ReactionInputView) r8
            if (r8 == 0) goto L_0x003b
            io.intercom.android.sdk.databinding.IntercomComposerHolderBinding r0 = new io.intercom.android.sdk.databinding.IntercomComposerHolderBinding
            r3 = r9
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003b:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.databinding.IntercomComposerHolderBinding.bind(android.view.View):io.intercom.android.sdk.databinding.IntercomComposerHolderBinding");
    }
}
