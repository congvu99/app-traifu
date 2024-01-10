package net.hockeyapp.android;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import net.hockeyapp.android.listeners.DownloadFileListener;
import net.hockeyapp.android.tasks.DownloadFileTask;
import net.hockeyapp.android.utils.VersionHelper;
import net.hockeyapp.android.views.UpdateView;
import org.json.JSONArray;
import org.json.JSONException;

public class UpdateFragment extends DialogFragment implements View.OnClickListener, UpdateInfoListener {
    private DownloadFileTask downloadTask;
    private String urlString;
    private VersionHelper versionHelper;
    private JSONArray versionInfo;

    public static UpdateFragment newInstance(JSONArray jSONArray, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putString("versionInfo", jSONArray.toString());
        UpdateFragment updateFragment = new UpdateFragment();
        updateFragment.setArguments(bundle);
        return updateFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.urlString = getArguments().getString("url");
            this.versionInfo = new JSONArray(getArguments().getString("versionInfo"));
            setStyle(1, 16973939);
        } catch (JSONException unused) {
            dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View layoutView = getLayoutView();
        this.versionHelper = new VersionHelper(this.versionInfo.toString(), this);
        ((TextView) layoutView.findViewById(4098)).setText(getAppName());
        ((TextView) layoutView.findViewById(4099)).setText("Version " + this.versionHelper.getVersionString() + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + this.versionHelper.getFileInfoString());
        ((Button) layoutView.findViewById(UpdateView.UPDATE_BUTTON_ID)).setOnClickListener(this);
        WebView webView = (WebView) layoutView.findViewById(UpdateView.WEB_VIEW_ID);
        webView.clearCache(true);
        webView.destroyDrawingCache();
        webView.loadDataWithBaseURL(Constants.BASE_URL, this.versionHelper.getReleaseNotes(false), "text/html", "utf-8", (String) null);
        return layoutView;
    }

    public void onClick(View view) {
        startDownloadTask(getActivity());
        dismiss();
    }

    /* access modifiers changed from: private */
    public void startDownloadTask(final Activity activity) {
        DownloadFileTask downloadFileTask = new DownloadFileTask(activity, this.urlString, new DownloadFileListener() {
            public void downloadSuccessful(DownloadFileTask downloadFileTask) {
            }

            public void downloadFailed(DownloadFileTask downloadFileTask, Boolean bool) {
                if (bool.booleanValue()) {
                    UpdateFragment.this.startDownloadTask(activity);
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
        this.downloadTask = downloadFileTask;
        downloadFileTask.execute(new String[0]);
    }

    public int getCurrentVersionCode() {
        try {
            return getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 128).versionCode;
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            return -1;
        }
    }

    public String getAppName() {
        Activity activity = getActivity();
        try {
            PackageManager packageManager = activity.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(activity.getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public View getLayoutView() {
        return new UpdateView(getActivity(), false, true);
    }
}
