package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J|\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material/ThreeLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconThreeLineVerticalPadding", "MinHeight", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ThreeLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth = Dp.m4704constructorimpl((float) 40);
    private static final float IconThreeLineVerticalPadding;
    private static final float MinHeight = Dp.m4704constructorimpl((float) 88);
    private static final float ThreeLineBaselineFirstOffset = Dp.m4704constructorimpl((float) 28);
    private static final float ThreeLineBaselineSecondOffset;
    private static final float ThreeLineBaselineThirdOffset;
    private static final float ThreeLineTrailingTopPadding;
    private static final float TrailingRightPadding;

    private ThreeLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ListItem(androidx.compose.ui.Modifier r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r35 = this;
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r13 = r41
            r14 = r43
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "secondaryText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1749738797(0x684ae52d, float:3.8325823E24)
            r1 = r42
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(1!1,4,3)302@11212L1431:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r44 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0031
            r7 = r14 | 6
            r8 = r7
            r7 = r36
            goto L_0x0045
        L_0x0031:
            r7 = r14 & 14
            if (r7 != 0) goto L_0x0042
            r7 = r36
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x003f
            r8 = 4
            goto L_0x0040
        L_0x003f:
            r8 = 2
        L_0x0040:
            r8 = r8 | r14
            goto L_0x0045
        L_0x0042:
            r7 = r36
            r8 = r14
        L_0x0045:
            r9 = r44 & 2
            if (r9 == 0) goto L_0x004c
            r8 = r8 | 48
            goto L_0x005c
        L_0x004c:
            r9 = r14 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x005c
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0059
            r9 = 32
            goto L_0x005b
        L_0x0059:
            r9 = 16
        L_0x005b:
            r8 = r8 | r9
        L_0x005c:
            r9 = r44 & 4
            if (r9 == 0) goto L_0x0063
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0073
        L_0x0063:
            r9 = r14 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0073
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0070
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r8 = r8 | r9
        L_0x0073:
            r9 = r44 & 8
            if (r9 == 0) goto L_0x007a
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x007a:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x008a
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0087
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r8 = r8 | r9
        L_0x008a:
            r9 = r44 & 16
            if (r9 == 0) goto L_0x0091
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0091:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a3
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x00a0
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r8 = r8 | r9
        L_0x00a3:
            r9 = r44 & 32
            if (r9 == 0) goto L_0x00ab
            r9 = 196608(0x30000, float:2.75506E-40)
        L_0x00a9:
            r8 = r8 | r9
            goto L_0x00bc
        L_0x00ab:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00bc
            boolean r9 = r0.changed((java.lang.Object) r13)
            if (r9 == 0) goto L_0x00b9
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a9
        L_0x00b9:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a9
        L_0x00bc:
            r9 = r44 & 64
            if (r9 == 0) goto L_0x00c6
            r9 = 1572864(0x180000, float:2.204052E-39)
            r8 = r8 | r9
            r15 = r35
            goto L_0x00d9
        L_0x00c6:
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r14
            r15 = r35
            if (r9 != 0) goto L_0x00d9
            boolean r9 = r0.changed((java.lang.Object) r15)
            if (r9 == 0) goto L_0x00d6
            r9 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r9 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r8 = r8 | r9
        L_0x00d9:
            r12 = r8
            r8 = 2995931(0x2db6db, float:4.198194E-39)
            r8 = r8 & r12
            r9 = 599186(0x92492, float:8.39638E-40)
            if (r8 != r9) goto L_0x00f0
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            r0.skipToGroupEnd()
            r2 = r7
            goto L_0x03c1
        L_0x00f0:
            if (r1 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00f8
        L_0x00f7:
            r1 = r7
        L_0x00f8:
            float r7 = MinHeight
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m570heightInVpY3zN4$default(r1, r7, r8, r2, r9)
            r8 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getTop()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r9, r0, r10)
            r9 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r9)
            java.lang.String r11 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r18 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r17
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x017f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017f:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x018c
            r0.createNode(r9)
            goto L_0x018f
        L_0x018c:
            r0.useNode()
        L_0x018f:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r1, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r14, r1)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            r2 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r7.invoke(r1, r0, r8)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C80@3988L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r20 = r2
            androidx.compose.foundation.layout.RowScope r20 = (androidx.compose.foundation.layout.RowScope) r20
            r2 = 1483377809(0x586a8c91, float:1.0315578E15)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C316@11836L477,330@12366L253:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = -280382992(0xffffffffef49b1f0, float:-6.24216E28)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "305@11369L440"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            if (r3 == 0) goto L_0x031f
            float r2 = IconLeftPadding
            float r7 = IconMinPaddedWidth
            float r2 = r2 + r7
            float r23 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r21 = r2
            androidx.compose.ui.Modifier r21 = (androidx.compose.ui.Modifier) r21
            r24 = 0
            r25 = 0
            r26 = 12
            r27 = 0
            r22 = r23
            androidx.compose.ui.Modifier r28 = androidx.compose.foundation.layout.SizeKt.m586sizeInqDBjuR0$default(r21, r22, r23, r24, r25, r26, r27)
            float r29 = IconLeftPadding
            float r32 = IconThreeLineVerticalPadding
            r31 = 0
            r33 = 4
            r34 = 0
            r30 = r32
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r28, r29, r30, r31, r32, r33, r34)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getCenterStart()
            r8 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            r8 = 6
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r9, r0, r8)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0297
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0297:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x02a4
            r0.createNode(r10)
            goto L_0x02a7
        L_0x02a4:
            r0.useNode()
        L_0x02a7:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r8, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r10, r9, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r7)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2.invoke(r7, r0, r9)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = 2007028978(0x77a0d4f2, float:6.5241136E33)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C314@11801L6:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r12 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x031f:
            r0.endReplaceableGroup()
            r1 = 3
            androidx.compose.ui.unit.Dp[] r1 = new androidx.compose.ui.unit.Dp[r1]
            float r2 = ThreeLineBaselineFirstOffset
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m4702boximpl(r2)
            r7 = 0
            r1[r7] = r2
            float r2 = ThreeLineBaselineSecondOffset
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m4702boximpl(r2)
            r7 = 1
            r1[r7] = r2
            float r2 = ThreeLineBaselineThirdOffset
            androidx.compose.ui.unit.Dp r2 = androidx.compose.ui.unit.Dp.m4702boximpl(r2)
            r8 = 2
            r1[r8] = r2
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r21 = r2
            androidx.compose.ui.Modifier r21 = (androidx.compose.ui.Modifier) r21
            r22 = 1065353216(0x3f800000, float:1.0)
            r23 = 0
            r24 = 2
            r25 = 0
            androidx.compose.ui.Modifier r26 = androidx.compose.foundation.layout.RowScope.CC.weight$default(r20, r21, r22, r23, r24, r25)
            float r27 = ContentLeftPadding
            r28 = 0
            float r29 = ContentRightPadding
            r30 = 0
            r31 = 10
            r32 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r26, r27, r28, r29, r30, r31, r32)
            r2 = -318094245(0xffffffffed0a445b, float:-2.674473E27)
            androidx.compose.material.ThreeLine$ListItem$1$2 r9 = new androidx.compose.material.ThreeLine$ListItem$1$2
            r9.<init>(r6, r12, r4, r5)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r7, r9)
            r9 = r2
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r11 = 384(0x180, float:5.38E-43)
            r2 = 0
            r7 = r1
            r10 = r0
            r1 = r12
            r12 = r2
            androidx.compose.material.ListItemKt.BaselinesOffsetColumn(r7, r8, r9, r10, r11, r12)
            if (r13 == 0) goto L_0x03ad
            float r2 = ThreeLineBaselineFirstOffset
            float r7 = ThreeLineTrailingTopPadding
            float r2 = r2 - r7
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r19 = r2
            androidx.compose.ui.Modifier r19 = (androidx.compose.ui.Modifier) r19
            r20 = 0
            float r21 = ThreeLineTrailingTopPadding
            float r22 = TrailingRightPadding
            r23 = 0
            r24 = 9
            r25 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r19, r20, r21, r22, r23, r24, r25)
            int r1 = r1 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r11 = r1 | 54
            r12 = 0
            r9 = r41
            r10 = r0
            androidx.compose.material.ListItemKt.m1316OffsetToBaselineOrCenterKz89ssw(r7, r8, r9, r10, r11, r12)
        L_0x03ad:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r18
        L_0x03c1:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x03c8
            goto L_0x03e3
        L_0x03c8:
            androidx.compose.material.ThreeLine$ListItem$2 r11 = new androidx.compose.material.ThreeLine$ListItem$2
            r0 = r11
            r1 = r35
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = r43
            r9 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x03e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ThreeLine.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 16;
        IconLeftPadding = Dp.m4704constructorimpl(f);
        IconThreeLineVerticalPadding = Dp.m4704constructorimpl(f);
        ContentLeftPadding = Dp.m4704constructorimpl(f);
        ContentRightPadding = Dp.m4704constructorimpl(f);
        float f2 = (float) 20;
        ThreeLineBaselineSecondOffset = Dp.m4704constructorimpl(f2);
        ThreeLineBaselineThirdOffset = Dp.m4704constructorimpl(f2);
        ThreeLineTrailingTopPadding = Dp.m4704constructorimpl(f);
        TrailingRightPadding = Dp.m4704constructorimpl(f);
    }
}
