package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.IntercomToolbar;

public final class IntercomFragmentInboxBinding implements ViewBinding {
    public final FrameLayout conversationsListRoot;
    public final RecyclerView inboxRecyclerView;
    public final FrameLayout intercomInboxContent;
    public final IntercomToolbar intercomToolbar;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;

    private IntercomFragmentInboxBinding(FrameLayout frameLayout, FrameLayout frameLayout2, RecyclerView recyclerView, FrameLayout frameLayout3, IntercomToolbar intercomToolbar2, ProgressBar progressBar2) {
        this.rootView = frameLayout;
        this.conversationsListRoot = frameLayout2;
        this.inboxRecyclerView = recyclerView;
        this.intercomInboxContent = frameLayout3;
        this.intercomToolbar = intercomToolbar2;
        this.progressBar = progressBar2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomFragmentInboxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomFragmentInboxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_fragment_inbox, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomFragmentInboxBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.inbox_recycler_view;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.intercom_inbox_content;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = R.id.intercom_toolbar;
                IntercomToolbar intercomToolbar2 = (IntercomToolbar) ViewBindings.findChildViewById(view, i);
                if (intercomToolbar2 != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar2 != null) {
                        return new IntercomFragmentInboxBinding(frameLayout, frameLayout, recyclerView, frameLayout2, intercomToolbar2, progressBar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
