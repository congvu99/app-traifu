package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.lazy.LazyListState;
import io.intercom.android.sdk.inbox.InboxScreenEffects;
import io.intercom.android.sdk.inbox.IntercomInboxViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.inbox.InboxScreenKt$InboxScreen$2", f = "InboxScreen.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<InboxScreenEffects.NavigateToConversation, Unit> $onConversationClicked;
    final /* synthetic */ IntercomInboxViewModel $viewModel;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$2(IntercomInboxViewModel intercomInboxViewModel, Function1<? super InboxScreenEffects.NavigateToConversation, Unit> function1, LazyListState lazyListState, Continuation<? super InboxScreenKt$InboxScreen$2> continuation) {
        super(2, continuation);
        this.$viewModel = intercomInboxViewModel;
        this.$onConversationClicked = function1;
        this.$lazyListState = lazyListState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InboxScreenKt$InboxScreen$2(this.$viewModel, this.$onConversationClicked, this.$lazyListState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InboxScreenKt$InboxScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<InboxScreenEffects> effect = this.$viewModel.getEffect();
            final Function1<InboxScreenEffects.NavigateToConversation, Unit> function1 = this.$onConversationClicked;
            final LazyListState lazyListState = this.$lazyListState;
            this.label = 1;
            if (effect.collect(new FlowCollector<InboxScreenEffects>() {
                public final Object emit(InboxScreenEffects inboxScreenEffects, Continuation<? super Unit> continuation) {
                    if (inboxScreenEffects instanceof InboxScreenEffects.NavigateToConversation) {
                        function1.invoke(inboxScreenEffects);
                    } else if ((inboxScreenEffects instanceof InboxScreenEffects.ScrollToTop) && lazyListState.getFirstVisibleItemIndex() == 0) {
                        Object animateScrollToItem$default = LazyListState.animateScrollToItem$default(lazyListState, 0, 0, continuation, 2, (Object) null);
                        return animateScrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem$default : Unit.INSTANCE;
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
