package com.trainerfu.utils;

import android.graphics.Bitmap;
import java.io.File;

public interface OnImagePickedHandler {
    void onImagePicked(Bitmap bitmap, String str, File file);
}
