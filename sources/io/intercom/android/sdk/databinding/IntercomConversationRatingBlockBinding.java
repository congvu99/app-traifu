package io.intercom.android.sdk.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import io.intercom.android.sdk.R;

public final class IntercomConversationRatingBlockBinding implements ViewBinding {
    public final LinearLayout intercomRatingOptionsLayout;
    public final Button intercomRatingTellUsMoreButton;
    public final ImageView intercomYouRatedImageView;
    public final LinearLayout intercomYouRatedLayout;
    public final TextView rateYourConversationTextView;
    private final LinearLayout rootView;

    private IntercomConversationRatingBlockBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, ImageView imageView, LinearLayout linearLayout3, TextView textView) {
        this.rootView = linearLayout;
        this.intercomRatingOptionsLayout = linearLayout2;
        this.intercomRatingTellUsMoreButton = button;
        this.intercomYouRatedImageView = imageView;
        this.intercomYouRatedLayout = linearLayout3;
        this.rateYourConversationTextView = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IntercomConversationRatingBlockBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static IntercomConversationRatingBlockBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.intercom_conversation_rating_block, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static IntercomConversationRatingBlockBinding bind(View view) {
        int i = R.id.intercom_rating_options_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.intercom_rating_tell_us_more_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.intercom_you_rated_image_view;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.intercom_you_rated_layout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.rate_your_conversation_text_view;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new IntercomConversationRatingBlockBinding((LinearLayout) view, linearLayout, button, imageView, linearLayout2, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
