package net.hockeyapp.android;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.Date;
import net.hockeyapp.android.tasks.CheckUpdateTask;

public class UpdateManager {
    private static UpdateManagerListener lastListener;
    private static CheckUpdateTask updateTask;

    public static void register(Activity activity, String str) {
        register(activity, str, (UpdateManagerListener) null);
    }

    public static void register(Activity activity, String str, UpdateManagerListener updateManagerListener) {
        register(activity, Constants.BASE_URL, str, updateManagerListener);
    }

    public static void register(Activity activity, String str, String str2, UpdateManagerListener updateManagerListener) {
        lastListener = updateManagerListener;
        WeakReference weakReference = new WeakReference(activity);
        if ((!fragmentsSupported().booleanValue() || !dialogShown(weakReference)) && !checkExpiryDate(weakReference, updateManagerListener) && !installedFromMarket(weakReference)) {
            startUpdateTask(weakReference, str, str2, updateManagerListener);
        }
    }

    public static void unregister() {
        CheckUpdateTask checkUpdateTask = updateTask;
        if (checkUpdateTask != null) {
            checkUpdateTask.cancel(true);
            updateTask.detach();
            updateTask = null;
        }
        lastListener = null;
    }

    private static boolean checkExpiryDate(WeakReference<Activity> weakReference, UpdateManagerListener updateManagerListener) {
        boolean z;
        boolean z2 = false;
        if (updateManagerListener != null) {
            Date expiryDate = updateManagerListener.getExpiryDate();
            boolean z3 = expiryDate != null && new Date().compareTo(expiryDate) > 0;
            if (z3) {
                z = updateManagerListener.onBuildExpired();
                z2 = z3;
                if (z2 && z) {
                    startExpiryInfoIntent(weakReference);
                }
                return z2;
            }
            z2 = z3;
        }
        z = false;
        startExpiryInfoIntent(weakReference);
        return z2;
    }

    private static boolean installedFromMarket(WeakReference<Activity> weakReference) {
        Activity activity = (Activity) weakReference.get();
        if (activity == null) {
            return false;
        }
        try {
            String installerPackageName = activity.getPackageManager().getInstallerPackageName(activity.getPackageName());
            if (Build.VERSION.SDK_INT >= 9) {
                if (installerPackageName == null || installerPackageName.isEmpty()) {
                    return false;
                }
            } else if (installerPackageName == null || installerPackageName.length() <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void startExpiryInfoIntent(WeakReference<Activity> weakReference) {
        Activity activity;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
            activity.finish();
            Intent intent = new Intent(activity, ExpiryInfoActivity.class);
            intent.addFlags(335544320);
            activity.startActivity(intent);
        }
    }

    private static void startUpdateTask(WeakReference<Activity> weakReference, String str, String str2, UpdateManagerListener updateManagerListener) {
        CheckUpdateTask checkUpdateTask = updateTask;
        if (checkUpdateTask == null || checkUpdateTask.getStatus() == AsyncTask.Status.FINISHED) {
            CheckUpdateTask checkUpdateTask2 = new CheckUpdateTask(weakReference, str, str2, updateManagerListener);
            updateTask = checkUpdateTask2;
            checkUpdateTask2.execute(new String[0]);
            return;
        }
        updateTask.attach(weakReference);
    }

    private static boolean dialogShown(WeakReference<Activity> weakReference) {
        Activity activity;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null || activity.getFragmentManager().findFragmentByTag("hockey_update_dialog") == null) {
            return false;
        }
        return true;
    }

    public static Boolean fragmentsSupported() {
        boolean z;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                Class<Fragment> cls = Fragment.class;
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    public static Boolean runsOnTablet(WeakReference<Activity> weakReference) {
        Activity activity;
        boolean z = false;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null) {
            return false;
        }
        Configuration configuration = activity.getResources().getConfiguration();
        if ((configuration.screenLayout & 15) == 3 || (configuration.screenLayout & 15) == 4) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static UpdateManagerListener getLastListener() {
        return lastListener;
    }
}
