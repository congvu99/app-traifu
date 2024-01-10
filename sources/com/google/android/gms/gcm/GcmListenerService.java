package com.google.android.gms.gcm;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.iid.zze;
import com.google.android.gms.internal.gcm.zzl;
import com.google.android.gms.internal.gcm.zzm;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class GcmListenerService extends zze {
    private zzl zzg = zzm.zzdk;

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }

    public void onCreate() {
        super.onCreate();
        zzm.zzab();
        getClass();
        this.zzg = zzm.zzdk;
    }

    public void handleIntent(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            String valueOf = String.valueOf(intent.getAction());
            Log.w("GcmListenerService", valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        char c = 65535;
        boolean z = false;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals("deleted_messages")) {
                    c = 1;
                    break;
                }
                break;
            case 102161:
                if (stringExtra.equals("gcm")) {
                    c = 0;
                    break;
                }
                break;
            case 814694033:
                if (stringExtra.equals("send_error")) {
                    c = 3;
                    break;
                }
                break;
            case 814800675:
                if (stringExtra.equals("send_event")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0) {
            Bundle extras = intent.getExtras();
            extras.remove(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            extras.remove("androidx.contentpager.content.wakelockid");
            if ("1".equals(zzd.zzd(extras, Constants.MessageNotificationKeys.ENABLE_NOTIFICATION)) || zzd.zzd(extras, Constants.MessageNotificationKeys.ICON) != null) {
                if (!((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                    int myPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) getSystemService("activity")).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    if (next.importance == 100) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!z) {
                    zzd.zzd(this).zze(extras);
                    return;
                }
                Bundle bundle = new Bundle();
                Iterator it2 = extras.keySet().iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    String string = extras.getString(str);
                    if (str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD)) {
                        str = str.replace(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX_OLD, Constants.MessageNotificationKeys.NOTIFICATION_PREFIX);
                    }
                    if (str.startsWith(Constants.MessageNotificationKeys.NOTIFICATION_PREFIX)) {
                        if (!Constants.MessageNotificationKeys.ENABLE_NOTIFICATION.equals(str)) {
                            bundle.putString(str.substring(6), string);
                        }
                        it2.remove();
                    }
                }
                String string2 = bundle.getString("sound2");
                if (string2 != null) {
                    bundle.remove("sound2");
                    bundle.putString("sound", string2);
                }
                if (!bundle.isEmpty()) {
                    extras.putBundle("notification", bundle);
                }
            }
            String string3 = extras.getString("from");
            extras.remove("from");
            zzd(extras);
            this.zzg.zzl("onMessageReceived");
            onMessageReceived(string3, extras);
        } else if (c == 1) {
            onDeletedMessages();
        } else if (c == 2) {
            onMessageSent(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID));
        } else if (c != 3) {
            String valueOf2 = String.valueOf(stringExtra);
            Log.w("GcmListenerService", valueOf2.length() != 0 ? "Received message with unknown type: ".concat(valueOf2) : new String("Received message with unknown type: "));
        } else {
            String stringExtra2 = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER);
            }
            onSendError(stringExtra2, intent.getStringExtra("error"));
        }
    }

    static void zzd(Bundle bundle) {
        Iterator it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null && str.startsWith(Constants.MessagePayloadKeys.RESERVED_CLIENT_LIB_PREFIX)) {
                it.remove();
            }
        }
    }
}
