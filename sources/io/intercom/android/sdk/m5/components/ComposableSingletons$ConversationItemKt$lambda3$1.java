package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.Participant;
import io.intercom.android.sdk.models.Ticket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.components.ComposableSingletons$ConversationItemKt$lambda-3$1  reason: invalid class name */
/* compiled from: ConversationItem.kt */
final class ComposableSingletons$ConversationItemKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$ConversationItemKt$lambda3$1 INSTANCE = new ComposableSingletons$ConversationItemKt$lambda3$1();

    ComposableSingletons$ConversationItemKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Modifier r5 = BackgroundKt.m177backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 8).m1218getSurface0d7_KjU(), (Shape) null, 2, (Object) null);
            Conversation withRead = ConversationItemKt.sampleConversation(new Ticket("Feature request", (String) null, (String) null, (String) null, new Ticket.Status("Resolved", "resolved", (String) null, false, 0, 28, (DefaultConstructorMarker) null), (List) null, (List) null, 0, (Participant.Builder) null, 494, (DefaultConstructorMarker) null)).withRead(true);
            Intrinsics.checkNotNullExpressionValue(withRead, "sampleConversation(\n    …         ).withRead(true)");
            float f = (float) 16;
            ConversationItemKt.ConversationItem(r5, withRead, PaddingKt.m507PaddingValuesa9UjIt4$default(Dp.m4704constructorimpl(f), Dp.m4704constructorimpl(f), 0.0f, Dp.m4704constructorimpl(f), 4, (Object) null), AnonymousClass1.INSTANCE, composer, 3136, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
