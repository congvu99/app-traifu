package io.intercom.android.sdk.views;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class AvatarInitialsDrawable extends Drawable {
    private final Paint avatarBackground;
    private final String text;
    private final Rect textBounds = new Rect();
    private final Paint textPaint;

    public int getOpacity() {
        return -3;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public AvatarInitialsDrawable(String str, int i) {
        this.text = str;
        Paint paint = new Paint();
        this.avatarBackground = paint;
        paint.setAntiAlias(true);
        this.avatarBackground.setColor(i);
        this.avatarBackground.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textPaint.setFakeBoldText(true);
        this.textPaint.setTextAlign(Paint.Align.LEFT);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.textPaint.setTextSize((float) (bounds.height() / 3));
        Paint paint = this.textPaint;
        String str = this.text;
        paint.getTextBounds(str, 0, str.length(), this.textBounds);
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), (float) (bounds.height() / 2), this.avatarBackground);
        canvas.drawText(this.text, ((float) bounds.centerX()) - this.textBounds.exactCenterX(), ((float) bounds.centerY()) - this.textBounds.exactCenterY(), this.textPaint);
    }

    public void setAlpha(int i) {
        this.textPaint.setAlpha(i);
        this.avatarBackground.setAlpha(i);
    }
}
