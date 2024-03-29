package io.intercom.android.sdk.views.compose;

import io.intercom.android.sdk.models.ReplyOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: MessageRow.kt */
final class MessageRowKt$MessageRow$1 extends Lambda implements Function1<ReplyOption, Unit> {
    public static final MessageRowKt$MessageRow$1 INSTANCE = new MessageRowKt$MessageRow$1();

    MessageRowKt$MessageRow$1() {
        super(1);
    }

    public final void invoke(ReplyOption replyOption) {
        Intrinsics.checkNotNullParameter(replyOption, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ReplyOption) obj);
        return Unit.INSTANCE;
    }
}
