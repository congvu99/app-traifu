package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$rememberDrawerState$1 extends Lambda implements Function1<DrawerValue, Boolean> {
    public static final DrawerKt$rememberDrawerState$1 INSTANCE = new DrawerKt$rememberDrawerState$1();

    DrawerKt$rememberDrawerState$1() {
        super(1);
    }

    public final Boolean invoke(DrawerValue drawerValue) {
        Intrinsics.checkNotNullParameter(drawerValue, "it");
        return true;
    }
}
