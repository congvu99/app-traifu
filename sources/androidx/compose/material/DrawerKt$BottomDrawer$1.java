package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$BottomDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$1(boolean z, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, Shape shape, long j2, long j3, float f, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$gesturesEnabled = z;
        this.$drawerState = bottomDrawerState;
        this.$content = function2;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r13 = r30
            java.lang.String r2 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.lang.String r2 = "C512@19019L51,*531@19859L7,553@20546L1672:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r2 = r31 & 14
            r3 = 2
            if (r2 != 0) goto L_0x0021
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001d
            r2 = 4
            goto L_0x001e
        L_0x001d:
            r2 = 2
        L_0x001e:
            r2 = r31 | r2
            goto L_0x0023
        L_0x0021:
            r2 = r31
        L_0x0023:
            r2 = r2 & 91
            r4 = 18
            if (r2 != r4) goto L_0x0035
            boolean r2 = r30.getSkipping()
            if (r2 != 0) goto L_0x0030
            goto L_0x0035
        L_0x0030:
            r30.skipToGroupEnd()
            goto L_0x0360
        L_0x0035:
            long r4 = r29.m457getConstraintsmsEJaDk()
            int r2 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r4)
            float r2 = (float) r2
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            r7 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r7)
            java.lang.String r8 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r8)
            boolean r4 = r13.changed((java.lang.Object) r4)
            java.lang.Object r5 = r30.rememberedValue()
            r9 = 0
            if (r4 != 0) goto L_0x0060
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x006b
        L_0x0060:
            java.lang.Float r4 = java.lang.Float.valueOf(r2)
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r9, r3, r9)
            r13.updateRememberedValue(r5)
        L_0x006b:
            r30.endReplaceableGroup()
            r10 = r5
            androidx.compose.runtime.MutableState r10 = (androidx.compose.runtime.MutableState) r10
            long r4 = r29.m457getConstraintsmsEJaDk()
            int r4 = androidx.compose.ui.unit.Constraints.m4624getMaxWidthimpl(r4)
            long r5 = r29.m457getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r5)
            r11 = 1
            r12 = 0
            if (r4 <= r5) goto L_0x0087
            r4 = 1
            goto L_0x0088
        L_0x0087:
            r4 = 0
        L_0x0088:
            r5 = 0
            r6 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 * r2
            float r14 = m1269invoke$lambda1(r10)
            float r14 = r2 - r14
            float r5 = java.lang.Math.max(r5, r14)
            float r14 = m1269invoke$lambda1(r10)
            int r14 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r14 < 0) goto L_0x00ce
            if (r4 == 0) goto L_0x00a2
            goto L_0x00ce
        L_0x00a2:
            r4 = 3
            kotlin.Pair[] r4 = new kotlin.Pair[r4]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r14)
            r4[r12] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r6)
            androidx.compose.material.BottomDrawerValue r6 = androidx.compose.material.BottomDrawerValue.Open
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r6)
            r4[r11] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r3] = r2
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r4)
            goto L_0x00ec
        L_0x00ce:
            kotlin.Pair[] r4 = new kotlin.Pair[r3]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            androidx.compose.material.BottomDrawerValue r6 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r6)
            r4[r12] = r2
            java.lang.Float r2 = java.lang.Float.valueOf(r5)
            androidx.compose.material.BottomDrawerValue r5 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r5)
            r4[r11] = r2
            java.util.Map r2 = kotlin.collections.MapsKt.mapOf(r4)
        L_0x00ec:
            r16 = r2
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r5)
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            r17 = r6
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            r18 = 0
            r19 = 0
            long r14 = r29.m457getConstraintsmsEJaDk()
            int r6 = androidx.compose.ui.unit.Constraints.m4624getMaxWidthimpl(r14)
            float r20 = r2.m4646toDpu2uoSUM((int) r6)
            long r14 = r29.m457getConstraintsmsEJaDk()
            int r1 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r14)
            float r21 = r2.m4646toDpu2uoSUM((int) r1)
            r22 = 3
            r23 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m586sizeInqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            boolean r1 = r0.$gesturesEnabled
            if (r1 == 0) goto L_0x0142
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material.BottomDrawerState r2 = r0.$drawerState
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r2 = r2.getNestedScrollConnection$material_release()
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r1, r2, r9, r3, r9)
            goto L_0x0146
        L_0x0142:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x0146:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = r2.then(r1)
            androidx.compose.material.BottomDrawerState r1 = r0.$drawerState
            r15 = r1
            androidx.compose.material.SwipeableState r15 = (androidx.compose.material.SwipeableState) r15
            androidx.compose.foundation.gestures.Orientation r17 = androidx.compose.foundation.gestures.Orientation.Vertical
            boolean r1 = r0.$gesturesEnabled
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 368(0x170, float:5.16E-43)
            r25 = 0
            r18 = r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.SwipeableKt.m1430swipeablepPrIpRY$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$content
            int r14 = r0.$$dirty
            r15 = r10
            long r9 = r0.$scrimColor
            androidx.compose.material.BottomDrawerState r3 = r0.$drawerState
            androidx.compose.ui.graphics.Shape r11 = r0.$drawerShape
            r18 = r8
            long r7 = r0.$drawerBackgroundColor
            r20 = r5
            long r4 = r0.$drawerContentColor
            float r12 = r0.$drawerElevation
            r22 = r4
            boolean r4 = r0.$gesturesEnabled
            kotlinx.coroutines.CoroutineScope r5 = r0.$scope
            r29 = r15
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.$drawerContent
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r24 = r6
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r0 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r6, r13, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r6)
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r25 = r12
            r12 = r20
            r19 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r12)
            java.lang.Object r6 = r13.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r12)
            java.lang.Object r8 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r26 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r27 = r11
            r11 = r26
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r12)
            java.lang.Object r7 = r13.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r30)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r12 = r30.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0203
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0203:
            r30.startReusableNode()
            boolean r12 = r30.getInserting()
            if (r12 == 0) goto L_0x0210
            r13.createNode(r11)
            goto L_0x0213
        L_0x0210:
            r30.useNode()
        L_0x0213:
            r30.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1543constructorimpl(r30)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r0, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r8, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r11, r7, r0)
            r30.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r30)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r0)
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r1.invoke(r0, r13, r7)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1660053078(0xffffffff9d0d99aa, float:-1.8740637E-21)
            r13.startReplaceableGroup(r0)
            java.lang.String r0 = "C554@20575L9,555@20597L427,566@21058L33,569@21175L63,570@21281L105,567@21104L1104:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            int r0 = r14 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.invoke(r13, r0)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$1 r0 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$1
            r0.<init>(r4, r3, r5)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            java.lang.Object r1 = r3.getTargetValue()
            androidx.compose.material.BottomDrawerValue r2 = androidx.compose.material.BottomDrawerValue.Closed
            if (r1 == r2) goto L_0x028d
            r4 = 1
            goto L_0x028e
        L_0x028d:
            r4 = 0
        L_0x028e:
            int r1 = r14 >> 24
            r6 = r1 & 14
            r1 = r9
            r7 = r3
            r3 = r0
            r8 = r22
            r0 = r5
            r5 = r30
            r10 = r24
            androidx.compose.material.DrawerKt.m1261BottomDrawerScrim3JVO9M(r1, r3, r4, r5, r6)
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1414getNavigationMenuUdPEhr4()
            r2 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1417getString4foXLRw(r1, r13, r2)
            r2 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r2)
            r2 = r18
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r3 = r13.changed((java.lang.Object) r7)
            java.lang.Object r4 = r30.rememberedValue()
            if (r3 != 0) goto L_0x02c7
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x02d2
        L_0x02c7:
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1 r3 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
            r3.<init>(r7)
            r4 = r3
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13.updateRememberedValue(r4)
        L_0x02d2:
            r30.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.OffsetKt.offset(r10, r4)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            r5 = r29
            boolean r2 = r13.changed((java.lang.Object) r5)
            java.lang.Object r4 = r30.rememberedValue()
            if (r2 != 0) goto L_0x02f8
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r4 != r2) goto L_0x0303
        L_0x02f8:
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1 r2 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
            r2.<init>(r5)
            r4 = r2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r13.updateRememberedValue(r4)
        L_0x0303:
            r30.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r3, r4)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$4 r3 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
            r3.<init>(r1, r7, r0)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r0 = 0
            r1 = 1
            r4 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r4, r3, r1, r0)
            r7 = 0
            r2 = 457750254(0x1b48b6ee, float:1.660272E-22)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$5 r3 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
            r3.<init>(r15, r14)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r2, r1, r3)
            r10 = r1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r1 = 1572864(0x180000, float:2.204052E-39)
            int r2 = r14 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r14 >> 12
            r3 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r14
            r11 = r1 | r2
            r12 = 16
            r1 = r0
            r2 = r27
            r3 = r19
            r5 = r8
            r8 = r25
            r9 = r10
            r10 = r30
            androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
            r30.endNode()
            r30.endReplaceableGroup()
            r30.endReplaceableGroup()
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$BottomDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final float m1269invoke$lambda1(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m1270invoke$lambda2(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }
}
