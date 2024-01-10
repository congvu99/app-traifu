package io.intercom.android.sdk.survey.ui.questiontype.choice;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ChoicePill.kt */
final class ChoicePillKt$ChoicePill$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<String, Unit> $onClicked;
    final /* synthetic */ String $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChoicePillKt$ChoicePill$2$1(Function1<? super String, Unit> function1, String str) {
        super(0);
        this.$onClicked = function1;
        this.$text = str;
    }

    public final void invoke() {
        this.$onClicked.invoke(this.$text);
    }
}
