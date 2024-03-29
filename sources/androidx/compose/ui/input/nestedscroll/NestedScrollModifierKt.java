package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: NestedScrollModifier.kt */
public final class NestedScrollModifierKt {
    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }

    public static final Modifier nestedScroll(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "connection");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1(nestedScrollConnection, nestedScrollDispatcher) : InspectableValueKt.getNoInspectorInfo(), new NestedScrollModifierKt$nestedScroll$2(nestedScrollDispatcher, nestedScrollConnection));
    }
}
