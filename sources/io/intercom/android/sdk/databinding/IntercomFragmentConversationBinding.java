package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomFragmentConversationBinding implements ViewBinding {
    public final IntercomComposerHolderBinding composerHolder;
    public final RelativeLayout conversationFragmentRoot;
    private final RelativeLayout rootView;

    private IntercomFragmentConversationBinding(RelativeLayout relativeLayout, IntercomComposerHolderBinding intercomComposerHolderBinding, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.composerHolder = intercomComposerHolderBinding;
        this.conversationFragmentRoot = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IntercomFragmentConversationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomFragmentConversationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_fragment_conversation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomFragmentConversationBinding bind(View view) {
        int i = R.id.composer_holder;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new IntercomFragmentConversationBinding(relativeLayout, IntercomComposerHolderBinding.bind(findChildViewById), relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
