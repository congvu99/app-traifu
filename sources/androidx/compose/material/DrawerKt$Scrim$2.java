package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$Scrim$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Float> $fraction;
    final /* synthetic */ Function0<Unit> $onClose;
    final /* synthetic */ boolean $open;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$2(boolean z, Function0<Unit> function0, Function0<Float> function02, long j, int i) {
        super(2);
        this.$open = z;
        this.$onClose = function0;
        this.$fraction = function02;
        this.$color = j;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DrawerKt.m1264ScrimBx497Mc(this.$open, this.$onClose, this.$fraction, this.$color, composer, this.$$changed | 1);
    }
}
