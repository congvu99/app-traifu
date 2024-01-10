package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.search.ArticleSearchState;
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
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.search.IntercomArticleSearchActivity$subscribeToStates$1", f = "IntercomArticleSearchActivity.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IntercomArticleSearchActivity.kt */
final class IntercomArticleSearchActivity$subscribeToStates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ IntercomArticleSearchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomArticleSearchActivity$subscribeToStates$1(IntercomArticleSearchActivity intercomArticleSearchActivity, Continuation<? super IntercomArticleSearchActivity$subscribeToStates$1> continuation) {
        super(2, continuation);
        this.this$0 = intercomArticleSearchActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomArticleSearchActivity$subscribeToStates$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomArticleSearchActivity$subscribeToStates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<ArticleSearchState> state = this.this$0.getViewModel().getState();
            final IntercomArticleSearchActivity intercomArticleSearchActivity = this.this$0;
            this.label = 1;
            if (state.collect(new FlowCollector<ArticleSearchState>() {
                public final Object emit(ArticleSearchState articleSearchState, Continuation<? super Unit> continuation) {
                    if (articleSearchState instanceof ArticleSearchState.Content) {
                        intercomArticleSearchActivity.displaySearchResults(((ArticleSearchState.Content) articleSearchState).getSearchResults());
                    } else if (articleSearchState instanceof ArticleSearchState.NoResults) {
                        ArticleSearchState.NoResults noResults = (ArticleSearchState.NoResults) articleSearchState;
                        intercomArticleSearchActivity.displayNoResults(noResults.getTeamPresenceState(), noResults.getSearchTerm());
                    } else if (Intrinsics.areEqual((Object) articleSearchState, (Object) ArticleSearchState.Error.INSTANCE)) {
                        intercomArticleSearchActivity.displayError();
                    } else if (Intrinsics.areEqual((Object) articleSearchState, (Object) ArticleSearchState.Initial.INSTANCE)) {
                        intercomArticleSearchActivity.displayInitialState();
                    } else if (articleSearchState instanceof ArticleSearchState.NoResultsNoTeamHelp) {
                        intercomArticleSearchActivity.displayNoResultsWithoutTeamHelp(((ArticleSearchState.NoResultsNoTeamHelp) articleSearchState).getSearchTerm());
                    } else if (Intrinsics.areEqual((Object) articleSearchState, (Object) ArticleSearchState.Loading.INSTANCE)) {
                        intercomArticleSearchActivity.displayLoading();
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
