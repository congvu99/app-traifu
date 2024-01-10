package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $background;
    final /* synthetic */ Set<DismissDirection> $directions;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $dismissContent;
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;
    final /* synthetic */ DismissState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$2(Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, int i, DismissState dismissState, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32) {
        super(3);
        this.$directions = set;
        this.$dismissThresholds = function1;
        this.$$dirty = i;
        this.$state = dismissState;
        this.$background = function3;
        this.$dismissContent = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "C180@6642L7,186@6883L106,193@7214L718:SwipeToDismiss.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r3)
            r3 = r25 & 14
            if (r3 != 0) goto L_0x0020
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x001c
            r3 = 4
            goto L_0x001d
        L_0x001c:
            r3 = 2
        L_0x001d:
            r3 = r25 | r3
            goto L_0x0022
        L_0x0020:
            r3 = r25
        L_0x0022:
            r3 = r3 & 91
            r5 = 18
            if (r3 != r5) goto L_0x0034
            boolean r3 = r24.getSkipping()
            if (r3 != 0) goto L_0x002f
            goto L_0x0034
        L_0x002f:
            r24.skipToGroupEnd()
            goto L_0x049b
        L_0x0034:
            long r5 = r23.m457getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m4624getMaxWidthimpl(r5)
            float r1 = (float) r1
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            java.lang.Object r3 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.LayoutDirection r7 = androidx.compose.ui.unit.LayoutDirection.Rtl
            r8 = 1
            r9 = 0
            if (r3 != r7) goto L_0x005a
            r15 = 1
            goto L_0x005b
        L_0x005a:
            r15 = 0
        L_0x005b:
            kotlin.Pair[] r3 = new kotlin.Pair[r8]
            r7 = 0
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            androidx.compose.material.DismissValue r10 = androidx.compose.material.DismissValue.Default
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r10)
            r3[r9] = r7
            java.util.Map r12 = kotlin.collections.MapsKt.mutableMapOf(r3)
            java.util.Set<androidx.compose.material.DismissDirection> r3 = r0.$directions
            androidx.compose.material.DismissDirection r7 = androidx.compose.material.DismissDirection.StartToEnd
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto L_0x008d
            java.lang.Float r3 = java.lang.Float.valueOf(r1)
            androidx.compose.material.DismissValue r7 = androidx.compose.material.DismissValue.DismissedToEnd
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r7)
            java.lang.Object r7 = r3.getFirst()
            java.lang.Object r3 = r3.getSecond()
            r12.put(r7, r3)
        L_0x008d:
            java.util.Set<androidx.compose.material.DismissDirection> r3 = r0.$directions
            androidx.compose.material.DismissDirection r7 = androidx.compose.material.DismissDirection.EndToStart
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto L_0x00ad
            float r3 = -r1
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            androidx.compose.material.DismissValue r7 = androidx.compose.material.DismissValue.DismissedToStart
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r7)
            java.lang.Object r7 = r3.getFirst()
            java.lang.Object r3 = r3.getSecond()
            r12.put(r7, r3)
        L_0x00ad:
            kotlin.jvm.functions.Function1<androidx.compose.material.DismissDirection, androidx.compose.material.ThresholdConfig> r3 = r0.$dismissThresholds
            r7 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r7)
            java.lang.String r14 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            boolean r10 = r2.changed((java.lang.Object) r3)
            java.lang.Object r11 = r24.rememberedValue()
            if (r10 != 0) goto L_0x00cc
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x00d7
        L_0x00cc:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 r10 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1
            r10.<init>(r3)
            r11 = r10
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r2.updateRememberedValue(r11)
        L_0x00d7:
            r24.endReplaceableGroup()
            r17 = r11
            kotlin.jvm.functions.Function2 r17 = (kotlin.jvm.functions.Function2) r17
            java.util.Set<androidx.compose.material.DismissDirection> r3 = r0.$directions
            androidx.compose.material.DismissDirection r10 = androidx.compose.material.DismissDirection.EndToStart
            boolean r3 = r3.contains(r10)
            r10 = 1092616192(0x41200000, float:10.0)
            r11 = 1101004800(0x41a00000, float:20.0)
            if (r3 == 0) goto L_0x00ef
            r3 = 1092616192(0x41200000, float:10.0)
            goto L_0x00f1
        L_0x00ef:
            r3 = 1101004800(0x41a00000, float:20.0)
        L_0x00f1:
            java.util.Set<androidx.compose.material.DismissDirection> r13 = r0.$directions
            androidx.compose.material.DismissDirection r8 = androidx.compose.material.DismissDirection.StartToEnd
            boolean r8 = r13.contains(r8)
            if (r8 == 0) goto L_0x00fc
            goto L_0x00fe
        L_0x00fc:
            r10 = 1101004800(0x41a00000, float:20.0)
        L_0x00fe:
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r13 = androidx.compose.foundation.gestures.Orientation.Horizontal
            androidx.compose.material.DismissState r11 = r0.$state
            java.lang.Object r11 = r11.getCurrentValue()
            androidx.compose.material.DismissValue r7 = androidx.compose.material.DismissValue.Default
            if (r11 != r7) goto L_0x010e
            r7 = 1
            goto L_0x010f
        L_0x010e:
            r7 = 0
        L_0x010f:
            androidx.compose.material.ResistanceConfig r11 = new androidx.compose.material.ResistanceConfig
            r11.<init>(r1, r3, r10)
            r10 = r8
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            androidx.compose.material.DismissState r1 = r0.$state
            androidx.compose.material.SwipeableState r1 = (androidx.compose.material.SwipeableState) r1
            r16 = 0
            r19 = 0
            r20 = 288(0x120, float:4.04E-43)
            r21 = 0
            r3 = r11
            r11 = r1
            r1 = r14
            r14 = r7
            r18 = r3
            androidx.compose.ui.Modifier r3 = androidx.compose.material.SwipeableKt.m1430swipeablepPrIpRY$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r0.$background
            int r8 = r0.$$dirty
            androidx.compose.material.DismissState r10 = r0.$state
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.RowScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.$dismissContent
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r9, r2, r9)
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r13)
            java.lang.String r14 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r4 = r16
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            java.lang.Object r4 = r2.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r6)
            java.lang.Object r13 = r2.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            androidx.compose.runtime.Applier r9 = r24.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x01a4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01a4:
            r24.startReusableNode()
            boolean r9 = r24.getInserting()
            if (r9 == 0) goto L_0x01b1
            r2.createNode(r5)
            goto L_0x01b4
        L_0x01b1:
            r24.useNode()
        L_0x01b4:
            r24.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1543constructorimpl(r24)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r12, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r15, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r4, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r5, r13, r4)
            r24.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r24)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3.invoke(r4, r2, r5)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r2.startReplaceableGroup(r4)
            java.lang.String r4 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            androidx.compose.foundation.layout.BoxScopeInstance r4 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r4 = (androidx.compose.foundation.layout.BoxScope) r4
            r5 = 981834387(0x3a859a93, float:0.0010193161)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "C208@7678L98,214@7867L49,212@7785L141:SwipeToDismiss.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.ui.Modifier r4 = r4.matchParentSize(r5)
            int r5 = r8 >> 3
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r9 = 693286680(0x2952b718, float:4.6788176E-14)
            r2.startReplaceableGroup(r9)
            java.lang.String r12 = "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            androidx.compose.foundation.layout.Arrangement r13 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r13 = r13.getStart()
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r15 = r15.getTop()
            int r16 = r5 >> 3
            r19 = r16 & 14
            r16 = r16 & 112(0x70, float:1.57E-43)
            r9 = r19 | r16
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r13, r15, r2, r9)
            int r13 = r5 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r6)
            java.lang.Object r15 = r2.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r0 = r18
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r6)
            java.lang.Object r0 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r19 = r11
            r11 = r18
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r3, r6)
            java.lang.Object r3 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            int r13 = r13 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r21 = r6
            androidx.compose.runtime.Applier r6 = r24.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x02aa
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02aa:
            r24.startReusableNode()
            boolean r6 = r24.getInserting()
            if (r6 == 0) goto L_0x02b7
            r2.createNode(r11)
            goto L_0x02ba
        L_0x02b7:
            r24.useNode()
        L_0x02ba:
            r24.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1543constructorimpl(r24)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r15, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r0, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r6, r3, r0)
            r24.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r24)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r0)
            int r3 = r13 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4.invoke(r0, r2, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r13 >> 9
            r0 = r0 & 14
            r3 = -678309503(0xffffffffd791d181, float:-3.20657997E14)
            r2.startReplaceableGroup(r3)
            java.lang.String r4 = "C80@3988L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r0 = r0 & 11
            r6 = 2
            if (r0 != r6) goto L_0x0320
            boolean r0 = r24.getSkipping()
            if (r0 != 0) goto L_0x031c
            goto L_0x0320
        L_0x031c:
            r24.skipToGroupEnd()
            goto L_0x032f
        L_0x0320:
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r5 = r5 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 6
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.invoke(r0, r2, r5)
        L_0x032f:
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endNode()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            boolean r1 = r2.changed((java.lang.Object) r10)
            java.lang.Object r5 = r24.rememberedValue()
            if (r1 != 0) goto L_0x035d
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L_0x0368
        L_0x035d:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1 r1 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2$1$1$1
            r1.<init>(r10)
            r5 = r1
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r2.updateRememberedValue(r5)
        L_0x0368:
            r24.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.OffsetKt.offset(r0, r5)
            int r1 = r8 >> 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = 693286680(0x2952b718, float:4.6788176E-14)
            r2.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getTop()
            int r7 = r1 >> 3
            r8 = r7 & 14
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r6, r2, r7)
            int r6 = r1 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r8 = r21
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r8)
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r8)
            java.lang.Object r10 = r2.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r8)
            java.lang.Object r8 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r24)
            androidx.compose.ui.platform.ViewConfiguration r8 = (androidx.compose.ui.platform.ViewConfiguration) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            int r6 = r6 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | 6
            androidx.compose.runtime.Applier r11 = r24.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x03f8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03f8:
            r24.startReusableNode()
            boolean r11 = r24.getInserting()
            if (r11 == 0) goto L_0x0405
            r2.createNode(r9)
            goto L_0x0408
        L_0x0405:
            r24.useNode()
        L_0x0408:
            r24.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r24)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r7, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r10, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r8, r5)
            r24.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r24)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r5)
            int r7 = r6 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r0.invoke(r5, r2, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r0 = r6 >> 9
            r0 = r0 & 14
            r2.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r0 = r0 & 11
            r3 = 2
            if (r0 != r3) goto L_0x0469
            boolean r0 = r24.getSkipping()
            if (r0 != 0) goto L_0x0465
            goto L_0x0469
        L_0x0465:
            r24.skipToGroupEnd()
            goto L_0x047a
        L_0x0469:
            androidx.compose.foundation.layout.RowScopeInstance r0 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r1 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r19
            r3.invoke(r0, r2, r1)
        L_0x047a:
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endNode()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
            r24.endNode()
            r24.endReplaceableGroup()
            r24.endReplaceableGroup()
        L_0x049b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }
}
