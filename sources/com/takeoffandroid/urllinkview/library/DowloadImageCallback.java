package com.takeoffandroid.urllinkview.library;

import android.graphics.Bitmap;
import android.widget.ImageView;

public interface DowloadImageCallback {
    void onLoaded(ImageView imageView, Bitmap bitmap, String str);
}
