package com.trainerfu.android;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.trainerfu.android.PlanTemplateListFragment;
import org.json.JSONObject;

public class PlanTemplateListActivity extends BaseActivity implements PlanTemplateListFragment.EventListener {
    private SearchView searchView;

    public PlanTemplateListActivity() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            PlanTemplateListFragment planTemplateListFragment = new PlanTemplateListFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("for_selection", getIntent().getExtras().getBoolean("for_selection"));
            planTemplateListFragment.setArguments(bundle2);
            getFragmentManager().beginTransaction().add(16908290, planTemplateListFragment, "ptlf").commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView searchView2 = (SearchView) menu.findItem(R.id.action_search).getActionView();
        this.searchView = searchView2;
        searchView2.setMaxWidth(Integer.MAX_VALUE);
        this.searchView.setSearchableInfo(((SearchManager) getSystemService(FirebaseAnalytics.Event.SEARCH)).getSearchableInfo(getComponentName()));
        this.searchView.setFocusable(false);
        this.searchView.setIconified(true);
        this.searchView.requestFocusFromTouch();
        SearchView searchView3 = this.searchView;
        searchView3.setImeOptions(searchView3.getImeOptions() | 268435456);
        SearchView searchView4 = this.searchView;
        searchView4.setImeOptions(searchView4.getImeOptions() | 268435456);
        final PlanTemplateListFragment planTemplateListFragment = (PlanTemplateListFragment) getFragmentManager().findFragmentByTag("ptlf");
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String str) {
                return true;
            }

            public boolean onQueryTextChange(String str) {
                planTemplateListFragment.searchPlanList(str);
                return false;
            }
        });
        styleSearchView(this.searchView);
        return super.onCreateOptionsMenu(menu);
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
            spannableStringBuilder.append(getString(R.string.searchPlanTemplate));
            Drawable drawable = getResources().getDrawable(R.drawable.ic_search_black_24dp);
            int floatValue = (int) (((double) ((Float) cls.getMethod("getTextSize", new Class[0]).invoke(findViewById, new Object[0])).floatValue()) * 1.25d);
            drawable.setBounds(0, 0, floatValue, floatValue);
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            cls.getMethod("setHint", new Class[]{CharSequence.class}).invoke(findViewById, new Object[]{spannableStringBuilder});
            searchView2.setIconifiedByDefault(true);
        } catch (Exception unused) {
        }
    }

    public void planTemplateSelected(JSONObject jSONObject) {
        if (Boolean.valueOf(getIntent().getExtras().getBoolean("for_selection")).booleanValue()) {
            Intent intent = new Intent();
            intent.putExtra("template", jSONObject.toString());
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery("", false);
        }
    }
}
