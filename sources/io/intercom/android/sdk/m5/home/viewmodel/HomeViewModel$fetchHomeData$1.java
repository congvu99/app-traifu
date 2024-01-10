package io.intercom.android.sdk.m5.home.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$fetchHomeData$1", f = "HomeViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$fetchHomeData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$fetchHomeData$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$fetchHomeData$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$fetchHomeData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$fetchHomeData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x002d
        L_0x000f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r10)
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel r10 = r9.this$0
            io.intercom.android.sdk.api.MessengerApi r10 = r10.messengerApi
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r2
            r3 = 0
            java.lang.Object r10 = io.intercom.android.sdk.api.MessengerApi.DefaultImpls.getHomeCardsV2Suspend$default(r10, r3, r1, r2, r3)
            if (r10 != r0) goto L_0x002d
            return r0
        L_0x002d:
            io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse r10 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse) r10
            boolean r0 = r10 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.ClientError
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0037
        L_0x0035:
            boolean r0 = r10 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.ServerError
        L_0x0037:
            if (r0 == 0) goto L_0x004f
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Error r10 = new io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Error
            io.intercom.android.sdk.m5.components.ErrorState$WithoutCTA r6 = new io.intercom.android.sdk.m5.components.ErrorState$WithoutCTA
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            io.intercom.android.sdk.m5.components.ErrorState r6 = (io.intercom.android.sdk.m5.components.ErrorState) r6
            r10.<init>(r6)
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState r10 = (io.intercom.android.sdk.m5.home.viewmodel.HomeViewState) r10
            goto L_0x00c9
        L_0x004f:
            boolean r0 = r10 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.NetworkError
            if (r0 == 0) goto L_0x0074
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Error r10 = new io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Error
            io.intercom.android.sdk.m5.components.ErrorState$WithCTA r8 = new io.intercom.android.sdk.m5.components.ErrorState$WithCTA
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$fetchHomeData$1$newState$1 r0 = new io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$fetchHomeData$1$newState$1
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel r5 = r9.this$0
            r0.<init>(r5)
            r5 = r0
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r6 = 15
            r7 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            io.intercom.android.sdk.m5.components.ErrorState r8 = (io.intercom.android.sdk.m5.components.ErrorState) r8
            r10.<init>(r8)
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState r10 = (io.intercom.android.sdk.m5.home.viewmodel.HomeViewState) r10
            goto L_0x00c9
        L_0x0074:
            boolean r0 = r10 instanceof io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.Success
            if (r0 == 0) goto L_0x00d5
            io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse$Success r10 = (io.intercom.android.sdk.helpcenter.utils.networking.NetworkResponse.Success) r10
            java.lang.Object r10 = r10.getBody()
            io.intercom.android.sdk.m5.home.data.HomeV2Response r10 = (io.intercom.android.sdk.m5.home.data.HomeV2Response) r10
            java.util.List r10 = r10.getCards()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r10 = r10.iterator()
        L_0x0091:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00c0
            java.lang.Object r1 = r10.next()
            r3 = r1
            io.intercom.android.sdk.m5.home.data.HomeCards r3 = (io.intercom.android.sdk.m5.home.data.HomeCards) r3
            boolean r4 = r3 instanceof io.intercom.android.sdk.m5.home.data.HomeCards.HomeNewConversationData
            if (r4 == 0) goto L_0x00b9
            io.intercom.android.sdk.m5.home.data.HomeCards$HomeNewConversationData r3 = (io.intercom.android.sdk.m5.home.data.HomeCards.HomeNewConversationData) r3
            boolean r4 = r3.getPreventMultipleInboundConversationsEnabled()
            if (r4 == 0) goto L_0x00b9
            java.util.List r3 = r3.getOpenInboundConversationsIds()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x00b9
            r3 = 1
            goto L_0x00ba
        L_0x00b9:
            r3 = 0
        L_0x00ba:
            if (r3 != 0) goto L_0x0091
            r0.add(r1)
            goto L_0x0091
        L_0x00c0:
            java.util.List r0 = (java.util.List) r0
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Content r10 = new io.intercom.android.sdk.m5.home.viewmodel.HomeViewState$Content
            r10.<init>(r0)
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewState r10 = (io.intercom.android.sdk.m5.home.viewmodel.HomeViewState) r10
        L_0x00c9:
            io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel r0 = r9.this$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = r0._state
            r0.setValue(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00d5:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel$fetchHomeData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
