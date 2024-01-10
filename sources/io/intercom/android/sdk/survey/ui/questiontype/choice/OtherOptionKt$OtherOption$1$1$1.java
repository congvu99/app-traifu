package io.intercom.android.sdk.survey.ui.questiontype.choice;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OtherOption.kt */
final class OtherOptionKt$OtherOption$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Function0<Unit> $onClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtherOptionKt$OtherOption$1$1$1(Function0<Unit> function0) {
        super(1);
        this.$onClicked = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        this.$onClicked.invoke();
    }
}
