package androidx.compose.ui.input.rotary;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.focus.FocusAwareInputModifier;
import androidx.compose.ui.input.focus.FocusDirectedInputEvent;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0003\u001a \u0010\f\u001a\u00020\r*\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\u001a \u0010\u000e\u001a\u00020\r*\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\tH\u0007\"*\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"ModifierLocalRotaryScrollParent", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/focus/FocusAwareInputModifier;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getModifierLocalRotaryScrollParent$annotations", "()V", "getModifierLocalRotaryScrollParent", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusAwareCallback", "Lkotlin/Function1;", "Landroidx/compose/ui/input/focus/FocusDirectedInputEvent;", "", "onPreRotaryScrollEvent", "Landroidx/compose/ui/Modifier;", "onRotaryScrollEvent", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: RotaryInputModifier.kt */
public final class RotaryInputModifierKt {
    private static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> ModifierLocalRotaryScrollParent = ModifierLocalKt.modifierLocalOf(RotaryInputModifierKt$ModifierLocalRotaryScrollParent$1.INSTANCE);

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getModifierLocalRotaryScrollParent$annotations() {
    }

    public static final ProvidableModifierLocal<FocusAwareInputModifier<RotaryScrollEvent>> getModifierLocalRotaryScrollParent() {
        return ModifierLocalRotaryScrollParent;
    }

    @ExperimentalComposeUiApi
    private static final Function1<FocusDirectedInputEvent, Boolean> focusAwareCallback(Function1<? super RotaryScrollEvent, Boolean> function1) {
        return new RotaryInputModifierKt$focusAwareCallback$1(function1);
    }

    @ExperimentalComposeUiApi
    public static final Modifier onRotaryScrollEvent(Modifier modifier, Function1<? super RotaryScrollEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onRotaryScrollEvent");
        Function1<InspectorInfo, Unit> rotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new RotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, rotaryInputModifierKt$onRotaryScrollEvent$$inlined$debugInspectorInfo$1, new FocusAwareInputModifier(focusAwareCallback(function1), (Function1<? super FocusDirectedInputEvent, Boolean>) null, ModifierLocalRotaryScrollParent));
    }

    @ExperimentalComposeUiApi
    public static final Modifier onPreRotaryScrollEvent(Modifier modifier, Function1<? super RotaryScrollEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPreRotaryScrollEvent");
        Function1<InspectorInfo, Unit> rotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new RotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, rotaryInputModifierKt$onPreRotaryScrollEvent$$inlined$debugInspectorInfo$1, new FocusAwareInputModifier((Function1<? super FocusDirectedInputEvent, Boolean>) null, focusAwareCallback(function1), ModifierLocalRotaryScrollParent));
    }
}
