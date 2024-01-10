package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a;\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a9\u00108\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00107\u001aA\u0010:\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a9\u0010=\u001a\u00020\u001f*\u0002012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\u001a)\u0010B\u001a\u00020\u001f*\u0002012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "backgroundColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m4704constructorimpl((float) 40);
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1357getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m4704constructorimpl((float) 240);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1365LinearProgressIndicatoreaDK9VM(float r16, androidx.compose.ui.Modifier r17, long r18, long r20, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r23
            r0 = -850309746(0xffffffffcd514d8e, float:-2.19470048E8)
            r1 = r22
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LinearProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)74@3420L6,81@3655L175,77@3520L310:ProgressIndicator.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x001a
            r1 = r7 | 6
            r2 = r1
            r1 = r16
            goto L_0x002e
        L_0x001a:
            r1 = r7 & 14
            if (r1 != 0) goto L_0x002b
            r1 = r16
            boolean r2 = r0.changed((float) r1)
            if (r2 == 0) goto L_0x0028
            r2 = 4
            goto L_0x0029
        L_0x0028:
            r2 = 2
        L_0x0029:
            r2 = r2 | r7
            goto L_0x002e
        L_0x002b:
            r1 = r16
            r2 = r7
        L_0x002e:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0048
            r4 = r17
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r2 = r2 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r17
        L_0x004a:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0063
            r5 = r24 & 4
            if (r5 != 0) goto L_0x005d
            r5 = r18
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x005f
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r5 = r18
        L_0x005f:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r2 = r2 | r8
            goto L_0x0065
        L_0x0063:
            r5 = r18
        L_0x0065:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007e
            r8 = r24 & 8
            if (r8 != 0) goto L_0x0078
            r8 = r20
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x007a
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x0078:
            r8 = r20
        L_0x007a:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r2 = r2 | r10
            goto L_0x0080
        L_0x007e:
            r8 = r20
        L_0x0080:
            r2 = r2 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r2 != r10) goto L_0x0095
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x008d
            goto L_0x0095
        L_0x008d:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r5
        L_0x0092:
            r5 = r8
            goto L_0x0149
        L_0x0095:
            r0.startDefaults()
            r2 = r7 & 1
            if (r2 == 0) goto L_0x00ad
            boolean r2 = r0.getDefaultsInvalid()
            if (r2 == 0) goto L_0x00a3
            goto L_0x00ad
        L_0x00a3:
            r0.skipToGroupEnd()
            r2 = r24 & 4
            r2 = r24 & 8
            r2 = r4
            r3 = r5
            goto L_0x00d9
        L_0x00ad:
            if (r3 == 0) goto L_0x00b4
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00b5
        L_0x00b4:
            r2 = r4
        L_0x00b5:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x00c5
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r4)
            long r3 = r3.m1214getPrimary0d7_KjU()
            goto L_0x00c6
        L_0x00c5:
            r3 = r5
        L_0x00c6:
            r5 = r24 & 8
            if (r5 == 0) goto L_0x00d9
            r10 = 1047904911(0x3e75c28f, float:0.24)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r8 = r3
            long r5 = androidx.compose.ui.graphics.Color.m1931copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            r8 = r5
        L_0x00d9:
            r0.endDefaults()
            r5 = 0
            r6 = 0
            r10 = 6
            r11 = 0
            r17 = r2
            r18 = r16
            r19 = r5
            r20 = r6
            r21 = r10
            r22 = r11
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r17, r18, r19, r20, r21, r22)
            float r6 = LinearIndicatorWidth
            float r10 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m584sizeVpY3zN4(r5, r6, r10)
            androidx.compose.ui.graphics.Color r6 = androidx.compose.ui.graphics.Color.m1922boximpl(r8)
            java.lang.Float r10 = java.lang.Float.valueOf(r16)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m1922boximpl(r3)
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r6 = r0.changed((java.lang.Object) r6)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r6 = r6 | r10
            boolean r10 = r0.changed((java.lang.Object) r11)
            r6 = r6 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r6 != 0) goto L_0x012b
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r10 != r6) goto L_0x013e
        L_0x012b:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1 r6 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r17 = r6
            r18 = r8
            r20 = r16
            r21 = r3
            r17.<init>(r18, r20, r21)
            r10 = r6
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.updateRememberedValue(r10)
        L_0x013e:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r6 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r10, r0, r6)
            goto L_0x0092
        L_0x0149:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0150
            goto L_0x0161
        L_0x0150:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2 r10 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r10
            r1 = r16
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r3, r5, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x0161:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1365LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    public static final void m1364LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, int i, int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        long j5;
        Modifier modifier3;
        long j6;
        int i4;
        int i5;
        int i6 = i;
        Composer startRestartGroup = composer.startRestartGroup(-819397058);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)102@4593L6,105@4718L28,109@5000L319,120@5364L319,131@5729L323,142@6098L323,157@6553L557,153@6426L684:ProgressIndicator.kt#jmzs0o");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i3 = i6;
        }
        if ((i6 & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i6 & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 731) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i6 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i7 != 0 ? Modifier.Companion : modifier2;
                j5 = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1214getPrimary0d7_KjU() : j3;
                if ((i2 & 4) != 0) {
                    j4 = Color.m1931copywmQWz5c$default(j5, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                int i8 = i2 & 2;
                int i9 = i2 & 4;
                modifier3 = modifier2;
                j5 = j3;
            }
            startRestartGroup.endDefaults();
            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(startRestartGroup, 0);
            State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2.INSTANCE), (RepeatMode) null, 0, 6, (Object) null), startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9));
            Modifier r8 = SizeKt.m584sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] objArr = {Color.m1922boximpl(j4), animateFloat, animateFloat2, Color.m1922boximpl(j5), animateFloat3, animateFloat4};
            startRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean z = false;
            for (int i10 = 0; i10 < 6; i10++) {
                z |= startRestartGroup.changed(objArr[i10]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ProgressIndicatorKt$LinearProgressIndicator$3$1(j4, j5, animateFloat, animateFloat2, animateFloat3, animateFloat4);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(r8, (Function1) rememberedValue, startRestartGroup, 0);
            j6 = j5;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j6 = j3;
        }
        long j7 = j4;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressIndicatorKt$LinearProgressIndicator$4(modifier3, j6, j7, i, i2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c  reason: not valid java name */
    public static final void m1385drawLinearIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, float f3) {
        float r0 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc());
        float r1 = Size.m1749getHeightimpl(drawScope.m2478getSizeNHjbRc()) / ((float) 2);
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        DrawScope.CC.m2506drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset((z ? f : 1.0f - f2) * r0, r1), OffsetKt.Offset((z ? f2 : 1.0f - f) * r0, r1), f3, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorBackground-bw27NRU  reason: not valid java name */
    public static final void m1386drawLinearIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, float f) {
        m1385drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j, f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1358CircularProgressIndicatorMBs18nI(float r21, androidx.compose.ui.Modifier r22, long r23, float r25, androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r6 = r21
            r7 = r27
            r0 = -409649739(0xffffffffe7953db5, float:-1.4095418E24)
            r1 = r26
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)226@9099L6,*229@9214L7,232@9300L296:ProgressIndicator.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r28 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r7 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r7 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r8.changed((float) r6)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r7
            goto L_0x0029
        L_0x0028:
            r0 = r7
        L_0x0029:
            r1 = r28 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0043
        L_0x0030:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0043
            r2 = r22
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003f
            r3 = 32
            goto L_0x0041
        L_0x003f:
            r3 = 16
        L_0x0041:
            r0 = r0 | r3
            goto L_0x0045
        L_0x0043:
            r2 = r22
        L_0x0045:
            r3 = r7 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005e
            r3 = r28 & 4
            if (r3 != 0) goto L_0x0058
            r3 = r23
            boolean r5 = r8.changed((long) r3)
            if (r5 == 0) goto L_0x005a
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r3 = r23
        L_0x005a:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r0 = r0 | r5
            goto L_0x0060
        L_0x005e:
            r3 = r23
        L_0x0060:
            r5 = r28 & 8
            if (r5 == 0) goto L_0x0067
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x007a
            r9 = r25
            boolean r10 = r8.changed((float) r9)
            if (r10 == 0) goto L_0x0076
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r0 = r0 | r10
            goto L_0x007c
        L_0x007a:
            r9 = r25
        L_0x007c:
            r0 = r0 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r0 != r10) goto L_0x008f
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0089
            goto L_0x008f
        L_0x0089:
            r8.skipToGroupEnd()
            r5 = r9
            goto L_0x0122
        L_0x008f:
            r8.startDefaults()
            r0 = r7 & 1
            if (r0 == 0) goto L_0x00a6
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x009d
            goto L_0x00a6
        L_0x009d:
            r8.skipToGroupEnd()
            r0 = r28 & 4
            r10 = r3
            r12 = r9
            r9 = r2
            goto L_0x00ce
        L_0x00a6:
            if (r1 == 0) goto L_0x00ad
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x00ae
        L_0x00ad:
            r0 = r2
        L_0x00ae:
            r1 = r28 & 4
            if (r1 == 0) goto L_0x00be
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r8, r2)
            long r1 = r1.m1214getPrimary0d7_KjU()
            goto L_0x00bf
        L_0x00be:
            r1 = r3
        L_0x00bf:
            if (r5 == 0) goto L_0x00cb
            androidx.compose.material.ProgressIndicatorDefaults r3 = androidx.compose.material.ProgressIndicatorDefaults.INSTANCE
            float r3 = r3.m1357getStrokeWidthD9Ej5fM()
            r9 = r0
            r10 = r1
            r12 = r3
            goto L_0x00ce
        L_0x00cb:
            r10 = r1
            r12 = r9
            r9 = r0
        L_0x00ce:
            r8.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r1, r2)
            java.lang.Object r0 = r8.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r5 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r14 = r0.m4649toPx0680j_4(r12)
            r15 = 0
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r16 = r0.m2287getButtKaPHkGw()
            r17 = 0
            r18 = 0
            r19 = 26
            r20 = 0
            r13 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r2 = 0
            r3 = 0
            r4 = 6
            r13 = 0
            r0 = r9
            r1 = r21
            r14 = r5
            r5 = r13
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r0, r1, r2, r3, r4, r5)
            float r1 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r0, r1)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1 r1 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
            r1.<init>(r6, r10, r14)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r1, r8, r2)
            r2 = r9
            r3 = r10
            r5 = r12
        L_0x0122:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x0129
            goto L_0x013a
        L_0x0129:
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2 r9 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
            r0 = r9
            r1 = r21
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1358CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1359CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r24, long r25, float r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r5 = r29
            r0 = -392089979(0xffffffffe8a12e85, float:-6.089273E24)
            r1 = r28
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)257@10275L6,*260@10390L7,264@10496L28,266@10654L278,278@11047L230,289@11395L345,301@11775L354,312@12134L582:ProgressIndicator.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r30 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001b
            r3 = r5 | 6
            r4 = r3
            r3 = r24
            goto L_0x002f
        L_0x001b:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x002c
            r3 = r24
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r5
            goto L_0x002f
        L_0x002c:
            r3 = r24
            r4 = r5
        L_0x002f:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0048
            r6 = r30 & 2
            if (r6 != 0) goto L_0x0042
            r6 = r25
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x0044
            r8 = 32
            goto L_0x0046
        L_0x0042:
            r6 = r25
        L_0x0044:
            r8 = 16
        L_0x0046:
            r4 = r4 | r8
            goto L_0x004a
        L_0x0048:
            r6 = r25
        L_0x004a:
            r8 = r30 & 4
            if (r8 == 0) goto L_0x0051
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r9 = r5 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0064
            r9 = r27
            boolean r10 = r0.changed((float) r9)
            if (r10 == 0) goto L_0x0060
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r4 = r4 | r10
            goto L_0x0066
        L_0x0064:
            r9 = r27
        L_0x0066:
            r4 = r4 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r4 != r10) goto L_0x007b
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x0073
            goto L_0x007b
        L_0x0073:
            r0.skipToGroupEnd()
            r1 = r3
            r2 = r6
            r4 = r9
            goto L_0x01c1
        L_0x007b:
            r0.startDefaults()
            r4 = r5 & 1
            if (r4 == 0) goto L_0x0092
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0089
            goto L_0x0092
        L_0x0089:
            r0.skipToGroupEnd()
            r1 = r30 & 2
            r1 = r3
            r3 = r6
        L_0x0090:
            r15 = r9
            goto L_0x00b4
        L_0x0092:
            if (r1 == 0) goto L_0x0099
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x009a
        L_0x0099:
            r1 = r3
        L_0x009a:
            r3 = r30 & 2
            if (r3 == 0) goto L_0x00aa
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r4)
            long r3 = r3.m1214getPrimary0d7_KjU()
            goto L_0x00ab
        L_0x00aa:
            r3 = r6
        L_0x00ab:
            if (r8 == 0) goto L_0x0090
            androidx.compose.material.ProgressIndicatorDefaults r6 = androidx.compose.material.ProgressIndicatorDefaults.INSTANCE
            float r6 = r6.m1357getStrokeWidthD9Ej5fM()
            r15 = r6
        L_0x00b4:
            r0.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r8)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.ui.graphics.drawscope.Stroke r16 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r8 = r6.m4649toPx0680j_4(r15)
            r9 = 0
            androidx.compose.ui.graphics.StrokeCap$Companion r6 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r10 = r6.m2289getSquareKaPHkGw()
            r11 = 0
            r12 = 0
            r13 = 26
            r14 = 0
            r7 = r16
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r14 = 0
            androidx.compose.animation.core.InfiniteTransition r13 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r14)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            r6 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            kotlin.jvm.internal.IntCompanionObject r6 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r9 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.IntCompanionObject) r6)
            r6 = 6660(0x1a04, float:9.333E-42)
            androidx.compose.animation.core.Easing r10 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r6 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r14, r10, r2, r12)
            r17 = r6
            androidx.compose.animation.core.DurationBasedAnimationSpec r17 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r17
            r18 = 0
            r19 = 0
            r21 = 6
            r22 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r10 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r17, r18, r19, r21, r22)
            int r6 = androidx.compose.animation.core.InfiniteTransition.$stable
            r6 = r6 | 4528(0x11b0, float:6.345E-42)
            int r11 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r11 = r11 << 12
            r17 = r6 | r11
            r6 = r13
            r11 = r0
            r2 = r12
            r12 = r17
            androidx.compose.runtime.State r12 = androidx.compose.animation.core.InfiniteTransitionKt.animateValue(r6, r7, r8, r9, r10, r11, r12)
            r7 = 0
            r8 = 1133445120(0x438f0000, float:286.0)
            r6 = 1332(0x534, float:1.867E-42)
            androidx.compose.animation.core.Easing r9 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r10 = 2
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r14, r9, r10, r2)
            r17 = r2
            androidx.compose.animation.core.DurationBasedAnimationSpec r17 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r17
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r17, r18, r19, r21, r22)
            int r2 = androidx.compose.animation.core.InfiniteTransition.$stable
            r2 = r2 | 432(0x1b0, float:6.05E-43)
            int r6 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r6 = r6 << 9
            r11 = r2 | r6
            r6 = r13
            r10 = r0
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            r8 = 1133576192(0x43910000, float:290.0)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2 r6 = androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.animation.core.KeyframesSpec r6 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r17 = r6
            androidx.compose.animation.core.DurationBasedAnimationSpec r17 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r17
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r17, r18, r19, r21, r22)
            int r6 = androidx.compose.animation.core.InfiniteTransition.$stable
            r6 = r6 | 432(0x1b0, float:6.05E-43)
            int r10 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r10 = r10 << 9
            r11 = r6 | r10
            r6 = r13
            r10 = r0
            androidx.compose.runtime.State r17 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 r6 = androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.animation.core.KeyframesSpec r6 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r18 = r6
            androidx.compose.animation.core.DurationBasedAnimationSpec r18 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r18
            r19 = 0
            r20 = 0
            r22 = 6
            r23 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r18, r19, r20, r22, r23)
            int r6 = androidx.compose.animation.core.InfiniteTransition.$stable
            r6 = r6 | 432(0x1b0, float:6.05E-43)
            int r10 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r10 = r10 << 9
            r11 = r6 | r10
            r6 = r13
            r10 = r0
            androidx.compose.runtime.State r13 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r1)
            float r7 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r6, r7)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3 r18 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
            r6 = r18
            r7 = r15
            r8 = r3
            r10 = r16
            r24 = r1
            r1 = r11
            r11 = r12
            r12 = r17
            r25 = r3
            r3 = 0
            r14 = r2
            r6.<init>(r7, r8, r10, r11, r12, r13, r14)
            r2 = r18
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.foundation.CanvasKt.Canvas(r1, r2, r0, r3)
            r1 = r24
            r2 = r25
            r4 = r15
        L_0x01c1:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x01c8
            goto L_0x01d7
        L_0x01c8:
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4 r8 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
            r0 = r8
            r5 = r29
            r6 = r30
            r0.<init>(r1, r2, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x01d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1359CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m1382drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = (float) 2;
        float width = stroke.getWidth() / f3;
        float r2 = Size.m1752getWidthimpl(drawScope.m2478getSizeNHjbRc()) - (f3 * width);
        DrawScope.CC.m2499drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.ui.geometry.SizeKt.Size(r2, r2), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m1383drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m1382drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m1384drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m1382drawCircularIndicator42QJj7c(drawScope, f + (((f2 / Dp.m4704constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-1  reason: not valid java name */
    public static final float m1366LinearProgressIndicator_RIQooxk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-2  reason: not valid java name */
    public static final float m1367LinearProgressIndicator_RIQooxk$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-3  reason: not valid java name */
    public static final float m1368LinearProgressIndicator_RIQooxk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-4  reason: not valid java name */
    public static final float m1369LinearProgressIndicator_RIQooxk$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-8  reason: not valid java name */
    public static final int m1362CircularProgressIndicator_aM_cp0Q$lambda8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-9  reason: not valid java name */
    public static final float m1363CircularProgressIndicator_aM_cp0Q$lambda9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-10  reason: not valid java name */
    public static final float m1360CircularProgressIndicator_aM_cp0Q$lambda10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-11  reason: not valid java name */
    public static final float m1361CircularProgressIndicator_aM_cp0Q$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }
}
