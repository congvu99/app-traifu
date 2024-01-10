package androidx.compose.ui.tooling;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
/* synthetic */ class ComposeViewAdapter$findAndTrackTransitions$4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    ComposeViewAdapter$findAndTrackTransitions$4$1(Object obj) {
        super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
    }

    public final void invoke() {
        ((ComposeViewAdapter) this.receiver).requestLayout();
    }
}
