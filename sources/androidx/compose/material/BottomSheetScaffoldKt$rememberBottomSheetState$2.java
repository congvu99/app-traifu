package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$rememberBottomSheetState$2 extends Lambda implements Function0<BottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<BottomSheetValue, Boolean> $confirmStateChange;
    final /* synthetic */ BottomSheetValue $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$rememberBottomSheetState$2(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        super(0);
        this.$initialValue = bottomSheetValue;
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
    }

    public final BottomSheetState invoke() {
        return new BottomSheetState(this.$initialValue, this.$animationSpec, this.$confirmStateChange);
    }
}
