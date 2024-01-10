package com.trainerfu.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CTAButton extends LinearLayout {
    private String detail;
    private int iconResId;
    private int tintColor;
    private String title;

    public CTAButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public CTAButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CTAButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CTAButton);
        this.title = obtainStyledAttributes.getString(3);
        if (obtainStyledAttributes.hasValue(0)) {
            this.detail = obtainStyledAttributes.getString(0);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.tintColor = obtainStyledAttributes.getInteger(2, 0);
        }
        this.iconResId = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.cta_button, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setTitle(this.title);
        setDetail(this.detail);
        ImageView imageView = (ImageView) findViewById(R.id.iconIV);
        if (this.iconResId != 0) {
            Drawable drawable = getResources().getDrawable(this.iconResId);
            int i = this.tintColor;
            if (i != 0) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setTitle(String str) {
        this.title = str;
        ((TextView) findViewById(R.id.titleTV)).setText(str);
    }

    public void setDetail(String str) {
        this.detail = str;
        TextView textView = (TextView) findViewById(R.id.detailTV);
        if (str != null) {
            textView.setText(str);
            textView.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void setDrawable(Drawable drawable, Boolean bool) {
        ImageView imageView = (ImageView) findViewById(R.id.iconIV);
        if (bool.booleanValue()) {
            drawable.setColorFilter(getResources().getColor(R.color.lightBlack), PorterDuff.Mode.SRC_IN);
        }
        imageView.setImageDrawable(drawable);
    }

    public void setIconSize(int i, int i2, Boolean bool) {
        if (this.iconResId != 0) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) getResources().getDrawable(this.iconResId)).getBitmap(), i2, i, true));
            if (bool.booleanValue()) {
                bitmapDrawable.setColorFilter(getResources().getColor(R.color.lightBlack), PorterDuff.Mode.SRC_IN);
            }
            ((ImageView) findViewById(R.id.iconIV)).setImageDrawable(bitmapDrawable);
        }
    }

    public void hideDivider() {
        findViewById(R.id.divider).setVisibility(8);
    }

    public void showPendingCheckins(boolean z, String str) {
        TextView textView = (TextView) findViewById(R.id.pending_checkins);
        if (z) {
            textView.setVisibility(0);
            textView.setText(str);
            return;
        }
        textView.setVisibility(8);
    }
}
