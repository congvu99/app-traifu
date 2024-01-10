package io.intercom.android.sdk.helpcenter.api;

import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterCollection;
import io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse;
import io.intercom.android.sdk.metrics.MetricTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.api.HelpCenterApiWrapper$fetchHelpCenterCollections$1", f = "HelpCenterApiWrapper.kt", i = {}, l = {23, 24}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterApiWrapper.kt */
final class HelpCenterApiWrapper$fetchHelpCenterCollections$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CollectionRequestCallback $collectionRequestCallback;
    final /* synthetic */ MetricTracker $metricTracker;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterApiWrapper$fetchHelpCenterCollections$1(MetricTracker metricTracker, CollectionRequestCallback collectionRequestCallback, Continuation<? super HelpCenterApiWrapper$fetchHelpCenterCollections$1> continuation) {
        super(2, continuation);
        this.$metricTracker = metricTracker;
        this.$collectionRequestCallback = collectionRequestCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterApiWrapper$fetchHelpCenterCollections$1(this.$metricTracker, this.$collectionRequestCallback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterApiWrapper$fetchHelpCenterCollections$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$metricTracker.requestedHelpCenterData(MetricTracker.Place.COLLECTION_LIST);
            HelpCenterApi helpCenterApi = Injector.get().getHelpCenterApi();
            Intrinsics.checkNotNullExpressionValue(helpCenterApi, "get().helpCenterApi");
            this.label = 1;
            obj = HelpCenterApi.DefaultImpls.fetchCollectionList$default(helpCenterApi, (Map) null, this, 1, (Object) null);
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
        final NetworkResponse networkResponse = (NetworkResponse) obj;
        final MetricTracker metricTracker = this.$metricTracker;
        final CollectionRequestCallback collectionRequestCallback = this.$collectionRequestCallback;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.helpcenter.api.HelpCenterApiWrapper$fetchHelpCenterCollections$1$1", f = "HelpCenterApiWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.helpcenter.api.HelpCenterApiWrapper$fetchHelpCenterCollections$1$1  reason: invalid class name */
    /* compiled from: HelpCenterApiWrapper.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(networkResponse, metricTracker, collectionRequestCallback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NetworkResponse<List<HelpCenterCollection>> networkResponse = networkResponse;
                if (networkResponse instanceof NetworkResponse.ServerError) {
                    metricTracker.failedHelpCenter(MetricTracker.Object.HELP_CENTER_DATA_API, MetricTracker.Place.COLLECTION_LIST, String.valueOf(((NetworkResponse.ServerError) networkResponse).getCode()), false);
                    collectionRequestCallback.onError(((NetworkResponse.ServerError) networkResponse).getCode());
                } else {
                    if (networkResponse instanceof NetworkResponse.ClientError ? true : networkResponse instanceof NetworkResponse.NetworkError) {
                        metricTracker.failedHelpCenter(MetricTracker.Object.HELP_CENTER_DATA_API, MetricTracker.Place.COLLECTION_LIST, (String) null, false);
                        collectionRequestCallback.onFailure();
                    } else if (networkResponse instanceof NetworkResponse.Success) {
                        collectionRequestCallback.onComplete((List) ((NetworkResponse.Success) networkResponse).getBody());
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
