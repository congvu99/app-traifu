package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.collections.ArticleSectionRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.sections.HelpCenterCollectionContent;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel$fetchSingleCollection$1", f = "HelpCenterViewModel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterViewModel.kt */
final class HelpCenterViewModel$fetchSingleCollection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    int label;
    final /* synthetic */ HelpCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterViewModel$fetchSingleCollection$1(HelpCenterViewModel helpCenterViewModel, String str, Continuation<? super HelpCenterViewModel$fetchSingleCollection$1> continuation) {
        super(2, continuation);
        this.this$0 = helpCenterViewModel;
        this.$collectionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterViewModel$fetchSingleCollection$1(this.this$0, this.$collectionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterViewModel$fetchSingleCollection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CollectionViewState collectionViewState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getState().getValue() instanceof CollectionViewState.Content.CollectionContent) {
                return Unit.INSTANCE;
            }
            this.this$0._state.setValue(CollectionViewState.Loading.INSTANCE);
            this.label = 1;
            obj = HelpCenterApi.DefaultImpls.fetchSectionsList$default(this.this$0.helpCenterApi, this.$collectionId, (Map) null, this, 2, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        MutableStateFlow access$get_state$p = this.this$0._state;
        if (networkResponse instanceof NetworkResponse.ServerError) {
            NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) networkResponse;
            this.this$0.sendFailedSingleCollectionMetric(Boxing.boxInt(serverError.getCode()));
            collectionViewState = serverError.getCode() == 404 ? this.this$0.notFoundError : this.this$0.genericError;
        } else if (networkResponse instanceof NetworkResponse.ClientError) {
            HelpCenterViewModel.sendFailedSingleCollectionMetric$default(this.this$0, (Integer) null, 1, (Object) null);
            collectionViewState = this.this$0.genericError;
        } else if (networkResponse instanceof NetworkResponse.NetworkError) {
            HelpCenterViewModel.sendFailedSingleCollectionMetric$default(this.this$0, (Integer) null, 1, (Object) null);
            final HelpCenterViewModel helpCenterViewModel = this.this$0;
            final String str = this.$collectionId;
            collectionViewState = helpCenterViewModel.errorWithRetry(new Function0<Unit>() {
                public final void invoke() {
                    helpCenterViewModel.fetchSingleCollection(str);
                }
            });
        } else if (networkResponse instanceof NetworkResponse.Success) {
            HelpCenterCollectionContent helpCenterCollectionContent = (HelpCenterCollectionContent) ((NetworkResponse.Success) networkResponse).getBody();
            List mutableList = CollectionsKt.toMutableList(this.this$0.transformToUiModel(helpCenterCollectionContent));
            if (this.this$0.isPartialHelpCenterLoaded) {
                mutableList.add(ArticleSectionRow.FullHelpCenterRow.INSTANCE);
            }
            this.this$0.metricTracker.viewedNativeHelpCenter(MetricTracker.Place.ARTICLE_LIST, Boxing.boxBoolean(this.this$0.isPartialHelpCenterLoaded), this.this$0.isFromSearchBrowse());
            if (this.this$0.shouldAddSendMessageRow()) {
                mutableList.add(new ArticleSectionRow.SendMessageRow(this.this$0.getSearchBrowseTeamPresenceState()));
            }
            collectionViewState = new CollectionViewState.Content.CollectionContent(helpCenterCollectionContent.getTitle(), helpCenterCollectionContent.getSummary(), helpCenterCollectionContent.getArticlesCount(), helpCenterCollectionContent.getAuthors(), mutableList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        access$get_state$p.setValue(collectionViewState);
        return Unit.INSTANCE;
    }
}
