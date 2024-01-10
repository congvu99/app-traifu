package io.intercom.android.sdk.conversation.composer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import io.intercom.android.sdk.R;

public class InputDrawableManager {
    private static final int[][] STATES = {new int[]{16842919}, new int[]{16842913}, new int[0]};
    private final ColorStateList colorStateList;

    public InputDrawableManager(Context context, int i) {
        this.colorStateList = new ColorStateList(STATES, new int[]{i, i, ContextCompat.getColor(context, R.color.intercom_input_default_color)});
    }

    public Drawable createDrawable(Context context, int i) {
        Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i));
        DrawableCompat.setTintList(wrap, this.colorStateList);
        return wrap;
    }
}
