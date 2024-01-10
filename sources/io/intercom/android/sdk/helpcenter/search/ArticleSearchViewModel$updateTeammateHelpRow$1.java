package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.search.ArticleSearchResultRow;
import io.intercom.android.sdk.helpcenter.search.ArticleSearchState;
import java.util.Collection;
import java.util.Iterator;
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
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$updateTeammateHelpRow$1", f = "ArticleSearchViewModel.kt", i = {0}, l = {180}, m = "invokeSuspend", n = {"currentState"}, s = {"L$0"})
/* compiled from: ArticleSearchViewModel.kt */
final class ArticleSearchViewModel$updateTeammateHelpRow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ArticleSearchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleSearchViewModel$updateTeammateHelpRow$1(ArticleSearchViewModel articleSearchViewModel, Continuation<? super ArticleSearchViewModel$updateTeammateHelpRow$1> continuation) {
        super(2, continuation);
        this.this$0 = articleSearchViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArticleSearchViewModel$updateTeammateHelpRow$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArticleSearchViewModel$updateTeammateHelpRow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ArticleSearchState articleSearchState;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.hasClickedAtLeastOneArticle = true;
            if (this.this$0.shouldAddSendMessageRow()) {
                ArticleSearchState articleSearchState2 = (ArticleSearchState) this.this$0._state.getValue();
                if (articleSearchState2 instanceof ArticleSearchState.Content) {
                    Iterable searchResults = ((ArticleSearchState.Content) articleSearchState2).getSearchResults();
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
                    z = true;
                    if (z) {
                        this.L$0 = articleSearchState2;
                        this.label = 1;
                        if (DelayKt.delay(2000, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        articleSearchState = articleSearchState2;
                    }
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            articleSearchState = (ArticleSearchState) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArticleSearchState.Content content = (ArticleSearchState.Content) articleSearchState;
        this.this$0._state.setValue(content.copy(CollectionsKt.plus(content.getSearchResults(), this.this$0.teammateHelpRow())));
        return Unit.INSTANCE;
    }
}
