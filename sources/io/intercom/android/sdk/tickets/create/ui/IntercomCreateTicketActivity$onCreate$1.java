package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.Shapes;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.m5.components.TopActionBarKt;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.tickets.IntercomTicketActivity;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomCreateTicketActivity.kt */
final class IntercomCreateTicketActivity$onCreate$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ IntercomCreateTicketActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomCreateTicketActivity$onCreate$1(IntercomCreateTicketActivity intercomCreateTicketActivity) {
        super(2);
        this.this$0 = intercomCreateTicketActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            final State collectAsState = SnapshotStateKt.collectAsState(this.this$0.getViewModel().getUiState(), CreateTicketViewModel.CreateTicketFormUiState.Initial.INSTANCE, (CoroutineContext) null, composer, 56, 2);
            final IntercomCreateTicketActivity intercomCreateTicketActivity = this.this$0;
            EffectsKt.LaunchedEffect((Object) "", (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 70);
            final IntercomCreateTicketActivity intercomCreateTicketActivity2 = this.this$0;
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableLambdaKt.composableLambda(composer, -1685136273, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    Composer composer2 = composer;
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        final State<CreateTicketViewModel.CreateTicketFormUiState> state = collectAsState;
                        final IntercomCreateTicketActivity intercomCreateTicketActivity = intercomCreateTicketActivity2;
                        final State<CreateTicketViewModel.CreateTicketFormUiState> state2 = collectAsState;
                        final IntercomCreateTicketActivity intercomCreateTicketActivity2 = intercomCreateTicketActivity2;
                        ScaffoldKt.m1388Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, ComposableLambdaKt.composableLambda(composer2, -2025296332, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer, int i) {
                                String str;
                                if ((i & 11) != 2 || !composer.getSkipping()) {
                                    if (IntercomCreateTicketActivity$onCreate$1.m5393invoke$lambda0(state) instanceof CreateTicketViewModel.CreateTicketFormUiState.Content) {
                                        CreateTicketViewModel.CreateTicketFormUiState r1 = IntercomCreateTicketActivity$onCreate$1.m5393invoke$lambda0(state);
                                        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.CreateTicketFormUiState.Content");
                                        str = ((CreateTicketViewModel.CreateTicketFormUiState.Content) r1).getTitle();
                                    } else {
                                        str = "";
                                    }
                                    final IntercomCreateTicketActivity intercomCreateTicketActivity = intercomCreateTicketActivity;
                                    TopActionBarKt.m5180TopActionBar6oU6zVQ((Modifier) null, str, (String) null, (List<? extends Avatar>) null, new Function0<Unit>() {
                                        public final void invoke() {
                                            intercomCreateTicketActivity.finish();
                                        }
                                    }, (Painter) null, false, 0, 0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, composer, 0, WebSocketProtocol.CLOSE_NO_STATUS_CODE);
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1161467091, true, new Function3<PaddingValues, Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((PaddingValues) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PaddingValues paddingValues, Composer composer, int i) {
                                Intrinsics.checkNotNullParameter(paddingValues, "it");
                                if ((i & 14) == 0) {
                                    i |= composer.changed((Object) paddingValues) ? 4 : 2;
                                }
                                if ((i & 91) != 18 || !composer.getSkipping()) {
                                    paddingValues.m520calculateBottomPaddingD9Ej5fM();
                                    CreateTicketViewModel.CreateTicketFormUiState r8 = IntercomCreateTicketActivity$onCreate$1.m5393invoke$lambda0(state2);
                                    if (Intrinsics.areEqual((Object) r8, (Object) CreateTicketViewModel.CreateTicketFormUiState.Initial.INSTANCE)) {
                                        return;
                                    }
                                    if (r8 instanceof CreateTicketViewModel.CreateTicketFormUiState.Content) {
                                        composer.startReplaceableGroup(773894976);
                                        ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                                        composer.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = composer.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                                            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                                        }
                                        composer.endReplaceableGroup();
                                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                        composer.endReplaceableGroup();
                                        CreateTicketViewModel.CreateTicketFormUiState r10 = IntercomCreateTicketActivity$onCreate$1.m5393invoke$lambda0(state2);
                                        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel.CreateTicketFormUiState.Content");
                                        final IntercomCreateTicketActivity intercomCreateTicketActivity = intercomCreateTicketActivity2;
                                        final IntercomCreateTicketActivity intercomCreateTicketActivity2 = intercomCreateTicketActivity2;
                                        CreateTicketContentScreenKt.CreateTicketContentScreen((Modifier) null, (CreateTicketViewModel.CreateTicketFormUiState.Content) r10, new Function0<Unit>() {
                                            public final void invoke() {
                                                intercomCreateTicketActivity.getViewModel().createTicket(coroutineScope);
                                            }
                                        }, new Function0<Unit>() {
                                            public final void invoke() {
                                                intercomCreateTicketActivity2.finish();
                                            }
                                        }, composer, 64, 1);
                                    } else if (!Intrinsics.areEqual((Object) r8, (Object) CreateTicketViewModel.CreateTicketFormUiState.Error.INSTANCE)) {
                                        boolean areEqual = Intrinsics.areEqual((Object) r8, (Object) CreateTicketViewModel.CreateTicketFormUiState.Loading.INSTANCE);
                                    }
                                } else {
                                    composer.skipToGroupEnd();
                                }
                            }
                        }), composer, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 12582912, 131067);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 3072, 7);
            return;
        }
        composer.skipToGroupEnd();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final CreateTicketViewModel.CreateTicketFormUiState m5393invoke$lambda0(State<? extends CreateTicketViewModel.CreateTicketFormUiState> state) {
        return (CreateTicketViewModel.CreateTicketFormUiState) state.getValue();
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.tickets.create.ui.IntercomCreateTicketActivity$onCreate$1$1", f = "IntercomCreateTicketActivity.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.tickets.create.ui.IntercomCreateTicketActivity$onCreate$1$1  reason: invalid class name */
    /* compiled from: IntercomCreateTicketActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(intercomCreateTicketActivity, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<CreateTicketViewModel.TicketSideEffect> effect = intercomCreateTicketActivity.getViewModel().getEffect();
                final IntercomCreateTicketActivity intercomCreateTicketActivity = intercomCreateTicketActivity;
                this.label = 1;
                if (effect.collect(new FlowCollector<CreateTicketViewModel.TicketSideEffect>() {
                    public final Object emit(CreateTicketViewModel.TicketSideEffect ticketSideEffect, Continuation<? super Unit> continuation) {
                        if (Intrinsics.areEqual((Object) ticketSideEffect, (Object) CreateTicketViewModel.TicketSideEffect.Finish.INSTANCE)) {
                            intercomCreateTicketActivity.startActivity(IntercomTicketActivity.Companion.createIntent(intercomCreateTicketActivity, true));
                            intercomCreateTicketActivity.finish();
                        } else {
                            Intrinsics.areEqual((Object) ticketSideEffect, (Object) CreateTicketViewModel.TicketSideEffect.None.INSTANCE);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }
}
