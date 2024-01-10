package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fe  */
    /* renamed from: Surface-F-jzlyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1419SurfaceFjzlyU(androidx.compose.ui.Modifier r22, androidx.compose.ui.graphics.Shape r23, long r24, long r26, androidx.compose.foundation.BorderStroke r28, float r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r30
            r11 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1412203386(0x542c837a, float:2.96376074E12)
            r1 = r31
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)106@5259L6,107@5301L22,*112@5476L7,113@5500L793:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x0021
            r2 = r11 | 6
            r3 = r2
            r2 = r22
            goto L_0x0035
        L_0x0021:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0032
            r2 = r22
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002f
            r3 = 4
            goto L_0x0030
        L_0x002f:
            r3 = 2
        L_0x0030:
            r3 = r3 | r11
            goto L_0x0035
        L_0x0032:
            r2 = r22
            r3 = r11
        L_0x0035:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x003c
            r3 = r3 | 48
            goto L_0x004f
        L_0x003c:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004f
            r5 = r23
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004b
            r6 = 32
            goto L_0x004d
        L_0x004b:
            r6 = 16
        L_0x004d:
            r3 = r3 | r6
            goto L_0x0051
        L_0x004f:
            r5 = r23
        L_0x0051:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006a
            r6 = r33 & 4
            if (r6 != 0) goto L_0x0064
            r6 = r24
            boolean r8 = r12.changed((long) r6)
            if (r8 == 0) goto L_0x0066
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r6 = r24
        L_0x0066:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r3 = r3 | r8
            goto L_0x006c
        L_0x006a:
            r6 = r24
        L_0x006c:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0085
            r8 = r33 & 8
            if (r8 != 0) goto L_0x007f
            r8 = r26
            boolean r13 = r12.changed((long) r8)
            if (r13 == 0) goto L_0x0081
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r8 = r26
        L_0x0081:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r3 = r3 | r13
            goto L_0x0087
        L_0x0085:
            r8 = r26
        L_0x0087:
            r13 = r33 & 16
            if (r13 == 0) goto L_0x008e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x008e:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x00a3
            r14 = r28
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x009f
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r3 = r3 | r15
            goto L_0x00a5
        L_0x00a3:
            r14 = r28
        L_0x00a5:
            r15 = r33 & 32
            if (r15 == 0) goto L_0x00b0
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r1 = r29
            goto L_0x00c5
        L_0x00b0:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            r1 = r29
            if (r16 != 0) goto L_0x00c5
            boolean r16 = r12.changed((float) r1)
            if (r16 == 0) goto L_0x00c1
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r3 = r3 | r16
        L_0x00c5:
            r16 = r33 & 64
            if (r16 == 0) goto L_0x00ce
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cb:
            r3 = r3 | r16
            goto L_0x00e0
        L_0x00ce:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00e0
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00dd
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cb
        L_0x00dd:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cb
        L_0x00e0:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r3 & r16
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x00fe
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00f1
            goto L_0x00fe
        L_0x00f1:
            r12.skipToGroupEnd()
            r1 = r22
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r14
            r8 = r29
            goto L_0x01e6
        L_0x00fe:
            r12.startDefaults()
            r1 = r11 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0133
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x010d
            goto L_0x0133
        L_0x010d:
            r12.skipToGroupEnd()
            r0 = r33 & 4
            if (r0 == 0) goto L_0x0116
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0116:
            r0 = r33 & 8
            if (r0 == 0) goto L_0x0127
            r0 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r13 = r22
            r20 = r29
            r15 = r6
            r17 = r8
            r19 = r14
            r6 = r0
            goto L_0x0131
        L_0x0127:
            r13 = r22
            r20 = r29
        L_0x012b:
            r15 = r6
            r17 = r8
            r19 = r14
            r6 = r3
        L_0x0131:
            r14 = r5
            goto L_0x0175
        L_0x0133:
            if (r0 == 0) goto L_0x013a
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x013c
        L_0x013a:
            r0 = r22
        L_0x013c:
            if (r4 == 0) goto L_0x0143
            androidx.compose.ui.graphics.Shape r1 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r1
        L_0x0143:
            r1 = r33 & 4
            if (r1 == 0) goto L_0x0154
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r12, r4)
            long r6 = r1.m1218getSurface0d7_KjU()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0154:
            r1 = r33 & 8
            if (r1 == 0) goto L_0x0162
            int r1 = r3 >> 6
            r1 = r1 & 14
            long r8 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r6, r12, r1)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0162:
            if (r13 == 0) goto L_0x0166
            r1 = 0
            r14 = r1
        L_0x0166:
            if (r15 == 0) goto L_0x0171
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            r13 = r0
            r20 = r1
            goto L_0x012b
        L_0x0171:
            r20 = r29
            r13 = r0
            goto L_0x012b
        L_0x0175:
            r12.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r12, r1, r3)
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r12)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m4718unboximpl()
            float r0 = r0 + r20
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r9 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m1922boximpl(r17)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r9[r2] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m4702boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r8 = 1
            r9[r8] = r0
            r7 = -1822160838(0xffffffff9364083a, float:-2.8781702E-27)
            androidx.compose.material.SurfaceKt$Surface$1 r3 = new androidx.compose.material.SurfaceKt$Surface$1
            r0 = r3
            r1 = r13
            r2 = r14
            r10 = r3
            r3 = r15
            r11 = -1822160838(0xffffffff9364083a, float:-2.8781702E-27)
            r7 = r19
            r11 = 1
            r8 = r20
            r21 = r9
            r9 = r30
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            r0 = -1822160838(0xffffffff9364083a, float:-2.8781702E-27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r11, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r21
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r12, (int) r1)
            r1 = r13
            r2 = r14
            r5 = r17
        L_0x01e6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x01ed
            goto L_0x01fe
        L_0x01ed:
            androidx.compose.material.SurfaceKt$Surface$2 r13 = new androidx.compose.material.SurfaceKt$Surface$2
            r0 = r13
            r9 = r30
            r10 = r32
            r11 = r33
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012b  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: Surface-LPr_se0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1420SurfaceLPr_se0(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.foundation.BorderStroke r36, float r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r13 = r28
            r14 = r39
            r15 = r41
            r12 = r42
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1560876237(0x5d0914cd, float:6.1735908E17)
            r1 = r40
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)213@10696L6,214@10738L22,217@10872L39,*220@11004L7,221@11028L1013:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0027
            r0 = r15 | 6
            goto L_0x0037
        L_0x0027:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x0036
            boolean r0 = r11.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0033
            r0 = 4
            goto L_0x0034
        L_0x0033:
            r0 = 2
        L_0x0034:
            r0 = r0 | r15
            goto L_0x0037
        L_0x0036:
            r0 = r15
        L_0x0037:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003e
            r0 = r0 | 48
            goto L_0x0051
        L_0x003e:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            r3 = r29
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004d
            r4 = 32
            goto L_0x004f
        L_0x004d:
            r4 = 16
        L_0x004f:
            r0 = r0 | r4
            goto L_0x0053
        L_0x0051:
            r3 = r29
        L_0x0053:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x005a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r5 = r15 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x006d
            r5 = r30
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x0069
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r0 = r0 | r6
            goto L_0x006f
        L_0x006d:
            r5 = r30
        L_0x006f:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x0076
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r7 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0089
            r7 = r31
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0085
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r0 = r0 | r8
            goto L_0x008b
        L_0x0089:
            r7 = r31
        L_0x008b:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x00a6
            r8 = r12 & 16
            if (r8 != 0) goto L_0x00a0
            r8 = r32
            boolean r10 = r11.changed((long) r8)
            if (r10 == 0) goto L_0x00a2
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a0:
            r8 = r32
        L_0x00a2:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r10
            goto L_0x00a8
        L_0x00a6:
            r8 = r32
        L_0x00a8:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r15
            if (r10 != 0) goto L_0x00c5
            r10 = r12 & 32
            if (r10 != 0) goto L_0x00bd
            r10 = r2
            r1 = r34
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00c0
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00bd:
            r10 = r2
            r1 = r34
        L_0x00c0:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r16
            goto L_0x00c8
        L_0x00c5:
            r10 = r2
            r1 = r34
        L_0x00c8:
            r16 = r12 & 64
            if (r16 == 0) goto L_0x00d3
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r1 = r36
            goto L_0x00e7
        L_0x00d3:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r15 & r17
            r1 = r36
            if (r17 != 0) goto L_0x00e7
            boolean r2 = r11.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x00e4
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r0 = r0 | r2
        L_0x00e7:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00f2
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r17
            r1 = r37
            goto L_0x0107
        L_0x00f2:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            r1 = r37
            if (r17 != 0) goto L_0x0107
            boolean r17 = r11.changed((float) r1)
            if (r17 == 0) goto L_0x0103
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0105
        L_0x0103:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0105:
            r0 = r0 | r17
        L_0x0107:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0112
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r3 = r38
            goto L_0x0127
        L_0x0112:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r15 & r17
            r3 = r38
            if (r17 != 0) goto L_0x0127
            boolean r17 = r11.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0123
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0125
        L_0x0123:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0125:
            r0 = r0 | r17
        L_0x0127:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x012f
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012d:
            r0 = r0 | r3
            goto L_0x0140
        L_0x012f:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r15
            if (r3 != 0) goto L_0x0140
            boolean r3 = r11.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x013d
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012d
        L_0x013d:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012d
        L_0x0140:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r0
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0164
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x0150
            goto L_0x0164
        L_0x0150:
            r11.skipToGroupEnd()
            r2 = r29
            r3 = r30
            r10 = r37
            r4 = r7
            r5 = r8
            r14 = r11
            r7 = r34
            r9 = r36
            r11 = r38
            goto L_0x02ab
        L_0x0164:
            r11.startDefaults()
            r3 = r15 & 1
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0199
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0175
            goto L_0x0199
        L_0x0175:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x017e
            r0 = r0 & r18
        L_0x017e:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0186
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x0186:
            r16 = r29
            r18 = r30
            r22 = r34
            r24 = r36
            r25 = r37
            r26 = r38
            r6 = r0
            r19 = r7
            r20 = r8
            goto L_0x0222
        L_0x0199:
            if (r10 == 0) goto L_0x01a0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01a2
        L_0x01a0:
            r3 = r29
        L_0x01a2:
            if (r4 == 0) goto L_0x01a6
            r4 = 1
            goto L_0x01a8
        L_0x01a6:
            r4 = r30
        L_0x01a8:
            if (r6 == 0) goto L_0x01af
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01b0
        L_0x01af:
            r6 = r7
        L_0x01b0:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x01c2
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material.Colors r7 = r7.getColors(r11, r8)
            long r7 = r7.m1218getSurface0d7_KjU()
            r0 = r0 & r18
            goto L_0x01c3
        L_0x01c2:
            r7 = r8
        L_0x01c3:
            r9 = r12 & 32
            if (r9 == 0) goto L_0x01d5
            int r9 = r0 >> 12
            r9 = r9 & 14
            long r9 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r7, r11, r9)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r17
            goto L_0x01d7
        L_0x01d5:
            r9 = r34
        L_0x01d7:
            if (r16 == 0) goto L_0x01dc
            r16 = 0
            goto L_0x01de
        L_0x01dc:
            r16 = r36
        L_0x01de:
            if (r2 == 0) goto L_0x01e7
            r2 = 0
            float r5 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            goto L_0x01e9
        L_0x01e7:
            r2 = r37
        L_0x01e9:
            if (r1 == 0) goto L_0x0211
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r1 != r5) goto L_0x0209
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x0209:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r26 = r1
            goto L_0x0213
        L_0x0211:
            r26 = r38
        L_0x0213:
            r25 = r2
            r18 = r4
            r19 = r6
            r20 = r7
            r22 = r9
            r24 = r16
            r6 = r0
            r16 = r3
        L_0x0222:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m4718unboximpl()
            float r0 = r0 + r25
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m1922boximpl(r22)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m4702boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            r9 = 2031491085(0x7916180d, float:4.870827E34)
            androidx.compose.material.SurfaceKt$Surface$4 r8 = new androidx.compose.material.SurfaceKt$Surface$4
            r0 = r8
            r1 = r16
            r2 = r19
            r3 = r20
            r13 = 1
            r7 = r24
            r13 = r8
            r8 = r25
            r14 = 2031491085(0x7916180d, float:4.870827E34)
            r9 = r26
            r27 = r10
            r10 = r18
            r14 = r11
            r11 = r28
            r12 = r39
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = 2031491085(0x7916180d, float:4.870827E34)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r1, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r27
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r14, (int) r1)
            r2 = r16
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r22
            r9 = r24
            r10 = r25
            r11 = r26
        L_0x02ab:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x02b2
            goto L_0x02c9
        L_0x02b2:
            androidx.compose.material.SurfaceKt$Surface$5 r16 = new androidx.compose.material.SurfaceKt$Surface$5
            r0 = r16
            r1 = r28
            r12 = r39
            r13 = r41
            r15 = r14
            r14 = r42
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1420SurfaceLPr_se0(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0129  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1421SurfaceNy5ogXk(boolean r30, kotlin.jvm.functions.Function0<kotlin.Unit> r31, androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, androidx.compose.foundation.BorderStroke r39, float r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, int r44, int r45, int r46) {
        /*
            r15 = r31
            r14 = r42
            r13 = r44
            r12 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 262027249(0xf9e37f1, float:1.560155E-29)
            r1 = r43
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)329@16529L6,330@16571L22,333@16705L39,*336@16837L7,337@16861L1052:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r13 | 6
            r10 = r30
            goto L_0x003b
        L_0x0029:
            r0 = r13 & 14
            r10 = r30
            if (r0 != 0) goto L_0x003a
            boolean r0 = r11.changed((boolean) r10)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r13
            goto L_0x003b
        L_0x003a:
            r0 = r13
        L_0x003b:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0042
            r0 = r0 | 48
            goto L_0x0052
        L_0x0042:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004f
            r3 = 32
            goto L_0x0051
        L_0x004f:
            r3 = 16
        L_0x0051:
            r0 = r0 | r3
        L_0x0052:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0059
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006c
            r4 = r32
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0068
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r5
            goto L_0x006e
        L_0x006c:
            r4 = r32
        L_0x006e:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0075
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0088
            r6 = r33
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x0084
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r0 = r0 | r7
            goto L_0x008a
        L_0x0088:
            r6 = r33
        L_0x008a:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0091:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00a6
            r8 = r34
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a2
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r9
            goto L_0x00a8
        L_0x00a6:
            r8 = r34
        L_0x00a8:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c1
            r9 = r12 & 32
            r1 = r35
            if (r9 != 0) goto L_0x00bc
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r16
            goto L_0x00c3
        L_0x00c1:
            r1 = r35
        L_0x00c3:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00dd
            r16 = r12 & 64
            r9 = r37
            if (r16 != 0) goto L_0x00d8
            boolean r17 = r11.changed((long) r9)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r17
            goto L_0x00df
        L_0x00dd:
            r9 = r37
        L_0x00df:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00e7
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            goto L_0x00fc
        L_0x00e7:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00fc
            r2 = r39
            boolean r17 = r11.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00f7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r17
            goto L_0x00fe
        L_0x00fc:
            r2 = r39
        L_0x00fe:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0109
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r4 = r40
            goto L_0x011e
        L_0x0109:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            r4 = r40
            if (r17 != 0) goto L_0x011e
            boolean r17 = r11.changed((float) r4)
            if (r17 == 0) goto L_0x011a
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x011a:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r0 = r0 | r17
        L_0x011e:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0129
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r17
            r6 = r41
            goto L_0x013e
        L_0x0129:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r13 & r17
            r6 = r41
            if (r17 != 0) goto L_0x013e
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x013a
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013c
        L_0x013a:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013c:
            r0 = r0 | r17
        L_0x013e:
            r6 = r12 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0147
            r6 = r45 | 6
        L_0x0144:
            r17 = r6
            goto L_0x0159
        L_0x0147:
            r6 = r45 & 14
            if (r6 != 0) goto L_0x0157
            boolean r6 = r11.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x0153
            r6 = 4
            goto L_0x0154
        L_0x0153:
            r6 = 2
        L_0x0154:
            r6 = r45 | r6
            goto L_0x0144
        L_0x0157:
            r17 = r45
        L_0x0159:
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r0
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x0183
            r6 = r17 & 11
            r8 = 2
            if (r6 != r8) goto L_0x0183
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x016e
            goto L_0x0183
        L_0x016e:
            r11.skipToGroupEnd()
            r3 = r32
            r4 = r33
            r5 = r34
            r6 = r35
            r12 = r41
            r8 = r9
            r15 = r11
            r10 = r39
            r11 = r40
            goto L_0x02de
        L_0x0183:
            r11.startDefaults()
            r8 = r13 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r8 == 0) goto L_0x01b9
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0197
            goto L_0x01b9
        L_0x0197:
            r11.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x01a0
            r0 = r0 & r18
        L_0x01a0:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x01a6
            r0 = r0 & r16
        L_0x01a6:
            r16 = r32
            r18 = r33
            r20 = r34
            r21 = r35
            r25 = r39
            r26 = r40
            r27 = r41
            r6 = r0
            r23 = r9
            goto L_0x024d
        L_0x01b9:
            if (r3 == 0) goto L_0x01c0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01c2
        L_0x01c0:
            r3 = r32
        L_0x01c2:
            if (r5 == 0) goto L_0x01c6
            r5 = 1
            goto L_0x01c8
        L_0x01c6:
            r5 = r33
        L_0x01c8:
            if (r7 == 0) goto L_0x01cf
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01d1
        L_0x01cf:
            r7 = r34
        L_0x01d1:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01e7
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r6 = r8.getColors(r11, r6)
            long r20 = r6.m1218getSurface0d7_KjU()
            r0 = r0 & r18
            r32 = r5
            r5 = r20
            goto L_0x01eb
        L_0x01e7:
            r32 = r5
            r5 = r35
        L_0x01eb:
            r8 = r12 & 64
            if (r8 == 0) goto L_0x01fa
            int r8 = r0 >> 15
            r8 = r8 & 14
            long r8 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r5, r11, r8)
            r0 = r0 & r16
            goto L_0x01fb
        L_0x01fa:
            r8 = r9
        L_0x01fb:
            if (r1 == 0) goto L_0x01ff
            r1 = 0
            goto L_0x0201
        L_0x01ff:
            r1 = r39
        L_0x0201:
            if (r2 == 0) goto L_0x020a
            r2 = 0
            float r10 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            goto L_0x020c
        L_0x020a:
            r2 = r40
        L_0x020c:
            if (r4 == 0) goto L_0x023c
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r4 != r10) goto L_0x022c
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x022c:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r18 = r32
            r25 = r1
            r26 = r2
            r16 = r3
            r27 = r4
            goto L_0x0246
        L_0x023c:
            r18 = r32
            r27 = r41
            r25 = r1
            r26 = r2
            r16 = r3
        L_0x0246:
            r21 = r5
            r20 = r7
            r23 = r8
            r6 = r0
        L_0x024d:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m4718unboximpl()
            float r0 = r0 + r26
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m1922boximpl(r23)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m4702boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            r9 = -1391199439(0xffffffffad13fb31, float:-8.411758E-12)
            androidx.compose.material.SurfaceKt$Surface$7 r8 = new androidx.compose.material.SurfaceKt$Surface$7
            r0 = r8
            r1 = r16
            r2 = r20
            r3 = r21
            r15 = 1
            r7 = r25
            r15 = r8
            r8 = r26
            r19 = r15
            r15 = -1391199439(0xffffffffad13fb31, float:-8.411758E-12)
            r9 = r30
            r28 = r10
            r10 = r27
            r15 = r11
            r11 = r18
            r12 = r31
            r13 = r42
            r14 = r17
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r19
            r0 = -1391199439(0xffffffffad13fb31, float:-8.411758E-12)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r28
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            r3 = r16
            r4 = r18
            r5 = r20
            r6 = r21
            r8 = r23
            r10 = r25
            r11 = r26
            r12 = r27
        L_0x02de:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x02e5
            goto L_0x0303
        L_0x02e5:
            androidx.compose.material.SurfaceKt$Surface$8 r17 = new androidx.compose.material.SurfaceKt$Surface$8
            r0 = r17
            r1 = r30
            r2 = r31
            r13 = r42
            r14 = r44
            r29 = r15
            r15 = r45
            r16 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r29
            r1.updateScope(r0)
        L_0x0303:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1421SurfaceNy5ogXk(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0129  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1422SurfaceNy5ogXk(boolean r30, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r31, androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, androidx.compose.foundation.BorderStroke r39, float r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, int r44, int r45, int r46) {
        /*
            r15 = r31
            r14 = r42
            r13 = r44
            r12 = r46
            java.lang.String r0 = "onCheckedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1341569296(0x4ff6b910, float:8.2786468E9)
            r1 = r43
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)446@22479L6,447@22521L22,450@22655L39,*453@22787L7,454@22811L1065:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r13 | 6
            r10 = r30
            goto L_0x003b
        L_0x0029:
            r0 = r13 & 14
            r10 = r30
            if (r0 != 0) goto L_0x003a
            boolean r0 = r11.changed((boolean) r10)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r13
            goto L_0x003b
        L_0x003a:
            r0 = r13
        L_0x003b:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0042
            r0 = r0 | 48
            goto L_0x0052
        L_0x0042:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004f
            r3 = 32
            goto L_0x0051
        L_0x004f:
            r3 = 16
        L_0x0051:
            r0 = r0 | r3
        L_0x0052:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0059
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006c
        L_0x0059:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006c
            r4 = r32
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0068
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0068:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r0 = r0 | r5
            goto L_0x006e
        L_0x006c:
            r4 = r32
        L_0x006e:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0075
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0075:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0088
            r6 = r33
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x0084
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0086
        L_0x0084:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0086:
            r0 = r0 | r7
            goto L_0x008a
        L_0x0088:
            r6 = r33
        L_0x008a:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x0091
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a6
        L_0x0091:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00a6
            r8 = r34
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a2
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r9
            goto L_0x00a8
        L_0x00a6:
            r8 = r34
        L_0x00a8:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00c1
            r9 = r12 & 32
            r1 = r35
            if (r9 != 0) goto L_0x00bc
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r16
            goto L_0x00c3
        L_0x00c1:
            r1 = r35
        L_0x00c3:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00dd
            r16 = r12 & 64
            r9 = r37
            if (r16 != 0) goto L_0x00d8
            boolean r17 = r11.changed((long) r9)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r17
            goto L_0x00df
        L_0x00dd:
            r9 = r37
        L_0x00df:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00e7
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            goto L_0x00fc
        L_0x00e7:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00fc
            r2 = r39
            boolean r17 = r11.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00f7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r0 = r0 | r17
            goto L_0x00fe
        L_0x00fc:
            r2 = r39
        L_0x00fe:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0109
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r4 = r40
            goto L_0x011e
        L_0x0109:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            r4 = r40
            if (r17 != 0) goto L_0x011e
            boolean r17 = r11.changed((float) r4)
            if (r17 == 0) goto L_0x011a
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x011a:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r0 = r0 | r17
        L_0x011e:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0129
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r17
            r6 = r41
            goto L_0x013e
        L_0x0129:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r13 & r17
            r6 = r41
            if (r17 != 0) goto L_0x013e
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x013a
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013c
        L_0x013a:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013c:
            r0 = r0 | r17
        L_0x013e:
            r6 = r12 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0147
            r6 = r45 | 6
        L_0x0144:
            r17 = r6
            goto L_0x0159
        L_0x0147:
            r6 = r45 & 14
            if (r6 != 0) goto L_0x0157
            boolean r6 = r11.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x0153
            r6 = 4
            goto L_0x0154
        L_0x0153:
            r6 = 2
        L_0x0154:
            r6 = r45 | r6
            goto L_0x0144
        L_0x0157:
            r17 = r45
        L_0x0159:
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r0
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x0183
            r6 = r17 & 11
            r8 = 2
            if (r6 != r8) goto L_0x0183
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x016e
            goto L_0x0183
        L_0x016e:
            r11.skipToGroupEnd()
            r3 = r32
            r4 = r33
            r5 = r34
            r6 = r35
            r12 = r41
            r8 = r9
            r15 = r11
            r10 = r39
            r11 = r40
            goto L_0x02de
        L_0x0183:
            r11.startDefaults()
            r8 = r13 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r8 == 0) goto L_0x01b9
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0197
            goto L_0x01b9
        L_0x0197:
            r11.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x01a0
            r0 = r0 & r18
        L_0x01a0:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x01a6
            r0 = r0 & r16
        L_0x01a6:
            r16 = r32
            r18 = r33
            r20 = r34
            r21 = r35
            r25 = r39
            r26 = r40
            r27 = r41
            r6 = r0
            r23 = r9
            goto L_0x024d
        L_0x01b9:
            if (r3 == 0) goto L_0x01c0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x01c2
        L_0x01c0:
            r3 = r32
        L_0x01c2:
            if (r5 == 0) goto L_0x01c6
            r5 = 1
            goto L_0x01c8
        L_0x01c6:
            r5 = r33
        L_0x01c8:
            if (r7 == 0) goto L_0x01cf
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01d1
        L_0x01cf:
            r7 = r34
        L_0x01d1:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01e7
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r6 = r8.getColors(r11, r6)
            long r20 = r6.m1218getSurface0d7_KjU()
            r0 = r0 & r18
            r32 = r5
            r5 = r20
            goto L_0x01eb
        L_0x01e7:
            r32 = r5
            r5 = r35
        L_0x01eb:
            r8 = r12 & 64
            if (r8 == 0) goto L_0x01fa
            int r8 = r0 >> 15
            r8 = r8 & 14
            long r8 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r5, r11, r8)
            r0 = r0 & r16
            goto L_0x01fb
        L_0x01fa:
            r8 = r9
        L_0x01fb:
            if (r1 == 0) goto L_0x01ff
            r1 = 0
            goto L_0x0201
        L_0x01ff:
            r1 = r39
        L_0x0201:
            if (r2 == 0) goto L_0x020a
            r2 = 0
            float r10 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r10)
            goto L_0x020c
        L_0x020a:
            r2 = r40
        L_0x020c:
            if (r4 == 0) goto L_0x023c
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r4 != r10) goto L_0x022c
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x022c:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r18 = r32
            r25 = r1
            r26 = r2
            r16 = r3
            r27 = r4
            goto L_0x0246
        L_0x023c:
            r18 = r32
            r27 = r41
            r25 = r1
            r26 = r2
            r16 = r3
        L_0x0246:
            r21 = r5
            r20 = r7
            r23 = r8
            r6 = r0
        L_0x024d:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r1, r2)
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m4718unboximpl()
            float r0 = r0 + r26
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m1922boximpl(r23)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m4702boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            r9 = -311657392(0xffffffffed6c7c50, float:-4.5742967E27)
            androidx.compose.material.SurfaceKt$Surface$10 r8 = new androidx.compose.material.SurfaceKt$Surface$10
            r0 = r8
            r1 = r16
            r2 = r20
            r3 = r21
            r15 = 1
            r7 = r25
            r15 = r8
            r8 = r26
            r19 = r15
            r15 = -311657392(0xffffffffed6c7c50, float:-4.5742967E27)
            r9 = r30
            r28 = r10
            r10 = r27
            r15 = r11
            r11 = r18
            r12 = r31
            r13 = r42
            r14 = r17
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r19
            r0 = -311657392(0xffffffffed6c7c50, float:-4.5742967E27)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r28
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            r3 = r16
            r4 = r18
            r5 = r20
            r6 = r21
            r8 = r23
            r10 = r25
            r11 = r26
            r12 = r27
        L_0x02de:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x02e5
            goto L_0x0303
        L_0x02e5:
            androidx.compose.material.SurfaceKt$Surface$11 r17 = new androidx.compose.material.SurfaceKt$Surface$11
            r0 = r17
            r1 = r30
            r2 = r31
            r13 = r42
            r14 = r44
            r29 = r15
            r15 = r45
            r16 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16)
            r0 = r17
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r29
            r1.updateScope(r0)
        L_0x0303:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1422SurfaceNy5ogXk(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0131  */
    @androidx.compose.material.ExperimentalMaterialApi
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @kotlin.ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Surface-9VG74zQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1418Surface9VG74zQ(kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, androidx.compose.ui.graphics.Shape r39, long r40, long r42, androidx.compose.foundation.BorderStroke r44, float r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.foundation.Indication r47, boolean r48, java.lang.String r49, androidx.compose.ui.semantics.Role r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r15 = r37
            r14 = r51
            r13 = r53
            r12 = r54
            r11 = r55
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1585925488(0x5e874d70, float:4.874786E18)
            r1 = r52
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)575@29078L6,576@29120L22,579@29254L39,580@29341L7,*586@29528L7,587@29552L1119:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r13 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r13
            goto L_0x0039
        L_0x0038:
            r0 = r13
        L_0x0039:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0053
        L_0x0040:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0053
            r6 = r38
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x004f
            r7 = 32
            goto L_0x0051
        L_0x004f:
            r7 = 16
        L_0x0051:
            r0 = r0 | r7
            goto L_0x0055
        L_0x0053:
            r6 = r38
        L_0x0055:
            r7 = r11 & 4
            if (r7 == 0) goto L_0x005c
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0070
        L_0x005c:
            r1 = r13 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x0070
            r1 = r39
            boolean r16 = r10.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x006b
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r0 = r0 | r16
            goto L_0x0072
        L_0x0070:
            r1 = r39
        L_0x0072:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008a
            r4 = r11 & 8
            r5 = r40
            if (r4 != 0) goto L_0x0085
            boolean r17 = r10.changed((long) r5)
            if (r17 == 0) goto L_0x0085
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r0 = r0 | r17
            goto L_0x008c
        L_0x008a:
            r5 = r40
        L_0x008c:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00a6
            r17 = r11 & 16
            r4 = r42
            if (r17 != 0) goto L_0x00a2
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x00a2
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a4
        L_0x00a2:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x00a4:
            r0 = r0 | r6
            goto L_0x00a8
        L_0x00a6:
            r4 = r42
        L_0x00a8:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x00b3
            r18 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r18
            r8 = r44
            goto L_0x00c8
        L_0x00b3:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r13 & r18
            r8 = r44
            if (r18 != 0) goto L_0x00c8
            boolean r19 = r10.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x00c4
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r0 = r0 | r19
        L_0x00c8:
            r19 = r11 & 64
            if (r19 == 0) goto L_0x00d3
            r20 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r20
            r9 = r45
            goto L_0x00e8
        L_0x00d3:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r13 & r20
            r9 = r45
            if (r20 != 0) goto L_0x00e8
            boolean r21 = r10.changed((float) r9)
            if (r21 == 0) goto L_0x00e4
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e6
        L_0x00e4:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e6:
            r0 = r0 | r21
        L_0x00e8:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00f3
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r22
            r1 = r46
            goto L_0x0108
        L_0x00f3:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r13 & r22
            r1 = r46
            if (r22 != 0) goto L_0x0108
            boolean r22 = r10.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x0104
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0106
        L_0x0104:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0106:
            r0 = r0 | r22
        L_0x0108:
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x0124
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x011d
            r1 = r47
            boolean r22 = r10.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x011f
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0121
        L_0x011d:
            r1 = r47
        L_0x011f:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0121:
            r0 = r0 | r22
            goto L_0x0126
        L_0x0124:
            r1 = r47
        L_0x0126:
            r1 = r11 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0131
            r22 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r22
            r4 = r48
            goto L_0x0145
        L_0x0131:
            r22 = 1879048192(0x70000000, float:1.58456325E29)
            r22 = r13 & r22
            r4 = r48
            if (r22 != 0) goto L_0x0145
            boolean r5 = r10.changed((boolean) r4)
            if (r5 == 0) goto L_0x0142
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0144
        L_0x0142:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0144:
            r0 = r0 | r5
        L_0x0145:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x014e
            r22 = r12 | 6
            r4 = r49
            goto L_0x0164
        L_0x014e:
            r22 = r12 & 14
            r4 = r49
            if (r22 != 0) goto L_0x0162
            boolean r22 = r10.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x015d
            r22 = 4
            goto L_0x015f
        L_0x015d:
            r22 = 2
        L_0x015f:
            r22 = r12 | r22
            goto L_0x0164
        L_0x0162:
            r22 = r12
        L_0x0164:
            r4 = r11 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x016b
            r22 = r22 | 48
            goto L_0x017e
        L_0x016b:
            r23 = r12 & 112(0x70, float:1.57E-43)
            r8 = r50
            if (r23 != 0) goto L_0x017e
            boolean r23 = r10.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x017a
            r16 = 32
            goto L_0x017c
        L_0x017a:
            r16 = 16
        L_0x017c:
            r22 = r22 | r16
        L_0x017e:
            r8 = r22
            r9 = r11 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0187
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0198
        L_0x0187:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0198
            boolean r9 = r10.changed((java.lang.Object) r14)
            if (r9 == 0) goto L_0x0194
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x0196
        L_0x0194:
            r18 = 128(0x80, float:1.794E-43)
        L_0x0196:
            r8 = r8 | r18
        L_0x0198:
            r9 = r8
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r0
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x01cb
            r8 = r9 & 731(0x2db, float:1.024E-42)
            r12 = 146(0x92, float:2.05E-43)
            if (r8 != r12) goto L_0x01cb
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x01af
            goto L_0x01cb
        L_0x01af:
            r10.skipToGroupEnd()
            r2 = r38
            r3 = r39
            r4 = r40
            r6 = r42
            r8 = r44
            r9 = r45
            r11 = r47
            r12 = r48
            r13 = r49
            r14 = r50
            r0 = r10
            r10 = r46
            goto L_0x0379
        L_0x01cb:
            r10.startDefaults()
            r8 = r13 & 1
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            r16 = r9
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r18 = 0
            if (r8 == 0) goto L_0x0212
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x01e2
            goto L_0x0212
        L_0x01e2:
            r10.skipToGroupEnd()
            r1 = r11 & 8
            if (r1 == 0) goto L_0x01eb
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01eb:
            r1 = r11 & 16
            if (r1 == 0) goto L_0x01f1
            r0 = r0 & r17
        L_0x01f1:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01f9
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x01f9:
            r17 = r38
            r18 = r39
            r23 = r40
            r25 = r42
            r19 = r44
            r27 = r45
            r28 = r46
            r29 = r47
            r30 = r48
            r31 = r49
            r32 = r50
            r6 = r0
            goto L_0x02e3
        L_0x0212:
            if (r3 == 0) goto L_0x0219
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x021b
        L_0x0219:
            r3 = r38
        L_0x021b:
            if (r7 == 0) goto L_0x0222
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x0224
        L_0x0222:
            r7 = r39
        L_0x0224:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x0236
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r9 = 6
            androidx.compose.material.Colors r8 = r8.getColors(r10, r9)
            long r8 = r8.m1218getSurface0d7_KjU()
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0238
        L_0x0236:
            r8 = r40
        L_0x0238:
            r23 = r11 & 16
            if (r23 == 0) goto L_0x0249
            int r23 = r0 >> 9
            r38 = r3
            r3 = r23 & 14
            long r23 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r8, r10, r3)
            r0 = r0 & r17
            goto L_0x024d
        L_0x0249:
            r38 = r3
            r23 = r42
        L_0x024d:
            if (r6 == 0) goto L_0x0252
            r3 = r18
            goto L_0x0254
        L_0x0252:
            r3 = r44
        L_0x0254:
            r39 = r3
            if (r19 == 0) goto L_0x025f
            r6 = 0
            float r3 = (float) r6
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            goto L_0x0261
        L_0x025f:
            r3 = r45
        L_0x0261:
            if (r2 == 0) goto L_0x0287
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r2 != r6) goto L_0x0281
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r2)
        L_0x0281:
            r10.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x0289
        L_0x0287:
            r2 = r46
        L_0x0289:
            r6 = r11 & 256(0x100, float:3.59E-43)
            if (r6 == 0) goto L_0x02a9
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r40 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r2, r12)
            java.lang.Object r2 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.Indication r2 = (androidx.compose.foundation.Indication) r2
            r6 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r6
            goto L_0x02ad
        L_0x02a9:
            r40 = r2
            r2 = r47
        L_0x02ad:
            if (r1 == 0) goto L_0x02b1
            r1 = 1
            goto L_0x02b3
        L_0x02b1:
            r1 = r48
        L_0x02b3:
            if (r5 == 0) goto L_0x02b8
            r5 = r18
            goto L_0x02ba
        L_0x02b8:
            r5 = r49
        L_0x02ba:
            r17 = r38
            r19 = r39
            r28 = r40
            if (r4 == 0) goto L_0x02d2
            r6 = r0
            r30 = r1
            r29 = r2
            r27 = r3
            r31 = r5
            r32 = r18
            r25 = r23
            r18 = r7
            goto L_0x02e1
        L_0x02d2:
            r32 = r50
            r6 = r0
            r30 = r1
            r29 = r2
            r27 = r3
            r31 = r5
            r18 = r7
            r25 = r23
        L_0x02e1:
            r23 = r8
        L_0x02e3:
            r10.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r12)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m4718unboximpl()
            float r0 = r0 + r27
            float r0 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r0)
            r5 = r0
            r1 = 2
            androidx.compose.runtime.ProvidedValue[] r12 = new androidx.compose.runtime.ProvidedValue[r1]
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m1922boximpl(r25)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r2)
            r2 = 0
            r12[r2] = r1
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r0 = androidx.compose.ui.unit.Dp.m4702boximpl(r0)
            androidx.compose.runtime.ProvidedValue r0 = r1.provides(r0)
            r9 = 1
            r12[r9] = r0
            r8 = 149594672(0x8eaa230, float:1.4121493E-33)
            androidx.compose.material.SurfaceKt$Surface$13 r7 = new androidx.compose.material.SurfaceKt$Surface$13
            r0 = r7
            r1 = r17
            r2 = r18
            r3 = r23
            r33 = r7
            r7 = r19
            r8 = r27
            r9 = r28
            r34 = r10
            r10 = r29
            r11 = r30
            r35 = r12
            r12 = r31
            r13 = r32
            r14 = r37
            r15 = r51
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r2 = r33
            r0 = r34
            r1 = 149594672(0x8eaa230, float:1.4121493E-33)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r3, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = 56
            r3 = r35
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r1, (androidx.compose.runtime.Composer) r0, (int) r2)
            r2 = r17
            r3 = r18
            r8 = r19
            r4 = r23
            r6 = r25
            r9 = r27
            r10 = r28
            r11 = r29
            r12 = r30
            r13 = r31
            r14 = r32
        L_0x0379:
            androidx.compose.runtime.ScopeUpdateScope r15 = r0.endRestartGroup()
            if (r15 != 0) goto L_0x0380
            goto L_0x039c
        L_0x0380:
            androidx.compose.material.SurfaceKt$Surface$14 r19 = new androidx.compose.material.SurfaceKt$Surface$14
            r0 = r19
            r1 = r37
            r36 = r15
            r15 = r51
            r16 = r53
            r17 = r54
            r18 = r55
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x039c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1418Surface9VG74zQ(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg  reason: not valid java name */
    public static final Modifier m1425surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        return ClipKt.clip(BackgroundKt.m176backgroundbw27NRU(ShadowKt.m1600shadows4CzXII$default(modifier, f, shape, false, 0, 0, 24, (Object) null).then(borderStroke != null ? BorderKt.border(Modifier.Companion, borderStroke, shape) : Modifier.Companion), j, shape), shape);
    }

    /* access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M  reason: not valid java name */
    public static final long m1426surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation(composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)637@31177L6,638@31248L31:Surface.kt#jmzs0o");
        if (Color.m1933equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m1218getSurface0d7_KjU()) && elevationOverlay != null) {
            j = elevationOverlay.m1282apply7g2Lkgo(j, f, composer, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
        }
        composer.endReplaceableGroup();
        return j;
    }
}
