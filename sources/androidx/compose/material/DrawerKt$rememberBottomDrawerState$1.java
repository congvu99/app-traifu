package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$rememberBottomDrawerState$1 extends Lambda implements Function1<BottomDrawerValue, Boolean> {
    public static final DrawerKt$rememberBottomDrawerState$1 INSTANCE = new DrawerKt$rememberBottomDrawerState$1();

    DrawerKt$rememberBottomDrawerState$1() {
        super(1);
    }

    public final Boolean invoke(BottomDrawerValue bottomDrawerValue) {
        Intrinsics.checkNotNullParameter(bottomDrawerValue, "it");
        return true;
    }
}
