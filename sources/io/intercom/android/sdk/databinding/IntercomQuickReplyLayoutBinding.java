package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;
import io.intercom.android.sdk.R;

public final class IntercomQuickReplyLayoutBinding implements ViewBinding {
    public final FlexboxLayout quickReplyLayout;
    private final FlexboxLayout rootView;

    private IntercomQuickReplyLayoutBinding(FlexboxLayout flexboxLayout, FlexboxLayout flexboxLayout2) {
        this.rootView = flexboxLayout;
        this.quickReplyLayout = flexboxLayout2;
    }

    public FlexboxLayout getRoot() {
        return this.rootView;
    }

    public static IntercomQuickReplyLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomQuickReplyLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_quick_reply_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomQuickReplyLayoutBinding bind(View view) {
        if (view != null) {
            FlexboxLayout flexboxLayout = (FlexboxLayout) view;
            return new IntercomQuickReplyLayoutBinding(flexboxLayout, flexboxLayout);
        }
        throw new NullPointerException("rootView");
    }
}
