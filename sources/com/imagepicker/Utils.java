package com.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Utils {
    public static String cameraPermissionDescription = "This library does not require Manifest.permission.CAMERA, if you add this permission in manifest then you have to obtain the same.";
    public static String errCameraUnavailable = "camera_unavailable";
    public static String errOthers = "others";
    public static String errPermission = "permission";
    public static String fileNamePrefix = "rn_image_picker_lib_temp_";
    public static String mediaTypePhoto = "photo";
    public static String mediaTypeVideo = "video";

    static boolean isValidRequestCode(int i) {
        switch (i) {
            case ImagePickerModule.REQUEST_LAUNCH_IMAGE_CAPTURE /*13001*/:
            case ImagePickerModule.REQUEST_LAUNCH_VIDEO_CAPTURE /*13002*/:
            case ImagePickerModule.REQUEST_LAUNCH_LIBRARY /*13003*/:
                return true;
            default:
                return false;
        }
    }

    public static File createFile(Context context, String str) {
        try {
            File file = new File(context.getCacheDir(), fileNamePrefix + UUID.randomUUID() + "." + str);
            file.createNewFile();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri createUri(File file, Context context) {
        return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".imagepickerprovider", file);
    }

    public static void saveToPublicDirectory(Uri uri, Context context, String str) {
        Uri uri2;
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues contentValues = new ContentValues();
        if (str.equals("video")) {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uri2 = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            contentValues.put("_display_name", UUID.randomUUID().toString());
            contentValues.put("mime_type", contentResolver.getType(uri));
            uri2 = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        copyUri(uri, uri2, contentResolver);
    }

    public static void copyUri(Uri uri, Uri uri2, ContentResolver contentResolver) {
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(uri2);
            InputStream openInputStream = contentResolver.openInputStream(uri);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read != -1) {
                    openOutputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Uri getAppSpecificStorageUri(Uri uri, Context context) {
        if (uri == null) {
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri fromFile = Uri.fromFile(createFile(context, getFileTypeFromMime(contentResolver.getType(uri))));
        copyUri(uri, fromFile, contentResolver);
        return fromFile;
    }

    public static boolean isCameraAvailable(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera") || context.getPackageManager().hasSystemFeature("android.hardware.camera.any");
    }

    public static void setFrontCamera(Intent intent) {
        if (Build.VERSION.SDK_INT >= 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                return;
            }
            return;
        }
        intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
    }

    public static int[] getImageDimensions(Uri uri, Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new int[]{0, 0};
        }
    }

    static boolean hasPermission(Activity activity) {
        return ActivityCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    static String getBase64String(Uri uri, Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Uri resizeImage(Uri uri, Context context, Options options) {
        try {
            int[] imageDimensions = getImageDimensions(uri, context);
            if (!shouldResizeImage(imageDimensions[0], imageDimensions[1], options)) {
                return uri;
            }
            int[] imageDimensBasedOnConstraints = getImageDimensBasedOnConstraints(imageDimensions[0], imageDimensions[1], options);
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            String mimeTypeFromFileUri = getMimeTypeFromFileUri(uri);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeStream(openInputStream), imageDimensBasedOnConstraints[0], imageDimensBasedOnConstraints[1], true);
            String orientation = getOrientation(uri, context);
            File createFile = createFile(context, getFileTypeFromMime(mimeTypeFromFileUri));
            createScaledBitmap.compress(getBitmapCompressFormat(mimeTypeFromFileUri), options.quality, context.getContentResolver().openOutputStream(Uri.fromFile(createFile)));
            setOrientation(createFile, orientation, context);
            deleteFile(uri);
            return Uri.fromFile(createFile);
        } catch (Exception e) {
            e.printStackTrace();
            return uri;
        }
    }

    static String getOrientation(Uri uri, Context context) throws IOException {
        return new ExifInterface(context.getContentResolver().openInputStream(uri)).getAttribute(ExifInterface.TAG_ORIENTATION);
    }

    static void setOrientation(File file, String str, Context context) throws IOException {
        if (!str.equals(String.valueOf(1)) && !str.equals(String.valueOf(0))) {
            ExifInterface exifInterface = new ExifInterface(file);
            exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, str);
            exifInterface.saveAttributes();
        }
    }

    static int[] getImageDimensBasedOnConstraints(int i, int i2, Options options) {
        if (options.maxWidth == 0 || options.maxHeight == 0) {
            return new int[]{i, i2};
        }
        if (options.maxWidth < i) {
            i2 = (int) ((((float) options.maxWidth) / ((float) i)) * ((float) i2));
            i = options.maxWidth;
        }
        if (options.maxHeight < i2) {
            i = (int) ((((float) options.maxHeight) / ((float) i2)) * ((float) i));
            i2 = options.maxHeight;
        }
        return new int[]{i, i2};
    }

    static double getFileSize(Uri uri, Context context) {
        try {
            return (double) context.getContentResolver().openFileDescriptor(uri, "r").getStatSize();
        } catch (Exception e) {
            e.printStackTrace();
            return com.github.mikephil.charting.utils.Utils.DOUBLE_EPSILON;
        }
    }

    static boolean shouldResizeImage(int i, int i2, Options options) {
        if ((options.maxWidth == 0 || options.maxHeight == 0) && options.quality == 100) {
            return false;
        }
        if (options.maxWidth < i || options.maxHeight < i2 || options.quality != 100) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap.CompressFormat getBitmapCompressFormat(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = -1487394660(0xffffffffa758289c, float:-2.9998036E-15)
            r2 = 1
            if (r0 == r1) goto L_0x001a
            r1 = -879258763(0xffffffffcb979375, float:-1.986737E7)
            if (r0 == r1) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r0 = "image/png"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r0 = "image/jpeg"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0025
        L_0x0024:
            r3 = -1
        L_0x0025:
            if (r3 == 0) goto L_0x002f
            if (r3 == r2) goto L_0x002c
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG
            return r3
        L_0x002c:
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG
            return r3
        L_0x002f:
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.Utils.getBitmapCompressFormat(java.lang.String):android.graphics.Bitmap$CompressFormat");
    }

    static String getFileTypeFromMime(String str) {
        if (str == null) {
            return "jpg";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1487394660) {
            if (hashCode != -879267568) {
                if (hashCode == -879258763 && str.equals("image/png")) {
                    c = 1;
                }
            } else if (str.equals("image/gif")) {
                c = 2;
            }
        } else if (str.equals(coil.util.Utils.MIME_TYPE_JPEG)) {
            c = 0;
        }
        if (c != 1) {
            return c != 2 ? "jpg" : "gif";
        }
        return "png";
    }

    static void deleteFile(Uri uri) {
        new File(uri.getPath()).delete();
    }

    static String getMimeTypeFromFileUri(Uri uri) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    }

    public static boolean isCameraPermissionFulfilled(Context context, Activity activity) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null || !Arrays.asList(strArr).contains("android.permission.CAMERA") || ActivityCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    static boolean isImageType(Uri uri, Context context) {
        return isContentType("image/", uri, context);
    }

    static boolean isVideoType(Uri uri, Context context) {
        return isContentType("video/", uri, context);
    }

    static boolean isContentType(String str, Uri uri, Context context) {
        String mimeType = getMimeType(uri, context);
        if (mimeType != null) {
            return mimeType.contains(str);
        }
        return false;
    }

    static String getMimeType(Uri uri, Context context) {
        if (uri.getScheme().equals("file")) {
            return getMimeTypeFromFileUri(uri);
        }
        return context.getContentResolver().getType(uri);
    }

    static List<Uri> collectUrisFromData(Intent intent) {
        if (intent.getClipData() == null) {
            return Collections.singletonList(intent.getData());
        }
        ClipData clipData = intent.getClipData();
        ArrayList arrayList = new ArrayList(clipData.getItemCount());
        for (int i = 0; i < clipData.getItemCount(); i++) {
            arrayList.add(clipData.getItemAt(i).getUri());
        }
        return arrayList;
    }

    static ReadableMap getImageResponseMap(Uri uri, Options options, Context context) {
        String lastPathSegment = uri.getLastPathSegment();
        ImageMetadata imageMetadata = new ImageMetadata(uri, context);
        int[] imageDimensions = getImageDimensions(uri, context);
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uri", uri.toString());
        createMap.putDouble("fileSize", getFileSize(uri, context));
        createMap.putString("fileName", lastPathSegment);
        createMap.putString("type", getMimeTypeFromFileUri(uri));
        createMap.putInt("width", imageDimensions[0]);
        createMap.putInt("height", imageDimensions[1]);
        createMap.putString("type", getMimeType(uri, context));
        if (options.includeBase64.booleanValue()) {
            createMap.putString("base64", getBase64String(uri, context));
        }
        if (options.includeExtra.booleanValue()) {
            createMap.putString("timestamp", imageMetadata.getDateTime());
            createMap.putString("id", lastPathSegment);
        }
        return createMap;
    }

    static ReadableMap getVideoResponseMap(Uri uri, Options options, Context context) {
        String lastPathSegment = uri.getLastPathSegment();
        WritableMap createMap = Arguments.createMap();
        VideoMetadata videoMetadata = new VideoMetadata(uri, context);
        createMap.putString("uri", uri.toString());
        createMap.putDouble("fileSize", getFileSize(uri, context));
        createMap.putInt("duration", videoMetadata.getDuration());
        createMap.putInt("bitrate", videoMetadata.getBitrate());
        createMap.putString("fileName", lastPathSegment);
        createMap.putString("type", getMimeType(uri, context));
        createMap.putInt("width", videoMetadata.getWidth());
        createMap.putInt("height", videoMetadata.getHeight());
        if (options.includeExtra.booleanValue()) {
            createMap.putString("timestamp", videoMetadata.getDateTime());
            createMap.putString("id", lastPathSegment);
        }
        return createMap;
    }

    static ReadableMap getResponseMap(List<Uri> list, Options options, Context context) throws RuntimeException {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i);
            if (isImageType(uri, context)) {
                if (uri.getScheme().contains("content")) {
                    uri = getAppSpecificStorageUri(uri, context);
                }
                createArray.pushMap(getImageResponseMap(resizeImage(uri, context, options), options, context));
            } else if (isVideoType(uri, context)) {
                createArray.pushMap(getVideoResponseMap(uri, options, context));
            } else {
                throw new RuntimeException("Unsupported file type");
            }
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("assets", createArray);
        return createMap;
    }

    static ReadableMap getErrorMap(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("errorCode", str);
        if (str2 != null) {
            createMap.putString("errorMessage", str2);
        }
        return createMap;
    }

    static ReadableMap getCancelMap() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("didCancel", true);
        return createMap;
    }
}
