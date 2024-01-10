package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExternalLinkCard.kt */
final class ExternalLinkCardKt$ExternalLinkCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ HomeCards.HomeExternalLinkData $homeExternalLinkData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExternalLinkCardKt$ExternalLinkCard$2(HomeCards.HomeExternalLinkData homeExternalLinkData, int i) {
        super(2);
        this.$homeExternalLinkData = homeExternalLinkData;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ExternalLinkCardKt.ExternalLinkCard(this.$homeExternalLinkData, composer, this.$$changed | 1);
    }
}
