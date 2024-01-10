package com.trainerfu.story;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.loopj.android.image.SmartImageView;
import com.trainerfu.android.R;
import com.trainerfu.utils.Util;

public class CreditView extends LinearLayout {
    private View.OnClickListener clickListener;

    public CreditView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CreditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initializeViews(context);
    }

    public void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.credit_view, this);
    }

    public void setCredit(String str, String str2, String str3, Integer num) {
        if (num == null || num.intValue() <= 0) {
            findViewById(R.id.profile_view).setVisibility(8);
            findViewById(R.id.profile_placeholder_view).setVisibility(0);
        } else {
            SmartImageView smartImageView = (SmartImageView) findViewById(R.id.profile_view);
            smartImageView.setVisibility(0);
            smartImageView.setImageUrl(Util.getUrlForPhoto(num.intValue()));
            findViewById(R.id.profile_placeholder_view).setVisibility(8);
        }
        if (!(str2 == null || str2.length() == 0 || str2.equals("-"))) {
            str = String.format("%s %s", new Object[]{str, str2});
        }
        String format = String.format(getContext().getString(R.string.trainedByXCredit), new Object[]{str});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new StyleSpan(1), format.length() - str.length(), format.length(), 33);
        ((TextView) findViewById(R.id.title_view)).setText(spannableStringBuilder);
        ((TextView) findViewById(R.id.subtitle_view)).setText(str3);
    }
}
