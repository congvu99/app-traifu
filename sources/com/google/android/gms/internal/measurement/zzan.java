package com.google.android.gms.internal.measurement;

import com.github.mikephil.charting.utils.Utils;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.JsonLexerKt;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
public final class zzan implements zzap {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzan;
    }

    public final int hashCode() {
        return 1;
    }

    public final zzap zzbK(String str, zzg zzg, List<zzap> list) {
        throw new IllegalStateException(String.format("null has no function %s", new Object[]{str}));
    }

    public final String zzc() {
        return JsonLexerKt.NULL;
    }

    public final Double zzd() {
        return Double.valueOf(Utils.DOUBLE_EPSILON);
    }

    public final Boolean zze() {
        return false;
    }

    public final Iterator<zzap> zzf() {
        return null;
    }

    public final zzap zzt() {
        return zzap.zzg;
    }
}