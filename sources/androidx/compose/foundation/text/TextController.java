package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020 2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\f\u0010.\u001a\u00020\u0006*\u00020\u0006H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"Landroidx/compose/foundation/text/TextController;", "Landroidx/compose/runtime/RememberObserver;", "state", "Landroidx/compose/foundation/text/TextState;", "(Landroidx/compose/foundation/text/TextState;)V", "coreModifiers", "Landroidx/compose/ui/Modifier;", "longPressDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getLongPressDragObserver", "()Landroidx/compose/foundation/text/TextDragObserver;", "setLongPressDragObserver", "(Landroidx/compose/foundation/text/TextDragObserver;)V", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "modifiers", "getModifiers", "()Landroidx/compose/ui/Modifier;", "selectionModifiers", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "<set-?>", "semanticsModifier", "getSemanticsModifier$foundation_release", "getState", "()Landroidx/compose/foundation/text/TextState;", "createSemanticsModifierFor", "text", "Landroidx/compose/ui/text/AnnotatedString;", "onAbandoned", "", "onForgotten", "onRemembered", "outOfBoundary", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "outOfBoundary-0a9Yr6o", "(JJ)Z", "setTextDelegate", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "update", "drawTextAndSelectionBehind", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextController implements RememberObserver {
    private final Modifier coreModifiers = OnGloballyPositionedModifierKt.onGloballyPositioned(drawTextAndSelectionBehind(Modifier.Companion), new TextController$coreModifiers$1(this));
    public TextDragObserver longPressDragObserver;
    private final MeasurePolicy measurePolicy = new TextController$measurePolicy$1(this);
    private Modifier selectionModifiers = Modifier.Companion;
    /* access modifiers changed from: private */
    public SelectionRegistrar selectionRegistrar;
    private Modifier semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
    private final TextState state;

    public TextController(TextState textState) {
        Intrinsics.checkNotNullParameter(textState, "state");
        this.state = textState;
    }

    public final TextState getState() {
        return this.state;
    }

    public final TextDragObserver getLongPressDragObserver() {
        TextDragObserver textDragObserver = this.longPressDragObserver;
        if (textDragObserver != null) {
            return textDragObserver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("longPressDragObserver");
        return null;
    }

    public final void setLongPressDragObserver(TextDragObserver textDragObserver) {
        Intrinsics.checkNotNullParameter(textDragObserver, "<set-?>");
        this.longPressDragObserver = textDragObserver;
    }

    public final void update(SelectionRegistrar selectionRegistrar2) {
        Modifier modifier;
        this.selectionRegistrar = selectionRegistrar2;
        if (selectionRegistrar2 == null) {
            modifier = Modifier.Companion;
        } else if (TouchMode_androidKt.isInTouchMode()) {
            setLongPressDragObserver(new TextController$update$1(this, selectionRegistrar2));
            modifier = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) getLongPressDragObserver(), (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextController$update$2(this, (Continuation<? super TextController$update$2>) null));
        } else {
            TextController$update$mouseSelectionObserver$1 textController$update$mouseSelectionObserver$1 = new TextController$update$mouseSelectionObserver$1(this, selectionRegistrar2);
            modifier = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textController$update$mouseSelectionObserver$1, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextController$update$3(textController$update$mouseSelectionObserver$1, (Continuation<? super TextController$update$3>) null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, (Object) null);
        }
        this.selectionModifiers = modifier;
    }

    public final void setTextDelegate(TextDelegate textDelegate) {
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        if (this.state.getTextDelegate() != textDelegate) {
            this.state.setTextDelegate(textDelegate);
            this.semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
        }
    }

    public final MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    /* access modifiers changed from: private */
    /* renamed from: outOfBoundary-0a9Yr6o  reason: not valid java name */
    public final boolean m924outOfBoundary0a9Yr6o(long j, long j2) {
        TextLayoutResult layoutResult = this.state.getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        int length = layoutResult.getLayoutInput().getText().getText().length();
        int r4 = layoutResult.m4195getOffsetForPositionk4lQ0M(j);
        int r5 = layoutResult.m4195getOffsetForPositionk4lQ0M(j2);
        int i = length - 1;
        if ((r4 < i || r5 < i) && (r4 >= 0 || r5 >= 0)) {
            return false;
        }
        return true;
    }

    private final Modifier drawTextAndSelectionBehind(Modifier modifier) {
        return DrawModifierKt.drawBehind(GraphicsLayerModifierKt.m2069graphicsLayerpANQ8Wg$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65535, (Object) null), new TextController$drawTextAndSelectionBehind$1(this));
    }

    public final Modifier getSemanticsModifier$foundation_release() {
        return this.semanticsModifier;
    }

    private final Modifier createSemanticsModifierFor(AnnotatedString annotatedString) {
        return SemanticsModifierKt.semantics$default(Modifier.Companion, false, new TextController$createSemanticsModifierFor$1(annotatedString, this), 1, (Object) null);
    }

    public final Modifier getModifiers() {
        return this.coreModifiers.then(this.semanticsModifier).then(this.selectionModifiers);
    }

    public void onRemembered() {
        SelectionRegistrar selectionRegistrar2 = this.selectionRegistrar;
        if (selectionRegistrar2 != null) {
            TextState textState = this.state;
            textState.setSelectable(selectionRegistrar2.subscribe(new MultiWidgetSelectionDelegate(textState.getSelectableId(), new TextController$onRemembered$1$1(this), new TextController$onRemembered$1$2(this))));
        }
    }

    public void onForgotten() {
        SelectionRegistrar selectionRegistrar2;
        Selectable selectable = this.state.getSelectable();
        if (selectable != null && (selectionRegistrar2 = this.selectionRegistrar) != null) {
            selectionRegistrar2.unsubscribe(selectable);
        }
    }

    public void onAbandoned() {
        SelectionRegistrar selectionRegistrar2;
        Selectable selectable = this.state.getSelectable();
        if (selectable != null && (selectionRegistrar2 = this.selectionRegistrar) != null) {
            selectionRegistrar2.unsubscribe(selectable);
        }
    }
}
