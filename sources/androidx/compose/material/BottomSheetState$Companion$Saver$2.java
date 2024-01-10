package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/BottomSheetState;", "it", "Landroidx/compose/material/BottomSheetValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetState$Companion$Saver$2 extends Lambda implements Function1<BottomSheetValue, BottomSheetState> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<BottomSheetValue, Boolean> $confirmStateChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetState$Companion$Saver$2(AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
    }

    public final BottomSheetState invoke(BottomSheetValue bottomSheetValue) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "it");
        return new BottomSheetState(bottomSheetValue, this.$animationSpec, this.$confirmStateChange);
    }
}
