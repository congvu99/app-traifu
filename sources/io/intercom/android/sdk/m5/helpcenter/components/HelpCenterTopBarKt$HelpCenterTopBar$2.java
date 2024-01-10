package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterTopBar.kt */
final class HelpCenterTopBarKt$HelpCenterTopBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function0<Unit> $onBackClick;
    final /* synthetic */ Function0<Unit> $onSearchClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterTopBarKt$HelpCenterTopBar$2(Function0<Unit> function0, Function0<Unit> function02, int i) {
        super(2);
        this.$onBackClick = function0;
        this.$onSearchClick = function02;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HelpCenterTopBarKt.HelpCenterTopBar(this.$onBackClick, this.$onSearchClick, composer, this.$$changed | 1);
    }
}
