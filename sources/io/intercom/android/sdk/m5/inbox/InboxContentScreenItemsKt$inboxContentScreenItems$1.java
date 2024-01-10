package io.intercom.android.sdk.m5.inbox;

import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "conversation", "Lio/intercom/android/sdk/models/Conversation;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxContentScreenItems.kt */
final class InboxContentScreenItemsKt$inboxContentScreenItems$1 extends Lambda implements Function2<Integer, Conversation, Object> {
    public static final InboxContentScreenItemsKt$inboxContentScreenItems$1 INSTANCE = new InboxContentScreenItemsKt$inboxContentScreenItems$1();

    InboxContentScreenItemsKt$inboxContentScreenItems$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Conversation) obj2);
    }

    public final Object invoke(int i, Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        String id = conversation.getId();
        Intrinsics.checkNotNullExpressionValue(id, "conversation.id");
        return id;
    }
}
