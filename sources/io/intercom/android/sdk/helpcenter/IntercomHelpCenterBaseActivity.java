package io.intercom.android.sdk.helpcenter;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014¨\u0006\r"}, d2 = {"Lio/intercom/android/sdk/helpcenter/IntercomHelpCenterBaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "localizedContext", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomHelpCenterBaseActivity.kt */
public abstract class IntercomHelpCenterBaseActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "newBase");
        super.attachBaseContext(localizedContext(context));
    }

    private final Context localizedContext(Context context) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(ContextLocaliser.convertToLocale(Injector.get().getAppConfigProvider().get().getHelpCenterLocale()));
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "context.createConfigurat…t(localisedConfiguration)");
        return createConfigurationContext;
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
