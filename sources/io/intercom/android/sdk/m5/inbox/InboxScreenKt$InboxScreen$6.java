package io.intercom.android.sdk.m5.inbox;

import androidx.compose.runtime.Composer;
import androidx.lifecycle.LifecycleOwner;
import io.intercom.android.sdk.inbox.InboxScreenEffects;
import io.intercom.android.sdk.inbox.IntercomInboxViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Function0<Unit> $onBackButtonClick;
    final /* synthetic */ Function0<Unit> $onBrowseHelpCenterButtonClick;
    final /* synthetic */ Function1<InboxScreenEffects.NavigateToConversation, Unit> $onConversationClicked;
    final /* synthetic */ Function0<Unit> $onSendMessageButtonClick;
    final /* synthetic */ IntercomInboxViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$6(IntercomInboxViewModel intercomInboxViewModel, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super InboxScreenEffects.NavigateToConversation, Unit> function1, LifecycleOwner lifecycleOwner, int i, int i2) {
        super(2);
        this.$viewModel = intercomInboxViewModel;
        this.$onSendMessageButtonClick = function0;
        this.$onBrowseHelpCenterButtonClick = function02;
        this.$onBackButtonClick = function03;
        this.$onConversationClicked = function1;
        this.$lifecycleOwner = lifecycleOwner;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        InboxScreenKt.InboxScreen(this.$viewModel, this.$onSendMessageButtonClick, this.$onBrowseHelpCenterButtonClick, this.$onBackButtonClick, this.$onConversationClicked, this.$lifecycleOwner, composer, this.$$changed | 1, this.$$default);
    }
}
