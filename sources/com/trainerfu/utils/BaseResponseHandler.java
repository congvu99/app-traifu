package com.trainerfu.utils;

import android.app.Activity;
import android.widget.ProgressBar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.trainerfu.android.MyApplication;
import com.trainerfu.android.R;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseResponseHandler extends JsonHttpResponseHandler {
    private ProgressBar progressBar;
    private Activity spinnerContext;
    private ProgressDialogFragment spinnerDialogFragment;

    public static int getErrorMessage(int i) {
        if (i == 1) {
            return R.string.errorcode_message_1;
        }
        if (i == 2) {
            return R.string.errorcode_message_2;
        }
        if (i == 3) {
            return R.string.errorcode_message_3;
        }
        if (i == 24) {
            return R.string.overwriteAssessment;
        }
        switch (i) {
            case 6:
                return R.string.errorcode_message_6;
            case 7:
                return R.string.errorcode_message_7;
            case 8:
                return R.string.errorcode_message_8;
            case 9:
                return R.string.errorcode_message_9;
            case 10:
                return R.string.errorcode_message_10;
            case 11:
                return R.string.errorcode_message_11;
            case 12:
                return R.string.errorcode_message_12;
            case 13:
                return R.string.errorcode_message_13;
            case 14:
                return R.string.errorcode_message_14;
            case 15:
                return R.string.errorcode_message_15;
            case 16:
                return R.string.errorcode_message_16;
            case 17:
                return R.string.errorcode_message_17;
            case 18:
                return R.string.errorcode_message_18;
            case 19:
                return R.string.errorcode_message_19;
            case 20:
                return R.string.errorcode_message_20;
            case 21:
                return R.string.errorcode_message_21;
            default:
                return R.string.errorcode_message_3;
        }
    }

    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        return false;
    }

    public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
        return false;
    }

    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
        return false;
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void setSpinnerDialog(ProgressDialogFragment progressDialogFragment) {
        this.spinnerDialogFragment = progressDialogFragment;
    }

    public void setSpinnerContext(Activity activity) {
        this.spinnerContext = activity;
    }

    public void setProgressBarView(ProgressBar progressBar2) {
        this.progressBar = progressBar2;
    }

    public void dismissSpinner() {
        ProgressBar progressBar2;
        Activity activity = this.spinnerContext;
        if (!(activity == null || (progressBar2 = (ProgressBar) activity.getWindow().getDecorView().findViewById(R.id.progress)) == null)) {
            progressBar2.setVisibility(8);
        }
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 != null) {
            progressBar3.setVisibility(8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[Catch:{ Exception -> 0x00aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFailure(int r6, org.apache.http.Header[] r7, java.lang.Throwable r8, org.json.JSONObject r9) {
        /*
            r5 = this;
            java.lang.String r0 = "is_active"
            java.lang.String r1 = "error_code"
            r5.dismissSpinner()     // Catch:{ Exception -> 0x00aa }
            r2 = 0
            if (r9 != 0) goto L_0x000f
            if (r8 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r6 = 0
            goto L_0x0013
        L_0x000f:
            boolean r6 = r5.handleFailure(r6, r7, r8, r9)     // Catch:{ Exception -> 0x00aa }
        L_0x0013:
            android.content.Context r7 = com.trainerfu.android.MyApplication.getAppContext()     // Catch:{ Exception -> 0x00aa }
            com.trainerfu.android.MyApplication r7 = (com.trainerfu.android.MyApplication) r7     // Catch:{ Exception -> 0x00aa }
            android.app.Activity r8 = r7.getCurrentActivity()     // Catch:{ Exception -> 0x00aa }
            if (r6 != 0) goto L_0x00a9
            r6 = 3
            if (r9 == 0) goto L_0x009e
            boolean r3 = r9.has(r1)     // Catch:{ Exception -> 0x00aa }
            if (r3 == 0) goto L_0x009e
            int r1 = r9.getInt(r1)     // Catch:{ Exception -> 0x00aa }
            r3 = 8
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            if (r1 != r3) goto L_0x0045
            if (r8 == 0) goto L_0x0037
            r8.finish()     // Catch:{ Exception -> 0x00aa }
        L_0x0037:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x00aa }
            java.lang.Class<com.trainerfu.android.HelloActivity> r8 = com.trainerfu.android.HelloActivity.class
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00aa }
            r6.setFlags(r4)     // Catch:{ Exception -> 0x00aa }
            r7.startActivity(r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x0045:
            r3 = 7
            if (r1 != r3) goto L_0x005b
            if (r8 == 0) goto L_0x004d
            r8.finish()     // Catch:{ Exception -> 0x00aa }
        L_0x004d:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x00aa }
            java.lang.Class<com.trainerfu.android.ResetPassword> r8 = com.trainerfu.android.ResetPassword.class
            r6.<init>(r7, r8)     // Catch:{ Exception -> 0x00aa }
            r6.setFlags(r4)     // Catch:{ Exception -> 0x00aa }
            r7.startActivity(r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x005b:
            r8 = 2
            if (r1 != r8) goto L_0x0092
            java.lang.String r8 = "data"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Exception -> 0x00aa }
            boolean r9 = r8.has(r0)     // Catch:{ Exception -> 0x00aa }
            if (r9 == 0) goto L_0x0086
            boolean r6 = r8.getBoolean(r0)     // Catch:{ Exception -> 0x00aa }
            if (r6 != 0) goto L_0x00a9
            java.lang.String r6 = "is_inactive_due_to_expired_iap"
            boolean r6 = r8.getBoolean(r6)     // Catch:{ Exception -> 0x00aa }
            if (r6 == 0) goto L_0x007c
            com.trainerfu.utils.BrandedIAPUtil.handleExpiredIAPAccount(r7)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x007c:
            r6 = 0
            com.trainerfu.utils.BaseHttpClient.logout(r7, r6, r2)     // Catch:{ Exception -> 0x00aa }
            r6 = 2131951616(0x7f130000, float:1.9539652E38)
            com.trainerfu.utils.Util.showToast(r7, r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x0086:
            android.content.Context r7 = com.trainerfu.android.MyApplication.getAppContext()     // Catch:{ Exception -> 0x00aa }
            int r6 = getErrorMessage(r6)     // Catch:{ Exception -> 0x00aa }
            com.trainerfu.utils.Util.showToast(r7, r6)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x0092:
            android.content.Context r6 = com.trainerfu.android.MyApplication.getAppContext()     // Catch:{ Exception -> 0x00aa }
            int r7 = getErrorMessage(r1)     // Catch:{ Exception -> 0x00aa }
            com.trainerfu.utils.Util.showToast(r6, r7)     // Catch:{ Exception -> 0x00aa }
            goto L_0x00a9
        L_0x009e:
            android.content.Context r7 = com.trainerfu.android.MyApplication.getAppContext()     // Catch:{ Exception -> 0x00aa }
            int r6 = getErrorMessage(r6)     // Catch:{ Exception -> 0x00aa }
            com.trainerfu.utils.Util.showToast(r7, r6)     // Catch:{ Exception -> 0x00aa }
        L_0x00a9:
            return
        L_0x00aa:
            r6 = move-exception
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.utils.BaseResponseHandler.onFailure(int, org.apache.http.Header[], java.lang.Throwable, org.json.JSONObject):void");
    }

    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        dismissSpinner();
        Util.showToast(MyApplication.getAppContext(), getErrorMessage(3));
    }

    public void onSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
        dismissSpinner();
        handleSuccess(i, headerArr, jSONObject);
    }

    public void onSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
        dismissSpinner();
        handleSuccess(i, headerArr, jSONArray);
    }
}
