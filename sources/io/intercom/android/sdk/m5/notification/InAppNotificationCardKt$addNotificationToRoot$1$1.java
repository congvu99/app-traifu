package io.intercom.android.sdk.m5.notification;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppNotificationCard.kt */
final class InAppNotificationCardKt$addNotificationToRoot$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppNotificationCardKt$addNotificationToRoot$1$1(Conversation conversation) {
        super(2);
        this.$conversation = conversation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            InAppNotificationCardKt.InAppNotificationCard(this.$conversation, composer, 8);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
