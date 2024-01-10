package com.trainerfu.android;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.joanzapata.iconify.widget.IconTextView;
import com.joanzapata.utils.Strings;
import com.squareup.picasso.Picasso;
import com.trainerfu.story.StoryListActivity;
import com.trainerfu.story.StoryListViewType;
import com.trainerfu.story.StoryType;
import com.trainerfu.utils.AppEventUtil;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ClientSearchTask;
import com.trainerfu.utils.ClientTuple;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.ReactInstanceManagerFactory;
import com.trainerfu.utils.Util;
import com.trainerfu.utils.ZipUtil;
import de.hdodenhof.circleimageview.CircleImageView;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.IntercomError;
import io.intercom.android.sdk.IntercomSpace;
import io.intercom.android.sdk.IntercomStatusCallback;
import io.intercom.android.sdk.identity.Registration;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientsFragment extends Fragment implements ClientRowEventListener, ClientSearchTask.SearchResultHandler {
    /* access modifiers changed from: private */
    public static boolean didCheckOutSampleClient = false;
    private static String productPrice;
    private ClientListAdapter adapter;
    /* access modifiers changed from: private */
    public boolean askForUpgrade = false;
    /* access modifiers changed from: private */
    public Calendar cal = Calendar.getInstance();
    /* access modifiers changed from: private */
    public boolean canAddClients = false;
    private ListView clientListView;
    /* access modifiers changed from: private */
    public JSONArray clients = null;
    private ClientSearchTask currentSearchTask = null;
    private String currentSearchTerm = null;
    /* access modifiers changed from: private */
    public MaterialDialog emailDialog;
    private LinearLayout emptyStateView;
    private AppEventsLogger fbLogger;
    /* access modifiers changed from: private */
    public ArrayList<Integer> filteredIndexes = new ArrayList<>();
    private View footerView;
    /* access modifiers changed from: private */
    public Boolean hideOnBoardingTip = false;
    /* access modifiers changed from: private */
    public boolean isAppPremiumWithApple;
    private FirebaseAnalytics mFirebaseAnalytics;
    private Menu menu;
    /* access modifiers changed from: private */
    public int myUserId = -1;
    private int newClientId;
    private LinearLayout onboardingWrapper;
    private LinearLayout resourcesWrapper;
    /* access modifiers changed from: private */
    public ArrayList<Integer> searchIndexes = new ArrayList<>();
    private SearchView searchView;
    private int segmentIdFilter = -1;
    /* access modifiers changed from: private */
    public boolean showedPayIntent = false;
    /* access modifiers changed from: private */
    public int step;
    private TextView stepText;
    /* access modifiers changed from: private */
    public SubscriptionPlanType subscriptionPlanType;
    private IconTextView tipBtn;
    private TextView tipText;
    /* access modifiers changed from: private */
    public String trainerFirstName;
    /* access modifiers changed from: private */
    public int trainerIdFilter = 0;
    private View view;
    /* access modifiers changed from: private */
    public String welcomeString;
    /* access modifiers changed from: private */
    public TextView welcomeText;

    public interface EventListener {
        void addNewClientClicked();
    }

    public void onCreate(Bundle bundle) {
        setHasOptionsMenu(true);
        this.fbLogger = AppEventsLogger.newLogger(getActivity());
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(getActivity());
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.clients_view, viewGroup, false);
        this.view = inflate;
        this.clientListView = (ListView) inflate.findViewById(R.id.client_list);
        View inflate2 = layoutInflater.inflate(R.layout.clients_view_footer, (ViewGroup) null, false);
        this.footerView = inflate2;
        this.clientListView.addFooterView(inflate2, (Object) null, false);
        this.step = Util.getStep(getActivity().getApplicationContext()).intValue();
        View findViewById = this.clientListView.findViewById(R.id.addClientBtn);
        View findViewById2 = this.clientListView.findViewById(R.id.seeResourcesBtn);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClientsFragment.this.handleAddClient();
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intercom.client().present(IntercomSpace.HelpCenter);
            }
        });
        this.onboardingWrapper = (LinearLayout) this.clientListView.findViewById(R.id.onboarding_wrapper);
        this.resourcesWrapper = (LinearLayout) this.clientListView.findViewById(R.id.resourcesWrapper);
        this.tipBtn = (IconTextView) this.clientListView.findViewById(R.id.tipBtn);
        this.welcomeText = (TextView) this.clientListView.findViewById(R.id.welcome_text);
        this.tipText = (TextView) this.clientListView.findViewById(R.id.tip_text);
        this.stepText = (TextView) this.clientListView.findViewById(R.id.step_text);
        LinearLayout linearLayout = (LinearLayout) this.view.findViewById(R.id.empty_state);
        this.emptyStateView = linearLayout;
        linearLayout.findViewById(R.id.addClientBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ClientsFragment.this.handleAddClient();
            }
        });
        this.tipBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    JSONObject jSONObject = (JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.filteredIndexes.get(0)).intValue());
                    if (ClientsFragment.this.step == 1) {
                        ClientsFragment.this.planBtnClicked(jSONObject);
                    } else if (ClientsFragment.this.step == 2) {
                        int unused = ClientsFragment.this.step = 3;
                        Util.storeStep(ClientsFragment.this.getActivity(), ClientsFragment.this.step);
                        ClientsFragment.this.coBtnClicked(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        ClientListAdapter clientListAdapter = new ClientListAdapter(getActivity(), this);
        this.adapter = clientListAdapter;
        this.clientListView.setAdapter(clientListAdapter);
        if (this.clients == null) {
            this.footerView.setVisibility(8);
        }
        this.clientListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                Util.hideKeyboard(ClientsFragment.this.getActivity());
            }
        });
        successfulLogin();
        return this.view;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null) {
            try {
                if (bundle.containsKey("clients")) {
                    byte[] byteArray = bundle.getByteArray("clients");
                    this.clients = null;
                    if (byteArray != null) {
                        try {
                            this.clients = new JSONArray(ZipUtil.decompress(byteArray));
                        } catch (IOException unused) {
                        }
                    }
                    this.myUserId = bundle.getInt("my_user_id");
                    this.askForUpgrade = bundle.getBoolean("ask_for_upgrade");
                    this.trainerIdFilter = bundle.getInt("trainer_id_filter");
                    this.segmentIdFilter = bundle.getInt("segment_id_filter");
                    this.canAddClients = bundle.getBoolean("can_add_clients");
                    this.subscriptionPlanType = SubscriptionPlanType.getSubscriptionPlanType(bundle.getInt("subscription_plan"));
                    this.isAppPremiumWithApple = bundle.getBoolean("is_app_premium_with_apple");
                    bind();
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JSONArray jSONArray = this.clients;
        if (jSONArray != null) {
            byte[] bArr = null;
            try {
                bArr = ZipUtil.compress(jSONArray.toString());
            } catch (IOException unused) {
            }
            bundle.putByteArray("clients", bArr);
            bundle.putInt("my_user_id", this.myUserId);
            bundle.putBoolean("ask_for_upgrade", this.askForUpgrade);
            bundle.putInt("trainer_id_filter", this.trainerIdFilter);
            bundle.putInt("segment_id_filter", this.segmentIdFilter);
            bundle.putBoolean("can_add_clients", this.canAddClients);
            bundle.putInt("subscription_plan", this.subscriptionPlanType.getMask());
            bundle.putBoolean("is_app_premium_with_apple", this.isAppPremiumWithApple);
        }
    }

    public void onResume() {
        super.onResume();
        reload();
    }

    public void reload() {
        reload(this.clients == null);
    }

    public void reload(boolean z) {
        JSONArray jSONArray = this.clients;
        if (jSONArray != null && (jSONArray.length() == 0 || this.searchIndexes.size() == 0)) {
            this.clientListView.findViewById(R.id.addClientBtn).setVisibility(8);
            this.emptyStateView.setVisibility(0);
        }
        if (this.trainerFirstName == null) {
            new BaseHttpClient(false, getActivity()).get("/users/myself/basic_info", (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        boolean z = jSONObject.getBoolean("is_client");
                        String unused = ClientsFragment.this.trainerFirstName = jSONObject.getString("first_name");
                        if (!z) {
                            String unused2 = ClientsFragment.this.welcomeString = String.format("Welcome, %s! 👋", new Object[]{ClientsFragment.this.trainerFirstName});
                            if (!ClientsFragment.this.isAdded()) {
                                return true;
                            }
                            ClientsFragment.this.welcomeText.setText(ClientsFragment.this.welcomeString);
                        }
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        new BaseHttpClient(Boolean.valueOf(z), getActivity()).get("/clients/ver2", (Map<String, Object>) null, new BaseResponseHandler() {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0096 A[Catch:{ JSONException -> 0x00a2 }, RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0097 A[Catch:{ JSONException -> 0x00a2 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean handleSuccess(int r2, org.apache.http.Header[] r3, org.json.JSONObject r4) {
                /*
                    r1 = this;
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "users"
                    org.json.JSONArray r3 = r4.getJSONArray(r3)     // Catch:{ JSONException -> 0x00a2 }
                    org.json.JSONArray unused = r2.clients = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    org.json.JSONArray r2 = r2.clients     // Catch:{ JSONException -> 0x00a2 }
                    int r2 = r2.length()     // Catch:{ JSONException -> 0x00a2 }
                    r3 = 3
                    r0 = 1
                    if (r2 < r3) goto L_0x0022
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.Boolean unused = r2.hideOnBoardingTip = r3     // Catch:{ JSONException -> 0x00a2 }
                L_0x0022:
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    r2.toggleOnBoarding()     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "my_user_id"
                    int r3 = r4.getInt(r3)     // Catch:{ JSONException -> 0x00a2 }
                    int unused = r2.myUserId = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    int r2 = r2.trainerIdFilter     // Catch:{ JSONException -> 0x00a2 }
                    if (r2 != 0) goto L_0x0045
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r3 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    int r3 = r3.myUserId     // Catch:{ JSONException -> 0x00a2 }
                    int unused = r2.trainerIdFilter = r3     // Catch:{ JSONException -> 0x00a2 }
                L_0x0045:
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "ask_for_upgrade"
                    boolean r3 = r4.getBoolean(r3)     // Catch:{ JSONException -> 0x00a2 }
                    if (r3 != 0) goto L_0x005a
                    java.lang.String r3 = "ask_to_resume_subscription"
                    boolean r3 = r4.getBoolean(r3)     // Catch:{ JSONException -> 0x00a2 }
                    if (r3 == 0) goto L_0x0058
                    goto L_0x005a
                L_0x0058:
                    r3 = 0
                    goto L_0x005b
                L_0x005a:
                    r3 = 1
                L_0x005b:
                    boolean unused = r2.askForUpgrade = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "can_add_clients"
                    boolean r3 = r4.getBoolean(r3)     // Catch:{ JSONException -> 0x00a2 }
                    boolean unused = r2.canAddClients = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "showed_pay_intent"
                    boolean r3 = r4.getBoolean(r3)     // Catch:{ JSONException -> 0x00a2 }
                    boolean unused = r2.showedPayIntent = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "subscription_plan"
                    int r3 = r4.getInt(r3)     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.SubscriptionPlanType r3 = com.trainerfu.android.SubscriptionPlanType.getSubscriptionPlanType(r3)     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.SubscriptionPlanType unused = r2.subscriptionPlanType = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    java.lang.String r3 = "is_app_premium_with_apple"
                    boolean r3 = r4.getBoolean(r3)     // Catch:{ JSONException -> 0x00a2 }
                    boolean unused = r2.isAppPremiumWithApple = r3     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    boolean r2 = r2.isAdded()     // Catch:{ JSONException -> 0x00a2 }
                    if (r2 != 0) goto L_0x0097
                    return r0
                L_0x0097:
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    r2.bind()     // Catch:{ JSONException -> 0x00a2 }
                    com.trainerfu.android.ClientsFragment r2 = com.trainerfu.android.ClientsFragment.this     // Catch:{ JSONException -> 0x00a2 }
                    r2.sendEventsForPPC()     // Catch:{ JSONException -> 0x00a2 }
                    return r0
                L_0x00a2:
                    java.lang.RuntimeException r2 = new java.lang.RuntimeException
                    r2.<init>()
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.ClientsFragment.AnonymousClass7.handleSuccess(int, org.apache.http.Header[], org.json.JSONObject):boolean");
            }
        });
    }

    /* access modifiers changed from: private */
    public void bind() {
        if (isAdded() && this.clients != null) {
            rebuildFiltered();
            this.adapter.notifyDataSetChanged();
            this.footerView.setVisibility(0);
            if (this.newClientId > 0) {
                int i = 0;
                while (i < this.searchIndexes.size()) {
                    try {
                        JSONObject jSONObject = (JSONObject) this.clients.get(this.searchIndexes.get(i).intValue());
                        if (jSONObject != null && jSONObject.getInt("id") == this.newClientId) {
                            this.clientListView.setSelection(i);
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    ClientsFragment.this.emailDialog.show();
                                }
                            }, 100);
                        }
                        i++;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                this.newClientId = 0;
            }
        }
    }

    public void setFilter(int i, int i2) {
        this.trainerIdFilter = i;
        this.segmentIdFilter = i2;
        bind();
    }

    private void rebuildFiltered() {
        this.filteredIndexes.clear();
        int i = 0;
        while (i < this.clients.length()) {
            try {
                JSONObject jSONObject = this.clients.getJSONObject(i);
                if (this.trainerIdFilter == -1 && this.segmentIdFilter == -1) {
                    this.filteredIndexes.add(Integer.valueOf(i));
                } else if (this.trainerIdFilter > 0 && jSONObject.getInt("primary_trainer") == this.trainerIdFilter) {
                    this.filteredIndexes.add(Integer.valueOf(i));
                } else if (this.segmentIdFilter > 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray("segment_ids");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            break;
                        } else if (jSONArray.getInt(i2) == this.segmentIdFilter) {
                            this.filteredIndexes.add(Integer.valueOf(i));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        ArrayList<Integer> arrayList = this.filteredIndexes;
        this.searchIndexes = arrayList;
        if (arrayList.size() == 0) {
            this.emptyStateView.setVisibility(0);
            return;
        }
        this.clientListView.findViewById(R.id.addClientBtn).setVisibility(0);
        this.emptyStateView.setVisibility(8);
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        this.menu = menu2;
        menu2.findItem(R.id.add_client_item).setVisible(true);
        SearchView searchView2 = (SearchView) menu2.findItem(R.id.action_search).getActionView();
        this.searchView = searchView2;
        searchView2.setMaxWidth(Integer.MAX_VALUE);
        this.searchView.setSearchableInfo(((SearchManager) getActivity().getSystemService(FirebaseAnalytics.Event.SEARCH)).getSearchableInfo(getActivity().getComponentName()));
        this.searchView.setFocusable(false);
        this.searchView.setIconified(true);
        this.searchView.requestFocusFromTouch();
        SearchView searchView3 = this.searchView;
        searchView3.setImeOptions(searchView3.getImeOptions() | 268435456);
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return true;
            }

            public boolean onQueryTextChange(String str) {
                ClientsFragment.this.searchClient(str);
                return false;
            }
        });
        styleSearchView(this.searchView);
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    private void showQuotaWarningDialog() {
        new MaterialDialog.Builder(getActivity()).title((int) R.string.quotaUsedAlertTitle).content((CharSequence) getString(R.string.quotaUsedAlertDescription)).positiveText((int) R.string.Ok).positiveColor(ContextCompat.getColor(getActivity(), R.color.tintColor)).show();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add_client_item) {
            handleAddClient();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: private */
    public void handleAddClient() {
        if ((this.subscriptionPlanType == SubscriptionPlanType.APP_FREEMIUM && !this.canAddClients) || (SubscriptionPlanType.isAppPremiumPlan(this.subscriptionPlanType) && !this.isAppPremiumWithApple && !this.canAddClients)) {
            startActivity(new Intent(getActivity(), PricingActivity.class));
        } else if (!this.canAddClients) {
            showQuotaWarningDialog();
        } else {
            ((EventListener) getActivity()).addNewClientClicked();
        }
    }

    private void styleSearchView(SearchView searchView2) {
        try {
            int identifier = searchView2.getContext().getResources().getIdentifier("android:id/search_edit_frame", (String) null, (String) null);
            if (identifier > 0) {
                ((LinearLayout.LayoutParams) ((LinearLayout) searchView2.findViewById(identifier)).getLayoutParams()).leftMargin = 0;
            }
            int identifier2 = searchView2.getContext().getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null);
            if (identifier2 > 0) {
                EditText editText = (EditText) searchView2.findViewById(identifier2);
                editText.setHintTextColor(ContextCompat.getColor(getActivity(), R.color.lightPlaceholderColor));
                editText.setTextColor(ContextCompat.getColor(getActivity(), R.color.black));
                editText.setPadding(0, 0, 0, 0);
            }
            int identifier3 = searchView2.getContext().getResources().getIdentifier("android:id/search_plate", (String) null, (String) null);
            if (identifier3 > 0) {
                searchView2.findViewById(identifier3).setPadding(0, 0, 0, 0);
                searchView2.findViewById(identifier3).getBackground().mutate().setColorFilter(Color.rgb(0, 0, 0), PorterDuff.Mode.SRC_ATOP);
                searchView2.findViewById(identifier3).setBackgroundColor(getResources().getColor(R.color.white));
                ((ImageView) searchView2.findViewById(getResources().getIdentifier("android:id/search_mag_icon", (String) null, (String) null))).setImageDrawable(getResources().getDrawable(R.drawable.ic_search_black_24dp));
            }
            int identifier4 = getResources().getIdentifier("android:id/search_close_btn", (String) null, (String) null);
            if (identifier4 > 0) {
                ((ImageView) searchView2.findViewById(identifier4)).setImageResource(R.drawable.icon_cancel);
            }
            int identifier5 = getResources().getIdentifier("android:id/search_mag_icon", (String) null, (String) null);
            if (identifier5 > 0) {
                ImageView imageView = (ImageView) searchView2.findViewById(identifier5);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
                imageView.setVisibility(8);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_search_black_24dp));
            }
            View findViewById = searchView2.findViewById(getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null));
            Class<?> cls = Class.forName("android.widget.SearchView$SearchAutoComplete");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("  ");
            spannableStringBuilder.append(getString(R.string.searchClient));
            Drawable drawable = getResources().getDrawable(R.drawable.ic_search_black_24dp);
            ((Float) cls.getMethod("getTextSize", new Class[0]).invoke(findViewById, new Object[0])).floatValue();
            drawable.setBounds(0, 0, 0, 0);
            spannableStringBuilder.setSpan(new StyleSpan(1), 2, 15, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), 2, 15, 34);
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 0, 1, 33);
            cls.getMethod("setHint", new Class[]{CharSequence.class}).invoke(findViewById, new Object[]{spannableStringBuilder});
            searchView2.setIconifiedByDefault(true);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void deleteClientAtIndex(int i) {
        try {
            int intValue = this.searchIndexes.get(i).intValue();
            JSONObject jSONObject = this.clients.getJSONObject(intValue);
            this.clients.remove(intValue);
            rebuildFiltered();
            new BaseHttpClient(false, getActivity()).delete(String.format("/users/%s", new Object[]{String.valueOf(jSONObject.getInt("id"))}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    if (!ClientsFragment.this.askForUpgrade) {
                        return true;
                    }
                    ClientsFragment.this.reload();
                    return true;
                }
            });
            this.adapter.notifyDataSetChanged();
            toggleOnBoarding();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void searchClient(String str) {
        if (this.clients != null) {
            String trim = str.trim();
            if (trim.length() == 0) {
                this.currentSearchTerm = null;
                rebuildFiltered();
                this.adapter.notifyDataSetChanged();
                if (this.searchIndexes.size() == 0) {
                    this.emptyStateView.setVisibility(0);
                } else {
                    this.emptyStateView.setVisibility(8);
                }
            } else {
                ClientSearchTask clientSearchTask = this.currentSearchTask;
                if (clientSearchTask != null) {
                    clientSearchTask.cancel(true);
                }
                this.currentSearchTerm = trim;
                ClientSearchTask clientSearchTask2 = new ClientSearchTask(this);
                clientSearchTask2.execute(new ClientTuple[]{new ClientTuple(trim, this.clients, this.filteredIndexes)});
                this.currentSearchTask = clientSearchTask2;
            }
        }
    }

    public void handleSearchResult(ClientTuple<String, JSONArray, ArrayList<Integer>> clientTuple) {
        if (isAdded()) {
            String str = (String) clientTuple.x;
            String str2 = this.currentSearchTerm;
            if (str2 == null || !str2.equals(str)) {
                this.emptyStateView.setVisibility(8);
                return;
            }
            ArrayList<Integer> arrayList = (ArrayList) clientTuple.z;
            this.searchIndexes = arrayList;
            if (arrayList.size() == 0) {
                this.emptyStateView.setVisibility(0);
            } else {
                this.emptyStateView.setVisibility(8);
            }
            this.adapter.notifyDataSetChanged();
        }
    }

    public void planBtnClicked(JSONObject jSONObject) {
        if (this.step == 1) {
            this.step = 2;
            Util.storeStep(getActivity(), this.step);
        }
        startClientManagementActivity(jSONObject, 0);
    }

    public void diaryBtnClicked(JSONObject jSONObject) {
        startClientManagementActivity(jSONObject, 1);
    }

    public void diaryBtnClicked(JSONObject jSONObject, int i) {
        try {
            Intent intent = new Intent(getActivity(), StoryListActivity.class);
            intent.putExtra("story_list_view_type", StoryListViewType.CHECKINS_VIEW.getMask());
            intent.putExtra("story_type_filter", StoryType.CHECKIN.getMask());
            intent.putExtra("diary_user_id", jSONObject.getInt("id"));
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void assessmentBtnClicked(JSONObject jSONObject) {
        try {
            Intent intent = new Intent(getActivity(), AssessmentActivity.class);
            intent.putExtra("userId", jSONObject.getInt("id"));
            intent.putExtra("context_user_first_name", jSONObject.getString("first_name"));
            intent.putExtra("viewed_by_trainer", true);
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void notesBtnClicked(JSONObject jSONObject) {
        try {
            Intent intent = new Intent(getActivity(), RNHostActivity.class);
            intent.putExtra("entryRoute", RNEntryRoute.NOTES.getMask());
            Bundle bundle = new Bundle();
            bundle.putString("channel_id", String.format("3-%d", new Object[]{Integer.valueOf(jSONObject.getInt("id"))}));
            intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void trackWorkoutClicked(JSONObject jSONObject) {
        try {
            Intent intent = new Intent(getActivity(), WorkoutLogActivity.class);
            intent.putExtra("user_id", jSONObject.getInt("id"));
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void settingsBtnClicked(JSONObject jSONObject) {
        try {
            Intent intent = new Intent(getActivity(), RNHostActivity.class);
            intent.putExtra("entryRoute", RNEntryRoute.USER_SETTINGS.getMask());
            Bundle bundle = new Bundle();
            bundle.putBoolean("for_my_settings", false);
            bundle.putInt("context_user_id", jSONObject.getInt("id"));
            bundle.putInt("context_user_role", UserRole.CLIENT.getMask());
            bundle.putString("client", jSONObject.toString());
            bundle.putBoolean("show_menu_button", false);
            intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void deleteBtnClicked(final int i) {
        String str;
        try {
            str = String.format(getString(R.string.deleteClientConfirmation), new Object[]{((JSONObject) this.clients.get(this.searchIndexes.get(i).intValue())).getString("first_name")});
        } catch (JSONException e) {
            e.printStackTrace();
            str = "";
        }
        new MaterialDialog.Builder(getActivity()).title((int) R.string.deleteClient).content((CharSequence) str).positiveText((CharSequence) getString(R.string.Yes)).negativeText((CharSequence) getString(R.string.No)).onPositive(new MaterialDialog.SingleButtonCallback() {
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                ClientsFragment.this.deleteClientAtIndex(i);
            }
        }).build().show();
    }

    public void moreBtnClicked(JSONObject jSONObject, int i) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt("client_id", jSONObject.getInt("id"));
            bundle.putString("client", jSONObject.toString());
            bundle.putInt(ViewProps.POSITION, i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ClientOptionsDialogFragment newInstance = ClientOptionsDialogFragment.newInstance();
        newInstance.setArguments(bundle);
        newInstance.setTargetFragment(this, 1);
        newInstance.show(getActivity().getSupportFragmentManager(), "bottomSheet");
    }

    public void startClientManagementActivity(JSONObject jSONObject, int i) {
        Intent intent = new Intent(getActivity(), ClientManagementActivity.class);
        try {
            intent.putExtra("client_id", jSONObject.getInt("id"));
            intent.putExtra("client_first_name", jSONObject.getString("first_name"));
            if (jSONObject.getBoolean("is_sample_client")) {
                didCheckOutSampleClient = true;
            }
            intent.putExtra("selectedTabIndex", i);
            startActivity(intent);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void startClientManagementActivityWithFilter(JSONObject jSONObject, int i, int i2) {
        Intent intent = new Intent(getActivity(), ClientManagementActivity.class);
        try {
            intent.putExtra("client_id", jSONObject.getInt("id"));
            intent.putExtra("client_first_name", jSONObject.getString("first_name"));
            intent.putExtra("selected_diary_filter", i2);
            if (jSONObject.getBoolean("is_sample_client")) {
                didCheckOutSampleClient = true;
            }
            intent.putExtra("selectedTabIndex", i);
            startActivity(intent);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendInviteBtnClicked(JSONObject jSONObject) {
        try {
            sendInviteEmail(getActivity(), jSONObject.getInt("id"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendInviteEmail(final Activity activity, final int i) {
        new BaseHttpClient(true, activity).put(String.format("/users/%s/invite2", new Object[]{String.valueOf(i)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    boolean z = jSONObject.getBoolean("is_trainer");
                    if (!z) {
                        AppEventUtil.sendClientInviteSentEvent(i);
                    }
                    ClientsFragment.openInviteEmail(activity, jSONObject.getString("first_name"), jSONObject.getString("email"), jSONObject.getString("password"), z);
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void coBtnClicked(JSONObject jSONObject) {
        LocalDB.userCOClientApp(getActivity());
        new BaseHttpClient(true, getActivity()).put("/access_tokens/sample_client_token", (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Intent intent = new Intent(ClientsFragment.this.getActivity(), MainClientActivity.class);
                intent.putExtra("isViewedByTrainer", true);
                intent.addFlags(268468224);
                ReactInstanceManagerFactory.getInstance().clear();
                ClientsFragment.this.startActivity(intent);
                ClientsFragment.this.getActivity().finish();
                return true;
            }
        });
    }

    public void chatBtnClicked(JSONObject jSONObject) {
        Intent intent = new Intent(getActivity(), RNHostActivity.class);
        intent.putExtra("entryRoute", RNEntryRoute.MESSAGING.getMask());
        Bundle bundle = new Bundle();
        try {
            bundle.putString("channel_id", String.format("1-%d", new Object[]{Integer.valueOf(jSONObject.getInt("id"))}));
            intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
            startActivity(intent);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleNewClient(int i, String str, String str2, String str3) {
        if (isAdded()) {
            String format = String.format(getString(R.string.emailLoginDetailsTitle), new Object[]{str});
            String format2 = String.format(getString(R.string.emailLoginDetailsBenefit), new Object[]{str, getString(R.string.app_name)});
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.emailDialog = new MaterialDialog.Builder(getActivity()).title((CharSequence) format).content((CharSequence) format2).positiveText((CharSequence) getString(R.string.Yes)).negativeText((CharSequence) getString(R.string.No)).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    AppEventUtil.sendClientInviteSentEvent(i2);
                    ClientsFragment.this.openInviteEmail(str4, str5, str6, false);
                }
            }).build();
            JSONArray jSONArray = this.clients;
            if (jSONArray != null && jSONArray.length() == 3) {
                this.hideOnBoardingTip = true;
            }
            this.newClientId = i;
        }
    }

    /* access modifiers changed from: private */
    public void openInviteEmail(String str, String str2, String str3, boolean z) {
        openInviteEmail(getActivity(), str, str2, str3, z);
    }

    /* access modifiers changed from: private */
    public static void openInviteEmail(Context context, String str, String str2, String str3, boolean z) {
        InputStream inputStream;
        Resources resources = context.getResources();
        if (z) {
            inputStream = resources.openRawResource(R.raw.trainer_welcome_txt);
        } else {
            inputStream = resources.openRawResource(R.raw.client_welcome_txt);
        }
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            String str4 = new String(bArr);
            Intent intent = new Intent("android.intent.action.SEND");
            String build = Strings.format(str4, "[", "]").with("param_name", str).with("param_app_name", context.getString(R.string.app_name)).with("param_ios_app_url", context.getString(R.string.ios_app_url)).with("param_android_app_url", context.getString(R.string.android_app_url)).with("param_email", str2).with("param_password", str3).build();
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{str2});
            intent.putExtra("android.intent.extra.SUBJECT", String.format(context.getString(R.string.welcomeEmailSubject), new Object[]{context.getString(R.string.app_name)}));
            intent.putExtra("android.intent.extra.TEXT", build);
            context.startActivity(Intent.createChooser(intent, "Email:"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Boolean isSampleClientPresent() {
        int i = 0;
        while (i < this.clients.length()) {
            try {
                if (this.clients.getJSONObject(i).getBoolean("is_sample_client")) {
                    return true;
                }
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void toggleOnBoarding() {
        if (this.clients == null || this.hideOnBoardingTip.booleanValue() || !isSampleClientPresent().booleanValue()) {
            this.onboardingWrapper.setVisibility(8);
            this.resourcesWrapper.setVisibility(0);
            return;
        }
        int i = this.step;
        if (i == 1) {
            this.onboardingWrapper.setVisibility(0);
            this.resourcesWrapper.setVisibility(8);
            this.stepText.setText("STEP 1/2");
            this.tipText.setText(R.string.onboarding1);
            this.tipBtn.setText(R.string.tipBtn1);
            String str = this.welcomeString;
            if (str != null) {
                this.welcomeText.setText(str);
            }
        } else if (i == 2) {
            this.onboardingWrapper.setVisibility(0);
            this.resourcesWrapper.setVisibility(8);
            this.stepText.setText("STEP 2/2");
            this.welcomeText.setText(R.string.welcome2);
            this.tipText.setText(R.string.onboarding2);
            this.tipBtn.setText(R.string.tipBtn2);
        } else {
            this.onboardingWrapper.setVisibility(8);
            this.resourcesWrapper.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r2 > 1) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r2 > 0) goto L_0x001d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[Catch:{ JSONException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027 A[Catch:{ JSONException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[Catch:{ JSONException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057 A[Catch:{ JSONException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c9 A[Catch:{ JSONException -> 0x00db }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0050 A[EDGE_INSN: B:47:0x0050->B:24:0x0050 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendEventsForPPC() {
        /*
            r9 = this;
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()     // Catch:{ JSONException -> 0x00db }
            java.lang.Boolean r1 = r9.isSampleClientPresent()     // Catch:{ JSONException -> 0x00db }
            boolean r1 = r1.booleanValue()     // Catch:{ JSONException -> 0x00db }
            org.json.JSONArray r2 = r9.clients     // Catch:{ JSONException -> 0x00db }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x00db }
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001b
            int r5 = r2 + -1
            if (r5 <= 0) goto L_0x001f
            goto L_0x001d
        L_0x001b:
            if (r2 <= 0) goto L_0x001f
        L_0x001d:
            r5 = 1
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            if (r1 == 0) goto L_0x0027
            int r2 = r2 + -2
            if (r2 <= 0) goto L_0x002b
            goto L_0x0029
        L_0x0027:
            if (r2 <= r4) goto L_0x002b
        L_0x0029:
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            r2 = 0
        L_0x002d:
            org.json.JSONArray r6 = r9.clients     // Catch:{ JSONException -> 0x00db }
            int r6 = r6.length()     // Catch:{ JSONException -> 0x00db }
            if (r2 >= r6) goto L_0x0050
            org.json.JSONArray r6 = r9.clients     // Catch:{ JSONException -> 0x00db }
            org.json.JSONObject r6 = r6.getJSONObject(r2)     // Catch:{ JSONException -> 0x00db }
            java.lang.String r7 = "is_sample_client"
            boolean r7 = r6.getBoolean(r7)     // Catch:{ JSONException -> 0x00db }
            java.lang.String r8 = "have_downloaded_app"
            boolean r6 = r6.getBoolean(r8)     // Catch:{ JSONException -> 0x00db }
            if (r7 != 0) goto L_0x004d
            if (r6 == 0) goto L_0x004d
            r3 = 1
            goto L_0x0050
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0050:
            boolean r2 = com.trainerfu.android.LocalDB.didSendRegistrationEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
            r4 = 0
            if (r2 != 0) goto L_0x0068
            com.facebook.appevents.AppEventsLogger r2 = r9.fbLogger     // Catch:{ JSONException -> 0x00db }
            java.lang.String r6 = "fb_mobile_complete_registration"
            r2.logEvent(r6)     // Catch:{ JSONException -> 0x00db }
            com.google.firebase.analytics.FirebaseAnalytics r2 = r9.mFirebaseAnalytics     // Catch:{ JSONException -> 0x00db }
            java.lang.String r6 = "sign_up_android"
            r2.logEvent(r6, r4)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.LocalDB.sentRegistrationEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
        L_0x0068:
            if (r5 == 0) goto L_0x0081
            boolean r2 = com.trainerfu.android.LocalDB.didSendAddedClient1EventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
            if (r2 != 0) goto L_0x0081
            com.facebook.appevents.AppEventsLogger r2 = r9.fbLogger     // Catch:{ JSONException -> 0x00db }
            java.lang.String r5 = "AddedClient1"
            r2.logEvent(r5)     // Catch:{ JSONException -> 0x00db }
            com.google.firebase.analytics.FirebaseAnalytics r2 = r9.mFirebaseAnalytics     // Catch:{ JSONException -> 0x00db }
            java.lang.String r5 = "added_client_1_android"
            r2.logEvent(r5, r4)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.LocalDB.sentAddedClient1EventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
        L_0x0081:
            if (r1 == 0) goto L_0x009a
            boolean r1 = com.trainerfu.android.LocalDB.didSendAddedClient2EventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
            if (r1 != 0) goto L_0x009a
            com.facebook.appevents.AppEventsLogger r1 = r9.fbLogger     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "AddedClient2"
            r1.logEvent(r2)     // Catch:{ JSONException -> 0x00db }
            com.google.firebase.analytics.FirebaseAnalytics r1 = r9.mFirebaseAnalytics     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "added_client_2_android"
            r1.logEvent(r2, r4)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.LocalDB.sentAddedClient2EventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
        L_0x009a:
            if (r3 == 0) goto L_0x00bf
            boolean r1 = com.trainerfu.android.LocalDB.didSendActivatedClientEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
            if (r1 != 0) goto L_0x00bf
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ JSONException -> 0x00db }
            r1.<init>()     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "fb_level"
            java.lang.String r3 = "level-1"
            r1.putString(r2, r3)     // Catch:{ JSONException -> 0x00db }
            com.facebook.appevents.AppEventsLogger r2 = r9.fbLogger     // Catch:{ JSONException -> 0x00db }
            java.lang.String r3 = "fb_mobile_level_achieved"
            r2.logEvent((java.lang.String) r3, (android.os.Bundle) r1)     // Catch:{ JSONException -> 0x00db }
            com.google.firebase.analytics.FirebaseAnalytics r1 = r9.mFirebaseAnalytics     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "activated_client_android"
            r1.logEvent(r2, r4)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.LocalDB.sentActivatedClientEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
        L_0x00bf:
            boolean r1 = r9.showedPayIntent     // Catch:{ JSONException -> 0x00db }
            if (r1 == 0) goto L_0x00da
            boolean r1 = com.trainerfu.android.LocalDB.didSendShowedPayIntentEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
            if (r1 != 0) goto L_0x00da
            com.facebook.appevents.AppEventsLogger r1 = r9.fbLogger     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "fb_mobile_achievement_unlocked"
            r1.logEvent(r2)     // Catch:{ JSONException -> 0x00db }
            com.google.firebase.analytics.FirebaseAnalytics r1 = r9.mFirebaseAnalytics     // Catch:{ JSONException -> 0x00db }
            java.lang.String r2 = "showed_payment_intent_android"
            r1.logEvent(r2, r4)     // Catch:{ JSONException -> 0x00db }
            com.trainerfu.android.LocalDB.sentShowedPayIntentEventForPPC(r0)     // Catch:{ JSONException -> 0x00db }
        L_0x00da:
            return
        L_0x00db:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.ClientsFragment.sendEventsForPPC():void");
    }

    private void successfulLogin() {
        Intercom.client().loginIdentifiedUser(Registration.create().withUserId(String.valueOf(this.myUserId)), new IntercomStatusCallback() {
            public void onFailure(IntercomError intercomError) {
            }

            public void onSuccess() {
            }
        });
    }

    private class ClientListAdapter extends BaseAdapter implements View.OnClickListener {
        private Context context;
        /* access modifiers changed from: private */
        public ClientRowEventListener listener;

        public int getViewTypeCount() {
            return 2;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isEmpty() {
            return false;
        }

        public ClientListAdapter(Context context2, ClientRowEventListener clientRowEventListener) {
            this.context = context2;
            this.listener = clientRowEventListener;
        }

        public int getCount() {
            return ClientsFragment.this.searchIndexes.size();
        }

        public Object getItem(int i) {
            try {
                return ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(i)).intValue());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public long getItemId(int i) {
            try {
                return (long) ((JSONObject) getItem(i)).getInt("id");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public int getItemViewType(int i) {
            try {
                return ((JSONObject) getItem(i)).getBoolean("is_sample_client") ? 1 : 0;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            String str;
            final int i2 = i;
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            try {
                JSONObject jSONObject = (JSONObject) getItem(i);
                boolean z = jSONObject.getBoolean("is_sample_client");
                View inflate = layoutInflater.inflate(R.layout.client_view, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.placeholder_photo_view)).getDrawable().setColorFilter(ContextCompat.getColor(this.context, R.color.grayColor), PorterDuff.Mode.SRC_IN);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.placeholder_photo_view);
                CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.client_photo_view);
                if (jSONObject.isNull("user_photo_id")) {
                    circleImageView.setVisibility(0);
                    circleImageView.setImageDrawable(ClientsFragment.this.getResources().getDrawable(R.drawable.profile));
                    circleImageView.setColorFilter(ContextCompat.getColor(this.context, R.color.grayColor), PorterDuff.Mode.SRC_IN);
                } else {
                    int i3 = jSONObject.getInt("user_photo_id");
                    circleImageView.setVisibility(0);
                    Picasso.get().load(Util.getUrlForPhoto(i3)).error((int) R.drawable.profile).into((ImageView) circleImageView);
                }
                ((TextView) inflate.findViewById(R.id.nameTV)).setText(String.format("%s %s", new Object[]{jSONObject.getString("first_name"), jSONObject.getString("last_name")}));
                boolean z2 = jSONObject.getBoolean("have_downloaded_app");
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sendInviteWrapper);
                if (z2) {
                    linearLayout.setVisibility(8);
                } else {
                    String string = ClientsFragment.this.getString(R.string.sendInvite);
                    String format = String.format(ClientsFragment.this.getString(R.string.whySendInvite), new Object[]{jSONObject.getString("first_name"), string});
                    new SpannableString(format).setSpan(new ClickableSpan() {
                        public void onClick(View view) {
                            try {
                                ClientListAdapter.this.listener.sendInviteBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(((Integer) view.getTag()).intValue())).intValue()));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            super.updateDrawState(textPaint);
                            textPaint.setUnderlineText(true);
                        }
                    }, format.length() - string.length(), format.length() - 1, 33);
                    linearLayout.setVisibility(0);
                    linearLayout.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            try {
                                ClientListAdapter.this.listener.sendInviteBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(i2)).intValue()));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
                setupBtn(inflate.findViewById(R.id.planBtn), i2);
                setupBtn(inflate.findViewById(R.id.moreBtn), i2);
                setupBtn(inflate.findViewById(R.id.chatBtn), i2);
                TextView textView = (TextView) inflate.findViewById(R.id.last_plan_start_view);
                Date dateFromISOFormat = DateUtils.getDateFromISOFormat(jSONObject.getString("last_plan_start_date"));
                Date todaysDate = DateUtils.getTodaysDate();
                if (DateUtils.dateDifferenceInDays(todaysDate, dateFromISOFormat) > 0) {
                    textView.setText(String.format("%s: %s", new Object[]{ClientsFragment.this.getString(R.string.plannedUptil), DateUtils.getDisplayDate(ClientsFragment.this.getActivity(), DateUtils.addDays(ClientsFragment.this.cal, dateFromISOFormat, 7))}));
                } else {
                    textView.setText(ClientsFragment.this.getString(R.string.NoUpcomingPlan));
                }
                TextView textView2 = (TextView) inflate.findViewById(R.id.last_activity_view);
                String str2 = "~";
                if (!jSONObject.isNull("last_workout_logged_date")) {
                    int dateDifferenceInDays = DateUtils.dateDifferenceInDays(DateUtils.getDateFromISOFormat(jSONObject.getString("last_workout_logged_date")), todaysDate);
                    if (dateDifferenceInDays == 0) {
                        str = ClientsFragment.this.getString(R.string.Today);
                    } else if (dateDifferenceInDays == 1) {
                        str = ClientsFragment.this.getString(R.string.Yesterday);
                    } else if (dateDifferenceInDays > 7) {
                        str = ClientsFragment.this.getString(R.string.moreThan7dAgo);
                    } else {
                        str = String.format(ClientsFragment.this.getString(R.string.nDaysAgo), new Object[]{String.valueOf(dateDifferenceInDays)});
                    }
                    str2 = String.format("%s : %s", new Object[]{ClientsFragment.this.getString(R.string.LastWorkout), str});
                }
                textView2.setText(str2);
                if (z) {
                    int length = ClientsFragment.this.clients.length();
                    setupBtn(inflate.findViewById(R.id.coWrapper), i2);
                    inflate.findViewById(R.id.onboardingWrapper).setVisibility(0);
                    if (length == 1 && LocalDB.isFirstLaunch(ClientsFragment.this.getActivity()) && !ClientsFragment.didCheckOutSampleClient) {
                        inflate.findViewById(R.id.coWrapper).setVisibility(0);
                    } else if (length >= 3 || LocalDB.didCOClientApp(ClientsFragment.this.getActivity())) {
                        inflate.findViewById(R.id.coWrapper).setVisibility(0);
                    } else {
                        inflate.findViewById(R.id.coWrapper).setVisibility(0);
                    }
                }
                return inflate;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        private void setupBtn(View view, int i) {
            view.setTag(Integer.valueOf(i));
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            try {
                if (view.getId() == R.id.planBtn) {
                    this.listener.planBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(intValue)).intValue()));
                } else if (view.getId() == R.id.moreBtn) {
                    this.listener.moreBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(intValue)).intValue()), intValue);
                } else if (view.getId() == R.id.coWrapper) {
                    this.listener.coBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(intValue)).intValue()));
                } else if (view.getId() == R.id.chatBtn) {
                    this.listener.chatBtnClicked((JSONObject) ClientsFragment.this.clients.get(((Integer) ClientsFragment.this.searchIndexes.get(intValue)).intValue()));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
