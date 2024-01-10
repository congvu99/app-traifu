package com.intercom.composer.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

public class ResourceIconProvider implements IconProvider {
    private final int resId;

    public ResourceIconProvider(int i) {
        this.resId = i;
    }

    public Drawable getIconDrawable(String str, Context context) {
        return ContextCompat.getDrawable(context, this.resId);
    }
}
