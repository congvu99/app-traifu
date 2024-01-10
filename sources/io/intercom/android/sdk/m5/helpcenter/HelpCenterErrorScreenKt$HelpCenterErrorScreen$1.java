package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.m5.components.ErrorState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterErrorScreen.kt */
final class HelpCenterErrorScreenKt$HelpCenterErrorScreen$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ ErrorState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterErrorScreenKt$HelpCenterErrorScreen$1(ErrorState errorState, Modifier modifier, int i, int i2) {
        super(2);
        this.$state = errorState;
        this.$modifier = modifier;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterErrorScreenKt.HelpCenterErrorScreen(this.$state, this.$modifier, composer, this.$$changed | 1, this.$$default);
    }
}
