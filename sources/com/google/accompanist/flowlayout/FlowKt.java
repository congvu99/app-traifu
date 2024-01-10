package com.google.accompanist.flowlayout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001av\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001av\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018*\n\u0010\u001b\"\u00020\t2\u00020\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Flow", "", "modifier", "Landroidx/compose/ui/Modifier;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "mainAxisSize", "Lcom/google/accompanist/flowlayout/SizeMode;", "mainAxisAlignment", "Lcom/google/accompanist/flowlayout/MainAxisAlignment;", "Lcom/google/accompanist/flowlayout/FlowMainAxisAlignment;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Lcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;", "crossAxisSpacing", "lastLineMainAxisAlignment", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Flow-F4y8cZ0", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/LayoutOrientation;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FlowColumn", "FlowColumn-07r0xoM", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "FlowRow-07r0xoM", "FlowMainAxisAlignment", "flowlayout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Flow.kt */
public final class FlowKt {
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011f  */
    /* renamed from: FlowRow-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5050FlowRow07r0xoM(androidx.compose.ui.Modifier r26, com.google.accompanist.flowlayout.SizeMode r27, com.google.accompanist.flowlayout.MainAxisAlignment r28, float r29, com.google.accompanist.flowlayout.FlowCrossAxisAlignment r30, float r31, com.google.accompanist.flowlayout.MainAxisAlignment r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -137566119(0xfffffffff7cce859, float:-8.31204E33)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FlowRow)P(7,5,4,6:c#ui.unit.Dp,1,2:c#ui.unit.Dp,3)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x0023
            r2 = r12 | 6
            r3 = r2
            r2 = r26
            goto L_0x0037
        L_0x0023:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0034
            r2 = r26
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r12
            goto L_0x0037
        L_0x0034:
            r2 = r26
            r3 = r12
        L_0x0037:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r27
        L_0x0053:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x006d
            r7 = r28
            boolean r8 = r14.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0069
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r8
            goto L_0x006f
        L_0x006d:
            r7 = r28
        L_0x006f:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0076
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0089
            r9 = r29
            boolean r10 = r14.changed((float) r9)
            if (r10 == 0) goto L_0x0085
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r3 = r3 | r10
            goto L_0x008b
        L_0x0089:
            r9 = r29
        L_0x008b:
            r10 = r13 & 16
            r15 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0097
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r15 = r30
            goto L_0x00aa
        L_0x0097:
            r16 = r12 & r15
            r15 = r30
            if (r16 != 0) goto L_0x00aa
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a6
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r3 = r3 | r16
        L_0x00aa:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b7
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r0 = r31
            goto L_0x00ca
        L_0x00b7:
            r18 = r12 & r17
            r0 = r31
            if (r18 != 0) goto L_0x00ca
            boolean r19 = r14.changed((float) r0)
            if (r19 == 0) goto L_0x00c6
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r3 = r3 | r19
        L_0x00ca:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00e4
            r20 = r13 & 64
            r0 = r32
            if (r20 != 0) goto L_0x00df
            boolean r20 = r14.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00df
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r3 = r3 | r20
            goto L_0x00e6
        L_0x00e4:
            r0 = r32
        L_0x00e6:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00f0
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ee:
            r3 = r3 | r0
            goto L_0x0100
        L_0x00f0:
            r0 = r12 & r20
            if (r0 != 0) goto L_0x0100
            boolean r0 = r14.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x00fd
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00fd:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ee
        L_0x0100:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011f
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x0110
            goto L_0x011f
        L_0x0110:
            r14.skipToGroupEnd()
            r1 = r26
            r6 = r31
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r32
            goto L_0x01e9
        L_0x011f:
            r14.startDefaults()
            r0 = r12 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0147
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0130
            goto L_0x0147
        L_0x0130:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0138
            r3 = r3 & r2
        L_0x0138:
            r24 = r31
            r25 = r32
            r16 = r5
            r21 = r7
            r22 = r9
            r23 = r15
            r15 = r26
            goto L_0x018d
        L_0x0147:
            if (r1 == 0) goto L_0x014e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0150
        L_0x014e:
            r0 = r26
        L_0x0150:
            if (r4 == 0) goto L_0x0155
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            r5 = r1
        L_0x0155:
            if (r6 == 0) goto L_0x015a
            com.google.accompanist.flowlayout.MainAxisAlignment r1 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r7 = r1
        L_0x015a:
            r1 = 0
            if (r8 == 0) goto L_0x0163
            float r4 = (float) r1
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r9 = r4
        L_0x0163:
            if (r10 == 0) goto L_0x0168
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x0168:
            if (r16 == 0) goto L_0x0170
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            goto L_0x0172
        L_0x0170:
            r1 = r31
        L_0x0172:
            r4 = r13 & 64
            if (r4 == 0) goto L_0x0180
            r3 = r3 & r2
            r24 = r1
            r16 = r5
            r21 = r7
            r25 = r21
            goto L_0x0188
        L_0x0180:
            r25 = r32
            r24 = r1
            r16 = r5
            r21 = r7
        L_0x0188:
            r22 = r9
            r23 = r15
            r15 = r0
        L_0x018d:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019f
            r0 = -1
            java.lang.String r1 = "com.google.accompanist.flowlayout.FlowRow (Flow.kt:46)"
            r2 = -137566119(0xfffffffff7cce859, float:-8.31204E33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x019f:
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Horizontal
            r0 = r3 & 14
            r0 = r0 | 48
            int r2 = r3 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = r2 & r20
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r33
            r9 = r14
            m5048FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01dc:
            r1 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
        L_0x01e9:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01f0
            goto L_0x0201
        L_0x01f0:
            com.google.accompanist.flowlayout.FlowKt$FlowRow$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowRow$1
            r0 = r15
            r8 = r33
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m5050FlowRow07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011f  */
    /* renamed from: FlowColumn-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5049FlowColumn07r0xoM(androidx.compose.ui.Modifier r26, com.google.accompanist.flowlayout.SizeMode r27, com.google.accompanist.flowlayout.MainAxisAlignment r28, float r29, com.google.accompanist.flowlayout.FlowCrossAxisAlignment r30, float r31, com.google.accompanist.flowlayout.MainAxisAlignment r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 203669733(0xc23c0e5, float:1.261511E-31)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(FlowColumn)P(7,5,4,6:c#ui.unit.Dp,1,2:c#ui.unit.Dp,3)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x0023
            r2 = r12 | 6
            r3 = r2
            r2 = r26
            goto L_0x0037
        L_0x0023:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x0034
            r2 = r26
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0031
            r3 = 4
            goto L_0x0032
        L_0x0031:
            r3 = 2
        L_0x0032:
            r3 = r3 | r12
            goto L_0x0037
        L_0x0034:
            r2 = r26
            r3 = r12
        L_0x0037:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x003e
            r3 = r3 | 48
            goto L_0x0051
        L_0x003e:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004d
            r6 = 32
            goto L_0x004f
        L_0x004d:
            r6 = 16
        L_0x004f:
            r3 = r3 | r6
            goto L_0x0053
        L_0x0051:
            r5 = r27
        L_0x0053:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x005a
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x006d
            r7 = r28
            boolean r8 = r14.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0069
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r3 = r3 | r8
            goto L_0x006f
        L_0x006d:
            r7 = r28
        L_0x006f:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0076
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0089
            r9 = r29
            boolean r10 = r14.changed((float) r9)
            if (r10 == 0) goto L_0x0085
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r3 = r3 | r10
            goto L_0x008b
        L_0x0089:
            r9 = r29
        L_0x008b:
            r10 = r13 & 16
            r15 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0097
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r15 = r30
            goto L_0x00aa
        L_0x0097:
            r16 = r12 & r15
            r15 = r30
            if (r16 != 0) goto L_0x00aa
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a6
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r3 = r3 | r16
        L_0x00aa:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b7
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r0 = r31
            goto L_0x00ca
        L_0x00b7:
            r18 = r12 & r17
            r0 = r31
            if (r18 != 0) goto L_0x00ca
            boolean r19 = r14.changed((float) r0)
            if (r19 == 0) goto L_0x00c6
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r3 = r3 | r19
        L_0x00ca:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00e4
            r20 = r13 & 64
            r0 = r32
            if (r20 != 0) goto L_0x00df
            boolean r20 = r14.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00df
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r3 = r3 | r20
            goto L_0x00e6
        L_0x00e4:
            r0 = r32
        L_0x00e6:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00f0
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ee:
            r3 = r3 | r0
            goto L_0x0100
        L_0x00f0:
            r0 = r12 & r20
            if (r0 != 0) goto L_0x0100
            boolean r0 = r14.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x00fd
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ee
        L_0x00fd:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ee
        L_0x0100:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011f
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x0110
            goto L_0x011f
        L_0x0110:
            r14.skipToGroupEnd()
            r1 = r26
            r6 = r31
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r32
            goto L_0x01e9
        L_0x011f:
            r14.startDefaults()
            r0 = r12 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0147
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0130
            goto L_0x0147
        L_0x0130:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0138
            r3 = r3 & r2
        L_0x0138:
            r24 = r31
            r25 = r32
            r16 = r5
            r21 = r7
            r22 = r9
            r23 = r15
            r15 = r26
            goto L_0x018d
        L_0x0147:
            if (r1 == 0) goto L_0x014e
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0150
        L_0x014e:
            r0 = r26
        L_0x0150:
            if (r4 == 0) goto L_0x0155
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            r5 = r1
        L_0x0155:
            if (r6 == 0) goto L_0x015a
            com.google.accompanist.flowlayout.MainAxisAlignment r1 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r7 = r1
        L_0x015a:
            r1 = 0
            if (r8 == 0) goto L_0x0163
            float r4 = (float) r1
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r9 = r4
        L_0x0163:
            if (r10 == 0) goto L_0x0168
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x0168:
            if (r16 == 0) goto L_0x0170
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
            goto L_0x0172
        L_0x0170:
            r1 = r31
        L_0x0172:
            r4 = r13 & 64
            if (r4 == 0) goto L_0x0180
            r3 = r3 & r2
            r24 = r1
            r16 = r5
            r21 = r7
            r25 = r21
            goto L_0x0188
        L_0x0180:
            r25 = r32
            r24 = r1
            r16 = r5
            r21 = r7
        L_0x0188:
            r22 = r9
            r23 = r15
            r15 = r0
        L_0x018d:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x019f
            r0 = -1
            java.lang.String r1 = "com.google.accompanist.flowlayout.FlowColumn (Flow.kt:84)"
            r2 = 203669733(0xc23c0e5, float:1.261511E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x019f:
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Vertical
            r0 = r3 & 14
            r0 = r0 | 48
            int r2 = r3 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = r2 & r20
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r33
            r9 = r14
            m5048FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01dc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01dc:
            r1 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
        L_0x01e9:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01f0
            goto L_0x0201
        L_0x01f0:
            com.google.accompanist.flowlayout.FlowKt$FlowColumn$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowColumn$1
            r0 = r15
            r8 = r33
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0201:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m5049FlowColumn07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Flow-F4y8cZ0  reason: not valid java name */
    public static final void m5048FlowF4y8cZ0(Modifier modifier, LayoutOrientation layoutOrientation, SizeMode sizeMode, MainAxisAlignment mainAxisAlignment, float f, FlowCrossAxisAlignment flowCrossAxisAlignment, float f2, MainAxisAlignment mainAxisAlignment2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(-1567419051);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) layoutOrientation) ? 32 : 16;
        } else {
            LayoutOrientation layoutOrientation2 = layoutOrientation;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) sizeMode) ? 256 : 128;
        } else {
            SizeMode sizeMode2 = sizeMode;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) mainAxisAlignment) ? 2048 : 1024;
        } else {
            MainAxisAlignment mainAxisAlignment3 = mainAxisAlignment;
        }
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed(f) ? 16384 : 8192;
        } else {
            float f3 = f;
        }
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) flowCrossAxisAlignment) ? 131072 : 65536;
        } else {
            FlowCrossAxisAlignment flowCrossAxisAlignment2 = flowCrossAxisAlignment;
        }
        float f4 = f2;
        if ((3670016 & i3) == 0) {
            i2 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
        }
        MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment2;
        if ((29360128 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) mainAxisAlignment4) ? 8388608 : 4194304;
        }
        if ((234881024 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1567419051, i2, -1, "com.google.accompanist.flowlayout.Flow (Flow.kt:131)");
            }
            MeasurePolicy flowKt$Flow$1 = new FlowKt$Flow$1(layoutOrientation, f, sizeMode, f2, mainAxisAlignment, mainAxisAlignment2, flowCrossAxisAlignment);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i4 = (((((i2 << 3) & 112) | ((i2 >> 24) & 14)) << 9) & 7168) | 6;
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
            Composer r2 = Updater.m1543constructorimpl(startRestartGroup);
            Updater.m1550setimpl(r2, flowKt$Flow$1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1550setimpl(r2, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1550setimpl(r2, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1550setimpl(r2, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1533boximpl(SkippableUpdater.m1534constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function22.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FlowKt$Flow$2(modifier, layoutOrientation, sizeMode, mainAxisAlignment, f, flowCrossAxisAlignment, f2, mainAxisAlignment2, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }
}
