package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzd;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
final class zzaf implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final Object zzb = new Object();
    private boolean zzc = false;
    private BillingClientStateListener zzd;

    /* synthetic */ zzaf(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzy zzy) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    private final void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingSetupFinished(billingResult);
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zza.zzj("BillingClient", "Billing service connected.");
        zzd unused = this.zza.zzg = zzc.zzn(iBinder);
        if (this.zza.zzH(new zzae(this), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new zzad(this), this.zza.zzD()) == null) {
            zzd(this.zza.zzF());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zza.zzk("BillingClient", "Billing service disconnected.");
        zzd unused = this.zza.zzg = null;
        int unused2 = this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = com.android.billingclient.api.BillingClientImpl.zzd(r10.zza).getPackageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        r5 = 16;
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if (r5 < 3) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r6 = com.android.billingclient.api.BillingClientImpl.zzl(r10.zza).zzb(r5, r3, com.android.billingclient.api.BillingClient.SkuType.SUBS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r6 != 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        r7 = r10.zza;
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r5 < 5) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        com.android.billingclient.api.BillingClientImpl.zzC(r7, r8);
        r7 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        if (r5 < 3) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        com.android.billingclient.api.BillingClientImpl.zzt(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (r5 >= 3) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
        com.google.android.gms.internal.play_billing.zza.zzj("BillingClient", "In-app billing API does not support subscription on this device.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0053, code lost:
        r5 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0055, code lost:
        if (r5 < 3) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0057, code lost:
        r6 = com.android.billingclient.api.BillingClientImpl.zzl(r10.zza).zzb(r5, r3, com.android.billingclient.api.BillingClient.SkuType.INAPP);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        if (r6 != 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
        com.android.billingclient.api.BillingClientImpl.zzb(r10.zza, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006b, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006e, code lost:
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0074, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 16) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0076, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0078, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0079, code lost:
        com.android.billingclient.api.BillingClientImpl.zzu(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 15) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0086, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0088, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0089, code lost:
        com.android.billingclient.api.BillingClientImpl.zzv(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0094, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 14) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0096, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0098, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0099, code lost:
        com.android.billingclient.api.BillingClientImpl.zzw(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a4, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 12) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a8, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a9, code lost:
        com.android.billingclient.api.BillingClientImpl.zzx(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b4, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 10) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        com.android.billingclient.api.BillingClientImpl.zzy(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 9) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c8, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c9, code lost:
        com.android.billingclient.api.BillingClientImpl.zzz(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d4, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 8) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00d6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00d8, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00d9, code lost:
        com.android.billingclient.api.BillingClientImpl.zzA(r3, r4);
        r3 = r10.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e3, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r3) < 6) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e7, code lost:
        com.android.billingclient.api.BillingClientImpl.zzB(r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f0, code lost:
        if (com.android.billingclient.api.BillingClientImpl.zza(r10.zza) >= 3) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00f2, code lost:
        com.google.android.gms.internal.play_billing.zza.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f9, code lost:
        if (r6 != 0) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00fb, code lost:
        com.android.billingclient.api.BillingClientImpl.zzc(r10.zza, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0102, code lost:
        com.android.billingclient.api.BillingClientImpl.zzc(r10.zza, 0);
        com.android.billingclient.api.BillingClientImpl.zzm(r10.zza, (com.google.android.gms.internal.play_billing.zzd) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x010d, code lost:
        com.google.android.gms.internal.play_billing.zza.zzk("BillingClient", "Exception while checking if billing is supported; try to reconnect");
        com.android.billingclient.api.BillingClientImpl.zzc(r10.zza, 0);
        com.android.billingclient.api.BillingClientImpl.zzm(r10.zza, (com.google.android.gms.internal.play_billing.zzd) null);
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x011f, code lost:
        if (r6 != 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0121, code lost:
        zzd(com.android.billingclient.api.zzak.zzp);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0127, code lost:
        zzd(com.android.billingclient.api.zzak.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x012c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza() throws java.lang.Exception {
        /*
            r10 = this;
            java.lang.Object r0 = r10.zzb
            monitor-enter(r0)
            boolean r1 = r10.zzc     // Catch:{ all -> 0x012d }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x012d }
            return r2
        L_0x000a:
            monitor-exit(r0)     // Catch:{ all -> 0x012d }
            r0 = 3
            r1 = 0
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x010d }
            android.content.Context r3 = r3.zzf     // Catch:{ Exception -> 0x010d }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x010d }
            r4 = 16
            r5 = 16
            r6 = 3
        L_0x001c:
            if (r5 < r0) goto L_0x0033
            com.android.billingclient.api.BillingClientImpl r7 = r10.zza     // Catch:{ Exception -> 0x0030 }
            com.google.android.gms.internal.play_billing.zzd r7 = r7.zzg     // Catch:{ Exception -> 0x0030 }
            java.lang.String r8 = "subs"
            int r6 = r7.zzb(r5, r3, r8)     // Catch:{ Exception -> 0x0030 }
            if (r6 != 0) goto L_0x002d
            goto L_0x0034
        L_0x002d:
            int r5 = r5 + -1
            goto L_0x001c
        L_0x0030:
            r0 = r6
            goto L_0x010d
        L_0x0033:
            r5 = 0
        L_0x0034:
            com.android.billingclient.api.BillingClientImpl r7 = r10.zza     // Catch:{ Exception -> 0x0030 }
            r8 = 5
            r9 = 1
            if (r5 < r8) goto L_0x003c
            r8 = 1
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            boolean unused = r7.zzj = r8     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r7 = r10.zza     // Catch:{ Exception -> 0x0030 }
            if (r5 < r0) goto L_0x0046
            r8 = 1
            goto L_0x0047
        L_0x0046:
            r8 = 0
        L_0x0047:
            boolean unused = r7.zzi = r8     // Catch:{ Exception -> 0x0030 }
            if (r5 >= r0) goto L_0x0053
            java.lang.String r5 = "BillingClient"
            java.lang.String r7 = "In-app billing API does not support subscription on this device."
            com.google.android.gms.internal.play_billing.zza.zzj(r5, r7)     // Catch:{ Exception -> 0x0030 }
        L_0x0053:
            r5 = 16
        L_0x0055:
            if (r5 < r0) goto L_0x006e
            com.android.billingclient.api.BillingClientImpl r7 = r10.zza     // Catch:{ Exception -> 0x0030 }
            com.google.android.gms.internal.play_billing.zzd r7 = r7.zzg     // Catch:{ Exception -> 0x0030 }
            java.lang.String r8 = "inapp"
            int r6 = r7.zzb(r5, r3, r8)     // Catch:{ Exception -> 0x0030 }
            if (r6 != 0) goto L_0x006b
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int unused = r3.zzk = r5     // Catch:{ Exception -> 0x0030 }
            goto L_0x006e
        L_0x006b:
            int r5 = r5 + -1
            goto L_0x0055
        L_0x006e:
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r5 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            if (r5 < r4) goto L_0x0078
            r4 = 1
            goto L_0x0079
        L_0x0078:
            r4 = 0
        L_0x0079:
            boolean unused = r3.zzs = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 15
            if (r4 < r5) goto L_0x0088
            r4 = 1
            goto L_0x0089
        L_0x0088:
            r4 = 0
        L_0x0089:
            boolean unused = r3.zzr = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 14
            if (r4 < r5) goto L_0x0098
            r4 = 1
            goto L_0x0099
        L_0x0098:
            r4 = 0
        L_0x0099:
            boolean unused = r3.zzq = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 12
            if (r4 < r5) goto L_0x00a8
            r4 = 1
            goto L_0x00a9
        L_0x00a8:
            r4 = 0
        L_0x00a9:
            boolean unused = r3.zzp = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 10
            if (r4 < r5) goto L_0x00b8
            r4 = 1
            goto L_0x00b9
        L_0x00b8:
            r4 = 0
        L_0x00b9:
            boolean unused = r3.zzo = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 9
            if (r4 < r5) goto L_0x00c8
            r4 = 1
            goto L_0x00c9
        L_0x00c8:
            r4 = 0
        L_0x00c9:
            boolean unused = r3.zzn = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 8
            if (r4 < r5) goto L_0x00d8
            r4 = 1
            goto L_0x00d9
        L_0x00d8:
            r4 = 0
        L_0x00d9:
            boolean unused = r3.zzm = r4     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r4 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            r5 = 6
            if (r4 < r5) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r9 = 0
        L_0x00e7:
            boolean unused = r3.zzl = r9     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int r3 = r3.zzk     // Catch:{ Exception -> 0x0030 }
            if (r3 >= r0) goto L_0x00f9
            java.lang.String r0 = "BillingClient"
            java.lang.String r3 = "In-app billing API version 3 is not supported on this device."
            com.google.android.gms.internal.play_billing.zza.zzk(r0, r3)     // Catch:{ Exception -> 0x0030 }
        L_0x00f9:
            if (r6 != 0) goto L_0x0102
            com.android.billingclient.api.BillingClientImpl r0 = r10.zza     // Catch:{ Exception -> 0x0030 }
            r3 = 2
            int unused = r0.zza = r3     // Catch:{ Exception -> 0x0030 }
            goto L_0x011f
        L_0x0102:
            com.android.billingclient.api.BillingClientImpl r0 = r10.zza     // Catch:{ Exception -> 0x0030 }
            int unused = r0.zza = r1     // Catch:{ Exception -> 0x0030 }
            com.android.billingclient.api.BillingClientImpl r0 = r10.zza     // Catch:{ Exception -> 0x0030 }
            com.google.android.gms.internal.play_billing.zzd unused = r0.zzg = r2     // Catch:{ Exception -> 0x0030 }
            goto L_0x011f
        L_0x010d:
            java.lang.String r3 = "BillingClient"
            java.lang.String r4 = "Exception while checking if billing is supported; try to reconnect"
            com.google.android.gms.internal.play_billing.zza.zzk(r3, r4)
            com.android.billingclient.api.BillingClientImpl r3 = r10.zza
            int unused = r3.zza = r1
            com.android.billingclient.api.BillingClientImpl r1 = r10.zza
            com.google.android.gms.internal.play_billing.zzd unused = r1.zzg = r2
            r6 = r0
        L_0x011f:
            if (r6 != 0) goto L_0x0127
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzak.zzp
            r10.zzd(r0)
            goto L_0x012c
        L_0x0127:
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzak.zza
            r10.zzd(r0)
        L_0x012c:
            return r2
        L_0x012d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x012d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzaf.zza():java.lang.Object");
    }

    public final /* synthetic */ void zzb() {
        int unused = this.zza.zza = 0;
        zzd unused2 = this.zza.zzg = null;
        zzd(zzak.zzr);
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
