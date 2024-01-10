package androidx.compose.ui.viewinterop;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$AndroidView$modifierWithSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final AndroidView_androidKt$AndroidView$modifierWithSemantics$1 INSTANCE = new AndroidView_androidKt$AndroidView$modifierWithSemantics$1();

    AndroidView_androidKt$AndroidView$modifierWithSemantics$1() {
        super(1);
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }
}
