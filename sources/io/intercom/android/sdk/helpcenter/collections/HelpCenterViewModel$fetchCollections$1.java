package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.collections.CollectionListRow;
import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterEffects;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel$fetchCollections$1", f = "HelpCenterViewModel.kt", i = {}, l = {116, 145, 154}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterViewModel.kt */
final class HelpCenterViewModel$fetchCollections$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $collectionIds;
    Object L$0;
    int label;
    final /* synthetic */ HelpCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterViewModel$fetchCollections$1(HelpCenterViewModel helpCenterViewModel, Set<String> set, Continuation<? super HelpCenterViewModel$fetchCollections$1> continuation) {
        super(2, continuation);
        this.this$0 = helpCenterViewModel;
        this.$collectionIds = set;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterViewModel$fetchCollections$1(this.this$0, this.$collectionIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterViewModel$fetchCollections$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CollectionViewState collectionViewState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getState().getValue() instanceof CollectionViewState.Content.CollectionListContent) {
                return Unit.INSTANCE;
            }
            this.this$0._state.setValue(CollectionViewState.Loading.INSTANCE);
            this.label = 1;
            obj = HelpCenterApi.DefaultImpls.fetchCollectionList$default(this.this$0.helpCenterApi, (Map) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            MutableStateFlow mutableStateFlow = (MutableStateFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 3) {
            MutableStateFlow mutableStateFlow2 = (MutableStateFlow) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkResponse networkResponse = (NetworkResponse) obj;
        MutableStateFlow access$get_state$p = this.this$0._state;
        if (networkResponse instanceof NetworkResponse.ServerError) {
            NetworkResponse.ServerError serverError = (NetworkResponse.ServerError) networkResponse;
            this.this$0.sendFailedCollectionListMetric(Boxing.boxInt(serverError.getCode()));
            collectionViewState = serverError.getCode() == 404 ? this.this$0.notFoundError : this.this$0.genericError;
        } else if (networkResponse instanceof NetworkResponse.ClientError) {
            HelpCenterViewModel.sendFailedCollectionListMetric$default(this.this$0, (Integer) null, 1, (Object) null);
            collectionViewState = this.this$0.genericError;
        } else if (networkResponse instanceof NetworkResponse.NetworkError) {
            HelpCenterViewModel.sendFailedCollectionListMetric$default(this.this$0, (Integer) null, 1, (Object) null);
            final HelpCenterViewModel helpCenterViewModel = this.this$0;
            final Set<String> set = this.$collectionIds;
            collectionViewState = helpCenterViewModel.errorWithRetry(new Function0<Unit>() {
                public final void invoke() {
                    helpCenterViewModel.fetchCollections(set);
                }
            });
        } else if (networkResponse instanceof NetworkResponse.Success) {
            List list = (List) ((NetworkResponse.Success) networkResponse).getBody();
            Set<String> set2 = this.$collectionIds;
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (set2.contains(((HelpCenterCollection) next).getId())) {
                    arrayList.add(next);
                }
            }
            List list2 = (List) arrayList;
            this.this$0.isPartialHelpCenterLoaded = list2.size() < list.size() && (list2.isEmpty() ^ true);
            this.this$0.metricTracker.viewedNativeHelpCenter(MetricTracker.Place.COLLECTION_LIST, Boxing.boxBoolean(this.this$0.isPartialHelpCenterLoaded), this.this$0.isFromSearchBrowse());
            if (list2.size() == 1) {
                this.L$0 = access$get_state$p;
                this.label = 2;
                if (this.this$0._effect.emit(new HelpCenterEffects.NavigateToCollectionContent(((HelpCenterCollection) CollectionsKt.first(list2)).getId()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (list.size() == 1) {
                this.L$0 = access$get_state$p;
                this.label = 3;
                if (this.this$0._effect.emit(new HelpCenterEffects.NavigateToCollectionContent(((HelpCenterCollection) CollectionsKt.first(list)).getId()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else {
                boolean z = !list2.isEmpty();
                if (!list2.isEmpty()) {
                    list = list2;
                }
                if (!list.isEmpty()) {
                    List mutableList = CollectionsKt.toMutableList(this.this$0.transformToUiModel((List<HelpCenterCollection>) list));
                    if (z) {
                        mutableList.add(CollectionListRow.BrowseAllHelpTopicsAsListItem.INSTANCE);
                    } else if (this.this$0.isPartialHelpCenterLoaded) {
                        mutableList.add(CollectionListRow.FullHelpCenterRow.INSTANCE);
                    }
                    if (this.this$0.shouldAddSendMessageRow()) {
                        mutableList.add(new CollectionListRow.SendMessageRow(this.this$0.getSearchBrowseTeamPresenceState()));
                    }
                    collectionViewState = new CollectionViewState.Content.CollectionListContent(mutableList);
                } else {
                    collectionViewState = this.this$0.genericError;
                }
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        access$get_state$p.setValue(collectionViewState);
        return Unit.INSTANCE;
    }
}
