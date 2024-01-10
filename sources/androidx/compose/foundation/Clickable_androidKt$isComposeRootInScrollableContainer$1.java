package androidx.compose.foundation;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Clickable.android.kt */
final class Clickable_androidKt$isComposeRootInScrollableContainer$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ View $view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Clickable_androidKt$isComposeRootInScrollableContainer$1(View view) {
        super(0);
        this.$view = view;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(Clickable_androidKt.isInScrollableViewGroup(this.$view));
    }
}
