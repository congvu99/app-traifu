package com.trainerfu.android;

import android.os.Build;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Push;
import java.util.Map;

public class SplashActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public static boolean app_launched_event_sent = false;
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() {
        public final void onActivityResult(Object obj) {
            SplashActivity.this.lambda$new$0$SplashActivity((Boolean) obj);
        }
    });

    public SplashActivity() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.splash_screen);
        getWindow().getDecorView().setSystemUiVisibility(16);
        getWindow().setStatusBarColor(getResources().getColor(R.color.tintColor));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.tintColor));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        new BaseHttpClient(false, this).get("/users/myself/basic_info", (Map<String, Object>) null, new BaseResponseHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:10:0x0025 A[Catch:{ JSONException -> 0x0077 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ JSONException -> 0x0077 }] */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x006b A[Catch:{ JSONException -> 0x0077 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean handleSuccess(int r4, org.apache.http.Header[] r5, org.json.JSONObject r6) {
                /*
                    r3 = this;
                    java.lang.String r4 = "is_client"
                    boolean r4 = r6.getBoolean(r4)     // Catch:{ JSONException -> 0x0077 }
                    java.lang.String r5 = "is_sample_client"
                    boolean r5 = r6.getBoolean(r5)     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r6 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    android.content.Context r6 = r6.getApplicationContext()     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.MyApplication r6 = (com.trainerfu.android.MyApplication) r6     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r6 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r0 = 0
                    r1 = 1
                    if (r4 == 0) goto L_0x001f
                    if (r5 == 0) goto L_0x001d
                    goto L_0x001f
                L_0x001d:
                    r2 = 0
                    goto L_0x0020
                L_0x001f:
                    r2 = 1
                L_0x0020:
                    com.trainerfu.utils.Util.storeIsTrainerProperty(r6, r2)     // Catch:{ JSONException -> 0x0077 }
                    if (r4 == 0) goto L_0x003b
                    android.content.Intent r4 = new android.content.Intent     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r6 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    java.lang.Class<com.trainerfu.android.MainClientActivity> r2 = com.trainerfu.android.MainClientActivity.class
                    r4.<init>(r6, r2)     // Catch:{ JSONException -> 0x0077 }
                    if (r5 == 0) goto L_0x0035
                    java.lang.String r5 = "isViewedByTrainer"
                    r4.putExtra(r5, r1)     // Catch:{ JSONException -> 0x0077 }
                L_0x0035:
                    com.trainerfu.android.SplashActivity r5 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r5.startActivity(r4)     // Catch:{ JSONException -> 0x0077 }
                    goto L_0x0049
                L_0x003b:
                    android.content.Intent r4 = new android.content.Intent     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r5 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    java.lang.Class<com.trainerfu.android.MainTrainerActivity> r6 = com.trainerfu.android.MainTrainerActivity.class
                    r4.<init>(r5, r6)     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r5 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r5.startActivity(r4)     // Catch:{ JSONException -> 0x0077 }
                L_0x0049:
                    com.trainerfu.android.SplashActivity r4 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r4.askNotificationPermission()     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.utils.ExerciseDataset r4 = com.trainerfu.utils.ExerciseDataset.getInstance()     // Catch:{ JSONException -> 0x0077 }
                    r5 = 0
                    r4.fetchAllExercises(r5)     // Catch:{ JSONException -> 0x0077 }
                    r4.fetchRecentExercises(r5)     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.utils.GAIDTask r4 = new com.trainerfu.utils.GAIDTask     // Catch:{ JSONException -> 0x0077 }
                    com.trainerfu.android.SplashActivity r5 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r4.<init>(r5)     // Catch:{ JSONException -> 0x0077 }
                    java.lang.Void[] r5 = new java.lang.Void[r0]     // Catch:{ JSONException -> 0x0077 }
                    r4.execute(r5)     // Catch:{ JSONException -> 0x0077 }
                    boolean r4 = com.trainerfu.android.SplashActivity.app_launched_event_sent     // Catch:{ JSONException -> 0x0077 }
                    if (r4 != 0) goto L_0x0071
                    com.trainerfu.utils.AppEventUtil.sendAppLaunchEvent()     // Catch:{ JSONException -> 0x0077 }
                    boolean unused = com.trainerfu.android.SplashActivity.app_launched_event_sent = r1     // Catch:{ JSONException -> 0x0077 }
                L_0x0071:
                    com.trainerfu.android.SplashActivity r4 = com.trainerfu.android.SplashActivity.this     // Catch:{ JSONException -> 0x0077 }
                    r4.finish()     // Catch:{ JSONException -> 0x0077 }
                    return r1
                L_0x0077:
                    r4 = move-exception
                    java.lang.RuntimeException r5 = new java.lang.RuntimeException
                    r5.<init>(r4)
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.SplashActivity.AnonymousClass1.handleSuccess(int, org.apache.http.Header[], org.json.JSONObject):boolean");
            }
        });
    }

    public /* synthetic */ void lambda$new$0$SplashActivity(Boolean bool) {
        if (bool.booleanValue()) {
            new Push(getApplicationContext()).checkAndRegister();
        }
    }

    /* access modifiers changed from: private */
    public void askNotificationPermission() {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            new Push(getApplicationContext()).checkAndRegister();
        } else {
            this.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        }
    }
}
