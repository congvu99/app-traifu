package io.intercom.android.sdk.survey.ui.questiontype.text;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextInputPill.kt */
final class TextInputPillKt$TextInputPillUnchecked$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextInputPillKt$TextInputPillUnchecked$1(int i) {
        super(2);
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TextInputPillKt.TextInputPillUnchecked(composer, this.$$changed | 1);
    }
}
