package io.intercom.android.sdk.helpcenter.collections;

import io.intercom.android.sdk.helpcenter.collections.CollectionViewState;
import io.intercom.android.sdk.helpcenter.collections.HelpCenterEffects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.collections.HelpCenterViewModel$onArticleClicked$1", f = "HelpCenterViewModel.kt", i = {1}, l = {262, 268}, m = "invokeSuspend", n = {"currentState"}, s = {"L$0"})
/* compiled from: HelpCenterViewModel.kt */
final class HelpCenterViewModel$onArticleClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $articleId;
    Object L$0;
    int label;
    final /* synthetic */ HelpCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterViewModel$onArticleClicked$1(HelpCenterViewModel helpCenterViewModel, String str, Continuation<? super HelpCenterViewModel$onArticleClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = helpCenterViewModel;
        this.$articleId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HelpCenterViewModel$onArticleClicked$1(this.this$0, this.$articleId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HelpCenterViewModel$onArticleClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CollectionViewState collectionViewState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.hasClickedAtLeastOneArticle = true;
            this.label = 1;
            if (this.this$0._effect.emit(new HelpCenterEffects.NavigateToArticle(this.$articleId), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            collectionViewState = (CollectionViewState) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.this$0._state.setValue(((CollectionViewState.Content.CollectionContent) collectionViewState).copyWithSingleSendMessageRow(this.this$0.getSearchBrowseTeamPresenceState()));
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.shouldAddSendMessageRow()) {
            CollectionViewState collectionViewState2 = (CollectionViewState) this.this$0._state.getValue();
            if ((collectionViewState2 instanceof CollectionViewState.Content.CollectionContent) && !((CollectionViewState.Content.CollectionContent) collectionViewState2).hasSendMessageRow()) {
                this.L$0 = collectionViewState2;
                this.label = 2;
                if (DelayKt.delay(2000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                collectionViewState = collectionViewState2;
                this.this$0._state.setValue(((CollectionViewState.Content.CollectionContent) collectionViewState).copyWithSingleSendMessageRow(this.this$0.getSearchBrowseTeamPresenceState()));
            }
        }
        return Unit.INSTANCE;
    }
}
