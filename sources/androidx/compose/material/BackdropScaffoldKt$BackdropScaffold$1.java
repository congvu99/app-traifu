package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $backLayer;
    final /* synthetic */ Function1<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ long $frontLayerBackgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $frontLayerContent;
    final /* synthetic */ long $frontLayerContentColor;
    final /* synthetic */ float $frontLayerElevation;
    final /* synthetic */ long $frontLayerScrimColor;
    final /* synthetic */ Shape $frontLayerShape;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ float $headerHeightPx;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ boolean $stickyFrontLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, float f, boolean z, boolean z2, BackdropScaffoldState backdropScaffoldState, float f2, int i, Shape shape, long j, long j2, float f3, int i2, float f4, float f5, Function2<? super Composer, ? super Integer, Unit> function22, long j3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$modifier = modifier;
        this.$backLayer = function2;
        this.$calculateBackLayerConstraints = function1;
        this.$headerHeightPx = f;
        this.$stickyFrontLayer = z;
        this.$gesturesEnabled = z2;
        this.$scaffoldState = backdropScaffoldState;
        this.$peekHeightPx = f2;
        this.$$dirty = i;
        this.$frontLayerShape = shape;
        this.$frontLayerBackgroundColor = j;
        this.$frontLayerContentColor = j2;
        this.$frontLayerElevation = f3;
        this.$$dirty1 = i2;
        this.$headerHeight = f4;
        this.$peekHeight = f5;
        this.$frontLayerContent = function22;
        this.$frontLayerScrimColor = j3;
        this.$snackbarHost = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            composer2.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer2, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
            composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.$backLayer;
            Function1<Constraints, Constraints> function1 = this.$calculateBackLayerConstraints;
            final float f = this.$headerHeightPx;
            final boolean z = this.$stickyFrontLayer;
            final boolean z2 = this.$gesturesEnabled;
            final BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
            final float f2 = this.$peekHeightPx;
            final int i2 = this.$$dirty;
            final Shape shape = this.$frontLayerShape;
            final long j = this.$frontLayerBackgroundColor;
            AnonymousClass1 r4 = r6;
            final long j2 = this.$frontLayerContentColor;
            final float f3 = this.$frontLayerElevation;
            final int i3 = this.$$dirty1;
            final float f4 = this.$headerHeight;
            final float f5 = this.$peekHeight;
            final Function2<Composer, Integer, Unit> function22 = this.$frontLayerContent;
            final long j3 = this.$frontLayerScrimColor;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function3 = this.$snackbarHost;
            AnonymousClass1 r6 = new Function4<Constraints, Float, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m1133invokejYbf7pk(((Constraints) obj).m4630unboximpl(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:43:0x0209  */
                /* JADX WARNING: Removed duplicated region for block: B:46:0x0215  */
                /* JADX WARNING: Removed duplicated region for block: B:47:0x0219  */
                /* renamed from: invoke-jYbf7pk  reason: not valid java name */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void m1133invokejYbf7pk(long r32, float r34, androidx.compose.runtime.Composer r35, int r36) {
                    /*
                        r31 = this;
                        r0 = r31
                        r1 = r34
                        r13 = r35
                        java.lang.String r2 = "CP(1:c#ui.unit.Constraints)344@15194L57,342@15132L942,366@16117L420:BackdropScaffold.kt#jmzs0o"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
                        r2 = r36 & 14
                        r3 = 2
                        r4 = r32
                        if (r2 != 0) goto L_0x001e
                        boolean r2 = r13.changed((long) r4)
                        if (r2 == 0) goto L_0x001a
                        r2 = 4
                        goto L_0x001b
                    L_0x001a:
                        r2 = 2
                    L_0x001b:
                        r2 = r36 | r2
                        goto L_0x0020
                    L_0x001e:
                        r2 = r36
                    L_0x0020:
                        r6 = r36 & 112(0x70, float:1.57E-43)
                        if (r6 != 0) goto L_0x0030
                        boolean r6 = r13.changed((float) r1)
                        if (r6 == 0) goto L_0x002d
                        r6 = 32
                        goto L_0x002f
                    L_0x002d:
                        r6 = 16
                    L_0x002f:
                        r2 = r2 | r6
                    L_0x0030:
                        r2 = r2 & 731(0x2db, float:1.024E-42)
                        r6 = 146(0x92, float:2.05E-43)
                        if (r2 != r6) goto L_0x0042
                        boolean r2 = r35.getSkipping()
                        if (r2 != 0) goto L_0x003d
                        goto L_0x0042
                    L_0x003d:
                        r35.skipToGroupEnd()
                        goto L_0x029a
                    L_0x0042:
                        int r2 = androidx.compose.ui.unit.Constraints.m4623getMaxHeightimpl(r32)
                        float r14 = (float) r2
                        float r2 = r7
                        float r2 = r14 - r2
                        boolean r4 = r8
                        if (r4 == 0) goto L_0x0053
                        float r2 = java.lang.Math.min(r2, r1)
                    L_0x0053:
                        r15 = r2
                        boolean r1 = r9
                        r2 = 0
                        if (r1 == 0) goto L_0x0068
                        androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r4 = r4.getNestedScrollConnection$material_release()
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r1, r4, r2, r3, r2)
                        goto L_0x006c
                    L_0x0068:
                        androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
                    L_0x006c:
                        androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r16 = r4.then(r1)
                        androidx.compose.material.BackdropScaffoldState r1 = r10
                        r17 = r1
                        androidx.compose.material.SwipeableState r17 = (androidx.compose.material.SwipeableState) r17
                        kotlin.Pair[] r1 = new kotlin.Pair[r3]
                        float r3 = r11
                        java.lang.Float r3 = java.lang.Float.valueOf(r3)
                        androidx.compose.material.BackdropValue r4 = androidx.compose.material.BackdropValue.Concealed
                        kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
                        r12 = 0
                        r1[r12] = r3
                        java.lang.Float r3 = java.lang.Float.valueOf(r15)
                        androidx.compose.material.BackdropValue r4 = androidx.compose.material.BackdropValue.Revealed
                        kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
                        r11 = 1
                        r1[r11] = r3
                        java.util.Map r18 = kotlin.collections.MapsKt.mapOf(r1)
                        androidx.compose.foundation.gestures.Orientation r19 = androidx.compose.foundation.gestures.Orientation.Vertical
                        boolean r1 = r9
                        r21 = 0
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 496(0x1f0, float:6.95E-43)
                        r27 = 0
                        r20 = r1
                        androidx.compose.ui.Modifier r1 = androidx.compose.material.SwipeableKt.m1430swipeablepPrIpRY$default(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1 r3 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        kotlinx.coroutines.CoroutineScope r5 = r21
                        r3.<init>(r4, r5)
                        kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                        androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r12, r3, r11, r2)
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        androidx.compose.material.BackdropScaffoldState r3 = r10
                        r4 = 1157296644(0x44faf204, float:2007.563)
                        r13.startReplaceableGroup(r4)
                        java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
                        boolean r4 = r13.changed((java.lang.Object) r3)
                        java.lang.Object r5 = r35.rememberedValue()
                        if (r4 != 0) goto L_0x00e4
                        androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r4 = r4.getEmpty()
                        if (r5 != r4) goto L_0x00ef
                    L_0x00e4:
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                        r4.<init>(r3)
                        r5 = r4
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        r13.updateRememberedValue(r5)
                    L_0x00ef:
                        r35.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r5)
                        androidx.compose.ui.Modifier r1 = r2.then(r1)
                        androidx.compose.ui.graphics.Shape r2 = r13
                        long r3 = r14
                        long r5 = r16
                        float r8 = r18
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2 r10 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2
                        float r12 = r22
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r7 = r23
                        int r9 = r12
                        r17 = r12
                        long r11 = r24
                        r26 = r15
                        androidx.compose.material.BackdropScaffoldState r15 = r10
                        r27 = r14
                        int r14 = r19
                        r28 = r8
                        boolean r8 = r9
                        r29 = r5
                        kotlinx.coroutines.CoroutineScope r5 = r21
                        r16 = r10
                        r18 = r7
                        r19 = r9
                        r20 = r11
                        r22 = r15
                        r23 = r14
                        r24 = r8
                        r25 = r5
                        r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25)
                        r5 = -1065299503(0xffffffffc080d1d1, float:-4.0256124)
                        r11 = 1
                        androidx.compose.runtime.internal.ComposableLambda r5 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r5, r11, r10)
                        r9 = r5
                        kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                        r5 = 1572864(0x180000, float:2.204052E-39)
                        int r6 = r19
                        int r7 = r6 >> 3
                        r7 = r7 & 112(0x70, float:1.57E-43)
                        r5 = r5 | r7
                        int r7 = r6 >> 6
                        r7 = r7 & 896(0x380, float:1.256E-42)
                        r5 = r5 | r7
                        int r7 = r6 >> 6
                        r7 = r7 & 7168(0x1c00, float:1.0045E-41)
                        r5 = r5 | r7
                        r7 = 458752(0x70000, float:6.42848E-40)
                        r14 = 6
                        int r6 = r6 << r14
                        r6 = r6 & r7
                        r12 = r5 | r6
                        r15 = 16
                        r5 = r29
                        r7 = 0
                        r8 = r28
                        r10 = r35
                        r16 = 1
                        r11 = r12
                        r14 = 0
                        r12 = r15
                        androidx.compose.material.SurfaceKt.m1419SurfaceFjzlyU(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
                        androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                        r2 = r1
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        r3 = 0
                        r4 = 0
                        r5 = 0
                        androidx.compose.material.BackdropScaffoldState r1 = r10
                        boolean r1 = r1.isRevealed()
                        if (r1 == 0) goto L_0x0189
                        float r1 = r7
                        float r1 = r27 - r1
                        int r1 = (r26 > r1 ? 1 : (r26 == r1 ? 0 : -1))
                        if (r1 != 0) goto L_0x0183
                        r12 = 1
                        goto L_0x0184
                    L_0x0183:
                        r12 = 0
                    L_0x0184:
                        if (r12 == 0) goto L_0x0189
                        float r1 = r20
                        goto L_0x018e
                    L_0x0189:
                        float r1 = (float) r14
                        float r1 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r1)
                    L_0x018e:
                        r6 = r1
                        r7 = 7
                        r8 = 0
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r2, r3, r4, r5, r6, r7, r8)
                        androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r2 = r2.getBottomCenter()
                        kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r26
                        androidx.compose.material.BackdropScaffoldState r4 = r10
                        int r5 = r19
                        r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r13.startReplaceableGroup(r6)
                        java.lang.String r6 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
                        r6 = 6
                        androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r14, r13, r6)
                        r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r13.startReplaceableGroup(r6)
                        java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r6)
                        androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
                        r7 = 2023513938(0x789c5f52, float:2.5372864E34)
                        java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r8)
                        java.lang.Object r6 = r13.consume(r6)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
                        androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
                        androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r8)
                        java.lang.Object r9 = r13.consume(r9)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
                        androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
                        androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
                        androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r7, r8)
                        java.lang.Object r7 = r13.consume(r10)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r35)
                        androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
                        androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
                        kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
                        androidx.compose.runtime.Applier r10 = r35.getApplier()
                        boolean r10 = r10 instanceof androidx.compose.runtime.Applier
                        if (r10 != 0) goto L_0x020c
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x020c:
                        r35.startReusableNode()
                        boolean r10 = r35.getInserting()
                        if (r10 == 0) goto L_0x0219
                        r13.createNode(r8)
                        goto L_0x021c
                    L_0x0219:
                        r35.useNode()
                    L_0x021c:
                        r35.disableReusing()
                        androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m1543constructorimpl(r35)
                        androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r10 = r10.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r2, r10)
                        androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
                        androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r6, r2)
                        androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r9, r2)
                        androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
                        androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r8, r7, r2)
                        r35.enableReusing()
                        androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r35)
                        androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
                        java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
                        r1.invoke(r2, r13, r6)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r13.startReplaceableGroup(r1)
                        r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
                        r13.startReplaceableGroup(r1)
                        java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
                        androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
                        r1 = 1815906203(0x6c3c879b, float:9.116737E26)
                        r13.startReplaceableGroup(r1)
                        java.lang.String r1 = "C375@16478L45:BackdropScaffold.kt#jmzs0o"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
                        androidx.compose.material.SnackbarHostState r1 = r4.getSnackbarHostState()
                        int r2 = r5 >> 18
                        r2 = r2 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                        r3.invoke(r1, r13, r2)
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                        r35.endNode()
                        r35.endReplaceableGroup()
                        r35.endReplaceableGroup()
                    L_0x029a:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m1133invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                }
            };
            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda(composer2, 1800047509, true, r4), composer, 3120);
            return;
        }
        composer.skipToGroupEnd();
    }
}
