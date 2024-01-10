package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import io.intercom.android.sdk.utilities.ColorExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeScreen.kt */
final class HomeScreenKt$HomeScreen$2$4$2$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ BoxScope $this_Box;
    final /* synthetic */ HeaderState.CloseButtonColor $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeScreenKt$HomeScreen$2$4$2$1(BoxScope boxScope, HeaderState.CloseButtonColor closeButtonColor) {
        super(3);
        this.$this_Box = boxScope;
        this.$this_with = closeButtonColor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        BoxKt.Box(BackgroundKt.m177backgroundbw27NRU$default(this.$this_Box.align(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), ColorExtensionsKt.toComposeColor(this.$this_with.getBackgroundColor(), this.$this_with.getBackgroundOpacity()), (Shape) null, 2, (Object) null), composer, 0);
    }
}
