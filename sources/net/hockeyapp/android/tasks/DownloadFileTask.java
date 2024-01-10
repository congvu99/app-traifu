package net.hockeyapp.android.tasks;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import net.hockeyapp.android.Strings;
import net.hockeyapp.android.listeners.DownloadFileListener;

public class DownloadFileTask extends AsyncTask<String, Integer, Boolean> {
    private Context context;
    private String filePath = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
    private String filename = (UUID.randomUUID() + ".apk");
    /* access modifiers changed from: private */
    public DownloadFileListener notifier;
    private ProgressDialog progressDialog;
    private String urlString;

    public DownloadFileTask(Context context2, String str, DownloadFileListener downloadFileListener) {
        this.context = context2;
        this.urlString = str;
        this.notifier = downloadFileListener;
    }

    public void attach(Context context2) {
        this.context = context2;
    }

    public void detach() {
        this.context = null;
        this.progressDialog = null;
    }

    /* access modifiers changed from: protected */
    public Boolean doInBackground(String... strArr) {
        boolean z;
        try {
            URLConnection createConnection = createConnection(new URL(getURLString()));
            createConnection.connect();
            int contentLength = createConnection.getContentLength();
            File file = new File(this.filePath);
            if (!file.mkdirs()) {
                if (!file.exists()) {
                    throw new IOException("Could not create the dir(s):" + file.getAbsolutePath());
                }
            }
            File file2 = new File(file, this.filename);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(createConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[1024];
            long j = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                z = true;
                if (read == -1) {
                    break;
                }
                j += (long) read;
                publishProgress(new Integer[]{Integer.valueOf((int) ((100 * j) / ((long) contentLength)))});
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (j <= 0) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public URLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
        httpURLConnection.setInstanceFollowRedirects(true);
        if (Build.VERSION.SDK_INT <= 9) {
            httpURLConnection.setRequestProperty("connection", "close");
        }
        return httpURLConnection;
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
        try {
            if (this.progressDialog == null) {
                ProgressDialog progressDialog2 = new ProgressDialog(this.context);
                this.progressDialog = progressDialog2;
                progressDialog2.setProgressStyle(1);
                this.progressDialog.setMessage("Loading...");
                this.progressDialog.setCancelable(false);
                this.progressDialog.show();
            }
            this.progressDialog.setProgress(numArr[0].intValue());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Boolean bool) {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            try {
                progressDialog2.dismiss();
            } catch (Exception unused) {
            }
        }
        if (bool.booleanValue()) {
            this.notifier.downloadSuccessful(this);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.filePath, this.filename)), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            this.context.startActivity(intent);
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle(Strings.get(this.notifier, 4));
            builder.setMessage(Strings.get(this.notifier, 5));
            builder.setNegativeButton(Strings.get(this.notifier, 6), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownloadFileTask.this.notifier.downloadFailed(DownloadFileTask.this, false);
                }
            });
            builder.setPositiveButton(Strings.get(this.notifier, 7), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownloadFileTask.this.notifier.downloadFailed(DownloadFileTask.this, true);
                }
            });
            builder.create().show();
        } catch (Exception unused2) {
        }
    }

    private String getURLString() {
        return this.urlString + "&type=apk";
    }
}
