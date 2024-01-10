package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewModel;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ HomeViewModel $homeViewModel;
    final /* synthetic */ Function0<Unit> $navigateToMessages;
    final /* synthetic */ Function0<Unit> $onCloseClick;
    final /* synthetic */ Function1<Conversation, Unit> $onConversationClicked;
    final /* synthetic */ Function0<Unit> $onHelpClicked;
    final /* synthetic */ Function0<Unit> $onMessagesClicked;
    final /* synthetic */ Function0<Unit> $onNewConversationClicked;
    final /* synthetic */ float $topPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$3(HomeViewModel homeViewModel, float f, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function1<? super Conversation, Unit> function1, Function0<Unit> function05, int i) {
        super(2);
        this.$homeViewModel = homeViewModel;
        this.$topPadding = f;
        this.$onMessagesClicked = function0;
        this.$onHelpClicked = function02;
        this.$navigateToMessages = function03;
        this.$onNewConversationClicked = function04;
        this.$onConversationClicked = function1;
        this.$onCloseClick = function05;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HomeScreenKt.m5223HomeScreenjfnsLPA(this.$homeViewModel, this.$topPadding, this.$onMessagesClicked, this.$onHelpClicked, this.$navigateToMessages, this.$onNewConversationClicked, this.$onConversationClicked, this.$onCloseClick, composer, this.$$changed | 1);
    }
}
