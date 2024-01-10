package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends BaseActivity {
    private EditText mPassword;
    private TextView mPrivacyPolicy;
    private IconTextView registerBtn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.register_view);
        this.mPrivacyPolicy = (TextView) findViewById(R.id.privacy_policy);
        this.mPassword = (EditText) findViewById(R.id.passwordField);
        this.mPrivacyPolicy.setText(Html.fromHtml(getString(R.string.privacy_policy)));
        this.mPrivacyPolicy.setMovementMethod(LinkMovementMethod.getInstance());
        IconTextView iconTextView = (IconTextView) findViewById(R.id.registerBtn);
        this.registerBtn = iconTextView;
        iconTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.createNewAccount();
            }
        });
        this.mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                RegisterActivity.this.createNewAccount();
                return true;
            }
        });
        this.mPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (i != 23 && i != 66) {
                    return false;
                }
                RegisterActivity.this.createNewAccount();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void createNewAccount() {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(((EditText) findViewById(R.id.nameField)).getText().toString().trim().split("\\s+")));
        if (arrayList.size() > 1) {
            str = (String) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        } else {
            str = "-";
        }
        Iterator it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + ((String) it.next()) + " ";
        }
        String trim = str2.trim();
        String trim2 = ((EditText) findViewById(R.id.emailField)).getText().toString().trim();
        String obj = ((EditText) findViewById(R.id.passwordField)).getText().toString();
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
        HashMap hashMap = new HashMap();
        hashMap.put("first_name", trim);
        hashMap.put("last_name", str);
        hashMap.put("email", trim2);
        hashMap.put("password", obj);
        hashMap.put("plan", "app_freemium");
        hashMap.put("company", "");
        baseHttpClient.post("/provisioned_companies/new", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Intent intent = new Intent(RegisterActivity.this, MainTrainerActivity.class);
                intent.addFlags(268468224);
                RegisterActivity.this.startActivity(intent);
                RegisterActivity.this.finish();
                return true;
            }

            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                String str;
                if (jSONObject == null) {
                    return false;
                }
                try {
                    if (!jSONObject.has("error_code")) {
                        return false;
                    }
                    int i2 = jSONObject.getInt("error_code");
                    if (i2 != 20 && i2 != 14 && i2 != 10) {
                        return false;
                    }
                    if (i2 == 20) {
                        str = jSONObject.getJSONObject("data").getString("error_details");
                    } else {
                        str = RegisterActivity.this.getString(BaseResponseHandler.getErrorMessage(i2));
                    }
                    new MaterialDialog.Builder(RegisterActivity.this).title((int) R.string.Error).content((CharSequence) str).positiveText((int) R.string.Ok).show();
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void checkAccountExists() {
        String trim = ((EditText) findViewById(R.id.nameField)).getText().toString().trim();
        String trim2 = ((EditText) findViewById(R.id.emailField)).getText().toString().trim();
        String obj = ((EditText) findViewById(R.id.passwordField)).getText().toString();
        if (trim.length() == 0) {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) "Name cannot be empty").positiveText((int) R.string.Ok).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(trim2).matches() || trim2.length() == 0) {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) "Invalid Email Address").positiveText((int) R.string.Ok).show();
        } else if (obj.length() == 0) {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) "Password cannot be empty").positiveText((int) R.string.Ok).show();
        } else if (obj.length() < 6) {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) "Password must be greater than or equal to 6 characters").positiveText((int) R.string.Ok).show();
        } else if (!obj.matches("^[A-Za-z0-9!-~]{6,}$")) {
            new MaterialDialog.Builder(this).title((int) R.string.Error).content((CharSequence) "Password can only contain alphanumeric or special characters.").positiveText((int) R.string.Ok).show();
        } else {
            BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
            HashMap hashMap = new HashMap();
            hashMap.put("email", trim2);
            baseHttpClient.get("/user_exist", hashMap, new BaseResponseHandler() {
                public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                    return false;
                }

                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    try {
                        if (jSONObject.getBoolean("exist")) {
                            new MaterialDialog.Builder(RegisterActivity.this).title((int) R.string.Error).content((CharSequence) "User with this email already exist.").positiveText((int) R.string.Ok).show();
                            return true;
                        }
                        RegisterActivity.this.loadTrainingPackage();
                        return true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void loadTrainingPackage() {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(((EditText) findViewById(R.id.nameField)).getText().toString().trim().split("\\s+")));
        if (arrayList.size() > 1) {
            str = (String) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        } else {
            str = "-";
        }
        Iterator it = arrayList.iterator();
        String str2 = "";
        while (it.hasNext()) {
            str2 = str2 + ((String) it.next()) + " ";
        }
        String trim = str2.trim();
        String trim2 = ((EditText) findViewById(R.id.emailField)).getText().toString().trim();
        String obj = ((EditText) findViewById(R.id.passwordField)).getText().toString();
        Intent intent = new Intent(this, InAppPurchaseActivity.class);
        intent.putExtra("transaction_type", BrandedIAPTransactionType.NEW_PURCHASE.getMask());
        intent.putExtra("first_name", trim);
        intent.putExtra("last_name", str);
        intent.putExtra("email", trim2);
        intent.putExtra("password", obj);
        startActivity(intent);
    }
}
