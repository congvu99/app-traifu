package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.inbox.IntercomInboxViewModelKt;
import io.intercom.android.sdk.m5.components.ConversationItemKt;
import io.intercom.android.sdk.m5.components.IntercomDividerKt;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/lazy/LazyItemScope;", "it", "", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;ILandroidx/compose/runtime/Composer;I)V", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$4"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class InboxContentScreenItemsKt$inboxContentScreenItems$$inlined$itemsIndexed$default$3 extends Lambda implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $inboxConversations$inlined;
    final /* synthetic */ List $items;
    final /* synthetic */ Function1 $onConversationClick$inlined;
    final /* synthetic */ Function1 $onLastConversation$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InboxContentScreenItemsKt$inboxContentScreenItems$$inlined$itemsIndexed$default$3(List list, List list2, Function1 function1, Function1 function12) {
        super(4);
        this.$items = list;
        this.$inboxConversations$inlined = list2;
        this.$onLastConversation$inlined = function1;
        this.$onConversationClick$inlined = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
        int i3;
        LazyItemScope lazyItemScope2 = lazyItemScope;
        int i4 = i;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(lazyItemScope2, "$this$items");
        ComposerKt.sourceInformation(composer2, "C180@8239L26:LazyDsl.kt#428nma");
        if ((i2 & 14) == 0) {
            i3 = i2 | (composer2.changed((Object) lazyItemScope2) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer2.changed(i4) ? 32 : 16;
        }
        if ((i3 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1091073711, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:179)");
            }
            Conversation conversation = (Conversation) this.$items.get(i4);
            if (CollectionsKt.getLastIndex(this.$inboxConversations$inlined) == i4) {
                this.$onLastConversation$inlined.invoke(Long.valueOf(IntercomInboxViewModelKt.lastActionCreatedAt(conversation)));
            }
            float f = (float) 16;
            ConversationItemKt.ConversationItem(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), conversation, PaddingKt.m507PaddingValuesa9UjIt4$default(Dp.m4704constructorimpl(f), Dp.m4704constructorimpl(f), 0.0f, Dp.m4704constructorimpl(f), 4, (Object) null), new InboxContentScreenItemsKt$inboxContentScreenItems$2$1(this.$onConversationClick$inlined, conversation), composer, 70, 0);
            IntercomDividerKt.IntercomDivider(PaddingKt.m512paddingVpY3zN4$default(Modifier.Companion, Dp.m4704constructorimpl(f), 0.0f, 2, (Object) null), composer2, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
