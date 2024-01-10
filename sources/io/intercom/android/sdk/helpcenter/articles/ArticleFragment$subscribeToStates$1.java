package io.intercom.android.sdk.helpcenter.articles;

import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.articles.ArticleFragment$subscribeToStates$1", f = "ArticleFragment.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ArticleFragment.kt */
final class ArticleFragment$subscribeToStates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArticleFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleFragment$subscribeToStates$1(ArticleFragment articleFragment, Continuation<? super ArticleFragment$subscribeToStates$1> continuation) {
        super(2, continuation);
        this.this$0 = articleFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArticleFragment$subscribeToStates$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArticleFragment$subscribeToStates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<ArticleViewState> state = this.this$0.getViewModel().getState();
            final ArticleFragment articleFragment = this.this$0;
            this.label = 1;
            if (state.collect(new FlowCollector<ArticleViewState>() {
                public final Object emit(ArticleViewState articleViewState, Continuation<? super Unit> continuation) {
                    if (!Intrinsics.areEqual((Object) articleViewState, (Object) ArticleViewState.Initial.INSTANCE)) {
                        if (articleViewState instanceof ArticleViewState.Content) {
                            articleFragment.renderContent((ArticleViewState.Content) articleViewState);
                        } else if (articleViewState instanceof ArticleViewState.Error) {
                            articleFragment.renderErrors((ArticleViewState.Error) articleViewState);
                        }
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
