package io.intercom.android.sdk.m5.home.components;

import io.intercom.android.sdk.m5.home.data.SpaceItem;
import io.intercom.android.sdk.m5.home.data.SpaceItemType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpacesCard.kt */
final class SpacesCardKt$SpacesCard$1$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SpaceItem $item;
    final /* synthetic */ Function1<SpaceItemType, Unit> $onItemClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpacesCardKt$SpacesCard$1$1$1$1$1(Function1<? super SpaceItemType, Unit> function1, SpaceItem spaceItem) {
        super(0);
        this.$onItemClick = function1;
        this.$item = spaceItem;
    }

    public final void invoke() {
        this.$onItemClick.invoke(this.$item.getType());
    }
}
