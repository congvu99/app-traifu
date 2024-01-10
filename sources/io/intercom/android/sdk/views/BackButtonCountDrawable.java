package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.intercom.commons.utilities.ScreenUtils;
import io.intercom.android.sdk.R;

class BackButtonCountDrawable extends Drawable {
    private static final String COUNT_BACKGROUND_COLOR = "#FE536C";
    private static final int COUNT_BACKGROUND_RADIUS_DP = 8;
    private static final int COUNT_TEXT_PADDING_TOP = 4;
    private static final int COUNT_TEXT_SIZE_DP = 11;
    private static final int ICON_PADDING_DP = 16;
    private static final int ICON_SIZE_DP = 24;
    private final Drawable backIcon;
    private final Paint countBackgroundPaint;
    private final int countBackgroundRadius;
    private final int iconPadding;
    private final int iconSize;
    private String text;
    private final Paint textPaint;
    private final int textTopPadding;

    public int getOpacity() {
        return -3;
    }

    BackButtonCountDrawable(Context context, String str) {
        this.text = str;
        this.backIcon = ContextCompat.getDrawable(context, R.drawable.intercom_back);
        if (Build.VERSION.SDK_INT >= 23) {
            this.backIcon.setLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        }
        this.iconPadding = ScreenUtils.dpToPx(16.0f, context);
        this.iconSize = ScreenUtils.dpToPx(24.0f, context);
        Paint paint = new Paint();
        this.countBackgroundPaint = paint;
        paint.setAntiAlias(true);
        this.countBackgroundPaint.setColor(Color.parseColor(COUNT_BACKGROUND_COLOR));
        this.countBackgroundPaint.setStyle(Paint.Style.FILL);
        this.countBackgroundRadius = ScreenUtils.dpToPx(8.0f, context);
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textPaint.setTextSize((float) ScreenUtils.dpToPx(11.0f, context));
        this.textPaint.setFakeBoldText(true);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textTopPadding = ScreenUtils.dpToPx(4.0f, context);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = bounds.left + this.iconPadding;
        int i2 = bounds.top + this.iconPadding;
        int i3 = this.iconSize;
        int i4 = i + i3;
        this.backIcon.setBounds(i, i2, i4, i3 + i2);
        this.backIcon.draw(canvas);
        if (!TextUtils.isEmpty(this.text)) {
            float f = (float) i4;
            canvas.drawCircle(f, (float) i2, (float) this.countBackgroundRadius, this.countBackgroundPaint);
            canvas.drawText(this.text, f, (float) (i2 + this.textTopPadding), this.textPaint);
        }
    }

    public void setAlpha(int i) {
        this.textPaint.setAlpha(i);
        this.countBackgroundPaint.setAlpha(i);
        this.backIcon.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.backIcon.setColorFilter(colorFilter);
    }

    public void setText(String str) {
        this.text = str;
        invalidateSelf();
    }
}
