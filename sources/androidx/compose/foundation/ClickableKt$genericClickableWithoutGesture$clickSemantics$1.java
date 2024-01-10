package androidx.compose.foundation;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$genericClickableWithoutGesture$clickSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$clickSemantics$1(Role role, String str, Function0<Unit> function0, String str2, boolean z, Function0<Unit> function02) {
        super(1);
        this.$role = role;
        this.$onClickLabel = str;
        this.$onLongClick = function0;
        this.$onLongClickLabel = str2;
        this.$enabled = z;
        this.$onClick = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        Role role = this.$role;
        if (role != null) {
            SemanticsPropertiesKt.m4104setRolekuIjeqM(semanticsPropertyReceiver, role.m4090unboximpl());
        }
        String str = this.$onClickLabel;
        final Function0<Unit> function0 = this.$onClick;
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, str, new Function0<Boolean>() {
            public final Boolean invoke() {
                function0.invoke();
                return true;
            }
        });
        final Function0<Unit> function02 = this.$onLongClick;
        if (function02 != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.$onLongClickLabel, new Function0<Boolean>() {
                public final Boolean invoke() {
                    function02.invoke();
                    return true;
                }
            });
        }
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
    }
}
