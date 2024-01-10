package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u0004H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/material/MaterialRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
final class MaterialRippleTheme implements RippleTheme {
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    private MaterialRippleTheme() {
    }

    /* renamed from: defaultColor-WaAFU9c  reason: not valid java name */
    public long m1320defaultColorWaAFU9c(Composer composer, int i) {
        composer.startReplaceableGroup(550536719);
        ComposerKt.sourceInformation(composer, "C(defaultColor)127@5167L7,128@5211L6:MaterialTheme.kt#jmzs0o");
        RippleTheme.Companion companion = RippleTheme.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long r0 = companion.m1524defaultRippleColor5vOe2sY(((Color) consume).m1942unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        composer.endReplaceableGroup();
        return r0;
    }

    public RippleAlpha rippleAlpha(Composer composer, int i) {
        composer.startReplaceableGroup(-1419762518);
        ComposerKt.sourceInformation(composer, "C(rippleAlpha)133@5355L7,134@5399L6:MaterialTheme.kt#jmzs0o");
        RippleTheme.Companion companion = RippleTheme.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        RippleAlpha r6 = companion.m1523defaultRippleAlphaDxMtmZc(((Color) consume).m1942unboximpl(), MaterialTheme.INSTANCE.getColors(composer, 6).isLight());
        composer.endReplaceableGroup();
        return r6;
    }
}
