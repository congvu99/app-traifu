package io.intercom.android.sdk.m5.helpcenter;

import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
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
@DebugMetadata(c = "io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1", f = "HelpCenterCollectionListScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterCollectionListScreen.kt */
final class HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $collectionIds;
    final /* synthetic */ HelpCenterViewModel $viewModel;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1(HelpCenterViewModel helpCenterViewModel, List<String> list, Continuation<? super HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1> continuation) {
        super(2, continuation);
        this.$viewModel = helpCenterViewModel;
        this.$collectionIds = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1(this.$viewModel, this.$collectionIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$viewModel.fetchCollections(CollectionsKt.toSet(this.$collectionIds));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
