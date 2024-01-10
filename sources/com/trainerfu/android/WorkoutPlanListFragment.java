package com.trainerfu.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.trainerfu.android.MorePlanOptionsFragment;
import com.trainerfu.android.WorkoutPlanWeekFragment;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.DateUtils;
import com.trainerfu.utils.Util;
import com.trainerfu.utils.ZipUtil;
import io.intercom.android.sdk.models.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WorkoutPlanListFragment extends Fragment implements WorkoutPlanWeekFragment.EventListener, View.OnClickListener, MorePlanOptionsFragment.EventListener {
    private static int CFPT_REQUEST_CODE = 19027;
    private static int EVENT_REQUEST_CODE = 4658;
    public static int copiedPlanId;
    /* access modifiers changed from: private */
    public JSONArray accessiblePlanIds = new JSONArray();
    /* access modifiers changed from: private */
    public PlanListAdapter adapter;
    /* access modifiers changed from: private */
    public int apiActivePlanIndex = 0;
    /* access modifiers changed from: private */
    public int apiCurrentPlanIndex = 0;
    private boolean blockViewOnNextLoad = false;
    /* access modifiers changed from: private */
    public String contextUserFirstName = "";
    /* access modifiers changed from: private */
    public int contextUserId = 0;
    /* access modifiers changed from: private */
    public int copiedWorkoutDay = 0;
    /* access modifiers changed from: private */
    public int currentPlanIndex = 0;
    /* access modifiers changed from: private */
    public boolean forClientPlan = true;
    /* access modifiers changed from: private */
    public int fromPlanId = 0;
    /* access modifiers changed from: private */
    public boolean hasPlanTemplates = false;
    private boolean isDetailsLoading = false;
    private long lastLoadTime = 0;
    private MenuItem leftArrow;
    private FloatingActionMenu menu;
    private int orderedPlanListId = 0;
    private int orderedPlanListLength = 0;
    private String orderedPlanListName = null;
    /* access modifiers changed from: private */
    public ViewPager pager;
    /* access modifiers changed from: private */
    public int pasteWorkoutDay = 0;
    /* access modifiers changed from: private */
    public Map<Integer, JSONObject> planMap = new HashMap();
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> plans;
    private MenuItem rightArrow;
    /* access modifiers changed from: private */
    public boolean showCurrentAndUpcoming = true;
    /* access modifiers changed from: private */
    public boolean showWebAppBanner = false;
    /* access modifiers changed from: private */
    public JSONObject summary;
    /* access modifiers changed from: private */
    public int toPlanId = 0;
    /* access modifiers changed from: private */
    public boolean viewedByClient = true;

    public void onCreate(Bundle bundle) {
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        boolean z = arguments.getBoolean("viewed_by_client");
        this.viewedByClient = z;
        if (!z) {
            this.forClientPlan = arguments.getBoolean("for_client_plan");
        }
        if (this.forClientPlan) {
            if (arguments.containsKey("context_user_id")) {
                this.contextUserId = arguments.getInt("context_user_id");
            }
            if (!this.viewedByClient) {
                this.contextUserFirstName = arguments.getString("context_user_first_name");
            }
        } else {
            this.orderedPlanListId = arguments.getInt("ordered_plan_list_id");
            this.orderedPlanListName = arguments.getString("ordered_plan_list_name");
            this.orderedPlanListLength = arguments.getInt("ordered_plan_list_length");
        }
        View inflate = layoutInflater.inflate(R.layout.workout_plan_list_view, viewGroup, false);
        this.adapter = new PlanListAdapter(getChildFragmentManager());
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.pager);
        this.pager = viewPager;
        if (!this.viewedByClient) {
            if (this.forClientPlan) {
                viewPager.setPadding(Util.sizeInPx(getActivity(), 20), 0, Util.sizeInPx(getActivity(), 20), 0);
            }
            if (!this.forClientPlan) {
                this.pager.setPadding(Util.sizeInPx(getActivity(), 20), 0, Util.sizeInPx(getActivity(), 20), 0);
            }
        }
        this.pager.setAdapter(this.adapter);
        this.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
            }
        });
        if (!this.viewedByClient) {
            this.pager.setPageTransformer(false, new ViewPager.PageTransformer() {
                public void transformPage(View view, float f) {
                    if (WorkoutPlanListFragment.this.pager.getCurrentItem() == 0) {
                        view.setTranslationX(-20.0f);
                    } else if (WorkoutPlanListFragment.this.pager.getCurrentItem() != WorkoutPlanListFragment.this.adapter.getCount() - 1) {
                        view.setTranslationX(0.0f);
                    } else if (!WorkoutPlanListFragment.this.forClientPlan || !WorkoutPlanListFragment.this.showCurrentAndUpcoming) {
                        view.setTranslationX(20.0f);
                    } else {
                        view.setTranslationX(20.0f);
                    }
                }
            });
        }
        return inflate;
    }

    public void onCreateOptionsMenu(Menu menu2, MenuInflater menuInflater) {
        this.leftArrow = menu2.findItem(R.id.left_arrow);
        this.rightArrow = menu2.findItem(R.id.right_arrow);
        setupOptionMenu();
        super.onCreateOptionsMenu(menu2, menuInflater);
    }

    /* access modifiers changed from: private */
    public void setupOptionMenu() {
        if (this.accessiblePlanIds.length() > 0) {
            this.leftArrow.setVisible(true);
            this.rightArrow.setVisible(true);
            if (this.apiActivePlanIndex != this.accessiblePlanIds.length() - 1) {
                this.rightArrow.setEnabled(true);
                menuIconColor(this.rightArrow, getResources().getColor(R.color.black));
            } else {
                this.rightArrow.setEnabled(false);
                menuIconColor(this.rightArrow, getResources().getColor(R.color.disabledIconColor));
            }
            if (this.apiActivePlanIndex != 0) {
                this.leftArrow.setEnabled(true);
                menuIconColor(this.leftArrow, getResources().getColor(R.color.black));
                return;
            }
            this.leftArrow.setEnabled(false);
            menuIconColor(this.leftArrow, getResources().getColor(R.color.disabledIconColor));
        }
    }

    /* access modifiers changed from: private */
    public void setActionBarTitle() {
        TextView textView = (TextView) getActivity().getWindow().getDecorView().findViewById(R.id.action_bar_title);
        int i = this.apiActivePlanIndex;
        int i2 = this.apiCurrentPlanIndex;
        if (i < i2) {
            textView.setText("Past Plan");
        } else if (i == i2) {
            textView.setText("Current Plan");
        } else {
            textView.setText("Upcoming Plan");
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.left_arrow) {
            loadPlanForClient(this.apiActivePlanIndex - 1);
        } else if (itemId == R.id.right_arrow) {
            loadPlanForClient(this.apiActivePlanIndex + 1);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void menuIconColor(MenuItem menuItem, int i) {
        Drawable icon = menuItem.getIcon();
        if (icon != null) {
            icon.mutate();
            icon.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        }
    }

    private void createMenuAnimation(final FloatingActionMenu floatingActionMenu) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleX", new float[]{1.0f, 0.2f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleY", new float[]{1.0f, 0.2f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleX", new float[]{0.2f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(floatingActionMenu.getMenuIconView(), "scaleY", new float[]{0.2f, 1.0f});
        ofFloat.setDuration(25);
        ofFloat2.setDuration(25);
        ofFloat3.setDuration(25);
        ofFloat4.setDuration(25);
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                floatingActionMenu.getMenuIconView().setImageResource(floatingActionMenu.isOpened() ? R.drawable.ic_menu_white_24dp : R.drawable.ic_clear_white_24dp);
            }
        });
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat3).with(ofFloat4).after(ofFloat);
        animatorSet.setInterpolator(new OvershootInterpolator(2.0f));
        floatingActionMenu.setIconToggleAnimatorSet(animatorSet);
    }

    public void onResume() {
        super.onResume();
        reload();
    }

    private void rebuildMenu() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                WorkoutPlanListFragment.this.rebuildMenuDelayed();
            }
        }, 100);
    }

    /* access modifiers changed from: private */
    public void rebuildMenuDelayed() {
        if (isAdded()) {
            this.menu.removeAllMenuButtons();
            if (!this.viewedByClient) {
                if (this.forClientPlan) {
                    if (this.showCurrentAndUpcoming) {
                        this.menu.addMenuButton(getGenericMenuButton(101, 0, R.drawable.ic_add_white_24dp, R.color.tintColor, R.string.addUpcomingPlan));
                        this.menu.addMenuButton(getGenericMenuButton(106, 0, R.drawable.ic_content_copy_white_24dp, R.color.tintColor, R.string.copyFromPlanTemplate));
                        if (this.currentPlanIndex > 0) {
                            this.menu.addMenuButton(getGenericMenuButton(102, 0, R.drawable.ic_event_note_white_24dp, R.color.darkGrayColor, R.string.seePastPlans));
                        }
                    } else {
                        this.menu.addMenuButton(getGenericMenuButton(103, 0, R.drawable.ic_event_note_white_24dp, R.color.tintColor, R.string.seeCurrentAndUpcoming));
                    }
                    int currentItem = this.pager.getCurrentItem();
                    if ((this.showCurrentAndUpcoming ? this.plans.size() - this.currentPlanIndex : this.currentPlanIndex) - currentItem > 1) {
                        this.menu.addMenuButton(getGenericMenuButton(104, 1, R.drawable.ic_chevron_right_white_24dp, R.color.darkGrayColor, R.string.next));
                    }
                    if (currentItem > 0) {
                        this.menu.addMenuButton(getGenericMenuButton(105, 1, R.drawable.ic_chevron_left_white_24dp, R.color.darkGrayColor, R.string.prev));
                        return;
                    }
                    return;
                }
                this.menu.addMenuButton(getGenericMenuButton(101, 0, R.drawable.ic_add_white_24dp, R.color.tintColor, R.string.addNextWeeksPlan));
                this.menu.addMenuButton(getGenericMenuButton(107, 0, R.drawable.ic_person_white_24dp, R.color.tintColor, R.string.copyTemplateToClients));
                this.menu.addMenuButton(getGenericMenuButton(108, 0, R.drawable.ic_people_white_24dp, R.color.tintColor, R.string.copyTemplateToGroups));
                int currentItem2 = this.pager.getCurrentItem();
                if (this.plans.size() - currentItem2 > 1) {
                    this.menu.addMenuButton(getGenericMenuButton(104, 1, R.drawable.ic_chevron_right_white_24dp, R.color.darkGrayColor, R.string.next));
                }
                if (currentItem2 > 0) {
                    this.menu.addMenuButton(getGenericMenuButton(105, 1, R.drawable.ic_chevron_left_white_24dp, R.color.darkGrayColor, R.string.prev));
                }
            }
        }
    }

    private FloatingActionButton getGenericMenuButton(int i, int i2, int i3, int i4, int i5) {
        FloatingActionButton floatingActionButton = new FloatingActionButton(getActivity());
        floatingActionButton.setTag(Integer.valueOf(i));
        floatingActionButton.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        floatingActionButton.setImageDrawable(ContextCompat.getDrawable(getActivity(), i3));
        floatingActionButton.setColorNormal(ContextCompat.getColor(getActivity(), i4));
        floatingActionButton.setColorPressed(ContextCompat.getColor(getActivity(), i4));
        floatingActionButton.setColorRipple(ContextCompat.getColor(getActivity(), R.color.lightGrayColor));
        floatingActionButton.setLabelText(getString(i5));
        floatingActionButton.setButtonSize(i2);
        floatingActionButton.setOnClickListener(this);
        return floatingActionButton;
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue == 101) {
            handleAddPlanClicked();
        } else if (intValue == 102) {
            handlePastClicked();
        } else if (intValue == 103) {
            handleCurrentAndUpcomingClicked();
        } else if (intValue == 104) {
            this.menu.close(false);
            ViewPager viewPager = this.pager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        } else if (intValue == 105) {
            this.menu.close(false);
            ViewPager viewPager2 = this.pager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        } else if (intValue == 106) {
            handleCopyFromPlanTemplate();
        } else if (intValue == 107) {
            handleCopyToClients();
        } else if (intValue == 108) {
            handleCopyToSegments();
        }
    }

    private void handlePastClicked() {
        this.showCurrentAndUpcoming = false;
        this.adapter.notifyDataSetChanged();
        this.pager.setCurrentItem(0);
    }

    private void handleCurrentAndUpcomingClicked() {
        this.showCurrentAndUpcoming = true;
        this.adapter.notifyDataSetChanged();
        this.pager.setCurrentItem(0);
    }

    private void handleCopyFromPlanTemplate() {
        if (!this.hasPlanTemplates) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.noPlanTemplatesFoundError).positiveText((int) R.string.Ok).show();
            return;
        }
        Intent intent = new Intent(getActivity(), CopyFromPlanTemplateActivity.class);
        intent.putExtra("task_type", CopyPlanTemplateTaskType.FOR_COPYING_A_TEMPLATE_TO_SINGLE_CLIENT.getMask());
        intent.putExtra("user_id", this.contextUserId);
        startActivityForResult(intent, CFPT_REQUEST_CODE);
    }

    private void handleCopyToClients() {
        Intent intent = new Intent(getActivity(), CopyFromPlanTemplateActivity.class);
        intent.putExtra("task_type", CopyPlanTemplateTaskType.FOR_COPYING_TO_MANY_CLIENTS.getMask());
        intent.putExtra("ordered_plan_list_id", this.orderedPlanListId);
        intent.putExtra("ordered_plan_list_name", this.orderedPlanListName);
        intent.putExtra("ordered_plan_list_length", this.orderedPlanListLength);
        startActivityForResult(intent, CFPT_REQUEST_CODE);
    }

    private void handleCopyToSegments() {
        Intent intent = new Intent(getActivity(), CopyFromPlanTemplateActivity.class);
        intent.putExtra("task_type", CopyPlanTemplateTaskType.FOR_COPYING_TO_SEGMENTS.getMask());
        intent.putExtra("ordered_plan_list_id", this.orderedPlanListId);
        intent.putExtra("ordered_plan_list_name", this.orderedPlanListName);
        intent.putExtra("ordered_plan_list_length", this.orderedPlanListLength);
        startActivityForResult(intent, CFPT_REQUEST_CODE);
    }

    private void handleAddPlanClicked() {
        HashMap hashMap;
        String str;
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
        if (this.forClientPlan) {
            hashMap = new HashMap();
            hashMap.put("program_type", 1);
            str = String.format("/users/%s/programs/new", new Object[]{Util.getUserIdForUrl(this.contextUserId)});
        } else {
            str = String.format("/ordered_program_lists/%s/items/new", new Object[]{Integer.valueOf(this.orderedPlanListId)});
            hashMap = null;
        }
        baseHttpClient.put(str, hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!WorkoutPlanListFragment.this.isAdded()) {
                    return true;
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    WorkoutPlanListFragment.this.plans.remove(WorkoutPlanListFragment.this.plans.size() - 1);
                    jSONObject2.put("distance_unit", "miles");
                    jSONObject2.put("drills", jSONArray);
                    jSONObject2.put(Part.NOTE_MESSAGE_STYLE, "");
                    jSONObject2.put("owned_by_trainer", "false");
                    jSONObject2.put("weight_unit", "lbs");
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("days");
                    for (int i2 = 0; i2 < 7; i2++) {
                        jSONArray2.put(i2, jSONObject2);
                    }
                    jSONObject3.put("days", jSONArray2);
                    WorkoutPlanListFragment.this.plans.add(jSONObject3);
                    WorkoutPlanListFragment.this.plans.add(new JSONObject());
                    boolean unused = WorkoutPlanListFragment.this.showCurrentAndUpcoming = true;
                    WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                    WorkoutPlanListFragment.this.pager.setCurrentItem((WorkoutPlanListFragment.this.plans.size() - WorkoutPlanListFragment.this.currentPlanIndex) - 2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.containsKey("programs")) {
            try {
                JSONArray jSONArray = new JSONArray(ZipUtil.decompress(bundle.getByteArray("programs")));
                this.plans = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.plans.add(jSONArray.getJSONObject(i));
                }
                this.forClientPlan = bundle.getBoolean("for_client_plan");
                this.viewedByClient = bundle.getBoolean("viewed_by_client");
                this.currentPlanIndex = bundle.getInt("current_program_index");
                this.showWebAppBanner = bundle.getBoolean("show_web_app_banner");
                this.showCurrentAndUpcoming = bundle.getBoolean("showing_current_and_upcoming");
                this.pager.setCurrentItem(bundle.getInt("current_item"));
                if (this.viewedByClient) {
                    this.apiCurrentPlanIndex = bundle.getInt("api_current_plan_index");
                    this.apiActivePlanIndex = bundle.getInt("api_active_plan_index");
                    this.accessiblePlanIds = new JSONArray(bundle.getString("accessible_plan_ids"));
                    this.lastLoadTime = bundle.getLong("last_load_time");
                }
                this.adapter.notifyDataSetChanged();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.plans != null) {
            bundle.putInt("current_program_index", this.currentPlanIndex);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.plans.size(); i++) {
                jSONArray.put(this.plans.get(i));
            }
            byte[] bArr = null;
            try {
                bArr = ZipUtil.compress(jSONArray.toString());
            } catch (IOException unused) {
            }
            bundle.putByteArray("programs", bArr);
            bundle.putInt("current_item", this.pager.getCurrentItem());
            bundle.putBoolean("show_web_app_banner", this.showWebAppBanner);
            bundle.putBoolean("showing_current_and_upcoming", this.showCurrentAndUpcoming);
            bundle.putBoolean("viewed_by_client", this.viewedByClient);
            bundle.putBoolean("for_client_plan", this.forClientPlan);
            if (this.viewedByClient) {
                bundle.putInt("api_current_plan_index", this.apiCurrentPlanIndex);
                bundle.putInt("api_active_plan_index", this.apiActivePlanIndex);
                bundle.putString("accessible_plan_ids", this.accessiblePlanIds.toString());
                bundle.putLong("last_load_time", this.lastLoadTime);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (isAdded() && i2 == -1 && i == CFPT_REQUEST_CODE) {
            this.blockViewOnNextLoad = true;
        }
    }

    public void reload() {
        reload(this.plans == null || this.blockViewOnNextLoad);
        this.blockViewOnNextLoad = false;
    }

    private void loadCurrentPlanForClient() {
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        String iSOFormattedDate = DateUtils.getISOFormattedDate(new Date(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        hashMap.put("date", iSOFormattedDate);
        baseHttpClient.get(String.format("users/%s/programs/current_program/details2", new Object[]{Util.getUserIdForUrl(this.contextUserId)}), hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!WorkoutPlanListFragment.this.isAdded()) {
                    return true;
                }
                ArrayList unused = WorkoutPlanListFragment.this.plans = new ArrayList();
                WorkoutPlanListFragment.this.plans.add(jSONObject);
                int unused2 = WorkoutPlanListFragment.this.currentPlanIndex = 0;
                WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                return true;
            }
        });
        baseHttpClient.get("/users/myself/summary", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                JSONObject unused = WorkoutPlanListFragment.this.summary = jSONObject;
                WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                if (!WorkoutPlanListFragment.this.isAdded()) {
                }
                return true;
            }
        });
    }

    private void loadPlanForClient(final int i) {
        try {
            int i2 = this.accessiblePlanIds.getInt(i);
            if (this.planMap.containsKey(Integer.valueOf(i2))) {
                ArrayList<JSONObject> arrayList = new ArrayList<>();
                this.plans = arrayList;
                arrayList.add(this.planMap.get(Integer.valueOf(i2)));
                this.apiActivePlanIndex = i;
                this.adapter.notifyDataSetChanged();
                setupOptionMenu();
                setActionBarTitle();
                return;
            }
            new BaseHttpClient().get(String.format("/programs/%s/details2", new Object[]{Integer.valueOf(i2)}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    if (!WorkoutPlanListFragment.this.isAdded()) {
                        return true;
                    }
                    try {
                        WorkoutPlanListFragment.this.planMap.put(Integer.valueOf(jSONObject.getInt("id")), jSONObject);
                        ArrayList unused = WorkoutPlanListFragment.this.plans = new ArrayList();
                        WorkoutPlanListFragment.this.plans.add(jSONObject);
                        int unused2 = WorkoutPlanListFragment.this.apiActivePlanIndex = i;
                        WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                        WorkoutPlanListFragment.this.setupOptionMenu();
                        WorkoutPlanListFragment.this.setActionBarTitle();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void reload(boolean z) {
        if (!this.forClientPlan) {
            new BaseHttpClient(Boolean.valueOf(z), getActivity()).get(String.format("/ordered_program_lists/%s/details", new Object[]{Integer.valueOf(this.orderedPlanListId)}), (Map<String, Object>) null, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    if (!WorkoutPlanListFragment.this.isAdded()) {
                        return true;
                    }
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("programs");
                        ArrayList unused = WorkoutPlanListFragment.this.plans = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            WorkoutPlanListFragment.this.plans.add(jSONArray.getJSONObject(i2));
                        }
                        WorkoutPlanListFragment.this.plans.add(new JSONObject());
                        int unused2 = WorkoutPlanListFragment.this.currentPlanIndex = 0;
                        WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } else if (this.viewedByClient) {
            setActionBarTitle();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.lastLoadTime;
            long j2 = elapsedRealtime - j;
            if (j == 0 || j2 > 3600000) {
                this.accessiblePlanIds = new JSONArray();
                this.apiCurrentPlanIndex = 0;
                this.apiActivePlanIndex = 0;
                this.planMap = new HashMap();
                this.plans = null;
                this.lastLoadTime = elapsedRealtime;
                this.adapter.notifyDataSetChanged();
                setActionBarTitle();
                loadCurrentPlanForClient();
                getAccessiblePlanIds();
            }
        } else {
            BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(z), getActivity());
            HashMap hashMap = new HashMap();
            hashMap.put("date", DateUtils.getISOFormattedDate(DateUtils.getTodaysDate()));
            hashMap.put("program_type", 1);
            baseHttpClient.get(String.format("/users/%s/programs/details", new Object[]{Util.getUserIdForUrl(this.contextUserId)}), hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    if (!WorkoutPlanListFragment.this.isAdded()) {
                        return true;
                    }
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("programs");
                        ArrayList unused = WorkoutPlanListFragment.this.plans = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            WorkoutPlanListFragment.this.plans.add(jSONArray.getJSONObject(i2));
                        }
                        WorkoutPlanListFragment.this.plans.add(new JSONObject());
                        boolean unused2 = WorkoutPlanListFragment.this.showWebAppBanner = true;
                        Date todaysDate = DateUtils.getTodaysDate();
                        int unused3 = WorkoutPlanListFragment.this.currentPlanIndex = 0;
                        for (int i3 = 0; i3 < WorkoutPlanListFragment.this.plans.size(); i3++) {
                            JSONObject jSONObject2 = (JSONObject) WorkoutPlanListFragment.this.plans.get(i3);
                            if (!jSONObject2.isNull("activation_date")) {
                                Date dateFromISOFormat = DateUtils.getDateFromISOFormat(jSONObject2.getString("activation_date"));
                                if (!dateFromISOFormat.before(todaysDate) && !dateFromISOFormat.equals(todaysDate)) {
                                    break;
                                }
                                int unused4 = WorkoutPlanListFragment.this.currentPlanIndex = i3;
                            }
                        }
                        WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            baseHttpClient.get("/ordered_program_lists/exist", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        boolean unused = WorkoutPlanListFragment.this.hasPlanTemplates = jSONObject.getBoolean("has_plan_templates");
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    private void getAccessiblePlanIds() {
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        String iSOFormattedDate = DateUtils.getISOFormattedDate(new Date(System.currentTimeMillis()));
        HashMap hashMap = new HashMap();
        hashMap.put("date", iSOFormattedDate);
        baseHttpClient.get(" /users/myself/accessible_plan_ids", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    int unused = WorkoutPlanListFragment.this.apiCurrentPlanIndex = jSONObject.getInt("current_program_index");
                    int unused2 = WorkoutPlanListFragment.this.apiActivePlanIndex = WorkoutPlanListFragment.this.apiCurrentPlanIndex;
                    JSONArray unused3 = WorkoutPlanListFragment.this.accessiblePlanIds = jSONObject.getJSONArray("program_ids");
                    WorkoutPlanListFragment.this.adapter.notifyDataSetChanged();
                    WorkoutPlanListFragment.this.getActivity().invalidateOptionsMenu();
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return true;
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    private JSONObject findPlan(int i) {
        int i2 = 0;
        while (i2 < this.plans.size()) {
            JSONObject jSONObject = this.plans.get(i2);
            try {
                if (jSONObject.getInt("id") == i) {
                    return jSONObject;
                }
                i2++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("plan does not exist");
    }

    private int findPlanIndex(int i) {
        int i2 = 0;
        while (i2 < this.plans.size()) {
            try {
                if (this.plans.get(i2).getInt("id") == i) {
                    return i2;
                }
                i2++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("plan does not exist");
    }

    @Subscribe
    public void handleTextEditedEvent(TextEditedEvent textEditedEvent) {
        try {
            if (textEditedEvent.requestCode == EVENT_REQUEST_CODE) {
                int i = new JSONObject(textEditedEvent.info).getInt("plan_id");
                String str = textEditedEvent.text;
                findPlan(i).put(Part.NOTE_MESSAGE_STYLE, str);
                this.adapter.notifyDataSetChanged();
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                HashMap hashMap = new HashMap();
                hashMap.put(Part.NOTE_MESSAGE_STYLE, str.trim());
                baseHttpClient.post(String.format("/programs/%s", new Object[]{String.valueOf(i)}), hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                        return true;
                    }
                });
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Subscribe
    public void handleDateSelectedEvent(DateSelectedEvent dateSelectedEvent) {
        if (dateSelectedEvent.requestCode == EVENT_REQUEST_CODE) {
            Date todaysDate = DateUtils.getTodaysDate();
            Date dateFromISOFormat = DateUtils.getDateFromISOFormat(dateSelectedEvent.date);
            if (dateFromISOFormat.before(todaysDate)) {
                new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.invalidPlanActivationDate).positiveText((int) R.string.Ok).show();
                return;
            }
            final int intValue = Integer.valueOf(dateSelectedEvent.info).intValue();
            String str = dateSelectedEvent.date;
            try {
                findPlan(intValue).put("activation_date", str);
                boolean equals = todaysDate.equals(dateFromISOFormat);
                ArrayList<JSONObject> arrayList = this.plans;
                arrayList.remove(arrayList.size() - 1);
                Collections.sort(this.plans, new Comparator<JSONObject>() {
                    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                        try {
                            if (jSONObject2.isNull("activation_date")) {
                                return -1;
                            }
                            if (jSONObject.isNull("activation_date")) {
                                return 1;
                            }
                            int compareTo = DateUtils.getDateFromISOFormat(jSONObject.getString("activation_date")).compareTo(DateUtils.getDateFromISOFormat(jSONObject2.getString("activation_date")));
                            if (compareTo == 0) {
                                if (jSONObject.getInt("id") == intValue) {
                                    return 1;
                                }
                                if (jSONObject2.getInt("id") == intValue) {
                                    return -1;
                                }
                            }
                            return compareTo;
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                this.plans.add(new JSONObject());
                int findPlanIndex = findPlanIndex(intValue);
                if (equals) {
                    this.currentPlanIndex = findPlanIndex;
                }
                this.adapter.notifyDataSetChanged();
                this.pager.setCurrentItem(findPlanIndex - this.currentPlanIndex);
                BaseHttpClient baseHttpClient = new BaseHttpClient();
                HashMap hashMap = new HashMap();
                hashMap.put("activation_date", str);
                baseHttpClient.post(String.format("/programs/%s/activation_date", new Object[]{String.valueOf(intValue)}), hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        return true;
                    }
                });
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void editNoteClicked(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("plan_id", i);
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            if (str == null) {
                str = "";
            }
            bundle.putString("text", str);
            bundle.putString(ViewHierarchyConstants.HINT_KEY, getString(R.string.note));
            bundle.putInt("request_code", EVENT_REQUEST_CODE);
            EditTextDialogFragment editTextDialogFragment = new EditTextDialogFragment();
            editTextDialogFragment.setArguments(bundle);
            editTextDialogFragment.show(getFragmentManager(), "enf");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStartDateClicked(int i, Date date) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("request_code", EVENT_REQUEST_CODE);
        bundle.putString("info", String.valueOf(i));
        if (date != null) {
            bundle.putString("date", DateUtils.getISOFormattedDate(date));
        } else {
            bundle.putString("date", DateUtils.getISOFormattedDate(DateUtils.addDays(Calendar.getInstance(), DateUtils.getTodaysDate(), 1)));
        }
        datePickerFragment.setArguments(bundle);
        datePickerFragment.show(getFragmentManager(), "dpf");
    }

    public void copyPlanClicked(int i) {
        copiedPlanId = i;
        Util.showToast(getActivity(), R.string.Copied);
    }

    public void pastePlanClicked(final int i) {
        int i2 = copiedPlanId;
        if (i2 == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.noPlanCopiedError).positiveText((int) R.string.Ok).show();
        } else if (i2 == i) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.cantPastePlanToSelfError).positiveText((int) R.string.Ok).show();
        } else {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Warning).content((int) R.string.replacePlanWarning).positiveText((CharSequence) getString(R.string.Yes)).negativeText((CharSequence) getString(R.string.No)).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    BaseHttpClient baseHttpClient = new BaseHttpClient(true, WorkoutPlanListFragment.this.getActivity());
                    HashMap hashMap = new HashMap();
                    hashMap.put("from_program_id", Integer.valueOf(WorkoutPlanListFragment.copiedPlanId));
                    hashMap.put("to_program_id", Integer.valueOf(i));
                    baseHttpClient.put("/copy_program_task", hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                            if (!WorkoutPlanListFragment.this.isAdded()) {
                                return true;
                            }
                            WorkoutPlanListFragment.this.reload();
                            return true;
                        }
                    });
                }
            }).build().show();
        }
    }

    public void deletePlanClicked(int i) {
        int currentItem = this.pager.getCurrentItem();
        this.plans.remove(findPlanIndex(i));
        if (!this.showCurrentAndUpcoming) {
            int i2 = this.currentPlanIndex - 1;
            this.currentPlanIndex = i2;
            if (i2 == 0) {
                this.showCurrentAndUpcoming = true;
            }
            this.adapter.notifyDataSetChanged();
            if (this.currentPlanIndex != 0) {
                this.pager.setCurrentItem(currentItem - 1);
            }
        } else {
            this.adapter.notifyDataSetChanged();
            this.pager.setCurrentItem(currentItem - 1);
        }
        Util.showToast(getActivity(), R.string.Deleted);
        new BaseHttpClient().delete(String.format("/programs/%s", new Object[]{Integer.valueOf(i)}), new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }

    public void emailPlanClicked(int i) {
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("program_id", Integer.valueOf(i));
        hashMap.put("to_user_id", Integer.valueOf(this.contextUserId));
        hashMap.put("send_to_self", false);
        baseHttpClient.put("email_program_task2", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                if (!WorkoutPlanListFragment.this.isAdded()) {
                    return true;
                }
                try {
                    String string = jSONObject.getString("email");
                    String replaceAll = jSONObject.getString("message").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "").replace("\r", "").replaceAll("<style>.*?</style>", "");
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/html");
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
                    intent.putExtra("android.intent.extra.SUBJECT", WorkoutPlanListFragment.this.getString(R.string.planEmailSubject));
                    intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(replaceAll));
                    WorkoutPlanListFragment.this.startActivity(Intent.createChooser(intent, "Send Email"));
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void addUpcomingPlanClicked() {
        handleAddPlanClicked();
    }

    public void copyFromPlanTemplateClicked() {
        handleCopyFromPlanTemplate();
    }

    public void togglePlansClicked() {
        if (this.showCurrentAndUpcoming) {
            handlePastClicked();
        } else {
            handleCurrentAndUpcomingClicked();
        }
    }

    public void copyTemplateToClientsClicked() {
        handleCopyToClients();
    }

    public void copyTemplateToGroupsClicked() {
        handleCopyToSegments();
    }

    public void copyWorkoutClicked(int i, int i2) {
        this.copiedWorkoutDay = i;
        this.fromPlanId = i2;
        Util.showToast(getActivity(), R.string.workoutCopied);
    }

    public void pasteWorkoutClicked(int i, int i2) {
        this.pasteWorkoutDay = i;
        this.toPlanId = i2;
        int i3 = this.copiedWorkoutDay;
        if (i3 == 0) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.noWorkoutCopiedError).positiveText((int) R.string.Ok).show();
        } else if (i3 == i && this.fromPlanId == i2) {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Error).content((int) R.string.cantPasteWorkoutToSelfError).positiveText((int) R.string.Ok).show();
        } else {
            new MaterialDialog.Builder(getActivity()).title((int) R.string.Warning).content((int) R.string.replaceWorkoutWarning).positiveText((CharSequence) getString(R.string.Yes)).negativeText((CharSequence) getString(R.string.No)).onPositive(new MaterialDialog.SingleButtonCallback() {
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    BaseHttpClient baseHttpClient = new BaseHttpClient(true, WorkoutPlanListFragment.this.getActivity());
                    HashMap hashMap = new HashMap();
                    hashMap.put("from_program_id", Integer.valueOf(WorkoutPlanListFragment.this.fromPlanId));
                    hashMap.put("from_day", Integer.valueOf(WorkoutPlanListFragment.this.copiedWorkoutDay));
                    hashMap.put("to_program_id", Integer.valueOf(WorkoutPlanListFragment.this.toPlanId));
                    hashMap.put("to_day", Integer.valueOf(WorkoutPlanListFragment.this.pasteWorkoutDay));
                    baseHttpClient.put("/copy_program_day_task", hashMap, new BaseResponseHandler() {
                        public boolean handleSuccess(int i, Header[] headerArr, JSONArray jSONArray) {
                            if (!WorkoutPlanListFragment.this.isAdded()) {
                                return true;
                            }
                            WorkoutPlanListFragment.this.reload();
                            return true;
                        }
                    });
                }
            }).build().show();
        }
    }

    public class PlanListAdapter extends FragmentStatePagerAdapter {
        public int getItemPosition(Object obj) {
            return -2;
        }

        public PlanListAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            if (WorkoutPlanListFragment.this.plans == null) {
                return 0;
            }
            if (WorkoutPlanListFragment.this.showCurrentAndUpcoming) {
                return WorkoutPlanListFragment.this.plans.size() - WorkoutPlanListFragment.this.currentPlanIndex;
            }
            return WorkoutPlanListFragment.this.currentPlanIndex + 1;
        }

        public Fragment getItem(int i) {
            WorkoutPlanStage workoutPlanStage;
            WorkoutPlanStage workoutPlanStage2;
            if (WorkoutPlanListFragment.this.viewedByClient) {
                WorkoutPlanWeekFragment workoutPlanWeekFragment = new WorkoutPlanWeekFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("context_user_id", WorkoutPlanListFragment.this.contextUserId);
                bundle.putBoolean("for_client_plan", WorkoutPlanListFragment.this.forClientPlan);
                bundle.putBoolean("viewed_by_client", WorkoutPlanListFragment.this.viewedByClient);
                bundle.putString("plan", ((JSONObject) WorkoutPlanListFragment.this.plans.get(i)).toString());
                if (WorkoutPlanListFragment.this.apiActivePlanIndex < WorkoutPlanListFragment.this.apiCurrentPlanIndex) {
                    workoutPlanStage2 = WorkoutPlanStage.PAST_PLAN;
                } else if (WorkoutPlanListFragment.this.apiActivePlanIndex == WorkoutPlanListFragment.this.apiCurrentPlanIndex) {
                    workoutPlanStage2 = WorkoutPlanStage.CURRENT_PLAN;
                } else {
                    workoutPlanStage2 = WorkoutPlanStage.UPCOMING_PLAN;
                }
                bundle.putInt("plan_stage", workoutPlanStage2.getMask());
                if (workoutPlanStage2 == WorkoutPlanStage.CURRENT_PLAN && WorkoutPlanListFragment.this.summary != null) {
                    bundle.putString("summary", WorkoutPlanListFragment.this.summary.toString());
                }
                workoutPlanWeekFragment.setArguments(bundle);
                return workoutPlanWeekFragment;
            }
            boolean z = true;
            if (i < getCount() - 1) {
                WorkoutPlanWeekFragment workoutPlanWeekFragment2 = new WorkoutPlanWeekFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("context_user_id", WorkoutPlanListFragment.this.contextUserId);
                bundle2.putBoolean("for_client_plan", WorkoutPlanListFragment.this.forClientPlan);
                bundle2.putBoolean("viewed_by_client", WorkoutPlanListFragment.this.viewedByClient);
                if (WorkoutPlanListFragment.this.forClientPlan) {
                    bundle2.putString("context_user_first_name", WorkoutPlanListFragment.this.contextUserFirstName);
                    if (!WorkoutPlanListFragment.this.showCurrentAndUpcoming) {
                        workoutPlanStage = WorkoutPlanStage.PAST_PLAN;
                    } else if (i == 0) {
                        workoutPlanStage = WorkoutPlanStage.CURRENT_PLAN;
                    } else {
                        workoutPlanStage = WorkoutPlanStage.UPCOMING_PLAN;
                    }
                    bundle2.putInt("plan_stage", workoutPlanStage.getMask());
                    if (workoutPlanStage != WorkoutPlanStage.CURRENT_PLAN || !WorkoutPlanListFragment.this.showWebAppBanner) {
                        z = false;
                    }
                    bundle2.putBoolean("show_web_app_banner", z);
                    if (workoutPlanStage == WorkoutPlanStage.PAST_PLAN) {
                        bundle2.putString("plan", ((JSONObject) WorkoutPlanListFragment.this.plans.get(i)).toString());
                    } else {
                        bundle2.putString("plan", ((JSONObject) WorkoutPlanListFragment.this.plans.get(WorkoutPlanListFragment.this.currentPlanIndex + i)).toString());
                    }
                } else {
                    bundle2.putString("plan", ((JSONObject) WorkoutPlanListFragment.this.plans.get(i)).toString());
                    bundle2.putInt("week_num", i + 1);
                }
                workoutPlanWeekFragment2.setArguments(bundle2);
                return workoutPlanWeekFragment2;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("show_current_and_upcoming", WorkoutPlanListFragment.this.showCurrentAndUpcoming);
            bundle3.putBoolean("for_client_plan", WorkoutPlanListFragment.this.forClientPlan);
            bundle3.putInt("current_plan_index", WorkoutPlanListFragment.this.currentPlanIndex);
            MorePlanOptionsFragment morePlanOptionsFragment = new MorePlanOptionsFragment();
            morePlanOptionsFragment.setArguments(bundle3);
            return morePlanOptionsFragment;
        }
    }
}
