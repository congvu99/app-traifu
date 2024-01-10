package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomComposerEditTextBinding implements ViewBinding {
    public final EditText inputText;
    private final EditText rootView;

    private IntercomComposerEditTextBinding(EditText editText, EditText editText2) {
        this.rootView = editText;
        this.inputText = editText2;
    }

    public EditText getRoot() {
        return this.rootView;
    }

    public static IntercomComposerEditTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomComposerEditTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_composer_edit_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomComposerEditTextBinding bind(View view) {
        if (view != null) {
            EditText editText = (EditText) view;
            return new IntercomComposerEditTextBinding(editText, editText);
        }
        throw new NullPointerException("rootView");
    }
}
