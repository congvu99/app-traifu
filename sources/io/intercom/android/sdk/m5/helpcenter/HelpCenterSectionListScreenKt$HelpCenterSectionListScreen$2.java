package io.intercom.android.sdk.m5.helpcenter;

import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.helpcenter.HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2", f = "HelpCenterSectionListScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterSectionListScreen.kt */
final class HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ HelpCenterViewModel $viewModel;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2(HelpCenterViewModel helpCenterViewModel, String str, Continuation<? super HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2> continuation) {
        super(2, continuation);
        this.$viewModel = helpCenterViewModel;
        this.$collectionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2(this.$viewModel, this.$collectionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterSectionListScreenKt$HelpCenterSectionListScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$viewModel.fetchSingleCollection(this.$collectionId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
