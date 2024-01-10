package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Avatar;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.LastParticipatingAdmin;
import io.intercom.android.sdk.models.Part;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.components.ComposableSingletons$ConversationHistoryCardKt$lambda-1$1  reason: invalid class name */
/* compiled from: ConversationHistoryCard.kt */
final class ComposableSingletons$ConversationHistoryCardKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ConversationHistoryCardKt$lambda1$1 INSTANCE = new ComposableSingletons$ConversationHistoryCardKt$lambda1$1();

    ComposableSingletons$ConversationHistoryCardKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            List createListBuilder = CollectionsKt.createListBuilder();
            int i2 = 0;
            while (i2 < 4) {
                Conversation build = new Conversation.Builder().withId("123").withRead(Boolean.valueOf(i2 == 0)).withLastParticipatingAdmin(new LastParticipatingAdmin.Builder().withFirstName("Santhosh Kumar").withAvatar(new Avatar.Builder().withInitials("SK"))).withParts(CollectionsKt.listOf(new Part.Builder().withSummary("This is the last message received/sent to/from this user").withCreatedAt(1659081886))).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …                 .build()");
                createListBuilder.add(build);
                i2++;
            }
            Unit unit = Unit.INSTANCE;
            ConversationHistoryCardKt.ConversationHistoryCard(fillMaxWidth$default, "Your recent conversations", CollectionsKt.build(createListBuilder), AnonymousClass2.INSTANCE, composer, 3638, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
