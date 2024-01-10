package io.intercom.android.sdk.helpcenter.articles;

import io.intercom.android.sdk.helpcenter.api.HelpCenterApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.helpcenter.articles.ArticleViewModel$sendReactionToServer$1", f = "ArticleViewModel.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ArticleViewModel.kt */
final class ArticleViewModel$sendReactionToServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $articleContentId;
    final /* synthetic */ String $articleId;
    final /* synthetic */ int $reactionIndex;
    int label;
    final /* synthetic */ ArticleViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArticleViewModel$sendReactionToServer$1(ArticleViewModel articleViewModel, String str, int i, String str2, Continuation<? super ArticleViewModel$sendReactionToServer$1> continuation) {
        super(2, continuation);
        this.this$0 = articleViewModel;
        this.$articleId = str;
        this.$reactionIndex = i;
        this.$articleContentId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArticleViewModel$sendReactionToServer$1(this.this$0, this.$articleId, this.$reactionIndex, this.$articleContentId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ArticleViewModel$sendReactionToServer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HelpCenterApi access$getHelpCenterApi$p = this.this$0.helpCenterApi;
            String str = this.$articleId;
            int i2 = this.$reactionIndex;
            String str2 = this.$articleContentId;
            String str3 = this.this$0.isFromSearchBrowse ? "search_browse" : null;
            this.label = 1;
            if (HelpCenterApi.DefaultImpls.reactToArticle$default(access$getHelpCenterApi$p, str, i2, str2, false, str3, (Map) null, this, 40, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
