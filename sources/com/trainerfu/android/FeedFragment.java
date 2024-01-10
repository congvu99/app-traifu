package com.trainerfu.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.internal.NativeProtocol;
import com.trainerfu.android.R;
import com.trainerfu.story.StoryListActivity;
import com.trainerfu.story.StoryListViewType;
import com.trainerfu.story.StoryType;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Tuple;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedFragment extends Fragment implements View.OnClickListener {
    /* access modifiers changed from: private */
    public static Drawable logoDrawable;
    /* access modifiers changed from: private */
    public static Drawable profilePlaceholderDrawable;
    /* access modifiers changed from: private */
    public boolean didLoadOnce = false;
    private LinearLayout emptyStateView;
    private boolean isViewedByTrainer = false;
    private ListView listView;
    /* access modifiers changed from: private */
    public int newNotificationsCount;
    /* access modifiers changed from: private */
    public List<JSONObject> notifications;
    /* access modifiers changed from: private */
    public StableArrayAdapter stableArrayAdapter;
    /* access modifiers changed from: private */
    public View view;

    static {
        Context appContext = MyApplication.getAppContext();
        Drawable drawable = appContext.getResources().getDrawable(R.drawable.profile);
        profilePlaceholderDrawable = drawable;
        drawable.setColorFilter(ContextCompat.getColor(appContext, R.color.grayColor), PorterDuff.Mode.SRC_IN);
        logoDrawable = appContext.getResources().getDrawable(R.mipmap.ic_launcher);
    }

    /* access modifiers changed from: private */
    public Intent getChatIntent(int i) {
        Intent intent = new Intent(getActivity(), RNHostActivity.class);
        intent.putExtra("entryRoute", RNEntryRoute.MESSAGING.getMask());
        Bundle bundle = new Bundle();
        bundle.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(i)}));
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        return intent;
    }

    /* access modifiers changed from: private */
    public Intent getClientSettingsIntent(int i) {
        Intent intent = new Intent(getActivity(), RNHostActivity.class);
        intent.putExtra("entryRoute", RNEntryRoute.USER_SETTINGS.getMask());
        Bundle bundle = new Bundle();
        bundle.putBoolean("for_my_settings", false);
        bundle.putInt("context_user_id", i);
        bundle.putInt("context_user_role", UserRole.CLIENT.getMask());
        bundle.putBoolean("show_menu_button", false);
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        return intent;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.notifications == null) {
            this.notifications = new ArrayList();
            this.newNotificationsCount = 0;
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("is_viewed_by_trainer")) {
            this.isViewedByTrainer = arguments.getBoolean("is_viewed_by_trainer");
        }
        View inflate = layoutInflater.inflate(R.layout.listview_header, (ViewGroup) null, false);
        View inflate2 = layoutInflater.inflate(R.layout.feed_view, viewGroup, false);
        this.view = inflate2;
        ListView listView2 = (ListView) inflate2.findViewById(R.id.feed_view_list);
        this.listView = listView2;
        listView2.addHeaderView(inflate, (Object) null, false);
        this.view.findViewById(R.id.likeBtn).setOnClickListener(this);
        this.view.findViewById(R.id.unlikeBtn).setOnClickListener(this);
        StableArrayAdapter stableArrayAdapter2 = new StableArrayAdapter(getActivity(), R.layout.feed_view, this.notifications);
        this.stableArrayAdapter = stableArrayAdapter2;
        this.listView.setAdapter(stableArrayAdapter2);
        this.emptyStateView = (LinearLayout) this.view.findViewById(R.id.empty_state);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent;
                try {
                    JSONObject jSONObject = (JSONObject) FeedFragment.this.notifications.get(i - 1);
                    if (jSONObject.has("read")) {
                        FeedFragment.this.markNotificationAsRead(jSONObject.getInt("id"));
                    }
                    Intent intent2 = null;
                    JSONObject jSONObject2 = !jSONObject.isNull("meta") ? jSONObject.getJSONObject("meta") : null;
                    NotificationType notificationType = NotificationType.getNotificationType(jSONObject.getInt("notification_type"));
                    if (notificationType == NotificationType.NEW_MESSAGE) {
                        intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("object_id_int"));
                    } else {
                        if (!(notificationType == NotificationType.STORY_COMMENT_ADDED || notificationType == NotificationType.STORY_LIKED)) {
                            if (notificationType != NotificationType.POST_STORY_ADDED) {
                                if (notificationType == NotificationType.NEW_LEAD) {
                                    intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("source_id"));
                                } else {
                                    if (notificationType != NotificationType.MFP_CONNECT_DISABLED) {
                                        if (notificationType != NotificationType.MFP_CONNECT_FAILED) {
                                            if (notificationType == NotificationType.CLIENT_IGNORED_INVITE) {
                                                ClientsFragment.sendInviteEmail(FeedFragment.this.getActivity(), jSONObject2.getInt("id"));
                                            } else if (notificationType == NotificationType.CLIENT_FIRST_LOGIN) {
                                                if (jSONObject2.getBoolean("waiting_for_workout_plan")) {
                                                    intent = new Intent(FeedFragment.this.getActivity(), ClientManagementActivity.class);
                                                    intent.putExtra("client_id", jSONObject2.getInt("id"));
                                                    intent.putExtra("client_first_name", jSONObject2.getString("first_name"));
                                                } else {
                                                    intent = new Intent(FeedFragment.this.getActivity(), RNHostActivity.class);
                                                    intent.putExtra("entryRoute", RNEntryRoute.MESSAGING.getMask());
                                                    Bundle bundle = new Bundle();
                                                    bundle.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(jSONObject2.getInt("id"))}));
                                                    intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                                                }
                                                intent2 = intent;
                                            } else if (notificationType == NotificationType.NEW_CLIENT_SIGNUP) {
                                                intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("source_id"));
                                            } else if (notificationType == NotificationType.TRAINERFU_ENGAGEMENT_MESSAGE) {
                                                intent2 = new Intent("android.intent.action.VIEW", Uri.parse(jSONObject2.getString("url")));
                                            } else if (notificationType == NotificationType.PLAN_TEMPLATE_COPIED) {
                                                FeedFragment.this.markNotificationAsRead(jSONObject.getInt("id"));
                                                intent2 = new Intent(FeedFragment.this.getActivity(), OrderedPlanListActivity.class);
                                                intent2.putExtra("ordered_plan_list_id", jSONObject.getInt("object_id_int"));
                                                intent2.putExtra("ordered_plan_list_name", jSONObject2.getString("name"));
                                            } else if (notificationType == NotificationType.CLIENT_CANCELLED_SUBSCRIPTION) {
                                                intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("source_id"));
                                            } else if (notificationType == NotificationType.DELETE_CLIENT_ACCOUNT_REQUEST) {
                                                intent2 = FeedFragment.this.getClientSettingsIntent(jSONObject.getInt("object_id_int"));
                                            } else if (notificationType == NotificationType.CLIENT_ACCOUNT_DEACTIVATED_IAP) {
                                                intent2 = FeedFragment.this.getClientSettingsIntent(jSONObject.getInt("object_id_int"));
                                            } else if (notificationType == NotificationType.CLIENT_ACCOUNT_ACCESS_EXTENDED_IAP) {
                                                intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("object_id_int"));
                                            } else if (notificationType == NotificationType.CLIENT_ACCOUNT_REACTIVATED_IAP) {
                                                intent2 = FeedFragment.this.getChatIntent(jSONObject.getInt("object_id_int"));
                                            } else if (notificationType == NotificationType.IAP_EXPIRED_CLIENT_ACCOUNT_NOT_DEACTIVATED) {
                                                intent2 = FeedFragment.this.getClientSettingsIntent(jSONObject.getInt("object_id_int"));
                                            }
                                        }
                                    }
                                    intent2 = new Intent(FeedFragment.this.getActivity(), RNHostActivity.class);
                                    intent2.putExtra("entryRoute", RNEntryRoute.ML_APP_PICKER.getMask());
                                }
                            }
                        }
                        intent2 = new Intent(FeedFragment.this.getActivity(), StoryListActivity.class);
                        intent2.putExtra("story_list_view_type", StoryListViewType.SINGLE_STORY_VIEW.getMask());
                        intent2.putExtra("story_id", jSONObject2.getInt("story_id"));
                        intent2.putExtra("focusCommentView", false);
                    }
                    if (intent2 != null) {
                        FeedFragment.this.startActivity(intent2);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e2) {
                    throw new RuntimeException(e2);
                } catch (JSONException e3) {
                    throw new RuntimeException(e3);
                } catch (JSONException e4) {
                    throw new RuntimeException(e4);
                } catch (JSONException e5) {
                    throw new RuntimeException(e5);
                } catch (JSONException e6) {
                    throw new RuntimeException(e6);
                } catch (JSONException e7) {
                    throw new RuntimeException(e7);
                } catch (JSONException e8) {
                    throw new RuntimeException(e8);
                } catch (JSONException e9) {
                    throw new RuntimeException(e9);
                } catch (JSONException e10) {
                    throw new RuntimeException(e10);
                } catch (Exception e11) {
                    throw new RuntimeException(e11);
                }
            }
        });
        return this.view;
    }

    /* access modifiers changed from: private */
    public void markNotificationAsRead(int i) {
        new BaseHttpClient(false, getActivity()).post(String.format("/users/myself/notifications/%d/read_status", new Object[]{Integer.valueOf(i)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("notifications")) {
            try {
                JSONArray jSONArray = new JSONArray(bundle.getString("notifications"));
                this.notifications.clear();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.notifications.add((JSONObject) jSONArray.get(i));
                }
                this.newNotificationsCount = bundle.getInt("new_count");
                this.didLoadOnce = bundle.getBoolean("did_load_once");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.notifications != null) {
            bundle.putInt("new_count", this.newNotificationsCount);
            bundle.putBoolean("did_load_once", this.didLoadOnce);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.notifications.size(); i++) {
                jSONArray.put(this.notifications.get(i));
            }
            bundle.putString("notifications", jSONArray.toString());
        }
    }

    public void onResume() {
        super.onResume();
        new BaseHttpClient(Boolean.valueOf(!this.didLoadOnce), getActivity()).get("/users/myself/notifications", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    FeedFragment.this.notifications.clear();
                    FeedFragment.this.notifications.addAll(FeedFragment.this.getMustUnderstandNotifications(jSONObject.getJSONArray("notifications")));
                    int unused = FeedFragment.this.newNotificationsCount = jSONObject.getInt("new_count");
                    FeedFragment.this.stableArrayAdapter.notifyDataSetChanged();
                    boolean unused2 = FeedFragment.this.didLoadOnce = true;
                    if (jSONObject.getBoolean("ask_feedback")) {
                        FeedFragment.this.view.findViewById(R.id.rateAppInnerWrapper).setVisibility(0);
                    }
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public List<JSONObject> getMustUnderstandNotifications(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
            NotificationType notificationType = NotificationType.getNotificationType(jSONObject.getInt("notification_type"));
            if (notificationType != null) {
                if (notificationType == NotificationType.WORKOUT_PLAN_UPDATED || notificationType == NotificationType.NEW_MESSAGE || notificationType == NotificationType.NEW_LEAD || notificationType == NotificationType.POST_STORY_ADDED || notificationType == NotificationType.MFP_CONNECT_DISABLED || notificationType == NotificationType.MFP_CONNECT_FAILED || notificationType == NotificationType.CLIENT_IGNORED_INVITE || notificationType == NotificationType.CLIENT_FIRST_LOGIN || notificationType == NotificationType.TEST_DRIVE_WEB_APP || notificationType == NotificationType.NEW_CLIENT_SIGNUP || notificationType == NotificationType.TRAINERFU_ENGAGEMENT_MESSAGE || notificationType == NotificationType.PLAN_TEMPLATE_COPIED || notificationType == NotificationType.CLIENT_CANCELLED_SUBSCRIPTION || notificationType == NotificationType.DELETE_CLIENT_ACCOUNT_REQUEST || notificationType == NotificationType.CLIENT_ACCOUNT_DEACTIVATED_IAP || notificationType == NotificationType.CLIENT_ACCOUNT_ACCESS_EXTENDED_IAP || notificationType == NotificationType.CLIENT_ACCOUNT_REACTIVATED_IAP || notificationType == NotificationType.IAP_EXPIRED_CLIENT_ACCOUNT_NOT_DEACTIVATED) {
                    arrayList.add(jSONObject);
                } else if ((notificationType == NotificationType.STORY_COMMENT_ADDED || notificationType == NotificationType.STORY_LIKED) && StoryType.getStoryType(jSONObject.getJSONObject("meta").getInt("story_type")) != StoryType.UNKNOWN) {
                    arrayList.add(jSONObject);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.emptyStateView.setVisibility(0);
            this.listView.setVisibility(8);
        } else {
            this.emptyStateView.setVisibility(8);
            this.listView.setVisibility(0);
        }
        return arrayList;
    }

    private class StableArrayAdapter extends ArrayAdapter<JSONObject> {
        private Context context;

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEnabled(int i) {
            return true;
        }

        public StableArrayAdapter(Context context2, int i, List<JSONObject> list) {
            super(context2, i, list);
            this.context = context2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00e9 A[Catch:{ JSONException -> 0x00fa }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
            /*
                r4 = this;
                java.lang.String r6 = "read"
                java.lang.String r7 = "user_photo_id"
                android.content.Context r0 = r4.context
                java.lang.String r1 = "layout_inflater"
                java.lang.Object r0 = r0.getSystemService(r1)
                android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
                r1 = 2131558516(0x7f0d0074, float:1.874235E38)
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                com.trainerfu.android.FeedFragment r1 = com.trainerfu.android.FeedFragment.this
                int r1 = r1.newNotificationsCount
                r2 = 2131099956(0x7f060134, float:1.781228E38)
                if (r5 >= r1) goto L_0x002e
                com.trainerfu.android.FeedFragment r1 = com.trainerfu.android.FeedFragment.this
                android.content.res.Resources r1 = r1.getResources()
                int r1 = r1.getColor(r2)
                r0.setBackgroundColor(r1)
            L_0x002e:
                com.trainerfu.android.FeedFragment r1 = com.trainerfu.android.FeedFragment.this     // Catch:{ JSONException -> 0x00fa }
                java.util.List r1 = r1.notifications     // Catch:{ JSONException -> 0x00fa }
                java.lang.Object r1 = r1.get(r5)     // Catch:{ JSONException -> 0x00fa }
                org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x00fa }
                boolean r3 = r1.has(r6)     // Catch:{ JSONException -> 0x00fa }
                if (r3 == 0) goto L_0x0054
                boolean r5 = r1.getBoolean(r6)     // Catch:{ JSONException -> 0x00fa }
                if (r5 != 0) goto L_0x0069
                com.trainerfu.android.FeedFragment r5 = com.trainerfu.android.FeedFragment.this     // Catch:{ JSONException -> 0x00fa }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ JSONException -> 0x00fa }
                int r5 = r5.getColor(r2)     // Catch:{ JSONException -> 0x00fa }
                r0.setBackgroundColor(r5)     // Catch:{ JSONException -> 0x00fa }
                goto L_0x0069
            L_0x0054:
                com.trainerfu.android.FeedFragment r6 = com.trainerfu.android.FeedFragment.this     // Catch:{ JSONException -> 0x00fa }
                int r6 = r6.newNotificationsCount     // Catch:{ JSONException -> 0x00fa }
                if (r5 >= r6) goto L_0x0069
                com.trainerfu.android.FeedFragment r5 = com.trainerfu.android.FeedFragment.this     // Catch:{ JSONException -> 0x00fa }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ JSONException -> 0x00fa }
                int r5 = r5.getColor(r2)     // Catch:{ JSONException -> 0x00fa }
                r0.setBackgroundColor(r5)     // Catch:{ JSONException -> 0x00fa }
            L_0x0069:
                java.lang.String r5 = "notification_type"
                int r5 = r1.getInt(r5)     // Catch:{ JSONException -> 0x00fa }
                com.trainerfu.android.NotificationType r5 = com.trainerfu.android.NotificationType.getNotificationType(r5)     // Catch:{ JSONException -> 0x00fa }
                r6 = 2131362983(0x7f0a04a7, float:1.8345762E38)
                android.view.View r6 = r0.findViewById(r6)     // Catch:{ JSONException -> 0x00fa }
                de.hdodenhof.circleimageview.CircleImageView r6 = (de.hdodenhof.circleimageview.CircleImageView) r6     // Catch:{ JSONException -> 0x00fa }
                com.trainerfu.android.NotificationType r2 = com.trainerfu.android.NotificationType.TEST_DRIVE_WEB_APP     // Catch:{ JSONException -> 0x00fa }
                if (r5 == r2) goto L_0x00c2
                com.trainerfu.android.NotificationType r2 = com.trainerfu.android.NotificationType.TRAINERFU_ENGAGEMENT_MESSAGE     // Catch:{ JSONException -> 0x00fa }
                if (r5 != r2) goto L_0x0085
                goto L_0x00c2
            L_0x0085:
                boolean r5 = r1.has(r7)     // Catch:{ JSONException -> 0x00fa }
                if (r5 == 0) goto L_0x00ac
                boolean r5 = r1.isNull(r7)     // Catch:{ JSONException -> 0x00fa }
                if (r5 != 0) goto L_0x00ac
                int r5 = r1.getInt(r7)     // Catch:{ JSONException -> 0x00fa }
                java.lang.String r5 = com.trainerfu.utils.Util.getUrlForPhoto(r5)     // Catch:{ JSONException -> 0x00fa }
                com.squareup.picasso.Picasso r7 = com.squareup.picasso.Picasso.get()     // Catch:{ JSONException -> 0x00fa }
                com.squareup.picasso.RequestCreator r5 = r7.load((java.lang.String) r5)     // Catch:{ JSONException -> 0x00fa }
                r7 = 2131231370(0x7f08028a, float:1.807882E38)
                com.squareup.picasso.RequestCreator r5 = r5.error((int) r7)     // Catch:{ JSONException -> 0x00fa }
                r5.into((android.widget.ImageView) r6)     // Catch:{ JSONException -> 0x00fa }
                goto L_0x00c9
            L_0x00ac:
                android.graphics.drawable.Drawable r5 = com.trainerfu.android.FeedFragment.profilePlaceholderDrawable     // Catch:{ JSONException -> 0x00fa }
                r6.setImageDrawable(r5)     // Catch:{ JSONException -> 0x00fa }
                android.content.Context r5 = r4.context     // Catch:{ JSONException -> 0x00fa }
                r7 = 2131099838(0x7f0600be, float:1.781204E38)
                int r5 = androidx.core.content.ContextCompat.getColor(r5, r7)     // Catch:{ JSONException -> 0x00fa }
                android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.SRC_IN     // Catch:{ JSONException -> 0x00fa }
                r6.setColorFilter(r5, r7)     // Catch:{ JSONException -> 0x00fa }
                goto L_0x00c9
            L_0x00c2:
                android.graphics.drawable.Drawable r5 = com.trainerfu.android.FeedFragment.logoDrawable     // Catch:{ JSONException -> 0x00fa }
                r6.setImageDrawable(r5)     // Catch:{ JSONException -> 0x00fa }
            L_0x00c9:
                com.trainerfu.android.FeedFragment r5 = com.trainerfu.android.FeedFragment.this     // Catch:{ JSONException -> 0x00fa }
                com.trainerfu.utils.Tuple r5 = r5.getTitleAndDetails(r1)     // Catch:{ JSONException -> 0x00fa }
                X r6 = r5.x     // Catch:{ JSONException -> 0x00fa }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ JSONException -> 0x00fa }
                Y r5 = r5.y     // Catch:{ JSONException -> 0x00fa }
                java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x00fa }
                r7 = 2131363299(0x7f0a05e3, float:1.8346403E38)
                android.view.View r7 = r0.findViewById(r7)     // Catch:{ JSONException -> 0x00fa }
                android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ JSONException -> 0x00fa }
                android.text.Spanned r6 = android.text.Html.fromHtml(r6)     // Catch:{ JSONException -> 0x00fa }
                r7.setText(r6)     // Catch:{ JSONException -> 0x00fa }
                if (r5 == 0) goto L_0x00f9
                r6 = 2131362253(0x7f0a01cd, float:1.8344281E38)
                android.view.View r6 = r0.findViewById(r6)     // Catch:{ JSONException -> 0x00fa }
                android.widget.TextView r6 = (android.widget.TextView) r6     // Catch:{ JSONException -> 0x00fa }
                r7 = 0
                r6.setVisibility(r7)     // Catch:{ JSONException -> 0x00fa }
                r6.setText(r5)     // Catch:{ JSONException -> 0x00fa }
            L_0x00f9:
                return r0
            L_0x00fa:
                r5 = move-exception
                java.lang.RuntimeException r6 = new java.lang.RuntimeException
                r6.<init>(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.FeedFragment.StableArrayAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }
    }

    /* access modifiers changed from: private */
    public Tuple<String, String> getTitleAndDetails(JSONObject jSONObject) throws JSONException {
        String str;
        String str2;
        String str3 = null;
        JSONObject jSONObject2 = !jSONObject.isNull("meta") ? jSONObject.getJSONObject("meta") : null;
        NotificationType notificationType = NotificationType.getNotificationType(jSONObject.getInt("notification_type"));
        String str4 = "";
        String string = (jSONObject2 == null || !jSONObject2.has("first_name")) ? str4 : jSONObject2.getString("first_name");
        if (notificationType == NotificationType.NEW_MESSAGE) {
            str4 = String.format(getString(R.string.newMessageNotification), new Object[]{string});
        } else if (notificationType == NotificationType.NEW_LEAD) {
            str4 = String.format(getString(R.string.newLeadNotification), new Object[]{String.format("%s %s", new Object[]{string, jSONObject2.getString("last_name")}), jSONObject2.getString("email")});
        } else if (notificationType == NotificationType.POST_STORY_ADDED) {
            if (jSONObject2.has("message") && !jSONObject2.isNull("messgae")) {
                str3 = jSONObject2.getString("message");
            }
            str4 = String.format(getString(R.string.addedANewPost), new Object[]{string});
        } else if (notificationType == NotificationType.WORKOUT_PLAN_UPDATED) {
            str4 = String.format(getString(R.string.yourWPUpdatedToday), new Object[]{string});
        } else if (notificationType == NotificationType.STORY_LIKED) {
            str4 = String.format(getString(Util.getId(String.format("storyLiked_%s", new Object[]{String.valueOf(StoryType.getStoryType(jSONObject2.getInt("story_type")).getMask())}), R.string.class)), new Object[]{string});
        } else if (notificationType == NotificationType.STORY_COMMENT_ADDED) {
            boolean z = jSONObject2.getBoolean("owned_by_self");
            StoryType storyType = StoryType.getStoryType(jSONObject2.getInt("story_type"));
            if (z) {
                str2 = String.format(getString(Util.getId(String.format("storyCommentAddedByOther_%s", new Object[]{String.valueOf(storyType.getMask())}), R.string.class)), new Object[]{string});
            } else {
                str2 = String.format(getString(Util.getId(String.format("storyCommentAddedByOwner_%s", new Object[]{String.valueOf(storyType.getMask())}), R.string.class)), new Object[]{string, string});
            }
            str4 = str2;
        } else if (notificationType == NotificationType.MFP_CONNECT_FAILED) {
            str4 = getString(R.string.MFPConnectFailed);
            str3 = getString(R.string.MFPConnectFailedDetails);
        } else if (notificationType == NotificationType.MFP_CONNECT_DISABLED) {
            str4 = getString(R.string.MFPConnectDisabled);
            str3 = getString(R.string.MFPConnectDisabledDetails);
        } else if (notificationType == NotificationType.CLIENT_IGNORED_INVITE) {
            str4 = String.format(getString(R.string.ignoredInviteNotifTitle), new Object[]{string});
            str3 = String.format(getString(R.string.ignoredInviteNotifDetails), new Object[]{string});
        } else if (notificationType == NotificationType.CLIENT_FIRST_LOGIN) {
            str4 = String.format(getString(R.string.clientFirstLoginNotifTitle), new Object[]{string});
            if (jSONObject2.getBoolean("waiting_for_workout_plan")) {
                str = String.format(getString(R.string.clientFirstLoginNotifDetailsWithoutPlan), new Object[]{string, string});
            } else {
                str = String.format(getString(R.string.clientFirstLoginNotifDetailsWithPlan), new Object[]{string});
            }
            str3 = str;
        } else if (notificationType == NotificationType.TEST_DRIVE_WEB_APP) {
            str4 = getString(R.string.TrainerFuWebAppTitle);
            str3 = getString(R.string.TrainerFuWebAppDetail);
        } else if (notificationType == NotificationType.NEW_CLIENT_SIGNUP) {
            str4 = getString(R.string.NewClientSignup);
            str3 = String.format(getString(jSONObject2.has("iap") && jSONObject2.getBoolean("iap") ? R.string.NewClientSignupDetailIAP : R.string.NewClientSignupDetail), new Object[]{jSONObject2.getString("first_name"), jSONObject2.getString("last_name"), jSONObject2.getString("title")});
        } else if (notificationType == NotificationType.TRAINERFU_ENGAGEMENT_MESSAGE) {
            str4 = jSONObject2.getString("title");
            str3 = jSONObject2.getString("detail");
        } else if (notificationType == NotificationType.PLAN_TEMPLATE_COPIED) {
            str4 = String.format("Completed copying of %s template.", new Object[]{jSONObject2.getString("name")});
        } else if (notificationType == NotificationType.CLIENT_CANCELLED_SUBSCRIPTION) {
            str4 = String.format(getString(R.string.clientCancelledSubscriptionTitle), new Object[]{jSONObject2.getString("first_name")});
            if (!jSONObject2.isNull("title")) {
                str3 = String.format(getString(R.string.clientCancelledSubscriptionDetail), new Object[]{jSONObject2.getString("title")});
            }
        } else if (notificationType == NotificationType.DELETE_CLIENT_ACCOUNT_REQUEST) {
            str4 = String.format(getString(R.string.deleteClientAccountRequestTitle), new Object[]{jSONObject2.getString("first_name")});
            str3 = getString(R.string.deleteClientAccountRequestDetail);
        } else if (notificationType == NotificationType.CLIENT_ACCOUNT_DEACTIVATED_IAP) {
            str4 = String.format(getString(R.string.clientAccountDeactivatedIAPTitle), new Object[]{jSONObject2.getString("first_name")});
            str3 = getString(R.string.clientAccountAccessExtendedIAPDetail);
        } else if (notificationType == NotificationType.CLIENT_ACCOUNT_ACCESS_EXTENDED_IAP) {
            str4 = String.format(getString(R.string.clientAccountAccessExtendedIAPTitle), new Object[]{jSONObject2.getString("first_name")});
            str3 = String.format(getString(R.string.clientAccountAccessExtendedIAPDetail), new Object[]{jSONObject2.getString("first_name")});
        } else if (notificationType == NotificationType.CLIENT_ACCOUNT_REACTIVATED_IAP) {
            str4 = String.format(getString(R.string.clientAccountReactivatedTitle), new Object[]{jSONObject2.getString("first_name")});
            str3 = String.format(getString(R.string.clientAccountReactivatedDetail), new Object[]{jSONObject2.getString("first_name")});
        } else if (notificationType == NotificationType.IAP_EXPIRED_CLIENT_ACCOUNT_NOT_DEACTIVATED) {
            str4 = String.format(getString(R.string.clientAccountKeptActiveIAPTitle), new Object[]{jSONObject2.getString("first_name")});
            str3 = String.format(getString(R.string.clientAccountKeptActiveIAPDetail), new Object[]{jSONObject2.getString("first_name")});
        }
        return new Tuple<>(str4, str3);
    }

    private boolean canShowDetailView(NotificationType notificationType) {
        return (notificationType == NotificationType.WORKOUT_PLAN_UPDATED || notificationType == NotificationType.TEST_DRIVE_WEB_APP) ? false : true;
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

    public void onClick(View view2) {
        if (view2.getId() == R.id.likeBtn) {
            new MaterialDialog.Builder(getActivity()).title((CharSequence) ":-)").titleColorRes(R.color.black25PercentColor).content((int) R.string.askForReview).positiveText((int) R.string.okSure).negativeText((int) R.string.notReally).positiveColorRes(R.color.tintColor).negativeColorRes(R.color.grayColor).contentColorRes(R.color.black25PercentColor).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    FeedFragment.this.saveFeedback(true, true);
                    String packageName = FeedFragment.this.getActivity().getPackageName();
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
                        intent.addFlags(1208483840);
                        FeedFragment.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        FeedFragment feedFragment = FeedFragment.this;
                        feedFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
                    }
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    FeedFragment.this.saveFeedback(true, false);
                }
            }).show();
        } else if (view2.getId() == R.id.unlikeBtn) {
            new MaterialDialog.Builder(getActivity()).title((CharSequence) ":-)").titleColorRes(R.color.black25PercentColor).content((int) R.string.askForFeedback).positiveText((int) R.string.okSure).negativeText((int) R.string.notReally).positiveColorRes(R.color.tintColor).negativeColorRes(R.color.grayColor).contentColorRes(R.color.black25PercentColor).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "support@trainerfu.com", (String) null));
                    intent.putExtra("android.intent.extra.SUBJECT", FeedFragment.this.getString(R.string.Feedback));
                    FeedFragment.this.startActivity(Intent.createChooser(intent, "Send email..."));
                }
            }).show();
            saveFeedback(false, false);
        }
    }
}
