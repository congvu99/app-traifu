package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/text/BoringLayout$Metrics;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutIntrinsics.kt */
final class LayoutIntrinsics$boringMetrics$2 extends Lambda implements Function0<BoringLayout.Metrics> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ int $textDirectionHeuristic;
    final /* synthetic */ TextPaint $textPaint;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$boringMetrics$2(int i, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.$textDirectionHeuristic = i;
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    public final BoringLayout.Metrics invoke() {
        return BoringLayoutFactory.INSTANCE.measure(this.$charSequence, this.$textPaint, TextLayoutKt.getTextDirectionHeuristic(this.$textDirectionHeuristic));
    }
}
