package com.trainerfu.android;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Util;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class ChangePassword extends BaseActivity {
    private TextView cancel;
    private EditText confirmPassword;
    private Menu menu;
    private EditText newPassword;
    private EditText oldPassword;
    private TextView save;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.change_password);
        this.oldPassword = (EditText) findViewById(R.id.old_password);
        this.newPassword = (EditText) findViewById(R.id.new_password);
        this.confirmPassword = (EditText) findViewById(R.id.confirm_password);
        getSupportActionBar().setTitle((CharSequence) "Update Password");
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        super.onCreateOptionsMenu(menu2);
        getMenuInflater().inflate(R.menu.create_post_menu, menu2);
        this.menu = menu2;
        MenuItem findItem = menu2.findItem(R.id.mark_done_item);
        findItem.getIcon().setTint(getResources().getColor(R.color.iconColor));
        findItem.setVisible(true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.mark_done_item) {
            if (TextUtils.isEmpty(this.newPassword.getText().toString()) || TextUtils.isEmpty(this.confirmPassword.getText().toString())) {
                Util.showToast(getApplicationContext(), R.string.invalid_credentials);
            } else if (this.newPassword.getText().toString().equals(this.confirmPassword.getText().toString())) {
                HashMap hashMap = new HashMap();
                hashMap.put("old_password", this.oldPassword.getText().toString().trim());
                hashMap.put("new_password", this.newPassword.getText().toString().trim());
                new BaseHttpClient().post("users/myself/password", hashMap, new BaseResponseHandler() {
                    public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                        Util.showToast(ChangePassword.this.getApplicationContext(), R.string.change_password_successful);
                        ChangePassword.this.finish();
                        return true;
                    }
                });
            } else {
                Util.showToast(getApplicationContext(), R.string.password_does_not_match);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
