package io.intercom.android.sdk.survey.ui.questiontype.numericscale;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aY\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"DarkFilledCell", "", "(Landroidx/compose/runtime/Composer;I)V", "EmptyCell", "FilledCell", "NumericRatingCell", "content", "", "modifier", "Landroidx/compose/ui/Modifier;", "strokeColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontColor", "NumericRatingCell-chV7uOw", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JFJLandroidx/compose/ui/text/font/FontWeight;JLandroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NumericRatingCell.kt */
public final class NumericRatingCellKt {
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f4  */
    /* renamed from: NumericRatingCell-chV7uOw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5341NumericRatingCellchV7uOw(java.lang.String r34, androidx.compose.ui.Modifier r35, long r36, float r38, long r39, androidx.compose.ui.text.font.FontWeight r41, long r42, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r7 = r34
            r2 = r45
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -657359647(0xffffffffd8d17ce1, float:-1.84267425E15)
            r1 = r44
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            r0 = r46 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r2 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r2 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r3.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r2
            goto L_0x0029
        L_0x0028:
            r0 = r2
        L_0x0029:
            r1 = r46 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r2 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r35
            boolean r5 = r3.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x003f
            r5 = 32
            goto L_0x0041
        L_0x003f:
            r5 = 16
        L_0x0041:
            r0 = r0 | r5
            goto L_0x0045
        L_0x0043:
            r4 = r35
        L_0x0045:
            r5 = r46 & 4
            if (r5 == 0) goto L_0x004e
            r0 = r0 | 384(0x180, float:5.38E-43)
            r8 = r36
            goto L_0x0060
        L_0x004e:
            r6 = r2 & 896(0x380, float:1.256E-42)
            r8 = r36
            if (r6 != 0) goto L_0x0060
            boolean r6 = r3.changed((long) r8)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r0 = r0 | r6
        L_0x0060:
            r6 = r46 & 8
            if (r6 == 0) goto L_0x0067
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r10 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x007a
            r10 = r38
            boolean r11 = r3.changed((float) r10)
            if (r11 == 0) goto L_0x0076
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r0 = r0 | r11
            goto L_0x007c
        L_0x007a:
            r10 = r38
        L_0x007c:
            r11 = r46 & 16
            if (r11 == 0) goto L_0x0083
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0083:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r2
            if (r12 != 0) goto L_0x0098
            r12 = r39
            boolean r14 = r3.changed((long) r12)
            if (r14 == 0) goto L_0x0094
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r0 = r0 | r14
            goto L_0x009a
        L_0x0098:
            r12 = r39
        L_0x009a:
            r14 = r46 & 32
            r20 = 458752(0x70000, float:6.42848E-40)
            if (r14 == 0) goto L_0x00a4
            r15 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r15
            goto L_0x00b8
        L_0x00a4:
            r15 = r2 & r20
            if (r15 != 0) goto L_0x00b8
            r15 = r41
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r0 = r0 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r41
        L_0x00ba:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r2 & r16
            if (r16 != 0) goto L_0x00d3
            r16 = r46 & 64
            r7 = r42
            if (r16 != 0) goto L_0x00cf
            boolean r9 = r3.changed((long) r7)
            if (r9 == 0) goto L_0x00cf
            r9 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r9 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r0 = r0 | r9
            goto L_0x00d5
        L_0x00d3:
            r7 = r42
        L_0x00d5:
            r9 = 2995931(0x2db6db, float:4.198194E-39)
            r9 = r9 & r0
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r9 != r4) goto L_0x00f4
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L_0x00e5
            goto L_0x00f4
        L_0x00e5:
            r3.skipToGroupEnd()
            r2 = r35
            r32 = r3
            r5 = r10
            r3 = r36
            r9 = r7
            r6 = r12
            r8 = r15
            goto L_0x02e5
        L_0x00f4:
            r3.startDefaults()
            r4 = r2 & 1
            r9 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r4 == 0) goto L_0x011b
            boolean r4 = r3.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0105
            goto L_0x011b
        L_0x0105:
            r3.skipToGroupEnd()
            r1 = r46 & 64
            if (r1 == 0) goto L_0x010d
            r0 = r0 & r9
        L_0x010d:
            r21 = r0
            r27 = r7
            r0 = r10
            r24 = r12
            r26 = r15
            r7 = r35
            r13 = r36
            goto L_0x0161
        L_0x011b:
            if (r1 == 0) goto L_0x0122
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0124
        L_0x0122:
            r1 = r35
        L_0x0124:
            if (r5 == 0) goto L_0x012d
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            long r4 = r4.m1958getBlack0d7_KjU()
            goto L_0x012f
        L_0x012d:
            r4 = r36
        L_0x012f:
            if (r6 == 0) goto L_0x0138
            r6 = 1
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            goto L_0x0139
        L_0x0138:
            r6 = r10
        L_0x0139:
            if (r11 == 0) goto L_0x0142
            androidx.compose.ui.graphics.Color$Companion r10 = androidx.compose.ui.graphics.Color.Companion
            long r10 = r10.m1969getWhite0d7_KjU()
            goto L_0x0143
        L_0x0142:
            r10 = r12
        L_0x0143:
            if (r14 == 0) goto L_0x014c
            androidx.compose.ui.text.font.FontWeight$Companion r12 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r12 = r12.getNormal()
            goto L_0x014d
        L_0x014c:
            r12 = r15
        L_0x014d:
            r13 = r46 & 64
            if (r13 == 0) goto L_0x0156
            long r7 = io.intercom.android.sdk.utilities.ColorExtensionsKt.m5396generateTextColor8_81llA(r10)
            r0 = r0 & r9
        L_0x0156:
            r21 = r0
            r13 = r4
            r0 = r6
            r27 = r7
            r24 = r10
            r26 = r12
            r7 = r1
        L_0x0161:
            r3.endDefaults()
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 8
            androidx.compose.material.Shapes r1 = r1.getShapes(r3, r4)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getMedium()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.foundation.shape.CornerSize r4 = androidx.compose.foundation.shape.CornerSizeKt.m840CornerSize0680j_4(r4)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.copy(r4)
            androidx.compose.foundation.BorderStroke r4 = androidx.compose.foundation.BorderStrokeKt.m191BorderStrokecXLIe8U(r0, r13)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.BorderKt.border(r7, r4, r1)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.ClipKt.clip(r4, r1)
            r4 = 0
            r5 = 2
            r6 = 0
            r35 = r1
            r36 = r24
            r38 = r4
            r39 = r5
            r40 = r6
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r35, r36, r38, r39, r40)
            r4 = 44
            float r4 = (float) r4
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m587width3ABfNKs(r1, r5)
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r4)
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r3, r5)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r9)
            java.lang.Object r6 = r3.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r9)
            java.lang.Object r10 = r3.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r9)
            java.lang.Object r8 = r3.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r11 = r3.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x0220
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0220:
            r3.startReusableNode()
            boolean r11 = r3.getInserting()
            if (r11 == 0) goto L_0x022d
            r3.createNode(r9)
            goto L_0x0230
        L_0x022d:
            r3.useNode()
        L_0x0230:
            r3.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r4, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r10, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r4)
            r3.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.invoke(r4, r3, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r3.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            androidx.compose.ui.Modifier r1 = r1.align(r4, r5)
            r4 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r29 = r13
            r13 = r15
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = r21 & 14
            int r4 = r21 >> 12
            r4 = r4 & 896(0x380, float:1.256E-42)
            r4 = r22 | r4
            r5 = r21 & r20
            r21 = r4 | r5
            r22 = 0
            r23 = 65496(0xffd8, float:9.178E-41)
            r31 = r0
            r0 = r34
            r32 = r3
            r2 = r27
            r33 = r7
            r7 = r26
            r20 = r32
            r4 = 0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r32.endReplaceableGroup()
            r32.endReplaceableGroup()
            r32.endNode()
            r32.endReplaceableGroup()
            r32.endReplaceableGroup()
            r6 = r24
            r8 = r26
            r9 = r27
            r3 = r29
            r5 = r31
            r2 = r33
        L_0x02e5:
            androidx.compose.runtime.ScopeUpdateScope r13 = r32.endRestartGroup()
            if (r13 != 0) goto L_0x02ec
            goto L_0x02fd
        L_0x02ec:
            io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingCellKt$NumericRatingCell$2 r14 = new io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingCellKt$NumericRatingCell$2
            r0 = r14
            r1 = r34
            r11 = r45
            r12 = r46
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x02fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.survey.ui.questiontype.numericscale.NumericRatingCellKt.m5341NumericRatingCellchV7uOw(java.lang.String, androidx.compose.ui.Modifier, long, float, long, androidx.compose.ui.text.font.FontWeight, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void EmptyCell(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1361614452);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            m5341NumericRatingCellchV7uOw("1", (Modifier) null, 0, 0.0f, 0, (FontWeight) null, 0, startRestartGroup, 6, 126);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingCellKt$EmptyCell$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void FilledCell(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1860651045);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            m5341NumericRatingCellchV7uOw("1", (Modifier) null, 0, 0.0f, Color.Companion.m1970getYellow0d7_KjU(), (FontWeight) null, 0, startRestartGroup, 24582, 110);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingCellKt$FilledCell$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void DarkFilledCell(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(477358395);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            m5341NumericRatingCellchV7uOw("1", (Modifier) null, 0, 0.0f, Color.Companion.m1958getBlack0d7_KjU(), (FontWeight) null, 0, startRestartGroup, 24582, 110);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NumericRatingCellKt$DarkFilledCell$1(i));
        }
    }
}
