package com.trainerfu.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutOptionsRowView extends LinearLayout {
    private String detail;
    private int iconResId;
    private int tintColor;
    private String title;

    public WorkoutOptionsRowView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WorkoutOptionsRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WorkoutOptionsRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WorkoutOptionsRowView);
        this.title = obtainStyledAttributes.getString(3);
        if (obtainStyledAttributes.hasValue(0)) {
            this.detail = obtainStyledAttributes.getString(0);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.tintColor = obtainStyledAttributes.getInteger(2, 0);
        }
        this.iconResId = obtainStyledAttributes.getResourceId(1, R.drawable.ic_add_circle_black_24dp);
        obtainStyledAttributes.recycle();
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.workout_options_row_view, this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        setTitle(this.title);
        Drawable drawable = getResources().getDrawable(this.iconResId);
        int i = this.tintColor;
        if (i != 0) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        ((ImageView) findViewById(R.id.icon_view)).setImageDrawable(drawable);
    }

    public void setTitle(String str) {
        this.title = str;
        ((TextView) findViewById(R.id.title_view)).setText(str);
    }

    public void setDetail(String str) {
        this.detail = str;
        TextView textView = (TextView) findViewById(R.id.detail_view);
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
}
