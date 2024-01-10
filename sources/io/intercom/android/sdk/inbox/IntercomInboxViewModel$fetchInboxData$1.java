package io.intercom.android.sdk.inbox;

import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.inbox.InboxScreenEffects;
import io.intercom.android.sdk.inbox.InboxScreenState;
import io.intercom.android.sdk.m5.components.ErrorState;
import io.intercom.android.sdk.models.ActionType;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.ConversationList;
import io.intercom.android.sdk.models.ConversationsResponse;
import io.intercom.android.sdk.models.EmptyState;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.inbox.IntercomInboxViewModel$fetchInboxData$1", f = "IntercomInboxViewModel.kt", i = {}, l = {49, 88}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IntercomInboxViewModel.kt */
final class IntercomInboxViewModel$fetchInboxData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $before;
    int label;
    final /* synthetic */ IntercomInboxViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomInboxViewModel$fetchInboxData$1(IntercomInboxViewModel intercomInboxViewModel, Long l, Continuation<? super IntercomInboxViewModel$fetchInboxData$1> continuation) {
        super(2, continuation);
        this.this$0 = intercomInboxViewModel;
        this.$before = l;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomInboxViewModel$fetchInboxData$1(this.this$0, this.$before, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomInboxViewModel$fetchInboxData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        InboxScreenState inboxScreenState;
        List<Conversation> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.inboxRepository.getConversations(this.$before, this);
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
        NetworkResponse networkResponse = (NetworkResponse) obj;
        if (networkResponse instanceof NetworkResponse.ClientError) {
            z = true;
        } else {
            z = networkResponse instanceof NetworkResponse.ServerError;
        }
        if (z) {
            inboxScreenState = new InboxScreenState.Error(new ErrorState.WithoutCTA(0, 0, (Integer) null, 7, (DefaultConstructorMarker) null));
        } else if (networkResponse instanceof NetworkResponse.NetworkError) {
            inboxScreenState = new InboxScreenState.Error(new ErrorState.WithCTA(0, 0, (Integer) null, 0, new IntercomInboxViewModel$fetchInboxData$1$newState$1(this.this$0), 15, (DefaultConstructorMarker) null));
        } else if (networkResponse instanceof NetworkResponse.Success) {
            ConversationsResponse build = ((ConversationsResponse.Builder) ((NetworkResponse.Success) networkResponse).getBody()).build();
            this.this$0.appConfig.update(build.getConfig(), this.this$0.bus);
            ConversationList conversationPage = build.getConversationPage();
            if (this.$before == null) {
                list = conversationPage.getConversations();
            } else {
                IntercomInboxViewModel intercomInboxViewModel = this.this$0;
                List<Conversation> conversations = conversationPage.getConversations();
                Intrinsics.checkNotNullExpressionValue(conversations, "conversationPage.conversations");
                list = intercomInboxViewModel.combineConversations(conversations);
            }
            if (!Intrinsics.areEqual((Object) conversationPage.getEmptyState(), (Object) EmptyState.Companion.getNULL())) {
                EmptyState emptyState = conversationPage.getEmptyState();
                Intrinsics.checkNotNullExpressionValue(emptyState, "conversationPage.emptyState");
                if (conversationPage.getEmptyState().getAction().getType() == ActionType.MESSAGE) {
                    z2 = this.this$0.shouldShowSendMessageButton();
                }
                inboxScreenState = new InboxScreenState.Empty(emptyState, z2);
            } else {
                Intrinsics.checkNotNullExpressionValue(list, "allConversations");
                inboxScreenState = new InboxScreenState.Content(list, this.this$0.shouldShowSendMessageButton(), conversationPage.hasMorePages());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.this$0._state.setValue(inboxScreenState);
        if ((inboxScreenState instanceof InboxScreenState.Content) && this.$before == null) {
            this.label = 2;
            if (this.this$0._effect.emit(InboxScreenEffects.ScrollToTop.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
