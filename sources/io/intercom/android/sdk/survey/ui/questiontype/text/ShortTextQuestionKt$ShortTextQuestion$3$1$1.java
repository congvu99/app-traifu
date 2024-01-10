package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import io.intercom.android.sdk.models.CountryAreaCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ShortTextQuestion.kt */
final class ShortTextQuestionKt$ShortTextQuestion$3$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CountryAreaCode $countryAreaCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShortTextQuestionKt$ShortTextQuestion$3$1$1(CountryAreaCode countryAreaCode) {
        super(2);
        this.$countryAreaCode = countryAreaCode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            String emoji = this.$countryAreaCode.getEmoji();
            Intrinsics.checkNotNullExpressionValue(emoji, "countryAreaCode.emoji");
            TextKt.m1496TextfLXpl1I(emoji, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 65534);
            return;
        }
        composer.skipToGroupEnd();
    }
}
