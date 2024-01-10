package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/ModalBottomSheetState;", "it", "Landroidx/compose/material/ModalBottomSheetValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetState$Companion$Saver$2 extends Lambda implements Function1<ModalBottomSheetValue, ModalBottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<ModalBottomSheetValue, Boolean> $confirmStateChange;
    final /* synthetic */ boolean $skipHalfExpanded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetState$Companion$Saver$2(AnimationSpec<Float> animationSpec, boolean z, Function1<? super ModalBottomSheetValue, Boolean> function1) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$skipHalfExpanded = z;
        this.$confirmStateChange = function1;
    }

    public final ModalBottomSheetState invoke(ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return new ModalBottomSheetState(modalBottomSheetValue, this.$animationSpec, this.$skipHalfExpanded, this.$confirmStateChange);
    }
}
