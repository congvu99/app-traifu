package com.trainerfu.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.legacy.app.FragmentCompat;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.squareup.picasso.Picasso;
import com.trainerfu.android.WorkoutPlanDayFragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ImagePickerUtil;
import com.trainerfu.utils.OnImagePickedHandler;
import com.trainerfu.utils.ReactInstanceManagerFactory;
import com.trainerfu.utils.Util;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment implements View.OnClickListener, FragmentCompat.OnRequestPermissionsResultCallback {
    private static int WORKOUT_TRACKING_REQUEST_CODE = 34923;
    /* access modifiers changed from: private */
    public AppCompatActivity act;
    private Runnable fetchNewNotificationCountRunnable = null;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private int nextPlannedDay = -1;
    /* access modifiers changed from: private */
    public Bitmap profilePicBitmap;
    private int programId;
    private ScrollView scrollView;
    /* access modifiers changed from: private */
    public JSONObject summary;
    /* access modifiers changed from: private */
    public CTAButton uploadProfilePhotoBtn;
    private String userFirstname;
    private int userId = -1;
    private View view;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.act = (AppCompatActivity) getActivity();
    }

    /* JADX WARNING: type inference failed for: r6v10, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v12, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v14, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v16, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            super.onCreateView(r4, r5, r6)
            r6 = 2131558532(0x7f0d0084, float:1.8742382E38)
            r0 = 0
            android.view.View r4 = r4.inflate(r6, r5, r0)
            r3.view = r4
            r5 = 2131363111(0x7f0a0527, float:1.8346022E38)
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ScrollView r4 = (android.widget.ScrollView) r4
            r3.scrollView = r4
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            com.trainerfu.utils.Util.getDeviceWidth(r4)
            android.view.View r4 = r3.view
            r5 = 2131363382(0x7f0a0636, float:1.8346571E38)
            android.view.View r4 = r4.findViewById(r5)
            com.trainerfu.android.CTAButton r4 = (com.trainerfu.android.CTAButton) r4
            r3.uploadProfilePhotoBtn = r4
            java.lang.String r4 = "1,2,3,4"
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            r5 = 0
        L_0x0035:
            int r6 = r4.length
            if (r5 >= r6) goto L_0x0099
            r6 = r4[r5]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r6 = r6.intValue()
            com.trainerfu.android.ClientHomeButtonType r6 = com.trainerfu.android.ClientHomeButtonType.get(r6)
            r1 = 0
            com.trainerfu.android.ClientHomeButtonType r2 = com.trainerfu.android.ClientHomeButtonType.NEXT_WORKOUT
            if (r6 != r2) goto L_0x0058
            android.view.View r6 = r3.view
            r1 = 2131362850(0x7f0a0422, float:1.8345492E38)
            android.view.View r6 = r6.findViewById(r1)
            r1 = r6
            com.trainerfu.android.CTAButton r1 = (com.trainerfu.android.CTAButton) r1
            goto L_0x008a
        L_0x0058:
            com.trainerfu.android.ClientHomeButtonType r2 = com.trainerfu.android.ClientHomeButtonType.CHAT
            if (r6 != r2) goto L_0x0069
            android.view.View r6 = r3.view
            r1 = 2131362058(0x7f0a010a, float:1.8343886E38)
            android.view.View r6 = r6.findViewById(r1)
            r1 = r6
            com.trainerfu.android.CTAButton r1 = (com.trainerfu.android.CTAButton) r1
            goto L_0x008a
        L_0x0069:
            com.trainerfu.android.ClientHomeButtonType r2 = com.trainerfu.android.ClientHomeButtonType.TRACK
            if (r6 != r2) goto L_0x007a
            android.view.View r6 = r3.view
            r1 = 2131363337(0x7f0a0609, float:1.834648E38)
            android.view.View r6 = r6.findViewById(r1)
            r1 = r6
            com.trainerfu.android.CTAButton r1 = (com.trainerfu.android.CTAButton) r1
            goto L_0x008a
        L_0x007a:
            com.trainerfu.android.ClientHomeButtonType r2 = com.trainerfu.android.ClientHomeButtonType.LOG_WORKOUT
            if (r6 != r2) goto L_0x008a
            android.view.View r6 = r3.view
            r1 = 2131362724(0x7f0a03a4, float:1.8345237E38)
            android.view.View r6 = r6.findViewById(r1)
            r1 = r6
            com.trainerfu.android.CTAButton r1 = (com.trainerfu.android.CTAButton) r1
        L_0x008a:
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            r1.setVisibility(r0)
            r1.setOnClickListener(r3)
            int r5 = r5 + 1
            goto L_0x0035
        L_0x0099:
            android.view.View r4 = r3.view
            r5 = 2131362499(0x7f0a02c3, float:1.834478E38)
            android.view.View r4 = r4.findViewById(r5)
            com.trainerfu.android.CTAButton r4 = (com.trainerfu.android.CTAButton) r4
            r4.setOnClickListener(r3)
            r4.hideDivider()
            android.view.View r4 = r3.view
            r5 = 2131362695(0x7f0a0387, float:1.8345178E38)
            android.view.View r4 = r4.findViewById(r5)
            r4.setOnClickListener(r3)
            android.view.View r4 = r3.view
            r5 = 2131363379(0x7f0a0633, float:1.8346565E38)
            android.view.View r4 = r4.findViewById(r5)
            r4.setOnClickListener(r3)
            androidx.appcompat.app.AppCompatActivity r4 = r3.act
            r5 = 2131362880(0x7f0a0440, float:1.8345553E38)
            android.view.View r4 = r4.findViewById(r5)
            r4.setOnClickListener(r3)
            r3.bind()
            r3.createFetchNotificationCountRunnable()
            android.view.View r4 = r3.view
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.HomeFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onResume() {
        super.onResume();
        BaseHttpClient baseHttpClient = new BaseHttpClient(false, getActivity());
        String iSOFormattedDate = DateUtils.getISOFormattedDate(new Date(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        hashMap.put("date", iSOFormattedDate);
        baseHttpClient.get("/users/myself/summary", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONObject unused = HomeFragment.this.summary = jSONObject;
                if (!HomeFragment.this.isAdded()) {
                    return true;
                }
                HomeFragment.this.bind();
                return true;
            }
        });
        this.handler.post(this.fetchNewNotificationCountRunnable);
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.fetchNewNotificationCountRunnable);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("summary")) {
            try {
                this.summary = new JSONObject(bundle.getString("summary"));
                bind();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JSONObject jSONObject = this.summary;
        if (jSONObject != null) {
            bundle.putString("summary", jSONObject.toString());
        }
    }

    /* access modifiers changed from: private */
    public void bind() {
        int i;
        JSONObject jSONObject = this.summary;
        if (jSONObject != null) {
            try {
                this.userId = jSONObject.getInt("user_id");
                this.userFirstname = this.summary.getString("first_name");
                CTAButton cTAButton = (CTAButton) this.view.findViewById(R.id.nextWorkoutBtn);
                CTAButton cTAButton2 = (CTAButton) this.view.findViewById(R.id.habitBtn);
                JSONObject jSONObject2 = this.summary.getJSONObject("next_workout_schedule");
                this.programId = jSONObject2.getInt("program_id");
                if (jSONObject2.isNull("next_due_workout_planned_day")) {
                    cTAButton.setDetail(getString(R.string.noWorkoutScheduled));
                    this.nextPlannedDay = -1;
                } else {
                    cTAButton.setTitle(getString(R.string.startNextWorkout));
                    int i2 = jSONObject2.getInt("due_in_days");
                    if (i2 == 0) {
                        cTAButton.setDetail(getString(R.string.dueToday));
                    } else if (i2 == 1) {
                        cTAButton.setDetail(getString(R.string.dueTomorrow));
                    } else {
                        cTAButton.setDetail(String.format(getString(R.string.dueInNDays), new Object[]{String.valueOf(i2)}));
                    }
                    this.nextPlannedDay = jSONObject2.getInt("next_due_workout_planned_day");
                }
                if (this.summary.getInt("pending_checkins") > 0) {
                    cTAButton2.showPendingCheckins(true, this.summary.getString("pending_checkins"));
                } else {
                    cTAButton2.showPendingCheckins(false, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                CircleImageView circleImageView = (CircleImageView) this.act.findViewById(R.id.photo_view);
                if (!this.summary.isNull("photo_id") || this.profilePicBitmap != null) {
                    this.uploadProfilePhotoBtn.setVisibility(8);
                    if (this.profilePicBitmap != null) {
                        circleImageView.setImageBitmap(this.profilePicBitmap);
                        circleImageView.setVisibility(0);
                    } else {
                        Picasso.get().load(Util.getUrlForPhoto(this.summary.getInt("photo_id"))).error((int) R.drawable.profile).into((ImageView) circleImageView);
                        this.uploadProfilePhotoBtn.setVisibility(8);
                        circleImageView.setVisibility(0);
                    }
                } else {
                    circleImageView.setVisibility(8);
                    this.uploadProfilePhotoBtn.setVisibility(0);
                    this.uploadProfilePhotoBtn.setClickable(true);
                    registerForContextMenu(this.uploadProfilePhotoBtn);
                    this.uploadProfilePhotoBtn.setOnClickListener(this);
                }
                circleImageView.setClickable(true);
                registerForContextMenu(circleImageView);
                circleImageView.setOnClickListener(this);
                if (this.summary.getBoolean("ask_feedback")) {
                    this.view.findViewById(R.id.rateAppInnerWrapper).setVisibility(0);
                }
                JSONObject jSONObject3 = this.summary.getJSONObject("stats");
                JSONArray jSONArray = jSONObject3.getJSONArray("num_per_week");
                int[] iArr = new int[5];
                for (int i3 = 0; i3 < 5; i3++) {
                    iArr[i3] = jSONArray.getInt(i3);
                }
                if (MyApplication.isRunningFastlaneTest) {
                    iArr = new int[]{3, 4, 5, 6, 4};
                }
                int i4 = jSONObject3.getInt("total");
                try {
                    i = jSONObject3.getInt("recent");
                } catch (JSONException e) {
                    e.printStackTrace();
                    i = 0;
                }
                ((StatsView) this.view.findViewById(R.id.statsView)).setStats(iArr, i4, i);
                if (this.summary.getBoolean("is_sample_client")) {
                    View findViewById = this.view.findViewById(R.id.goToTrainerBtn);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            new BaseHttpClient(true, HomeFragment.this.getActivity()).put("/access_tokens/my_trainer_token", (Map<String, Object>) null, new BaseResponseHandler() {
                                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                                    Intent intent = new Intent(HomeFragment.this.getActivity(), MainTrainerActivity.class);
                                    intent.putExtra("isViewedByTrainer", false);
                                    intent.addFlags(268468224);
                                    ReactInstanceManagerFactory.getInstance().clear();
                                    HomeFragment.this.startActivity(intent);
                                    HomeFragment.this.getActivity().finish();
                                    return true;
                                }
                            });
                        }
                    });
                }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void onClick(View view2) {
        if (view2.getId() == R.id.nextWorkoutBtn) {
            if (this.nextPlannedDay != -1) {
                Intent intent = new Intent(getActivity(), WorkoutPlanDayActivity.class);
                intent.putExtra("program_id", this.programId);
                intent.putExtra("dayOfWeek", this.nextPlannedDay);
                intent.putExtra("view_type", WorkoutPlanDayViewType.TRACKING.getMask());
                startActivityForResult(intent, WORKOUT_TRACKING_REQUEST_CODE);
            }
        } else if (view2.getId() == R.id.chatWithCoachBtn) {
            if (this.userId != -1) {
                Intent intent2 = new Intent(getActivity(), RNHostActivity.class);
                intent2.putExtra("entryRoute", RNEntryRoute.MESSAGING.getMask());
                Bundle bundle = new Bundle();
                bundle.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(this.userId)}));
                bundle.putBoolean("for_checkin", false);
                intent2.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                startActivity(intent2);
            }
        } else if (view2.getId() == R.id.trackProgressBtn) {
            if (this.userId != -1) {
                Intent intent3 = new Intent(getActivity(), AssessmentActivity.class);
                intent3.putExtra("userId", this.userId);
                intent3.putExtra("viewed_by_trainer", false);
                intent3.putExtra("context_user_first_name", this.userFirstname);
                startActivity(intent3);
            }
        } else if (view2.getId() == R.id.photo_view || view2.getId() == R.id.uploadProfilePhotoBtn) {
            getActivity().openContextMenu(view2);
        } else if (view2.getId() == R.id.notification_icon) {
            Intent intent4 = new Intent(getActivity(), FeedActivity.class);
            intent4.putExtra("is_viewed_by_trainer", false);
            startActivity(intent4);
        } else if (view2.getId() == R.id.logWorkoutBtn) {
            if (this.userId != -1) {
                Intent intent5 = new Intent(getActivity(), WorkoutLogActivity.class);
                intent5.putExtra("user_id", this.userId);
                startActivity(intent5);
            }
        } else if (view2.getId() == R.id.likeBtn) {
            new MaterialDialog.Builder(getActivity()).title((CharSequence) ":-)").titleColorRes(R.color.black25PercentColor).content((int) R.string.askForReview).positiveText((int) R.string.okSure).negativeText((int) R.string.notReally).positiveColorRes(R.color.tintColor).negativeColorRes(R.color.grayColor).contentColorRes(R.color.black25PercentColor).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    HomeFragment.this.saveFeedback(true, true);
                    String packageName = HomeFragment.this.getActivity().getPackageName();
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                        intent.addFlags(1208483840);
                        HomeFragment.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        HomeFragment homeFragment = HomeFragment.this;
                        homeFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
                    }
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    HomeFragment.this.saveFeedback(true, false);
                }
            }).show();
        } else if (view2.getId() == R.id.unlikeBtn) {
            new MaterialDialog.Builder(getActivity()).title((CharSequence) ":-)").titleColorRes(R.color.black25PercentColor).content((int) R.string.askForFeedback).positiveText((int) R.string.okSure).negativeText((int) R.string.notReally).positiveColorRes(R.color.tintColor).negativeColorRes(R.color.grayColor).contentColorRes(R.color.black25PercentColor).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "support@trainerfu.com", (String) null));
                    intent.putExtra("android.intent.extra.SUBJECT", HomeFragment.this.getString(R.string.Feedback));
                    HomeFragment.this.startActivity(Intent.createChooser(intent, "Send email..."));
                }
            }).show();
            saveFeedback(false, false);
        } else if (view2.getId() == R.id.habitBtn && this.userId != -1) {
            Intent intent6 = new Intent(getActivity(), RNHostActivity.class);
            intent6.putExtra("entryRoute", RNEntryRoute.HABITS.getMask());
            Bundle bundle2 = new Bundle();
            bundle2.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(this.userId)}));
            bundle2.putBoolean("for_checkin", true);
            intent6.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle2);
            startActivity(intent6);
        }
    }

    /* access modifiers changed from: private */
    public void saveFeedback(boolean z, boolean z2) {
        this.view.findViewById(R.id.rateAppInnerWrapper).setVisibility(8);
        HashMap hashMap = new HashMap();
        hashMap.put("likes_app", Boolean.valueOf(z));
        hashMap.put("did_rate_app", Boolean.valueOf(z2));
        new BaseHttpClient().put("/users/myself/feedbacks/new", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        ImagePickerUtil.showPickPhotoMenu(getActivity(), contextMenu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return ImagePickerUtil.onContextItemSelected(menuItem, (Context) getActivity(), (Fragment) this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (isAdded()) {
            ImagePickerUtil.onRequestPermissionsResult(i, strArr, iArr, (Fragment) this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (!isAdded() || i2 != -1) {
            return;
        }
        if (i != WORKOUT_TRACKING_REQUEST_CODE) {
            ImagePickerUtil.onActivityResult(getActivity(), i, i2, intent, true, new OnImagePickedHandler() {
                public void onImagePicked(final Bitmap bitmap, String str, File file) {
                    HomeFragment.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            CircleImageView circleImageView = (CircleImageView) HomeFragment.this.act.findViewById(R.id.photo_view);
                            Bitmap unused = HomeFragment.this.profilePicBitmap = bitmap;
                            circleImageView.setImageBitmap(bitmap);
                            Util.savePhoto(0, 1, HomeFragment.this.profilePicBitmap, (String) null, false, (Runnable) null);
                            HomeFragment.this.uploadProfilePhotoBtn.setVisibility(8);
                            circleImageView.setVisibility(0);
                        }
                    });
                }
            });
        } else if (intent.getStringExtra("action").equals("completed_tracking")) {
            ((WorkoutPlanDayFragment.TrackingEventListener) getActivity()).completedTracking();
        }
    }

    private void createFetchNotificationCountRunnable() {
        this.fetchNewNotificationCountRunnable = new Runnable() {
            public void run() {
                new BaseHttpClient().get("/users/myself/new_notifications_count", (Map<String, Object>) null, new BaseResponseHandler() {
                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        return true;
                    }

                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        if (!HomeFragment.this.isAdded()) {
                            return true;
                        }
                        TextView textView = (TextView) HomeFragment.this.act.findViewById(R.id.notification_badge);
                        try {
                            int i2 = jSONObject.getInt("count");
                            if (i2 > 0) {
                                textView.setText(String.format("%s", new Object[]{String.valueOf(i2)}));
                                textView.setVisibility(0);
                            } else {
                                textView.setVisibility(8);
                            }
                            return true;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                HomeFragment.this.handler.postDelayed(this, 180000);
            }
        };
    }
}
