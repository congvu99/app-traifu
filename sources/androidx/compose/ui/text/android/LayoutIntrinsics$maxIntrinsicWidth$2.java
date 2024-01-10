package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LayoutIntrinsics.kt */
final class LayoutIntrinsics$maxIntrinsicWidth$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ TextPaint $textPaint;
    final /* synthetic */ LayoutIntrinsics this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$maxIntrinsicWidth$2(LayoutIntrinsics layoutIntrinsics, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.this$0 = layoutIntrinsics;
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    public final Float invoke() {
        BoringLayout.Metrics boringMetrics = this.this$0.getBoringMetrics();
        Float valueOf = boringMetrics != null ? Float.valueOf((float) boringMetrics.width) : null;
        if (valueOf == null) {
            CharSequence charSequence = this.$charSequence;
            valueOf = Float.valueOf((float) Math.ceil((double) Layout.getDesiredWidth(charSequence, 0, charSequence.length(), this.$textPaint)));
        }
        return LayoutIntrinsicsKt.shouldIncreaseMaxIntrinsic(valueOf.floatValue(), this.$charSequence, this.$textPaint) ? Float.valueOf(valueOf.floatValue() + 0.5f) : valueOf;
    }
}
