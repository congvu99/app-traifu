package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m1392colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i3;
        composer2.startReplaceableGroup(436017687);
        ComposerKt.sourceInformation(composer2, "C(colors)P(9:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color)468@20392L6,469@20458L6,470@20514L8,471@20565L6,472@20630L6,475@20801L6,478@21014L33:Slider.kt#jmzs0o");
        long r7 = (i4 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j;
        long r9 = (i4 & 2) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j2;
        long r11 = (i4 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1214getPrimary0d7_KjU() : j3;
        long r13 = (i4 & 8) != 0 ? Color.m1931copywmQWz5c$default(r11, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j4;
        long r15 = (i4 & 16) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5;
        long r17 = (i4 & 32) != 0 ? Color.m1931copywmQWz5c$default(r15, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long r19 = (i4 & 64) != 0 ? Color.m1931copywmQWz5c$default(ColorsKt.m1232contentColorForek8zF_U(r11, composer2, (i >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j7;
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(r7, r9, r11, r13, r15, r17, r19, (i4 & 128) != 0 ? Color.m1931copywmQWz5c$default(r11, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j8, (i4 & 256) != 0 ? Color.m1931copywmQWz5c$default(r19, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j9, (i4 & 512) != 0 ? Color.m1931copywmQWz5c$default(r17, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j10, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
