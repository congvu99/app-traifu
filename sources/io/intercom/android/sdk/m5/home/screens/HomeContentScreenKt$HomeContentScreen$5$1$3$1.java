package io.intercom.android.sdk.m5.home.screens;

import io.intercom.android.sdk.Injector;
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
@DebugMetadata(c = "io.intercom.android.sdk.m5.home.screens.HomeContentScreenKt$HomeContentScreen$5$1$3$1", f = "HomeContentScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeContentScreen.kt */
final class HomeContentScreenKt$HomeContentScreen$5$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeContentScreenKt$HomeContentScreen$5$1$3$1(int i, Continuation<? super HomeContentScreenKt$HomeContentScreen$5$1$3$1> continuation) {
        super(2, continuation);
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeContentScreenKt$HomeContentScreen$5$1$3$1(this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeContentScreenKt$HomeContentScreen$5$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Injector.get().getMetricTracker().viewedSearchBrowseCard(this.$index);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
