package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewState;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeContentScreen.kt */
final class HomeContentScreenKt$HomeContentScreen$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ HomeViewState.Content $content;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Conversation, Unit> $onConversationClick;
    final /* synthetic */ Function0<Unit> $onHelpClicked;
    final /* synthetic */ Function0<Unit> $onMessagesClicked;
    final /* synthetic */ Function0<Unit> $onNewConversationClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeContentScreenKt$HomeContentScreen$6(Modifier modifier, HomeViewState.Content content, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super Conversation, Unit> function1, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$content = content;
        this.$onMessagesClicked = function0;
        this.$onHelpClicked = function02;
        this.$onNewConversationClicked = function03;
        this.$onConversationClick = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HomeContentScreenKt.HomeContentScreen(this.$modifier, this.$content, this.$onMessagesClicked, this.$onHelpClicked, this.$onNewConversationClicked, this.$onConversationClick, composer, this.$$changed | 1, this.$$default);
    }
}
