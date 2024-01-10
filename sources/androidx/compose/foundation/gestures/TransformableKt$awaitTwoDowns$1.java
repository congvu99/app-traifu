package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0}, l = {162}, m = "awaitTwoDowns", n = {"$this$awaitTwoDowns", "firstDown", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
/* compiled from: Transformable.kt */
final class TransformableKt$awaitTwoDowns$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    TransformableKt$awaitTwoDowns$1(Continuation<? super TransformableKt$awaitTwoDowns$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TransformableKt.awaitTwoDowns((AwaitPointerEventScope) null, false, this);
    }
}
