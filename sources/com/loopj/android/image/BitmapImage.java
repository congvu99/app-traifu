package com.loopj.android.image;

import android.content.Context;
import android.graphics.Bitmap;

public class BitmapImage implements SmartImage {
    private Bitmap bitmap;

    public BitmapImage(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public Bitmap getBitmap(Context context) {
        return this.bitmap;
    }
}
