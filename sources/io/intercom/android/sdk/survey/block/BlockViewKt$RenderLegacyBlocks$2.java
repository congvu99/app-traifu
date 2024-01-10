package io.intercom.android.sdk.survey.block;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.blocks.lib.models.Block;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockView.kt */
final class BlockViewKt$RenderLegacyBlocks$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Block $block;
    final /* synthetic */ long $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockViewKt$RenderLegacyBlocks$2(Block block, long j, int i) {
        super(2);
        this.$block = block;
        this.$textColor = j;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BlockViewKt.m5298RenderLegacyBlocksRPmYEkk(this.$block, this.$textColor, composer, this.$$changed | 1);
    }
}
