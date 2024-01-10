package io.intercom.android.sdk.tickets.create.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.survey.block.BlockRenderData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CreateTicketCard.kt */
final class CreateTicketCardKt$CreateTicketCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ BlockRenderData $blockRenderData;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateTicketCardKt$CreateTicketCard$2(Modifier modifier, BlockRenderData blockRenderData, boolean z, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$blockRenderData = blockRenderData;
        this.$enabled = z;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CreateTicketCardKt.CreateTicketCard(this.$modifier, this.$blockRenderData, this.$enabled, composer, this.$$changed | 1, this.$$default);
    }
}
