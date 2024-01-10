package com.google.android.gms.internal.measurement;

import io.intercom.android.sdk.models.carousel.ActionType;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public interface zzap {
    public static final zzap zzf = new zzau();
    public static final zzap zzg = new zzan();
    public static final zzap zzh = new zzag(ActionType.CONTINUE);
    public static final zzap zzi = new zzag("break");
    public static final zzap zzj = new zzag("return");
    public static final zzap zzk = new zzaf(Boolean.TRUE);
    public static final zzap zzl = new zzaf(Boolean.FALSE);
    public static final zzap zzm = new zzat("");

    zzap zzbK(String str, zzg zzg2, List<zzap> list);

    String zzc();

    Double zzd();

    Boolean zze();

    Iterator<zzap> zzf();

    zzap zzt();
}
