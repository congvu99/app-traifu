package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000\u001a!\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"ModifierLocalKeyInput", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/input/key/KeyInputModifier;", "getModifierLocalKeyInput", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "onKeyEvent", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreviewKeyEvent", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeyInputModifier.kt */
public final class KeyInputModifierKt {
    private static final ProvidableModifierLocal<KeyInputModifier> ModifierLocalKeyInput = ModifierLocalKt.modifierLocalOf(KeyInputModifierKt$ModifierLocalKeyInput$1.INSTANCE);

    public static final ProvidableModifierLocal<KeyInputModifier> getModifierLocalKeyInput() {
        return ModifierLocalKeyInput;
    }

    public static final Modifier onKeyEvent(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onKeyEvent");
        Function1<InspectorInfo, Unit> keyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new KeyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, keyInputModifierKt$onKeyEvent$$inlined$debugInspectorInfo$1, new KeyInputModifier(function1, (Function1<? super KeyEvent, Boolean>) null));
    }

    public static final Modifier onPreviewKeyEvent(Modifier modifier, Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPreviewKeyEvent");
        Function1<InspectorInfo, Unit> keyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1 = InspectableValueKt.isDebugInspectorInfoEnabled() ? new KeyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo();
        Modifier modifier2 = Modifier.Companion;
        return InspectableValueKt.inspectableWrapper(modifier, keyInputModifierKt$onPreviewKeyEvent$$inlined$debugInspectorInfo$1, new KeyInputModifier((Function1<? super KeyEvent, Boolean>) null, function1));
    }
}
