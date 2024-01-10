package com.joanzapata.iconify;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import androidx.core.view.ViewCompat;
import com.joanzapata.iconify.internal.IconFontDescriptorWrapper;

public class IconDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    private int alpha = 255;
    private Context context;
    private Icon icon;
    private TextPaint paint;
    private int size = -1;

    public boolean isStateful() {
        return true;
    }

    public IconDrawable(Context context2, String str) {
        Icon findIconForKey = Iconify.findIconForKey(str);
        if (findIconForKey != null) {
            init(context2, findIconForKey);
            return;
        }
        throw new IllegalArgumentException("No icon with that key \"" + str + "\".");
    }

    public IconDrawable(Context context2, Icon icon2) {
        init(context2, icon2);
    }

    private void init(Context context2, Icon icon2) {
        this.context = context2;
        this.icon = icon2;
        this.paint = new TextPaint();
        IconFontDescriptorWrapper findTypefaceOf = Iconify.findTypefaceOf(icon2);
        if (findTypefaceOf != null) {
            this.paint.setTypeface(findTypefaceOf.getTypeface(context2));
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setTextAlign(Paint.Align.CENTER);
            this.paint.setUnderlineText(false);
            this.paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.paint.setAntiAlias(true);
            return;
        }
        throw new IllegalStateException("Unable to find the module associated with icon " + icon2.key() + ", have you registered the module " + "you are trying to use with Iconify.with(...) in your Application?");
    }

    public IconDrawable actionBarSize() {
        return sizeDp(24);
    }

    public IconDrawable sizeRes(int i) {
        return sizePx(this.context.getResources().getDimensionPixelSize(i));
    }

    public IconDrawable sizeDp(int i) {
        return sizePx(convertDpToPx(this.context, (float) i));
    }

    public IconDrawable sizePx(int i) {
        this.size = i;
        setBounds(0, 0, i, i);
        invalidateSelf();
        return this;
    }

    public IconDrawable color(int i) {
        this.paint.setColor(i);
        invalidateSelf();
        return this;
    }

    public IconDrawable colorRes(int i) {
        this.paint.setColor(this.context.getResources().getColor(i));
        invalidateSelf();
        return this;
    }

    public IconDrawable alpha(int i) {
        setAlpha(i);
        invalidateSelf();
        return this;
    }

    public int getIntrinsicHeight() {
        return this.size;
    }

    public int getIntrinsicWidth() {
        return this.size;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int height = bounds.height();
        this.paint.setTextSize((float) height);
        Rect rect = new Rect();
        String valueOf = String.valueOf(this.icon.character());
        this.paint.getTextBounds(valueOf, 0, 1, rect);
        int height2 = rect.height();
        canvas.drawText(valueOf, bounds.exactCenterX(), ((((float) bounds.top) + (((float) (height - height2)) / 2.0f)) + ((float) height2)) - ((float) rect.bottom), this.paint);
    }

    public boolean setState(int[] iArr) {
        int alpha2 = this.paint.getAlpha();
        int i = isEnabled(iArr) ? this.alpha : this.alpha / 2;
        this.paint.setAlpha(i);
        return alpha2 != i;
    }

    public void setAlpha(int i) {
        this.alpha = i;
        this.paint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void clearColorFilter() {
        this.paint.setColorFilter((ColorFilter) null);
    }

    public int getOpacity() {
        return this.alpha;
    }

    public void setStyle(Paint.Style style) {
        this.paint.setStyle(style);
    }

    private boolean isEnabled(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842910) {
                return true;
            }
        }
        return false;
    }

    private int convertDpToPx(Context context2, float f) {
        return (int) TypedValue.applyDimension(1, f, context2.getResources().getDisplayMetrics());
    }
}
