package io.intercom.android.sdk.m5.components;

import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlocksLayoutCard.kt */
final class BlocksLayoutCardKt$BlocksLayoutCard$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ ViewGroup $blocksLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlocksLayoutCardKt$BlocksLayoutCard$2(ViewGroup viewGroup, int i) {
        super(2);
        this.$blocksLayout = viewGroup;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BlocksLayoutCardKt.BlocksLayoutCard(this.$blocksLayout, composer, this.$$changed | 1);
    }
}
