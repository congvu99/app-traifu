package com.trainerfu.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.joanzapata.iconify.widget.IconTextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class ResetPassword extends BaseActivity implements View.OnClickListener {
    private EditText confirmPassword;
    private EditText newPassword;
    private IconTextView save;

    public ResetPassword() {
        super(false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.reset_password);
        this.newPassword = (EditText) findViewById(R.id.rpv_new_password);
        this.confirmPassword = (EditText) findViewById(R.id.rpv_confirm_password);
        IconTextView iconTextView = (IconTextView) findViewById(R.id.rpv_save_btn);
        this.save = iconTextView;
        iconTextView.setOnClickListener(this);
        this.confirmPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                ResetPassword.this.resetPassword();
                return true;
            }
        });
        this.confirmPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if (i != 23 && i != 66) {
                    return false;
                }
                ResetPassword.this.resetPassword();
                return true;
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.rpv_save_btn) {
            resetPassword();
        }
    }

    public void resetPassword() {
        if (TextUtils.isEmpty(this.newPassword.getText().toString()) || TextUtils.isEmpty(this.confirmPassword.getText().toString())) {
            Util.showToast(getApplicationContext(), R.string.invalid_credentials);
        } else if (this.newPassword.getText().toString().equals(this.confirmPassword.getText().toString())) {
            HashMap hashMap = new HashMap();
            hashMap.put("new_password", this.newPassword.getText().toString().trim());
            new BaseHttpClient().post("users/myself/password", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    Intent intent;
                    try {
                        if (jSONObject.getBoolean("is_client")) {
                            intent = new Intent(ResetPassword.this.getApplicationContext(), MainClientActivity.class);
                        } else {
                            intent = new Intent(ResetPassword.this.getApplicationContext(), MainTrainerActivity.class);
                        }
                        ResetPassword.this.startActivity(intent);
                        ResetPassword.this.finish();
                        return true;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } else {
            Util.showToast(getApplicationContext(), R.string.password_does_not_match);
        }
    }
}
