package io.intercom.android.sdk.m5.components;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ac\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0001¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"HomeItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "text", "textString", "", "subtitle", "messagesUnread", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "HomeMessagesPreview", "(Landroidx/compose/runtime/Composer;I)V", "HomeSendMessagePreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeItem.kt */
public final class HomeItemKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x04f7  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void HomeItem(androidx.compose.ui.Modifier r38, java.lang.Integer r39, java.lang.Integer r40, java.lang.String r41, java.lang.String r42, java.lang.Integer r43, kotlin.jvm.functions.Function0<kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47) {
        /*
            r8 = r46
            r0 = -722258190(0xffffffffd4f336f2, float:-8.3567911E12)
            r1 = r45
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r47 & 1
            if (r1 == 0) goto L_0x0015
            r3 = r8 | 6
            r4 = r3
            r3 = r38
            goto L_0x0029
        L_0x0015:
            r3 = r8 & 14
            if (r3 != 0) goto L_0x0026
            r3 = r38
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0023
            r4 = 4
            goto L_0x0024
        L_0x0023:
            r4 = 2
        L_0x0024:
            r4 = r4 | r8
            goto L_0x0029
        L_0x0026:
            r3 = r38
            r4 = r8
        L_0x0029:
            r5 = r47 & 2
            if (r5 == 0) goto L_0x0030
            r4 = r4 | 48
            goto L_0x0043
        L_0x0030:
            r7 = r8 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0043
            r7 = r39
            boolean r9 = r0.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x003f
            r9 = 32
            goto L_0x0041
        L_0x003f:
            r9 = 16
        L_0x0041:
            r4 = r4 | r9
            goto L_0x0045
        L_0x0043:
            r7 = r39
        L_0x0045:
            r9 = r47 & 4
            if (r9 == 0) goto L_0x004c
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r10 = r8 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x005f
            r10 = r40
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x005b
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r4 = r4 | r11
            goto L_0x0061
        L_0x005f:
            r10 = r40
        L_0x0061:
            r11 = r47 & 8
            if (r11 == 0) goto L_0x0068
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r12 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x007b
            r12 = r41
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0077
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r4 = r4 | r13
            goto L_0x007d
        L_0x007b:
            r12 = r41
        L_0x007d:
            r13 = r47 & 16
            if (r13 == 0) goto L_0x0084
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r8
            if (r14 != 0) goto L_0x0099
            r14 = r42
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x0095
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r15
            goto L_0x009b
        L_0x0099:
            r14 = r42
        L_0x009b:
            r15 = r47 & 32
            if (r15 == 0) goto L_0x00a6
            r16 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r16
            r2 = r43
            goto L_0x00bb
        L_0x00a6:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r8 & r16
            r2 = r43
            if (r16 != 0) goto L_0x00bb
            boolean r16 = r0.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r4 = r4 | r16
        L_0x00bb:
            r16 = r47 & 64
            if (r16 == 0) goto L_0x00c6
            r17 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r17
            r6 = r44
            goto L_0x00db
        L_0x00c6:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r8 & r17
            r6 = r44
            if (r17 != 0) goto L_0x00db
            boolean r18 = r0.changed((java.lang.Object) r6)
            if (r18 == 0) goto L_0x00d7
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r4 = r4 | r18
        L_0x00db:
            r18 = 2995931(0x2db6db, float:4.198194E-39)
            r2 = r4 & r18
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00ec
            goto L_0x00fa
        L_0x00ec:
            r0.skipToGroupEnd()
            r1 = r38
            r2 = r7
            r3 = r10
            r4 = r12
            r5 = r14
            r7 = r6
            r6 = r43
            goto L_0x04f0
        L_0x00fa:
            if (r1 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0103
        L_0x0101:
            r1 = r38
        L_0x0103:
            r2 = 0
            if (r5 == 0) goto L_0x0107
            r7 = r2
        L_0x0107:
            if (r9 == 0) goto L_0x010b
            r3 = r2
            goto L_0x010c
        L_0x010b:
            r3 = r10
        L_0x010c:
            if (r11 == 0) goto L_0x0110
            r5 = r2
            goto L_0x0111
        L_0x0110:
            r5 = r12
        L_0x0111:
            if (r13 == 0) goto L_0x0116
            r33 = r2
            goto L_0x0118
        L_0x0116:
            r33 = r14
        L_0x0118:
            if (r15 == 0) goto L_0x011d
            r34 = r2
            goto L_0x011f
        L_0x011d:
            r34 = r43
        L_0x011f:
            if (r16 == 0) goto L_0x0125
            io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$1 r6 = io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$1.INSTANCE
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
        L_0x0125:
            r9 = 0
            r10 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r9, r10, r2)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            boolean r12 = r0.changed((java.lang.Object) r6)
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x014b
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0156
        L_0x014b:
            io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$2$1 r12 = new io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$2$1
            r12.<init>(r6)
            r13 = r12
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            r0.updateRememberedValue(r13)
        L_0x0156:
            r0.endReplaceableGroup()
            r12 = r13
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r13 = 7
            r14 = 0
            r38 = r2
            r39 = r9
            r40 = r10
            r41 = r11
            r42 = r12
            r43 = r13
            r44 = r14
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r38, r39, r40, r41, r42, r43, r44)
            r9 = 16
            float r9 = (float) r9
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            r11 = 12
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m511paddingVpY3zN4(r2, r10, r11)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r10 = r10.getCenterVertically()
            r11 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r11 = r11.getStart()
            r12 = 48
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r11, r10, r0, r12)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            java.lang.String r12 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r11 = r16
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r35 = r1
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r36 = r6
            androidx.compose.runtime.Applier r6 = r0.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0202
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0202:
            r0.startReusableNode()
            boolean r6 = r0.getInserting()
            if (r6 == 0) goto L_0x020f
            r0.createNode(r14)
            goto L_0x0212
        L_0x020f:
            r0.useNode()
        L_0x0212:
            r0.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r10, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r13, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r11, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r1, r10)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r6 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)
            r2.invoke(r1, r0, r10)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C80@4021L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r2 = (androidx.compose.foundation.layout.RowScope) r2
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            r17 = r10
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            r18 = 1073741824(0x40000000, float:2.0)
            r19 = 0
            r20 = 2
            r21 = 0
            r16 = r2
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r16, r17, r18, r19, r20, r21)
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            r13 = 4
            float r13 = (float) r13
            float r13 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r13)
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r11 = r11.m407spacedBy0680j_4(r13)
            androidx.compose.foundation.layout.Arrangement$Vertical r11 = (androidx.compose.foundation.layout.Arrangement.Vertical) r11
            r13 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r13)
            java.lang.String r13 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r13)
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r13 = r13.getStart()
            r14 = 6
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r11, r13, r0, r14)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x02f8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02f8:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x0305
            r0.createNode(r13)
            goto L_0x0308
        L_0x0305:
            r0.useNode()
        L_0x0308:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r11, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r12, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r1, r11)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r10.invoke(r1, r0, r6)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r1 = -1014323086(0xffffffffc38aa872, float:-277.31598)
            r0.startReplaceableGroup(r1)
            if (r3 == 0) goto L_0x036f
            int r1 = r3.intValue()
            int r6 = r4 >> 6
            r6 = r6 & 14
            java.lang.String r1 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r0, r6)
            goto L_0x0375
        L_0x036f:
            if (r5 != 0) goto L_0x0374
            java.lang.String r1 = ""
            goto L_0x0375
        L_0x0374:
            r1 = r5
        L_0x0375:
            r0.endReplaceableGroup()
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r15 = 8
            androidx.compose.material.Typography r6 = r6.getTypography(r0, r15)
            androidx.compose.ui.text.TextStyle r28 = r6.getSubtitle1()
            androidx.compose.ui.text.font.FontWeight$Companion r6 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r16 = r6.getSemiBold()
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r24 = r6.m4591getEllipsisgIe3tQ8()
            r10 = 0
            r11 = 0
            r13 = 0
            r6 = 6
            r17 = 0
            r6 = 8
            r15 = r17
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 2
            r27 = 0
            r30 = 196608(0x30000, float:2.75506E-40)
            r31 = 3120(0xc30, float:4.372E-42)
            r32 = 22494(0x57de, float:3.1521E-41)
            r37 = r9
            r9 = r1
            r29 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r9, r10, r11, r13, r15, r16, r17, r18, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r1 = -249299733(0xfffffffff123fceb, float:-8.1202905E29)
            r0.startReplaceableGroup(r1)
            if (r33 == 0) goto L_0x03fe
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r1 = r1.getTypography(r0, r6)
            androidx.compose.ui.text.TextStyle r28 = r1.getSubtitle1()
            r9 = 4285887861(0xff757575, double:2.117509954E-314)
            long r11 = androidx.compose.ui.graphics.ColorKt.Color((long) r9)
            r10 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            int r1 = r4 >> 12
            r1 = r1 & 14
            r1 = r1 | 384(0x180, float:5.38E-43)
            r30 = r1
            r31 = 0
            r32 = 32762(0x7ffa, float:4.591E-41)
            r9 = r33
            r29 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r9, r10, r11, r13, r15, r16, r17, r18, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
        L_0x03fe:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            if (r34 == 0) goto L_0x048e
            int r1 = r34.intValue()
            if (r1 <= 0) goto L_0x048e
            r1 = -249299440(0xfffffffff123fe10, float:-8.120512E29)
            r0.startReplaceableGroup(r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r4 = 0
            r6 = 0
            r9 = 6
            float r9 = (float) r9
            float r9 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r9)
            r10 = 0
            r11 = 11
            r12 = 0
            r39 = r1
            r40 = r4
            r41 = r6
            r42 = r9
            r43 = r10
            r44 = r11
            r45 = r12
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r39, r40, r41, r42, r43, r44, r45)
            io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$3$2 r4 = io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$3$2.INSTANCE
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r1, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r4 = r4.getCenterVertically()
            androidx.compose.ui.Modifier r10 = r2.align(r1, r4)
            java.lang.String r9 = java.lang.String.valueOf(r34)
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r11 = r1.m1969getWhite0d7_KjU()
            r1 = 11
            long r13 = androidx.compose.ui.unit.TextUnitKt.getSp((int) r1)
            androidx.compose.ui.text.font.FontWeight$Companion r1 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r16 = r1.getW800()
            r15 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 200064(0x30d80, float:2.8035E-40)
            r31 = 0
            r32 = 65488(0xffd0, float:9.1768E-41)
            r29 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r9, r10, r11, r13, r15, r16, r17, r18, r20, r21, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            r0.endReplaceableGroup()
            goto L_0x04d7
        L_0x048e:
            r1 = -249298886(0xfffffffff124003a, float:-8.1209305E29)
            r0.startReplaceableGroup(r1)
            if (r7 != 0) goto L_0x0497
            goto L_0x04d4
        L_0x0497:
            r1 = r7
            java.lang.Number r1 = (java.lang.Number) r1
            r1.intValue()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r2 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r37)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r1, r2)
            int r2 = r7.intValue()
            int r4 = r4 >> 3
            r4 = r4 & 14
            androidx.compose.ui.graphics.painter.Painter r2 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r2, r0, r4)
            io.intercom.android.sdk.m5.IntercomTheme r4 = io.intercom.android.sdk.m5.IntercomTheme.INSTANCE
            long r9 = r4.m5118getColorOnWhite0d7_KjU$intercom_sdk_base_release()
            r4 = 0
            r6 = 440(0x1b8, float:6.17E-43)
            r11 = 0
            r38 = r2
            r39 = r4
            r40 = r1
            r41 = r9
            r43 = r0
            r44 = r6
            r45 = r11
            androidx.compose.material.IconKt.m1313Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r38, (java.lang.String) r39, (androidx.compose.ui.Modifier) r40, (long) r41, (androidx.compose.runtime.Composer) r43, (int) r44, (int) r45)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x04d4:
            r0.endReplaceableGroup()
        L_0x04d7:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r4 = r5
            r2 = r7
            r5 = r33
            r6 = r34
            r1 = r35
            r7 = r36
        L_0x04f0:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x04f7
            goto L_0x0506
        L_0x04f7:
            io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$4 r11 = new io.intercom.android.sdk.m5.components.HomeItemKt$HomeItem$4
            r0 = r11
            r8 = r46
            r9 = r47
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0506:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.components.HomeItemKt.HomeItem(androidx.compose.ui.Modifier, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void HomeSendMessagePreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(861055120);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeItemKt.INSTANCE.m5153getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeItemKt$HomeSendMessagePreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void HomeMessagesPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1318695433);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeItemKt.INSTANCE.m5154getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeItemKt$HomeMessagesPreview$1(i));
        }
    }
}
