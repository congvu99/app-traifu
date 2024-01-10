package androidx.compose.ui.platform;

import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconDefaults;
import androidx.compose.ui.input.pointer.PointerIconService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$pointerIconService$1", "Landroidx/compose/ui/input/pointer/PointerIconService;", "value", "Landroidx/compose/ui/input/pointer/PointerIcon;", "current", "getCurrent", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setCurrent", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$pointerIconService$1 implements PointerIconService {
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$pointerIconService$1(AndroidComposeView androidComposeView) {
        this.this$0 = androidComposeView;
    }

    public PointerIcon getCurrent() {
        PointerIcon access$getDesiredPointerIcon$p = this.this$0.desiredPointerIcon;
        return access$getDesiredPointerIcon$p == null ? PointerIconDefaults.INSTANCE.getDefault() : access$getDesiredPointerIcon$p;
    }

    public void setCurrent(PointerIcon pointerIcon) {
        Intrinsics.checkNotNullParameter(pointerIcon, "value");
        this.this$0.desiredPointerIcon = pointerIcon;
    }
}
