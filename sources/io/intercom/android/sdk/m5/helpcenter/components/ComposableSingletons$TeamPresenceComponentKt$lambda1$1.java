package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import androidx.core.view.ViewCompat;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.helpcenter.articles.ArticleViewState;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.models.Avatar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.helpcenter.components.ComposableSingletons$TeamPresenceComponentKt$lambda-1$1  reason: invalid class name */
/* compiled from: TeamPresenceComponent.kt */
final class ComposableSingletons$TeamPresenceComponentKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TeamPresenceComponentKt$lambda1$1 INSTANCE = new ComposableSingletons$TeamPresenceComponentKt$lambda1$1();

    ComposableSingletons$TeamPresenceComponentKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            int i2 = R.string.intercom_the_team_can_help_if_needed;
            int i3 = R.string.intercom_send_us_a_message;
            int i4 = R.drawable.intercom_new_conversation_send_button;
            List arrayList = new ArrayList();
            for (int i5 = 0; i5 < 3; i5++) {
                Avatar create = Avatar.create("", "VR");
                Intrinsics.checkNotNullExpressionValue(create, "create(\"\", \"VR\")");
                arrayList.add(new ArticleViewState.AvatarState(0, create));
            }
            TeamPresenceComponentKt.TeamPresenceComponent(new ArticleViewState.TeamPresenceState("", (ArticleViewState.ConversationState) null, i2, i3, i4, ViewCompat.MEASURED_STATE_MASK, 0, arrayList, "article", MetricTracker.Context.STYLE_HUMAN, false), composer, 8);
            return;
        }
        composer.skipToGroupEnd();
    }
}
