package androidx.compose.material;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$FilterChip$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final ChipKt$FilterChip$2 INSTANCE = new ChipKt$FilterChip$2();

    ChipKt$FilterChip$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.m4104setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m4092getCheckboxo7Vup1c());
    }
}
