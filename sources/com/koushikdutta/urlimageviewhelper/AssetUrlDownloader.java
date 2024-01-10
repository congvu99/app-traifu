package com.koushikdutta.urlimageviewhelper;

import android.content.Context;
import android.os.AsyncTask;
import com.koushikdutta.urlimageviewhelper.UrlDownloader;

public class AssetUrlDownloader implements UrlDownloader {
    public boolean allowCache() {
        return false;
    }

    public void download(Context context, String str, String str2, UrlDownloader.UrlDownloaderCallback urlDownloaderCallback, Runnable runnable) {
        final String str3 = str;
        final Context context2 = context;
        final UrlDownloader.UrlDownloaderCallback urlDownloaderCallback2 = urlDownloaderCallback;
        final Runnable runnable2 = runnable;
        UrlImageViewHelper.executeTask(new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                try {
                    urlDownloaderCallback2.onDownloadComplete(AssetUrlDownloader.this, context2.getAssets().open(str3.replaceFirst("file:///android_asset/", "")), (String) null);
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Void voidR) {
                runnable2.run();
            }
        });
    }

    public boolean canDownloadUrl(String str) {
        return str.startsWith("file:///android_asset/");
    }
}
