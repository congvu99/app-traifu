package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Magnifier.kt */
final class MagnifierKt$magnifier$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<Density, Offset> $magnifierCenter;
    final /* synthetic */ Function1<DpSize, Unit> $onSizeChanged;
    final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
    final /* synthetic */ Function1<Density, Offset> $sourceCenter;
    final /* synthetic */ MagnifierStyle $style;
    final /* synthetic */ float $zoom;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MagnifierKt$magnifier$4(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.$sourceCenter = function1;
        this.$magnifierCenter = function12;
        this.$zoom = f;
        this.$onSizeChanged = function13;
        this.$platformMagnifierFactory = platformMagnifierFactory;
        this.$style = magnifierStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2 = modifier;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
        composer2.startReplaceableGroup(-454877003);
        ComposerKt.sourceInformation(composer2, "C273@11641L7,274@11680L7,275@11728L47,276@11807L34,277@11876L37,278@11937L26,279@11996L35,280@12062L331,290@12422L62,295@12614L107,307@13298L2602,373@15957L344,385@16670L78:Magnifier.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, i, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:272)");
        }
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final View view = (View) consume;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume2;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1672boximpl(Offset.Companion.m1698getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$sourceCenter, composer2, 0);
        final State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$magnifierCenter, composer2, 0);
        final State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.$zoom), composer2, 0);
        final State<T> rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(this.$onSizeChanged, composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, rememberUpdatedState, mutableState));
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        State state = (State) rememberedValue2;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(state));
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        State state2 = (State) rememberedValue3;
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) rememberedValue4;
        float f = this.$platformMagnifierFactory.getCanUpdateZoom() ? 0.0f : this.$zoom;
        MagnifierStyle magnifierStyle = this.$style;
        Object[] objArr = {view, density, Float.valueOf(f), magnifierStyle, Boolean.valueOf(Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault()))};
        final PlatformMagnifierFactory platformMagnifierFactory = this.$platformMagnifierFactory;
        MagnifierStyle magnifierStyle2 = this.$style;
        final float f2 = this.$zoom;
        Object[] objArr2 = objArr;
        final MagnifierStyle magnifierStyle3 = magnifierStyle2;
        State state3 = state;
        final MutableSharedFlow mutableSharedFlow2 = mutableSharedFlow;
        final State state4 = state2;
        final State state5 = state3;
        final MutableState mutableState2 = mutableState;
        EffectsKt.LaunchedEffect(objArr2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer2, 72);
        composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer2.changed((Object) mutableState);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
            rememberedValue5 = new MagnifierKt$magnifier$4$2$1(mutableState);
            composer2.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1) rememberedValue5), new Function1<DrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
                mutableSharedFlow.tryEmit(Unit.INSTANCE);
            }
        });
        composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer2, "C(remember)P(1):Composables.kt#9igjgp");
        State state6 = state3;
        boolean changed2 = composer2.changed((Object) state6);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = new MagnifierKt$magnifier$4$4$1(state6);
            composer2.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) rememberedValue6, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return semantics$default;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final long m237invoke$lambda1(MutableState<Offset> mutableState) {
        return ((Offset) mutableState.getValue()).m1693unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m239invoke$lambda2(MutableState<Offset> mutableState, long j) {
        mutableState.setValue(Offset.m1672boximpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final Function1<Density, Offset> m240invoke$lambda3(State<? extends Function1<? super Density, Offset>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final Function1<Density, Offset> m241invoke$lambda4(State<? extends Function1<? super Density, Offset>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final float m242invoke$lambda5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final Function1<DpSize, Unit> m243invoke$lambda6(State<? extends Function1<? super DpSize, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final long m244invoke$lambda8(State<Offset> state) {
        return state.getValue().m1693unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-10  reason: not valid java name */
    public static final boolean m238invoke$lambda10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", i = {0}, l = {365}, m = "invokeSuspend", n = {"magnifier"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1  reason: invalid class name */
    /* compiled from: Magnifier.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r1 = new AnonymousClass1(platformMagnifierFactory, magnifierStyle3, view, density, f2, mutableSharedFlow2, rememberUpdatedState4, state4, state5, rememberUpdatedState2, mutableState2, rememberUpdatedState3, continuation);
            r1.L$0 = obj;
            return r1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: androidx.compose.foundation.PlatformMagnifier} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.label
                r3 = 1
                if (r2 == 0) goto L_0x0022
                if (r2 != r3) goto L_0x001a
                java.lang.Object r0 = r1.L$0
                r2 = r0
                androidx.compose.foundation.PlatformMagnifier r2 = (androidx.compose.foundation.PlatformMagnifier) r2
                kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0017 }
                goto L_0x009e
            L_0x0017:
                r0 = move-exception
                goto L_0x00a6
            L_0x001a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r20)
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                androidx.compose.foundation.PlatformMagnifierFactory r4 = r7
                androidx.compose.foundation.MagnifierStyle r5 = r8
                android.view.View r6 = r9
                androidx.compose.ui.unit.Density r7 = r10
                float r8 = r11
                androidx.compose.foundation.PlatformMagnifier r4 = r4.create(r5, r6, r7, r8)
                kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
                r5.<init>()
                long r6 = r4.m255getSizeYbymL2g()
                androidx.compose.ui.unit.Density r8 = r10
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r9 = r13
                kotlin.jvm.functions.Function1 r9 = androidx.compose.foundation.MagnifierKt$magnifier$4.m243invoke$lambda6(r9)
                if (r9 == 0) goto L_0x0059
                long r10 = androidx.compose.ui.unit.IntSizeKt.m4874toSizeozmzZPI(r6)
                long r10 = r8.m4647toDpSizekrfVVM(r10)
                androidx.compose.ui.unit.DpSize r8 = androidx.compose.ui.unit.DpSize.m4790boximpl(r10)
                r9.invoke(r8)
            L_0x0059:
                r5.element = r6
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r6 = r12
                kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$1 r7 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$1
                r8 = 0
                r7.<init>(r4, r8)
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onEach(r6, r7)
                kotlinx.coroutines.flow.FlowKt.launchIn(r6, r2)
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$2 r2 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$2     // Catch:{ all -> 0x00a4 }
                androidx.compose.ui.unit.Density r11 = r10     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.State<java.lang.Boolean> r12 = r14     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r13 = r15     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset>> r14 = r16     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.MutableState<androidx.compose.ui.geometry.Offset> r15 = r17     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.State<java.lang.Float> r6 = r18     // Catch:{ all -> 0x00a4 }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r7 = r13     // Catch:{ all -> 0x00a4 }
                r9 = r2
                r10 = r4
                r16 = r6
                r17 = r5
                r18 = r7
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00a4 }
                kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2     // Catch:{ all -> 0x00a4 }
                kotlinx.coroutines.flow.Flow r2 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r2)     // Catch:{ all -> 0x00a4 }
                r5 = r1
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x00a4 }
                r1.L$0 = r4     // Catch:{ all -> 0x00a4 }
                r1.label = r3     // Catch:{ all -> 0x00a4 }
                java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collect(r2, r5)     // Catch:{ all -> 0x00a4 }
                if (r2 != r0) goto L_0x009d
                return r0
            L_0x009d:
                r2 = r4
            L_0x009e:
                r2.dismiss()
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x00a4:
                r0 = move-exception
                r2 = r4
            L_0x00a6:
                r2.dismiss()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierKt$magnifier$4.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
