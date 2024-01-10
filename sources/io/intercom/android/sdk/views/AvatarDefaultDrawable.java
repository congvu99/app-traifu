package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;

public class AvatarDefaultDrawable extends Drawable {
    private final Paint avatarBackground;
    private final Drawable companyIcon;
    private final RectF roundRect = new RectF();

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public AvatarDefaultDrawable(Context context, int i) {
        this.companyIcon = ContextCompat.getDrawable(context, R.drawable.intercom_default_avatar_icon);
        Paint paint = new Paint();
        this.avatarBackground = paint;
        paint.setAntiAlias(true);
        this.avatarBackground.setColor(i);
        this.avatarBackground.setStyle(Paint.Style.FILL);
    }

    public void draw(Canvas canvas) {
        this.roundRect.set(getBounds());
        canvas.drawRoundRect(this.roundRect, (float) (canvas.getHeight() / 2), (float) (canvas.getHeight() / 2), this.avatarBackground);
        int width = (canvas.getWidth() - this.companyIcon.getIntrinsicWidth()) / 2;
        int height = (canvas.getHeight() - this.companyIcon.getIntrinsicHeight()) / 2;
        Drawable drawable = this.companyIcon;
        drawable.setBounds(width, height, drawable.getIntrinsicWidth() + width, this.companyIcon.getIntrinsicHeight() + height);
        this.companyIcon.draw(canvas);
    }
}