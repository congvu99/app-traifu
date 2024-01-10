package com.trainerfu.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MoreFragment extends Fragment {
    /* access modifiers changed from: private */
    public AppLinksListAdapter adapter;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> appLinks = null;
    /* access modifiers changed from: private */
    public ListView appLinksListView;
    /* access modifiers changed from: private */
    public String bookingPage = null;
    private CTAButton chatBtn;
    /* access modifiers changed from: private */
    public String clientFirstName;
    /* access modifiers changed from: private */
    public int clientId = 0;
    private CTAButton companySettingsBtn;
    /* access modifiers changed from: private */
    public CTAButton exercisesBtn;
    /* access modifiers changed from: private */
    public CTAButton groupsBtn;
    private CTAButton habitBtn;
    /* access modifiers changed from: private */
    public boolean isLoadedOnce = false;
    /* access modifiers changed from: private */
    public CTAButton launchAppBtn;
    private CTAButton learnBtn;
    private CTAButton logoutBtn;
    /* access modifiers changed from: private */
    public LinearLayout logoutView;
    private CTAButton mealLogBtn;
    private CTAButton mealLogFAQBtn;
    private CTAButton notesBtn;
    /* access modifiers changed from: private */
    public CTAButton planTemplatesBtn;
    /* access modifiers changed from: private */
    public CTAButton premiumBtn;
    /* access modifiers changed from: private */
    public CTAButton pricingBtn;
    private CTAButton scheduledMessagesBtnClient;
    /* access modifiers changed from: private */
    public CTAButton settingsBtn;
    private CTAButton trackBtn;
    /* access modifiers changed from: private */
    public CTAButton trainersBtn;
    /* access modifiers changed from: private */
    public CTAButton trainingPackageBtn;
    /* access modifiers changed from: private */
    public MoreFragmentViewType viewType = MoreFragmentViewType.CLIENT_VIEW;
    /* access modifiers changed from: private */
    public CTAButton workoutTemplatesBtn;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("view_type")) {
            MoreFragmentViewType moreFragmentType = MoreFragmentViewType.getMoreFragmentType(arguments.getInt("view_type"));
            this.viewType = moreFragmentType;
            if (moreFragmentType == MoreFragmentViewType.CLIENT_MANAGEMENT_VIEW) {
                this.clientId = arguments.getInt("client_id");
                this.clientFirstName = arguments.getString("context_user_first_name");
            }
        }
        View inflate = layoutInflater.inflate(R.layout.more_view, viewGroup, false);
        this.workoutTemplatesBtn = (CTAButton) inflate.findViewById(R.id.workoutTemplatesBtn);
        this.logoutBtn = (CTAButton) inflate.findViewById(R.id.logoutBtn);
        this.settingsBtn = (CTAButton) inflate.findViewById(R.id.settingsBtn);
        this.planTemplatesBtn = (CTAButton) inflate.findViewById(R.id.planTemplatesBtn);
        this.exercisesBtn = (CTAButton) inflate.findViewById(R.id.exercisesBtn);
        this.trainingPackageBtn = (CTAButton) inflate.findViewById(R.id.trainingPackageBtn);
        this.groupsBtn = (CTAButton) inflate.findViewById(R.id.groupsBtn);
        this.logoutBtn = (CTAButton) inflate.findViewById(R.id.logoutBtn);
        this.trainersBtn = (CTAButton) inflate.findViewById(R.id.trainersBtn);
        this.launchAppBtn = (CTAButton) inflate.findViewById(R.id.launchAppBtn);
        this.mealLogBtn = (CTAButton) inflate.findViewById(R.id.mealLogBtn);
        this.premiumBtn = (CTAButton) inflate.findViewById(R.id.premiumBtn);
        this.trackBtn = (CTAButton) inflate.findViewById(R.id.trackProgressBtn);
        this.chatBtn = (CTAButton) inflate.findViewById(R.id.chatBtn);
        this.mealLogFAQBtn = (CTAButton) inflate.findViewById(R.id.mealLogginFaqBtn);
        this.scheduledMessagesBtnClient = (CTAButton) inflate.findViewById(R.id.scheduledMessagesBtnClient);
        this.notesBtn = (CTAButton) inflate.findViewById(R.id.notesBtn);
        this.habitBtn = (CTAButton) inflate.findViewById(R.id.habitBtn);
        this.learnBtn = (CTAButton) inflate.findViewById(R.id.learnBtn);
        this.pricingBtn = (CTAButton) inflate.findViewById(R.id.pricingBtn);
        this.appLinksListView = (ListView) inflate.findViewById(R.id.app_links_list);
        AppLinksListAdapter appLinksListAdapter = new AppLinksListAdapter(getActivity());
        this.adapter = appLinksListAdapter;
        this.appLinksListView.setAdapter(appLinksListAdapter);
        this.adapter.notifyDataSetChanged();
        this.logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseHttpClient.logout(MoreFragment.this.getActivity().getApplicationContext(), MoreFragment.this.getActivity(), true);
            }
        });
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.logout_view);
        this.logoutView = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseHttpClient.logout(MoreFragment.this.getActivity().getApplicationContext(), MoreFragment.this.getActivity(), true);
            }
        });
        this.workoutTemplatesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), TemplateListActivity.class);
                intent.putExtra("for_selection", false);
                intent.putExtra("for_workout_templates", true);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.planTemplatesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), PlanTemplateListActivity.class);
                intent.putExtra("for_selection", false);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.exercisesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), ExerciseCollectionActivity.class);
                intent.putExtra("allow_add_exercise", true);
                intent.putExtra("for_selection", false);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.trainingPackageBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), DiscoveryActivity.class);
                intent.putExtra(FirebaseAnalytics.Param.CONTENT_TYPE, ContentType.TRAINING_PACKAGES.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        this.groupsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.GROUPS.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        this.trainersBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.TRAINERS.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        this.settingsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.USER_SETTINGS.getMask());
                Bundle bundle = new Bundle();
                if (MoreFragment.this.viewType == MoreFragmentViewType.CLIENT_MANAGEMENT_VIEW) {
                    bundle.putBoolean("for_my_settings", false);
                    bundle.putInt("context_user_id", MoreFragment.this.clientId);
                    bundle.putInt("context_user_role", UserRole.CLIENT.getMask());
                } else {
                    bundle.putBoolean("for_my_settings", true);
                    bundle.putInt("context_user_id", 0);
                    if (MoreFragment.this.viewType == MoreFragmentViewType.CLIENT_VIEW) {
                        bundle.putInt("context_user_role", UserRole.CLIENT.getMask());
                    } else {
                        bundle.putInt("context_user_role", UserRole.TRAINER.getMask());
                    }
                }
                bundle.putBoolean("show_menu_button", false);
                intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.learnBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MoreFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.trainerfu.com/resources.html")));
            }
        });
        this.pricingBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MoreFragment.this.startActivity(new Intent(MoreFragment.this.getActivity(), PricingActivity.class));
            }
        });
        ((CTAButton) inflate.findViewById(R.id.mealLogginFaqBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MoreFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://support.trainerfu.com/knowledgebase/articles/1145188-meal-logging-faq-for-trainers")));
            }
        });
        ((CTAButton) inflate.findViewById(R.id.notesBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.NOTES.getMask());
                Bundle bundle = new Bundle();
                bundle.putString("channel_id", String.format("3-%d", new Object[]{Integer.valueOf(MoreFragment.this.clientId)}));
                intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.habitBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), DiscoveryActivity.class);
                intent.putExtra(FirebaseAnalytics.Param.CONTENT_TYPE, ContentType.HABIT.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        ((CTAButton) inflate.findViewById(R.id.mealLogBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity().getApplicationContext(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.ML_APP_PICKER.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        this.premiumBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity().getApplicationContext(), InAppPurchaseActivity.class);
                intent.putExtra("transaction_type", BrandedIAPTransactionType.EXTENSION.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        ((CTAButton) inflate.findViewById(R.id.bookApptBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MoreFragment.this.bookingPage != null) {
                    MoreFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MoreFragment.this.bookingPage)));
                }
            }
        });
        ((CTAButton) inflate.findViewById(R.id.trackProgressBtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), AssessmentActivity.class);
                intent.putExtra("userId", MoreFragment.this.clientId);
                intent.putExtra("context_user_first_name", MoreFragment.this.clientFirstName);
                intent.putExtra("viewed_by_trainer", true);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.chatBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), RNHostActivity.class);
                intent.putExtra("entryRoute", RNEntryRoute.MESSAGING.getMask());
                Bundle bundle = new Bundle();
                bundle.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(MoreFragment.this.clientId)}));
                intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                MoreFragment.this.startActivity(intent);
            }
        });
        this.scheduledMessagesBtnClient.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MoreFragment.this.getActivity(), DiscoveryActivity.class);
                intent.putExtra(FirebaseAnalytics.Param.CONTENT_TYPE, ContentType.SCHEDULED_MESSAGES.getMask());
                MoreFragment.this.startActivity(intent);
            }
        });
        this.launchAppBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri parse = Uri.parse("https://www.trainerfu.com/white-label-fitness-app.html");
                Intent makeMainSelectorActivity = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
                makeMainSelectorActivity.setData(parse);
                MoreFragment.this.startActivity(makeMainSelectorActivity);
            }
        });
        return inflate;
    }

    public void onResume() {
        super.onResume();
        reload();
    }

    public void reload() {
        if (this.viewType == MoreFragmentViewType.TRAINER_VIEW) {
            loadTrainerView();
        } else if (this.viewType == MoreFragmentViewType.CLIENT_MANAGEMENT_VIEW) {
            loadClientManagementView();
        } else {
            loadClientView();
        }
    }

    private void loadTrainerView() {
        new BaseHttpClient(Boolean.valueOf(!this.isLoadedOnce), getActivity()).get("/users/myself/groups", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                boolean z;
                try {
                    if (!MoreFragment.this.isAdded()) {
                        return true;
                    }
                    boolean unused = MoreFragment.this.isLoadedOnce = true;
                    JSONArray jSONArray = jSONObject.getJSONArray("groups");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.getInt(i2) == Group.ADMIN.getMask()) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    View view = MoreFragment.this.getView();
                    MoreFragment.this.settingsBtn.setVisibility(0);
                    MoreFragment.this.workoutTemplatesBtn.setVisibility(0);
                    MoreFragment.this.planTemplatesBtn.setVisibility(0);
                    MoreFragment.this.exercisesBtn.setVisibility(0);
                    MoreFragment.this.trainingPackageBtn.setVisibility(0);
                    MoreFragment.this.groupsBtn.setVisibility(0);
                    view.findViewById(R.id.separator).setVisibility(0);
                    view.findViewById(R.id.separator2).setVisibility(0);
                    view.findViewById(R.id.topDivider).setVisibility(0);
                    view.findViewById(R.id.bottomDivider).setVisibility(0);
                    MoreFragment.this.launchAppBtn.setVisibility(0);
                    view.findViewById(R.id.separator3).setVisibility(0);
                    MoreFragment.this.logoutView.setVisibility(0);
                    MoreFragment.this.settingsBtn.setDetail((String) null);
                    MoreFragment.this.settingsBtn.setDrawable(MoreFragment.this.getResources().getDrawable(R.drawable.settings_icon_grey), false);
                    MoreFragment.this.settingsBtn.setLayoutParams(new LinearLayout.LayoutParams(-1, Util.sizeInPx(MoreFragment.this.getActivity(), 55)));
                    MoreFragment.this.settingsBtn.hideDivider();
                    if (z) {
                        MoreFragment.this.trainersBtn.setVisibility(0);
                        SubscriptionPlanType subscriptionPlanType = SubscriptionPlanType.getSubscriptionPlanType(jSONObject.getInt("plan"));
                        boolean z2 = jSONObject.getBoolean("is_app_premium_with_apple");
                        if (SubscriptionPlanType.isAppPremiumPlan(subscriptionPlanType) && !z2) {
                            MoreFragment.this.pricingBtn.setVisibility(0);
                        }
                        MoreFragment.this.trainersBtn.hideDivider();
                    }
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void loadClientManagementView() {
        this.trackBtn.setVisibility(0);
        this.chatBtn.setVisibility(0);
        this.settingsBtn.setVisibility(0);
        this.mealLogFAQBtn.setVisibility(0);
        this.scheduledMessagesBtnClient.setVisibility(0);
        this.notesBtn.setVisibility(0);
        this.habitBtn.setVisibility(0);
        this.settingsBtn.setDetail((String) null);
        this.settingsBtn.setLayoutParams(new LinearLayout.LayoutParams(-1, Util.sizeInPx(getActivity(), 50)));
        this.settingsBtn.hideDivider();
    }

    private void loadClientView() {
        View view = getView();
        view.findViewById(R.id.topDivider).setVisibility(0);
        this.settingsBtn.setVisibility(0);
        this.mealLogBtn.setVisibility(0);
        this.settingsBtn.setDrawable(getResources().getDrawable(R.drawable.settings_icon), false);
        view.findViewById(R.id.separator2).setVisibility(0);
        this.settingsBtn.hideDivider();
        this.logoutView.setVisibility(0);
        view.findViewById(R.id.bottomDivider).setVisibility(0);
        BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(!this.isLoadedOnce), getActivity());
        baseHttpClient.get("/users/myself/iap", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    if (!MoreFragment.this.isAdded()) {
                        return true;
                    }
                    boolean unused = MoreFragment.this.isLoadedOnce = true;
                    if (MoreFragment.this.getView() != null && jSONObject.getBoolean("has_active_iap")) {
                        Date dateFromISOFormat = DateUtils.getDateFromISOFormat(jSONObject.getString("subscription_expiration"));
                        MoreFragment.this.premiumBtn.setVisibility(0);
                        MoreFragment.this.premiumBtn.setDetail(String.format("Expiring on %s", new Object[]{DateUtils.getDisplayDate(MoreFragment.this.getActivity(), dateFromISOFormat)}));
                    }
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        baseHttpClient.get("/company_settings/app_links", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                MoreFragment.this.getView();
                try {
                    if (jSONObject.isNull("app_links")) {
                        return true;
                    }
                    ArrayList unused = MoreFragment.this.appLinks = new ArrayList();
                    MoreFragment.this.appLinksListView.setVisibility(0);
                    JSONArray jSONArray = jSONObject.getJSONArray("app_links");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        MoreFragment.this.appLinks.add((JSONObject) jSONArray.get(i2));
                    }
                    MoreFragment.this.adapter.notifyDataSetChanged();
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    private class AppLinksListAdapter extends BaseAdapter {
        private Context context;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public AppLinksListAdapter(Context context2) {
            this.context = context2;
        }

        public int getCount() {
            if (MoreFragment.this.appLinks == null) {
                return 0;
            }
            return MoreFragment.this.appLinks.size();
        }

        public Object getItem(int i) {
            return MoreFragment.this.appLinks.get(i);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.app_link_row_view, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(R.id.titleLabel);
            TextView textView2 = (TextView) view.findViewById(R.id.urlTV);
            IconTextView iconTextView = (IconTextView) view.findViewById(R.id.link_icon);
            view.findViewById(R.id.divider_view);
            JSONObject jSONObject = (JSONObject) getItem(i);
            try {
                String string = jSONObject.getString("iconName");
                textView.setText(jSONObject.getString("title"));
                textView2.setText(jSONObject.getString("url"));
                iconTextView.setText(String.format(MoreFragment.this.getString(R.string.icon_name), new Object[]{string}));
                view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        try {
                            Uri parse = Uri.parse(((JSONObject) MoreFragment.this.appLinks.get(i)).getString("url"));
                            String uri = parse.toString();
                            if (!URLUtil.isHttpUrl(uri)) {
                                if (!URLUtil.isHttpsUrl(uri)) {
                                    if (!uri.startsWith("http://") && !uri.startsWith("https://")) {
                                        MoreFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://" + uri)));
                                        return;
                                    }
                                    return;
                                }
                            }
                            MoreFragment.this.startActivity(new Intent("android.intent.action.VIEW", parse));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return view;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
