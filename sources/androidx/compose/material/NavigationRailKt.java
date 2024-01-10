package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00012 \b\u0002\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\u001c\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0001\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u001d2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\b\b\u0002\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010'\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a=\u0010*\u001a\u00020\f2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\f0\u001f¢\u0006\u0002\b\u00162\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f¢\u0006\u0002\b\u00162\u0006\u0010+\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010,\u001aU\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2&\u0010\u0018\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\f0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001a)\u00105\u001a\u000206*\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=\u001a9\u0010>\u001a\u000206*\u0002072\u0006\u0010?\u001a\u0002092\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
public final class NavigationRailKt {
    /* access modifiers changed from: private */
    public static final float HeaderPadding;
    private static final float ItemIconTopOffset = Dp.m4704constructorimpl((float) 14);
    private static final float ItemLabelBaselineBottomOffset = Dp.m4704constructorimpl((float) 16);
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, (DefaultConstructorMarker) null);
    private static final float NavigationRailItemCompactSize = Dp.m4704constructorimpl((float) 56);
    private static final float NavigationRailItemSize = Dp.m4704constructorimpl((float) 72);
    /* access modifiers changed from: private */
    public static final float NavigationRailPadding;

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0176  */
    /* renamed from: NavigationRail-HsRjFd4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1340NavigationRailHsRjFd4(androidx.compose.ui.Modifier r24, long r25, long r27, float r29, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r8 = r31
            r9 = r33
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1790971523(0x6ac00e83, float:1.1609114E26)
            r1 = r32
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)94@4333L6,95@4375L32,100@4577L552:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r34 & 1
            if (r1 == 0) goto L_0x0021
            r2 = r9 | 6
            r3 = r2
            r2 = r24
            goto L_0x0035
        L_0x0021:
            r2 = r9 & 14
            if (r2 != 0) goto L_0x0032
            r2 = r24
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002f
            r3 = 4
            goto L_0x0030
        L_0x002f:
            r3 = 2
        L_0x0030:
            r3 = r3 | r9
            goto L_0x0035
        L_0x0032:
            r2 = r24
            r3 = r9
        L_0x0035:
            r4 = r9 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004e
            r4 = r34 & 2
            if (r4 != 0) goto L_0x0048
            r4 = r25
            boolean r6 = r0.changed((long) r4)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x0048:
            r4 = r25
        L_0x004a:
            r6 = 16
        L_0x004c:
            r3 = r3 | r6
            goto L_0x0050
        L_0x004e:
            r4 = r25
        L_0x0050:
            r6 = r9 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0069
            r6 = r34 & 4
            if (r6 != 0) goto L_0x0063
            r6 = r27
            boolean r10 = r0.changed((long) r6)
            if (r10 == 0) goto L_0x0065
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0063:
            r6 = r27
        L_0x0065:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r3 = r3 | r10
            goto L_0x006b
        L_0x0069:
            r6 = r27
        L_0x006b:
            r10 = r34 & 8
            if (r10 == 0) goto L_0x0072
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0085
        L_0x0072:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0085
            r11 = r29
            boolean r12 = r0.changed((float) r11)
            if (r12 == 0) goto L_0x0081
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r3 = r3 | r12
            goto L_0x0087
        L_0x0085:
            r11 = r29
        L_0x0087:
            r12 = r34 & 16
            if (r12 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008e:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00a3
            r13 = r30
            boolean r14 = r0.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x009f
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r3 = r3 | r14
            goto L_0x00a5
        L_0x00a3:
            r13 = r30
        L_0x00a5:
            r14 = r34 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00af
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x00ad:
            r3 = r3 | r14
            goto L_0x00bf
        L_0x00af:
            r14 = r9 & r15
            if (r14 != 0) goto L_0x00bf
            boolean r14 = r0.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x00bc
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ad
        L_0x00bc:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ad
        L_0x00bf:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r3
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r14 != r15) goto L_0x00d9
            boolean r14 = r0.getSkipping()
            if (r14 != 0) goto L_0x00cf
            goto L_0x00d9
        L_0x00cf:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r4
            r4 = r6
            r6 = r11
            r7 = r13
            goto L_0x016f
        L_0x00d9:
            r0.startDefaults()
            r14 = r9 & 1
            r15 = 6
            if (r14 == 0) goto L_0x00fc
            boolean r14 = r0.getDefaultsInvalid()
            if (r14 == 0) goto L_0x00e8
            goto L_0x00fc
        L_0x00e8:
            r0.skipToGroupEnd()
            r1 = r34 & 2
            if (r1 == 0) goto L_0x00f1
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00f1:
            r1 = r34 & 4
            if (r1 == 0) goto L_0x00f7
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00f7:
            r1 = r2
        L_0x00f8:
            r10 = r3
            r2 = r11
            r3 = r13
            goto L_0x0132
        L_0x00fc:
            if (r1 == 0) goto L_0x0103
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0104
        L_0x0103:
            r1 = r2
        L_0x0104:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x0114
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r0, r15)
            long r4 = r2.m1218getSurface0d7_KjU()
            r3 = r3 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0114:
            r2 = r34 & 4
            if (r2 == 0) goto L_0x0123
            int r2 = r3 >> 3
            r2 = r2 & 14
            long r6 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r4, r0, r2)
            r2 = r3 & -897(0xfffffffffffffc7f, float:NaN)
            r3 = r2
        L_0x0123:
            if (r10 == 0) goto L_0x012c
            androidx.compose.material.NavigationRailDefaults r2 = androidx.compose.material.NavigationRailDefaults.INSTANCE
            float r2 = r2.m1339getElevationD9Ej5fM()
            r11 = r2
        L_0x012c:
            if (r12 == 0) goto L_0x00f8
            r2 = 0
            r10 = r3
            r3 = r2
            r2 = r11
        L_0x0132:
            r0.endDefaults()
            r11 = 0
            r16 = 0
            r12 = -1571506489(0xffffffffa254b6c7, float:-2.882812E-18)
            androidx.compose.material.NavigationRailKt$NavigationRail$1 r13 = new androidx.compose.material.NavigationRailKt$NavigationRail$1
            r13.<init>(r3, r10, r8)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r12 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r14, r13)
            r18 = r12
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            r12 = 1572864(0x180000, float:2.204052E-39)
            r13 = r10 & 14
            r12 = r12 | r13
            int r13 = r10 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r12 = r12 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | r13
            int r10 = r10 << r15
            r13 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            r20 = r12 | r10
            r21 = 18
            r10 = r1
            r12 = r4
            r14 = r6
            r17 = r2
            r19 = r0
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21)
            r22 = r6
            r6 = r2
            r7 = r3
            r2 = r4
            r4 = r22
        L_0x016f:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x0176
            goto L_0x0187
        L_0x0176:
            androidx.compose.material.NavigationRailKt$NavigationRail$2 r12 = new androidx.compose.material.NavigationRailKt$NavigationRail$2
            r0 = r12
            r8 = r31
            r9 = r33
            r10 = r34
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r11.updateScope(r12)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m1340NavigationRailHsRjFd4(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02fe  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126  */
    /* renamed from: NavigationRailItem-0S3VyRs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1341NavigationRailItem0S3VyRs(boolean r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.ui.Modifier r26, boolean r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, androidx.compose.foundation.interaction.MutableInteractionSource r30, long r31, long r33, androidx.compose.runtime.Composer r35, int r36, int r37) {
        /*
            r2 = r24
            r3 = r25
            r13 = r36
            r14 = r37
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "icon"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = -1813548445(0xffffffff93e77263, float:-5.8425392E-27)
            r1 = r35
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)154@6931L39,155@7020L6,156@7090L7,156@7124L6,171@7922L83,175@8010L791:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r14 & 1
            if (r1 == 0) goto L_0x002a
            r1 = r13 | 6
            r4 = r1
            r1 = r23
            goto L_0x003e
        L_0x002a:
            r1 = r13 & 14
            if (r1 != 0) goto L_0x003b
            r1 = r23
            boolean r4 = r0.changed((boolean) r1)
            if (r4 == 0) goto L_0x0038
            r4 = 4
            goto L_0x0039
        L_0x0038:
            r4 = 2
        L_0x0039:
            r4 = r4 | r13
            goto L_0x003e
        L_0x003b:
            r1 = r23
            r4 = r13
        L_0x003e:
            r5 = r14 & 2
            if (r5 == 0) goto L_0x0045
            r4 = r4 | 48
            goto L_0x0055
        L_0x0045:
            r5 = r13 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0055
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0052
            r5 = 32
            goto L_0x0054
        L_0x0052:
            r5 = 16
        L_0x0054:
            r4 = r4 | r5
        L_0x0055:
            r5 = r14 & 4
            if (r5 == 0) goto L_0x005c
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x005c:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006c
            boolean r5 = r0.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x0069
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r4 = r4 | r5
        L_0x006c:
            r5 = r14 & 8
            if (r5 == 0) goto L_0x0073
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0086
            r6 = r26
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0082
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r4 = r4 | r7
            goto L_0x0088
        L_0x0086:
            r6 = r26
        L_0x0088:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x008f
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x008f:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00a4
            r8 = r27
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x00a0
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r4 = r4 | r9
            goto L_0x00a6
        L_0x00a4:
            r8 = r27
        L_0x00a6:
            r9 = r14 & 32
            if (r9 == 0) goto L_0x00ae
            r10 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r10
            goto L_0x00c2
        L_0x00ae:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00c2
            r10 = r28
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00be
            r11 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r11 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r4 = r4 | r11
            goto L_0x00c4
        L_0x00c2:
            r10 = r28
        L_0x00c4:
            r11 = r14 & 64
            if (r11 == 0) goto L_0x00cc
            r12 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r12
            goto L_0x00e0
        L_0x00cc:
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r13
            if (r12 != 0) goto L_0x00e0
            r12 = r29
            boolean r15 = r0.changed((boolean) r12)
            if (r15 == 0) goto L_0x00dc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r4 = r4 | r15
            goto L_0x00e2
        L_0x00e0:
            r12 = r29
        L_0x00e2:
            r15 = r14 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x00ed
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r16
            r1 = r30
            goto L_0x0102
        L_0x00ed:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            r1 = r30
            if (r16 != 0) goto L_0x0102
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00fe
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r4 = r4 | r16
        L_0x0102:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x011e
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0117
            r1 = r31
            boolean r16 = r0.changed((long) r1)
            if (r16 == 0) goto L_0x0119
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011b
        L_0x0117:
            r1 = r31
        L_0x0119:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011b:
            r4 = r4 | r16
            goto L_0x0120
        L_0x011e:
            r1 = r31
        L_0x0120:
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x013c
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x0135
            r1 = r33
            boolean r16 = r0.changed((long) r1)
            if (r16 == 0) goto L_0x0137
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0135:
            r1 = r33
        L_0x0137:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0139:
            r4 = r4 | r16
            goto L_0x013e
        L_0x013c:
            r1 = r33
        L_0x013e:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r4 & r16
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x015e
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x014f
            goto L_0x015e
        L_0x014f:
            r0.skipToGroupEnd()
            r4 = r6
            r5 = r8
            r6 = r10
            r7 = r12
            r8 = r30
            r9 = r31
            r11 = r33
            goto L_0x03a8
        L_0x015e:
            r0.startDefaults()
            r1 = r13 & 1
            r16 = 0
            r17 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            r6 = 1
            if (r1 == 0) goto L_0x018f
            boolean r1 = r0.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0174
            goto L_0x018f
        L_0x0174:
            r0.skipToGroupEnd()
            r1 = r14 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x017d
            r4 = r4 & r17
        L_0x017d:
            r1 = r14 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0185
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r1
        L_0x0185:
            r1 = r26
            r5 = r30
            r18 = r31
        L_0x018b:
            r20 = r33
            goto L_0x021f
        L_0x018f:
            if (r5 == 0) goto L_0x0196
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0198
        L_0x0196:
            r1 = r26
        L_0x0198:
            if (r7 == 0) goto L_0x019b
            r8 = 1
        L_0x019b:
            if (r9 == 0) goto L_0x019f
            r10 = r16
        L_0x019f:
            if (r11 == 0) goto L_0x01a2
            r12 = 1
        L_0x01a2:
            if (r15 == 0) goto L_0x01c8
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            java.lang.Object r5 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x01c2
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r5)
        L_0x01c2:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            goto L_0x01ca
        L_0x01c8:
            r5 = r30
        L_0x01ca:
            r7 = r14 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x01dc
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 6
            androidx.compose.material.Colors r7 = r7.getColors(r0, r9)
            long r18 = r7.m1214getPrimary0d7_KjU()
            r4 = r4 & r17
            goto L_0x01de
        L_0x01dc:
            r18 = r31
        L_0x01de:
            r7 = r14 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x018b
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r2)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r20 = r7.m1942unboximpl()
            androidx.compose.material.ContentAlpha r7 = androidx.compose.material.ContentAlpha.INSTANCE
            r9 = 6
            float r7 = r7.getMedium(r0, r9)
            r9 = 0
            r11 = 0
            r15 = 0
            r17 = 14
            r22 = 0
            r26 = r20
            r28 = r7
            r29 = r9
            r30 = r11
            r31 = r15
            r32 = r17
            r33 = r22
            long r20 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r26, r28, r29, r30, r31, r32, r33)
            r7 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r4 = r4 & r7
        L_0x021f:
            r0.endDefaults()
            if (r10 == 0) goto L_0x0234
            r7 = -180398615(0xfffffffff53f55e9, float:-2.4254667E32)
            androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1 r9 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$styledLabel$1$1
            r9.<init>(r10, r4)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r6, r9)
            r16 = r7
            kotlin.jvm.functions.Function2 r16 = (kotlin.jvm.functions.Function2) r16
        L_0x0234:
            r7 = r16
            if (r10 != 0) goto L_0x023b
            float r9 = NavigationRailItemCompactSize
            goto L_0x023d
        L_0x023b:
            float r9 = NavigationRailItemSize
        L_0x023d:
            r11 = 0
            r15 = 0
            int r6 = r4 >> 18
            r6 = r6 & 896(0x380, float:1.256E-42)
            r16 = 6
            r6 = r6 | 6
            r16 = 2
            r26 = r11
            r27 = r15
            r28 = r18
            r30 = r0
            r31 = r6
            r32 = r16
            androidx.compose.foundation.Indication r6 = androidx.compose.material.ripple.RippleKt.m1521rememberRipple9IZ8Weo(r26, r27, r28, r30, r31, r32)
            androidx.compose.ui.semantics.Role$Companion r11 = androidx.compose.ui.semantics.Role.Companion
            int r11 = r11.m4096getTabo7Vup1c()
            androidx.compose.ui.semantics.Role r11 = androidx.compose.ui.semantics.Role.m4084boximpl(r11)
            r26 = r1
            r27 = r23
            r28 = r5
            r29 = r6
            r30 = r8
            r31 = r11
            r32 = r24
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.selection.SelectableKt.m816selectableO2vRcR0(r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r6, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getCenter()
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            r11 = 0
            r15 = 6
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r11, r0, r15)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r15)
            java.lang.String r15 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r2)
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r34 = r1
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r2)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r17 = r5
            r5 = r16
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r2)
            java.lang.Object r2 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r11 = r0.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x02f1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02f1:
            r0.startReusableNode()
            boolean r11 = r0.getInserting()
            if (r11 == 0) goto L_0x02fe
            r0.createNode(r5)
            goto L_0x0301
        L_0x02fe:
            r0.useNode()
        L_0x0301:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r15, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r1, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r2, r1)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.invoke(r1, r0, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -172871267(0xfffffffff5b2319d, float:-4.5177496E32)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C187@8378L417:NavigationRail.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = 670576792(0x27f83098, float:6.8886513E-15)
            androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1 r2 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$2$1
            r2.<init>(r12, r3, r7, r4)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r5, r2)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            int r2 = r4 >> 24
            r5 = r2 & 14
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r5
            r5 = 6
            int r4 = r4 << r5
            r4 = r4 & 896(0x380, float:1.256E-42)
            r2 = r2 | r4
            r26 = r18
            r28 = r20
            r30 = r23
            r31 = r1
            r32 = r0
            r33 = r2
            m1342NavigationRailTransitionKlgxPg(r26, r28, r30, r31, r32, r33)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r34
            r5 = r8
            r6 = r10
            r7 = r12
            r8 = r17
            r9 = r18
            r11 = r20
        L_0x03a8:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x03af
            goto L_0x03c7
        L_0x03af:
            androidx.compose.material.NavigationRailKt$NavigationRailItem$3 r16 = new androidx.compose.material.NavigationRailKt$NavigationRailItem$3
            r0 = r16
            r1 = r23
            r2 = r24
            r3 = r25
            r13 = r36
            r14 = r37
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x03c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.NavigationRailKt.m1341NavigationRailItem0S3VyRs(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailTransition-Klgx-Pg  reason: not valid java name */
    public static final void m1342NavigationRailTransitionKlgxPg(long j, long j2, boolean z, Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        int i2;
        long j3 = j;
        long j4 = j2;
        boolean z2 = z;
        Function3<? super Float, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-207161906);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)232@9909L126,239@10110L181:NavigationRail.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed(j3) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function32) ? 2048 : 1024;
        }
        int i4 = i2;
        if ((i4 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z2 ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            long r9 = ColorKt.m1984lerpjxsXWHM(j4, j3, m1343NavigationRailTransition_Klgx_Pg$lambda3(animateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1922boximpl(Color.m1931copywmQWz5c$default(r9, 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1934getAlphaimpl(r9)))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1688205042, true, new NavigationRailKt$NavigationRailTransition$1(function32, i4, animateFloatAsState)), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailTransition$2(j, j2, z, function3, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void NavigationRailItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, float f, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        float f2 = f;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1903861684);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationRailItemBaselineLayout)P(!1,2)264@10960L1118:NavigationRail.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function23) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i2 & 731) != 146 || !startRestartGroup.getSkipping()) {
            MeasurePolicy navigationRailKt$NavigationRailItemBaselineLayout$2 = new NavigationRailKt$NavigationRailItemBaselineLayout$2(function24, f2);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r11 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r11, navigationRailKt$NavigationRailItemBaselineLayout$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1943278197);
            ComposerKt.sourceInformation(startRestartGroup, "C266@10990L41,268@11081L168:NavigationRail.kt#jmzs0o");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "icon");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(layoutId);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r7 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(1405563567);
            ComposerKt.sourceInformation(startRestartGroup, "C266@11023L6:NavigationRail.kt#jmzs0o");
            function23.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier alpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.Companion, Constants.ScionAnalytics.PARAM_LABEL), f2);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(alpha);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r12 = Updater.m1543constructorimpl(startRestartGroup);
                Updater.m1550setimpl(r12, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1550setimpl(r12, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1550setimpl(r12, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1550setimpl(r12, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(2107148020);
                ComposerKt.sourceInformation(startRestartGroup, "C272@11240L7:NavigationRail.kt#jmzs0o");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationRailKt$NavigationRailItemBaselineLayout$3(function23, function24, f2, i3));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s  reason: not valid java name */
    public static final MeasureResult m1348placeIcon3p2s80s(MeasureScope measureScope, Placeable placeable, long j) {
        return MeasureScope.CC.layout$default(measureScope, Constraints.m4624getMaxWidthimpl(j), Constraints.m4623getMaxHeightimpl(j), (Map) null, new NavigationRailKt$placeIcon$1(placeable, Math.max(0, (Constraints.m4624getMaxWidthimpl(j) - placeable.getWidth()) / 2), Math.max(0, (Constraints.m4623getMaxHeightimpl(j) - placeable.getHeight()) / 2)), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0  reason: not valid java name */
    public static final MeasureResult m1349placeLabelAndIconDIyivk0(MeasureScope measureScope, Placeable placeable, Placeable placeable2, long j, float f) {
        int i = placeable.get(AlignmentLineKt.getLastBaseline());
        int r6 = (Constraints.m4623getMaxHeightimpl(j) - i) - measureScope.m4643roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        int r5 = (Constraints.m4624getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        int r10 = measureScope.m4643roundToPx0680j_4(ItemIconTopOffset);
        int r9 = (Constraints.m4624getMaxWidthimpl(j) - placeable2.getWidth()) / 2;
        int roundToInt = MathKt.roundToInt(((float) (((Constraints.m4623getMaxHeightimpl(j) - placeable2.getHeight()) / 2) - r10)) * (((float) 1) - f));
        float f2 = f;
        return MeasureScope.CC.layout$default(measureScope, Constraints.m4624getMaxWidthimpl(j), Constraints.m4623getMaxHeightimpl(j), (Map) null, new NavigationRailKt$placeLabelAndIcon$1(f2, placeable, r5, r6, roundToInt, placeable2, r9, r10), 4, (Object) null);
    }

    static {
        float f = (float) 8;
        NavigationRailPadding = Dp.m4704constructorimpl(f);
        HeaderPadding = Dp.m4704constructorimpl(f);
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationRailTransition_Klgx_Pg$lambda-3  reason: not valid java name */
    public static final float m1343NavigationRailTransition_Klgx_Pg$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
