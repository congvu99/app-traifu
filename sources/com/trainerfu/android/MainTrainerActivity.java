package com.trainerfu.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.trainerfu.android.ClientsFragment;
import com.trainerfu.android.TabHostActivity;
import com.trainerfu.story.StoryListFragment;
import com.trainerfu.story.StoryListViewType;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainTrainerActivity extends TabHostActivity implements ClientsFragment.EventListener {
    private static int ADD_CLIENT_REQUEST_CODE = 1009;
    private static int BUY_PREMIUM_REQUEST_CODE = 1008;
    private Activity activity;
    private CallbackManager callbackManager = CallbackManager.Factory.create();
    private boolean didSyncPurchaseData = false;
    private int filterForClientsFragment = -2;
    private int filterForStoriesFragment = -2;
    /* access modifiers changed from: private */
    public int myUserId = -1;
    private int segmentIdFilter = -1;
    /* access modifiers changed from: private */
    public JSONArray segments = null;
    /* access modifiers changed from: private */
    public JSONArray trainers = null;

    /* access modifiers changed from: package-private */
    public int getNewsTabIndex() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getNotificationTabIndex() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean hasNewsTab() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean hasNotificationTab() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            if (bundle.containsKey("filter_for_clients_fragment")) {
                this.filterForClientsFragment = bundle.getInt("filter_for_clients_fragment");
            }
            if (bundle.containsKey("filter_for_stories_fragment")) {
                this.filterForStoriesFragment = bundle.getInt("filter_for_stories_fragment");
            }
            if (bundle.containsKey("my_user_id")) {
                this.myUserId = bundle.getInt("my_user_id");
            }
            try {
                if (bundle.containsKey("trainers")) {
                    this.trainers = new JSONArray(bundle.getString("trainers"));
                }
                if (bundle.containsKey("segments")) {
                    this.segments = new JSONArray(bundle.getString("segments"));
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("segmentIdFilter")) {
            this.segmentIdFilter = extras.getInt("segmentIdFilter");
        }
        this.activity = this;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = this.filterForClientsFragment;
        if (i != -2) {
            bundle.putInt("filter_for_clients_fragment", i);
        }
        int i2 = this.filterForStoriesFragment;
        if (i2 != -2) {
            bundle.putInt("filter_for_stories_fragment", i2);
        }
        JSONArray jSONArray = this.trainers;
        if (jSONArray != null) {
            bundle.putString("trainers", jSONArray.toString());
        }
        JSONArray jSONArray2 = this.segments;
        if (jSONArray2 != null) {
            bundle.putString("segments", jSONArray2.toString());
        }
        bundle.putInt("my_user_id", this.myUserId);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z;
        String str;
        Menu menu2 = menu;
        getMenuInflater().inflate(R.menu.trainer_filter, menu2);
        MenuItem findItem = menu2.findItem(R.id.filter_item);
        MenuItem findItem2 = menu2.findItem(R.id.add_client_item);
        MenuItem findItem3 = menu2.findItem(R.id.action_search);
        try {
            if (this.trainers == null || this.segments == null || !(getSelectedTabIndex() == 0 || getSelectedTabIndex() == 1)) {
                z = false;
                findItem.setVisible(false);
            } else {
                findItem.setVisible(true);
                int i = 0;
                while (true) {
                    if (i >= this.trainers.length()) {
                        i = 0;
                        break;
                    } else if (this.trainers.getJSONObject(i).getInt("id") == this.myUserId) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (this.filterForClientsFragment == -2 || this.filterForStoriesFragment == -2) {
                    this.filterForClientsFragment = i;
                    this.filterForStoriesFragment = i;
                }
                Integer valueOf = Integer.valueOf(getSelectedTabIndex() == 0 ? this.filterForClientsFragment : this.filterForStoriesFragment);
                if (valueOf.intValue() == -1) {
                    str = getString(R.string.All);
                } else if (valueOf.intValue() < this.trainers.length()) {
                    JSONObject jSONObject = this.trainers.getJSONObject(valueOf.intValue());
                    if (jSONObject.getInt("id") == this.myUserId) {
                        str = getString(R.string.My);
                    } else {
                        str = jSONObject.getString("first_name");
                    }
                } else {
                    str = this.segments.getJSONObject(valueOf.intValue() - this.trainers.length()).getString("name");
                }
                SpannableString spannableString = new SpannableString(String.format("▼ %s ", new Object[]{str}));
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.iconColor)), 0, spannableString.length(), 0);
                findItem.setTitle(spannableString);
                SubMenu subMenu = findItem.getSubMenu();
                MenuItem add = subMenu.add(R.id.sub_menu, -1, 0, getString(R.string.AllClients));
                add.setCheckable(true);
                if (valueOf.intValue() == -1) {
                    add.setChecked(true);
                }
                MenuItem add2 = subMenu.add(R.id.sub_menu, i, 0, getString(R.string.MyClients));
                add2.setCheckable(true);
                if (valueOf.intValue() == i) {
                    add2.setChecked(true);
                }
                if (this.trainers.length() > 1) {
                    MenuItem add3 = subMenu.add(R.id.sub_menu, -100, 0, String.format("%s ▼", new Object[]{getString(R.string.TrainedBy)}));
                    add3.setCheckable(false);
                    add3.setEnabled(false);
                }
                for (int i2 = 0; i2 < this.trainers.length(); i2++) {
                    JSONObject jSONObject2 = this.trainers.getJSONObject(i2);
                    if (jSONObject2.getInt("id") != this.myUserId) {
                        MenuItem add4 = subMenu.add(R.id.sub_menu, i2, 0, String.format("    %s", new Object[]{jSONObject2.getString("first_name")}));
                        add4.setCheckable(true);
                        if (valueOf.intValue() == i2) {
                            add4.setChecked(true);
                        }
                    }
                }
                if (this.segments.length() > 1) {
                    MenuItem add5 = subMenu.add(R.id.sub_menu, -101, 0, String.format("%s ▼", new Object[]{getString(R.string.InGroup)}));
                    add5.setCheckable(false);
                    add5.setEnabled(false);
                    for (int i3 = 0; i3 < this.segments.length(); i3++) {
                        int length = this.trainers.length() + i3;
                        JSONObject jSONObject3 = this.segments.getJSONObject(i3);
                        if (jSONObject3.getInt("segment_type") == 1) {
                            MenuItem add6 = subMenu.add(R.id.sub_menu, length, 0, String.format("    %s", new Object[]{jSONObject3.getString("name")}));
                            add6.setCheckable(true);
                            if (valueOf.intValue() == length) {
                                add6.setChecked(true);
                            }
                            if (getSelectedTabIndex() == 1) {
                                if (this.segmentIdFilter != -1 && this.segmentIdFilter == jSONObject3.getInt("id")) {
                                    onOptionsItemSelected(add6);
                                }
                            }
                        }
                    }
                }
                z = false;
            }
            if (getSelectedTabIndex() != 0) {
                findItem2.setVisible(z);
                findItem3.setVisible(z);
            }
            return super.onCreateOptionsMenu(menu);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.trainers == null) {
            new BaseHttpClient(false, this).get("/trainers", (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        JSONArray unused = MainTrainerActivity.this.trainers = jSONObject.getJSONArray("users");
                        int unused2 = MainTrainerActivity.this.myUserId = jSONObject.getInt("my_user_id");
                        MainTrainerActivity.this.invalidateOptionsMenu();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        if (this.segments == null) {
            new BaseHttpClient(false, this).get("/segments", (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("segments");
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            boolean z = jSONObject2.getBoolean("is_default");
                            if (!(jSONObject2.has("for_tm_only") ? jSONObject2.getBoolean("for_tm_only") : false) || z) {
                                arrayList.add(jSONObject2);
                            }
                        }
                        JSONArray unused = MainTrainerActivity.this.segments = new JSONArray(arrayList);
                        MainTrainerActivity.this.invalidateOptionsMenu();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onOptionsItemSelected(android.view.MenuItem r6) {
        /*
            r5 = this;
            int r0 = r6.getGroupId()
            r1 = 2131363228(0x7f0a059c, float:1.8346259E38)
            if (r0 != r1) goto L_0x006a
            int r0 = r6.getItemId()
            r1 = -1
            r5.segmentIdFilter = r1
            if (r0 <= r1) goto L_0x0045
            org.json.JSONArray r2 = r5.trainers     // Catch:{ JSONException -> 0x003e }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x003e }
            java.lang.String r3 = "id"
            if (r0 >= r2) goto L_0x0029
            org.json.JSONArray r2 = r5.trainers     // Catch:{ JSONException -> 0x003e }
            org.json.JSONObject r2 = r2.getJSONObject(r0)     // Catch:{ JSONException -> 0x003e }
            int r2 = r2.getInt(r3)     // Catch:{ JSONException -> 0x003e }
            r5.segmentIdFilter = r1     // Catch:{ JSONException -> 0x003e }
            goto L_0x0046
        L_0x0029:
            org.json.JSONArray r2 = r5.segments     // Catch:{ JSONException -> 0x003e }
            org.json.JSONArray r4 = r5.trainers     // Catch:{ JSONException -> 0x003e }
            int r4 = r4.length()     // Catch:{ JSONException -> 0x003e }
            int r4 = r0 - r4
            org.json.JSONObject r2 = r2.getJSONObject(r4)     // Catch:{ JSONException -> 0x003e }
            int r2 = r2.getInt(r3)     // Catch:{ JSONException -> 0x003e }
            r5.segmentIdFilter = r2     // Catch:{ JSONException -> 0x003e }
            goto L_0x0045
        L_0x003e:
            r6 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r6)
            throw r0
        L_0x0045:
            r2 = -1
        L_0x0046:
            int r3 = r5.getSelectedTabIndex()
            if (r3 != 0) goto L_0x005a
            r5.filterForClientsFragment = r0
            com.trainerfu.android.ClientsFragment r0 = r5.getClientFragment()
            int r3 = r5.segmentIdFilter
            r0.setFilter(r2, r3)
            r5.segmentIdFilter = r1
            goto L_0x0067
        L_0x005a:
            r5.filterForStoriesFragment = r0
            com.trainerfu.story.StoryListFragment r0 = r5.getStoriesFragment()
            int r3 = r5.segmentIdFilter
            r0.setFilter(r2, r3)
            r5.segmentIdFilter = r1
        L_0x0067:
            r5.invalidateOptionsMenu()
        L_0x006a:
            boolean r6 = super.onOptionsItemSelected(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.MainTrainerActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    /* access modifiers changed from: protected */
    public ArrayList<TabHostActivity.TabDefinition> getTabDefinition(Bundle bundle) {
        ArrayList<TabHostActivity.TabDefinition> arrayList = new ArrayList<>();
        arrayList.add(new TabHostActivity.TabDefinition("clf", ClientsFragment.class.getName(), R.string.clientsTab, R.drawable.icon_clients, (Bundle) null, new ClientsFragment()));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("story_list_view_type", StoryListViewType.NEWS_VIEW.getMask());
        bundle2.putBoolean("is_viewed_by_trainer", true);
        arrayList.add(new TabHostActivity.TabDefinition("sf", StoryListFragment.class.getName(), R.string.newsTab, R.drawable.ic_language_black_24dp, bundle2, new StoryListFragment()));
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("is_viewed_by_trainer", true);
        arrayList.add(new TabHostActivity.TabDefinition("ff", FeedFragment.class.getName(), R.string.notifsTab, R.drawable.ic_notifications_black_24dp, bundle3, new FeedFragment()));
        Bundle bundle4 = new Bundle();
        bundle4.putInt("view_type", MoreFragmentViewType.TRAINER_VIEW.getMask());
        arrayList.add(new TabHostActivity.TabDefinition("mf", MoreFragment.class.getName(), R.string.moreTab, R.drawable.more_icon, bundle4, new MoreFragment()));
        return arrayList;
    }

    public void addNewClientClicked() {
        Intent intent = new Intent(this, AddClientActivity.class);
        JSONArray jSONArray = this.trainers;
        if (jSONArray != null) {
            intent.putExtra("trainers", jSONArray.toString());
            intent.putExtra("selected_trainer_id", this.myUserId);
        }
        JSONArray jSONArray2 = this.segments;
        if (jSONArray2 != null) {
            intent.putExtra("segments", jSONArray2.toString());
        }
        startActivityForResult(intent, ADD_CLIENT_REQUEST_CODE);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ClientsFragment clientFragment;
        if (i == ADD_CLIENT_REQUEST_CODE) {
            if (i2 == -1 && (clientFragment = getClientFragment()) != null && clientFragment.isAdded()) {
                Bundle extras = intent.getExtras();
                clientFragment.handleNewClient(extras.getInt("user_id"), extras.getString("first_name"), extras.getString("email"), extras.getString("password"));
            }
        } else if (i == BUY_PREMIUM_REQUEST_CODE) {
            intent.getStringExtra("INAPP_PURCHASE_DATA");
        }
        super.onActivityResult(i, i2, intent);
        this.callbackManager.onActivityResult(i, i2, intent);
    }

    private ClientsFragment getClientFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments == null) {
            return null;
        }
        for (Fragment next : fragments) {
            if (next instanceof ClientsFragment) {
                return (ClientsFragment) next;
            }
        }
        return null;
    }

    private StoryListFragment getStoriesFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments == null) {
            return null;
        }
        for (Fragment next : fragments) {
            if (next instanceof StoryListFragment) {
                return (StoryListFragment) next;
            }
        }
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
