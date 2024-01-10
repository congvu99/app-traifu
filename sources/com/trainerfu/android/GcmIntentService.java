package com.trainerfu.android;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.views.holder.AttributeType;

public class GcmIntentService extends JobIntentService {
    static final String CHANNEL_ID = "my_channel_01";
    static final int JOB_ID = 1000;
    public static final int NOTIFICATION_ID = 1;
    NotificationCompat.Builder builder;
    private NotificationManager mNotificationManager;

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) GcmIntentService.class, 1000, intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(Intent intent) {
        Bundle extras = intent.getExtras();
        String messageType = GoogleCloudMessaging.getInstance(this).getMessageType(intent);
        if (!extras.isEmpty() && "gcm".equals(messageType)) {
            sendNotification(extras);
        }
    }

    private void sendNotification(Bundle bundle) {
        PendingIntent pendingIntent;
        Intent intent;
        Boolean isTrainerProperty = Util.getIsTrainerProperty(this);
        int uniqueNotificationId = Util.getUniqueNotificationId();
        Intent intent2 = new Intent(this, FeedActivity.class);
        if (isTrainerProperty != null) {
            if (isTrainerProperty.booleanValue()) {
                intent = new Intent(this, MainTrainerActivity.class);
            } else {
                intent = new Intent(this, MainClientActivity.class);
            }
            pendingIntent = PendingIntent.getActivities(this, 0, new Intent[]{intent, intent2}, 67108864);
        } else {
            pendingIntent = PendingIntent.getActivity(this, 0, intent2, 67108864);
        }
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.mNotificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "TrainerFu Channel", 3));
        }
        NotificationCompat.Builder channelId = new NotificationCompat.Builder(this).setSmallIcon((int) R.drawable.ic_notification).setContentTitle(bundle.getString("title")).setTicker(bundle.getString("title")).setStyle(new NotificationCompat.BigTextStyle().bigText(bundle.getString("content"))).setContentText(bundle.getString("content")).setNumber(Integer.parseInt(bundle.getString(AttributeType.NUMBER))).setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).setSound(RingtoneManager.getDefaultUri(2)).setChannelId(CHANNEL_ID);
        channelId.setContentIntent(pendingIntent);
        this.mNotificationManager.notify(uniqueNotificationId, channelId.build());
    }
}
