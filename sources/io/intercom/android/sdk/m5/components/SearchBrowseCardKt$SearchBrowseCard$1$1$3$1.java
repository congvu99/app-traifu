package io.intercom.android.sdk.m5.components;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.m5.home.data.SuggestedArticle;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.ArrayList;
import java.util.Collection;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.components.SearchBrowseCardKt$SearchBrowseCard$1$1$3$1", f = "SearchBrowseCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SearchBrowseCard.kt */
final class SearchBrowseCardKt$SearchBrowseCard$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<SuggestedArticle> $articleSuggestions;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchBrowseCardKt$SearchBrowseCard$1$1$3$1(List<SuggestedArticle> list, Continuation<? super SearchBrowseCardKt$SearchBrowseCard$1$1$3$1> continuation) {
        super(2, continuation);
        this.$articleSuggestions = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchBrowseCardKt$SearchBrowseCard$1$1$3$1(this.$articleSuggestions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchBrowseCardKt$SearchBrowseCard$1$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MetricTracker metricTracker = Injector.get().getMetricTracker();
            Iterable<SuggestedArticle> iterable = this.$articleSuggestions;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SuggestedArticle id : iterable) {
                arrayList.add(id.getId());
            }
            metricTracker.viewedArticleSuggestions((List) arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
