package io.intercom.android.sdk.views.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageBubbleRow$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageRowKt$MessageBubbleRow$2$1(Function0<Unit> function0) {
        super(0);
        this.$onClick = function0;
    }

    public final void invoke() {
        Function0<Unit> function0 = this.$onClick;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
