package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1(ScrollState scrollState) {
        super(0);
        this.$state = scrollState;
    }

    public final Float invoke() {
        return Float.valueOf((float) this.$state.getValue());
    }
}
