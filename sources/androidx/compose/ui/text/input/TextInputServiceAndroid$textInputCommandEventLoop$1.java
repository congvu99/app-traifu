package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.input.TextInputServiceAndroid", f = "TextInputServiceAndroid.android.kt", i = {0}, l = {204}, m = "textInputCommandEventLoop", n = {"this"}, s = {"L$0"})
/* compiled from: TextInputServiceAndroid.android.kt */
final class TextInputServiceAndroid$textInputCommandEventLoop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextInputServiceAndroid this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextInputServiceAndroid$textInputCommandEventLoop$1(TextInputServiceAndroid textInputServiceAndroid, Continuation<? super TextInputServiceAndroid$textInputCommandEventLoop$1> continuation) {
        super(continuation);
        this.this$0 = textInputServiceAndroid;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.textInputCommandEventLoop(this);
    }
}
