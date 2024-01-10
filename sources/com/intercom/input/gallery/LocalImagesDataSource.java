package com.intercom.input.gallery;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import androidx.fragment.app.FragmentActivity;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.intercom.input.gallery.GalleryInputDataSource;
import java.util.ArrayList;
import java.util.List;

public class LocalImagesDataSource implements GalleryInputDataSource {
    private static final int ITEM_COUNT_LIMIT = 50;
    private static final int READ_EXTERNAL_STORAGE_REQUEST = 1;
    private Context context;
    private GalleryInputScreen galleryInputScreen;
    private GalleryInputDataSource.Listener listener;
    private boolean loading;
    private PermissionHelper permissionHelper;
    private final boolean shouldShowVideos;

    public static GalleryInputDataSource create(GalleryInputFragment galleryInputFragment, boolean z) {
        FragmentActivity activity = galleryInputFragment.getActivity();
        return new LocalImagesDataSource(activity, PermissionHelper.create(activity), galleryInputFragment, z);
    }

    LocalImagesDataSource(Context context2, PermissionHelper permissionHelper2, GalleryInputScreen galleryInputScreen2, boolean z) {
        this.context = context2;
        this.galleryInputScreen = galleryInputScreen2;
        this.permissionHelper = permissionHelper2;
        this.shouldShowVideos = z;
    }

    public int getPermissionStatus() {
        if (Build.VERSION.SDK_INT >= 33) {
            return this.permissionHelper.getPermissionStatus("android.permission.READ_MEDIA_IMAGES");
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return this.permissionHelper.getPermissionStatus("android.permission.READ_EXTERNAL_STORAGE");
        }
        return 0;
    }

    public void requestPermission() {
        this.permissionHelper.setAskedForPermissionPref(true);
        if (Build.VERSION.SDK_INT >= 33) {
            this.galleryInputScreen.requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO"}, 1);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.galleryInputScreen.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        }
    }

    public void setListener(GalleryInputDataSource.Listener listener2) {
        this.listener = listener2;
    }

    public int getCount() {
        Cursor createMediaCursor;
        if (getPermissionStatus() != 0 || (createMediaCursor = createMediaCursor(0)) == null) {
            return 0;
        }
        int count = createMediaCursor.getCount();
        createMediaCursor.close();
        return count;
    }

    public void getImages(int i, String str) {
        this.loading = true;
        Cursor createMediaCursor = createMediaCursor(i);
        this.loading = false;
        if (createMediaCursor == null) {
            this.listener.onError();
        } else {
            this.listener.onSuccess(galleryImagesFromCursor(createMediaCursor));
        }
    }

    /* access modifiers changed from: package-private */
    public List<GalleryImage> galleryImagesFromCursor(Cursor cursor) {
        Cursor cursor2 = cursor;
        ArrayList arrayList = new ArrayList(cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                int i = cursor2.getInt(cursor2.getColumnIndexOrThrow(MessengerShareContentUtility.MEDIA_TYPE));
                String string = cursor2.getString(cursor2.getColumnIndexOrThrow("mime_type"));
                String string2 = cursor2.getString(cursor2.getColumnIndexOrThrow("title"));
                int i2 = cursor2.getInt(cursor2.getColumnIndexOrThrow("_size"));
                long j = cursor2.getLong(cursor2.getColumnIndexOrThrow("duration"));
                if (!(string2 == null || string == null)) {
                    Uri withAppendedId = ContentUris.withAppendedId(getContentUri(), cursor2.getLong(cursor2.getColumnIndexOrThrow(APEZProvider.FILEID)));
                    String createFileNameWithExtension = createFileNameWithExtension(string2, string, MimeTypeMap.getSingleton());
                    Point imageHeightAndWidth = getImageHeightAndWidth(cursor);
                    String str = createFileNameWithExtension;
                    GalleryImage galleryImage = r4;
                    GalleryImage galleryImage2 = new GalleryImage(str, string, withAppendedId, "", "", imageHeightAndWidth.x, imageHeightAndWidth.y, i2, false, i == 3, UtilsKt.millisecondsToFormatTime(j));
                    arrayList.add(galleryImage);
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public String createFileNameWithExtension(String str, String str2, MimeTypeMap mimeTypeMap) {
        String extensionFromMimeType;
        if (!MimeTypeMap.getFileExtensionFromUrl(str).isEmpty() || (extensionFromMimeType = mimeTypeMap.getExtensionFromMimeType(str2)) == null || extensionFromMimeType.isEmpty()) {
            return str;
        }
        return String.format("%s.%s", new Object[]{str, extensionFromMimeType});
    }

    private Point getImageHeightAndWidth(Cursor cursor) {
        return new Point(cursor.getInt(cursor.getColumnIndexOrThrow("width")), cursor.getInt(cursor.getColumnIndexOrThrow("height")));
    }

    public boolean isLoading() {
        return this.loading;
    }

    private Cursor createMediaCursor(int i) {
        int i2 = i;
        String str = "media_type=1";
        if (this.shouldShowVideos) {
            str = str + " OR media_type=3";
        }
        String str2 = str;
        String[] strArr = {APEZProvider.FILEID, "date_added", MessengerShareContentUtility.MEDIA_TYPE, "mime_type", "title", "height", "width", "_size", "duration"};
        if (Build.VERSION.SDK_INT >= 26) {
            Bundle bundle = new Bundle();
            bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});
            bundle.putInt("android:query-arg-sort-direction", 1);
            bundle.putInt("android:query-arg-limit", 50);
            bundle.putInt("android:query-arg-offset", i2);
            bundle.putString("android:query-arg-sql-selection", str2);
            return this.context.getContentResolver().query(getContentUri(), strArr, bundle, (CancellationSignal) null);
        }
        return this.context.getContentResolver().query(getContentUri(), strArr, str2, (String[]) null, "date_added DESC LIMIT 50 OFFSET " + i2);
    }

    private Uri getContentUri() {
        return MediaStore.Files.getContentUri("external");
    }
}
