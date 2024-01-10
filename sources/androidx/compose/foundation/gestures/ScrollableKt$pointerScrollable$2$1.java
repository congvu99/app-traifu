package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableKt$pointerScrollable$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ State<ScrollingLogic> $scrollLogic;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableKt$pointerScrollable$2$1(State<ScrollingLogic> state) {
        super(0);
        this.$scrollLogic = state;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$scrollLogic.getValue().shouldScrollImmediately());
    }
}
