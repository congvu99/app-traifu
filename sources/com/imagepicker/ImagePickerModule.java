package com.imagepicker;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.anggrayudi.storage.file.MimeType;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;
import java.util.Collections;
import java.util.List;

@ReactModule(name = "ImagePickerManager")
public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    static final String NAME = "ImagePickerManager";
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_LIBRARY = 13003;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13002;
    Callback callback;
    Uri cameraCaptureURI;
    private Uri fileUri;
    Options options;
    final ReactApplicationContext reactContext;

    public String getName() {
        return NAME;
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback2) {
        int i;
        File file;
        Intent intent;
        if (!Utils.isCameraAvailable(this.reactContext)) {
            callback2.invoke(Utils.getErrorMap(Utils.errCameraUnavailable, (String) null));
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback2.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
        } else if (!Utils.isCameraPermissionFulfilled(this.reactContext, currentActivity)) {
            callback2.invoke(Utils.getErrorMap(Utils.errOthers, Utils.cameraPermissionDescription));
        } else {
            this.callback = callback2;
            Options options2 = new Options(readableMap);
            this.options = options2;
            if (!options2.saveToPhotos.booleanValue() || Build.VERSION.SDK_INT > 28 || Utils.hasPermission(currentActivity)) {
                if (this.options.mediaType.equals(Utils.mediaTypeVideo)) {
                    i = REQUEST_LAUNCH_VIDEO_CAPTURE;
                    intent = new Intent("android.media.action.VIDEO_CAPTURE");
                    intent.putExtra("android.intent.extra.videoQuality", this.options.videoQuality);
                    if (this.options.durationLimit > 0) {
                        intent.putExtra("android.intent.extra.durationLimit", this.options.durationLimit);
                    }
                    file = Utils.createFile(this.reactContext, "mp4");
                    this.cameraCaptureURI = Utils.createUri(file, this.reactContext);
                } else {
                    i = REQUEST_LAUNCH_IMAGE_CAPTURE;
                    intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    file = Utils.createFile(this.reactContext, "jpg");
                    this.cameraCaptureURI = Utils.createUri(file, this.reactContext);
                }
                if (this.options.useFrontCamera.booleanValue()) {
                    Utils.setFrontCamera(intent);
                }
                this.fileUri = Uri.fromFile(file);
                intent.putExtra("output", this.cameraCaptureURI);
                intent.addFlags(3);
                try {
                    currentActivity.startActivityForResult(intent, i);
                } catch (ActivityNotFoundException e) {
                    callback2.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
                    this.callback = null;
                }
            } else {
                callback2.invoke(Utils.getErrorMap(Utils.errPermission, (String) null));
            }
        }
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback2) {
        Intent intent;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback2.invoke(Utils.getErrorMap(Utils.errOthers, "Activity error"));
            return;
        }
        this.callback = callback2;
        Options options2 = new Options(readableMap);
        this.options = options2;
        int i = options2.selectionLimit;
        boolean z = i == 1;
        boolean equals = this.options.mediaType.equals(Utils.mediaTypePhoto);
        boolean equals2 = this.options.mediaType.equals(Utils.mediaTypeVideo);
        if (Build.VERSION.SDK_INT >= 33) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
        } else if (!z || (!equals && !equals2)) {
            intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
        } else {
            intent = new Intent("android.intent.action.PICK");
        }
        if (!z) {
            if (Build.VERSION.SDK_INT < 33) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            } else if (i != 1) {
                if (i == 0) {
                    i = MediaStore.getPickImagesMaxLimit();
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", i);
            }
        }
        if (equals) {
            intent.setType(MimeType.IMAGE);
        } else if (equals2) {
            intent.setType(MimeType.VIDEO);
        } else if (Build.VERSION.SDK_INT < 33) {
            intent.setType(MimeType.UNKNOWN);
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{MimeType.IMAGE, MimeType.VIDEO});
        }
        try {
            currentActivity.startActivityForResult(intent, REQUEST_LAUNCH_LIBRARY);
        } catch (ActivityNotFoundException e) {
            callback2.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
            this.callback = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void onAssetsObtained(List<Uri> list) {
        try {
            this.callback.invoke(Utils.getResponseMap(list, this.options, this.reactContext));
        } catch (RuntimeException e) {
            this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
        } catch (Throwable th) {
            this.callback = null;
            throw th;
        }
        this.callback = null;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (Utils.isValidRequestCode(i) && this.callback != null) {
            if (i2 != -1) {
                if (i == 13001) {
                    Utils.deleteFile(this.fileUri);
                }
                try {
                    this.callback.invoke(Utils.getCancelMap());
                    return;
                } catch (RuntimeException e) {
                    this.callback.invoke(Utils.getErrorMap(Utils.errOthers, e.getMessage()));
                } finally {
                    this.callback = null;
                }
            }
            switch (i) {
                case REQUEST_LAUNCH_IMAGE_CAPTURE /*13001*/:
                    if (this.options.saveToPhotos.booleanValue()) {
                        Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, "photo");
                    }
                    onAssetsObtained(Collections.singletonList(this.fileUri));
                    return;
                case REQUEST_LAUNCH_VIDEO_CAPTURE /*13002*/:
                    if (this.options.saveToPhotos.booleanValue()) {
                        Utils.saveToPublicDirectory(this.cameraCaptureURI, this.reactContext, "video");
                    }
                    onAssetsObtained(Collections.singletonList(this.fileUri));
                    return;
                case REQUEST_LAUNCH_LIBRARY /*13003*/:
                    onAssetsObtained(Utils.collectUrisFromData(intent));
                    return;
                default:
                    return;
            }
        }
    }
}
