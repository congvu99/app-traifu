package io.intercom.android.sdk.push;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.ContextLocaliser;
import java.util.Map;

public class IntercomPushClient {
    private final PushHandler pushHandler;
    private final Twig twig;

    public IntercomPushClient() {
        this(LumberMill.getLogger(), new PushHandler());
    }

    IntercomPushClient(Twig twig2, PushHandler pushHandler2) {
        this.twig = twig2;
        this.pushHandler = pushHandler2;
    }

    public void sendTokenToIntercom(Application application, String str) {
        if (TextUtils.isEmpty(str)) {
            this.twig.e("sendTokenToIntercom() was called with a null or empty token. This user will not receive push notifications until a valid device token is sent.", new Object[0]);
            return;
        }
        Injector.initIfCachedCredentials(application);
        if (Injector.isNotInitialised()) {
            this.twig.w("Token not sent because Intercom is not initialised", new Object[0]);
            return;
        }
        Injector injector = Injector.get();
        if (this.pushHandler.shouldSendDeviceToken(application, str)) {
            this.pushHandler.sendTokenToIntercom(application, str, injector.getApi(), injector.getUserIdentity(), injector.getAppConfigProvider());
        }
    }

    public void handlePush(Application application, Bundle bundle) {
        if (bundle == null) {
            this.twig.i("The message passed to handlePush() was null.", new Object[0]);
        } else if (!PushPayload.create(bundle).isIntercomPush()) {
            this.twig.i("The message passed to handlePush() was not an Intercom push message.", new Object[0]);
        } else {
            Injector.initIfCachedCredentials(application);
            if (Injector.isNotInitialised()) {
                this.twig.w("Push not handled because Intercom is not initialised", new Object[0]);
                return;
            }
            Injector injector = Injector.get();
            Context createLocalisedContext = new ContextLocaliser(injector.getAppConfigProvider()).createLocalisedContext(application);
            boolean isBackgrounded = injector.getStore().state().hostAppState().isBackgrounded();
            Bundle bundle2 = bundle;
            this.pushHandler.handlePush(bundle2, injector.getUserIdentity(), injector.getSystemNotificationManager(), isBackgrounded, createLocalisedContext, injector.getMetricTracker(), injector.getAppConfigProvider().get());
        }
    }

    public void handlePush(Application application, Map<String, String> map) {
        if (map == null) {
            this.twig.i("The message passed to handlePush() was null.", new Object[0]);
        } else {
            handlePush(application, convertMessageMapToBundle(map));
        }
    }

    public boolean isIntercomPush(Bundle bundle) {
        return bundle != null && PushPayload.create(bundle).isIntercomPush();
    }

    public boolean isIntercomPush(Map<String, String> map) {
        return map != null && isIntercomPush(convertMessageMapToBundle(map));
    }

    private Bundle convertMessageMapToBundle(Map<String, String> map) {
        Bundle bundle = new Bundle(map.size());
        for (Map.Entry next : map.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        return bundle;
    }
}
