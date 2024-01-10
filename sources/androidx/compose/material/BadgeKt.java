package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001aS\u0010\u001e\u001a\u00020\u00112\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0007¢\u0006\u0002\u0010!\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\"\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\"\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\"\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\"\u0019\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"BadgeContentFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "BadgeHorizontalOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeHorizontalOffset", "()F", "F", "BadgeRadius", "getBadgeRadius", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentRadius", "getBadgeWithContentRadius", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Badge.kt */
public final class BadgeKt {
    /* access modifiers changed from: private */
    public static final long BadgeContentFontSize = TextUnitKt.getSp(10);
    private static final float BadgeHorizontalOffset;
    private static final float BadgeRadius;
    private static final float BadgeWithContentHorizontalOffset = Dp.m4704constructorimpl(-Dp.m4704constructorimpl((float) 6));
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentRadius = Dp.m4704constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BadgedBox(kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r19
            r3 = r21
            r4 = r23
            java.lang.String r0 = "badge"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r2 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            r2 = 859805272(0x333f9658, float:4.460739E-8)
            r5 = r22
            androidx.compose.runtime.Composer r2 = r5.startRestartGroup(r2)
            java.lang.String r5 = "C(BadgedBox)P(!1,2)63@2513L1971:Badge.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            r5 = r24 & 1
            if (r5 == 0) goto L_0x0025
            r5 = r4 | 6
            goto L_0x0035
        L_0x0025:
            r5 = r4 & 14
            if (r5 != 0) goto L_0x0034
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0031
            r5 = 4
            goto L_0x0032
        L_0x0031:
            r5 = 2
        L_0x0032:
            r5 = r5 | r4
            goto L_0x0035
        L_0x0034:
            r5 = r4
        L_0x0035:
            r7 = r24 & 2
            if (r7 == 0) goto L_0x003c
            r5 = r5 | 48
            goto L_0x004f
        L_0x003c:
            r8 = r4 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004f
            r8 = r20
            boolean r9 = r2.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x004b
            r9 = 32
            goto L_0x004d
        L_0x004b:
            r9 = 16
        L_0x004d:
            r5 = r5 | r9
            goto L_0x0051
        L_0x004f:
            r8 = r20
        L_0x0051:
            r9 = r24 & 4
            if (r9 == 0) goto L_0x0058
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r9 = r4 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0068
            boolean r9 = r2.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0065
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r5 = r5 | r9
        L_0x0068:
            r9 = r5 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r9 != r10) goto L_0x007d
            boolean r9 = r2.getSkipping()
            if (r9 != 0) goto L_0x0075
            goto L_0x007d
        L_0x0075:
            r2.skipToGroupEnd()
            r4 = r1
            r18 = r8
            goto L_0x03b9
        L_0x007d:
            if (r7 == 0) goto L_0x0084
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            goto L_0x0085
        L_0x0084:
            r7 = r8
        L_0x0085:
            androidx.compose.material.BadgeKt$BadgedBox$2 r8 = androidx.compose.material.BadgeKt$BadgedBox$2.INSTANCE
            androidx.compose.ui.layout.MeasurePolicy r8 = (androidx.compose.ui.layout.MeasurePolicy) r8
            r9 = r5 & 112(0x70, float:1.57E-43)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r10)
            java.lang.String r11 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            java.lang.Object r12 = r2.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r10 = r16
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r13, r14)
            java.lang.Object r10 = r2.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            int r9 = r9 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            androidx.compose.runtime.Applier r4 = r2.getApplier()
            boolean r4 = r4 instanceof androidx.compose.runtime.Applier
            if (r4 != 0) goto L_0x00ee
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00ee:
            r2.startReusableNode()
            boolean r4 = r2.getInserting()
            if (r4 == 0) goto L_0x00fb
            r2.createNode(r13)
            goto L_0x00fe
        L_0x00fb:
            r2.useNode()
        L_0x00fe:
            r2.disableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.Updater.m1543constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r4, r8, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r4, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r4, r15, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r4, r10, r8)
            r2.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            int r8 = r9 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r6.invoke(r4, r2, r8)
            r4 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r4)
            int r6 = r9 >> 9
            r6 = r6 & 14
            r8 = 1799938959(0x6b48e38f, float:2.4285978E26)
            r2.startReplaceableGroup(r8)
            java.lang.String r8 = "C65@2543L161,70@2717L105:Badge.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r8)
            r6 = r6 & 11
            r8 = 2
            if (r6 != r8) goto L_0x0168
            boolean r6 = r2.getSkipping()
            if (r6 != 0) goto L_0x0160
            goto L_0x0168
        L_0x0160:
            r2.skipToGroupEnd()
            r4 = r1
            r18 = r7
            goto L_0x03ad
        L_0x0168:
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            java.lang.String r8 = "anchor"
            androidx.compose.ui.Modifier r6 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r6, r8)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getCenter()
            int r9 = r5 << 3
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 54
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r10)
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            int r13 = r9 >> 3
            r15 = r13 & 14
            r13 = r13 & 112(0x70, float:1.57E-43)
            r13 = r13 | r15
            r15 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r8, r15, r2, r13)
            int r13 = r9 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r14)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r4 = r17
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r14)
            java.lang.Object r4 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r18 = r7
            r7 = r17
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r10, r14)
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            int r13 = r13 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            androidx.compose.runtime.Applier r1 = r2.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01fc
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01fc:
            r2.startReusableNode()
            boolean r1 = r2.getInserting()
            if (r1 == 0) goto L_0x0209
            r2.createNode(r10)
            goto L_0x020c
        L_0x0209:
            r2.useNode()
        L_0x020c:
            r2.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m1543constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r8, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r15, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r4, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r1, r7, r4)
            r2.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r1)
            int r4 = r13 >> 3
            r4 = r4 & 112(0x70, float:1.57E-43)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6.invoke(r1, r2, r4)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r1)
            int r1 = r13 >> 9
            r1 = r1 & 14
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r2.startReplaceableGroup(r4)
            java.lang.String r6 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            r1 = r1 & 11
            r7 = 2
            if (r1 != r7) goto L_0x0272
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x026e
            goto L_0x0272
        L_0x026e:
            r2.skipToGroupEnd()
            goto L_0x0281
        L_0x0272:
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r7 = r9 >> 6
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | 6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3.invoke(r1, r2, r7)
        L_0x0281:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r0)
            int r1 = r5 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            int r7 = r1 >> 3
            r8 = r7 & 14
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r8, r2, r7)
            int r7 = r1 << 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r14)
            java.lang.Object r8 = r2.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r14)
            java.lang.Object r10 = r2.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r14)
            java.lang.Object r9 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r7 = r7 << 9
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | 6
            androidx.compose.runtime.Applier r12 = r2.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x031a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x031a:
            r2.startReusableNode()
            boolean r12 = r2.getInserting()
            if (r12 == 0) goto L_0x0327
            r2.createNode(r11)
            goto L_0x032a
        L_0x0327:
            r2.useNode()
        L_0x032a:
            r2.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r5, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r8, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r9, r5)
            r2.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            int r8 = r7 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0.invoke(r5, r2, r8)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r7 >> 9
            r0 = r0 & 14
            r2.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r6)
            r0 = r0 & 11
            r4 = 2
            if (r0 != r4) goto L_0x038d
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0387
            goto L_0x038d
        L_0x0387:
            r2.skipToGroupEnd()
            r4 = r19
            goto L_0x039e
        L_0x038d:
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r1 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4 = r19
            r4.invoke(r0, r2, r1)
        L_0x039e:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
        L_0x03ad:
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
        L_0x03b9:
            androidx.compose.runtime.ScopeUpdateScope r6 = r2.endRestartGroup()
            if (r6 != 0) goto L_0x03c0
            goto L_0x03d5
        L_0x03c0:
            androidx.compose.material.BadgeKt$BadgedBox$3 r7 = new androidx.compose.material.BadgeKt$BadgedBox$3
            r0 = r7
            r1 = r19
            r2 = r18
            r3 = r21
            r4 = r23
            r5 = r24
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x03d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BadgeKt.BadgedBox(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* renamed from: Badge-eopBjH0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1138BadgeeopBjH0(androidx.compose.ui.Modifier r17, long r18, long r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r7 = r24
            r0 = 1133484502(0x438f99d6, float:287.20184)
            r1 = r23
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)131@5169L6,132@5209L32,139@5458L857:Badge.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r25 & 1
            r2 = 2
            if (r1 == 0) goto L_0x001b
            r3 = r7 | 6
            r4 = r3
            r3 = r17
            goto L_0x002f
        L_0x001b:
            r3 = r7 & 14
            if (r3 != 0) goto L_0x002c
            r3 = r17
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0029
            r4 = 4
            goto L_0x002a
        L_0x0029:
            r4 = 2
        L_0x002a:
            r4 = r4 | r7
            goto L_0x002f
        L_0x002c:
            r3 = r17
            r4 = r7
        L_0x002f:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0048
            r5 = r25 & 2
            if (r5 != 0) goto L_0x0042
            r5 = r18
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x0044
            r8 = 32
            goto L_0x0046
        L_0x0042:
            r5 = r18
        L_0x0044:
            r8 = 16
        L_0x0046:
            r4 = r4 | r8
            goto L_0x004a
        L_0x0048:
            r5 = r18
        L_0x004a:
            r8 = r7 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0063
            r8 = r25 & 4
            if (r8 != 0) goto L_0x005d
            r8 = r20
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x005f
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005d:
            r8 = r20
        L_0x005f:
            r10 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r10
            goto L_0x0065
        L_0x0063:
            r8 = r20
        L_0x0065:
            r10 = r25 & 8
            if (r10 == 0) goto L_0x006c
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r11 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007f
            r11 = r22
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x007b
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r4 = r4 | r12
            goto L_0x0081
        L_0x007f:
            r11 = r22
        L_0x0081:
            r12 = r4 & 5851(0x16db, float:8.199E-42)
            r13 = 1170(0x492, float:1.64E-42)
            if (r12 != r13) goto L_0x0097
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x008e
            goto L_0x0097
        L_0x008e:
            r0.skipToGroupEnd()
            r1 = r3
        L_0x0092:
            r2 = r5
            r4 = r8
            r6 = r11
            goto L_0x0235
        L_0x0097:
            r0.startDefaults()
            r12 = r7 & 1
            r13 = 0
            r14 = 6
            if (r12 == 0) goto L_0x00b8
            boolean r12 = r0.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00a7
            goto L_0x00b8
        L_0x00a7:
            r0.skipToGroupEnd()
            r1 = r25 & 2
            if (r1 == 0) goto L_0x00b0
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00b0:
            r1 = r25 & 4
            if (r1 == 0) goto L_0x00b6
            r4 = r4 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b6:
            r1 = r3
            goto L_0x00e2
        L_0x00b8:
            if (r1 == 0) goto L_0x00bf
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00c0
        L_0x00bf:
            r1 = r3
        L_0x00c0:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x00d0
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r3 = r3.getColors(r0, r14)
            long r5 = r3.m1208getError0d7_KjU()
            r4 = r4 & -113(0xffffffffffffff8f, float:NaN)
        L_0x00d0:
            r3 = r25 & 4
            if (r3 == 0) goto L_0x00df
            int r3 = r4 >> 3
            r3 = r3 & 14
            long r8 = androidx.compose.material.ColorsKt.m1232contentColorForek8zF_U(r5, r0, r3)
            r3 = r4 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r3
        L_0x00df:
            if (r10 == 0) goto L_0x00e2
            r11 = r13
        L_0x00e2:
            r0.endDefaults()
            if (r11 == 0) goto L_0x00ea
            float r3 = BadgeWithContentRadius
            goto L_0x00ec
        L_0x00ea:
            float r3 = BadgeRadius
        L_0x00ec:
            androidx.compose.foundation.shape.RoundedCornerShape r10 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m855RoundedCornerShape0680j_4(r3)
            float r12 = (float) r2
            float r3 = r3 * r12
            float r12 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            float r3 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m566defaultMinSizeVpY3zN4(r1, r12, r3)
            androidx.compose.ui.graphics.Shape r10 = (androidx.compose.ui.graphics.Shape) r10
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m176backgroundbw27NRU(r3, r5, r10)
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.draw.ClipKt.clip(r3, r10)
            float r10 = BadgeWithContentHorizontalPadding
            r12 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m512paddingVpY3zN4$default(r3, r10, r12, r2, r13)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r3 = r3.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r10 = r10.getCenter()
            r12 = 693286680(0x2952b718, float:4.6788176E-14)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.foundation.layout.Arrangement$Horizontal r10 = (androidx.compose.foundation.layout.Arrangement.Horizontal) r10
            r12 = 54
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r10, r3, r0, r12)
            r10 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r10)
            java.lang.String r10 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r13)
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r13)
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r12, r13)
            java.lang.Object r12 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x018c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x018c:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x0199
            r0.createNode(r13)
            goto L_0x019c
        L_0x0199:
            r0.useNode()
        L_0x019c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r10, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r13, r12, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            r10 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            r2.invoke(r3, r0, r12)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C80@3988L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r2 = (androidx.compose.foundation.layout.RowScope) r2
            r3 = -1024875974(0xffffffffc2e9a23a, float:-116.81685)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C154@5959L340:Badge.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            if (r11 == 0) goto L_0x0221
            r3 = 1
            androidx.compose.runtime.ProvidedValue[] r12 = new androidx.compose.runtime.ProvidedValue[r3]
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r14 = androidx.compose.ui.graphics.Color.m1922boximpl(r8)
            androidx.compose.runtime.ProvidedValue r13 = r13.provides(r14)
            r12[r10] = r13
            r10 = 1784526485(0x6a5db695, float:6.7008706E25)
            androidx.compose.material.BadgeKt$Badge$1$1 r13 = new androidx.compose.material.BadgeKt$Badge$1$1
            r14 = 6
            r13.<init>(r11, r2, r14, r4)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r10, r3, r13)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r3 = 56
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r2, (androidx.compose.runtime.Composer) r0, (int) r3)
        L_0x0221:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x0092
        L_0x0235:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x023c
            goto L_0x024b
        L_0x023c:
            androidx.compose.material.BadgeKt$Badge$2 r10 = new androidx.compose.material.BadgeKt$Badge$2
            r0 = r10
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r4, r6, r7, r8)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r9.updateScope(r10)
        L_0x024b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BadgeKt.m1138BadgeeopBjH0(androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getBadgeRadius() {
        return BadgeRadius;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeWithContentRadius;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeHorizontalOffset() {
        return BadgeHorizontalOffset;
    }

    static {
        float f = (float) 4;
        BadgeRadius = Dp.m4704constructorimpl(f);
        BadgeWithContentHorizontalPadding = Dp.m4704constructorimpl(f);
        BadgeHorizontalOffset = Dp.m4704constructorimpl(-Dp.m4704constructorimpl(f));
    }
}
