package io.intercom.android.sdk.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.utilities.IntentUtils;
import io.intercom.android.sdk.utilities.LinkOpener;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import java.util.List;

class PushReceiverDelegate {
    private static final String CONSUMED_BY_INTERCOM = "consumed_by_intercom";
    private final Twig twig = LumberMill.getLogger();

    PushReceiverDelegate() {
    }

    /* access modifiers changed from: package-private */
    public void handlePushTap(Context context, Intent intent, Api api, UserIdentity userIdentity, MetricTracker metricTracker) {
        Intent intent2;
        if (userIdentity.identityExists() && (intent2 = (Intent) intent.getParcelableExtra(IntercomPushManager.HOST_APP_INTENT)) != null) {
            PushBroadcast createPushFromIntent = createPushFromIntent(intent2);
            if (createPushFromIntent.isEmpty()) {
                this.twig.internal("Could not open push. No Uri and conversation id found.");
                return;
            }
            Uri pushData = createPushFromIntent.getPushData();
            if (createPushFromIntent.hasPushOnlyId()) {
                handlePushMessage(context, api, createPushFromIntent, metricTracker);
            } else {
                openHostAppIntent(context, intent2, extractNotificationId(pushData));
            }
        }
    }

    private void handlePushMessage(Context context, Api api, PushBroadcast pushBroadcast, MetricTracker metricTracker) {
        String pushOnlyId = pushBroadcast.getPushOnlyId();
        int pushOnlyIdType = pushBroadcast.getPushOnlyIdType();
        if (pushOnlyIdType == 1) {
            api.markPushAsOpened(pushOnlyId);
        } else if (pushOnlyIdType == 0) {
            api.markConversationAsRead(pushOnlyId);
        }
        Uri pushData = pushBroadcast.getPushData();
        if (Uri.EMPTY.equals(pushData)) {
            this.twig.i("There was no URI in the push message. Defaulting to launch activity", new Object[0]);
            Intent launchActivityIntent = getLaunchActivityIntent(context);
            launchActivityIntent.addFlags(268435456);
            IntentUtils.safelyOpenIntent(context, launchActivityIntent);
        } else {
            LinkOpener.handleUrl(pushData.toString(), context, api);
        }
        metricTracker.openedPushOnlyNotification(pushOnlyId);
    }

    private Intent getLaunchActivityIntent(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                return launchIntentForPackage;
            }
            throw new PackageManager.NameNotFoundException();
        } catch (PackageManager.NameNotFoundException unused) {
            return new Intent();
        }
    }

    private void openHostAppIntent(Context context, Intent intent, String str) {
        context.getSharedPreferences(PreferenceKeys.INTERCOM_PUSH_PREFS, 0).edit().putString(IntercomPushManager.INTERCOM_PUSH_PATH, str).apply();
        IntentUtils.safelyOpenIntent(context, intent);
    }

    private PushBroadcast createPushFromIntent(Intent intent) {
        PushBroadcast pushBroadcast = new PushBroadcast();
        if (intent == null) {
            this.twig.internal("Host app intent was null.");
            return pushBroadcast;
        } else if (!notLaunchedFromHistory(intent) || !notConsumedByIntercom(intent) || !isIntercomIntent(intent.getExtras())) {
            return pushBroadcast;
        } else {
            PushBroadcast pushBroadcast2 = new PushBroadcast(intent);
            intent.putExtra(CONSUMED_BY_INTERCOM, true);
            return pushBroadcast2;
        }
    }

    private String extractNotificationId(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.isEmpty()) {
            return "";
        }
        String str = pathSegments.get(1);
        if (str.equals(IntercomPushManager.MULTIPLE_NOTIFICATIONS)) {
            return IntercomPushManager.MULTIPLE_NOTIFICATIONS;
        }
        return str.substring(str.lastIndexOf(61) + 1);
    }

    /* access modifiers changed from: package-private */
    public void trackDismiss(Intent intent, UserIdentity userIdentity, MetricTracker metricTracker) {
        Intent intent2;
        String str;
        if (userIdentity.identityExists() && (intent2 = (Intent) intent.getParcelableExtra(IntercomPushManager.HOST_APP_INTENT)) != null) {
            PushBroadcast pushBroadcast = new PushBroadcast(intent2);
            if (pushBroadcast.isEmpty()) {
                this.twig.internal("Could not track push dismiss. No Uri found");
            } else if (pushBroadcast.hasPushOnlyId()) {
                String str2 = "";
                if (pushBroadcast.getPushOnlyIdType() == 1) {
                    str = pushBroadcast.getPushOnlyId();
                } else {
                    String str3 = str2;
                    str2 = pushBroadcast.getPushOnlyId();
                    str = str3;
                }
                metricTracker.dismissedPushOnlyNotification(str2, str);
            } else {
                metricTracker.dismissedPushNotification(extractNotificationId(pushBroadcast.getPushData()));
            }
        }
    }

    private boolean notConsumedByIntercom(Intent intent) {
        return !intent.getBooleanExtra(CONSUMED_BY_INTERCOM, false);
    }

    private boolean isIntercomIntent(Bundle bundle) {
        return bundle != null && bundle.containsKey(IntercomPushManager.INTERCOM_PUSH_KEY);
    }

    private boolean notLaunchedFromHistory(Intent intent) {
        return (intent.getFlags() & 1048576) == 0;
    }
}
