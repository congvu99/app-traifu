package com.trainerfu.android;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.android.WorkoutPlanDayFragment;
import com.trainerfu.story.StoryListFragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class TabHostActivity extends BaseActivity implements WorkoutPlanDayFragment.TrackingEventListener {
    /* access modifiers changed from: private */
    public TextView actionBarTitle;
    /* access modifiers changed from: private */
    public LinearLayout appBar;
    private String clientFirstName;
    private int defaultIconColor;
    private Bundle extras;
    private Runnable fetchNewNotificationCountRunnable = null;
    /* access modifiers changed from: private */
    public Fragment[] fragments;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean hasNewsTab;
    /* access modifiers changed from: private */
    public boolean hasNotificationTab;
    private ImageView homeBackground;
    private int homeIconColor;
    private ImageView iconView;
    /* access modifiers changed from: private */
    public Boolean isTrainer = true;
    /* access modifiers changed from: private */
    public Boolean isViewedByTrainer = false;
    private Runnable newNewsNotificationRunnable = null;
    /* access modifiers changed from: private */
    public TextView newsBadgeView;
    private IconTextView newsTabIcon;
    /* access modifiers changed from: private */
    public int newsTabIndex;
    private IconTextView newsTabSelectedIcon;
    /* access modifiers changed from: private */
    public TextView notificationBadgeView;
    /* access modifiers changed from: private */
    public int notificationTabIndex;
    /* access modifiers changed from: private */
    public int selectedIconColor;
    /* access modifiers changed from: private */
    public int selectedTabIndex = 0;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    public ArrayList<TabDefinition> tabs;
    private TextView title;
    /* access modifiers changed from: private */
    public Toolbar toolbar;
    private ViewPager viewPager;

    /* access modifiers changed from: package-private */
    public abstract int getNewsTabIndex();

    /* access modifiers changed from: package-private */
    public abstract int getNotificationTabIndex();

    /* access modifiers changed from: package-private */
    public abstract ArrayList<TabDefinition> getTabDefinition(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean hasNewsTab();

    /* access modifiers changed from: package-private */
    public abstract boolean hasNotificationTab();

    public static class TabDefinition {
        public Bundle args;
        public String className;
        public Fragment fragment;
        public int iconDrawable;
        public String tag;
        public int titleResource;

        public TabDefinition(String str, int i, int i2, Bundle bundle, Fragment fragment2) {
            this((String) null, str, i, i2, bundle, fragment2);
        }

        public TabDefinition(String str, String str2, int i, int i2, Bundle bundle, Fragment fragment2) {
            this.tag = str;
            this.className = str2;
            this.titleResource = i;
            this.iconDrawable = i2;
            this.args = bundle;
            this.fragment = fragment2;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        this.toolbar = (Toolbar) findViewById(R.id.mainActivityBar);
        this.appBar = (LinearLayout) findViewById(R.id.app_bar);
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout2 = (TabLayout) findViewById(R.id.tabs);
        this.tabLayout = tabLayout2;
        tabLayout2.setupWithViewPager(this.viewPager);
        this.tabs = getTabDefinition(bundle);
        this.hasNotificationTab = hasNotificationTab();
        this.notificationTabIndex = getNotificationTabIndex();
        this.hasNewsTab = hasNewsTab();
        this.newsTabIndex = getNewsTabIndex();
        this.fragments = new Fragment[this.tabs.size()];
        this.isTrainer = Util.getIsTrainerProperty(getApplicationContext());
        this.selectedIconColor = getResources().getColor(R.color.tintColor);
        this.defaultIconColor = getResources().getColor(R.color.iconColor);
        this.homeIconColor = getResources().getColor(R.color.homeIconColor);
        this.actionBarTitle = (TextView) this.toolbar.findViewById(R.id.action_bar_title);
        this.iconView = (ImageView) this.toolbar.findViewById(R.id.icon_view);
        this.homeBackground = (ImageView) this.toolbar.findViewById(R.id.home_background);
        Bundle extras2 = getIntent().getExtras();
        this.extras = extras2;
        if (extras2 != null && extras2.getBoolean("isViewedByTrainer")) {
            this.isViewedByTrainer = Boolean.valueOf(this.extras.getBoolean("isViewedByTrainer"));
        }
        setupViewPager(this.viewPager);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setElevation(0.0f);
        if (!this.isTrainer.booleanValue() || this.isViewedByTrainer.booleanValue()) {
            this.toolbar.findViewById(R.id.profile_notif_view).setVisibility(0);
            getWindow().getDecorView().setSystemUiVisibility(16);
            getWindow().setStatusBarColor(getResources().getColor(R.color.tintColor));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.backgroundColor));
        } else {
            this.toolbar.findViewById(R.id.profile_notif_view).setVisibility(8);
            getWindow().getDecorView().setSystemUiVisibility(8192);
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        }
        if (bundle != null) {
            this.selectedTabIndex = bundle.getInt("selectedTabIndex");
        } else {
            Bundle bundle2 = this.extras;
            if (bundle2 != null && bundle2.containsKey("selectedTabIndex")) {
                this.selectedTabIndex = this.extras.getInt("selectedTabIndex");
            }
        }
        setTabIcons();
        this.tabLayout.getTabAt(this.selectedTabIndex).select();
        if (this.hasNotificationTab) {
            createFetchNotificationCountRunnable();
        }
        if (this.hasNewsTab) {
            createNewNewsNotificationRunnable();
        }
    }

    private void setupViewPager(ViewPager viewPager2) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager2.setAdapter(viewPagerAdapter);
        for (int i = 0; i < this.tabs.size(); i++) {
            TabDefinition tabDefinition = this.tabs.get(i);
            Fragment fragment = tabDefinition.fragment;
            fragment.setArguments(tabDefinition.args);
            viewPagerAdapter.addFragment(fragment, getResources().getString(tabDefinition.titleResource));
        }
        viewPager2.setOffscreenPageLimit(5);
        viewPagerAdapter.notifyDataSetChanged();
        viewPager2.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                int unused = TabHostActivity.this.selectedTabIndex = tab.getPosition();
                Fragment fragment = TabHostActivity.this.fragments[tab.getPosition()];
                TabDefinition tabDefinition = TabHostActivity.this.tabs.get(tab.getPosition());
                if (tabDefinition.args == null || !tabDefinition.args.containsKey("context_user_first_name") || TabHostActivity.this.selectedTabIndex == 2) {
                    TabHostActivity.this.actionBarTitle.setText(tabDefinition.titleResource);
                } else {
                    String string = tabDefinition.args.getString("context_user_first_name");
                    if (string != null) {
                        TabHostActivity.this.actionBarTitle.setText(String.format("%s's %s", new Object[]{string, TabHostActivity.this.getString(tabDefinition.titleResource)}));
                    }
                }
                if (TabHostActivity.this.hasNotificationTab && tab.getPosition() == TabHostActivity.this.notificationTabIndex) {
                    TextView unused2 = TabHostActivity.this.notificationBadgeView = (TextView) customView.findViewById(R.id.badge);
                    TabHostActivity.this.notificationBadgeView.setVisibility(8);
                    ImageViewCompat.setImageTintList((ImageView) customView.findViewById(R.id.iv), ColorStateList.valueOf(TabHostActivity.this.selectedIconColor));
                }
                if (TabHostActivity.this.hasNewsTab && tab.getPosition() == TabHostActivity.this.newsTabIndex) {
                    ImageViewCompat.setImageTintList((ImageView) customView.findViewById(R.id.iv), ColorStateList.valueOf(TabHostActivity.this.selectedIconColor));
                    customView.findViewById(R.id.badge).setVisibility(8);
                } else if (tab.getIcon() != null) {
                    tab.getIcon().setTint(TabHostActivity.this.selectedIconColor);
                }
                if (!TabHostActivity.this.isTrainer.booleanValue() || TabHostActivity.this.isViewedByTrainer.booleanValue()) {
                    if (TabHostActivity.this.selectedTabIndex != 0) {
                        TabHostActivity.this.actionBarTitle.setTextColor(TabHostActivity.this.getResources().getColor(R.color.black));
                        TabHostActivity.this.toolbar.findViewById(R.id.profile_notif_view).setVisibility(8);
                        TabHostActivity tabHostActivity = TabHostActivity.this;
                        tabHostActivity.changeIconColor(tabHostActivity.getResources().getColor(R.color.iconColor));
                        TabHostActivity.this.appBar.setBackgroundColor(TabHostActivity.this.getResources().getColor(R.color.white));
                        if (TabHostActivity.this.selectedTabIndex == TabHostActivity.this.newsTabIndex) {
                            ImageViewCompat.setImageTintList((ImageView) customView.findViewById(R.id.iv), ColorStateList.valueOf(TabHostActivity.this.getResources().getColor(R.color.tintColor)));
                        } else {
                            tab.getIcon().setTint(TabHostActivity.this.getResources().getColor(R.color.tintColor));
                        }
                        TabHostActivity.this.tabLayout.setSelectedTabIndicatorColor(TabHostActivity.this.getResources().getColor(R.color.tintColor));
                        TabHostActivity.this.getWindow().getDecorView().setSystemUiVisibility(8192);
                        TabHostActivity.this.getWindow().setStatusBarColor(TabHostActivity.this.getResources().getColor(R.color.white));
                        TabHostActivity.this.getWindow().setNavigationBarColor(TabHostActivity.this.getResources().getColor(R.color.black));
                    } else {
                        TabHostActivity.this.actionBarTitle.setTextColor(TabHostActivity.this.getResources().getColor(R.color.white));
                        TabHostActivity.this.toolbar.findViewById(R.id.profile_notif_view).setVisibility(0);
                        TabHostActivity tabHostActivity2 = TabHostActivity.this;
                        tabHostActivity2.changeIconColor(tabHostActivity2.getResources().getColor(R.color.homeIconColor));
                        TabHostActivity.this.appBar.setBackgroundColor(0);
                        tab.getIcon().setTint(TabHostActivity.this.getResources().getColor(R.color.white));
                        TabHostActivity.this.tabLayout.setSelectedTabIndicatorColor(TabHostActivity.this.getResources().getColor(R.color.white));
                        TabHostActivity.this.getWindow().getDecorView().setSystemUiVisibility(16);
                        TabHostActivity.this.getWindow().setStatusBarColor(TabHostActivity.this.getResources().getColor(R.color.tintColor));
                        TabHostActivity.this.getWindow().setNavigationBarColor(TabHostActivity.this.getResources().getColor(R.color.backgroundColor));
                    }
                }
                TabHostActivity.this.invalidateOptionsMenu();
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setTint(TabHostActivity.this.getResources().getColor(R.color.iconColor));
                }
                if (TabHostActivity.this.hasNewsTab && tab.getPosition() == TabHostActivity.this.newsTabIndex) {
                    ImageViewCompat.setImageTintList((ImageView) tab.getCustomView().findViewById(R.id.iv), ColorStateList.valueOf(TabHostActivity.this.getResources().getColor(R.color.iconColor)));
                }
                if (TabHostActivity.this.hasNotificationTab && tab.getPosition() == TabHostActivity.this.notificationTabIndex) {
                    ImageViewCompat.setImageTintList((ImageView) tab.getCustomView().findViewById(R.id.iv), ColorStateList.valueOf(TabHostActivity.this.getResources().getColor(R.color.iconColor)));
                }
            }

            public void onTabReselected(TabLayout.Tab tab) {
                TabDefinition tabDefinition = TabHostActivity.this.tabs.get(tab.getPosition());
                if (tabDefinition.args == null || !tabDefinition.args.containsKey("context_user_first_name")) {
                    TabHostActivity.this.actionBarTitle.setText(tabDefinition.titleResource);
                    return;
                }
                String string = tabDefinition.args.getString("context_user_first_name");
                if (string != null) {
                    TabHostActivity.this.actionBarTitle.setText(String.format("%s's %s", new Object[]{string, TabHostActivity.this.getString(tabDefinition.titleResource)}));
                }
            }
        });
    }

    private void setTabIcons() {
        for (int i = 0; i < this.tabs.size(); i++) {
            TabDefinition tabDefinition = this.tabs.get(i);
            if (this.hasNotificationTab && i == this.notificationTabIndex) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.notif_tab, (ViewGroup) null);
                frameLayout.setLayoutParams(new TableLayout.LayoutParams(-1, -1));
                this.tabLayout.getTabAt(i).setCustomView((View) frameLayout);
                this.notificationBadgeView = (TextView) this.tabLayout.getTabAt(i).getCustomView().findViewById(R.id.badge);
            } else if (!this.hasNewsTab || i != this.newsTabIndex) {
                this.tabLayout.getTabAt(i).setIcon(tabDefinition.iconDrawable);
                if (!this.isTrainer.booleanValue() || this.isViewedByTrainer.booleanValue()) {
                    if (i == 0) {
                        this.actionBarTitle.setTextColor(getResources().getColor(R.color.white));
                        this.tabLayout.getTabAt(i).getIcon().setTint(getResources().getColor(R.color.white));
                        this.appBar.setBackgroundColor(0);
                    } else {
                        this.tabLayout.getTabAt(i).getIcon().setTint(getResources().getColor(R.color.homeIconColor));
                    }
                } else if (i == 0) {
                    this.tabLayout.getTabAt(i).getIcon().setTint(this.selectedIconColor);
                } else {
                    this.tabLayout.getTabAt(i).getIcon().setTint(this.defaultIconColor);
                }
            } else {
                FrameLayout frameLayout2 = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.news_tab, (ViewGroup) null);
                frameLayout2.setLayoutParams(new TableLayout.LayoutParams(-1, -1));
                this.tabLayout.getTabAt(i).setCustomView((View) frameLayout2);
                View customView = this.tabLayout.getTabAt(i).getCustomView();
                this.newsBadgeView = (TextView) customView.findViewById(R.id.badge);
                ImageViewCompat.setImageTintList((ImageView) customView.findViewById(R.id.iv), ColorStateList.valueOf((!this.isTrainer.booleanValue() || this.isViewedByTrainer.booleanValue()) ? this.homeIconColor : this.defaultIconColor));
            }
        }
    }

    /* access modifiers changed from: private */
    public void changeIconColor(int i) {
        for (int i2 = 0; i2 < this.tabs.size(); i2++) {
            if (i2 != this.newsTabIndex) {
                this.tabLayout.getTabAt(i2).getIcon().setTint(i);
            }
            if (i2 == this.newsTabIndex) {
                View customView = this.tabLayout.getTabAt(i2).getCustomView();
                this.newsBadgeView = (TextView) customView.findViewById(R.id.badge);
                ImageViewCompat.setImageTintList((ImageView) customView.findViewById(R.id.iv), ColorStateList.valueOf(i));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selectedTabIndex", this.selectedTabIndex);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.hasNotificationTab) {
            this.handler.post(this.fetchNewNotificationCountRunnable);
        }
        if (this.hasNewsTab) {
            this.handler.post(this.newNewsNotificationRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.hasNotificationTab) {
            this.handler.removeCallbacks(this.fetchNewNotificationCountRunnable);
        }
        if (this.hasNewsTab) {
            this.handler.removeCallbacks(this.newNewsNotificationRunnable);
        }
    }

    public void completedTracking() {
        StoryListFragment.hasNewDiaryEntries = true;
        if (this.isTrainer.booleanValue()) {
            this.tabLayout.getTabAt(1).select();
        } else {
            this.tabLayout.getTabAt(2).select();
        }
    }

    public int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    private void createNewNewsNotificationRunnable() {
        this.newNewsNotificationRunnable = new Runnable() {
            public void run() {
                new BaseHttpClient().get("/users/myself/new_stories_notification/ver2", (Map<String, Object>) null, new BaseResponseHandler() {
                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        return true;
                    }

                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        try {
                            if (!jSONObject.getBoolean("has_new_stories") || TabHostActivity.this.selectedTabIndex == TabHostActivity.this.getNewsTabIndex()) {
                                TabHostActivity.this.newsBadgeView.setVisibility(8);
                            } else {
                                StoryListFragment.hasNewNews = true;
                                TabHostActivity.this.newsBadgeView.setVisibility(0);
                            }
                            return true;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                TabHostActivity.this.handler.postDelayed(this, 180000);
            }
        };
    }

    private void createFetchNotificationCountRunnable() {
        this.fetchNewNotificationCountRunnable = new Runnable() {
            public void run() {
                new BaseHttpClient().get("/users/myself/new_notifications_count", (Map<String, Object>) null, new BaseResponseHandler() {
                    public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                        return true;
                    }

                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        try {
                            int i2 = jSONObject.getInt("count");
                            TabHostActivity.this.notificationBadgeView.setText(String.valueOf(i2));
                            if (i2 <= 0 || TabHostActivity.this.selectedTabIndex == TabHostActivity.this.notificationTabIndex) {
                                TabHostActivity.this.notificationBadgeView.setVisibility(8);
                                return true;
                            }
                            TabHostActivity.this.notificationBadgeView.setVisibility(0);
                            return true;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                TabHostActivity.this.handler.postDelayed(this, 180000);
            }
        };
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList();
        private final List<String> mFragmentTitleList = new ArrayList();

        public CharSequence getPageTitle(int i) {
            return null;
        }

        public Parcelable saveState() {
            return null;
        }

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        public Fragment getItem(int i) {
            return this.mFragmentList.get(i);
        }

        public int getCount() {
            return this.mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String str) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(str);
        }
    }
}
