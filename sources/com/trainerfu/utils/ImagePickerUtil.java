package com.trainerfu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.MenuItem;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.trainerfu.android.R;
import java.io.File;
import java.util.List;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ImagePickerUtil {
    public static int OPEN_CAMERA_REQUEST_CODE = 7854;
    public static int OPEN_GALLERY_REQUEST_CODE = 2365;

    public static boolean requestPermissionsIfMissing(Context context, Activity activity, int i) {
        return requestPermissionsIfMissing(context, activity, (Fragment) null, i);
    }

    public static boolean requestPermissionsIfMissing(Context context, Fragment fragment, int i) {
        return requestPermissionsIfMissing(context, (Activity) null, fragment, i);
    }

    public static void showPickPhotoMenu(Activity activity, ContextMenu contextMenu) {
        activity.getMenuInflater().inflate(R.menu.pick_photo, contextMenu);
    }

    public static boolean isImagePickerMenuItem(MenuItem menuItem) {
        return menuItem.getItemId() == R.id.choosePhotoItem || menuItem.getItemId() == R.id.takePhotoItem;
    }

    public static boolean onContextItemSelected(MenuItem menuItem, Context context, Fragment fragment) {
        return onContextItemSelected(menuItem, context, (Activity) null, fragment);
    }

    public static boolean onContextItemSelected(MenuItem menuItem, Context context, Activity activity) {
        return onContextItemSelected(menuItem, context, activity, (Fragment) null);
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Fragment fragment) {
        onRequestPermissionsResult(i, strArr, iArr, (Activity) null, fragment);
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Activity activity) {
        onRequestPermissionsResult(i, strArr, iArr, activity, (Fragment) null);
    }

    public static void onActivityResult(Activity activity, int i, int i2, Intent intent, final boolean z, final OnImagePickedHandler onImagePickedHandler) {
        EasyImage.handleActivityResult(i, i2, intent, activity, new DefaultCallback() {
            public void onImagePickerError(Exception exc, EasyImage.ImageSource imageSource, int i) {
            }

            public void onImagesPicked(List<File> list, EasyImage.ImageSource imageSource, int i) {
                Bitmap bitmap;
                File file = list.get(0);
                if (z) {
                    bitmap = Util.scaleBitmapForProfile(file.getAbsolutePath());
                } else {
                    bitmap = Util.scaleBitmapForStory(file.getAbsolutePath());
                }
                onImagePickedHandler.onImagePicked(bitmap, file.getAbsolutePath(), file);
            }
        });
    }

    private static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Activity activity, Fragment fragment) {
        if (activity == null) {
            if (iArr[0] != 0) {
                return;
            }
            if (i == OPEN_GALLERY_REQUEST_CODE) {
                EasyImage.openGallery(fragment, 1);
            } else if (i == OPEN_CAMERA_REQUEST_CODE) {
                EasyImage.openCamera(fragment, 1);
            }
        } else if (iArr[0] != 0) {
        } else {
            if (i == OPEN_GALLERY_REQUEST_CODE) {
                EasyImage.openGallery(activity, 1);
            } else if (i == OPEN_CAMERA_REQUEST_CODE) {
                EasyImage.openCamera(activity, 1);
            }
        }
    }

    private static boolean onContextItemSelected(MenuItem menuItem, Context context, Activity activity, Fragment fragment) {
        if (activity == null) {
            if (menuItem.getItemId() == R.id.choosePhotoItem) {
                EasyImage.openGallery(fragment, 1);
            } else if (menuItem.getItemId() == R.id.takePhotoItem) {
                EasyImage.openCamera(fragment, 1);
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.choosePhotoItem) {
            EasyImage.openGallery(activity, 1);
        } else if (menuItem.getItemId() == R.id.takePhotoItem) {
            EasyImage.openCamera(activity, 1);
        }
        return true;
    }

    private static int getImagePickerRequestCode(int i) {
        if (i == R.id.choosePhotoItem) {
            return OPEN_GALLERY_REQUEST_CODE;
        }
        return OPEN_CAMERA_REQUEST_CODE;
    }

    private static boolean requestPermissionsIfMissing(Context context, Activity activity, Fragment fragment, int i) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        if (activity != null) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, i);
            return false;
        }
        fragment.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, i);
        return false;
    }
}
