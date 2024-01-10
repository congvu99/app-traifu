package com.google.accompanist.placeholder;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Placeholder.kt */
final class PlaceholderDefaults$fadeAnimationSpec$2 extends Lambda implements Function0<InfiniteRepeatableSpec<Float>> {
    public static final PlaceholderDefaults$fadeAnimationSpec$2 INSTANCE = new PlaceholderDefaults$fadeAnimationSpec$2();

    PlaceholderDefaults$fadeAnimationSpec$2() {
        super(0);
    }

    public final InfiniteRepeatableSpec<Float> invoke() {
        return AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(600, 200, (Easing) null, 4, (Object) null), RepeatMode.Reverse, 0, 4, (Object) null);
    }
}
