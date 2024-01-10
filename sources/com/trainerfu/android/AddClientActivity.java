package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.afollestad.materialdialogs.MaterialDialog;
import com.facebook.internal.NativeProtocol;
import com.google.android.material.textfield.TextInputLayout;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddClientActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public static int SS_REQUEST_CODE = 23642;
    private ActionBar actionBar;
    /* access modifiers changed from: private */
    public boolean isSaving;
    private JSONArray segments = null;
    /* access modifiers changed from: private */
    public ArrayList<Integer> selectedSegmentIds = new ArrayList<>();
    /* access modifiers changed from: private */
    public int selectedTrainerId = -1;
    private Toolbar toolbar;
    /* access modifiers changed from: private */
    public JSONArray trainers = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            if (intent.hasExtra("trainers")) {
                this.trainers = new JSONArray(intent.getStringExtra("trainers"));
            }
            if (intent.hasExtra("segments")) {
                this.segments = new JSONArray(intent.getStringExtra("segments"));
            }
            if (intent.hasExtra("selected_trainer_id")) {
                this.selectedTrainerId = intent.getIntExtra("selected_trainer_id", -1);
            }
            setContentView((int) R.layout.add_client_view);
            findViewById(R.id.addClientBtn).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AddClientActivity.this.addClient();
                }
            });
            JSONArray jSONArray = this.trainers;
            if (jSONArray != null && jSONArray.length() >= 1) {
                findViewById(R.id.ts_wrapper).setVisibility(0);
                String[] strArr = new String[this.trainers.length()];
                int i = 0;
                while (i < this.trainers.length()) {
                    try {
                        JSONObject jSONObject = this.trainers.getJSONObject(i);
                        strArr[i] = String.format("%s %s", new Object[]{jSONObject.getString("first_name"), jSONObject.getString("last_name")});
                        i++;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                final Spinner spinner = (Spinner) findViewById(R.id.primaryTrainerSpinner);
                spinner.setAdapter(new ArrayAdapter(this, R.layout.spinner_item, strArr));
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        try {
                            int unused = AddClientActivity.this.selectedTrainerId = AddClientActivity.this.trainers.getJSONObject(i).getInt("id");
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                findViewById(R.id.trainer_selector).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        spinner.performClick();
                    }
                });
            }
            if (this.segments != null) {
                int i2 = 0;
                while (true) {
                    try {
                        if (i2 >= this.segments.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = this.segments.getJSONObject(i2);
                        if (jSONObject2.getBoolean("is_default")) {
                            this.selectedSegmentIds.add(Integer.valueOf(jSONObject2.getInt("id")));
                            break;
                        }
                        i2++;
                    } catch (JSONException e2) {
                        throw new RuntimeException(e2);
                    }
                }
                if (this.segments.length() >= 1) {
                    View findViewById = findViewById(R.id.ss_wrapper);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(AddClientActivity.this, RNHostActivity.class);
                            intent.putExtra("entryRoute", RNEntryRoute.SELECT_GROUPS.getMask());
                            Bundle bundle = new Bundle();
                            bundle.putString("selected", AddClientActivity.this.selectedSegmentIds.size() > 0 ? TextUtils.join("-", AddClientActivity.this.selectedSegmentIds) : "");
                            intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
                            AddClientActivity.this.startActivityForResult(intent, AddClientActivity.SS_REQUEST_CODE);
                        }
                    });
                }
            }
            if (this.trainers.length() == 0 && this.segments.length() == 0) {
                ((EditText) findViewById(R.id.emailField)).setBackgroundColor(0);
                TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.input_layout_email);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textInputLayout.getLayoutParams();
                layoutParams.setMargins(Util.sizeInPx(this, 3), Util.sizeInPx(this, 20), Util.sizeInPx(this, -4), Util.sizeInPx(this, -8));
                textInputLayout.setLayoutParams(layoutParams);
            }
            if (bundle != null) {
                this.selectedSegmentIds = bundle.getIntegerArrayList("selected_segment_ids");
                this.selectedTrainerId = bundle.getInt("selected_trainer_id");
            }
            bind();
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mark_done, menu);
        menu.findItem(R.id.post_item).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.post_item) {
            addClient();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selected_trainer_id", this.selectedTrainerId);
        bundle.putIntegerArrayList("selected_segment_ids", this.selectedSegmentIds);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == SS_REQUEST_CODE) {
                int[] intArrayExtra = intent.getIntArrayExtra("segmentIds");
                this.selectedSegmentIds.clear();
                for (int valueOf : intArrayExtra) {
                    this.selectedSegmentIds.add(Integer.valueOf(valueOf));
                }
            }
            bind();
        }
    }

    private void bind() {
        JSONArray jSONArray = this.trainers;
        if (jSONArray != null && jSONArray.length() >= 1) {
            int i = 0;
            int i2 = 0;
            while (i < this.trainers.length()) {
                try {
                    if (this.trainers.getJSONObject(i).getInt("id") == this.selectedTrainerId) {
                        i2 = i;
                    }
                    i++;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            ((Spinner) findViewById(R.id.primaryTrainerSpinner)).setSelection(i2);
        }
        if (this.segments.length() >= 1) {
            TextView textView = (TextView) findViewById(R.id.ss_detail_view);
            if (this.selectedSegmentIds.size() == 1) {
                textView.setText(getString(R.string.OneGroup));
                return;
            }
            textView.setText(String.format(getString(R.string.NGroups), new Object[]{String.valueOf(this.selectedSegmentIds.size())}));
        }
    }

    /* access modifiers changed from: private */
    public void addClient() {
        if (!this.isSaving) {
            this.isSaving = true;
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
            HashMap hashMap = new HashMap();
            hashMap.put("first_name", ((EditText) findViewById(R.id.firstNameField)).getText().toString().trim());
            hashMap.put("last_name", ((EditText) findViewById(R.id.lastNameField)).getText().toString().trim());
            hashMap.put("email", ((EditText) findViewById(R.id.emailField)).getText().toString().trim());
            hashMap.put("primary_trainer_id", Integer.valueOf(this.selectedTrainerId));
            hashMap.put("segment_ids", new JSONArray(this.selectedSegmentIds));
            baseHttpClient.put("users/new_client", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        boolean unused = AddClientActivity.this.isSaving = false;
                        Intent intent = new Intent();
                        intent.putExtra("user_id", jSONObject.getInt("user_id"));
                        intent.putExtra("first_name", jSONObject.getString("first_name"));
                        intent.putExtra("email", jSONObject.getString("email"));
                        intent.putExtra("password", jSONObject.getString("password"));
                        AddClientActivity.this.setResult(-1, intent);
                        AddClientActivity.this.finish();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    int i2;
                    try {
                        boolean unused = AddClientActivity.this.isSaving = false;
                        if (jSONObject == null || !jSONObject.has("error_code") || ((i2 = jSONObject.getInt("error_code")) != 12 && i2 != 6 && i2 != 14)) {
                            return false;
                        }
                        new MaterialDialog.Builder(AddClientActivity.this).title((int) R.string.Error).content((CharSequence) AddClientActivity.this.getString(BaseResponseHandler.getErrorMessage(i2))).positiveText((int) R.string.Ok).show();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }
}
