package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.views.AuthorAvatarView;

public final class IntercomRowInboxBinding implements ViewBinding {
    public final AuthorAvatarView intercomAuthorAvatar;
    public final ConstraintLayout intercomInboxRowLayout;
    public final TextView intercomMessageSummary;
    public final TextView intercomTimeStamp;
    public final ImageView intercomUnreadDot;
    public final TextView intercomUserName;
    private final ConstraintLayout rootView;

    private IntercomRowInboxBinding(ConstraintLayout constraintLayout, AuthorAvatarView authorAvatarView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3) {
        this.rootView = constraintLayout;
        this.intercomAuthorAvatar = authorAvatarView;
        this.intercomInboxRowLayout = constraintLayout2;
        this.intercomMessageSummary = textView;
        this.intercomTimeStamp = textView2;
        this.intercomUnreadDot = imageView;
        this.intercomUserName = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static IntercomRowInboxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomRowInboxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_row_inbox, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomRowInboxBinding bind(View view) {
        int i = R.id.intercom_author_avatar;
        AuthorAvatarView authorAvatarView = (AuthorAvatarView) ViewBindings.findChildViewById(view, i);
        if (authorAvatarView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.intercom_message_summary;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.intercom_time_stamp;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.intercom_unread_dot;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.intercom_user_name;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new IntercomRowInboxBinding(constraintLayout, authorAvatarView, constraintLayout, textView, textView2, imageView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
