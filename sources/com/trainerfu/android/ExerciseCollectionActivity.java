package com.trainerfu.android;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.trainerfu.android.AddOrUpdateExerciseFragment;
import com.trainerfu.android.ExerciseCollectionFragment;
import com.trainerfu.android.YTSearchFragment;
import com.trainerfu.utils.Constants;
import com.trainerfu.utils.ExerciseDataset;
import java.util.ArrayList;
import org.json.JSONObject;

public class ExerciseCollectionActivity extends BaseActivity implements ExerciseCollectionFragment.EventListener, AddOrUpdateExerciseFragment.EventListener, YTSearchFragment.EventListener, FragmentManager.OnBackStackChangedListener, ExerciseDataset.ExerciseDatasetFetchedResponder {
    private ActionBar actionBar;
    private boolean forSelection = true;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    private String searchQuery;
    /* access modifiers changed from: private */
    public SearchView searchView;

    public ExerciseCollectionActivity() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ExerciseCollectionFragment exerciseCollectionFragment = new ExerciseCollectionFragment();
            Bundle extras = getIntent().getExtras();
            Bundle bundle2 = new Bundle();
            if (extras != null) {
                if (extras.containsKey("allow_add_exercise")) {
                    bundle2.putBoolean("allow_add_exercise", extras.getBoolean("allow_add_exercise"));
                    if (!extras.getBoolean("allow_add_exercise")) {
                        getSupportActionBar().setTitle((CharSequence) "Add Exercise");
                    } else {
                        getSupportActionBar().setTitle((CharSequence) "Exercises");
                    }
                }
                if (extras.containsKey("for_selection")) {
                    this.forSelection = extras.getBoolean("for_selection");
                }
            }
            bundle2.putBoolean("for_selection", this.forSelection);
            exerciseCollectionFragment.setArguments(bundle2);
            getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) exerciseCollectionFragment, "ecf").commit();
        }
        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView searchView2 = (SearchView) menu.findItem(R.id.action_search).getActionView();
        this.searchView = searchView2;
        searchView2.setMaxWidth(Integer.MAX_VALUE);
        this.searchView.setSearchableInfo(((SearchManager) getSystemService(FirebaseAnalytics.Event.SEARCH)).getSearchableInfo(getComponentName()));
        this.searchView.setFocusable(false);
        this.searchView.setIconified(false);
        this.searchView.requestFocusFromTouch();
        this.searchView.requestFocus();
        SearchView searchView3 = this.searchView;
        searchView3.setImeOptions(searchView3.getImeOptions() | 268435456);
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return true;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
                r0 = (com.trainerfu.android.YTSearchFragment) r5.this$0.getSupportFragmentManager().findFragmentByTag("ytf");
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onQueryTextChange(final java.lang.String r6) {
                /*
                    r5 = this;
                    com.trainerfu.android.ExerciseCollectionActivity r0 = com.trainerfu.android.ExerciseCollectionActivity.this
                    androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
                    int r0 = r0.getBackStackEntryCount()
                    if (r0 != 0) goto L_0x0020
                    com.trainerfu.android.ExerciseCollectionActivity r0 = com.trainerfu.android.ExerciseCollectionActivity.this
                    androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
                    java.lang.String r1 = "ecf"
                    androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
                    com.trainerfu.android.ExerciseCollectionFragment r0 = (com.trainerfu.android.ExerciseCollectionFragment) r0
                    if (r0 == 0) goto L_0x0043
                    r0.filter(r6)
                    goto L_0x0043
                L_0x0020:
                    r1 = 2
                    if (r0 != r1) goto L_0x0043
                    com.trainerfu.android.ExerciseCollectionActivity r0 = com.trainerfu.android.ExerciseCollectionActivity.this
                    androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
                    java.lang.String r1 = "ytf"
                    androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
                    com.trainerfu.android.YTSearchFragment r0 = (com.trainerfu.android.YTSearchFragment) r0
                    if (r0 == 0) goto L_0x0043
                    com.trainerfu.android.ExerciseCollectionActivity r1 = com.trainerfu.android.ExerciseCollectionActivity.this
                    android.os.Handler r1 = r1.handler
                    com.trainerfu.android.ExerciseCollectionActivity$1$1 r2 = new com.trainerfu.android.ExerciseCollectionActivity$1$1
                    r2.<init>(r0, r6)
                    r3 = 600(0x258, double:2.964E-321)
                    r1.postDelayed(r2, r3)
                L_0x0043:
                    r6 = 1
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.trainerfu.android.ExerciseCollectionActivity.AnonymousClass1.onQueryTextChange(java.lang.String):boolean");
            }
        });
        styleSearchView(this.searchView);
        this.searchView.setQuery(this.searchQuery, false);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayOptions(8);
            supportActionBar.setDisplayShowTitleEnabled(true);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("search_query", this.searchQuery);
        bundle.putBoolean("for_selection", this.forSelection);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            this.searchQuery = bundle.getString("search_query");
            this.forSelection = bundle.getBoolean("for_selection");
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            View currentFocus = getCurrentFocus();
            if (currentFocus instanceof EditText) {
                Rect rect = new Rect();
                currentFocus.getGlobalVisibleRect(rect);
                if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                    currentFocus.clearFocus();
                    ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void styleSearchView(SearchView searchView2) {
        try {
            int identifier = searchView2.getContext().getResources().getIdentifier("android:id/search_src_text", (String) null, (String) null);
            if (identifier > 0) {
                EditText editText = (EditText) searchView2.findViewById(identifier);
                editText.setHintTextColor(ContextCompat.getColor(this, R.color.lightBlack));
                editText.setTextColor(ContextCompat.getColor(this, R.color.black));
                editText.setPadding(0, 0, 0, 0);
            }
            int identifier2 = searchView2.getContext().getResources().getIdentifier("android:id/search_plate", (String) null, (String) null);
            if (identifier2 > 0) {
                searchView2.findViewById(identifier2).setPadding(0, 0, 0, 0);
                searchView2.findViewById(identifier2).getBackground().mutate().setColorFilter(Color.rgb(0, 0, 0), PorterDuff.Mode.SRC_ATOP);
                ((ImageView) searchView2.findViewById(getResources().getIdentifier("android:id/search_mag_icon", (String) null, (String) null))).setImageDrawable(getResources().getDrawable(R.drawable.ic_search_black_24dp));
            }
            int identifier3 = getResources().getIdentifier("android:id/search_button", (String) null, (String) null);
            if (identifier3 > 0) {
                ((ImageView) searchView2.findViewById(identifier3)).setImageResource(R.drawable.ic_search_black_24dp);
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
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.append(getString(R.string.exercise_search_description));
            Drawable drawable = getResources().getDrawable(R.drawable.ic_search_black_24dp);
            int floatValue = (int) (((double) ((Float) cls.getMethod("getTextSize", new Class[0]).invoke(findViewById, new Object[0])).floatValue()) * 1.25d);
            drawable.setBounds(0, 0, floatValue, floatValue);
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            cls.getMethod("setHint", new Class[]{CharSequence.class}).invoke(findViewById, new Object[]{spannableStringBuilder});
            searchView2.setIconifiedByDefault(true);
        } catch (Exception unused) {
        }
    }

    public void exerciseSelected(JSONObject jSONObject) {
        if (this.forSelection) {
            sendResult(jSONObject);
            return;
        }
        AddOrUpdateExerciseFragment addOrUpdateExerciseFragment = new AddOrUpdateExerciseFragment();
        Bundle bundle = new Bundle();
        bundle.putString("exercise", jSONObject.toString());
        bundle.putBoolean("for_adding", false);
        addOrUpdateExerciseFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) addOrUpdateExerciseFragment, "aef").addToBackStack((String) null).commit();
    }

    public void createNewExerciseClicked() {
        ActionBar supportActionBar = getSupportActionBar();
        AddOrUpdateExerciseFragment addOrUpdateExerciseFragment = new AddOrUpdateExerciseFragment();
        supportActionBar.setTitle((CharSequence) getString(R.string.addExercise));
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) addOrUpdateExerciseFragment, "aef").addToBackStack((String) null).commit();
    }

    public void tagsClicked() {
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) new AddOrUpdateTagsFragment(), "tf").addToBackStack((String) null).commit();
    }

    public void onBackStackChanged() {
        setupActionbar();
        styleSearchView(this.searchView);
    }

    private void setupActionbar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackEntryCount == 0) {
                supportActionBar.setDisplayShowTitleEnabled(true);
                getSupportActionBar().setTitle((CharSequence) "Exercises");
                this.searchView.setVisibility(0);
                this.searchView.setQueryHint(getString(R.string.exercise_search_hint));
            } else if (backStackEntryCount == 1) {
                if (this.forSelection) {
                    supportActionBar.setTitle((CharSequence) getString(R.string.createNewExerciseTitle));
                } else {
                    supportActionBar.setTitle((CharSequence) getString(R.string.editExercise));
                }
                supportActionBar.setDisplayShowTitleEnabled(true);
                this.searchView.setVisibility(8);
                this.searchView.setQuery("", false);
            } else if (backStackEntryCount != 2) {
            } else {
                if (getSupportFragmentManager().findFragmentByTag("tf") != null) {
                    supportActionBar.setDisplayShowTitleEnabled(true);
                    this.searchView.setVisibility(8);
                    supportActionBar.setTitle((CharSequence) "Tags");
                    return;
                }
                supportActionBar.setDisplayShowTitleEnabled(false);
                this.searchView.setVisibility(0);
                this.searchView.setQueryHint(getString(R.string.yt_search_hint));
            }
        }
    }

    public void exerciseAdded(JSONObject jSONObject) {
        refreshExerciseDataset();
        if (this.forSelection) {
            sendResult(jSONObject);
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }

    public void exerciseUpdated() {
        refreshExerciseDataset();
        getSupportFragmentManager().popBackStack();
    }

    public void exerciseAddOrUpdateCancelled() {
        getSupportFragmentManager().popBackStack();
    }

    public void findYTVideoClicked(String str) {
        YTSearchFragment yTSearchFragment = new YTSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("current_st", str);
        yTSearchFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) yTSearchFragment, "ytf").addToBackStack((String) null).commit();
        if (str.length() == 0) {
            this.searchView.setFocusable(true);
            this.searchView.setIconified(false);
            this.searchView.requestFocusFromTouch();
        } else {
            this.searchView.setQuery(str, false);
        }
        this.searchQuery = str;
    }

    private void refreshExerciseDataset() {
        ExerciseDataset.getInstance().fetchRecentExercises(this);
        ExerciseDataset.getInstance().fetchAllExercises(this);
    }

    private void sendResult(JSONObject jSONObject) {
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent();
        intent.putExtra("exercise", jSONObject.toString());
        if (extras != null && extras.containsKey("info")) {
            intent.putExtra("info", extras.getBundle("info"));
        }
        setResult(-1, intent);
        finish();
    }

    public void ytVideoSelected(String str, String str2, String str3) {
        getSupportFragmentManager().popBackStack();
        AddOrUpdateExerciseFragment addOrUpdateExerciseFragment = (AddOrUpdateExerciseFragment) getSupportFragmentManager().findFragmentByTag("aef");
        if (addOrUpdateExerciseFragment != null) {
            addOrUpdateExerciseFragment.ytVideoSelected(str, str2, str3);
        }
    }

    public void ytThumbnailClicked(JSONObject jSONObject) {
        DrillVideoFragment drillVideoFragment = new DrillVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DRILL, jSONObject.toString());
        bundle.putBoolean("custom_action_bar", true);
        drillVideoFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(16908290, (Fragment) drillVideoFragment, "dvf").addToBackStack((String) null).commit();
        this.searchView.setVisibility(8);
    }

    public void allExercisesFetched(ArrayList<JSONObject> arrayList) {
        if (!this.forSelection) {
            rebindExerciseCollection();
        }
    }

    public void recentExercisesFetched(ArrayList<JSONObject> arrayList) {
        if (!this.forSelection) {
            rebindExerciseCollection();
        }
    }

    private void rebindExerciseCollection() {
        ExerciseCollectionFragment exerciseCollectionFragment = (ExerciseCollectionFragment) getSupportFragmentManager().findFragmentByTag("ecf");
        if (exerciseCollectionFragment != null) {
            exerciseCollectionFragment.rebindExerciseCollection();
        }
    }
}
