package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"defaultDecayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidActualDefaultDecayAnimationSpec.android.kt */
public final class AndroidActualDefaultDecayAnimationSpec_androidKt {
    @Deprecated(message = "Replace with rememberSplineBasedDecay<Float>")
    public static final DecayAnimationSpec<Float> defaultDecayAnimationSpec(Composer composer, int i) {
        composer.startReplaceableGroup(-1686079097);
        ComposerKt.sourceInformation(composer, "C(defaultDecayAnimationSpec)24@906L26:AndroidActualDefaultDecayAnimationSpec.android.kt#xbi5r1");
        DecayAnimationSpec<Float> rememberSplineBasedDecay = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        composer.endReplaceableGroup();
        return rememberSplineBasedDecay;
    }
}
