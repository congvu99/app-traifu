package androidx.compose.foundation;

import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableKt$focusable$2$4$1 extends Lambda implements Function1<PinnableParent, Unit> {
    final /* synthetic */ MutableState<PinnableParent> $pinnableParent$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$4$1(MutableState<PinnableParent> mutableState) {
        super(1);
        this.$pinnableParent$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PinnableParent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PinnableParent pinnableParent) {
        FocusableKt$focusable$2.m221invoke$lambda3(this.$pinnableParent$delegate, pinnableParent);
    }
}
