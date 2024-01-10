package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeHeaderBackdrop.kt */
final class HomeHeaderBackdropKt$HomeHeaderBackdrop$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ HeaderState.HeaderBackdropStyle $backdropStyle;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ Function0<Unit> $onImageLoaded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeHeaderBackdropKt$HomeHeaderBackdrop$2(float f, HeaderState.HeaderBackdropStyle headerBackdropStyle, Function0<Unit> function0, int i) {
        super(2);
        this.$headerHeight = f;
        this.$backdropStyle = headerBackdropStyle;
        this.$onImageLoaded = function0;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HomeHeaderBackdropKt.m5232HomeHeaderBackdroporJrPs(this.$headerHeight, this.$backdropStyle, this.$onImageLoaded, composer, this.$$changed | 1);
    }
}
