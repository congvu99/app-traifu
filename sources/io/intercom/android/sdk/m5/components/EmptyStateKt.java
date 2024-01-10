package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aN\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"EmptyState", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "description", "iconId", "", "bottomContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "EmptyStatePreview", "(Landroidx/compose/runtime/Composer;I)V", "EmptyStateWithOutlinedButtonPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EmptyState.kt */
public final class EmptyStateKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void EmptyState(java.lang.String r31, androidx.compose.ui.Modifier r32, java.lang.String r33, java.lang.Integer r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r0 = r31
            r15 = r37
            java.lang.String r1 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 1094399996(0x413b37fc, float:11.701168)
            r2 = r36
            androidx.compose.runtime.Composer r13 = r2.startRestartGroup(r1)
            r1 = r38 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r15 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r15 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r13.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r15
            goto L_0x0029
        L_0x0028:
            r1 = r15
        L_0x0029:
            r2 = r38 & 2
            r3 = 32
            r14 = 16
            if (r2 == 0) goto L_0x0034
            r1 = r1 | 48
            goto L_0x0047
        L_0x0034:
            r4 = r15 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0047
            r4 = r32
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0043
            r5 = 32
            goto L_0x0045
        L_0x0043:
            r5 = 16
        L_0x0045:
            r1 = r1 | r5
            goto L_0x0049
        L_0x0047:
            r4 = r32
        L_0x0049:
            r5 = r38 & 4
            if (r5 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r15 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r33
            boolean r7 = r13.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r33
        L_0x0065:
            r7 = r38 & 8
            if (r7 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007f
            r8 = r34
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r34
        L_0x0081:
            r9 = r38 & 16
            if (r9 == 0) goto L_0x0088
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x0088:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r15
            if (r10 != 0) goto L_0x009d
            r10 = r35
            boolean r11 = r13.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0099
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r1 = r1 | r11
            goto L_0x009f
        L_0x009d:
            r10 = r35
        L_0x009f:
            r20 = r1
            r1 = 46811(0xb6db, float:6.5596E-41)
            r1 = r20 & r1
            r11 = 9362(0x2492, float:1.3119E-41)
            if (r1 != r11) goto L_0x00bb
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x00b1
            goto L_0x00bb
        L_0x00b1:
            r13.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r10
            r1 = r13
            goto L_0x0309
        L_0x00bb:
            if (r2 == 0) goto L_0x00c3
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r12 = r1
            goto L_0x00c4
        L_0x00c3:
            r12 = r4
        L_0x00c4:
            r1 = 0
            if (r5 == 0) goto L_0x00ca
            r26 = r1
            goto L_0x00cc
        L_0x00ca:
            r26 = r6
        L_0x00cc:
            if (r7 == 0) goto L_0x00d1
            r27 = r1
            goto L_0x00d3
        L_0x00d1:
            r27 = r8
        L_0x00d3:
            if (r9 == 0) goto L_0x00d7
            r11 = r1
            goto L_0x00d8
        L_0x00d7:
            r11 = r10
        L_0x00d8:
            r2 = 24
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m510padding3ABfNKs(r12, r2)
            r4 = 0
            r5 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r4, r5, r1)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r2 = r2.getCenterHorizontally()
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r4 = r4.getCenter()
            r5 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r13.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r5)
            androidx.compose.foundation.layout.Arrangement$Vertical r4 = (androidx.compose.foundation.layout.Arrangement.Vertical) r4
            r5 = 54
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r2, r13, r5)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r4 = r13.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r5 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x0163
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0163:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x0170
            r13.createNode(r6)
            goto L_0x0173
        L_0x0170:
            r13.useNode()
        L_0x0173:
            r13.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r4, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            r13.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r10 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r1.invoke(r2, r13, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r1 = -1702546892(0xffffffff9a853234, float:-5.508862E-23)
            r13.startReplaceableGroup(r1)
            r1 = 6
            r9 = 8
            if (r27 != 0) goto L_0x01d4
            r15 = 8
            goto L_0x0218
        L_0x01d4:
            r2 = r27
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            androidx.compose.ui.graphics.painter.Painter r2 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r2, r13, r10)
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r4 = r4.getColors(r13, r9)
            long r5 = r4.m1213getOnSurface0d7_KjU()
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r4, r3)
            r3 = 0
            r8 = 440(0x1b8, float:6.17E-43)
            r16 = 0
            r7 = r13
            r15 = 8
            r9 = r16
            androidx.compose.material.IconKt.m1313Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r2, (java.lang.String) r3, (androidx.compose.ui.Modifier) r4, (long) r5, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            float r3 = (float) r14
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r2, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r13, r1)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0218:
            r13.endReplaceableGroup()
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r2 = r2.getTypography(r13, r15)
            androidx.compose.ui.text.TextStyle r19 = r2.getH6()
            androidx.compose.ui.text.style.TextAlign$Companion r2 = androidx.compose.ui.text.style.TextAlign.Companion
            int r16 = r2.m4554getCentere0LSkKk()
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r13, r15)
            long r2 = r2.m1213getOnSurface0d7_KjU()
            r4 = 0
            r9 = 6
            r1 = r4
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r17 = 0
            r28 = 0
            r9 = r17
            r17 = 0
            r29 = r11
            r11 = r17
            androidx.compose.ui.text.style.TextAlign r16 = androidx.compose.ui.text.style.TextAlign.m4547boximpl(r16)
            r30 = r12
            r12 = r16
            r16 = 0
            r32 = r13
            r13 = r16
            r16 = 0
            r15 = r16
            r17 = 0
            r18 = 0
            r21 = r20 & 14
            r22 = 0
            r23 = 32250(0x7dfa, float:4.5192E-41)
            r0 = r31
            r20 = r32
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = -1702546379(0xffffffff9a853435, float:-5.5091856E-23)
            r1 = r32
            r1.startReplaceableGroup(r0)
            if (r26 != 0) goto L_0x0278
            r0 = 6
            goto L_0x02ce
        L_0x0278:
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r2 = 6
            float r3 = (float) r2
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r0, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r0, r1, r2)
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 8
            androidx.compose.material.Typography r0 = r0.getTypography(r1, r3)
            androidx.compose.ui.text.TextStyle r21 = r0.getBody1()
            androidx.compose.ui.text.style.TextAlign$Companion r0 = androidx.compose.ui.text.style.TextAlign.Companion
            int r0 = r0.m4554getCentere0LSkKk()
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r3 = r4.getColors(r1, r3)
            long r4 = r3.m1213getOnSurface0d7_KjU()
            r3 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            androidx.compose.ui.text.style.TextAlign r14 = androidx.compose.ui.text.style.TextAlign.m4547boximpl(r0)
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r23 = 0
            r24 = 0
            r25 = 32250(0x7dfa, float:4.5192E-41)
            r0 = 6
            r2 = r26
            r22 = r1
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r2, r3, r4, r6, r8, r9, r10, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x02ce:
            r1.endReplaceableGroup()
            r10 = r29
            if (r10 != 0) goto L_0x02d6
            goto L_0x02f3
        L_0x02d6:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r3 = 16
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r2, r3)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r1, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r28)
            r10.invoke(r1, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x02f3:
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            r1.endReplaceableGroup()
            r5 = r10
            r3 = r26
            r4 = r27
            r2 = r30
        L_0x0309:
            androidx.compose.runtime.ScopeUpdateScope r8 = r1.endRestartGroup()
            if (r8 != 0) goto L_0x0310
            goto L_0x0321
        L_0x0310:
            io.intercom.android.sdk.m5.components.EmptyStateKt$EmptyState$2 r9 = new io.intercom.android.sdk.m5.components.EmptyStateKt$EmptyState$2
            r0 = r9
            r1 = r31
            r6 = r37
            r7 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0321:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.EmptyStateKt.EmptyState(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void EmptyStatePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(1885515198);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$EmptyStateKt.INSTANCE.m5149getLambda3$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmptyStateKt$EmptyStatePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void EmptyStateWithOutlinedButtonPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-484307592);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$EmptyStateKt.INSTANCE.m5152getLambda6$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmptyStateKt$EmptyStateWithOutlinedButtonPreview$1(i));
        }
    }
}
