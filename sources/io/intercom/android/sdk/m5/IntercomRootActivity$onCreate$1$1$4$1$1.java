package io.intercom.android.sdk.m5;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import io.intercom.android.sdk.m5.IntercomScreenScenario;
import io.intercom.android.sdk.m5.helpcenter.HelpCenterScreenKt;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$4$1$1 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ IntercomScreenScenario $scenario;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableState<Float> $sheetHeightAsState;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    final /* synthetic */ IntercomRootActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$4$1$1(IntercomRootActivity intercomRootActivity, ModalBottomSheetState modalBottomSheetState, MutableState<Float> mutableState, NavHostController navHostController, CoroutineScope coroutineScope, IntercomScreenScenario intercomScreenScenario) {
        super(1);
        this.this$0 = intercomRootActivity;
        this.$sheetState = modalBottomSheetState;
        this.$sheetHeightAsState = mutableState;
        this.$navController = navHostController;
        this.$scope = coroutineScope;
        this.$scenario = intercomScreenScenario;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavGraphBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$NavHost");
        String name = IntercomDestination.HOME.name();
        final IntercomRootActivity intercomRootActivity = this.this$0;
        final ModalBottomSheetState modalBottomSheetState = this.$sheetState;
        final MutableState<Float> mutableState = this.$sheetHeightAsState;
        final NavHostController navHostController = this.$navController;
        final CoroutineScope coroutineScope = this.$scope;
        NavGraphBuilderKt.composable$default(navGraphBuilder, name, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(-1116319639, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(androidx.navigation.NavBackStackEntry r13, androidx.compose.runtime.Composer r14, int r15) {
                /*
                    r12 = this;
                    java.lang.String r15 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r15)
                    io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$Companion r13 = io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel.Companion
                    io.intercom.android.sdk.m5.IntercomRootActivity r15 = r4
                    androidx.lifecycle.ViewModelStoreOwner r15 = (androidx.lifecycle.ViewModelStoreOwner) r15
                    io.intercom.android.sdk.Injector r0 = io.intercom.android.sdk.Injector.get()
                    io.intercom.android.sdk.api.MessengerApi r0 = r0.getMessengerApi()
                    java.lang.String r1 = "get().messengerApi"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel r2 = r13.create(r15, r0)
                    androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
                    androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
                    r15 = 2023513938(0x789c5f52, float:2.5372864E34)
                    java.lang.String r0 = "C:CompositionLocal.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r0)
                    java.lang.Object r13 = r14.consume(r13)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                    androidx.lifecycle.LifecycleOwner r13 = (androidx.lifecycle.LifecycleOwner) r13
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$1 r1 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$1
                    r1.<init>(r13, r2)
                    kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                    r3 = 8
                    androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r14, (int) r3)
                    androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                    androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r15, r0)
                    java.lang.Object r13 = r14.consume(r13)
                    androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                    androidx.compose.material.ModalBottomSheetState r15 = r5
                    androidx.compose.runtime.MutableState<java.lang.Float> r0 = r6
                    androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
                    androidx.compose.foundation.layout.WindowInsets$Companion r1 = androidx.compose.foundation.layout.WindowInsets.Companion
                    androidx.compose.foundation.layout.WindowInsets r1 = androidx.compose.foundation.layout.WindowInsets_androidKt.getSystemBars(r1, r14, r3)
                    int r1 = r1.getTop(r13)
                    float r15 = io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt.getEquivalentTopPadding(r15, r1, r0)
                    float r3 = r13.m4645toDpu2uoSUM((float) r15)
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$3 r13 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$3
                    androidx.navigation.NavHostController r15 = r7
                    r13.<init>(r15)
                    r4 = r13
                    kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$4 r13 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$4
                    androidx.navigation.NavHostController r15 = r7
                    r13.<init>(r15)
                    r5 = r13
                    kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$5 r13 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$5
                    androidx.navigation.NavHostController r15 = r7
                    r13.<init>(r15)
                    r6 = r13
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                    io.intercom.android.sdk.m5.IntercomRootActivity r13 = r4
                    r15 = 1157296644(0x44faf204, float:2007.563)
                    r14.startReplaceableGroup(r15)
                    java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                    boolean r1 = r14.changed((java.lang.Object) r13)
                    java.lang.Object r7 = r14.rememberedValue()
                    if (r1 != 0) goto L_0x00a4
                    androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r1 = r1.getEmpty()
                    if (r7 != r1) goto L_0x00af
                L_0x00a4:
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$6$1 r1 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$6$1
                    r1.<init>(r13)
                    r7 = r1
                    kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                    r14.updateRememberedValue(r7)
                L_0x00af:
                    r14.endReplaceableGroup()
                    kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                    io.intercom.android.sdk.m5.IntercomRootActivity r13 = r4
                    r14.startReplaceableGroup(r15)
                    androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                    boolean r15 = r14.changed((java.lang.Object) r13)
                    java.lang.Object r0 = r14.rememberedValue()
                    if (r15 != 0) goto L_0x00ce
                    androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r15 = r15.getEmpty()
                    if (r0 != r15) goto L_0x00d9
                L_0x00ce:
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$7$1 r15 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$7$1
                    r15.<init>(r13)
                    r0 = r15
                    kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
                    r14.updateRememberedValue(r0)
                L_0x00d9:
                    r14.endReplaceableGroup()
                    r8 = r0
                    kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$8 r13 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$8
                    kotlinx.coroutines.CoroutineScope r15 = r8
                    androidx.compose.material.ModalBottomSheetState r0 = r5
                    io.intercom.android.sdk.m5.IntercomRootActivity r1 = r4
                    r13.<init>(r15, r0, r1)
                    r9 = r13
                    kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                    r11 = 8
                    r10 = r14
                    io.intercom.android.sdk.m5.home.screens.HomeScreenKt.m5223HomeScreenjfnsLPA(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$9 r13 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$1$9
                    r15 = 0
                    r13.<init>(r15)
                    kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
                    r15 = 70
                    java.lang.String r0 = ""
                    androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r13, (androidx.compose.runtime.Composer) r14, (int) r15)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1.AnonymousClass1.invoke(androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
            }
        }), 6, (Object) null);
        String name2 = IntercomDestination.MESSAGES.name();
        final IntercomRootActivity intercomRootActivity2 = this.this$0;
        final NavHostController navHostController2 = this.$navController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, name2, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(-235425262, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(androidx.navigation.NavBackStackEntry r10, androidx.compose.runtime.Composer r11, int r12) {
                /*
                    r9 = this;
                    java.lang.String r12 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r12)
                    io.intercom.android.sdk.inbox.IntercomInboxViewModel$Companion r10 = io.intercom.android.sdk.inbox.IntercomInboxViewModel.Companion
                    io.intercom.android.sdk.m5.IntercomRootActivity r12 = r1
                    androidx.lifecycle.ViewModelStoreOwner r12 = (androidx.lifecycle.ViewModelStoreOwner) r12
                    io.intercom.android.sdk.inbox.IntercomInboxViewModel r0 = r10.create(r12)
                    io.intercom.android.sdk.m5.IntercomRootActivity r10 = r1
                    r12 = 1157296644(0x44faf204, float:2007.563)
                    r11.startReplaceableGroup(r12)
                    java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
                    boolean r2 = r11.changed((java.lang.Object) r10)
                    java.lang.Object r3 = r11.rememberedValue()
                    if (r2 != 0) goto L_0x002e
                    androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r2 = r2.getEmpty()
                    if (r3 != r2) goto L_0x0039
                L_0x002e:
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$1$1 r2 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$1$1
                    r2.<init>(r10)
                    r3 = r2
                    kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
                    r11.updateRememberedValue(r3)
                L_0x0039:
                    r11.endReplaceableGroup()
                    r10 = r3
                    kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$2 r2 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$2
                    androidx.navigation.NavHostController r3 = r3
                    r2.<init>(r3)
                    kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$3 r3 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$3
                    androidx.navigation.NavHostController r4 = r3
                    io.intercom.android.sdk.m5.IntercomRootActivity r5 = r1
                    r3.<init>(r4, r5)
                    kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
                    io.intercom.android.sdk.m5.IntercomRootActivity r4 = r1
                    r11.startReplaceableGroup(r12)
                    androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
                    boolean r12 = r11.changed((java.lang.Object) r4)
                    java.lang.Object r1 = r11.rememberedValue()
                    if (r12 != 0) goto L_0x006d
                    androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r12 = r12.getEmpty()
                    if (r1 != r12) goto L_0x0078
                L_0x006d:
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$4$1 r12 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$4$1
                    r12.<init>(r4)
                    r1 = r12
                    kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                    r11.updateRememberedValue(r1)
                L_0x0078:
                    r11.endReplaceableGroup()
                    r4 = r1
                    kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                    r5 = 0
                    r7 = 8
                    r8 = 32
                    r1 = r10
                    r6 = r11
                    io.intercom.android.sdk.m5.inbox.InboxScreenKt.InboxScreen(r0, r1, r2, r3, r4, r5, r6, r7, r8)
                    io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$5 r10 = new io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$2$5
                    r12 = 0
                    r10.<init>(r12)
                    kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                    r12 = 70
                    java.lang.String r0 = ""
                    androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r10, (androidx.compose.runtime.Composer) r11, (int) r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1.AnonymousClass2.invoke(androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):void");
            }
        }), 6, (Object) null);
        String name3 = IntercomDestination.HELP_CENTER.name();
        final IntercomRootActivity intercomRootActivity3 = this.this$0;
        final IntercomScreenScenario intercomScreenScenario = this.$scenario;
        final NavHostController navHostController3 = this.$navController;
        NavGraphBuilderKt.composable$default(navGraphBuilder, name3, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(-1946097743, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                List<String> list;
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                HelpCenterApi helpCenterApi = Injector.get().getHelpCenterApi();
                Intrinsics.checkNotNullExpressionValue(helpCenterApi, "get().helpCenterApi");
                HelpCenterViewModel create = HelpCenterViewModel.Companion.create(intercomRootActivity3, helpCenterApi, MetricTracker.Place.COLLECTION_LIST);
                IntercomScreenScenario intercomScreenScenario = intercomScreenScenario;
                if (intercomScreenScenario instanceof IntercomScreenScenario.HelpCenterCollections) {
                    list = ((IntercomScreenScenario.HelpCenterCollections) intercomScreenScenario).getCollectionIds();
                } else if (intercomScreenScenario instanceof IntercomScreenScenario.HelpCenterCollection) {
                    list = CollectionsKt.listOf(((IntercomScreenScenario.HelpCenterCollection) intercomScreenScenario).getCollectionId());
                } else {
                    list = CollectionsKt.emptyList();
                }
                final NavHostController navHostController = navHostController3;
                final IntercomRootActivity intercomRootActivity = intercomRootActivity3;
                HelpCenterScreenKt.HelpCenterScreen(create, list, new Function0<Unit>() {
                    public final void invoke() {
                        if (navHostController.getPreviousBackStackEntry() == null) {
                            intercomRootActivity.finish();
                        } else {
                            navHostController.navigateUp();
                        }
                    }
                }, composer, 72);
                EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass2((Continuation<? super AnonymousClass2>) null), composer, 70);
            }

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$3$2", f = "IntercomRootActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$4$1$1$3$2  reason: invalid class name */
            /* compiled from: IntercomRootActivity.kt */
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        ResultKt.throwOnFailure(obj);
                        Injector.get().getMetricTracker().viewedSpace("help");
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }), 6, (Object) null);
    }
}
