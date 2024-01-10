package io.intercom.android.sdk.m5.inbox;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.m5.components.IntercomPrimaryButtonKt;
import io.intercom.android.sdk.m5.home.data.IconType;
import io.intercom.android.sdk.models.ActionType;
import io.intercom.android.sdk.models.EmptyState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxEmptyScreen.kt */
final class InboxEmptyScreenKt$InboxEmptyScreen$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ EmptyState $emptyState;
    final /* synthetic */ Function0<Unit> $onActionButtonClick;
    final /* synthetic */ boolean $showActionButton;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InboxEmptyScreen.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IconType.values().length];
            iArr[IconType.TEAMMATE.ordinal()] = 1;
            iArr[IconType.BOT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionType.values().length];
            iArr2[ActionType.MESSAGE.ordinal()] = 1;
            iArr2[ActionType.HELP.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxEmptyScreenKt$InboxEmptyScreen$1(boolean z, EmptyState emptyState, Function0<Unit> function0, int i) {
        super(2);
        this.$showActionButton = z;
        this.$emptyState = emptyState;
        this.$onActionButtonClick = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Integer num;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.$showActionButton) {
            int i2 = WhenMappings.$EnumSwitchMapping$1[this.$emptyState.getAction().getType().ordinal()];
            if (i2 == 1) {
                composer.startReplaceableGroup(-1691691478);
                String label = this.$emptyState.getAction().getLabel();
                IconType icon = this.$emptyState.getAction().getIcon();
                int i3 = icon == null ? -1 : WhenMappings.$EnumSwitchMapping$0[icon.ordinal()];
                if (i3 == -1) {
                    num = null;
                } else if (i3 == 1) {
                    num = Integer.valueOf(R.drawable.intercom_send_message_icon);
                } else if (i3 == 2) {
                    num = Integer.valueOf(R.drawable.intercom_conversation_card_question);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                IntercomPrimaryButtonKt.IntercomPrimaryButton(label, (Modifier) null, num, this.$onActionButtonClick, composer, (this.$$dirty << 3) & 7168, 2);
                composer.endReplaceableGroup();
            } else if (i2 != 2) {
                composer.startReplaceableGroup(-1691690769);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1691691001);
                IntercomPrimaryButtonKt.IntercomPrimaryButton(this.$emptyState.getAction().getLabel(), (Modifier) null, Integer.valueOf(R.drawable.intercom_article_book_icon), this.$onActionButtonClick, composer, (this.$$dirty << 3) & 7168, 2);
                composer.endReplaceableGroup();
            }
        }
    }
}
