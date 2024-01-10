package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomGalleryInputToolbarBinding implements ViewBinding {
    private final Toolbar rootView;
    public final Toolbar toolbar;
    public final TextView toolbarTitle;

    private IntercomGalleryInputToolbarBinding(Toolbar toolbar2, Toolbar toolbar3, TextView textView) {
        this.rootView = toolbar2;
        this.toolbar = toolbar3;
        this.toolbarTitle = textView;
    }

    public Toolbar getRoot() {
        return this.rootView;
    }

    public static IntercomGalleryInputToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomGalleryInputToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_gallery_input_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomGalleryInputToolbarBinding bind(View view) {
        Toolbar toolbar2 = (Toolbar) view;
        int i = R.id.toolbar_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new IntercomGalleryInputToolbarBinding(toolbar2, toolbar2, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
