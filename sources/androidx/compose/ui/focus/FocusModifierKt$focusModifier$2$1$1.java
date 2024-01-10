package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusModifier.kt */
final class FocusModifierKt$focusModifier$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusModifier $focusModifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusModifierKt$focusModifier$2$1$1(FocusModifier focusModifier) {
        super(0);
        this.$focusModifier = focusModifier;
    }

    public final void invoke() {
        FocusTransactionsKt.sendOnFocusEvent(this.$focusModifier);
    }
}
