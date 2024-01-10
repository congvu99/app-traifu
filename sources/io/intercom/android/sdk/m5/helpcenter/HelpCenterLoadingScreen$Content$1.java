package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterLoadingScreen.kt */
final class HelpCenterLoadingScreen$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ HelpCenterLoadingScreen $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterLoadingScreen$Content$1(HelpCenterLoadingScreen helpCenterLoadingScreen, int i) {
        super(2);
        this.$tmp0_rcvr = helpCenterLoadingScreen;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.Content(composer, this.$$changed | 1);
    }
}
