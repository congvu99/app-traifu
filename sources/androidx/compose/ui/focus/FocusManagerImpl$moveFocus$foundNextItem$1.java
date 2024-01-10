package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/compose/ui/focus/FocusModifier;", "invoke", "(Landroidx/compose/ui/focus/FocusModifier;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusManager.kt */
final class FocusManagerImpl$moveFocus$foundNextItem$1 extends Lambda implements Function1<FocusModifier, Boolean> {
    final /* synthetic */ FocusModifier $source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusManagerImpl$moveFocus$foundNextItem$1(FocusModifier focusModifier) {
        super(1);
        this.$source = focusModifier;
    }

    public final Boolean invoke(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "destination");
        if (Intrinsics.areEqual((Object) focusModifier, (Object) this.$source)) {
            return false;
        }
        if (focusModifier.getParent() != null) {
            FocusTransactionsKt.requestFocus(focusModifier);
            return true;
        }
        throw new IllegalStateException("Focus search landed at the root.".toString());
    }
}
