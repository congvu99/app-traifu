package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.Transition;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0006"}, d2 = {"parse", "Landroidx/compose/ui/tooling/animation/TransitionComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "", "parseAnimatedVisibility", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityComposeAnimation;", "ui-tooling_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeAnimationParser.kt */
public final class ComposeAnimationParserKt {
    public static final TransitionComposeAnimation parse(Transition<Object> transition) {
        Set set;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "Transition subscribed");
        Object initialState = transition.getSegment().getInitialState();
        Object[] enumConstants = initialState.getClass().getEnumConstants();
        if (enumConstants == null || (set = ArraysKt.toSet((T[]) enumConstants)) == null) {
            set = SetsKt.setOf(initialState);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(initialState.getClass()).getSimpleName();
        }
        return new TransitionComposeAnimation(transition, set, label);
    }

    public static final AnimatedVisibilityComposeAnimation parseAnimatedVisibility(Transition<Object> transition) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "AnimatedVisibility transition subscribed");
        String label = transition.getLabel();
        if (label == null) {
            label = "AnimatedVisibility";
        }
        return new AnimatedVisibilityComposeAnimation(transition, label);
    }
}
