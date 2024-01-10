package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomActivityHelpCenterArticleBinding implements ViewBinding {
    public final ConstraintLayout articleContainer;
    private final ConstraintLayout rootView;

    private IntercomActivityHelpCenterArticleBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.articleContainer = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomActivityHelpCenterArticleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomActivityHelpCenterArticleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_activity_help_center_article, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomActivityHelpCenterArticleBinding bind(View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new IntercomActivityHelpCenterArticleBinding(constraintLayout, constraintLayout);
        }
        throw new NullPointerException("rootView");
    }
}
