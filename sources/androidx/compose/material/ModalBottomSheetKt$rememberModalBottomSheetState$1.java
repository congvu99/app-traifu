package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$rememberModalBottomSheetState$1 extends Lambda implements Function1<ModalBottomSheetValue, Boolean> {
    public static final ModalBottomSheetKt$rememberModalBottomSheetState$1 INSTANCE = new ModalBottomSheetKt$rememberModalBottomSheetState$1();

    ModalBottomSheetKt$rememberModalBottomSheetState$1() {
        super(1);
    }

    public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return true;
    }
}
