package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.font.FontWeight;
import io.intercom.android.sdk.blocks.lib.models.Block;
import io.intercom.android.sdk.survey.QuestionState;
import io.intercom.android.sdk.survey.ValidationError;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QuestionComponent.kt */
final class QuestionComponentKt$QuestionComponent$questionHeader$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $questionFontSize;
    final /* synthetic */ FontWeight $questionFontWeight;
    final /* synthetic */ QuestionState $questionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuestionComponentKt$QuestionComponent$questionHeader$1(QuestionState questionState, FontWeight fontWeight, long j, int i) {
        super(2);
        this.$questionState = questionState;
        this.$questionFontWeight = fontWeight;
        this.$questionFontSize = j;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            List<Block.Builder> title = this.$questionState.getQuestionModel().getTitle();
            boolean isRequired = this.$questionState.getQuestionModel().isRequired();
            ValidationError validationError = this.$questionState.getValidationError();
            FontWeight fontWeight = this.$questionFontWeight;
            long j = this.$questionFontSize;
            int i2 = this.$$dirty;
            QuestionHeaderComponentKt.m5312QuestionHeaderSNZTmsY(title, isRequired, validationError, fontWeight, j, composer, ((i2 >> 12) & 7168) | 8 | ((i2 >> 12) & 57344));
            return;
        }
        composer.skipToGroupEnd();
    }
}
