package io.intercom.android.sdk.m5.home.viewmodel;

import io.intercom.android.sdk.m5.home.topbars.HeaderEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/m5/home/viewmodel/HeaderState;", "currentState", "headerEvent", "Lio/intercom/android/sdk/m5/home/topbars/HeaderEvent;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$headerState$3", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$headerState$3 extends SuspendLambda implements Function3<HeaderState, HeaderEvent, Continuation<? super HeaderState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$headerState$3(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$headerState$3> continuation) {
        super(3, continuation);
        this.this$0 = homeViewModel;
    }

    public final Object invoke(HeaderState headerState, HeaderEvent headerEvent, Continuation<? super HeaderState> continuation) {
        HomeViewModel$headerState$3 homeViewModel$headerState$3 = new HomeViewModel$headerState$3(this.this$0, continuation);
        homeViewModel$headerState$3.L$0 = headerState;
        homeViewModel$headerState$3.L$1 = headerEvent;
        return homeViewModel$headerState$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            HeaderEvent headerEvent = (HeaderEvent) this.L$1;
            return this.this$0.homeHeaderStateReducer.reduce(headerEvent, (HeaderState) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
