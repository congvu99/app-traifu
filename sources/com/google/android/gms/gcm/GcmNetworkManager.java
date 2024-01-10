package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.internal.gcm.zzq;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zzh;
    private final Context zzi;
    private final Map<String, Map<String, Boolean>> zzj = new ArrayMap();

    public static GcmNetworkManager getInstance(Context context) {
        GcmNetworkManager gcmNetworkManager;
        synchronized (GcmNetworkManager.class) {
            if (zzh == null) {
                zzh = new GcmNetworkManager(context.getApplicationContext());
            }
            gcmNetworkManager = zzh;
        }
        return gcmNetworkManager;
    }

    private GcmNetworkManager(Context context) {
        this.zzi = context;
    }

    private final zzn zze() {
        if (GoogleCloudMessaging.zzf(this.zzi) >= 5000000) {
            return new zzm(this.zzi);
        }
        Log.e("GcmNetworkManager", "Google Play services is not available, dropping all GcmNetworkManager requests");
        return new zzo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        zzd(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0062, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void schedule(com.google.android.gms.gcm.Task r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.gcm.zzp r0 = new com.google.android.gms.gcm.zzp     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "nts:client:schedule:"
            java.lang.String r2 = r5.getTag()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0063 }
            int r3 = r2.length()     // Catch:{ all -> 0x0063 }
            if (r3 == 0) goto L_0x0018
            java.lang.String r1 = r1.concat(r2)     // Catch:{ all -> 0x0063 }
            goto L_0x001e
        L_0x0018:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x0063 }
            r2.<init>(r1)     // Catch:{ all -> 0x0063 }
            r1 = r2
        L_0x001e:
            r0.<init>(r1)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r5.getServiceName()     // Catch:{ all -> 0x005c }
            r4.zze(r1)     // Catch:{ all -> 0x005c }
            com.google.android.gms.gcm.zzn r1 = r4.zze()     // Catch:{ all -> 0x005c }
            boolean r1 = r1.zzd((com.google.android.gms.gcm.Task) r5)     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0056
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Boolean>> r1 = r4.zzj     // Catch:{ all -> 0x005c }
            java.lang.String r2 = r5.getServiceName()     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x005c }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0056
            java.lang.String r2 = r5.getTag()     // Catch:{ all -> 0x005c }
            boolean r2 = r1.containsKey(r2)     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0056
            java.lang.String r5 = r5.getTag()     // Catch:{ all -> 0x005c }
            r2 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x005c }
            r1.put(r5, r2)     // Catch:{ all -> 0x005c }
        L_0x0056:
            r5 = 0
            zzd((java.lang.Throwable) r5, (com.google.android.gms.gcm.zzp) r0)     // Catch:{ all -> 0x0063 }
            monitor-exit(r4)
            return
        L_0x005c:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x005e }
        L_0x005e:
            r1 = move-exception
            zzd((java.lang.Throwable) r5, (com.google.android.gms.gcm.zzp) r0)     // Catch:{ all -> 0x0063 }
            throw r1     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmNetworkManager.schedule(com.google.android.gms.gcm.Task):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        zzd(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancelTask(java.lang.String r5, java.lang.Class<? extends com.google.android.gms.gcm.GcmTaskService> r6) {
        /*
            r4 = this;
            android.content.ComponentName r0 = new android.content.ComponentName
            android.content.Context r1 = r4.zzi
            r0.<init>(r1, r6)
            com.google.android.gms.gcm.zzp r6 = new com.google.android.gms.gcm.zzp
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r2 = r1.length()
            java.lang.String r3 = "nts:client:cancel:"
            if (r2 == 0) goto L_0x001a
            java.lang.String r1 = r3.concat(r1)
            goto L_0x001f
        L_0x001a:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x001f:
            r6.<init>(r1)
            zzd(r5)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r0.getClassName()     // Catch:{ all -> 0x0038 }
            r4.zze(r1)     // Catch:{ all -> 0x0038 }
            com.google.android.gms.gcm.zzn r1 = r4.zze()     // Catch:{ all -> 0x0038 }
            r1.zzd(r0, r5)     // Catch:{ all -> 0x0038 }
            r5 = 0
            zzd((java.lang.Throwable) r5, (com.google.android.gms.gcm.zzp) r6)
            return
        L_0x0038:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            zzd((java.lang.Throwable) r5, (com.google.android.gms.gcm.zzp) r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmNetworkManager.cancelTask(java.lang.String, java.lang.Class):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        zzd(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancelAllTasks(java.lang.Class<? extends com.google.android.gms.gcm.GcmTaskService> r3) {
        /*
            r2 = this;
            android.content.ComponentName r0 = new android.content.ComponentName
            android.content.Context r1 = r2.zzi
            r0.<init>(r1, r3)
            com.google.android.gms.gcm.zzp r3 = new com.google.android.gms.gcm.zzp
            java.lang.String r1 = "nts:client:cancelAll"
            r3.<init>(r1)
            java.lang.String r1 = r0.getClassName()     // Catch:{ all -> 0x0021 }
            r2.zze(r1)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.gcm.zzn r1 = r2.zze()     // Catch:{ all -> 0x0021 }
            r1.zzd((android.content.ComponentName) r0)     // Catch:{ all -> 0x0021 }
            r0 = 0
            zzd((java.lang.Throwable) r0, (com.google.android.gms.gcm.zzp) r3)
            return
        L_0x0021:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            zzd((java.lang.Throwable) r0, (com.google.android.gms.gcm.zzp) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmNetworkManager.cancelAllTasks(java.lang.Class):void");
    }

    static void zzd(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private final boolean zze(String str) {
        List<ResolveInfo> list;
        Intent intent;
        Preconditions.checkNotNull(str, "GcmTaskService must not be null.");
        PackageManager packageManager = this.zzi.getPackageManager();
        if (packageManager == null) {
            list = Collections.emptyList();
        } else {
            if (str != null) {
                intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setClassName(this.zzi, str);
            } else {
                intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK).setPackage(this.zzi.getPackageName());
            }
            list = packageManager.queryIntentServices(intent, 0);
        }
        if (CollectionUtils.isEmpty(list)) {
            Log.e("GcmNetworkManager", String.valueOf(str).concat(" is not available. This may cause the task to be lost."));
            return true;
        }
        for (ResolveInfo next : list) {
            if (next.serviceInfo != null && next.serviceInfo.enabled) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 118);
        sb.append("The GcmTaskService class you provided ");
        sb.append(str);
        sb.append(" does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd(String str, String str2) {
        Map map = this.zzj.get(str2);
        if (map == null) {
            map = new ArrayMap();
            this.zzj.put(str2, map);
        }
        if (map.put(str, false) == null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zze(String str, String str2) {
        Map map = this.zzj.get(str2);
        if (map != null) {
            if ((map.remove(str) != null) && map.isEmpty()) {
                this.zzj.remove(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzf(String str, String str2) {
        Map map = this.zzj.get(str2);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzf(String str) {
        return this.zzj.containsKey(str);
    }

    private static /* synthetic */ void zzd(Throwable th, zzp zzp) {
        if (th != null) {
            try {
                zzp.close();
            } catch (Throwable th2) {
                zzq.zzd(th, th2);
            }
        } else {
            zzp.close();
        }
    }
}
