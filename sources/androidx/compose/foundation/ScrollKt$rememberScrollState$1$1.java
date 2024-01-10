package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$rememberScrollState$1$1 extends Lambda implements Function0<ScrollState> {
    final /* synthetic */ int $initial;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$rememberScrollState$1$1(int i) {
        super(0);
        this.$initial = i;
    }

    public final ScrollState invoke() {
        return new ScrollState(this.$initial);
    }
}
