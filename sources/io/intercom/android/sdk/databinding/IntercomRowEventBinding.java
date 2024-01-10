package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.AvatarIcon;

public final class IntercomRowEventBinding implements ViewBinding {
    public final AvatarIcon avatar;
    public final TextView eventName;
    private final LinearLayout rootView;

    private IntercomRowEventBinding(LinearLayout linearLayout, AvatarIcon avatarIcon, TextView textView) {
        this.rootView = linearLayout;
        this.avatar = avatarIcon;
        this.eventName = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowEventBinding bind(View view) {
        int i = R.id.avatar;
        AvatarIcon avatarIcon = (AvatarIcon) ViewBindings.findChildViewById(view, i);
        if (avatarIcon != null) {
            i = R.id.event_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new IntercomRowEventBinding((LinearLayout) view, avatarIcon, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
