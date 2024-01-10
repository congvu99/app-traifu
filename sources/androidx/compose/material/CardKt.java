package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardKt {
    /* renamed from: Card-F-jzlyU  reason: not valid java name */
    public static final void m1177CardFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        long j3;
        float f2;
        Composer composer2 = composer;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(1956755640);
        ComposerKt.sourceInformation(composer2, "C(Card)P(5,6,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)60@2616L6,61@2674L6,62@2716L32,67@2854L218:Card.kt#jmzs0o");
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        Shape medium = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium() : shape;
        long r3 = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        if ((i2 & 8) != 0) {
            j3 = ColorsKt.m1232contentColorForek8zF_U(r3, composer2, (i3 >> 6) & 14);
        } else {
            j3 = j2;
        }
        BorderStroke borderStroke2 = (i2 & 16) != 0 ? null : borderStroke;
        if ((i2 & 32) != 0) {
            f2 = Dp.m4704constructorimpl((float) 1);
        } else {
            f2 = f;
        }
        SurfaceKt.m1419SurfaceFjzlyU(modifier2, medium, r3, j3, borderStroke2, f2, function2, composer, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016), 0);
        composer.endReplaceableGroup();
    }

    @ExperimentalMaterialApi
    /* renamed from: Card-LPr_se0  reason: not valid java name */
    public static final void m1178CardLPr_se0(Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2) {
        long j3;
        float f2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2 = composer;
        int i3 = i;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(778538979);
        ComposerKt.sourceInformation(composer2, "C(Card)P(8,7,5,9,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)111@4759L6,112@4817L6,113@4859L32,116@5003L39,119@5088L319:Card.kt#jmzs0o");
        Modifier modifier2 = (i4 & 2) != 0 ? Modifier.Companion : modifier;
        boolean z2 = (i4 & 4) != 0 ? true : z;
        Shape medium = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium() : shape;
        long r7 = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        if ((i4 & 32) != 0) {
            j3 = ColorsKt.m1232contentColorForek8zF_U(r7, composer2, (i3 >> 12) & 14);
        } else {
            j3 = j2;
        }
        BorderStroke borderStroke2 = (i4 & 64) != 0 ? null : borderStroke;
        if ((i4 & 128) != 0) {
            f2 = Dp.m4704constructorimpl((float) 1);
        } else {
            f2 = f;
        }
        if ((i4 & 256) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        SurfaceKt.m1420SurfaceLPr_se0(function0, modifier2, z2, medium, r7, j3, borderStroke2, f2, mutableInteractionSource2, function2, composer, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
        composer.endReplaceableGroup();
    }

    @ExperimentalMaterialApi
    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Card-9VG74zQ  reason: not valid java name */
    public static final void m1176Card9VG74zQ(Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i, int i2, int i3) {
        long j3;
        float f2;
        MutableInteractionSource mutableInteractionSource2;
        Indication indication2;
        Composer composer2 = composer;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer2.startReplaceableGroup(1353606722);
        ComposerKt.sourceInformation(composer2, "C(Card)P(9,8,12,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)182@7959L6,183@8017L6,184@8059L32,187@8203L39,188@8290L7,195@8465L410:Card.kt#jmzs0o");
        Modifier modifier2 = (i6 & 2) != 0 ? Modifier.Companion : modifier;
        Shape medium = (i6 & 4) != 0 ? MaterialTheme.INSTANCE.getShapes(composer2, 6).getMedium() : shape;
        long r6 = (i6 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer2, 6).m1218getSurface0d7_KjU() : j;
        if ((i6 & 16) != 0) {
            j3 = ColorsKt.m1232contentColorForek8zF_U(r6, composer2, (i4 >> 9) & 14);
        } else {
            j3 = j2;
        }
        BorderStroke borderStroke2 = (i6 & 32) != 0 ? null : borderStroke;
        if ((i6 & 64) != 0) {
            f2 = Dp.m4704constructorimpl((float) 1);
        } else {
            f2 = f;
        }
        if ((i6 & 128) != 0) {
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i6 & 256) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer2.consume(IndicationKt.getLocalIndication());
            ComposerKt.sourceInformationMarkerEnd(composer);
            indication2 = (Indication) consume;
        } else {
            indication2 = indication;
        }
        SurfaceKt.m1418Surface9VG74zQ(function0, modifier2, medium, r6, j3, borderStroke2, f2, mutableInteractionSource2, indication2, (i6 & 512) != 0 ? true : z, (i6 & 1024) != 0 ? null : str, (i6 & 2048) != 0 ? null : role, function2, composer, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i5 & 14) | (i5 & 112) | (i5 & 896), 0);
        composer.endReplaceableGroup();
    }
}
