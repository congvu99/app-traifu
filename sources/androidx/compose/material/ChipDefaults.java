package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 Jo\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)JQ\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010 Jo\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    public static final float LeadingIconOpacity = 0.54f;
    private static final float LeadingIconSize = Dp.m4704constructorimpl((float) 20);
    private static final float MinHeight = Dp.m4704constructorimpl((float) 32);
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize = Dp.m4704constructorimpl((float) 1);
    private static final float SelectedIconSize = Dp.m4704constructorimpl((float) 18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1197getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1194chipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1838505436);
        ComposerKt.sourceInformation(composer2, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)384@16784L6,385@16878L6,386@16939L6,389@17141L6,390@17201L8,391@17276L6,393@17383L8,396@17531L8:Chip.kt#jmzs0o");
        long r6 = (i2 & 1) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j;
        long r3 = (i2 & 2) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r10 = (i2 & 4) != 0 ? Color.m1931copywmQWz5c$default(r3, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        DefaultChipColors defaultChipColors = new DefaultChipColors(r6, r3, r10, (i2 & 8) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j4, (i2 & 16) != 0 ? Color.m1931copywmQWz5c$default(r3, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5, (i2 & 32) != 0 ? Color.m1931copywmQWz5c$default(r10, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc  reason: not valid java name */
    public final ChipColors m1200outlinedChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i;
        composer2.startReplaceableGroup(-1763922662);
        ComposerKt.sourceInformation(composer2, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)420@18727L6,421@18787L6,425@19070L8,428@19218L8,429@19270L342:Chip.kt#jmzs0o");
        long r3 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        long r5 = (i2 & 2) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r7 = (i2 & 4) != 0 ? Color.m1931copywmQWz5c$default(r5, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        ChipColors r0 = m1194chipColors5tl4gsc(r3, r5, r7, (i2 & 8) != 0 ? r3 : j4, (i2 & 16) != 0 ? Color.m1931copywmQWz5c$default(r5, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5, (i2 & 32) != 0 ? Color.m1931copywmQWz5c$default(r7, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6, composer, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: filterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m1195filterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(830140629);
        ComposerKt.sourceInformation(composer2, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)454@20609L6,455@20703L6,456@20764L6,459@20951L6,460@21011L8,461@21086L6,463@21193L8,466@21328L8,468@21424L6,471@21583L6,474@21744L6:Chip.kt#jmzs0o");
        long r7 = (i3 & 1) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j;
        long r4 = (i3 & 2) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r11 = (i3 & 4) != 0 ? Color.m1931copywmQWz5c$default(r4, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(r7, r4, r11, (i3 & 8) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU()) : j4, (i3 & 16) != 0 ? Color.m1931copywmQWz5c$default(r4, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5, (i3 & 32) != 0 ? Color.m1931copywmQWz5c$default(r11, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6, (i3 & 64) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r7) : j7, (i3 & 128) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r4) : j8, (i3 & 256) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r11) : j9, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E  reason: not valid java name */
    public final SelectableChipColors m1201outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        Composer composer2 = composer;
        int i3 = i2;
        composer2.startReplaceableGroup(346878099);
        ComposerKt.sourceInformation(composer2, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)505@23394L6,506@23454L6,510@23714L8,513@23849L8,515@23945L6,518@24105L6,521@24266L6:Chip.kt#jmzs0o");
        long r7 = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        long r4 = (i3 & 2) != 0 ? Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j2;
        long r11 = (i3 & 4) != 0 ? Color.m1931copywmQWz5c$default(r4, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j3;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(r7, r4, r11, (i3 & 8) != 0 ? r7 : j4, (i3 & 16) != 0 ? Color.m1931copywmQWz5c$default(r4, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5, (i3 & 32) != 0 ? Color.m1931copywmQWz5c$default(r11, ContentAlpha.INSTANCE.getDisabled(composer2, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6, (i3 & 64) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r7) : j7, (i3 & 128) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r4) : j8, (i3 & 256) != 0 ? ColorKt.m1978compositeOverOWjLjI(Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer2, 6).m1213getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, (Object) null), r11) : j9, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-1650225597);
        ComposerKt.sourceInformation(composer, "C542@25113L6:Chip.kt#jmzs0o");
        BorderStroke r11 = BorderStrokeKt.m191BorderStrokecXLIe8U(OutlinedBorderSize, Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1213getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
        composer.endReplaceableGroup();
        return r11;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM  reason: not valid java name */
    public final float m1198getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1196getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1199getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
