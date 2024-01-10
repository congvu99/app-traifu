package io.intercom.android.sdk.m5.helpcenter;

import io.intercom.android.sdk.helpcenter.collections.HelpCenterEffects;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.helpcenter.HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2", f = "HelpCenterCollectionListScreen.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HelpCenterCollectionListScreen.kt */
final class HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onAutoNavigateToCollection;
    final /* synthetic */ HelpCenterViewModel $viewModel;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2(HelpCenterViewModel helpCenterViewModel, Function1<? super String, Unit> function1, Continuation<? super HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2> continuation) {
        super(2, continuation);
        this.$viewModel = helpCenterViewModel;
        this.$onAutoNavigateToCollection = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2(this.$viewModel, this.$onAutoNavigateToCollection, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterCollectionListScreenKt$HelpCenterCollectionListScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<HelpCenterEffects> effect = this.$viewModel.getEffect();
            final Function1<String, Unit> function1 = this.$onAutoNavigateToCollection;
            this.label = 1;
            if (effect.collect(new FlowCollector<HelpCenterEffects>() {
                public final Object emit(HelpCenterEffects helpCenterEffects, Continuation<? super Unit> continuation) {
                    if (!(helpCenterEffects instanceof HelpCenterEffects.NavigateToArticle) && (helpCenterEffects instanceof HelpCenterEffects.NavigateToCollectionContent)) {
                        function1.invoke(((HelpCenterEffects.NavigateToCollectionContent) helpCenterEffects).getCollectionId());
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
