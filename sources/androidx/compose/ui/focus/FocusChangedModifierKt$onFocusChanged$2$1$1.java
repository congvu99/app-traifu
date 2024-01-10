package androidx.compose.ui.focus;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusChangedModifier.kt */
final class FocusChangedModifierKt$onFocusChanged$2$1$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ MutableState<FocusState> $focusState;
    final /* synthetic */ Function1<FocusState, Unit> $onFocusChanged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusChangedModifierKt$onFocusChanged$2$1$1(MutableState<FocusState> mutableState, Function1<? super FocusState, Unit> function1) {
        super(1);
        this.$focusState = mutableState;
        this.$onFocusChanged = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "it");
        if (!Intrinsics.areEqual((Object) this.$focusState.getValue(), (Object) focusState)) {
            this.$focusState.setValue(focusState);
            this.$onFocusChanged.invoke(focusState);
        }
    }
}
