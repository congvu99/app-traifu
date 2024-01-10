package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.HomeItemKt;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.data.IconType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NewConversationCard.kt */
final class NewConversationCardKt$NewConversationCard$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ HomeCards.HomeNewConversationData $newConversation;
    final /* synthetic */ Function0<Unit> $onNewConversationClicked;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NewConversationCard.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IconType.values().length];
            iArr[IconType.TEAMMATE.ordinal()] = 1;
            iArr[IconType.BOT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewConversationCardKt$NewConversationCard$1(HomeCards.HomeNewConversationData homeNewConversationData, Function0<Unit> function0, int i) {
        super(2);
        this.$newConversation = homeNewConversationData;
        this.$onNewConversationClicked = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Integer num;
        if ((i & 11) != 2 || !composer.getSkipping()) {
            IconType icon = this.$newConversation.getAction().getIcon();
            int i2 = icon == null ? -1 : WhenMappings.$EnumSwitchMapping$0[icon.ordinal()];
            if (i2 == -1) {
                num = null;
            } else if (i2 == 1) {
                num = Integer.valueOf(R.drawable.intercom_send_message_icon);
            } else if (i2 == 2) {
                num = Integer.valueOf(R.drawable.intercom_conversation_card_question);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            HomeItemKt.HomeItem((Modifier) null, num, (Integer) null, this.$newConversation.getAction().getLabel(), this.$newConversation.getAction().getSubtitle(), (Integer) null, this.$onNewConversationClicked, composer, (this.$$dirty << 15) & 3670016, 37);
            return;
        }
        composer.skipToGroupEnd();
    }
}
