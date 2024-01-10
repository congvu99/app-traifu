package io.intercom.android.sdk.push;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import androidx.core.app.NotificationCompat;
import com.intercom.commons.utilities.DeviceUtils;
import com.intercom.twig.Twig;
import io.intercom.android.sdk.IntercomPushManager;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.utilities.Phrase;
import java.util.List;

class SystemNotificationFactory {
    private static final String CONVERSATION_URI = "conversation_id=%s";
    private static final String INTERCOM_SDK_PUSH = "intercom_sdk_push";
    private static final Twig twig = LumberMill.getLogger();

    SystemNotificationFactory() {
    }

    /* access modifiers changed from: package-private */
    public Notification createSingleNotification(PushPayload pushPayload, Context context, AppConfig appConfig, Bitmap bitmap, Bitmap bitmap2) {
        PushPayload pushPayload2 = pushPayload;
        return createBuilder(context, Uri.parse(String.format("intercom_sdk/conversation_id=%s", new Object[]{pushPayload.getConversationId()})), (String) null, (String) null, -1, getConversationChannelId(pushPayload), appConfig, bitmap2, pushPayload.getBody(), getTitle(context, pushPayload)).setPriority(pushPayload.getPriority()).setLargeIcon(bitmap).build();
    }

    /* access modifiers changed from: package-private */
    public Notification createGroupedNotification(List<PushPayload> list, Context context, AppConfig appConfig) {
        CharSequence charSequence;
        List<PushPayload> list2 = list;
        Context context2 = context;
        Uri parse = Uri.parse("intercom_sdk/multiple_notifications");
        if (list.size() == 1) {
            charSequence = context2.getString(R.string.intercom_one_new_message);
        } else {
            charSequence = Phrase.from(context2, R.string.intercom_new_messages).put("n", list.size()).format();
        }
        CharSequence charSequence2 = charSequence;
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(context2.getString(R.string.intercom_new_notifications));
        for (PushPayload next : list) {
            SpannableString spannableString = new SpannableString(groupMessageBody(next));
            spannableString.setSpan(new StyleSpan(1), 0, next.getAuthorName().length(), 33);
            inboxStyle.addLine(spannableString);
        }
        return createBuilder(context, parse, (String) null, (String) null, -1, getConversationChannelId(list2.get(list.size() - 1)), appConfig, (Bitmap) null, charSequence2, context2.getString(R.string.intercom_new_notifications)).setPriority(list2.get(list.size() - 1).getPriority()).setStyle(inboxStyle).build();
    }

    private CharSequence groupMessageBody(PushPayload pushPayload) {
        String message = pushPayload.getMessage();
        if (!TextUtils.isEmpty(message)) {
            return message;
        }
        return pushPayload.getAuthorName() + ": " + pushPayload.getBody();
    }

    private String getConversationChannelId(PushPayload pushPayload) {
        return pushPayload.isFirstPart() ? SystemNotificationManager.NEW_CHATS_CHANNEL : SystemNotificationManager.CHAT_REPLIES_CHANNEL;
    }

    /* access modifiers changed from: package-private */
    public Notification createPushOnlyNotification(PushPayload pushPayload, Context context, AppConfig appConfig, Bitmap bitmap) {
        String pushOnlyConversationId = pushPayload.getPushOnlyConversationId();
        String instanceId = pushPayload.getInstanceId();
        return createBuilder(context, Uri.parse(pushPayload.getUri()), pushOnlyConversationId, instanceId, TextUtils.isEmpty(instanceId) ? pushOnlyConversationId.hashCode() : instanceId.hashCode(), SystemNotificationManager.ACTIONS_CHANNEL, appConfig, bitmap, pushPayload.messageOrBody(), getTitle(context, pushPayload)).setPriority(pushPayload.getPriority()).build();
    }

    /* access modifiers changed from: package-private */
    public NotificationCompat.Builder createBuilder(Context context, Uri uri, String str, String str2, int i, String str3, AppConfig appConfig, Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        int i2 = i;
        Intent intent = new Intent(context, IntercomPushTrampolineActivity.class);
        Intent component = new Intent("io.intercom.android.sdk.INTERCOM_PUSH_DISMISSED").setComponent(new ComponentName(context, IntercomPushBroadcastReceiver.class));
        String packageName = context.getPackageName();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new Intent();
            Twig twig2 = twig;
            twig2.e("Couldn't get launch Intent for package '" + packageName + "' - tapping on notification will do nothing", new Object[0]);
        } else {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            Uri uri2 = uri;
            launchIntentForPackage.setData(uri);
            launchIntentForPackage.putExtra(IntercomPushManager.INTERCOM_PUSH_KEY, INTERCOM_SDK_PUSH);
            if (str4 != null) {
                launchIntentForPackage.putExtra(IntercomPushManager.PUSH_ONLY_CONVO_ID, str);
            }
            if (str5 != null) {
                launchIntentForPackage.putExtra(IntercomPushManager.PUSH_ONLY_INSTANCE_ID, str2);
            }
        }
        intent.putExtra(IntercomPushManager.HOST_APP_INTENT, launchIntentForPackage);
        component.putExtra(IntercomPushManager.HOST_APP_INTENT, launchIntentForPackage);
        int i3 = 134217728;
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 201326592;
        }
        return baseNotificationBuilder(context, str3, appConfig, PendingIntent.getActivity(context, i, intent, i3), PendingIntent.getBroadcast(context, i, component, i3), bitmap, charSequence, charSequence2);
    }

    /* access modifiers changed from: package-private */
    public NotificationCompat.Builder baseNotificationBuilder(Context context, String str, AppConfig appConfig, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, CharSequence charSequence, CharSequence charSequence2) {
        int i = DeviceUtils.hasPermission(context, "android.permission.VIBRATE") ? 2 : 0;
        int primaryColor = appConfig.getPrimaryColor();
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(context, str).setContentText(charSequence).setContentTitle(charSequence2).setSmallIcon(R.drawable.intercom_push_icon).setCategory(NotificationCompat.CATEGORY_MESSAGE).setAutoCancel(true).setColor(primaryColor).setLights(primaryColor, 500, 2000).setContentIntent(pendingIntent).setDeleteIntent(pendingIntent2).setDefaults(1 | i);
        if (bitmap != null) {
            defaults.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).setBigContentTitle(charSequence2).setSummaryText(charSequence).bigLargeIcon((Bitmap) null));
            defaults.setLargeIcon(bitmap);
        } else {
            defaults.setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(charSequence2).bigText(charSequence));
        }
        return defaults;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getTitle(Context context, PushPayload pushPayload) {
        String title = pushPayload.getTitle();
        if (!title.isEmpty()) {
            return title;
        }
        String authorName = pushPayload.getAuthorName();
        String appName = pushPayload.getAppName();
        if (authorName.isEmpty() || appName.isEmpty()) {
            return authorName.isEmpty() ? appName : authorName;
        }
        return Phrase.from(context, R.string.intercom_teammate_from_company).put("name", (CharSequence) authorName).put("company", (CharSequence) appName).format();
    }
}
