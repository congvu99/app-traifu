package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.AttributeCollectorCardView;

public final class IntercomRowAttributeCollectorPartBinding implements ViewBinding {
    public final ImageView avatarView;
    public final AttributeCollectorCardView cellLayout;
    private final FrameLayout rootView;

    private IntercomRowAttributeCollectorPartBinding(FrameLayout frameLayout, ImageView imageView, AttributeCollectorCardView attributeCollectorCardView) {
        this.rootView = frameLayout;
        this.avatarView = imageView;
        this.cellLayout = attributeCollectorCardView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowAttributeCollectorPartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowAttributeCollectorPartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_attribute_collector_part, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowAttributeCollectorPartBinding bind(View view) {
        int i = R.id.avatarView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.cellLayout;
            AttributeCollectorCardView attributeCollectorCardView = (AttributeCollectorCardView) ViewBindings.findChildViewById(view, i);
            if (attributeCollectorCardView != null) {
                return new IntercomRowAttributeCollectorPartBinding((FrameLayout) view, imageView, attributeCollectorCardView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
