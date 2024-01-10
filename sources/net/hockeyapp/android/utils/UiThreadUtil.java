package net.hockeyapp.android.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import java.lang.ref.WeakReference;

public class UiThreadUtil {
    private UiThreadUtil() {
    }

    private static class WbUtilHolder {
        public static final UiThreadUtil INSTANCE = new UiThreadUtil();

        private WbUtilHolder() {
        }
    }

    public static UiThreadUtil getInstance() {
        return WbUtilHolder.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = (android.app.Activity) r2.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dismissLoadingDialogAndDisplayError(java.lang.ref.WeakReference<android.app.Activity> r2, final android.app.ProgressDialog r3, final int r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0012
            java.lang.Object r2 = r2.get()
            android.app.Activity r2 = (android.app.Activity) r2
            if (r2 == 0) goto L_0x0012
            net.hockeyapp.android.utils.UiThreadUtil$1 r0 = new net.hockeyapp.android.utils.UiThreadUtil$1
            r0.<init>(r3, r2, r4)
            r2.runOnUiThread(r0)
        L_0x0012:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.UiThreadUtil.dismissLoadingDialogAndDisplayError(java.lang.ref.WeakReference, android.app.ProgressDialog, int):void");
    }

    public void dismissLoading(WeakReference<Activity> weakReference, final ProgressDialog progressDialog) {
        Activity activity;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    ProgressDialog progressDialog = progressDialog;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = (android.app.Activity) r2.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void displayToastMessage(java.lang.ref.WeakReference<android.app.Activity> r2, final java.lang.String r3, final int r4) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0012
            java.lang.Object r2 = r2.get()
            android.app.Activity r2 = (android.app.Activity) r2
            if (r2 == 0) goto L_0x0012
            net.hockeyapp.android.utils.UiThreadUtil$3 r0 = new net.hockeyapp.android.utils.UiThreadUtil$3
            r0.<init>(r2, r3, r4)
            r2.runOnUiThread(r0)
        L_0x0012:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.UiThreadUtil.displayToastMessage(java.lang.ref.WeakReference, java.lang.String, int):void");
    }
}
