package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$rememberBottomDrawerState$2 extends Lambda implements Function0<BottomDrawerState> {
    final /* synthetic */ Function1<BottomDrawerValue, Boolean> $confirmStateChange;
    final /* synthetic */ BottomDrawerValue $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$rememberBottomDrawerState$2(BottomDrawerValue bottomDrawerValue, Function1<? super BottomDrawerValue, Boolean> function1) {
        super(0);
        this.$initialValue = bottomDrawerValue;
        this.$confirmStateChange = function1;
    }

    public final BottomDrawerState invoke() {
        return new BottomDrawerState(this.$initialValue, this.$confirmStateChange);
    }
}
