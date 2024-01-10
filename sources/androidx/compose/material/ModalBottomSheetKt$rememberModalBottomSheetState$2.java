package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$rememberModalBottomSheetState$2 extends Lambda implements Function0<ModalBottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<ModalBottomSheetValue, Boolean> $confirmStateChange;
    final /* synthetic */ ModalBottomSheetValue $initialValue;
    final /* synthetic */ boolean $skipHalfExpanded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$rememberModalBottomSheetState$2(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z, Function1<? super ModalBottomSheetValue, Boolean> function1) {
        super(0);
        this.$initialValue = modalBottomSheetValue;
        this.$animationSpec = animationSpec;
        this.$skipHalfExpanded = z;
        this.$confirmStateChange = function1;
    }

    public final ModalBottomSheetState invoke() {
        return new ModalBottomSheetState(this.$initialValue, this.$animationSpec, this.$skipHalfExpanded, this.$confirmStateChange);
    }
}
