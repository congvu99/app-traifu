package io.intercom.android.sdk.m5.home.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.home.data.HomeCards;
import io.intercom.android.sdk.m5.home.data.SpaceItemType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpacesCard.kt */
final class SpacesCardKt$SpacesCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ HomeCards.HomeSpacesData $homeSpacesData;
    final /* synthetic */ Function1<SpaceItemType, Unit> $onItemClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpacesCardKt$SpacesCard$2(HomeCards.HomeSpacesData homeSpacesData, Function1<? super SpaceItemType, Unit> function1, int i) {
        super(2);
        this.$homeSpacesData = homeSpacesData;
        this.$onItemClick = function1;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SpacesCardKt.SpacesCard(this.$homeSpacesData, this.$onItemClick, composer, this.$$changed | 1);
    }
}
