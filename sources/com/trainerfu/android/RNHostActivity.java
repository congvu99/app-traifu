package com.trainerfu.android;

import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.PermissionListener;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;
import org.greenrobot.eventbus.EventBus;

public class RNHostActivity extends BaseReactActivity {
    private PermissionListener listener;
    private ReactRootView mReactRootView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RNGestureHandlerEnabledRootView rNGestureHandlerEnabledRootView = new RNGestureHandlerEnabledRootView(this);
        this.mReactRootView = rNGestureHandlerEnabledRootView;
        rNGestureHandlerEnabledRootView.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        this.mReactRootView.startReactApplication(getReactInstanceManager(), "App", getIntent().getExtras());
        setContentView((View) this.mReactRootView);
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onBackPressed() {
        if (getReactInstanceManager() != null) {
            getReactInstanceManager().onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:23|24|(2:26|27)(3:28|(2:30|(1:32)(1:33))|34)|35|36|37|38|76) */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00fb */
    @org.greenrobot.eventbus.Subscribe
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRNEvent(com.trainerfu.android.RNEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "segmentIds"
            java.lang.String r1 = "event_name"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r8 = r8.data     // Catch:{ JSONException -> 0x01f1 }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "OnConnectWithFitBit"
            boolean r8 = r8.equals(r3)     // Catch:{ JSONException -> 0x01f1 }
            if (r8 == 0) goto L_0x0021
            com.trainerfu.android.RNHostActivity$1 r8 = new com.trainerfu.android.RNHostActivity$1     // Catch:{ JSONException -> 0x01f1 }
            r8.<init>()     // Catch:{ JSONException -> 0x01f1 }
            r7.runOnUiThread(r8)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x0021:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "OnClientsSelected"
            boolean r8 = r8.equals(r3)     // Catch:{ JSONException -> 0x01f1 }
            r3 = -1
            r4 = 0
            java.lang.String r5 = "data"
            if (r8 == 0) goto L_0x0062
            android.content.Intent r8 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            r8.<init>()     // Catch:{ JSONException -> 0x01f1 }
            org.json.JSONObject r0 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r1 = "ids"
            org.json.JSONArray r0 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x01f1 }
            int r1 = r0.length()     // Catch:{ JSONException -> 0x01f1 }
            int[] r1 = new int[r1]     // Catch:{ JSONException -> 0x01f1 }
        L_0x0046:
            int r2 = r0.length()     // Catch:{ JSONException -> 0x01f1 }
            if (r4 >= r2) goto L_0x0055
            int r2 = r0.getInt(r4)     // Catch:{ JSONException -> 0x01f1 }
            r1[r4] = r2     // Catch:{ JSONException -> 0x01f1 }
            int r4 = r4 + 1
            goto L_0x0046
        L_0x0055:
            java.lang.String r0 = "clientIds"
            r8.putExtra(r0, r1)     // Catch:{ JSONException -> 0x01f1 }
            r7.setResult(r3, r8)     // Catch:{ JSONException -> 0x01f1 }
            r7.finish()     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x0062:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r6 = "OnSegmentsSelected"
            boolean r8 = r8.equals(r6)     // Catch:{ JSONException -> 0x01f1 }
            if (r8 == 0) goto L_0x009b
            android.content.Intent r8 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            r8.<init>()     // Catch:{ JSONException -> 0x01f1 }
            org.json.JSONObject r1 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01f1 }
            org.json.JSONArray r1 = r1.getJSONArray(r0)     // Catch:{ JSONException -> 0x01f1 }
            int r2 = r1.length()     // Catch:{ JSONException -> 0x01f1 }
            int[] r2 = new int[r2]     // Catch:{ JSONException -> 0x01f1 }
        L_0x0081:
            int r5 = r1.length()     // Catch:{ JSONException -> 0x01f1 }
            if (r4 >= r5) goto L_0x0090
            int r5 = r1.getInt(r4)     // Catch:{ JSONException -> 0x01f1 }
            r2[r4] = r5     // Catch:{ JSONException -> 0x01f1 }
            int r4 = r4 + 1
            goto L_0x0081
        L_0x0090:
            r8.putExtra(r0, r2)     // Catch:{ JSONException -> 0x01f1 }
            r7.setResult(r3, r8)     // Catch:{ JSONException -> 0x01f1 }
            r7.finish()     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x009b:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r0 = "OnPlayVideo"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x01f1 }
            r0 = 1
            if (r8 == 0) goto L_0x0140
            org.json.JSONObject r8 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r1 = "uri"
            java.lang.String r8 = r8.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            android.content.Intent r1 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r8)     // Catch:{ JSONException -> 0x01f1 }
            r1.<init>(r2, r3)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r2 = "\\."
            java.lang.String[] r2 = r8.split(r2)     // Catch:{ JSONException -> 0x01f1 }
            int r3 = r2.length     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r4 = "video/*"
            if (r3 > r0) goto L_0x00d0
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ JSONException -> 0x01f1 }
            r1.setDataAndType(r8, r4)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x00f6
        L_0x00d0:
            int r3 = r2.length     // Catch:{ JSONException -> 0x01f1 }
            int r3 = r3 - r0
            r0 = r2[r3]     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r2 = "mov"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x01f1 }
            if (r2 != 0) goto L_0x00ed
            java.lang.String r2 = "qt"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x01f1 }
            if (r0 == 0) goto L_0x00e5
            goto L_0x00ed
        L_0x00e5:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ JSONException -> 0x01f1 }
            r1.setDataAndType(r8, r4)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x00f6
        L_0x00ed:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r0 = "video/mov"
            r1.setDataAndType(r8, r0)     // Catch:{ JSONException -> 0x01f1 }
        L_0x00f6:
            r7.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x00fb }
            goto L_0x01f0
        L_0x00fb:
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = new com.afollestad.materialdialogs.MaterialDialog$Builder     // Catch:{ JSONException -> 0x01f1 }
            r8.<init>(r7)     // Catch:{ JSONException -> 0x01f1 }
            r0 = 2131951697(0x7f130051, float:1.9539816E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.title((int) r0)     // Catch:{ JSONException -> 0x01f1 }
            r0 = 2131099695(0x7f06002f, float:1.781175E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.titleColorRes(r0)     // Catch:{ JSONException -> 0x01f1 }
            r1 = 2131951698(0x7f130052, float:1.9539818E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.content((int) r1)     // Catch:{ JSONException -> 0x01f1 }
            r1 = 2131951648(0x7f130020, float:1.9539716E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.positiveText((int) r1)     // Catch:{ JSONException -> 0x01f1 }
            r1 = 2131951700(0x7f130054, float:1.9539822E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.negativeText((int) r1)     // Catch:{ JSONException -> 0x01f1 }
            r1 = 2131100514(0x7f060362, float:1.7813412E38)
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.positiveColorRes(r1)     // Catch:{ JSONException -> 0x01f1 }
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.negativeColorRes(r1)     // Catch:{ JSONException -> 0x01f1 }
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.contentColorRes(r0)     // Catch:{ JSONException -> 0x01f1 }
            com.trainerfu.android.RNHostActivity$2 r0 = new com.trainerfu.android.RNHostActivity$2     // Catch:{ JSONException -> 0x01f1 }
            r0.<init>()     // Catch:{ JSONException -> 0x01f1 }
            com.afollestad.materialdialogs.MaterialDialog$Builder r8 = r8.onPositive(r0)     // Catch:{ JSONException -> 0x01f1 }
            r8.show()     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x0140:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "OnUpdatePassword"
            boolean r8 = r8.equals(r3)     // Catch:{ JSONException -> 0x01f1 }
            if (r8 == 0) goto L_0x015c
            android.content.Intent r8 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            android.content.Context r0 = r7.getApplicationContext()     // Catch:{ JSONException -> 0x01f1 }
            java.lang.Class<com.trainerfu.android.ChangePassword> r1 = com.trainerfu.android.ChangePassword.class
            r8.<init>(r0, r1)     // Catch:{ JSONException -> 0x01f1 }
            r7.startActivity(r8)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x015c:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "OnSendTrainerInvite"
            boolean r8 = r8.equals(r3)     // Catch:{ JSONException -> 0x01f1 }
            if (r8 == 0) goto L_0x0177
            org.json.JSONObject r8 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r0 = "userId"
            int r8 = r8.getInt(r0)     // Catch:{ JSONException -> 0x01f1 }
            com.trainerfu.android.ClientsFragment.sendInviteEmail(r7, r8)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x0177:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "OnGroupNewsFeed"
            boolean r8 = r8.equals(r3)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r3 = "segmentIdFilter"
            java.lang.String r4 = "groupId"
            if (r8 == 0) goto L_0x01b8
            android.content.Intent r8 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ JSONException -> 0x01f1 }
            java.lang.Class<com.trainerfu.android.MainTrainerActivity> r6 = com.trainerfu.android.MainTrainerActivity.class
            r8.<init>(r1, r6)     // Catch:{ JSONException -> 0x01f1 }
            org.json.JSONObject r1 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01b1 }
            int r1 = r1.getInt(r4)     // Catch:{ JSONException -> 0x01b1 }
            java.lang.String r2 = "story_list_view_type"
            com.trainerfu.story.StoryListViewType r4 = com.trainerfu.story.StoryListViewType.NEWS_VIEW     // Catch:{ JSONException -> 0x01b1 }
            int r4 = r4.getMask()     // Catch:{ JSONException -> 0x01b1 }
            r8.putExtra(r2, r4)     // Catch:{ JSONException -> 0x01b1 }
            r8.putExtra(r3, r1)     // Catch:{ JSONException -> 0x01b1 }
            java.lang.String r1 = "selectedTabIndex"
            r8.putExtra(r1, r0)     // Catch:{ JSONException -> 0x01f1 }
            r7.startActivity(r8)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x01b1:
            r8 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ JSONException -> 0x01f1 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x01f1 }
            throw r0     // Catch:{ JSONException -> 0x01f1 }
        L_0x01b8:
            java.lang.String r8 = r2.getString(r1)     // Catch:{ JSONException -> 0x01f1 }
            java.lang.String r0 = "OnGroupAssignWorkout"
            boolean r8 = r8.equals(r0)     // Catch:{ JSONException -> 0x01f1 }
            if (r8 == 0) goto L_0x01f0
            android.content.Intent r8 = new android.content.Intent     // Catch:{ JSONException -> 0x01f1 }
            android.content.Context r0 = r7.getApplicationContext()     // Catch:{ JSONException -> 0x01f1 }
            java.lang.Class<com.trainerfu.android.CopyFromPlanTemplateActivity> r1 = com.trainerfu.android.CopyFromPlanTemplateActivity.class
            r8.<init>(r0, r1)     // Catch:{ JSONException -> 0x01f1 }
            org.json.JSONObject r0 = r2.getJSONObject(r5)     // Catch:{ JSONException -> 0x01e9 }
            int r0 = r0.getInt(r4)     // Catch:{ JSONException -> 0x01e9 }
            java.lang.String r1 = "task_type"
            com.trainerfu.android.CopyPlanTemplateTaskType r2 = com.trainerfu.android.CopyPlanTemplateTaskType.FOR_COPYING_A_PLAN_TEMPLATE_TO_GROUP     // Catch:{ JSONException -> 0x01e9 }
            int r2 = r2.getMask()     // Catch:{ JSONException -> 0x01e9 }
            r8.putExtra(r1, r2)     // Catch:{ JSONException -> 0x01e9 }
            r8.putExtra(r3, r0)     // Catch:{ JSONException -> 0x01e9 }
            r7.startActivity(r8)     // Catch:{ JSONException -> 0x01f1 }
            goto L_0x01f0
        L_0x01e9:
            r8 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ JSONException -> 0x01f1 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x01f1 }
            throw r0     // Catch:{ JSONException -> 0x01f1 }
        L_0x01f0:
            return
        L_0x01f1:
            r8 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.RNHostActivity.onRNEvent(com.trainerfu.android.RNEvent):void");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionListener permissionListener = this.listener;
        if (permissionListener != null) {
            permissionListener.onRequestPermissionsResult(i, strArr, iArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
