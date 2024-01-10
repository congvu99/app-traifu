package androidx.compose.foundation;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\t\u001a\u00020\n*\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007\"0\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"ModifierLocalFocusedBoundsObserver", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "getModifierLocalFocusedBoundsObserver$annotations", "()V", "getModifierLocalFocusedBoundsObserver", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "onFocusedBoundsChanged", "Landroidx/compose/ui/Modifier;", "onPositioned", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: FocusedBounds.kt */
public final class FocusedBoundsKt {
    private static final ProvidableModifierLocal<Function1<LayoutCoordinates, Unit>> ModifierLocalFocusedBoundsObserver = ModifierLocalKt.modifierLocalOf(FocusedBoundsKt$ModifierLocalFocusedBoundsObserver$1.INSTANCE);

    public static /* synthetic */ void getModifierLocalFocusedBoundsObserver$annotations() {
    }

    public static final ProvidableModifierLocal<Function1<LayoutCoordinates, Unit>> getModifierLocalFocusedBoundsObserver() {
        return ModifierLocalFocusedBoundsObserver;
    }

    @ExperimentalFoundationApi
    public static final Modifier onFocusedBoundsChanged(Modifier modifier, Function1<? super LayoutCoordinates, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onPositioned");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusedBoundsKt$onFocusedBoundsChanged$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo(), new FocusedBoundsKt$onFocusedBoundsChanged$2(function1));
    }
}
