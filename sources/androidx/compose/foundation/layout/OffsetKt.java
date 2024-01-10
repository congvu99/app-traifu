package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006ø\u0001\u0000\u001a-\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"absoluteOffset", "Landroidx/compose/ui/Modifier;", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "absoluteOffset-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "offset-VpY3zN4", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Offset.kt */
public final class OffsetKt {
    /* renamed from: offset-VpY3zN4  reason: not valid java name */
    public static final Modifier m496offsetVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$offset");
        return modifier.then(new OffsetModifier(f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: absoluteOffset-VpY3zN4  reason: not valid java name */
    public static final Modifier m494absoluteOffsetVpY3zN4(Modifier modifier, float f, float f2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$absoluteOffset");
        return modifier.then(new OffsetModifier(f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$absoluteOffsetVpY3zN4$$inlined$debugInspectorInfo$1(f, f2) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static final Modifier offset(Modifier modifier, Function1<? super Density, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, TypedValues.CycleType.S_WAVE_OFFSET);
        return modifier.then(new OffsetPxModifier(function1, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$offset$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final Modifier absoluteOffset(Modifier modifier, Function1<? super Density, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, TypedValues.CycleType.S_WAVE_OFFSET);
        return modifier.then(new OffsetPxModifier(function1, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$absoluteOffset$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* renamed from: offset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m497offsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4704constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4704constructorimpl((float) 0);
        }
        return m496offsetVpY3zN4(modifier, f, f2);
    }

    /* renamed from: absoluteOffset-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m495absoluteOffsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m4704constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m4704constructorimpl((float) 0);
        }
        return m494absoluteOffsetVpY3zN4(modifier, f, f2);
    }
}
