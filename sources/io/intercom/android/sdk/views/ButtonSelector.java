package io.intercom.android.sdk.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.StateListDrawable;

public class ButtonSelector extends StateListDrawable {
    private final int color;

    public ButtonSelector(Context context, int i, int i2) {
        this.color = i2;
        addState(new int[]{16842910}, context.getResources().getDrawable(i));
        addState(new int[]{16842908}, context.getResources().getDrawable(i));
        addState(new int[]{16842919}, context.getResources().getDrawable(i));
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i : iArr) {
            if (i == 16842919 || i == 16842908) {
                z = true;
            }
        }
        if (z) {
            setColorFilter(darken(this.color, 0.9d), PorterDuff.Mode.SRC);
        } else {
            setColorFilter(this.color, PorterDuff.Mode.SRC);
        }
        return super.onStateChange(iArr);
    }

    private static int darken(int i, double d) {
        return Color.argb(255, (int) (((double) Color.red(i)) * d), (int) (((double) Color.green(i)) * d), (int) (((double) Color.blue(i)) * d));
    }
}
