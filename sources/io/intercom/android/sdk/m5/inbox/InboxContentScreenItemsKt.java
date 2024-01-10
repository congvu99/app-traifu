package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a`\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\t2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0000¨\u0006\u0010"}, d2 = {"InboxContentScreenPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "inboxContentScreenItems", "Landroidx/compose/foundation/lazy/LazyListScope;", "inboxConversations", "", "Lio/intercom/android/sdk/models/Conversation;", "onConversationClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "conversation", "onLastConversation", "", "before", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxContentScreenItems.kt */
public final class InboxContentScreenItemsKt {
    public static final void inboxContentScreenItems(LazyListScope lazyListScope, List<? extends Conversation> list, Function1<? super Conversation, Unit> function1, Function1<? super Long, Unit> function12) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "inboxConversations");
        Intrinsics.checkNotNullParameter(function1, "onConversationClick");
        Intrinsics.checkNotNullParameter(function12, "onLastConversation");
        Function2 function2 = InboxContentScreenItemsKt$inboxContentScreenItems$1.INSTANCE;
        lazyListScope.items(list.size(), function2 != null ? new InboxContentScreenItemsKt$inboxContentScreenItems$$inlined$itemsIndexed$default$1(function2, list) : null, new InboxContentScreenItemsKt$inboxContentScreenItems$$inlined$itemsIndexed$default$2(list), ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new InboxContentScreenItemsKt$inboxContentScreenItems$$inlined$itemsIndexed$default$3(list, list, function12, function1)));
    }

    /* access modifiers changed from: private */
    public static final void InboxContentScreenPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1159337668);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$InboxContentScreenItemsKt.INSTANCE.m5243getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxContentScreenItemsKt$InboxContentScreenPreview$1(i));
        }
    }
}
