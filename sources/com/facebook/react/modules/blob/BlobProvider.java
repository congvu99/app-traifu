package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class BlobProvider extends ContentProvider {
    private static final int PIPE_CAPACITY = 65536;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.ParcelFileDescriptor openFile(android.net.Uri r5, java.lang.String r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "r"
            boolean r0 = r6.equals(r0)
            java.lang.String r1 = "Cannot open "
            if (r0 == 0) goto L_0x0091
            android.content.Context r6 = r4.getContext()
            android.content.Context r6 = r6.getApplicationContext()
            boolean r0 = r6 instanceof com.facebook.react.ReactApplication
            r2 = 0
            if (r0 == 0) goto L_0x002e
            com.facebook.react.ReactApplication r6 = (com.facebook.react.ReactApplication) r6
            com.facebook.react.ReactNativeHost r6 = r6.getReactNativeHost()
            com.facebook.react.ReactInstanceManager r6 = r6.getReactInstanceManager()
            com.facebook.react.bridge.ReactContext r6 = r6.getCurrentReactContext()
            java.lang.Class<com.facebook.react.modules.blob.BlobModule> r0 = com.facebook.react.modules.blob.BlobModule.class
            com.facebook.react.bridge.NativeModule r6 = r6.getNativeModule(r0)
            com.facebook.react.modules.blob.BlobModule r6 = (com.facebook.react.modules.blob.BlobModule) r6
            goto L_0x002f
        L_0x002e:
            r6 = r2
        L_0x002f:
            if (r6 == 0) goto L_0x0089
            byte[] r6 = r6.resolve((android.net.Uri) r5)
            if (r6 == 0) goto L_0x006b
            android.os.ParcelFileDescriptor[] r5 = android.os.ParcelFileDescriptor.createPipe()     // Catch:{ IOException -> 0x006a }
            r0 = 0
            r0 = r5[r0]
            r1 = 1
            r5 = r5[r1]
            int r1 = r6.length
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r1 > r3) goto L_0x005f
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch:{ IOException -> 0x005e }
            r1.<init>(r5)     // Catch:{ IOException -> 0x005e }
            r1.write(r6)     // Catch:{ all -> 0x0052 }
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0069
        L_0x0052:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r6 = move-exception
            r1.close()     // Catch:{ all -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r0 = move-exception
            r5.addSuppressed(r0)     // Catch:{ IOException -> 0x005e }
        L_0x005d:
            throw r6     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            return r2
        L_0x005f:
            com.facebook.react.modules.blob.BlobProvider$1 r1 = new com.facebook.react.modules.blob.BlobProvider$1
            r1.<init>(r5, r6)
            java.util.concurrent.ExecutorService r5 = r4.executor
            r5.submit(r1)
        L_0x0069:
            return r0
        L_0x006a:
            return r2
        L_0x006b:
            java.io.FileNotFoundException r6 = new java.io.FileNotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            java.lang.String r5 = ", blob not found."
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x0089:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "No blob module associated with BlobProvider"
            r5.<init>(r6)
            throw r5
        L_0x0091:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            java.lang.String r5 = " in mode '"
            r2.append(r5)
            r2.append(r6)
            java.lang.String r5 = "'"
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.blob.BlobProvider.openFile(android.net.Uri, java.lang.String):android.os.ParcelFileDescriptor");
    }
}
