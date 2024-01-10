package com.koushikdutta.urlimageviewhelper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import com.koushikdutta.urlimageviewhelper.UrlDownloader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.apache.http.NameValuePair;

public final class UrlImageViewHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CACHE_DURATION_FIVE_DAYS = 432000000;
    public static final int CACHE_DURATION_FOUR_DAYS = 345600000;
    public static final int CACHE_DURATION_INFINITE = Integer.MAX_VALUE;
    public static final int CACHE_DURATION_ONE_DAY = 86400000;
    public static final int CACHE_DURATION_ONE_WEEK = 604800000;
    public static final int CACHE_DURATION_SIX_DAYS = 518400000;
    public static final int CACHE_DURATION_THREE_DAYS = 259200000;
    public static final int CACHE_DURATION_TWO_DAYS = 172800000;
    /* access modifiers changed from: private */
    public static HashSet<Bitmap> mAllCache = new HashSet<>();
    private static AssetUrlDownloader mAssetDownloader = new AssetUrlDownloader();
    private static ContactContentUrlDownloader mContactDownloader = new ContactContentUrlDownloader();
    private static ContentUrlDownloader mContentDownloader = new ContentUrlDownloader();
    /* access modifiers changed from: private */
    public static LruBitmapCache mDeadCache = null;
    private static ArrayList<UrlDownloader> mDownloaders = null;
    private static FileUrlDownloader mFileDownloader = new FileUrlDownloader();
    private static boolean mHasCleaned = false;
    private static HttpUrlDownloader mHttpDownloader = new HttpUrlDownloader();
    /* access modifiers changed from: private */
    public static DrawableCache mLiveCache = DrawableCache.getInstance();
    static DisplayMetrics mMetrics = null;
    /* access modifiers changed from: private */
    public static Hashtable<String, ArrayList<ImageView>> mPendingDownloads = new Hashtable<>();
    /* access modifiers changed from: private */
    public static Hashtable<ImageView, String> mPendingViews = new Hashtable<>();
    private static RequestPropertiesCallback mRequestPropertiesCallback = null;
    static Resources mResources = null;
    private static boolean mUseBitmapScaling = true;

    public interface RequestPropertiesCallback {
        ArrayList<NameValuePair> getHeadersForRequest(Context context, String str);
    }

    static void clog(String str, Object... objArr) {
        if (objArr.length != 0) {
            String.format(str, objArr);
        }
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            outputStream.write(bArr, 0, read);
            i += read;
        }
    }

    private static void prepareResources(Context context) {
        if (mMetrics == null) {
            mMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(mMetrics);
            mResources = new Resources(context.getAssets(), mMetrics, context.getResources().getConfiguration());
        }
    }

    public static void setUseBitmapScaling(boolean z) {
        mUseBitmapScaling = z;
    }

    public static boolean getUseBitmapScaling() {
        return mUseBitmapScaling;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[SYNTHETIC, Splitter:B:32:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3 A[SYNTHETIC, Splitter:B:40:0x00b3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap loadBitmapFromStream(android.content.Context r8, java.lang.String r9, java.lang.String r10, int r11, int r12) {
        /*
            java.lang.String r0 = "Failed to close FileInputStream"
            java.lang.String r1 = "UrlImageViewHelper"
            prepareResources(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "Decoding: "
            r8.append(r2)
            r8.append(r9)
            java.lang.String r9 = " "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r9 = 0
            java.lang.Object[] r2 = new java.lang.Object[r9]
            clog(r8, r2)
            r8 = 0
            boolean r2 = mUseBitmapScaling     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            r3 = 8192(0x2000, float:1.14794E-41)
            r4 = 1
            if (r2 == 0) goto L_0x005e
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            r2.<init>()     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            r2.inJustDecodeBounds = r4     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            r6.<init>(r10)     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            r5.<init>(r6, r3)     // Catch:{ IOException -> 0x00b0, all -> 0x00a2 }
            android.graphics.BitmapFactory.decodeStream(r5, r8, r2)     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            r5.close()     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            r6 = 0
        L_0x0046:
            int r7 = r2.outWidth     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            int r7 = r7 >> r6
            if (r7 > r11) goto L_0x005b
            int r7 = r2.outHeight     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            int r7 = r7 >> r6
            if (r7 <= r12) goto L_0x0051
            goto L_0x005b
        L_0x0051:
            android.graphics.BitmapFactory$Options r11 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            r11.<init>()     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            int r12 = r4 << r6
            r11.inSampleSize = r12     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            goto L_0x0060
        L_0x005b:
            int r6 = r6 + 1
            goto L_0x0046
        L_0x005e:
            r11 = r8
            r5 = r11
        L_0x0060:
            java.io.BufferedInputStream r12 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            r2.<init>(r10)     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            r12.<init>(r2, r3)     // Catch:{ IOException -> 0x00a0, all -> 0x009d }
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r12, r8, r11)     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            java.lang.String r11 = "Loaded bitmap (%dx%d)."
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            int r3 = r10.getWidth()     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            r2[r9] = r3     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            int r3 = r10.getHeight()     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            r2[r4] = r3     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            java.lang.String r11 = java.lang.String.format(r11, r2)     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            clog(r11, r9)     // Catch:{ IOException -> 0x009b, all -> 0x0099 }
            r12.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r8 = move-exception
            android.util.Log.w(r1, r0, r8)
        L_0x0098:
            return r10
        L_0x0099:
            r8 = move-exception
            goto L_0x00a5
        L_0x009b:
            r5 = r12
            goto L_0x00b1
        L_0x009d:
            r8 = move-exception
            r12 = r5
            goto L_0x00a5
        L_0x00a0:
            goto L_0x00b1
        L_0x00a2:
            r9 = move-exception
            r12 = r8
            r8 = r9
        L_0x00a5:
            if (r12 == 0) goto L_0x00af
            r12.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r9 = move-exception
            android.util.Log.w(r1, r0, r9)
        L_0x00af:
            throw r8
        L_0x00b0:
            r5 = r8
        L_0x00b1:
            if (r5 == 0) goto L_0x00bb
            r5.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r9 = move-exception
            android.util.Log.w(r1, r0, r9)
        L_0x00bb:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.loadBitmapFromStream(android.content.Context, java.lang.String, java.lang.String, int, int):android.graphics.Bitmap");
    }

    public static void setUrlDrawable(ImageView imageView, String str, int i) {
        setUrlDrawable(imageView.getContext(), imageView, str, i, 259200000);
    }

    public static void setUrlDrawable(ImageView imageView, String str) {
        setUrlDrawable(imageView.getContext(), imageView, str, (Drawable) null, 259200000, (UrlImageViewCallback) null);
    }

    public static void loadUrlDrawable(Context context, String str) {
        setUrlDrawable(context, (ImageView) null, str, (Drawable) null, 259200000, (UrlImageViewCallback) null);
    }

    public static void setUrlDrawable(ImageView imageView, String str, Drawable drawable) {
        setUrlDrawable(imageView.getContext(), imageView, str, drawable, 259200000, (UrlImageViewCallback) null);
    }

    public static void setUrlDrawable(ImageView imageView, String str, int i, long j) {
        setUrlDrawable(imageView.getContext(), imageView, str, i, j);
    }

    public static void loadUrlDrawable(Context context, String str, long j) {
        setUrlDrawable(context, (ImageView) null, str, (Drawable) null, j, (UrlImageViewCallback) null);
    }

    public static void setUrlDrawable(ImageView imageView, String str, Drawable drawable, long j) {
        setUrlDrawable(imageView.getContext(), imageView, str, drawable, j, (UrlImageViewCallback) null);
    }

    private static void setUrlDrawable(Context context, ImageView imageView, String str, int i, long j) {
        setUrlDrawable(context, imageView, str, i != 0 ? imageView.getResources().getDrawable(i) : null, j, (UrlImageViewCallback) null);
    }

    public static void setUrlDrawable(ImageView imageView, String str, int i, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(imageView.getContext(), imageView, str, i, 259200000, urlImageViewCallback);
    }

    public static void setUrlDrawable(ImageView imageView, String str, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(imageView.getContext(), imageView, str, (Drawable) null, 259200000, urlImageViewCallback);
    }

    public static void loadUrlDrawable(Context context, String str, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(context, (ImageView) null, str, (Drawable) null, 259200000, urlImageViewCallback);
    }

    public static void setUrlDrawable(ImageView imageView, String str, Drawable drawable, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(imageView.getContext(), imageView, str, drawable, 259200000, urlImageViewCallback);
    }

    public static void setUrlDrawable(ImageView imageView, String str, int i, long j, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(imageView.getContext(), imageView, str, i, j, urlImageViewCallback);
    }

    public static void loadUrlDrawable(Context context, String str, long j, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(context, (ImageView) null, str, (Drawable) null, j, urlImageViewCallback);
    }

    public static void setUrlDrawable(ImageView imageView, String str, Drawable drawable, long j, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(imageView.getContext(), imageView, str, drawable, j, urlImageViewCallback);
    }

    private static void setUrlDrawable(Context context, ImageView imageView, String str, int i, long j, UrlImageViewCallback urlImageViewCallback) {
        setUrlDrawable(context, imageView, str, i != 0 ? imageView.getResources().getDrawable(i) : null, j, urlImageViewCallback);
    }

    private static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.equals("") || charSequence.equals(JsonLexerKt.NULL) || charSequence.equals("NULL");
    }

    public static String getFilenameForUrl(String str) {
        return str.hashCode() + ".urlimage";
    }

    public static void cleanup(Context context, long j) {
        if (!mHasCleaned) {
            mHasCleaned = true;
            try {
                String[] list = context.getFilesDir().list();
                if (list != null) {
                    for (String str : list) {
                        if (str.endsWith(".urlimage")) {
                            File file = new File(context.getFilesDir().getAbsolutePath() + '/' + str);
                            if (System.currentTimeMillis() > file.lastModified() + j) {
                                file.delete();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void cleanup(Context context) {
        cleanup(context, 604800000);
    }

    private static boolean checkCacheDuration(File file, long j) {
        return j == 2147483647L || System.currentTimeMillis() < file.lastModified() + j;
    }

    public static Bitmap getCachedBitmap(String str) {
        if (str == null) {
            return null;
        }
        LruBitmapCache lruBitmapCache = mDeadCache;
        Bitmap bitmap = lruBitmapCache != null ? (Bitmap) lruBitmapCache.get(str) : null;
        if (bitmap != null) {
            return bitmap;
        }
        DrawableCache drawableCache = mLiveCache;
        if (drawableCache != null) {
            Drawable drawable = (Drawable) drawableCache.get(str);
            if (drawable instanceof ZombieDrawable) {
                return ((ZombieDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0201 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setUrlDrawable(android.content.Context r20, android.widget.ImageView r21, java.lang.String r22, android.graphics.drawable.Drawable r23, long r24, com.koushikdutta.urlimageviewhelper.UrlImageViewCallback r26) {
        /*
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r6 = r26
            cleanup(r20)
            boolean r0 = isNullOrEmpty(r22)
            if (r0 == 0) goto L_0x001e
            if (r7 == 0) goto L_0x001d
            java.util.Hashtable<android.widget.ImageView, java.lang.String> r0 = mPendingViews
            r0.remove(r7)
            r7.setImageDrawable(r9)
        L_0x001d:
            return
        L_0x001e:
            android.util.DisplayMetrics r0 = mMetrics
            if (r0 != 0) goto L_0x0025
            prepareResources(r20)
        L_0x0025:
            android.util.DisplayMetrics r0 = mMetrics
            int r0 = r0.widthPixels
            android.util.DisplayMetrics r1 = mMetrics
            int r1 = r1.heightPixels
            java.lang.String r2 = getFilenameForUrl(r22)
            r12 = r20
            java.io.File r2 = r12.getFileStreamPath(r2)
            java.lang.String r13 = r2.getAbsolutePath()
            java.io.File r14 = new java.io.File
            r14.<init>(r13)
            com.koushikdutta.urlimageviewhelper.LruBitmapCache r2 = mDeadCache
            if (r2 != 0) goto L_0x0051
            com.koushikdutta.urlimageviewhelper.LruBitmapCache r2 = new com.koushikdutta.urlimageviewhelper.LruBitmapCache
            int r3 = getHeapSize(r20)
            int r3 = r3 / 8
            r2.<init>(r3)
            mDeadCache = r2
        L_0x0051:
            com.koushikdutta.urlimageviewhelper.LruBitmapCache r2 = mDeadCache
            java.lang.Object r2 = r2.remove(r8)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            r15 = 0
            if (r2 == 0) goto L_0x0074
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "zombie load: "
            r4.append(r5)
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r15]
            clog(r4, r5)
            r4 = 0
            goto L_0x007c
        L_0x0074:
            com.koushikdutta.urlimageviewhelper.DrawableCache r4 = mLiveCache
            java.lang.Object r4 = r4.get(r8)
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
        L_0x007c:
            if (r4 != 0) goto L_0x0080
            if (r2 == 0) goto L_0x00dc
        L_0x0080:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r3 = "Cache hit on: "
            r5.append(r3)
            r5.append(r8)
            java.lang.String r3 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r15]
            clog(r3, r5)
            boolean r3 = r14.exists()
            if (r3 == 0) goto L_0x00c6
            boolean r3 = checkCacheDuration(r14, r10)
            if (r3 != 0) goto L_0x00c6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cache hit, but file is stale. Forcing reload: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r15]
            clog(r2, r3)
            if (r4 == 0) goto L_0x00c3
            boolean r2 = r4 instanceof com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable
            if (r2 == 0) goto L_0x00c3
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable r4 = (com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable) r4
            r4.headshot()
        L_0x00c3:
            r2 = 0
            r3 = 0
            goto L_0x00dd
        L_0x00c6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Using cached: "
            r3.append(r5)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r5 = new java.lang.Object[r15]
            clog(r3, r5)
        L_0x00dc:
            r3 = r4
        L_0x00dd:
            if (r3 != 0) goto L_0x01dd
            if (r2 == 0) goto L_0x00e3
            goto L_0x01dd
        L_0x00e3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Waiting for "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = " "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r15]
            clog(r2, r3)
            if (r7 == 0) goto L_0x010b
            r7.setImageDrawable(r9)
            java.util.Hashtable<android.widget.ImageView, java.lang.String> r2 = mPendingViews
            r2.put(r7, r8)
        L_0x010b:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<android.widget.ImageView>> r2 = mPendingDownloads
            java.lang.Object r2 = r2.get(r8)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            if (r2 == 0) goto L_0x011b
            if (r7 == 0) goto L_0x011a
            r2.add(r7)
        L_0x011a:
            return
        L_0x011b:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r7 == 0) goto L_0x0125
            r5.add(r7)
        L_0x0125:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<android.widget.ImageView>> r2 = mPendingDownloads
            r2.put(r8, r5)
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r0 > 0) goto L_0x0133
            r4 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0134
        L_0x0133:
            r4 = r0
        L_0x0134:
            if (r1 > 0) goto L_0x013a
            r16 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x013c
        L_0x013a:
            r16 = r1
        L_0x013c:
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$1 r3 = new com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$1
            r0 = r3
            r1 = r13
            r2 = r20
            r17 = r3
            r3 = r22
            r18 = r5
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5)
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$2 r5 = new com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$2
            r0 = r5
            r1 = r17
            r2 = r22
            r3 = r23
            r4 = r26
            r6 = r5
            r5 = r21
            r19 = r6
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            boolean r0 = r14.exists()
            if (r0 == 0) goto L_0x01b3
            boolean r0 = checkCacheDuration(r14, r10)     // Catch:{ Exception -> 0x01b3 }
            if (r0 == 0) goto L_0x01a7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b3 }
            r0.<init>()     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r1 = "File Cache hit on: "
            r0.append(r1)     // Catch:{ Exception -> 0x01b3 }
            r0.append(r8)     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r1 = ". "
            r0.append(r1)     // Catch:{ Exception -> 0x01b3 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01b3 }
            long r3 = r14.lastModified()     // Catch:{ Exception -> 0x01b3 }
            long r1 = r1 - r3
            r0.append(r1)     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r1 = "ms old."
            r0.append(r1)     // Catch:{ Exception -> 0x01b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01b3 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01b3 }
            clog(r0, r1)     // Catch:{ Exception -> 0x01b3 }
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$3 r0 = new com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$3     // Catch:{ Exception -> 0x01b3 }
            r4 = r17
            r5 = r19
            r0.<init>(r4, r13, r5)     // Catch:{ Exception -> 0x01b7 }
            executeTask(r0)     // Catch:{ Exception -> 0x01b7 }
            return
        L_0x01a7:
            r4 = r17
            r5 = r19
            java.lang.String r0 = "File cache has expired. Refreshing."
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x01b7 }
            clog(r0, r1)     // Catch:{ Exception -> 0x01b7 }
            goto L_0x01b7
        L_0x01b3:
            r4 = r17
            r5 = r19
        L_0x01b7:
            java.util.ArrayList<com.koushikdutta.urlimageviewhelper.UrlDownloader> r0 = mDownloaders
            java.util.Iterator r0 = r0.iterator()
        L_0x01bd:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01d9
            java.lang.Object r1 = r0.next()
            com.koushikdutta.urlimageviewhelper.UrlDownloader r1 = (com.koushikdutta.urlimageviewhelper.UrlDownloader) r1
            boolean r2 = r1.canDownloadUrl(r8)
            if (r2 == 0) goto L_0x01bd
            r0 = r1
            r1 = r20
            r2 = r22
            r3 = r13
            r0.download(r1, r2, r3, r4, r5)
            return
        L_0x01d9:
            r7.setImageDrawable(r9)
            return
        L_0x01dd:
            if (r7 == 0) goto L_0x01ff
            java.util.Hashtable<android.widget.ImageView, java.lang.String> r0 = mPendingViews
            r0.remove(r7)
            boolean r0 = r3 instanceof com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable
            if (r0 == 0) goto L_0x01f2
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable r3 = (com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable) r3
            android.content.res.Resources r0 = mResources
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable r0 = r3.clone(r0)
        L_0x01f0:
            r3 = r0
            goto L_0x01fc
        L_0x01f2:
            if (r2 == 0) goto L_0x01fc
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable r0 = new com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable
            android.content.res.Resources r1 = mResources
            r0.<init>(r8, r1, r2)
            goto L_0x01f0
        L_0x01fc:
            r7.setImageDrawable(r3)
        L_0x01ff:
            if (r6 == 0) goto L_0x0211
            if (r2 != 0) goto L_0x020d
            boolean r0 = r3 instanceof com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable
            if (r0 == 0) goto L_0x020d
            com.koushikdutta.urlimageviewhelper.UrlImageViewHelper$ZombieDrawable r3 = (com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.ZombieDrawable) r3
            android.graphics.Bitmap r2 = r3.getBitmap()
        L_0x020d:
            r0 = 1
            r6.onLoaded(r7, r2, r8, r0)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.urlimageviewhelper.UrlImageViewHelper.setUrlDrawable(android.content.Context, android.widget.ImageView, java.lang.String, android.graphics.drawable.Drawable, long, com.koushikdutta.urlimageviewhelper.UrlImageViewCallback):void");
    }

    private static abstract class Loader implements UrlDownloader.UrlDownloaderCallback {
        Bitmap result;

        private Loader() {
        }
    }

    static {
        ArrayList<UrlDownloader> arrayList = new ArrayList<>();
        mDownloaders = arrayList;
        arrayList.add(mHttpDownloader);
        mDownloaders.add(mContactDownloader);
        mDownloaders.add(mContentDownloader);
        mDownloaders.add(mAssetDownloader);
        mDownloaders.add(mFileDownloader);
    }

    public static ArrayList<UrlDownloader> getDownloaders() {
        return mDownloaders;
    }

    public static RequestPropertiesCallback getRequestPropertiesCallback() {
        return mRequestPropertiesCallback;
    }

    public static void setRequestPropertiesCallback(RequestPropertiesCallback requestPropertiesCallback) {
        mRequestPropertiesCallback = requestPropertiesCallback;
    }

    private static int getHeapSize(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getMemoryClass() * 1024 * 1024;
    }

    public static Bitmap remove(String str) {
        new File(getFilenameForUrl(str)).delete();
        Drawable drawable = (Drawable) mLiveCache.remove(str);
        if (!(drawable instanceof ZombieDrawable)) {
            return null;
        }
        ZombieDrawable zombieDrawable = (ZombieDrawable) drawable;
        Bitmap bitmap = zombieDrawable.getBitmap();
        zombieDrawable.headshot();
        return bitmap;
    }

    private static class ZombieDrawable extends BitmapDrawable {
        Brains mBrains;
        String mUrl;

        private static class Brains {
            boolean mHeadshot;
            int mRefCounter;

            private Brains() {
            }
        }

        public ZombieDrawable(String str, Resources resources, Bitmap bitmap) {
            this(str, resources, bitmap, new Brains());
        }

        private ZombieDrawable(String str, Resources resources, Bitmap bitmap, Brains brains) {
            super(resources, bitmap);
            this.mUrl = str;
            this.mBrains = brains;
            UrlImageViewHelper.mAllCache.add(bitmap);
            UrlImageViewHelper.mDeadCache.remove(str);
            UrlImageViewHelper.mLiveCache.put(str, this);
            this.mBrains.mRefCounter++;
        }

        public ZombieDrawable clone(Resources resources) {
            return new ZombieDrawable(this.mUrl, resources, getBitmap(), this.mBrains);
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            super.finalize();
            Brains brains = this.mBrains;
            brains.mRefCounter--;
            if (this.mBrains.mRefCounter == 0) {
                if (!this.mBrains.mHeadshot) {
                    UrlImageViewHelper.mDeadCache.put(this.mUrl, getBitmap());
                }
                UrlImageViewHelper.mAllCache.remove(getBitmap());
                UrlImageViewHelper.mLiveCache.remove(this.mUrl);
                UrlImageViewHelper.clog("Zombie GC event " + this.mUrl, new Object[0]);
            }
        }

        public void headshot() {
            UrlImageViewHelper.clog("BOOM! Headshot: " + this.mUrl, new Object[0]);
            this.mBrains.mHeadshot = true;
            UrlImageViewHelper.mLiveCache.remove(this.mUrl);
            UrlImageViewHelper.mAllCache.remove(getBitmap());
        }
    }

    static void executeTask(AsyncTask<Void, Void, Void> asyncTask) {
        if (Build.VERSION.SDK_INT < 11) {
            asyncTask.execute(new Void[0]);
        } else {
            executeTaskHoneycomb(asyncTask);
        }
    }

    private static void executeTaskHoneycomb(AsyncTask<Void, Void, Void> asyncTask) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int getPendingDownloads() {
        return mPendingDownloads.size();
    }
}
