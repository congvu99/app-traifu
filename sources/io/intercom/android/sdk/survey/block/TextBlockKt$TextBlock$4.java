package io.intercom.android.sdk.survey.block;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextBlock.kt */
final class TextBlockKt$TextBlock$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ BlockRenderData $blockRenderData;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ SuffixText $suffixText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextBlockKt$TextBlock$4(Modifier modifier, BlockRenderData blockRenderData, SuffixText suffixText, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$blockRenderData = blockRenderData;
        this.$suffixText = suffixText;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextBlockKt.TextBlock(this.$modifier, this.$blockRenderData, this.$suffixText, composer, this.$$changed | 1, this.$$default);
    }
}
