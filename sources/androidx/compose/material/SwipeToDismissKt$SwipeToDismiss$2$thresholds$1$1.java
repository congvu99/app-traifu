package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends Lambda implements Function2<DismissValue, DismissValue, ThresholdConfig> {
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(Function1<? super DismissDirection, ? extends ThresholdConfig> function1) {
        super(2);
        this.$dismissThresholds = function1;
    }

    public final ThresholdConfig invoke(DismissValue dismissValue, DismissValue dismissValue2) {
        Intrinsics.checkNotNullParameter(dismissValue, "from");
        Intrinsics.checkNotNullParameter(dismissValue2, "to");
        Function1<DismissDirection, ThresholdConfig> function1 = this.$dismissThresholds;
        DismissDirection access$getDismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
        Intrinsics.checkNotNull(access$getDismissDirection);
        return function1.invoke(access$getDismissDirection);
    }
}
