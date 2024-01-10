package io.intercom.android.sdk.m5.home.viewmodel;

import io.intercom.android.sdk.m5.home.topbars.HeaderEvent;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "Lio/intercom/android/sdk/m5/home/topbars/HeaderEvent;", "headerEvent", "homeState", "Lio/intercom/android/sdk/m5/home/viewmodel/HomeViewState;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$headerState$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$headerState$1 extends SuspendLambda implements Function3<HeaderEvent, HomeViewState, Continuation<? super HeaderEvent>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    HomeViewModel$headerState$1(Continuation<? super HomeViewModel$headerState$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(HeaderEvent headerEvent, HomeViewState homeViewState, Continuation<? super HeaderEvent> continuation) {
        HomeViewModel$headerState$1 homeViewModel$headerState$1 = new HomeViewModel$headerState$1(continuation);
        homeViewModel$headerState$1.L$0 = headerEvent;
        homeViewModel$headerState$1.L$1 = homeViewState;
        return homeViewModel$headerState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            HeaderEvent headerEvent = (HeaderEvent) this.L$0;
            HomeViewState homeViewState = (HomeViewState) this.L$1;
            if (homeViewState instanceof HomeViewState.Content) {
                return headerEvent;
            }
            if (homeViewState instanceof HomeViewState.Error) {
                return HeaderEvent.ERROR;
            }
            return HeaderEvent.WAITING_FOR_CONTENT;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
