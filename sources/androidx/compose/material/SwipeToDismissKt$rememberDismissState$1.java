package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
final class SwipeToDismissKt$rememberDismissState$1 extends Lambda implements Function1<DismissValue, Boolean> {
    public static final SwipeToDismissKt$rememberDismissState$1 INSTANCE = new SwipeToDismissKt$rememberDismissState$1();

    SwipeToDismissKt$rememberDismissState$1() {
        super(1);
    }

    public final Boolean invoke(DismissValue dismissValue) {
        Intrinsics.checkNotNullParameter(dismissValue, "it");
        return true;
    }
}
