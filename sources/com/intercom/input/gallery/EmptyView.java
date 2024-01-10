package com.intercom.input.gallery;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmptyView extends LinearLayout {
    private Button actionButton;
    private String actionButtonText;
    private int internalPaddingBottom;
    private int internalPaddingLeft;
    private int internalPaddingRight;
    private int internalPaddingTop;
    private TextView subtitle;
    private String subtitleText;
    private TextView title;
    private String titleText;

    public EmptyView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|4|5|6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0054, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0068, code lost:
        r5.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EmptyView(android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.<init>(r5, r6)
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r5)
            int r2 = com.intercom.input.gallery.R.layout.intercom_composer_empty_view
            r3 = 1
            r1.inflate(r2, r4, r3)
            int r1 = com.intercom.input.gallery.R.color.intercom_composer_white
            r4.setBackgroundResource(r1)
            int[] r1 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view
            r2 = 0
            android.content.res.TypedArray r5 = r5.obtainStyledAttributes(r6, r1, r2, r2)
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_titleText     // Catch:{ RuntimeException -> 0x0056 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ RuntimeException -> 0x0056 }
            r4.titleText = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_subtitleText     // Catch:{ RuntimeException -> 0x0056 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ RuntimeException -> 0x0056 }
            r4.subtitleText = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_actionButtonText     // Catch:{ RuntimeException -> 0x0056 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ RuntimeException -> 0x0056 }
            r4.actionButtonText = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingTop     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = r5.getDimensionPixelSize(r6, r2)     // Catch:{ RuntimeException -> 0x0056 }
            r4.internalPaddingTop = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingBottom     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = r5.getDimensionPixelSize(r6, r2)     // Catch:{ RuntimeException -> 0x0056 }
            r4.internalPaddingBottom = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingLeft     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = r5.getDimensionPixelSize(r6, r2)     // Catch:{ RuntimeException -> 0x0056 }
            r4.internalPaddingLeft = r6     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = com.intercom.input.gallery.R.styleable.intercom_composer_empty_view_intercom_composer_internalPaddingRight     // Catch:{ RuntimeException -> 0x0056 }
            int r6 = r5.getDimensionPixelSize(r6, r2)     // Catch:{ RuntimeException -> 0x0056 }
            r4.internalPaddingRight = r6     // Catch:{ RuntimeException -> 0x0056 }
            goto L_0x0064
        L_0x0054:
            r6 = move-exception
            goto L_0x0068
        L_0x0056:
            r4.titleText = r0     // Catch:{ all -> 0x0054 }
            r4.subtitleText = r0     // Catch:{ all -> 0x0054 }
            r4.actionButtonText = r0     // Catch:{ all -> 0x0054 }
            r4.internalPaddingTop = r2     // Catch:{ all -> 0x0054 }
            r4.internalPaddingBottom = r2     // Catch:{ all -> 0x0054 }
            r4.internalPaddingLeft = r2     // Catch:{ all -> 0x0054 }
            r4.internalPaddingRight = r2     // Catch:{ all -> 0x0054 }
        L_0x0064:
            r5.recycle()
            return
        L_0x0068:
            r5.recycle()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intercom.input.gallery.EmptyView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.title = (TextView) findViewById(R.id.empty_text_title);
        this.subtitle = (TextView) findViewById(R.id.empty_text_subtitle);
        this.actionButton = (Button) findViewById(R.id.empty_action_button);
        this.title.setText(this.titleText);
        this.subtitle.setText(this.subtitleText);
        if (!TextUtils.isEmpty(this.actionButtonText)) {
            this.actionButton.setText(this.actionButtonText);
        } else {
            this.actionButton.setVisibility(8);
        }
        ((LinearLayout) findViewById(R.id.empty_view_layout)).setPadding(this.internalPaddingLeft, this.internalPaddingTop, this.internalPaddingRight, this.internalPaddingBottom);
    }

    public void setTitle(CharSequence charSequence) {
        this.title.setText(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.subtitle.setText(charSequence);
    }

    public void setActionButtonClickListener(View.OnClickListener onClickListener) {
        this.actionButton.setOnClickListener(onClickListener);
    }

    public void setTitle(int i) {
        this.title.setText(i);
    }

    public void setSubtitle(int i) {
        this.subtitle.setText(i);
    }

    public void setActionButtonVisibility(int i) {
        this.actionButton.setVisibility(i);
    }

    public void setThemeColor(int i) {
        this.actionButton.setBackgroundColor(i);
    }
}
