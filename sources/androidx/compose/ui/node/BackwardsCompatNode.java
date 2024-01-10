package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.focus.FocusPropertiesModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\rB\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010D\u001a\u00020\u001eH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020FH\u0016J\r\u0010I\u001a\u00020FH\u0000¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u00020F2\u0006\u0010L\u001a\u00020\"H\u0016J\u0010\u0010M\u001a\u00020F2\u0006\u0010L\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020FH\u0016J\u0010\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020\u001eH\u0002J\u0010\u0010R\u001a\u00020F2\u0006\u0010L\u001a\u00020\"H\u0016J-\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020F2\u0006\u00107\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010?J\b\u0010]\u001a\u00020\u001eH\u0016J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020FH\u0002J\u0006\u0010a\u001a\u00020FJ\u0006\u0010b\u001a\u00020FJ\u0012\u0010c\u001a\u00020F2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030dJ\f\u0010e\u001a\u00020F*\u00020fH\u0016J\u001c\u0010g\u001a\u00020h*\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020hH\u0016J\u001c\u0010m\u001a\u00020h*\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010n\u001a\u00020hH\u0016J)\u0010o\u001a\u00020p*\u00020q2\u0006\u0010j\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u001c\u0010w\u001a\u00020h*\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020hH\u0016J\u001c\u0010x\u001a\u00020h*\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010n\u001a\u00020hH\u0016J\u0018\u0010y\u001a\u0004\u0018\u00010z*\u00020\u00142\b\u0010{\u001a\u0004\u0018\u00010zH\u0016R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0010R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R2\u0010+\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u0002048VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001d\u00107\u001a\u0002088VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b9\u0010:R-\u0010<\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020;8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b=\u0010:\"\u0004\b>\u0010?R$\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u0002HA0-8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006|"}, d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "focusOrderElement", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "invalidateCache", "", "isValid", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "Landroidx/compose/ui/unit/IntSize;", "targetSize", "getTargetSize-YbymL2g", "setTargetSize-ozmzZPI", "(J)V", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "interceptOutOfBoundsChildEvents", "onAttach", "", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onGloballyPositioned", "coordinates", "onLookaheadPlaced", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "onMeasureResultChanged", "onModifierUpdated", "duringAttach", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "sharePointerInputWithSiblings", "toString", "", "updateDrawCache", "updateFocusOrderModifierLocalConsumer", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BackwardsCompatNode.kt */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, IntermediateLayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, OwnerScope, BuildDrawCacheParams {
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    /* access modifiers changed from: private */
    public FocusPropertiesModifier focusOrderElement;
    private boolean invalidateCache = true;
    /* access modifiers changed from: private */
    public LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues = new HashSet<>();

    public /* synthetic */ void forceRemeasure() {
        LayoutModifierNode.CC.$default$forceRemeasure(this);
    }

    public /* synthetic */ <T> void provide(ModifierLocal<T> modifierLocal, T t) {
        ModifierLocalNode.CC.$default$provide(this, modifierLocal, t);
    }

    public BackwardsCompatNode(Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        this.element = element2;
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element2, "value");
        this.element = element2;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element2));
        if (isAttached()) {
            onModifierUpdated(false);
        }
    }

    public void onDetach() {
        FocusPropertiesModifier focusPropertiesModifier;
        Modifier.Element element2 = this.element;
        Modifier.Node node = this;
        boolean z = true;
        if ((Nodes.INSTANCE.m3938getLocalsOLwlOKw() & node.getKindSet$ui_release()) != 0) {
            if (element2 instanceof ModifierLocalProvider) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element2).getKey());
            }
            if (element2 instanceof ModifierLocalConsumer) {
                ((ModifierLocalConsumer) element2).onModifierLocalsUpdated(BackwardsCompatNodeKt.DetachedModifierLocalReadScope);
            }
            if ((element2 instanceof FocusOrderModifier) && (focusPropertiesModifier = this.focusOrderElement) != null) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, focusPropertiesModifier.getKey());
            }
        }
        if ((Nodes.INSTANCE.m3941getSemanticsOLwlOKw() & node.getKindSet$ui_release()) == 0) {
            z = false;
        }
        if (z) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    public void onAttach() {
        onModifierUpdated(true);
    }

    private final void onModifierUpdated(boolean z) {
        if (isAttached()) {
            Modifier.Element element2 = this.element;
            Modifier.Node node = this;
            boolean z2 = false;
            if ((Nodes.INSTANCE.m3938getLocalsOLwlOKw() & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof ModifierLocalProvider) {
                    updateModifierLocalProvider((ModifierLocalProvider) element2);
                }
                if (element2 instanceof ModifierLocalConsumer) {
                    if (z) {
                        updateModifierLocalConsumer();
                    } else {
                        sideEffect(new BackwardsCompatNode$onModifierUpdated$1(this));
                    }
                }
                if (element2 instanceof FocusOrderModifier) {
                    FocusOrderModifierToProperties focusOrderModifierToProperties = new FocusOrderModifierToProperties((FocusOrderModifier) element2);
                    FocusPropertiesModifier focusPropertiesModifier = new FocusPropertiesModifier(focusOrderModifierToProperties, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BackwardsCompatNode$onModifierUpdated$$inlined$debugInspectorInfo$1(focusOrderModifierToProperties) : InspectableValueKt.getNoInspectorInfo());
                    this.focusOrderElement = focusPropertiesModifier;
                    Intrinsics.checkNotNull(focusPropertiesModifier);
                    updateModifierLocalProvider(focusPropertiesModifier);
                    if (z) {
                        updateFocusOrderModifierLocalConsumer();
                    } else {
                        sideEffect(new BackwardsCompatNode$onModifierUpdated$3(this));
                    }
                }
            }
            if ((Nodes.INSTANCE.m3933getDrawOLwlOKw() & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof DrawCacheModifier) {
                    this.invalidateCache = true;
                }
                LayoutModifierNodeKt.invalidateLayer(this);
            }
            if ((Nodes.INSTANCE.m3936getLayoutOLwlOKw() & node.getKindSet$ui_release()) != 0) {
                DelegatableNode delegatableNode = this;
                if (DelegatableNodeKt.requireLayoutNode(delegatableNode).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release);
                    ((LayoutModifierNodeCoordinator) coordinator$ui_release).setLayoutModifierNode$ui_release(this);
                    coordinator$ui_release.onLayoutModifierNodeChanged();
                }
                LayoutModifierNodeKt.invalidateLayer(this);
                DelegatableNodeKt.requireLayoutNode(delegatableNode).invalidateMeasurements$ui_release();
            }
            if (element2 instanceof RemeasurementModifier) {
                ((RemeasurementModifier) element2).onRemeasurementAvailable(this);
            }
            if ((Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw() & node.getKindSet$ui_release()) != 0) {
                if (element2 instanceof OnRemeasuredModifier) {
                    DelegatableNode delegatableNode2 = this;
                    if (DelegatableNodeKt.requireLayoutNode(delegatableNode2).getNodes$ui_release().getTail$ui_release().isAttached()) {
                        DelegatableNodeKt.requireLayoutNode(delegatableNode2).invalidateMeasurements$ui_release();
                    }
                }
                if (element2 instanceof OnPlacedModifier) {
                    this.lastOnPlacedCoordinates = null;
                    DelegatableNode delegatableNode3 = this;
                    if (DelegatableNodeKt.requireLayoutNode(delegatableNode3).getNodes$ui_release().getTail$ui_release().isAttached()) {
                        DelegatableNodeKt.requireOwner(delegatableNode3).registerOnLayoutCompletedListener(new BackwardsCompatNode$onModifierUpdated$4(this));
                    }
                }
            }
            if (((Nodes.INSTANCE.m3934getGlobalPositionAwareOLwlOKw() & node.getKindSet$ui_release()) != 0) && (element2 instanceof OnGloballyPositionedModifier)) {
                DelegatableNode delegatableNode4 = this;
                if (DelegatableNodeKt.requireLayoutNode(delegatableNode4).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    DelegatableNodeKt.requireLayoutNode(delegatableNode4).invalidateMeasurements$ui_release();
                }
            }
            if (((Nodes.INSTANCE.m3940getPointerInputOLwlOKw() & node.getKindSet$ui_release()) != 0) && (element2 instanceof PointerInputModifier)) {
                ((PointerInputModifier) element2).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
            }
            if ((Nodes.INSTANCE.m3941getSemanticsOLwlOKw() & node.getKindSet$ui_release()) != 0) {
                z2 = true;
            }
            if (z2) {
                DelegatableNodeKt.requireOwner(this).onSemanticsChange();
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m3730getSizeNHjbRc() {
        return IntSizeKt.m4874toSizeozmzZPI(DelegatableNodeKt.m3750requireCoordinator64DMado(this, Nodes.INSTANCE.m3937getLayoutAwareOLwlOKw()).m3895getSizeYbymL2g());
    }

    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    private final void updateDrawCache() {
        Modifier.Element element2 = this.element;
        if (element2 instanceof DrawCacheModifier) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.onDrawCacheReadsChanged, new BackwardsCompatNode$updateDrawCache$1(element2, this));
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getCurrent(androidx.compose.ui.modifier.ModifierLocal<T> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.HashSet<androidx.compose.ui.modifier.ModifierLocal<?>> r0 = r5.readValues
            r0.add(r6)
            r0 = r5
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            androidx.compose.ui.node.Nodes r1 = androidx.compose.ui.node.Nodes.INSTANCE
            int r1 = r1.m3938getLocalsOLwlOKw()
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x007e
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0029:
            if (r0 == 0) goto L_0x0075
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0062
        L_0x003a:
            if (r2 == 0) goto L_0x0062
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x005d
            boolean r3 = r2 instanceof androidx.compose.ui.modifier.ModifierLocalNode
            if (r3 == 0) goto L_0x005d
            r3 = r2
            androidx.compose.ui.modifier.ModifierLocalNode r3 = (androidx.compose.ui.modifier.ModifierLocalNode) r3
            androidx.compose.ui.modifier.ModifierLocalMap r4 = r3.getProvidedValues()
            boolean r4 = r4.contains$ui_release(r6)
            if (r4 == 0) goto L_0x005d
            androidx.compose.ui.modifier.ModifierLocalMap r0 = r3.getProvidedValues()
            java.lang.Object r6 = r0.get$ui_release(r6)
            return r6
        L_0x005d:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x003a
        L_0x0062:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0073
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x0073
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x0029
        L_0x0073:
            r2 = 0
            goto L_0x0029
        L_0x0075:
            kotlin.jvm.functions.Function0 r6 = r6.getDefaultFactory$ui_release()
            java.lang.Object r6 = r6.invoke()
            return r6
        L_0x007e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.BackwardsCompatNode.getCurrent(androidx.compose.ui.modifier.ModifierLocal):java.lang.Object");
    }

    public final void updateModifierLocalConsumer() {
        if (isAttached()) {
            this.readValues.clear();
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateModifierLocalConsumer, new BackwardsCompatNode$updateModifierLocalConsumer$1(this));
        }
    }

    public final void updateFocusOrderModifierLocalConsumer() {
        if (isAttached()) {
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, BackwardsCompatNodeKt.updateFocusOrderModifierLocalConsumer, new BackwardsCompatNode$updateFocusOrderModifierLocalConsumer$1(this));
        }
    }

    public final void updateModifierLocalProvider(ModifierLocalProvider<?> modifierLocalProvider) {
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "element");
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap == null || !backwardsCompatLocalMap.contains$ui_release(modifierLocalProvider.getKey())) {
            this._providedValues = new BackwardsCompatLocalMap(modifierLocalProvider);
            DelegatableNode delegatableNode = this;
            if (DelegatableNodeKt.requireLayoutNode(delegatableNode).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireOwner(delegatableNode).getModifierLocalManager().insertedProvider(this, modifierLocalProvider.getKey());
                return;
            }
            return;
        }
        backwardsCompatLocalMap.setElement(modifierLocalProvider);
        DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, modifierLocalProvider.getKey());
    }

    public boolean isValid() {
        return isAttached();
    }

    /* renamed from: getTargetSize-YbymL2g  reason: not valid java name */
    public long m3731getTargetSizeYbymL2g() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return ((IntermediateLayoutModifier) element2).m3597getTargetSizeYbymL2g();
    }

    /* renamed from: setTargetSize-ozmzZPI  reason: not valid java name */
    public void m3735setTargetSizeozmzZPI(long j) {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        ((IntermediateLayoutModifier) element2).m3598setTargetSizeozmzZPI(j);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3732measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).m3621measure3p2s80s(measureScope, measurable, j);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element2).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element2;
        if (this.invalidateCache && (element2 instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier.draw(contentDrawScope);
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return ((SemanticsModifier) element2).getSemanticsConfiguration();
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m3733onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().m3450onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    public void onCancelPointerInput() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element2).getPointerInputFilter().onCancel();
    }

    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getShareWithSiblings();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element2).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    public Object modifyParentData(Density density, Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element2).modifyParentData(density, obj);
    }

    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Modifier.Element element2 = this.element;
        Intrinsics.checkNotNull(element2, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element2).onGloballyPositioned(layoutCoordinates);
    }

    public void onLookaheadPlaced(LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        Modifier.Element element2 = this.element;
        if (element2 instanceof LookaheadOnPlacedModifier) {
            ((LookaheadOnPlacedModifier) element2).onPlaced(lookaheadLayoutCoordinates);
        }
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    public void m3734onRemeasuredozmzZPI(long j) {
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element2).m3679onRemeasuredozmzZPI(j);
        }
    }

    public void onPlaced(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.lastOnPlacedCoordinates = layoutCoordinates;
        Modifier.Element element2 = this.element;
        if (element2 instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element2).onPlaced(layoutCoordinates);
        }
    }

    public String toString() {
        return this.element.toString();
    }
}
