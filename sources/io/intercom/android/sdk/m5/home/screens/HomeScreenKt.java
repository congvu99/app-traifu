package io.intercom.android.sdk.m5.home.screens;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"ANIMATION_DURATION", "", "HomeScreen", "", "homeViewModel", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel;", "topPadding", "Landroidx/compose/ui/unit/Dp;", "onMessagesClicked", "Lkotlin/Function0;", "onHelpClicked", "navigateToMessages", "onNewConversationClicked", "onConversationClicked", "Lkotlin/Function1;", "Lio/intercom/android/sdk/models/Conversation;", "onCloseClick", "HomeScreen-jfnsLPA", "(Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewModel;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
public final class HomeScreenKt {
    private static final int ANIMATION_DURATION = 600;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: HomeScreen-jfnsLPA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5223HomeScreenjfnsLPA(io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel r35, float r36, kotlin.jvm.functions.Function0<kotlin.Unit> r37, kotlin.jvm.functions.Function0<kotlin.Unit> r38, kotlin.jvm.functions.Function0<kotlin.Unit> r39, kotlin.jvm.functions.Function0<kotlin.Unit> r40, kotlin.jvm.functions.Function1<? super io.intercom.android.sdk.models.Conversation, kotlin.Unit> r41, kotlin.jvm.functions.Function0<kotlin.Unit> r42, androidx.compose.runtime.Composer r43, int r44) {
        /*
            r1 = r35
            r5 = r39
            r13 = r42
            java.lang.String r0 = "homeViewModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onMessagesClicked"
            r3 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onHelpClicked"
            r4 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "navigateToMessages"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "onNewConversationClicked"
            r2 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "onConversationClicked"
            r15 = r41
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onCloseClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 289970958(0x11489b0e, float:1.5824998E-28)
            r6 = r43
            androidx.compose.runtime.Composer r0 = r6.startRestartGroup(r0)
            kotlinx.coroutines.flow.StateFlow r6 = r35.getState()
            r14 = 0
            r12 = 8
            r11 = 1
            androidx.compose.runtime.State r26 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r14, r0, r12, r11)
            kotlinx.coroutines.flow.StateFlow r6 = r35.getIntercomBadgeState()
            androidx.compose.runtime.State r27 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r14, r0, r12, r11)
            kotlinx.coroutines.flow.StateFlow r6 = r35.getHeaderState()
            androidx.compose.runtime.State r10 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r14, r0, r12, r11)
            r9 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            androidx.compose.foundation.ScrollState r28 = androidx.compose.foundation.ScrollKt.rememberScrollState(r9, r0, r9, r11)
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            java.lang.Object r6 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            r11 = 2
            r9 = 0
            if (r6 != r7) goto L_0x0083
            java.lang.Float r6 = java.lang.Float.valueOf(r9)
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r14, r11, r14)
            r0.updateRememberedValue(r6)
        L_0x0083:
            r0.endReplaceableGroup()
            r7 = r6
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$1 r6 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$1
            r6.<init>(r1, r5, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r12 = 70
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r14, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r6, (androidx.compose.runtime.Composer) r0, (int) r12)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.WindowInsetsPadding_androidKt.navigationBarsPadding(r6)
            r12 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r12)
            java.lang.String r9 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r9)
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r16.getTopStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r11, r0, r11)
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r3 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r4 = r16
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            java.lang.Object r4 = r0.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r5 = r16
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r3)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r16 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r16.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r31 = r9
            androidx.compose.runtime.Applier r9 = r0.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0116
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0116:
            r0.startReusableNode()
            boolean r9 = r0.getInserting()
            if (r9 == 0) goto L_0x0123
            r0.createNode(r2)
            goto L_0x0126
        L_0x0123:
            r0.useNode()
        L_0x0126:
            r0.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r12, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r14, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r4, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r2, r5, r4)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r2)
            r6.invoke(r2, r0, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r4)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r6 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r14 = r6
            androidx.compose.foundation.layout.BoxScope r14 = (androidx.compose.foundation.layout.BoxScope) r14
            java.lang.Object r6 = r10.getValue()
            boolean r6 = r6 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent
            r17 = 0
            r12 = 600(0x258, float:8.41E-43)
            r9 = 6
            r2 = 0
            r4 = 0
            androidx.compose.animation.core.TweenSpec r16 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r4, r2, r9, r2)
            r32 = r14
            r14 = r16
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r33 = r5
            r5 = 0
            r15 = 2
            androidx.compose.animation.EnterTransition r18 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r5, r15, r2)
            androidx.compose.animation.core.TweenSpec r14 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r4, r2, r9, r2)
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            androidx.compose.animation.ExitTransition r19 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r5, r15, r2)
            r20 = 0
            r2 = 666201196(0x27b56c6c, float:5.0355143E-15)
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$1 r4 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$1
            r4.<init>(r10, r1, r7)
            r5 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r5, r4)
            r21 = r2
            kotlin.jvm.functions.Function3 r21 = (kotlin.jvm.functions.Function3) r21
            r23 = 200064(0x30d80, float:2.8035E-40)
            r24 = 18
            r16 = r6
            r22 = r0
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r16, (androidx.compose.ui.Modifier) r17, (androidx.compose.animation.EnterTransition) r18, (androidx.compose.animation.ExitTransition) r19, (java.lang.String) r20, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r4 = 0
            r5 = 1
            r6 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r2, r4, r5, r6)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            r22 = 0
            r17 = r28
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ScrollKt.verticalScroll$default(r16, r17, r18, r19, r20, r21, r22)
            r4 = -483455358(0xffffffffe32f0e82, float:-3.2292256E21)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            androidx.compose.foundation.layout.Arrangement r4 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r4 = r4.getTop()
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r6 = r6.getStart()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r4 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r4, r6, r0, r14)
            r14 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r3)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r5 = r16
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r3)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r16
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r15, r3)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r9 = r0.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x024f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x024f:
            r0.startReusableNode()
            boolean r9 = r0.getInserting()
            if (r9 == 0) goto L_0x025c
            r0.createNode(r15)
            goto L_0x025f
        L_0x025c:
            r0.useNode()
        L_0x025f:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r4, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r6, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r5, r4)
            androidx.compose.ui.node.ComposeUiNode$Companion r4 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r4 = r4.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r9, r14, r4)
            r0.enableReusing()
            androidx.compose.runtime.Composer r4 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r4 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r4)
            r2.invoke(r4, r0, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -1163856341(0xffffffffbaa0f62b, float:-0.0012280395)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@4027L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.ColumnScopeInstance r2 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r2 = (androidx.compose.foundation.layout.ColumnScope) r2
            java.lang.Object r4 = r10.getValue()
            boolean r4 = r4 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent
            r18 = 0
            r5 = 6
            r6 = 0
            r9 = 0
            androidx.compose.animation.core.TweenSpec r14 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r9, r6, r5, r6)
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            r1 = 0
            r15 = 2
            androidx.compose.animation.EnterTransition r19 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r14, r1, r15, r6)
            androidx.compose.animation.core.TweenSpec r14 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r12, r9, r6, r5, r6)
            androidx.compose.animation.core.FiniteAnimationSpec r14 = (androidx.compose.animation.core.FiniteAnimationSpec) r14
            androidx.compose.animation.ExitTransition r20 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r14, r1, r15, r6)
            r21 = 0
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$1 r6 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$1
            r16 = r6
            r29 = r7
            r7 = r28
            r1 = r8
            r8 = r29
            r5 = r31
            r9 = r10
            r30 = r10
            r10 = r36
            r15 = r11
            r14 = 1
            r11 = r42
            r12 = r44
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r7 = r16
            r6 = 485841634(0x1cf55ae2, float:1.6236233E-21)
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r14, r7)
            r22 = r6
            kotlin.jvm.functions.Function3 r22 = (kotlin.jvm.functions.Function3) r22
            r6 = 1600518(0x186c06, float:2.242803E-39)
            r25 = 18
            r16 = r2
            r17 = r4
            r23 = r0
            r24 = r6
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((androidx.compose.foundation.layout.ColumnScope) r16, (boolean) r17, (androidx.compose.ui.Modifier) r18, (androidx.compose.animation.EnterTransition) r19, (androidx.compose.animation.ExitTransition) r20, (java.lang.String) r21, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25)
            java.lang.Object r4 = r26.getValue()
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState r4 = (io.intercom.android.sdk.m5.home.viewmodel.HomeViewState) r4
            boolean r7 = r4 instanceof io.intercom.android.sdk.m5.home.viewmodel.HomeViewState.Error
            r19 = 0
            r20 = 0
            r8 = 637559449(0x26006299, float:4.4542546E-16)
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$2 r9 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$2
            r9.<init>(r4)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r14, r9)
            r22 = r8
            kotlin.jvm.functions.Function3 r22 = (kotlin.jvm.functions.Function3) r22
            r8 = 1572870(0x180006, float:2.20406E-39)
            r25 = 30
            r17 = r7
            r24 = r8
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((androidx.compose.foundation.layout.ColumnScope) r16, (boolean) r17, (androidx.compose.ui.Modifier) r18, (androidx.compose.animation.EnterTransition) r19, (androidx.compose.animation.ExitTransition) r20, (java.lang.String) r21, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25)
            boolean r7 = r4 instanceof io.intercom.android.sdk.m5.home.viewmodel.HomeViewState.Loading
            androidx.compose.animation.ExitTransition$Companion r9 = androidx.compose.animation.ExitTransition.Companion
            androidx.compose.animation.ExitTransition r20 = r9.getNone()
            io.intercom.android.sdk.m5.home.screens.ComposableSingletons$HomeScreenKt r9 = io.intercom.android.sdk.m5.home.screens.ComposableSingletons$HomeScreenKt.INSTANCE
            kotlin.jvm.functions.Function3 r22 = r9.m5222getLambda1$intercom_sdk_base_release()
            r25 = 22
            r17 = r7
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((androidx.compose.foundation.layout.ColumnScope) r16, (boolean) r17, (androidx.compose.ui.Modifier) r18, (androidx.compose.animation.EnterTransition) r19, (androidx.compose.animation.ExitTransition) r20, (java.lang.String) r21, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (androidx.compose.runtime.Composer) r23, (int) r24, (int) r25)
            boolean r7 = r4 instanceof io.intercom.android.sdk.m5.home.viewmodel.HomeViewState.Content
            r9 = 4
            r10 = 600(0x258, float:8.41E-43)
            r11 = 0
            androidx.compose.animation.core.TweenSpec r9 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r10, r11, r9, r11)
            androidx.compose.animation.core.FiniteAnimationSpec r9 = (androidx.compose.animation.core.FiniteAnimationSpec) r9
            r6 = 0
            r12 = 2
            androidx.compose.animation.EnterTransition r9 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r9, r6, r12, r11)
            r6 = 0
            r8 = 6
            androidx.compose.animation.core.TweenSpec r10 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r10, r6, r11, r8, r11)
            androidx.compose.animation.core.FiniteAnimationSpec r10 = (androidx.compose.animation.core.FiniteAnimationSpec) r10
            r14 = 0
            androidx.compose.animation.ExitTransition r10 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r10, r14, r12, r11)
            r14 = -1492375013(0xffffffffa70c2a1b, float:-1.9451728E-15)
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$3 r11 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$2$3
            r6 = r32
            r8 = -1492375013(0xffffffffa70c2a1b, float:-1.9451728E-15)
            r12 = 1
            r14 = r11
            r34 = r15
            r15 = r4
            r16 = r30
            r17 = r37
            r18 = r38
            r19 = r40
            r20 = r41
            r21 = r44
            r14.<init>(r15, r16, r17, r18, r19, r20, r21)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r12, r11)
            r20 = r4
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            r4 = 18
            r14 = r2
            r15 = r7
            r2 = 0
            r16 = r2
            r17 = r9
            r18 = r10
            r2 = 0
            r19 = r2
            r21 = r0
            r2 = 1600518(0x186c06, float:2.242803E-39)
            r22 = r2
            r23 = r4
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((androidx.compose.foundation.layout.ColumnScope) r14, (boolean) r15, (androidx.compose.ui.Modifier) r16, (androidx.compose.animation.EnterTransition) r17, (androidx.compose.animation.ExitTransition) r18, (java.lang.String) r19, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r20, (androidx.compose.runtime.Composer) r21, (int) r22, (int) r23)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r4 = 100
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r4)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m568height3ABfNKs(r2, r4)
            r4 = 6
            androidx.compose.foundation.layout.SpacerKt.Spacer(r2, r0, r4)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r4, r3)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r4 = r27.getValue()
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState r4 = (io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState) r4
            r7 = 407834885(0x184f1105, float:2.6762716E-24)
            r0.startReplaceableGroup(r7)
            boolean r7 = r4 instanceof io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState.Shown
            if (r7 == 0) goto L_0x041a
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r14 = r7
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            r15 = 0
            r16 = 0
            r17 = 0
            r7 = 24
            float r7 = (float) r7
            float r18 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r19 = 7
            r20 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m514paddingqDBjuR0$default(r14, r15, r16, r17, r18, r19, r20)
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r8 = r8.getBottomCenter()
            androidx.compose.ui.Modifier r7 = r6.align(r7, r8)
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$3 r8 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$3
            r8.<init>(r4, r2)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r2 = 0
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeKt.IntercomBadge(r8, r7, r0, r2, r2)
            goto L_0x041f
        L_0x041a:
            io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState$Hidden r2 = io.intercom.android.sdk.m5.components.intercombadge.IntercomBadgeState.Hidden.INSTANCE
            kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r2)
        L_0x041f:
            r0.endReplaceableGroup()
            java.lang.Object r2 = r30.getValue()
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState r2 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState) r2
            boolean r4 = r2 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Expanded
            if (r4 == 0) goto L_0x0604
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$HeaderContent$Expanded r2 = (io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Expanded) r2
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$CloseButtonColor r2 = r2.getCloseButtonColor()
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            r7 = 14
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            float r7 = r7 + r36
            float r7 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r7)
            r8 = -16
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r8)
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.OffsetKt.m496offsetVpY3zN4(r4, r8, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopEnd()
            androidx.compose.ui.Modifier r4 = r6.align(r4, r7)
            androidx.compose.material.MaterialTheme r6 = androidx.compose.material.MaterialTheme.INSTANCE
            r7 = 8
            androidx.compose.material.Shapes r6 = r6.getShapes(r0, r7)
            androidx.compose.foundation.shape.CornerBasedShape r6 = r6.getSmall()
            androidx.compose.ui.graphics.Shape r6 = (androidx.compose.ui.graphics.Shape) r6
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.draw.ClipKt.clip(r4, r6)
            r6 = 30
            float r6 = (float) r6
            float r6 = androidx.compose.ui.unit.Dp.m4704constructorimpl(r6)
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.m582size3ABfNKs(r4, r6)
            r15 = 0
            r16 = 0
            r17 = 0
            r4 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            boolean r4 = r0.changed((java.lang.Object) r13)
            java.lang.Object r6 = r0.rememberedValue()
            if (r4 != 0) goto L_0x0497
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x04a2
        L_0x0497:
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$4$1$1 r4 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$4$1$1
            r4.<init>(r13)
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r0.updateRememberedValue(r6)
        L_0x04a2:
            r0.endReplaceableGroup()
            r18 = r6
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 7
            r20 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.ClickableKt.m196clickableXHw0xAI$default(r14, r15, r16, r17, r18, r19, r20)
            r6 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r6, r0, r6)
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r6)
            r6 = r34
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r3)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r3)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r3)
            java.lang.Object r3 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r3 = (androidx.compose.ui.platform.ViewConfiguration) r3
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r4 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            androidx.compose.runtime.Applier r9 = r0.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x051e
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x051e:
            r0.startReusableNode()
            boolean r9 = r0.getInserting()
            if (r9 == 0) goto L_0x052b
            r0.createNode(r7)
            goto L_0x052e
        L_0x052b:
            r0.useNode()
        L_0x052e:
            r0.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m1543constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r9 = r9.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r5, r9)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r8, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1550setimpl((androidx.compose.runtime.Composer) r7, r3, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m1534constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m1533boximpl(r3)
            r4.invoke(r3, r0, r1)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r0.startReplaceableGroup(r1)
            r1 = r33
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            int r3 = r28.getValue()
            double r3 = (double) r3
            java.lang.Object r5 = r29.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            r7 = 4603579539098121011(0x3fe3333333333333, double:0.6)
            double r5 = r5 * r7
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0598
            r14 = 1
            goto L_0x0599
        L_0x0598:
            r14 = 0
        L_0x0599:
            r15 = 0
            r3 = 3
            r4 = 0
            r5 = 0
            androidx.compose.animation.EnterTransition r16 = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(r5, r4, r3, r5)
            androidx.compose.animation.ExitTransition r17 = androidx.compose.animation.EnterExitTransitionKt.fadeOut$default(r5, r4, r3, r5)
            r18 = 0
            r3 = 796718624(0x2f7cf620, float:2.3006708E-10)
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$4$2$1 r4 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$2$4$2$1
            r4.<init>(r1, r2)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r3, r12, r4)
            r19 = r3
            kotlin.jvm.functions.Function3 r19 = (kotlin.jvm.functions.Function3) r19
            r21 = 200064(0x30d80, float:2.8035E-40)
            r22 = 18
            r20 = r0
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility((boolean) r14, (androidx.compose.ui.Modifier) r15, (androidx.compose.animation.EnterTransition) r16, (androidx.compose.animation.ExitTransition) r17, (java.lang.String) r18, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getCenter()
            androidx.compose.ui.Modifier r16 = r1.align(r3, r4)
            androidx.compose.material.icons.Icons r1 = androidx.compose.material.icons.Icons.INSTANCE
            androidx.compose.material.icons.Icons$Filled r1 = r1.getDefault()
            androidx.compose.ui.graphics.vector.ImageVector r14 = androidx.compose.material.icons.filled.CloseKt.getClose(r1)
            int r1 = io.intercom.android.sdk.R.string.intercom_close
            r3 = 0
            java.lang.String r15 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r0, r3)
            java.lang.String r1 = r2.getForegroundColor()
            r2 = 0
            long r17 = io.intercom.android.sdk.utilities.ColorExtensionsKt.toComposeColor$default(r1, r2, r12, r5)
            r20 = 0
            r21 = 0
            r19 = r0
            androidx.compose.material.IconKt.m1314Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r14, (java.lang.String) r15, (androidx.compose.ui.Modifier) r16, (long) r17, (androidx.compose.runtime.Composer) r19, (int) r20, (int) r21)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x060e
        L_0x0604:
            io.intercom.android.sdk.m5.home.viewmodel.HeaderState$NoHeader r1 = io.intercom.android.sdk.m5.home.viewmodel.HeaderState.NoHeader.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x060e
            boolean r1 = r2 instanceof io.intercom.android.sdk.m5.home.viewmodel.HeaderState.HeaderContent.Reduced
        L_0x060e:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0624
            goto L_0x0641
        L_0x0624:
            io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$3 r11 = new io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$3
            r0 = r11
            r1 = r35
            r2 = r36
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = r42
            r9 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x0641:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.screens.HomeScreenKt.m5223HomeScreenjfnsLPA(io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel, float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }
}
