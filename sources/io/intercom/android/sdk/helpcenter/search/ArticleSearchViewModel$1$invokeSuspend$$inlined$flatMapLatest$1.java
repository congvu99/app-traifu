package io.intercom.android.sdk.helpcenter.search;

import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.search.ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1", f = "ArticleSearchViewModel.kt", i = {0}, l = {217, 222}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* compiled from: Merge.kt */
public final class ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Pair<? extends NetworkResponse<? extends List<? extends HelpCenterArticleSearchResponse>>, ? extends String>>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ArticleSearchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, ArticleSearchViewModel articleSearchViewModel) {
        super(3, continuation);
        this.this$0 = articleSearchViewModel;
    }

    public final Object invoke(FlowCollector<? super Pair<? extends NetworkResponse<? extends List<? extends HelpCenterArticleSearchResponse>>, ? extends String>> flowCollector, String str, Continuation<? super Unit> continuation) {
        ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 articleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 = new ArticleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.this$0);
        articleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = flowCollector;
        articleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = str;
        return articleSearchViewModel$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            Continuation continuation = this;
            str = (String) this.L$1;
            HelpCenterApi access$getHelpCenterApi$p = this.this$0.helpCenterApi;
            String str2 = this.this$0.isFromSearchBrowse ? "search_browse" : null;
            this.L$0 = flowCollector2;
            this.L$1 = str;
            this.label = 1;
            Object searchForArticles$default = HelpCenterApi.DefaultImpls.searchForArticles$default(access$getHelpCenterApi$p, str, str2, (Map) null, this, 4, (Object) null);
            if (searchForArticles$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = searchForArticles$default;
            flowCollector = flowCollector2;
            obj = obj2;
        } else if (i == 1) {
            str = (String) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (FlowKt.emitAll(flowCollector, FlowKt.flowOf(new Pair(obj, str)), (Continuation<? super Unit>) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
