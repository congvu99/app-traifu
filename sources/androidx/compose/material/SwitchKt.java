package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a?\u0010!\u001a\u00020\u0014*\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0006\u0010\u001c\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a1\u0010'\u001a\u00020\u0014*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\n\u0010\u000b\"\u0013\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0010\u0010\u000b\"\u0019\u0010\u0011\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Landroidx/compose/runtime/State;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float DefaultSwitchPadding = Dp.m4704constructorimpl((float) 2);
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation = Dp.m4704constructorimpl((float) 1);
    private static final float ThumbDiameter = Dp.m4704constructorimpl((float) 20);
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation = Dp.m4704constructorimpl((float) 6);
    private static final float ThumbRippleRadius = Dp.m4704constructorimpl((float) 24);
    private static final float TrackStrokeWidth = Dp.m4704constructorimpl((float) 14);
    private static final float TrackWidth = Dp.m4704constructorimpl((float) 34);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r35, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, androidx.compose.foundation.interaction.MutableInteractionSource r39, androidx.compose.material.SwitchColors r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r7 = r36
            r8 = r42
            r0 = 25866825(0x18ab249, float:5.094902E-38)
            r1 = r41
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,2,3)94@4383L39,95@4466L8,*98@4538L7,99@4599L72,100@4709L7,115@5150L1024:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r43 & 1
            r6 = 2
            if (r1 == 0) goto L_0x001c
            r1 = r8 | 6
            r5 = r35
            goto L_0x002e
        L_0x001c:
            r1 = r8 & 14
            r5 = r35
            if (r1 != 0) goto L_0x002d
            boolean r1 = r0.changed((boolean) r5)
            if (r1 == 0) goto L_0x002a
            r1 = 4
            goto L_0x002b
        L_0x002a:
            r1 = 2
        L_0x002b:
            r1 = r1 | r8
            goto L_0x002e
        L_0x002d:
            r1 = r8
        L_0x002e:
            r2 = r43 & 2
            if (r2 == 0) goto L_0x0035
            r1 = r1 | 48
            goto L_0x0045
        L_0x0035:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0045
            boolean r2 = r0.changed((java.lang.Object) r7)
            if (r2 == 0) goto L_0x0042
            r2 = 32
            goto L_0x0044
        L_0x0042:
            r2 = 16
        L_0x0044:
            r1 = r1 | r2
        L_0x0045:
            r2 = r43 & 4
            if (r2 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r3 = r8 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005f
            r3 = r37
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005b
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r4
            goto L_0x0061
        L_0x005f:
            r3 = r37
        L_0x0061:
            r4 = r43 & 8
            if (r4 == 0) goto L_0x0068
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r9 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007b
            r9 = r38
            boolean r10 = r0.changed((boolean) r9)
            if (r10 == 0) goto L_0x0077
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r1 = r1 | r10
            goto L_0x007d
        L_0x007b:
            r9 = r38
        L_0x007d:
            r10 = r43 & 16
            if (r10 == 0) goto L_0x0084
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r8
            if (r11 != 0) goto L_0x0099
            r11 = r39
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0095
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r12
            goto L_0x009b
        L_0x0099:
            r11 = r39
        L_0x009b:
            r32 = 458752(0x70000, float:6.42848E-40)
            r12 = r8 & r32
            if (r12 != 0) goto L_0x00b6
            r12 = r43 & 32
            if (r12 != 0) goto L_0x00b0
            r12 = r40
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x00b2
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b4
        L_0x00b0:
            r12 = r40
        L_0x00b2:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b4:
            r1 = r1 | r13
            goto L_0x00b8
        L_0x00b6:
            r12 = r40
        L_0x00b8:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r1
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00d0
            boolean r13 = r0.getSkipping()
            if (r13 != 0) goto L_0x00c8
            goto L_0x00d0
        L_0x00c8:
            r0.skipToGroupEnd()
            r4 = r9
            r5 = r11
            r6 = r12
            goto L_0x0371
        L_0x00d0:
            r0.startDefaults()
            r13 = r8 & 1
            r33 = -458753(0xfffffffffff8ffff, float:NaN)
            r34 = 1
            if (r13 == 0) goto L_0x00f6
            boolean r13 = r0.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00e3
            goto L_0x00f6
        L_0x00e3:
            r0.skipToGroupEnd()
            r2 = r43 & 32
            if (r2 == 0) goto L_0x00ec
            r1 = r1 & r33
        L_0x00ec:
            r15 = r3
            r17 = r9
            r30 = r11
            r31 = r12
        L_0x00f3:
            r9 = r1
            goto L_0x0161
        L_0x00f6:
            if (r2 == 0) goto L_0x00fd
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00fe
        L_0x00fd:
            r2 = r3
        L_0x00fe:
            if (r4 == 0) goto L_0x0102
            r3 = 1
            goto L_0x0103
        L_0x0102:
            r3 = r9
        L_0x0103:
            if (r10 == 0) goto L_0x0129
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r4 != r9) goto L_0x0123
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r4)
        L_0x0123:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            goto L_0x012a
        L_0x0129:
            r4 = r11
        L_0x012a:
            r9 = r43 & 32
            if (r9 == 0) goto L_0x0159
            androidx.compose.material.SwitchDefaults r9 = androidx.compose.material.SwitchDefaults.INSTANCE
            r10 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            r29 = 0
            r30 = 6
            r31 = 1023(0x3ff, float:1.434E-42)
            r28 = r0
            androidx.compose.material.SwitchColors r9 = r9.m1435colorsSQMK_m0(r10, r12, r14, r15, r17, r19, r20, r22, r24, r26, r28, r29, r30, r31)
            r1 = r1 & r33
            r15 = r2
            r17 = r3
            r30 = r4
            r31 = r9
            goto L_0x00f3
        L_0x0159:
            r9 = r1
            r15 = r2
            r17 = r3
            r30 = r4
            r31 = r12
        L_0x0161:
            r0.endDefaults()
            r10 = 0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r2 = ThumbPathLength
            float r13 = r1.m4649toPx0680j_4(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r35)
            if (r7 != 0) goto L_0x018d
            androidx.compose.material.SwitchKt$Switch$swipeableState$1 r2 = androidx.compose.material.SwitchKt$Switch$swipeableState$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            goto L_0x018e
        L_0x018d:
            r2 = r7
        L_0x018e:
            androidx.compose.animation.core.TweenSpec<java.lang.Float> r3 = AnimationSpec
            androidx.compose.animation.core.AnimationSpec r3 = (androidx.compose.animation.core.AnimationSpec) r3
            r4 = r9 & 14
            r14 = r4 | 384(0x180, float:5.38E-43)
            r16 = 0
            r4 = r0
            r5 = r14
            r14 = 2
            r6 = r16
            androidx.compose.material.SwipeableState r16 = androidx.compose.material.SwipeableKt.rememberSwipeableStateFor(r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r12)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r6 = 0
            if (r1 != r2) goto L_0x01b9
            r23 = 1
            goto L_0x01bb
        L_0x01b9:
            r23 = 0
        L_0x01bb:
            if (r7 == 0) goto L_0x01de
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r2 = androidx.compose.ui.semantics.Role.Companion
            int r2 = r2.m4095getSwitcho7Vup1c()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r3 = 0
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m4084boximpl(r2)
            r4 = r0
            r0 = r1
            r1 = r35
            r2 = r30
            r11 = r4
            r4 = r17
            r38 = 0
            r6 = r36
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m820toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01e5
        L_0x01de:
            r11 = r0
            r38 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01e5:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            if (r7 == 0) goto L_0x01ef
            androidx.compose.ui.Modifier r1 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x01ef:
            androidx.compose.ui.Modifier r1 = r15.then(r1)
            androidx.compose.ui.Modifier r18 = r1.then(r0)
            kotlin.Pair[] r0 = new kotlin.Pair[r14]
            java.lang.Float r1 = java.lang.Float.valueOf(r10)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r38)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            r2 = 0
            r0[r2] = r1
            java.lang.Float r1 = java.lang.Float.valueOf(r13)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r34)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r3)
            r0[r34] = r1
            java.util.Map r20 = kotlin.collections.MapsKt.mapOf(r0)
            androidx.compose.foundation.gestures.Orientation r21 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r17 == 0) goto L_0x0223
            if (r7 == 0) goto L_0x0223
            r22 = 1
            goto L_0x0225
        L_0x0223:
            r22 = 0
        L_0x0225:
            androidx.compose.material.SwitchKt$Switch$2 r0 = androidx.compose.material.SwitchKt$Switch$2.INSTANCE
            r25 = r0
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r26 = 0
            r27 = 0
            r28 = 256(0x100, float:3.59E-43)
            r29 = 0
            r19 = r16
            r24 = r30
            androidx.compose.ui.Modifier r0 = androidx.compose.material.SwipeableKt.m1430swipeablepPrIpRY$default(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            r3 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r0, r1, r2, r14, r3)
            float r1 = DefaultSwitchPadding
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r0, r1)
            float r1 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m576requiredSizeVpY3zN4(r0, r1, r3)
            r1 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r2, r11, r2)
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r12)
            java.lang.Object r3 = r11.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r12)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r4, r12)
            java.lang.Object r4 = r11.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r10 = r11.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x02c2
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02c2:
            r11.startReusableNode()
            boolean r10 = r11.getInserting()
            if (r10 == 0) goto L_0x02cf
            r11.createNode(r6)
            goto L_0x02d2
        L_0x02cf:
            r11.useNode()
        L_0x02d2:
            r11.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r1, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r4, r1)
            r11.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r11, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r1 = 1571176015(0x5da63e4f, float:1.49738737E18)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C135@5958L210:Switch.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            androidx.compose.runtime.State r13 = r16.getOffset()
            r14 = r30
            androidx.compose.foundation.interaction.InteractionSource r14 = (androidx.compose.foundation.interaction.InteractionSource) r14
            int r1 = r9 << 3
            r2 = r1 & 112(0x70, float:1.57E-43)
            r3 = 6
            r2 = r2 | r3
            int r4 = r9 >> 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            int r3 = r9 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r1 = r1 & r32
            r16 = r2 | r1
            r9 = r0
            r10 = r35
            r0 = r11
            r11 = r17
            r12 = r31
            r2 = r15
            r15 = r0
            SwitchImpl(r9, r10, r11, r12, r13, r14, r15, r16)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r2
            r4 = r17
            r5 = r30
            r6 = r31
        L_0x0371:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0378
            goto L_0x038b
        L_0x0378:
            androidx.compose.material.SwitchKt$Switch$4 r10 = new androidx.compose.material.SwitchKt$Switch$4
            r0 = r10
            r1 = r35
            r2 = r36
            r7 = r42
            r8 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x038b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void SwitchImpl(BoxScope boxScope, boolean z, boolean z2, SwitchColors switchColors, State<Float> state, InteractionSource interactionSource, Composer composer, int i) {
        int i2;
        float f;
        long j;
        String str;
        int i3;
        BoxScope boxScope2 = boxScope;
        boolean z3 = z;
        boolean z4 = z2;
        SwitchColors switchColors2 = switchColors;
        State<Float> state2 = state;
        InteractionSource interactionSource2 = interactionSource;
        int i4 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1834839253);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(!1,2!1,4)181@7257L46,183@7343L614,183@7309L648,202@8160L28,203@8248L81,203@8193L136,206@8359L28,207@8437L7,*208@8496L7,210@8585L6,218@8838L47,221@8995L59,215@8751L479:Switch.kt#jmzs0o");
        if ((i4 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) boxScope2) ? 4 : 2) | i4;
        } else {
            i2 = i4;
        }
        if ((i4 & 112) == 0) {
            i2 |= startRestartGroup.changed(z3) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i2 |= startRestartGroup.changed(z4) ? 256 : 128;
        }
        if ((i4 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) switchColors2) ? 2048 : 1024;
        }
        if ((57344 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) state2) ? 16384 : 8192;
        }
        if ((458752 & i4) == 0) {
            i2 |= startRestartGroup.changed((Object) interactionSource2) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            int i5 = (i2 >> 15) & 14;
            startRestartGroup.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) interactionSource2) | startRestartGroup.changed((Object) snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource2, snapshotStateList, (Continuation<? super SwitchKt$SwitchImpl$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) interactionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, i5);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float f2 = f;
            int i6 = ((i2 >> 3) & 896) | ((i2 >> 6) & 14) | (i2 & 112);
            State<Color> trackColor = switchColors2.trackColor(z4, z3, startRestartGroup, i6);
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getCenter()), 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed((Object) trackColor);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new SwitchKt$SwitchImpl$2$1(trackColor);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue3, startRestartGroup, 0);
            State<Color> thumbColor = switchColors2.thumbColor(z4, z3, startRestartGroup, i6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float r11 = Dp.m4704constructorimpl(((Dp) consume2).m4718unboximpl() + f2);
            startRestartGroup.startReplaceableGroup(-539245361);
            ComposerKt.sourceInformation(startRestartGroup, "211@8660L36");
            float f3 = f2;
            if (!Color.m1933equalsimpl0(m1437SwitchImpl$lambda7(thumbColor), MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1218getSurface0d7_KjU()) || elevationOverlay == null) {
                str = "C(remember)P(1):Composables.kt#9igjgp";
                i3 = 0;
                j = m1437SwitchImpl$lambda7(thumbColor);
            } else {
                long r2 = m1437SwitchImpl$lambda7(thumbColor);
                ElevationOverlay elevationOverlay2 = elevationOverlay;
                long j2 = r2;
                i3 = 0;
                str = "C(remember)P(1):Composables.kt#9igjgp";
                j = elevationOverlay2.m1282apply7g2Lkgo(j2, r11, startRestartGroup, 0);
            }
            long j3 = j;
            startRestartGroup.endReplaceableGroup();
            Modifier align = boxScope2.align(Modifier.Companion, Alignment.Companion.getCenterStart());
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, str);
            boolean changed3 = startRestartGroup.changed((Object) state2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new SwitchKt$SwitchImpl$3$1(state2);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m176backgroundbw27NRU(ShadowKt.m1600shadows4CzXII$default(SizeKt.m574requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue4), interactionSource2, RippleKt.m1521rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0, startRestartGroup, 54, 4)), ThumbDiameter), f3, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 24, (Object) null), j3, RoundedCornerShapeKt.getCircleShape()), startRestartGroup, i3);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SwitchKt$SwitchImpl$4(boxScope, z, z2, switchColors, state, interactionSource, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk  reason: not valid java name */
    public static final void m1440drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / ((float) 2);
        DrawScope.CC.m2506drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m1684getYimpl(drawScope.m2477getCenterF1C5BW0())), f2, StrokeCap.Companion.m2288getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    /* access modifiers changed from: private */
    /* renamed from: SwitchImpl$lambda-5  reason: not valid java name */
    public static final long m1436SwitchImpl$lambda5(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    /* renamed from: SwitchImpl$lambda-7  reason: not valid java name */
    private static final long m1437SwitchImpl$lambda7(State<Color> state) {
        return state.getValue().m1942unboximpl();
    }

    static {
        float f = TrackWidth;
        SwitchWidth = f;
        float f2 = ThumbDiameter;
        SwitchHeight = f2;
        ThumbPathLength = Dp.m4704constructorimpl(f - f2);
    }
}
