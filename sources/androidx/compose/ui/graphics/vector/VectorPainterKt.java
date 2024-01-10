package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a£\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\"2@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a&\u0010%\u001a\u00020\u0003*\u00020&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0002\b)H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006*"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m2648rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        int i4 = i2;
        Intrinsics.checkNotNullParameter(function4, "content");
        composer2.startReplaceableGroup(-964365210);
        ComposerKt.sourceInformation(composer2, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)83@3597L207:VectorPainter.kt#huu6hf");
        float f5 = Float.NaN;
        float f6 = (i3 & 4) != 0 ? Float.NaN : f3;
        if ((i3 & 8) == 0) {
            f5 = f4;
        }
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long r5 = (i3 & 32) != 0 ? Color.Companion.m1968getUnspecified0d7_KjU() : j;
        int r7 = (i3 & 64) != 0 ? BlendMode.Companion.m1862getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:73)");
        }
        VectorPainter r0 = m2649rememberVectorPaintervIP8VLU(f, f2, f6, f5, str2, r5, r7, false, function4, composer, 12582912 | (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | ((i4 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    public static final VectorPainter m2649rememberVectorPaintervIP8VLU(float f, float f2, float f3, float f4, String str, long j, int i, boolean z, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        ColorFilter colorFilter;
        Composer composer2 = composer;
        int i4 = i2;
        int i5 = i3;
        Intrinsics.checkNotNullParameter(function4, "content");
        composer2.startReplaceableGroup(1068590786);
        ComposerKt.sourceInformation(composer2, "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)125@5300L7,132@5603L187,*140@5803L28,145@6076L46:VectorPainter.kt#huu6hf");
        float f5 = Float.NaN;
        float f6 = (i5 & 4) != 0 ? Float.NaN : f3;
        if ((i5 & 8) == 0) {
            f5 = f4;
        }
        String str2 = (i5 & 16) != 0 ? RootGroupName : str;
        long r8 = (i5 & 32) != 0 ? Color.Companion.m1968getUnspecified0d7_KjU() : j;
        int r10 = (i5 & 64) != 0 ? BlendMode.Companion.m1862getSrcIn0nO6VwU() : i;
        boolean z2 = (i5 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i4, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:114)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        float r11 = density.m4649toPx0680j_4(f);
        float r3 = density.m4649toPx0680j_4(f2);
        if (Float.isNaN(f6)) {
            f6 = r11;
        }
        if (Float.isNaN(f5)) {
            f5 = r3;
        }
        Color r12 = Color.m1922boximpl(r8);
        BlendMode r13 = BlendMode.m1830boximpl(r10);
        int i6 = i4 >> 15;
        composer2.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) r12) | composer2.changed((Object) r13);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (!Color.m1933equalsimpl0(r8, Color.Companion.m1968getUnspecified0d7_KjU())) {
                colorFilter = ColorFilter.Companion.m1976tintxETnrds(r8, r10);
            } else {
                colorFilter = null;
            }
            rememberedValue = colorFilter;
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ColorFilter colorFilter2 = (ColorFilter) rememberedValue;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new VectorPainter();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue2;
        vectorPainter.m2647setSizeuvyYCjk$ui_release(SizeKt.Size(r11, r3));
        vectorPainter.setAutoMirror$ui_release(z2);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter2);
        vectorPainter.RenderVector$ui_release(str2, f6, f5, function4, composer, ((i4 >> 12) & 14) | 32768 | (i6 & 7168));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return vectorPainter;
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        ImageVector imageVector2 = imageVector;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(imageVector, "image");
        composer.startReplaceableGroup(1413834416);
        ComposerKt.sourceInformation(composer, "C(rememberVectorPainter)157@6447L424:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:156)");
        }
        VectorPainter r0 = m2649rememberVectorPaintervIP8VLU(imageVector.m2616getDefaultWidthD9Ej5fM(), imageVector.m2615getDefaultHeightD9Ej5fM(), imageVector.getViewportWidth(), imageVector.getViewportHeight(), imageVector.getName(), imageVector.m2618getTintColor0d7_KjU(), imageVector.m2617getTintBlendMode0nO6VwU(), imageVector.getAutoMirror(), ComposableLambdaKt.composableLambda(composer, 1873274766, true, new VectorPainterKt$rememberVectorPainter$3(imageVector)), composer, 100663296, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x02b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup r22, java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r23, androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r0 = r22
            r1 = r25
            r2 = r26
            java.lang.String r3 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -446179233(0xffffffffe567d85f, float:-6.8428625E22)
            r4 = r24
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            r4 = r2 & 1
            r5 = 2
            if (r4 == 0) goto L_0x0021
            r4 = r1 | 6
            goto L_0x0031
        L_0x0021:
            r4 = r1 & 14
            if (r4 != 0) goto L_0x0030
            boolean r4 = r15.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x002d
            r4 = 4
            goto L_0x002e
        L_0x002d:
            r4 = 2
        L_0x002e:
            r4 = r4 | r1
            goto L_0x0031
        L_0x0030:
            r4 = r1
        L_0x0031:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x0037
            r4 = r4 | 16
        L_0x0037:
            if (r6 != r5) goto L_0x004e
            r4 = r4 & 91
            r5 = 18
            if (r4 != r5) goto L_0x004e
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L_0x0046
            goto L_0x004e
        L_0x0046:
            r15.skipToGroupEnd()
            r3 = r23
            r1 = r15
            goto L_0x02b8
        L_0x004e:
            r15.startDefaults()
            r4 = r1 & 1
            if (r4 == 0) goto L_0x0060
            boolean r4 = r15.getDefaultsInvalid()
            if (r4 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            r15.skipToGroupEnd()
            goto L_0x0068
        L_0x0060:
            if (r6 == 0) goto L_0x0068
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            r14 = r4
            goto L_0x006a
        L_0x0068:
            r14 = r23
        L_0x006a:
            r15.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0079
            r4 = -1
            java.lang.String r5 = "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:326)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r4, r5)
        L_0x0079:
            java.util.Iterator r3 = r22.iterator()
        L_0x007d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02ad
            java.lang.Object r4 = r3.next()
            androidx.compose.ui.graphics.vector.VectorNode r4 = (androidx.compose.ui.graphics.vector.VectorNode) r4
            boolean r5 = r4 instanceof androidx.compose.ui.graphics.vector.VectorPath
            if (r5 == 0) goto L_0x019d
            r5 = -326285817(0xffffffffec8d4607, float:-1.3663139E27)
            r15.startReplaceableGroup(r5)
            java.lang.String r5 = "333@12072L1719"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r5)
            r17 = r4
            androidx.compose.ui.graphics.vector.VectorPath r17 = (androidx.compose.ui.graphics.vector.VectorPath) r17
            java.lang.String r4 = r17.getName()
            java.lang.Object r4 = r14.get(r4)
            androidx.compose.ui.graphics.vector.VectorConfig r4 = (androidx.compose.ui.graphics.vector.VectorConfig) r4
            if (r4 != 0) goto L_0x00af
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1 r4 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
            r4.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r4 = (androidx.compose.ui.graphics.vector.VectorConfig) r4
        L_0x00af:
            r13 = r4
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r4 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r4 = (androidx.compose.ui.graphics.vector.VectorProperty) r4
            java.util.List r5 = r17.getPathData()
            java.lang.Object r4 = r13.getOrDefault(r4, r5)
            java.util.List r4 = (java.util.List) r4
            int r5 = r17.m2650getPathFillTypeRgk1Os()
            java.lang.String r6 = r17.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Fill r7 = androidx.compose.ui.graphics.vector.VectorProperty.Fill.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            androidx.compose.ui.graphics.Brush r8 = r17.getFill()
            java.lang.Object r7 = r13.getOrDefault(r7, r8)
            androidx.compose.ui.graphics.Brush r7 = (androidx.compose.ui.graphics.Brush) r7
            androidx.compose.ui.graphics.vector.VectorProperty$FillAlpha r8 = androidx.compose.ui.graphics.vector.VectorProperty.FillAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r8 = (androidx.compose.ui.graphics.vector.VectorProperty) r8
            float r9 = r17.getFillAlpha()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r8 = r13.getOrDefault(r8, r9)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$Stroke r9 = androidx.compose.ui.graphics.vector.VectorProperty.Stroke.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r9 = (androidx.compose.ui.graphics.vector.VectorProperty) r9
            androidx.compose.ui.graphics.Brush r10 = r17.getStroke()
            java.lang.Object r9 = r13.getOrDefault(r9, r10)
            androidx.compose.ui.graphics.Brush r9 = (androidx.compose.ui.graphics.Brush) r9
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeAlpha r10 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r10 = (androidx.compose.ui.graphics.vector.VectorProperty) r10
            float r11 = r17.getStrokeAlpha()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r10 = r13.getOrDefault(r10, r11)
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeLineWidth r11 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeLineWidth.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r11 = (androidx.compose.ui.graphics.vector.VectorProperty) r11
            float r12 = r17.getStrokeLineWidth()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r11 = r13.getOrDefault(r11, r12)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            int r12 = r17.m2651getStrokeLineCapKaPHkGw()
            int r16 = r17.m2652getStrokeLineJoinLxFBmk8()
            r23 = r3
            r3 = r13
            r13 = r16
            float r16 = r17.getStrokeLineMiter()
            r0 = r14
            r14 = r16
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathStart r16 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathStart.INSTANCE
            r24 = r15
            r15 = r16
            androidx.compose.ui.graphics.vector.VectorProperty r15 = (androidx.compose.ui.graphics.vector.VectorProperty) r15
            float r16 = r17.getTrimPathStart()
            java.lang.Float r1 = java.lang.Float.valueOf(r16)
            java.lang.Object r1 = r3.getOrDefault(r15, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r15 = r1.floatValue()
            r1 = r24
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathEnd r16 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathEnd.INSTANCE
            r2 = r16
            androidx.compose.ui.graphics.vector.VectorProperty r2 = (androidx.compose.ui.graphics.vector.VectorProperty) r2
            float r16 = r17.getTrimPathEnd()
            r24 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r16)
            java.lang.Object r0 = r3.getOrDefault(r2, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r16 = r0.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathOffset r0 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathOffset.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r0 = (androidx.compose.ui.graphics.vector.VectorProperty) r0
            float r2 = r17.getTrimPathOffset()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r0 = r3.getOrDefault(r0, r2)
            java.lang.Number r0 = (java.lang.Number) r0
            float r17 = r0.floatValue()
            r19 = 8
            r20 = 0
            r21 = 0
            r18 = r1
            androidx.compose.ui.graphics.vector.VectorComposeKt.m2641Path9cdaXJ4(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r1.endReplaceableGroup()
            r0 = r22
            r3 = r23
            r14 = r24
            r2 = r26
            r15 = r1
            goto L_0x02a9
        L_0x019d:
            r23 = r3
            r24 = r14
            r1 = r15
            boolean r0 = r4 instanceof androidx.compose.ui.graphics.vector.VectorGroup
            if (r0 == 0) goto L_0x0296
            r0 = -326283959(0xffffffffec8d4d49, float:-1.3665881E27)
            r1.startReplaceableGroup(r0)
            java.lang.String r0 = "378@13930L1368"
            androidx.compose.runtime.ComposerKt.sourceInformation(r1, r0)
            r0 = r4
            androidx.compose.ui.graphics.vector.VectorGroup r0 = (androidx.compose.ui.graphics.vector.VectorGroup) r0
            java.lang.String r2 = r0.getName()
            r3 = r24
            java.lang.Object r2 = r3.get(r2)
            androidx.compose.ui.graphics.vector.VectorConfig r2 = (androidx.compose.ui.graphics.vector.VectorConfig) r2
            if (r2 != 0) goto L_0x01c9
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2 r2 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
            r2.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r2 = (androidx.compose.ui.graphics.vector.VectorConfig) r2
        L_0x01c9:
            java.lang.String r5 = r0.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Rotation r6 = androidx.compose.ui.graphics.vector.VectorProperty.Rotation.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r6 = (androidx.compose.ui.graphics.vector.VectorProperty) r6
            float r7 = r0.getRotation()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r6 = r2.getOrDefault(r6, r7)
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleX r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r8 = r0.getScaleX()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            java.lang.Object r7 = r2.getOrDefault(r7, r8)
            java.lang.Number r7 = (java.lang.Number) r7
            float r8 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleY r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r9 = r0.getScaleY()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r7 = r2.getOrDefault(r7, r9)
            java.lang.Number r7 = (java.lang.Number) r7
            float r9 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateX r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r10 = r0.getTranslationX()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r7 = r2.getOrDefault(r7, r10)
            java.lang.Number r7 = (java.lang.Number) r7
            float r10 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateY r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r11 = r0.getTranslationY()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r7 = r2.getOrDefault(r7, r11)
            java.lang.Number r7 = (java.lang.Number) r7
            float r11 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotX r7 = androidx.compose.ui.graphics.vector.VectorProperty.PivotX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r12 = r0.getPivotX()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r7 = r2.getOrDefault(r7, r12)
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotY r12 = androidx.compose.ui.graphics.vector.VectorProperty.PivotY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r12 = (androidx.compose.ui.graphics.vector.VectorProperty) r12
            float r13 = r0.getPivotY()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r12 = r2.getOrDefault(r12, r13)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r13 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r13 = (androidx.compose.ui.graphics.vector.VectorProperty) r13
            java.util.List r0 = r0.getClipPathData()
            java.lang.Object r0 = r2.getOrDefault(r13, r0)
            java.util.List r0 = (java.util.List) r0
            r2 = 1450046638(0x566df4ae, float:6.5408787E13)
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1 r13 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
            r13.<init>(r4, r3)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r2, r4, r13)
            r13 = r2
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r15 = 939524096(0x38000000, float:3.0517578E-5)
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            r12 = r0
            r14 = r1
            androidx.compose.ui.graphics.vector.VectorComposeKt.Group(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.endReplaceableGroup()
            goto L_0x02a1
        L_0x0296:
            r3 = r24
            r0 = -326282489(0xffffffffec8d5307, float:-1.366805E27)
            r1.startReplaceableGroup(r0)
            r1.endReplaceableGroup()
        L_0x02a1:
            r0 = r22
            r2 = r26
            r15 = r1
            r14 = r3
            r3 = r23
        L_0x02a9:
            r1 = r25
            goto L_0x007d
        L_0x02ad:
            r3 = r14
            r1 = r15
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b8:
            androidx.compose.runtime.ScopeUpdateScope r0 = r1.endRestartGroup()
            if (r0 != 0) goto L_0x02bf
            goto L_0x02cf
        L_0x02bf:
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2 r1 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
            r2 = r22
            r4 = r25
            r5 = r26
            r1.<init>(r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x02cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long r0 = drawScope.m2477getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r3 = drawContext.m2456getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m2570scale0AR0LA0(-1.0f, 1.0f, r0);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m2457setSizeuvyYCjk(r3);
    }
}
