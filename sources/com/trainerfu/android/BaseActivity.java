package com.trainerfu.android;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.trainerfu.utils.BaseHttpClient;
import com.trainerfu.utils.BaseResponseHandler;
import com.trainerfu.utils.Push;
import com.trainerfu.utils.ReactInstanceManagerFactory;
import com.trainerfu.utils.Util;
import java.lang.Thread;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public abstract class BaseActivity extends AppCompatActivity {
    public static final String APP_ID = "dba1f357b44924f3001ff0f31104b831";
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private boolean inflateMenu;

    /* access modifiers changed from: protected */
    public boolean canSendRegistrationId() {
        return true;
    }

    public BaseActivity() {
        this(false);
    }

    public BaseActivity(boolean z) {
        this.inflateMenu = z;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                try {
                    Util.sendGack(th);
                } catch (Exception unused) {
                }
            }
        });
        ReactInstanceManagerFactory.getInstance().getReactInstanceManager(getApplication());
        if (checkPlayServices() && canSendRegistrationId()) {
            new Push(getApplicationContext()).checkAndRegister();
        }
        getWindow().getDecorView().setSystemUiVisibility(8192);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        checkPlayServices();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(27);
            int identifier = getResources().getIdentifier("ic_ab_icon", "drawable", getPackageName());
            if (identifier != 0) {
                actionBar.setIcon(identifier);
            } else {
                actionBar.setIcon(17170445);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Activity currentActivity = ((MyApplication) MyApplication.getAppContext()).getCurrentActivity();
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_logout) {
            HashMap hashMap = null;
            String registrationId = new Push(getApplicationContext()).getRegistrationId();
            if (!registrationId.isEmpty()) {
                hashMap = new HashMap();
                hashMap.put("device_token", registrationId);
            }
            baseHttpClient.delete("access_tokens/my_token", hashMap, new BaseResponseHandler() {
                public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                    new Push(BaseActivity.this.getApplicationContext());
                    MyApplication myApplication = (MyApplication) MyApplication.getAppContext();
                    Activity currentActivity = myApplication.getCurrentActivity();
                    if (currentActivity != null) {
                        currentActivity.finish();
                    }
                    Intent intent = new Intent(myApplication, LoginActivity.class);
                    intent.setFlags(268435456);
                    myApplication.startActivity(intent);
                    return true;
                }
            });
            return true;
        } else if (itemId != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            if (!(currentActivity instanceof UserProfileActivity)) {
                startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
            }
            return true;
        }
    }

    private boolean checkPlayServices() {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
            GooglePlayServicesUtil.getErrorDialog(isGooglePlayServicesAvailable, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            return false;
        }
        finish();
        return false;
    }
}
