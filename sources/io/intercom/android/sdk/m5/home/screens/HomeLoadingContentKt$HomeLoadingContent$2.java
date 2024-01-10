package io.intercom.android.sdk.m5.home.screens;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeLoadingContent.kt */
final class HomeLoadingContentKt$HomeLoadingContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ int $shimmerDrawable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeLoadingContentKt$HomeLoadingContent$2(Modifier modifier, int i, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$shimmerDrawable = i;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HomeLoadingContentKt.HomeLoadingContent(this.$modifier, this.$shimmerDrawable, composer, this.$$changed | 1, this.$$default);
    }
}
