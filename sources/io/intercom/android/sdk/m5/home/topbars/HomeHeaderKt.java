package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnitKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"HomeHeader", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "topPadding", "Landroidx/compose/ui/unit/Dp;", "onCloseClick", "Lkotlin/Function0;", "HomeHeader-942rkJo", "(Landroidx/compose/ui/Modifier;Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;FLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "HomeReducedHeaderPreview", "(Landroidx/compose/runtime/Composer;I)V", "HomeTopBarPreview", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeader.kt */
public final class HomeHeaderKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: HomeHeader-942rkJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5233HomeHeader942rkJo(androidx.compose.ui.Modifier r67, io.intercom.android.sdk.m5.home.viewmodel.HeaderState r68, float r69, kotlin.jvm.functions.Function0<kotlin.Unit> r70, androidx.compose.runtime.Composer r71, int r72, int r73) {
        /*
            r2 = r68
            r10 = r69
            r11 = r70
            r12 = r72
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onCloseClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -2140210181(0xffffffff806efbfb, float:-1.0192298E-38)
            r1 = r71
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r73 & 1
            r13 = 2
            if (r1 == 0) goto L_0x0026
            r3 = r12 | 6
            r4 = r3
            r3 = r67
            goto L_0x003a
        L_0x0026:
            r3 = r12 & 14
            if (r3 != 0) goto L_0x0037
            r3 = r67
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0034
            r4 = 4
            goto L_0x0035
        L_0x0034:
            r4 = 2
        L_0x0035:
            r4 = r4 | r12
            goto L_0x003a
        L_0x0037:
            r3 = r67
            r4 = r12
        L_0x003a:
            r5 = r73 & 2
            if (r5 == 0) goto L_0x0041
            r4 = r4 | 48
            goto L_0x0051
        L_0x0041:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0051
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x004e
            r5 = 32
            goto L_0x0050
        L_0x004e:
            r5 = 16
        L_0x0050:
            r4 = r4 | r5
        L_0x0051:
            r5 = r73 & 4
            if (r5 == 0) goto L_0x0058
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r5 = r12 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0068
            boolean r5 = r0.changed((float) r10)
            if (r5 == 0) goto L_0x0065
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r4 = r4 | r5
        L_0x0068:
            r5 = r73 & 8
            if (r5 == 0) goto L_0x006f
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006f:
            r5 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007f
            boolean r5 = r0.changed((java.lang.Object) r11)
            if (r5 == 0) goto L_0x007c
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r4 = r4 | r5
        L_0x007f:
            r4 = r4 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r4 != r5) goto L_0x0093
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x008c
            goto L_0x0093
        L_0x008c:
            r0.skipToGroupEnd()
            r1 = r3
            r7 = r11
            goto L_0x08d8
        L_0x0093:
            if (r1 == 0) goto L_0x009a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x009b
        L_0x009a:
            r1 = r3
        L_0x009b:
            boolean r3 = r2 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.NoHeader
            if (r3 == 0) goto L_0x00c5
            r3 = 1708457982(0x65d4fffe, float:1.2573299E23)
            r0.startReplaceableGroup(r3)
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x00af
            goto L_0x00c4
        L_0x00af:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$1 r8 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$1
            r0 = r8
            r2 = r68
            r3 = r69
            r4 = r70
            r5 = r72
            r6 = r73
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x00c4:
            return
        L_0x00c5:
            boolean r3 = r2 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Expanded
            java.lang.String r9 = "C80@4021L9:Row.kt#2w3rfo"
            java.lang.String r7 = "C(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo"
            java.lang.String r15 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            r8 = 8
            r6 = 0
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            if (r3 == 0) goto L_0x0585
            r3 = 1708458062(0x65d5004e, float:1.2573371E23)
            r0.startReplaceableGroup(r3)
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r3 = r3.getTypography(r0, r8)
            androidx.compose.ui.text.TextStyle r27 = r3.getH4()
            r28 = 0
            r30 = 0
            androidx.compose.ui.text.font.FontWeight$Companion r3 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r32 = r3.getW700()
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r50 = 0
            r51 = 262139(0x3fffb, float:3.67335E-40)
            r52 = 0
            androidx.compose.ui.text.TextStyle r3 = androidx.compose.ui.text.TextStyle.m4228copyHL5avdY$default(r27, r28, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r44, r45, r46, r47, r48, r50, r51, r52)
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r8)
            java.lang.String r14 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r4 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r17.getEmpty()
            if (r4 != r8) goto L_0x0133
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r6, r13, r6)
            r0.updateRememberedValue(r4)
        L_0x0133:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r8 != r14) goto L_0x0159
            r14 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r14)
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r6, r13, r6)
            r0.updateRememberedValue(r8)
        L_0x0159:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            r14 = 0
            r6 = 10
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            float r6 = r6 + r10
            float r17 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            r18 = 0
            r6 = 16
            float r6 = (float) r6
            float r19 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            r20 = 5
            r21 = 0
            r53 = r15
            r15 = r1
            r16 = r14
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r15, r16, r17, r18, r19, r20, r21)
            r15 = 24
            float r15 = (float) r15
            float r10 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r15)
            r16 = r15
            r12 = 0
            r15 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r14, r10, r12, r13, r15)
            r12 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r12 = r12.getTop()
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r13 = r13.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r12, r13, r0, r14)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            r15 = r53
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r5)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r11 = r17
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r5)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r37 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r5)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            r30 = r3
            androidx.compose.runtime.Applier r3 = r0.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x020d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x020d:
            r0.startReusableNode()
            boolean r3 = r0.getInserting()
            if (r3 == 0) goto L_0x021a
            r0.createNode(r14)
            goto L_0x021d
        L_0x021a:
            r0.useNode()
        L_0x021d:
            r0.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r12, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r13, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r11, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r3, r1, r11)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r3 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
            r10.invoke(r1, r0, r11)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r3 = 0
            r10 = 1
            r11 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r3, r10, r11)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getCenterVertically()
            r10 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            r10 = 48
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r3, r0, r10)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r11 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x02ed
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02ed:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x02fa
            r0.createNode(r13)
            goto L_0x02fd
        L_0x02fa:
            r0.useNode()
        L_0x02fd:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r7, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r12, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r11, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            r7 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
            r1.invoke(r3, r0, r11)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r12 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            r3 = 1144095885(0x4431848d, float:710.0711)
            r0.startReplaceableGroup(r3)
            r3 = r2
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderContent$Expanded r3 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Expanded) r3
            boolean r7 = r3.getShowLogo()
            if (r7 == 0) goto L_0x0403
            coil.request.ImageRequest$Builder r7 = new coil.request.ImageRequest$Builder
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r9 = (android.content.Context) r9
            r7.<init>((android.content.Context) r9)
            java.lang.String r9 = r3.getLogoUrl()
            coil.request.ImageRequest$Builder r7 = r7.data(r9)
            r9 = 1
            coil.request.ImageRequest$Builder r7 = r7.crossfade((boolean) r9)
            coil.request.ImageRequest r13 = r7.build()
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r11, r5)
            java.lang.Object r5 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r5 = (android.content.Context) r5
            coil.ImageLoader r14 = io.intercom.android.sdk.utilities.IntercomCoilKt.getImageLoader(r5)
            r15 = 0
            r5 = 0
            r17 = 0
            r18 = 0
            r20 = 72
            r21 = 60
            r7 = r16
            r16 = r5
            r19 = r0
            coil.compose.AsyncImagePainter r5 = coil.compose.AsyncImagePainterKt.m4998rememberAsyncImagePainter5jETZwI(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.ui.layout.ContentScale$Companion r9 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r9 = r9.getFillHeight()
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r16 = r11.getCenterStart()
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            r18 = r11
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 2
            r22 = 0
            r17 = r1
            androidx.compose.ui.Modifier r38 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r17, r18, r19, r20, r21, r22)
            r39 = 0
            r40 = 0
            float r41 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            r42 = 0
            r43 = 11
            r44 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r38, r39, r40, r41, r42, r43, r44)
            r11 = 32
            float r11 = (float) r11
            float r11 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r11)
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r6, r11)
            r13 = r5
            androidx.compose.ui.graphics.painter.Painter r13 = (androidx.compose.ui.graphics.painter.Painter) r13
            r14 = 0
            r18 = 0
            r19 = 0
            r21 = 27696(0x6c30, float:3.881E-41)
            r22 = 96
            r17 = r9
            r20 = r0
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r13, (java.lang.String) r14, (androidx.compose.ui.Modifier) r15, (androidx.compose.ui.Alignment) r16, (androidx.compose.ui.layout.ContentScale) r17, (float) r18, (androidx.compose.ui.graphics.ColorFilter) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            goto L_0x0405
        L_0x0403:
            r7 = r16
        L_0x0405:
            r0.endReplaceableGroup()
            r5 = 1144096804(0x44318824, float:710.1272)
            r0.startReplaceableGroup(r5)
            boolean r5 = r3.getShowAvatars()
            if (r5 == 0) goto L_0x0425
            java.util.List r13 = r3.getAdminsAvatars()
            r14 = 0
            r15 = 0
            r16 = 0
            r19 = 8
            r20 = 14
            r18 = r0
            io.intercom.android.sdk.m5.components.AvatarGroupKt.m5121AvatarGroupJ8mCjc(r13, r14, r15, r16, r18, r19, r20)
        L_0x0425:
            r0.endReplaceableGroup()
            r5 = 1144096928(0x443188a0, float:710.13477)
            r0.startReplaceableGroup(r5)
            boolean r3 = r3.getShowLogo()
            if (r3 != 0) goto L_0x044c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r18 = r3
            androidx.compose.ui.Modifier r18 = (androidx.compose.ui.Modifier) r18
            r19 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            r21 = 2
            r22 = 0
            r17 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r17, r18, r19, r20, r21, r22)
            r6 = 0
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r6)
        L_0x044c:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r1, r3)
            r3 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            float r5 = (float) r10
            float r5 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r5)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r1, r5)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r0, r3)
            r1 = 801971760(0x2fcd1e30, float:3.7310732E-10)
            r0.startReplaceableGroup(r1)
            r1 = r2
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderContent$Expanded r1 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Expanded) r1
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$ColoredText r3 = r1.getGreeting()
            java.lang.String r5 = r3.getText()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            r6 = 1
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x04f7
            java.lang.String r14 = r3.getText()
            java.lang.Object r5 = r4.getValue()
            r17 = r5
            androidx.compose.ui.text.TextStyle r17 = (androidx.compose.ui.text.TextStyle) r17
            java.lang.String r5 = r3.getColor()
            float r3 = r3.getOpacity()
            long r15 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor(r5, r3)
            r13 = 0
            r3 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            boolean r3 = r0.changed((java.lang.Object) r8)
            boolean r5 = r0.changed((java.lang.Object) r4)
            r3 = r3 | r5
            r5 = r30
            boolean r6 = r0.changed((java.lang.Object) r5)
            r3 = r3 | r6
            java.lang.Object r6 = r0.rememberedValue()
            if (r3 != 0) goto L_0x04db
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r6 != r3) goto L_0x04e6
        L_0x04db:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$2$2$1$1 r3 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$2$2$1$1
            r3.<init>(r8, r4, r5)
            r6 = r3
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.updateRememberedValue(r6)
        L_0x04e6:
            r0.endReplaceableGroup()
            r18 = r6
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r20 = 0
            r21 = 1
            r19 = r0
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt.m5217WrapReportingTextT042LqI(r13, r14, r15, r17, r18, r19, r20, r21)
            goto L_0x04f9
        L_0x04f7:
            r5 = r30
        L_0x04f9:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r0.endReplaceableGroup()
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$ColoredText r1 = r1.getIntro()
            java.lang.String r3 = r1.getText()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r6 = 1
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x056b
            java.lang.String r14 = r1.getText()
            java.lang.Object r3 = r4.getValue()
            r17 = r3
            androidx.compose.ui.text.TextStyle r17 = (androidx.compose.ui.text.TextStyle) r17
            java.lang.String r3 = r1.getColor()
            float r1 = r1.getOpacity()
            long r15 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor(r3, r1)
            r13 = 0
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            boolean r1 = r0.changed((java.lang.Object) r8)
            boolean r3 = r0.changed((java.lang.Object) r4)
            r1 = r1 | r3
            boolean r3 = r0.changed((java.lang.Object) r5)
            r1 = r1 | r3
            java.lang.Object r3 = r0.rememberedValue()
            if (r1 != 0) goto L_0x0550
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x055b
        L_0x0550:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$2$3$1$1 r1 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$2$3$1$1
            r1.<init>(r8, r4, r5)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0.updateRememberedValue(r3)
        L_0x055b:
            r0.endReplaceableGroup()
            r18 = r3
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r20 = 0
            r21 = 1
            r19 = r0
            io.intercom.android.sdk.m5.home.components.WrapReportingTextKt.m5217WrapReportingTextT042LqI(r13, r14, r15, r17, r18, r19, r20, r21)
        L_0x056b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r7 = r70
            r5 = r37
            goto L_0x08d7
        L_0x0585:
            r37 = r1
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r6 = 0
            r10 = 693286680(0x2952b718, float:4.6788176E-14)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r12 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            boolean r3 = r2 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Reduced
            if (r3 == 0) goto L_0x08ca
            r3 = 1708461511(0x65d50dc7, float:1.2576478E23)
            r0.startReplaceableGroup(r3)
            r14 = r37
            r1 = 0
            r3 = 1
            r4 = 0
            androidx.compose.ui.Modifier r17 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r14, r4, r3, r1)
            r37 = r2
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderContent$Reduced r37 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Reduced) r37
            java.lang.String r6 = r37.getBackgroundColor()
            long r18 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r6, r4, r3, r1)
            r20 = 0
            r21 = 2
            r22 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BackgroundKt.m177backgroundbw27NRU$default(r17, r18, r20, r21, r22)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 13
            r21 = 0
            r22 = 1
            r3 = r6
            r67 = 0
            r1 = 1
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r22 = 0
            r4 = r17
            r12 = r5
            r11 = 0
            r5 = r69
            r1 = 0
            r6 = r18
            r54 = r7
            r7 = r19
            r8 = r20
            r57 = r9
            r9 = r21
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r3, r4, r5, r6, r7, r8, r9)
            r4 = 16
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r3, r4, r11, r13, r1)
            r4 = 56
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r3, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r4 = r4.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            r0.startReplaceableGroup(r10)
            r6 = r54
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            r6 = 54
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r4, r0, r6)
            r5 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x0670
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0670:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x067d
            r0.createNode(r9)
            goto L_0x0680
        L_0x067d:
            r0.useNode()
        L_0x0680:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r4, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r7, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r4)
            r0.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r67)
            r3.invoke(r4, r0, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            r3 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r3)
            r3 = r57
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.foundation.layout.RowScopeInstance r3 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r16 = r3
            androidx.compose.foundation.layout.RowScope r16 = (androidx.compose.foundation.layout.RowScope) r16
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r17 = r3
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            r20 = 2
            r21 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r16, r17, r18, r19, r20, r21)
            r23 = 0
            r24 = 0
            r3 = 8
            float r4 = (float) r3
            float r25 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            r26 = 0
            r27 = 11
            r28 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            r5 = r14
            r14 = r4
            java.lang.String r13 = r37.getGreeting()
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Typography r3 = r4.getTypography(r0, r3)
            androidx.compose.ui.text.TextStyle r41 = r3.getSubtitle1()
            r42 = 0
            r44 = 0
            androidx.compose.ui.text.font.FontWeight$Companion r3 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r46 = r3.getSemiBold()
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r64 = 0
            r65 = 262139(0x3fffb, float:3.67335E-40)
            r66 = 0
            androidx.compose.ui.text.TextStyle r32 = androidx.compose.ui.text.TextStyle.m4228copyHL5avdY$default(r41, r42, r44, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56, r58, r59, r60, r61, r62, r64, r65, r66)
            java.lang.String r3 = r37.getForegroundColor()
            r4 = 1
            long r7 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r3, r11, r4, r1)
            r3 = r15
            r15 = r7
            r17 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r34 = 0
            r35 = 0
            r36 = 32760(0x7ff8, float:4.5907E-41)
            r33 = r0
            androidx.compose.material.TextKt.m1496TextfLXpl1I(r13, r14, r15, r17, r19, r20, r21, r22, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            java.lang.String r4 = r37.getForegroundColor()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r13 = r7
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            r14 = 0
            r15 = 0
            r16 = 0
            r7 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            r7 = r70
            boolean r8 = r0.changed((java.lang.Object) r7)
            java.lang.Object r9 = r0.rememberedValue()
            if (r8 != 0) goto L_0x0794
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r9 != r8) goto L_0x079f
        L_0x0794:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$3$1$1$1 r8 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$3$1$1$1
            r8.<init>(r7)
            r9 = r8
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r0.updateRememberedValue(r9)
        L_0x079f:
            r0.endReplaceableGroup()
            r17 = r9
            kotlin.jvm.functions.Function0 r17 = (kotlin.jvm.functions.Function0) r17
            r18 = 7
            r19 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r13, r14, r15, r16, r17, r18, r19)
            r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r9 = r9.getTopStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r9, r10, r0, r10)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r3 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r6 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r8 = androidx.compose.ui.layout.LayoutKt.materializerOf(r8)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0818
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0818:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x0825
            r0.createNode(r12)
            goto L_0x0828
        L_0x0825:
            r0.useNode()
        L_0x0828:
            r0.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r3, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r13, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r12, r6, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r8.invoke(r3, r0, r6)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getCenter()
            androidx.compose.ui.Modifier r15 = r3.align(r6, r8)
            androidx.compose.material.icons.Icons r3 = androidx.compose.material.icons.Icons.INSTANCE
            androidx.compose.material.icons.Icons$Filled r3 = r3.getDefault()
            androidx.compose.ui.graphics.vector.ImageVector r13 = androidx.compose.material.icons.filled.CloseKt.getClose(r3)
            int r3 = io.intercom.android.sdk.R.string.intercom_close
            java.lang.String r14 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r0, r10)
            r3 = 1
            long r16 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r4, r11, r3, r1)
            r19 = 0
            r20 = 0
            r18 = r0
            androidx.compose.material.IconKt.m1314Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r13, (java.lang.String) r14, (androidx.compose.ui.Modifier) r15, (long) r16, (androidx.compose.runtime.Composer) r18, (int) r19, (int) r20)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x08d7
        L_0x08ca:
            r7 = r70
            r5 = r37
            r1 = 1708462937(0x65d51359, float:1.2577762E23)
            r0.startReplaceableGroup(r1)
            r0.endReplaceableGroup()
        L_0x08d7:
            r1 = r5
        L_0x08d8:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x08df
            goto L_0x08f4
        L_0x08df:
            io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$4 r9 = new io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt$HomeHeader$4
            r0 = r9
            r2 = r68
            r3 = r69
            r4 = r70
            r5 = r72
            r6 = r73
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x08f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.topbars.HomeHeaderKt.m5233HomeHeader942rkJo(androidx.compose.ui.Modifier, io.intercom.android.sdk.m5.home.viewmodel.HeaderState, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void HomeHeader_942rkJo$updateTextStyle(MutableState<Boolean> mutableState, MutableState<TextStyle> mutableState2, TextStyle textStyle) {
        if (mutableState.getValue().booleanValue()) {
            mutableState2.setValue(TextStyle.m4228copyHL5avdY$default(textStyle, 0, TextUnitKt.getSp(24), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262141, (Object) null));
            return;
        }
        MutableState<TextStyle> mutableState3 = mutableState2;
        mutableState2.setValue(textStyle);
    }

    /* access modifiers changed from: private */
    public static final void HomeTopBarPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-2004448257);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderKt.INSTANCE.m5229getLambda2$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderKt$HomeTopBarPreview$1(i));
        }
    }

    /* access modifiers changed from: private */
    public static final void HomeReducedHeaderPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-510419342);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$HomeHeaderKt.INSTANCE.m5231getLambda4$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new HomeHeaderKt$HomeReducedHeaderPreview$1(i));
        }
    }
}
