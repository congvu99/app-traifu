package androidx.compose.ui.focus;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2 = {"ModifierLocalFocusEvent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusEventModifierLocal;", "getModifierLocalFocusEvent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "onFocusEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusState;", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusEventModifier.kt */
public final class FocusEventModifierKt {
    private static final ProvidableModifierLocal<FocusEventModifierLocal> ModifierLocalFocusEvent = ModifierLocalKt.modifierLocalOf(FocusEventModifierKt$ModifierLocalFocusEvent$1.INSTANCE);

    public static final ProvidableModifierLocal<FocusEventModifierLocal> getModifierLocalFocusEvent() {
        return ModifierLocalFocusEvent;
    }

    public static final Modifier onFocusEvent(Modifier modifier, Function1<? super FocusState, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onFocusEvent");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusEventModifierKt$onFocusEvent$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo(), new FocusEventModifierKt$onFocusEvent$2(function1));
    }
}
