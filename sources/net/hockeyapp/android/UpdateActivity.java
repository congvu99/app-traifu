package net.hockeyapp.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import net.hockeyapp.android.listeners.DownloadFileListener;
import net.hockeyapp.android.objects.ErrorObject;
import net.hockeyapp.android.tasks.DownloadFileTask;
import net.hockeyapp.android.utils.VersionHelper;
import net.hockeyapp.android.views.UpdateView;

public class UpdateActivity extends Activity implements UpdateActivityInterface, UpdateInfoListener, View.OnClickListener {
    private final int DIALOG_ERROR_ID = 0;
    private Context context;
    protected DownloadFileTask downloadTask;
    /* access modifiers changed from: private */
    public ErrorObject error;
    protected VersionHelper versionHelper;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("App Update");
        setContentView(getLayoutView());
        this.context = this;
        this.versionHelper = new VersionHelper(getIntent().getStringExtra("json"), this);
        configureView();
        DownloadFileTask downloadFileTask = (DownloadFileTask) getLastNonConfigurationInstance();
        this.downloadTask = downloadFileTask;
        if (downloadFileTask != null) {
            downloadFileTask.attach(this);
        }
    }

    /* access modifiers changed from: protected */
    public void configureView() {
        ((TextView) findViewById(4098)).setText(getAppName());
        ((TextView) findViewById(4099)).setText("Version " + this.versionHelper.getVersionString() + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + this.versionHelper.getFileInfoString());
        ((Button) findViewById(UpdateView.UPDATE_BUTTON_ID)).setOnClickListener(this);
        WebView webView = (WebView) findViewById(UpdateView.WEB_VIEW_ID);
        webView.clearCache(true);
        webView.destroyDrawingCache();
        webView.loadDataWithBaseURL(Constants.BASE_URL, getReleaseNotes(), "text/html", "utf-8", (String) null);
    }

    /* access modifiers changed from: protected */
    public String getReleaseNotes() {
        return this.versionHelper.getReleaseNotes(false);
    }

    public Object onRetainNonConfigurationInstance() {
        DownloadFileTask downloadFileTask = this.downloadTask;
        if (downloadFileTask != null) {
            downloadFileTask.detach();
        }
        return this.downloadTask;
    }

    /* access modifiers changed from: protected */
    public void startDownloadTask() {
        startDownloadTask(getIntent().getStringExtra("url"));
    }

    /* access modifiers changed from: protected */
    public void startDownloadTask(String str) {
        createDownloadTask(str, new DownloadFileListener() {
            public void downloadSuccessful(DownloadFileTask downloadFileTask) {
                UpdateActivity.this.enableUpdateButton();
            }

            public void downloadFailed(DownloadFileTask downloadFileTask, Boolean bool) {
                if (bool.booleanValue()) {
                    UpdateActivity.this.startDownloadTask();
                } else {
                    UpdateActivity.this.enableUpdateButton();
                }
            }

            public String getStringForResource(int i) {
                UpdateManagerListener lastListener = UpdateManager.getLastListener();
                if (lastListener != null) {
                    return lastListener.getStringForResource(i);
                }
                return null;
            }
        });
        this.downloadTask.execute(new String[0]);
    }

    /* access modifiers changed from: protected */
    public void createDownloadTask(String str, DownloadFileListener downloadFileListener) {
        this.downloadTask = new DownloadFileTask(this, str, downloadFileListener);
    }

    public void enableUpdateButton() {
        findViewById(UpdateView.UPDATE_BUTTON_ID).setEnabled(true);
    }

    public int getCurrentVersionCode() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public ViewGroup getLayoutView() {
        return new UpdateView(this);
    }

    public String getAppName() {
        try {
            PackageManager packageManager = getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private boolean isWriteExternalStorageSet(Context context2) {
        return context2.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    private boolean isUnknownSourcesChecked() {
        Cursor cursor;
        String[] strArr = {"value"};
        if (Build.VERSION.SDK_INT >= 17) {
            cursor = getContentResolver().query(Settings.Global.CONTENT_URI, strArr, "name = ? AND value = ?", new String[]{"install_non_market_apps", String.valueOf(1)}, (String) null);
        } else {
            cursor = getContentResolver().query(Settings.Secure.CONTENT_URI, strArr, "name = ? AND value = ?", new String[]{"install_non_market_apps", String.valueOf(1)}, (String) null);
        }
        return cursor.getCount() == 1;
    }

    public void onClick(View view) {
        if (!isWriteExternalStorageSet(this.context)) {
            ErrorObject errorObject = new ErrorObject();
            this.error = errorObject;
            errorObject.setMessage("The permission to access the external storage permission is not set. Please contact the developer.");
            runOnUiThread(new Runnable() {
                public void run() {
                    UpdateActivity.this.showDialog(0);
                }
            });
        } else if (!isUnknownSourcesChecked()) {
            ErrorObject errorObject2 = new ErrorObject();
            this.error = errorObject2;
            errorObject2.setMessage("The installation from unknown sources is not enabled. Please check the device settings.");
            runOnUiThread(new Runnable() {
                public void run() {
                    UpdateActivity.this.showDialog(0);
                }
            });
        } else {
            startDownloadTask();
            view.setEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        if (i != 0) {
            return null;
        }
        return new AlertDialog.Builder(this).setMessage("An error has occured").setCancelable(false).setTitle("Error").setIcon(17301543).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                ErrorObject unused = UpdateActivity.this.error = null;
                dialogInterface.cancel();
            }
        }).create();
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i == 0) {
            AlertDialog alertDialog = (AlertDialog) dialog;
            ErrorObject errorObject = this.error;
            if (errorObject != null) {
                alertDialog.setMessage(errorObject.getMessage());
            } else {
                alertDialog.setMessage("An unknown error has occured.");
            }
        }
    }
}
