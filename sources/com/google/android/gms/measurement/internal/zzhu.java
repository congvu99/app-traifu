package com.google.android.gms.measurement.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzhv zze;

    zzhu(zzhv zzhv, boolean z, Uri uri, String str, String str2) {
        this.zze = zzhv;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (r2.zza.zzs.zzc().zzn((java.lang.String) null, com.google.android.gms.measurement.internal.zzea.zzac) == false) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2 A[SYNTHETIC, Splitter:B:31:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0104 A[Catch:{ RuntimeException -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117 A[SYNTHETIC, Splitter:B:47:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0149 A[Catch:{ RuntimeException -> 0x01de }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014b A[Catch:{ RuntimeException -> 0x01de }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzhv r2 = r1.zze
            boolean r0 = r1.zza
            android.net.Uri r3 = r1.zzb
            java.lang.String r4 = r1.zzc
            java.lang.String r5 = r1.zzd
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza
            r6.zzg()
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzea.zzab     // Catch:{ RuntimeException -> 0x01de }
            r8 = 0
            boolean r6 = r6.zzn(r8, r7)     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r7 = "Activity created with data 'referrer' without required params"
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "utm_source"
            java.lang.String r12 = "utm_campaign"
            java.lang.String r13 = "gclid"
            if (r6 != 0) goto L_0x0051
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ RuntimeException -> 0x01de }
            boolean r6 = r6.zzn(r8, r14)     // Catch:{ RuntimeException -> 0x01de }
            if (r6 != 0) goto L_0x0051
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01de }
            boolean r6 = r6.zzn(r8, r14)     // Catch:{ RuntimeException -> 0x01de }
            if (r6 == 0) goto L_0x005f
        L_0x0051:
            com.google.android.gms.measurement.internal.zzhw r6 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzku r6 = r6.zzl()     // Catch:{ RuntimeException -> 0x01de }
            boolean r14 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01de }
            if (r14 == 0) goto L_0x0061
        L_0x005f:
            r6 = r8
            goto L_0x00ad
        L_0x0061:
            boolean r14 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r14 != 0) goto L_0x0087
            boolean r14 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01de }
            if (r14 != 0) goto L_0x0087
            boolean r14 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x01de }
            if (r14 != 0) goto L_0x0087
            boolean r14 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01de }
            if (r14 != 0) goto L_0x0087
            com.google.android.gms.measurement.internal.zzfu r6 = r6.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzem r6 = r6.zzau()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzek r6 = r6.zzj()     // Catch:{ RuntimeException -> 0x01de }
            r6.zza(r7)     // Catch:{ RuntimeException -> 0x01de }
            goto L_0x005f
        L_0x0087:
            java.lang.String r14 = "https://google.com/search?"
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ RuntimeException -> 0x01de }
            int r16 = r15.length()     // Catch:{ RuntimeException -> 0x01de }
            if (r16 == 0) goto L_0x0098
            java.lang.String r14 = r14.concat(r15)     // Catch:{ RuntimeException -> 0x01de }
            goto L_0x009e
        L_0x0098:
            java.lang.String r15 = new java.lang.String     // Catch:{ RuntimeException -> 0x01de }
            r15.<init>(r14)     // Catch:{ RuntimeException -> 0x01de }
            r14 = r15
        L_0x009e:
            android.net.Uri r14 = android.net.Uri.parse(r14)     // Catch:{ RuntimeException -> 0x01de }
            android.os.Bundle r6 = r6.zzi(r14)     // Catch:{ RuntimeException -> 0x01de }
            if (r6 == 0) goto L_0x00ad
            java.lang.String r14 = "referrer"
            r6.putString(r9, r14)     // Catch:{ RuntimeException -> 0x01de }
        L_0x00ad:
            java.lang.String r14 = "_cmp"
            r15 = 1
            if (r0 == 0) goto L_0x0104
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzku r0 = r0.zzl()     // Catch:{ RuntimeException -> 0x01de }
            android.os.Bundle r0 = r0.zzi(r3)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 == 0) goto L_0x0105
            java.lang.String r3 = "intent"
            r0.putString(r9, r3)     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzab     // Catch:{ RuntimeException -> 0x01de }
            boolean r3 = r3.zzn(r8, r9)     // Catch:{ RuntimeException -> 0x01de }
            if (r3 == 0) goto L_0x00f7
            boolean r3 = r0.containsKey(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r3 != 0) goto L_0x00f7
            if (r6 == 0) goto L_0x00f7
            boolean r3 = r6.containsKey(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r3 == 0) goto L_0x00f7
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ RuntimeException -> 0x01de }
            r9 = 0
            java.lang.String r16 = r6.getString(r13)     // Catch:{ RuntimeException -> 0x01de }
            r3[r9] = r16     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r9 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.String r3 = java.lang.String.format(r15, r3)     // Catch:{ RuntimeException -> 0x01de }
            r0.putString(r9, r3)     // Catch:{ RuntimeException -> 0x01de }
        L_0x00f7:
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            r3.zzs(r4, r14, r0)     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzr r3 = r3.zzb     // Catch:{ RuntimeException -> 0x01de }
            r3.zzb(r4, r0)     // Catch:{ RuntimeException -> 0x01de }
            goto L_0x0105
        L_0x0104:
            r0 = r8
        L_0x0105:
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzea.zzad     // Catch:{ RuntimeException -> 0x01de }
            boolean r3 = r3.zzn(r8, r9)     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r9 = "auto"
            if (r3 == 0) goto L_0x0143
            com.google.android.gms.measurement.internal.zzhw r3 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r3 = r3.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r3 = r3.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01de }
            boolean r3 = r3.zzn(r8, r15)     // Catch:{ RuntimeException -> 0x01de }
            if (r3 != 0) goto L_0x0143
            if (r6 == 0) goto L_0x0143
            boolean r3 = r6.containsKey(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r3 == 0) goto L_0x0143
            if (r0 == 0) goto L_0x0137
            boolean r0 = r0.containsKey(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x0143
        L_0x0137:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r3 = "_lgclid"
            java.lang.String r15 = r6.getString(r13)     // Catch:{ RuntimeException -> 0x01de }
            r8 = 1
            r0.zzy(r9, r3, r15, r8)     // Catch:{ RuntimeException -> 0x01de }
        L_0x0143:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 == 0) goto L_0x014b
            goto L_0x01cd
        L_0x014b:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r5)     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzae r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzdz<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzea.zzac     // Catch:{ RuntimeException -> 0x01de }
            r8 = 0
            boolean r0 = r0.zzn(r8, r3)     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r3 = "_ldl"
            if (r0 == 0) goto L_0x0197
            if (r6 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            r0.zzs(r4, r14, r6)     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzb     // Catch:{ RuntimeException -> 0x01de }
            r0.zzb(r4, r6)     // Catch:{ RuntimeException -> 0x01de }
            goto L_0x018f
        L_0x017e:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01de }
            java.lang.String r4 = "Referrer does not contain valid parameters"
            r0.zzb(r4, r5)     // Catch:{ RuntimeException -> 0x01de }
        L_0x018f:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            r4 = 1
            r5 = 0
            r0.zzy(r9, r3, r5, r4)     // Catch:{ RuntimeException -> 0x01de }
            return
        L_0x0197:
            boolean r0 = r5.contains(r13)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 == 0) goto L_0x01ce
            boolean r0 = r5.contains(r12)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x01c1
            boolean r0 = r5.contains(r11)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x01c1
            boolean r0 = r5.contains(r10)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x01c1
            java.lang.String r0 = "utm_term"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x01c1
            java.lang.String r0 = "utm_content"
            boolean r0 = r5.contains(r0)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 == 0) goto L_0x01ce
        L_0x01c1:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ RuntimeException -> 0x01de }
            if (r0 != 0) goto L_0x01cd
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            r4 = 1
            r0.zzy(r9, r3, r5, r4)     // Catch:{ RuntimeException -> 0x01de }
        L_0x01cd:
            return
        L_0x01ce:
            com.google.android.gms.measurement.internal.zzhw r0 = r2.zza     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzfu r0 = r0.zzs     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzau()     // Catch:{ RuntimeException -> 0x01de }
            com.google.android.gms.measurement.internal.zzek r0 = r0.zzj()     // Catch:{ RuntimeException -> 0x01de }
            r0.zza(r7)     // Catch:{ RuntimeException -> 0x01de }
            return
        L_0x01de:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhw r2 = r2.zza
            com.google.android.gms.measurement.internal.zzfu r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhu.run():void");
    }
}
