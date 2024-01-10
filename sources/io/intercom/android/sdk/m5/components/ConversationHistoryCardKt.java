package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import io.intercom.android.sdk.models.Conversation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"ConversationHistoryCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "cardTitle", "", "conversations", "", "Lio/intercom/android/sdk/models/Conversation;", "onConversationClick", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "RecentConversationsCardPreview", "(Landroidx/compose/runtime/Composer;I)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConversationHistoryCard.kt */
public final class ConversationHistoryCardKt {
    public static final void ConversationHistoryCard(Modifier modifier, String str, List<? extends Conversation> list, Function1<? super Conversation, Unit> function1, Composer composer, int i, int i2) {
        Function1<? super Conversation, Unit> function12;
        String str2 = str;
        List<? extends Conversation> list2 = list;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str2, "cardTitle");
        Intrinsics.checkNotNullParameter(list2, "conversations");
        Composer startRestartGroup = composer.startRestartGroup(-1629591433);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            function12 = ConversationHistoryCardKt$ConversationHistoryCard$1.INSTANCE;
        } else {
            function12 = function1;
        }
        CardKt.m1177CardFjzlyU(modifier2, (Shape) null, 0, 0, BorderStrokeKt.m191BorderStrokecXLIe8U(Dp.m4704constructorimpl((float) 0.5d), Color.m1931copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 8).m1213getOnSurface0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Dp.m4704constructorimpl((float) 2), ComposableLambdaKt.composableLambda(startRestartGroup, -1199096358, true, new ConversationHistoryCardKt$ConversationHistoryCard$2(str2, i3, list2, function12)), startRestartGroup, (i3 & 14) | 1769472, 14);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationHistoryCardKt$ConversationHistoryCard$3(modifier2, str, list, function12, i, i2));
        }
    }

    /* access modifiers changed from: private */
    public static final void RecentConversationsCardPreview(Composer composer, int i) {
        Composer startRestartGroup = composer.startRestartGroup(593700998);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$ConversationHistoryCardKt.INSTANCE.m5139getLambda1$intercom_sdk_base_release(), startRestartGroup, 3072, 7);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ConversationHistoryCardKt$RecentConversationsCardPreview$1(i));
        }
    }
}
