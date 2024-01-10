package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$newConversation$1", f = "ArticleSearchViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ArticleSearchViewModel.kt */
final class ArticleSearchViewModel$newConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ArticleSearchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleSearchViewModel$newConversation$1(ArticleSearchViewModel articleSearchViewModel, Continuation<? super ArticleSearchViewModel$newConversation$1> continuation) {
        super(2, continuation);
        this.this$0 = articleSearchViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArticleSearchViewModel$newConversation$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArticleSearchViewModel$newConversation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ArticleSearchState articleSearchState = (ArticleSearchState) this.this$0._state.getValue();
            if (!this.this$0.shouldAddSendMessageRow()) {
                MutableStateFlow access$get_state$p = this.this$0._state;
                if (articleSearchState instanceof ArticleSearchState.Content) {
                    ArticleSearchState.Content content = (ArticleSearchState.Content) articleSearchState;
                    Collection arrayList = new ArrayList();
                    for (Object next : content.getSearchResults()) {
                        if (!(((ArticleSearchResultRow) next) instanceof ArticleSearchResultRow.TeammateHelpRow)) {
                            arrayList.add(next);
                        }
                    }
                    articleSearchState = content.copy((List) arrayList);
                } else if (articleSearchState instanceof ArticleSearchState.NoResults) {
                    articleSearchState = new ArticleSearchState.NoResultsNoTeamHelp(((ArticleSearchState.NoResults) articleSearchState).getSearchTerm());
                }
                access$get_state$p.setValue(articleSearchState);
            } else if (articleSearchState instanceof ArticleSearchState.Content) {
                ArticleSearchState.Content content2 = (ArticleSearchState.Content) articleSearchState;
                Iterable searchResults = content2.getSearchResults();
                boolean z = true;
                if (!(searchResults instanceof Collection) || !((Collection) searchResults).isEmpty()) {
                    Iterator it = searchResults.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((ArticleSearchResultRow) it.next()) instanceof ArticleSearchResultRow.TeammateHelpRow) {
                                z = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (z) {
                    this.this$0._state.setValue(content2.copy(CollectionsKt.plus(content2.getSearchResults(), this.this$0.teammateHelpRow())));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
