package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$rememberBottomSheetState$1 extends Lambda implements Function1<BottomSheetValue, Boolean> {
    public static final BottomSheetScaffoldKt$rememberBottomSheetState$1 INSTANCE = new BottomSheetScaffoldKt$rememberBottomSheetState$1();

    BottomSheetScaffoldKt$rememberBottomSheetState$1() {
        super(1);
    }

    public final Boolean invoke(BottomSheetValue bottomSheetValue) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "it");
        return true;
    }
}
