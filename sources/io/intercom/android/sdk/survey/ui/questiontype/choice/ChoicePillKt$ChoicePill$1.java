package io.intercom.android.sdk.survey.ui.questiontype.choice;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ChoicePill.kt */
final class ChoicePillKt$ChoicePill$1 extends Lambda implements Function1<String, Unit> {
    public static final ChoicePillKt$ChoicePill$1 INSTANCE = new ChoicePillKt$ChoicePill$1();

    ChoicePillKt$ChoicePill$1() {
        super(1);
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
