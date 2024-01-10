package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$rememberDismissState$2 extends Lambda implements Function0<DismissState> {
    final /* synthetic */ Function1<DismissValue, Boolean> $confirmStateChange;
    final /* synthetic */ DismissValue $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$rememberDismissState$2(DismissValue dismissValue, Function1<? super DismissValue, Boolean> function1) {
        super(0);
        this.$initialValue = dismissValue;
        this.$confirmStateChange = function1;
    }

    public final DismissState invoke() {
        return new DismissState(this.$initialValue, this.$confirmStateChange);
    }
}
