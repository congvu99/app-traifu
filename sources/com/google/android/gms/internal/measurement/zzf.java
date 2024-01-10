package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzf {
    final zzax zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd = new zzj();

    public zzf() {
        zzax zzax = new zzax();
        this.zza = zzax;
        zzg zzg = new zzg((zzg) null, zzax);
        this.zzc = zzg;
        this.zzb = zzg.zzc();
        this.zzc.zze("require", new zzv(this.zzd));
        this.zzd.zza("internal.platform", zze.zza);
        this.zzc.zze("runtime.counter", new zzah(Double.valueOf(Utils.DOUBLE_EPSILON)));
    }

    public final zzap zza(zzg zzg, zzgt... zzgtArr) {
        zzap zzap = zzap.zzf;
        for (zzgt zzb2 : zzgtArr) {
            zzap = zzi.zzb(zzb2);
            zzh.zzk(this.zzc);
            if ((zzap instanceof zzaq) || (zzap instanceof zzao)) {
                zzap = this.zza.zzb(zzg, zzap);
            }
        }
        return zzap;
    }
}
