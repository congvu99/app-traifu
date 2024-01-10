package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import io.intercom.android.sdk.R;

public final class IntercomPreviewChatSnippetBodyBinding implements ViewBinding {
    public final TextView chatheadTextBody;
    private final TextView rootView;

    private IntercomPreviewChatSnippetBodyBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.chatheadTextBody = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static IntercomPreviewChatSnippetBodyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomPreviewChatSnippetBodyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_preview_chat_snippet_body, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomPreviewChatSnippetBodyBinding bind(View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new IntercomPreviewChatSnippetBodyBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }
}
