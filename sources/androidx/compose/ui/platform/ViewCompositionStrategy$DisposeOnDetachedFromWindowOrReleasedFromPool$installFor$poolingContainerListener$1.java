package androidx.compose.ui.platform;

import androidx.customview.poolingcontainer.PoolingContainerListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewCompositionStrategy.android.kt */
final class ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1 implements PoolingContainerListener {
    final /* synthetic */ AbstractComposeView $view;

    ViewCompositionStrategy$DisposeOnDetachedFromWindowOrReleasedFromPool$installFor$poolingContainerListener$1(AbstractComposeView abstractComposeView) {
        this.$view = abstractComposeView;
    }

    public final void onRelease() {
        this.$view.disposeComposition();
    }
}
