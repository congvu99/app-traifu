package io.intercom.android.sdk.survey.block;

import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlockView.kt */
final class BlockViewKt$BlockView$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ BlockRenderData $blockRenderData;
    final /* synthetic */ ViewGroup $blocksLayout;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SuffixText $suffixText;
    final /* synthetic */ long $textColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlockViewKt$BlockView$2(Modifier modifier, BlockRenderData blockRenderData, long j, SuffixText suffixText, boolean z, ViewGroup viewGroup, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$blockRenderData = blockRenderData;
        this.$textColor = j;
        this.$suffixText = suffixText;
        this.$enabled = z;
        this.$blocksLayout = viewGroup;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BlockViewKt.m5297BlockViewFU0evQE(this.$modifier, this.$blockRenderData, this.$textColor, this.$suffixText, this.$enabled, this.$blocksLayout, composer, this.$$changed | 1, this.$$default);
    }
}
