package io.intercom.android.sdk.m5.home.screens;

import io.intercom.android.sdk.m5.home.viewmodel.HomeScreenEffects;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.home.screens.HomeScreenKt$HomeScreen$1", f = "HomeScreen.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeViewModel $homeViewModel;
    final /* synthetic */ Function0<Unit> $navigateToMessages;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$1(HomeViewModel homeViewModel, Function0<Unit> function0, Continuation<? super HomeScreenKt$HomeScreen$1> continuation) {
        super(2, continuation);
        this.$homeViewModel = homeViewModel;
        this.$navigateToMessages = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenKt$HomeScreen$1(this.$homeViewModel, this.$navigateToMessages, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeScreenKt$HomeScreen$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<HomeScreenEffects> effect = this.$homeViewModel.getEffect();
            final Function0<Unit> function0 = this.$navigateToMessages;
            this.label = 1;
            if (effect.collect(new FlowCollector<HomeScreenEffects>() {
                public final Object emit(HomeScreenEffects homeScreenEffects, Continuation<? super Unit> continuation) {
                    if (Intrinsics.areEqual((Object) homeScreenEffects, (Object) HomeScreenEffects.NavigateToMessages.INSTANCE)) {
                        function0.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
