package io.intercom.android.sdk.tickets.create.model;

import androidx.lifecycle.ViewModelKt;
import io.intercom.android.sdk.blocks.lib.models.TicketType;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.ValidationError;
import io.intercom.android.sdk.survey.ui.models.Answer;
import io.intercom.android.sdk.tickets.create.data.TicketRepository;
import io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "content", "Lio/intercom/android/sdk/tickets/create/model/CreateTicketViewModel$CreateTicketFormUiState$Content;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketViewModel.kt */
final class CreateTicketViewModel$createTicket$1 extends Lambda implements Function1<CreateTicketViewModel.CreateTicketFormUiState.Content, Unit> {
    final /* synthetic */ CoroutineScope $compositionAwareScope;
    final /* synthetic */ CreateTicketViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateTicketViewModel$createTicket$1(CreateTicketViewModel createTicketViewModel, CoroutineScope coroutineScope) {
        super(1);
        this.this$0 = createTicketViewModel;
        this.$compositionAwareScope = coroutineScope;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$createTicket$1$1", f = "CreateTicketViewModel.kt", i = {}, l = {201, 208}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.tickets.create.model.CreateTicketViewModel$createTicket$1$1  reason: invalid class name */
    /* compiled from: CreateTicketViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(content, createTicketViewModel, coroutineScope, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                for (QuestionState validate : content.getQuestions()) {
                    validate.validate();
                }
                Iterable questions = content.getQuestions();
                boolean z2 = false;
                if (!(questions instanceof Collection) || !((Collection) questions).isEmpty()) {
                    Iterator it = questions.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!(((QuestionState) it.next()).getValidationError() instanceof ValidationError.NoValidationError)) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    for (QuestionState questionState : content.getQuestions()) {
                        if (!(questionState.getValidationError() instanceof ValidationError.NoValidationError)) {
                            CoroutineScope coroutineScope = coroutineScope;
                            if (coroutineScope != null) {
                                questionState.bringIntoView(coroutineScope);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                final CreateTicketViewModel createTicketViewModel = createTicketViewModel;
                createTicketViewModel.withState(new Function1<CreateTicketViewModel.CreateTicketFormUiState.Content, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CreateTicketViewModel.CreateTicketFormUiState.Content) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CreateTicketViewModel.CreateTicketFormUiState.Content content) {
                        Intrinsics.checkNotNullParameter(content, "it");
                        createTicketViewModel._uiState.setValue(CreateTicketViewModel.CreateTicketFormUiState.Content.copy$default(content, (String) null, (List) null, true, 3, (Object) null));
                    }
                });
                CharSequence email = createTicketViewModel.userIdentity.getEmail();
                if (email == null || StringsKt.isBlank(email)) {
                    z2 = true;
                }
                if (z2) {
                    TicketRepository access$getTicketRepository$p = createTicketViewModel.ticketRepository;
                    Answer answer = ((QuestionState) CollectionsKt.first(content.getQuestions())).getAnswer();
                    Intrinsics.checkNotNull(answer, "null cannot be cast to non-null type io.intercom.android.sdk.survey.ui.models.Answer.SingleAnswer");
                    access$getTicketRepository$p.updateUser(((Answer.SingleAnswer) answer).getAnswer());
                }
                TicketRepository access$getTicketRepository$p2 = createTicketViewModel.ticketRepository;
                String access$getConversationId$p = createTicketViewModel.conversationId;
                TicketType access$getTicketData$p = createTicketViewModel.ticketData;
                Intrinsics.checkNotNull(access$getTicketData$p);
                this.label = 1;
                obj = access$getTicketRepository$p2.createTicket(access$getConversationId$p, access$getTicketData$p.getId(), createTicketViewModel.getAttributeRequest(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((NetworkResponse) obj) instanceof NetworkResponse.Success) {
                this.label = 2;
                if (createTicketViewModel._effect.emit(CreateTicketViewModel.TicketSideEffect.Finish.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                final CreateTicketViewModel createTicketViewModel2 = createTicketViewModel;
                createTicketViewModel2.withState(new Function1<CreateTicketViewModel.CreateTicketFormUiState.Content, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CreateTicketViewModel.CreateTicketFormUiState.Content) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CreateTicketViewModel.CreateTicketFormUiState.Content content) {
                        Intrinsics.checkNotNullParameter(content, "it");
                        createTicketViewModel2._uiState.setValue(CreateTicketViewModel.CreateTicketFormUiState.Content.copy$default(content, (String) null, (List) null, false, 3, (Object) null));
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CreateTicketViewModel.CreateTicketFormUiState.Content) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final CreateTicketViewModel.CreateTicketFormUiState.Content content) {
        Intrinsics.checkNotNullParameter(content, "content");
        final CreateTicketViewModel createTicketViewModel = this.this$0;
        final CoroutineScope coroutineScope = this.$compositionAwareScope;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), this.this$0.dispatcher, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
    }
}
