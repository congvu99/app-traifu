package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomGifInputToolbarBinding implements ViewBinding {
    public final ImageButton clearSearch;
    private final Toolbar rootView;
    public final EditText searchBar;
    public final Toolbar toolbar;

    private IntercomGifInputToolbarBinding(Toolbar toolbar2, ImageButton imageButton, EditText editText, Toolbar toolbar3) {
        this.rootView = toolbar2;
        this.clearSearch = imageButton;
        this.searchBar = editText;
        this.toolbar = toolbar3;
    }

    public Toolbar getRoot() {
        return this.rootView;
    }

    public static IntercomGifInputToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomGifInputToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_gif_input_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomGifInputToolbarBinding bind(View view) {
        int i = R.id.clear_search;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.search_bar;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                Toolbar toolbar2 = (Toolbar) view;
                return new IntercomGifInputToolbarBinding(toolbar2, imageButton, editText, toolbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
