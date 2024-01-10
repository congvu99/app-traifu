package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.font.FontWeight;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.ValidationError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionHeaderComponent.kt */
final class QuestionHeaderComponentKt$QuestionHeader$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<Block.Builder> $blockList;
    final /* synthetic */ long $fontSize;
    final /* synthetic */ FontWeight $fontWeight;
    final /* synthetic */ boolean $isRequired;
    final /* synthetic */ ValidationError $validationError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionHeaderComponentKt$QuestionHeader$2(List<Block.Builder> list, boolean z, ValidationError validationError, FontWeight fontWeight, long j, int i) {
        super(2);
        this.$blockList = list;
        this.$isRequired = z;
        this.$validationError = validationError;
        this.$fontWeight = fontWeight;
        this.$fontSize = j;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        QuestionHeaderComponentKt.m5312QuestionHeaderSNZTmsY(this.$blockList, this.$isRequired, this.$validationError, this.$fontWeight, this.$fontSize, composer, this.$$changed | 1);
    }
}
