package androidx.compose.ui.layout;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jg\u0010\t\u001a\u00020\n*\u00020\n2V\u0010\u000b\u001aR\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\f¢\u0006\u0002\b\u0017H\u0016ø\u0001\u0000JD\u0010\u0018\u001a\u00020\n*\u00020\n26\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0019H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutScopeImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutScope;", "()V", "root", "Landroidx/compose/ui/node/NodeCoordinator;", "getRoot", "()Landroidx/compose/ui/node/NodeCoordinator;", "setRoot", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "intermediateLayout", "Landroidx/compose/ui/Modifier;", "measure", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "onPlaced", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadScopeCoordinates", "layoutCoordinates", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutScopeImpl implements LookaheadLayoutScope {
    private NodeCoordinator root;

    public final NodeCoordinator getRoot() {
        return this.root;
    }

    public final void setRoot(NodeCoordinator nodeCoordinator) {
        this.root = nodeCoordinator;
    }

    public Modifier intermediateLayout(Modifier modifier, Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> function4) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function4, "measure");
        return modifier.then(new LookaheadIntermediateLayoutModifierImpl(function4, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LookaheadLayoutScopeImpl$intermediateLayout$$inlined$debugInspectorInfo$1(function4) : InspectableValueKt.getNoInspectorInfo()));
    }

    public Modifier onPlaced(Modifier modifier, Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function2, "onPlaced");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LookaheadLayoutScopeImpl$onPlaced$$inlined$debugInspectorInfo$1(function2) : InspectableValueKt.getNoInspectorInfo(), new LookaheadLayoutScopeImpl$onPlaced$2(function2, this));
    }
}
