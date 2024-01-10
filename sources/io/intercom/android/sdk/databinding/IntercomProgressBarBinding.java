package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomProgressBarBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final ProgressBar rootView;

    private IntercomProgressBarBinding(ProgressBar progressBar2, ProgressBar progressBar3) {
        this.rootView = progressBar2;
        this.progressBar = progressBar3;
    }

    public ProgressBar getRoot() {
        return this.rootView;
    }

    public static IntercomProgressBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomProgressBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_progress_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomProgressBarBinding bind(View view) {
        if (view != null) {
            ProgressBar progressBar2 = (ProgressBar) view;
            return new IntercomProgressBarBinding(progressBar2, progressBar2);
        }
        throw new NullPointerException("rootView");
    }
}
