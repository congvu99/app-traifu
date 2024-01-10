package com.trainerfu.android;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.trainerfu.utils.Push;
import com.trainerfu.utils.Util;
import io.intercom.android.sdk.views.holder.AttributeType;
import org.json.JSONException;
import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    static final String CHANNEL_ID = "my_channel_01";
    private static final String TAG = "MyFirebaseMsgService";
    private NotificationManager mNotificationManager;

    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            try {
                sendNotification(new JSONObject(remoteMessage.getData()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void onNewToken(String str) {
        new Push(getApplicationContext()).sendRegistrationIdToBackend(str);
    }

    private void sendNotification(JSONObject jSONObject) throws JSONException {
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
        NotificationCompat.Builder channelId = new NotificationCompat.Builder(this).setSmallIcon((int) R.drawable.ic_notification).setContentTitle(jSONObject.getString("title")).setTicker(jSONObject.getString("title")).setStyle(new NotificationCompat.BigTextStyle().bigText(jSONObject.getString("content"))).setContentText(jSONObject.getString("content")).setNumber(Integer.parseInt(jSONObject.getString(AttributeType.NUMBER))).setVibrate(new long[]{1000, 1000, 1000, 1000, 1000}).setSound(RingtoneManager.getDefaultUri(2)).setChannelId(CHANNEL_ID);
        channelId.setContentIntent(pendingIntent);
        this.mNotificationManager.notify(uniqueNotificationId, channelId.build());
    }
}
