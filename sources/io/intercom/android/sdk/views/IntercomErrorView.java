package io.intercom.android.sdk.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.utilities.FontUtils;

public class IntercomErrorView extends RelativeLayout {
    private Button actionButton;
    private TextView subtitle;
    private TextView titleView;

    public IntercomErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IntercomErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(R.id.empty_text_title);
        this.titleView = textView;
        FontUtils.setRobotoMediumTypeface(textView);
        this.subtitle = (TextView) findViewById(R.id.empty_text_subtitle);
        this.actionButton = (Button) findViewById(R.id.action_button);
    }

    public void setTitle(int i) {
        this.titleView.setText(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.subtitle.setText(charSequence);
    }

    public void setSubtitle(int i) {
        this.subtitle.setText(i);
    }

    public void setActionButtonVisibility(int i) {
        this.actionButton.setVisibility(i);
    }

    public void setActionButtonText(int i) {
        this.actionButton.setText(i);
    }

    public void setActionButtonClickListener(View.OnClickListener onClickListener) {
        this.actionButton.setOnClickListener(onClickListener);
    }

    public void setActionButtonTextColor(int i) {
        this.actionButton.setTextColor(i);
    }
}
