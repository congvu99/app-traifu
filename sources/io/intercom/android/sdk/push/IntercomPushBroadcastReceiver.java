package io.intercom.android.sdk.push;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;

public class IntercomPushBroadcastReceiver extends BroadcastReceiver {
    static final String INTERCOM_PUSH_DISMISSED = "io.intercom.android.sdk.INTERCOM_PUSH_DISMISSED";
    private static final Twig TWIG = LumberMill.getLogger();
    private final PushReceiverDelegate pushReceiverDelegate = new PushReceiverDelegate();

    public void onReceive(Context context, Intent intent) {
        Injector.initIfCachedCredentials((Application) context.getApplicationContext());
        if (Injector.isNotInitialised()) {
            TWIG.w("Push not handled because Intercom is not initialised", new Object[0]);
            return;
        }
        Injector injector = Injector.get();
        UserIdentity userIdentity = injector.getUserIdentity();
        MetricTracker metricTracker = injector.getMetricTracker();
        if (INTERCOM_PUSH_DISMISSED.equals(intent.getAction())) {
            this.pushReceiverDelegate.trackDismiss(intent, userIdentity, metricTracker);
        }
    }
}
