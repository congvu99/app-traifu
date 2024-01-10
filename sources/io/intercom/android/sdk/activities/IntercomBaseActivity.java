package io.intercom.android.sdk.activities;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.utilities.ContextLocaliser;

public abstract class IntercomBaseActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(localizedContext(context));
    }

    private Context localizedContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(ContextLocaliser.convertToLocale(Injector.get().getAppConfigProvider().get().getLocale()));
        return context.createConfigurationContext(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Injector.get().getActivityFinisher().register(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Injector.get().getActivityFinisher().unregister(this);
    }
}
