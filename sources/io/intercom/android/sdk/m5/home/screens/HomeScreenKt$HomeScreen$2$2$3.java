package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.m5.home.viewmodel.HomeViewState;
import io.intercom.android.sdk.models.Conversation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$2$2$3 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ State<HeaderState> $headerState;
    final /* synthetic */ HomeViewState $homeState;
    final /* synthetic */ Function1<Conversation, Unit> $onConversationClicked;
    final /* synthetic */ Function0<Unit> $onHelpClicked;
    final /* synthetic */ Function0<Unit> $onMessagesClicked;
    final /* synthetic */ Function0<Unit> $onNewConversationClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$2$3(HomeViewState homeViewState, State<? extends HeaderState> state, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super Conversation, Unit> function1, int i) {
        super(3);
        this.$homeState = homeViewState;
        this.$headerState = state;
        this.$onMessagesClicked = function0;
        this.$onHelpClicked = function02;
        this.$onNewConversationClicked = function03;
        this.$onConversationClicked = function1;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        if (this.$homeState instanceof HomeViewState.Content) {
            Modifier modifier = Modifier.Companion;
            int i2 = this.$headerState.getValue() instanceof HeaderState.HeaderContent.Reduced ? 32 : 0;
            Function0<Unit> function0 = this.$onMessagesClicked;
            Function0<Unit> function02 = this.$onHelpClicked;
            Function0<Unit> function03 = this.$onNewConversationClicked;
            Function1<Conversation, Unit> function1 = this.$onConversationClicked;
            int i3 = this.$$dirty;
            HomeContentScreenKt.HomeContentScreen(PaddingKt.m514paddingqDBjuR0$default(modifier, 0.0f, Dp.m4704constructorimpl((float) i2), 0.0f, 0.0f, 13, (Object) null), (HomeViewState.Content) this.$homeState, function0, function02, function03, function1, composer, (i3 & 896) | 64 | (i3 & 7168) | (57344 & (i3 >> 3)) | ((i3 >> 3) & 458752), 0);
        }
    }
}
