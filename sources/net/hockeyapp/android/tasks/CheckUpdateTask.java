package net.hockeyapp.android.tasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.Strings;
import net.hockeyapp.android.Tracking;
import net.hockeyapp.android.UpdateActivity;
import net.hockeyapp.android.UpdateFragment;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.UpdateManagerListener;
import net.hockeyapp.android.utils.VersionCache;
import net.hockeyapp.android.utils.VersionHelper;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckUpdateTask extends AsyncTask<String, String, JSONArray> {
    private static final int MAX_NUMBER_OF_VERSIONS = 25;
    /* access modifiers changed from: private */
    public Activity activity;
    protected String appIdentifier;
    private UpdateManagerListener listener;
    private Boolean mandatory;
    protected String urlString;
    private long usageTime;

    /* access modifiers changed from: protected */
    public boolean getCachingEnabled() {
        return true;
    }

    public CheckUpdateTask(WeakReference<Activity> weakReference, String str) {
        this.urlString = null;
        this.appIdentifier = null;
        this.activity = null;
        this.mandatory = false;
        this.usageTime = 0;
        this.appIdentifier = null;
        this.urlString = str;
        if (weakReference != null) {
            this.activity = (Activity) weakReference.get();
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            this.usageTime = Tracking.getUsageTime(activity2);
            Constants.loadFromContext(this.activity);
        }
    }

    public CheckUpdateTask(WeakReference<Activity> weakReference, String str, String str2) {
        this.urlString = null;
        this.appIdentifier = null;
        this.activity = null;
        this.mandatory = false;
        this.usageTime = 0;
        this.appIdentifier = str2;
        this.urlString = str;
        if (weakReference != null) {
            this.activity = (Activity) weakReference.get();
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            this.usageTime = Tracking.getUsageTime(activity2);
            Constants.loadFromContext(this.activity);
        }
    }

    public CheckUpdateTask(WeakReference<Activity> weakReference, String str, String str2, UpdateManagerListener updateManagerListener) {
        this.urlString = null;
        this.appIdentifier = null;
        this.activity = null;
        this.mandatory = false;
        this.usageTime = 0;
        this.appIdentifier = str2;
        this.urlString = str;
        this.listener = updateManagerListener;
        if (weakReference != null) {
            this.activity = (Activity) weakReference.get();
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            this.usageTime = Tracking.getUsageTime(activity2);
            Constants.loadFromContext(this.activity);
        }
    }

    public void attach(WeakReference<Activity> weakReference) {
        if (weakReference != null) {
            this.activity = (Activity) weakReference.get();
        }
        Activity activity2 = this.activity;
        if (activity2 != null) {
            Constants.loadFromContext(activity2);
        }
    }

    public void detach() {
        this.activity = null;
    }

    /* access modifiers changed from: protected */
    public int getVersionCode() {
        return Integer.parseInt(Constants.APP_VERSION);
    }

    /* access modifiers changed from: protected */
    public JSONArray doInBackground(String... strArr) {
        try {
            int versionCode = getVersionCode();
            JSONArray jSONArray = new JSONArray(VersionCache.getVersionInfo(this.activity));
            if (getCachingEnabled() && findNewVersion(jSONArray, versionCode)) {
                return jSONArray;
            }
            URLConnection createConnection = createConnection(new URL(getURLString("json")));
            createConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(createConnection.getInputStream());
            String convertStreamToString = convertStreamToString(bufferedInputStream);
            bufferedInputStream.close();
            JSONArray jSONArray2 = new JSONArray(convertStreamToString);
            if (findNewVersion(jSONArray2, versionCode)) {
                return limitResponseSize(jSONArray2);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public URLConnection createConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.addRequestProperty("User-Agent", "HockeySDK/Android");
        if (Build.VERSION.SDK_INT <= 9) {
            openConnection.setRequestProperty("connection", "close");
        }
        return openConnection;
    }

    private boolean findNewVersion(JSONArray jSONArray, int i) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject.getInt(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION) <= i || VersionHelper.compareVersionStrings(jSONObject.getString("minimum_os_version"), Build.VERSION.RELEASE) > 0) {
                    i2++;
                } else if (!jSONObject.has("mandatory")) {
                    return true;
                } else {
                    this.mandatory = Boolean.valueOf(jSONObject.getBoolean("mandatory"));
                    return true;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private JSONArray limitResponseSize(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < Math.min(jSONArray.length(), 25); i++) {
            try {
                jSONArray2.put(jSONArray.get(i));
            } catch (JSONException unused) {
            }
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(JSONArray jSONArray) {
        if (jSONArray != null) {
            UpdateManagerListener updateManagerListener = this.listener;
            if (updateManagerListener != null) {
                updateManagerListener.onUpdateAvailable();
            }
            showDialog(jSONArray);
            return;
        }
        UpdateManagerListener updateManagerListener2 = this.listener;
        if (updateManagerListener2 != null) {
            updateManagerListener2.onNoUpdateAvailable();
        }
    }

    /* access modifiers changed from: private */
    public void cleanUp() {
        this.activity = null;
        this.urlString = null;
        this.appIdentifier = null;
    }

    /* access modifiers changed from: protected */
    public String getURLString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urlString);
        sb.append("api/2/apps/");
        String str2 = this.appIdentifier;
        if (str2 == null) {
            str2 = this.activity.getPackageName();
        }
        sb.append(str2);
        sb.append("?format=" + str);
        if (Settings.Secure.getString(this.activity.getContentResolver(), "android_id") != null) {
            sb.append("&udid=" + encodeParam(Settings.Secure.getString(this.activity.getContentResolver(), "android_id")));
        }
        sb.append("&os=Android");
        sb.append("&os_version=" + encodeParam(Constants.ANDROID_VERSION));
        sb.append("&device=" + encodeParam(Constants.PHONE_MODEL));
        sb.append("&oem=" + encodeParam(Constants.PHONE_MANUFACTURER));
        sb.append("&app_version=" + encodeParam(Constants.APP_VERSION));
        sb.append("&sdk=" + encodeParam(Constants.SDK_NAME));
        sb.append("&sdk_version=" + encodeParam(Constants.SDK_VERSION));
        sb.append("&lang=" + encodeParam(Locale.getDefault().getLanguage()));
        sb.append("&usage_time=" + this.usageTime);
        return sb.toString();
    }

    private String encodeParam(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private void showDialog(final JSONArray jSONArray) {
        if (getCachingEnabled()) {
            VersionCache.setVersionInfo(this.activity, jSONArray.toString());
        }
        Activity activity2 = this.activity;
        if (activity2 != null && !activity2.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.activity);
            builder.setTitle(Strings.get(this.listener, 9));
            if (!this.mandatory.booleanValue()) {
                builder.setMessage(Strings.get(this.listener, 10));
                builder.setNegativeButton(Strings.get(this.listener, 11), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CheckUpdateTask.this.cleanUp();
                    }
                });
                builder.setPositiveButton(Strings.get(this.listener, 12), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (CheckUpdateTask.this.getCachingEnabled()) {
                            VersionCache.setVersionInfo(CheckUpdateTask.this.activity, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        }
                        WeakReference weakReference = new WeakReference(CheckUpdateTask.this.activity);
                        if (!UpdateManager.fragmentsSupported().booleanValue() || !UpdateManager.runsOnTablet(weakReference).booleanValue()) {
                            CheckUpdateTask.this.startUpdateIntent(jSONArray, false);
                        } else {
                            CheckUpdateTask.this.showUpdateFragment(jSONArray);
                        }
                    }
                });
                builder.create().show();
                return;
            }
            Toast.makeText(this.activity, Strings.get(this.listener, 8), 1).show();
            startUpdateIntent(jSONArray, true);
        }
    }

    /* access modifiers changed from: private */
    public void startUpdateIntent(JSONArray jSONArray, Boolean bool) {
        UpdateManagerListener updateManagerListener = this.listener;
        Class updateActivityClass = updateManagerListener != null ? updateManagerListener.getUpdateActivityClass() : null;
        if (updateActivityClass == null) {
            updateActivityClass = UpdateActivity.class;
        }
        if (this.activity != null) {
            Intent intent = new Intent();
            intent.setClass(this.activity, updateActivityClass);
            intent.putExtra("json", jSONArray.toString());
            intent.putExtra("url", getURLString("apk"));
            this.activity.startActivity(intent);
            if (bool.booleanValue()) {
                this.activity.finish();
            }
        }
        cleanUp();
    }

    /* access modifiers changed from: private */
    public void showUpdateFragment(JSONArray jSONArray) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            FragmentTransaction beginTransaction = activity2.getFragmentManager().beginTransaction();
            beginTransaction.setTransition(4097);
            Fragment findFragmentByTag = this.activity.getFragmentManager().findFragmentByTag("hockey_update_dialog");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.addToBackStack((String) null);
            Class cls = UpdateFragment.class;
            UpdateManagerListener updateManagerListener = this.listener;
            if (updateManagerListener != null) {
                cls = updateManagerListener.getUpdateFragmentClass();
            }
            try {
                ((DialogFragment) cls.getMethod("newInstance", new Class[]{JSONArray.class, String.class}).invoke((Object) null, new Object[]{jSONArray, getURLString("apk")})).show(beginTransaction, "hockey_update_dialog");
            } catch (Exception e) {
                Log.d(Constants.TAG, "An exception happened while showing the update fragment:");
                e.printStackTrace();
                Log.d(Constants.TAG, "Showing update activity instead.");
                startUpdateIntent(jSONArray, false);
            }
        }
    }

    private static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                inputStream.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return sb.toString();
    }
}
