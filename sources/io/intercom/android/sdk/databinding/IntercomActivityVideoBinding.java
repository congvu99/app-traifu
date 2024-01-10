package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.IntercomToolbar;

public final class IntercomActivityVideoBinding implements ViewBinding {
    public final FrameLayout fullscreenVideoLayout;
    public final IntercomToolbar intercomToolbar;
    public final ProgressBar loadingView;
    private final FrameLayout rootView;
    public final VideoView videoView;
    public final FrameLayout videoViewOverlay;

    private IntercomActivityVideoBinding(FrameLayout frameLayout, FrameLayout frameLayout2, IntercomToolbar intercomToolbar2, ProgressBar progressBar, VideoView videoView2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.fullscreenVideoLayout = frameLayout2;
        this.intercomToolbar = intercomToolbar2;
        this.loadingView = progressBar;
        this.videoView = videoView2;
        this.videoViewOverlay = frameLayout3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_video, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomActivityVideoBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.intercom_toolbar;
        IntercomToolbar intercomToolbar2 = (IntercomToolbar) ViewBindings.findChildViewById(view, i);
        if (intercomToolbar2 != null) {
            i = R.id.loading_view;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.video_view;
                VideoView videoView2 = (VideoView) ViewBindings.findChildViewById(view, i);
                if (videoView2 != null) {
                    i = R.id.video_view_overlay;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        return new IntercomActivityVideoBinding(frameLayout, frameLayout, intercomToolbar2, progressBar, videoView2, frameLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
