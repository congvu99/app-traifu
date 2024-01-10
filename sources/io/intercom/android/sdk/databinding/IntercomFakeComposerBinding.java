package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomFakeComposerBinding implements ViewBinding {
    public final EditText composerInputView;
    private final EditText rootView;

    private IntercomFakeComposerBinding(EditText editText, EditText editText2) {
        this.rootView = editText;
        this.composerInputView = editText2;
    }

    public EditText getRoot() {
        return this.rootView;
    }

    public static IntercomFakeComposerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomFakeComposerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_fake_composer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomFakeComposerBinding bind(View view) {
        if (view != null) {
            EditText editText = (EditText) view;
            return new IntercomFakeComposerBinding(editText, editText);
        }
        throw new NullPointerException("rootView");
    }
}
