package com.trainerfu.android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.ExerciseDataset;
import com.trainerfu.utils.Push;
import com.trainerfu.utils.ReactInstanceManagerFactory;
import com.trainerfu.utils.Util;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEmail;
    private TextView mForgotPassword;
    LayoutInflater mInflater;
    private IconTextView mLoginBtn;
    private EditText mPassword;
    private TextView mPrivacyPolicy;
    private final ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() {
        public final void onActivityResult(Object obj) {
            LoginActivity.this.lambda$new$0$LoginActivity((Boolean) obj);
        }
    });
    private Toolbar toolbar;

    /* access modifiers changed from: protected */
    public boolean canSendRegistrationId() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.login_layout);
        TextView textView = (TextView) findViewById(R.id.privacy_policy);
        this.mPrivacyPolicy = textView;
        textView.setText(Html.fromHtml(getString(R.string.privacy_policy)));
        this.mPrivacyPolicy.setMovementMethod(LinkMovementMethod.getInstance());
        this.mEmail = (EditText) findViewById(R.id.email);
        this.mPassword = (EditText) findViewById(R.id.password);
        this.mLoginBtn = (IconTextView) findViewById(R.id.loginBtn);
        getSupportActionBar().setTitle((CharSequence) "Login");
        TextView textView2 = (TextView) findViewById(R.id.forgot_password);
        this.mForgotPassword = textView2;
        textView2.setOnClickListener(this);
        this.mLoginBtn.setOnClickListener(this);
        this.mPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                LoginActivity.this.login();
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
                LoginActivity.this.login();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    public void onClick(View view) {
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
        HashMap hashMap = new HashMap();
        int id = view.getId();
        if (id == R.id.forgot_password) {
            hashMap.put("email", this.mEmail.getText().toString());
            if (this.mEmail.getText().toString().length() == 0) {
                Util.showToast(getApplicationContext(), R.string.emailError);
            } else {
                baseHttpClient.put("users/myself/alternate_password", hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        Util.showToast(LoginActivity.this.getApplicationContext(), R.string.forgot_password_success_response);
                        return true;
                    }
                });
            }
        } else if (id == R.id.loginBtn) {
            login();
        }
    }

    public void login() {
        BaseHttpClient baseHttpClient = new BaseHttpClient(true, this);
        HashMap hashMap = new HashMap();
        hashMap.put("email", this.mEmail.getText().toString());
        hashMap.put("password", this.mPassword.getText().toString());
        baseHttpClient.put("access_tokens/new", hashMap, new BaseResponseHandler() {
            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                Intent intent;
                try {
                    boolean z = jSONObject.getBoolean("is_client");
                    Util.storeIsTrainerProperty(LoginActivity.this, !z);
                    ExerciseDataset instance = ExerciseDataset.getInstance();
                    instance.fetchAllExercises((ExerciseDataset.ExerciseDatasetFetchedResponder) null);
                    instance.fetchRecentExercises((ExerciseDataset.ExerciseDatasetFetchedResponder) null);
                    LoginActivity.this.askNotificationPermission();
                    Util.showToast(LoginActivity.this.getApplicationContext(), R.string.login_success_response);
                    ReactInstanceManagerFactory.getInstance().clear();
                    if (z) {
                        intent = new Intent(LoginActivity.this, MainClientActivity.class);
                    } else {
                        intent = new Intent(LoginActivity.this, MainTrainerActivity.class);
                    }
                    intent.addFlags(268468224);
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }

            public void onFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                String str;
                try {
                    dismissSpinner();
                    if (jSONObject != null && jSONObject.has("error_code")) {
                        int i2 = jSONObject.getInt("error_code");
                        if (i2 == 20) {
                            str = jSONObject.getJSONObject("data").getString("error_details");
                        } else {
                            str = LoginActivity.this.getString(BaseResponseHandler.getErrorMessage(i2));
                        }
                        new MaterialDialog.Builder(LoginActivity.this).title((int) R.string.Error).content((CharSequence) str).positiveText((int) R.string.Ok).show();
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public /* synthetic */ void lambda$new$0$LoginActivity(Boolean bool) {
        if (bool.booleanValue()) {
            new Push(getApplicationContext()).sendRegistrationIdToBackend();
        }
    }

    /* access modifiers changed from: private */
    public void askNotificationPermission() {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            new Push(getApplicationContext()).sendRegistrationIdToBackend();
        } else {
            this.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        }
    }
}
