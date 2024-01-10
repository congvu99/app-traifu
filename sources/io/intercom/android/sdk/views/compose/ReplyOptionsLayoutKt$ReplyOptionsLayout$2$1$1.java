package io.intercom.android.sdk.views.compose;

import io.intercom.android.sdk.models.ReplyOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReplyOptionsLayout.kt */
final class ReplyOptionsLayoutKt$ReplyOptionsLayout$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<ReplyOption, Unit> $onReplyClicked;
    final /* synthetic */ ReplyOption $replyOption;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReplyOptionsLayoutKt$ReplyOptionsLayout$2$1$1(Function1<? super ReplyOption, Unit> function1, ReplyOption replyOption) {
        super(0);
        this.$onReplyClicked = function1;
        this.$replyOption = replyOption;
    }

    public final void invoke() {
        this.$onReplyClicked.invoke(this.$replyOption);
    }
}
