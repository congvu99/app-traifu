package io.intercom.android.sdk.survey.ui.questiontype.dropdown;

import androidx.compose.foundation.layout.RowScope;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DropDownQuestion.kt */
final class DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$2 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ String $optionText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropDownQuestionKt$DropDownQuestion$1$1$1$4$2$2(String str) {
        super(3);
        this.$optionText = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$DropdownMenuItem");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            TextKt.m1496TextfLXpl1I(this.$optionText, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 65534);
            return;
        }
        composer.skipToGroupEnd();
    }
}
