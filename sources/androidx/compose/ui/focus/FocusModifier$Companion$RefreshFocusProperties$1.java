package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "focusModifier", "Landroidx/compose/ui/focus/FocusModifier;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusModifier.kt */
final class FocusModifier$Companion$RefreshFocusProperties$1 extends Lambda implements Function1<FocusModifier, Unit> {
    public static final FocusModifier$Companion$RefreshFocusProperties$1 INSTANCE = new FocusModifier$Companion$RefreshFocusProperties$1();

    FocusModifier$Companion$RefreshFocusProperties$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusModifier) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        FocusPropertiesKt.refreshFocusProperties(focusModifier);
    }
}
