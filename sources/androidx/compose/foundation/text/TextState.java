package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b0\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R%\u0010#\u001a\u00020$X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R%\u00101\u001a\u000202X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/foundation/text/TextState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "selectableId", "", "(Landroidx/compose/foundation/text/TextDelegate;J)V", "<set-?>", "", "drawScopeInvalidation", "getDrawScopeInvalidation", "()Lkotlin/Unit;", "setDrawScopeInvalidation", "(Lkotlin/Unit;)V", "drawScopeInvalidation$delegate", "Landroidx/compose/runtime/MutableState;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "value", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "onTextLayout", "Lkotlin/Function1;", "getOnTextLayout", "()Lkotlin/jvm/functions/Function1;", "setOnTextLayout", "(Lkotlin/jvm/functions/Function1;)V", "previousGlobalPosition", "Landroidx/compose/ui/geometry/Offset;", "getPreviousGlobalPosition-F1C5BW0", "()J", "setPreviousGlobalPosition-k-4lQ0M", "(J)V", "J", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "getSelectable", "()Landroidx/compose/foundation/text/selection/Selectable;", "setSelectable", "(Landroidx/compose/foundation/text/selection/Selectable;)V", "getSelectableId", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "setSelectionBackgroundColor-8_81llA", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextState {
    private final MutableState drawScopeInvalidation$delegate = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
    private LayoutCoordinates layoutCoordinates;
    private TextLayoutResult layoutResult;
    private Function1<? super TextLayoutResult, Unit> onTextLayout = TextState$onTextLayout$1.INSTANCE;
    private long previousGlobalPosition = Offset.Companion.m1699getZeroF1C5BW0();
    private Selectable selectable;
    private final long selectableId;
    private long selectionBackgroundColor = Color.Companion.m1968getUnspecified0d7_KjU();
    private TextDelegate textDelegate;

    public TextState(TextDelegate textDelegate2, long j) {
        Intrinsics.checkNotNullParameter(textDelegate2, "textDelegate");
        this.textDelegate = textDelegate2;
        this.selectableId = j;
    }

    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setTextDelegate(TextDelegate textDelegate2) {
        Intrinsics.checkNotNullParameter(textDelegate2, "<set-?>");
        this.textDelegate = textDelegate2;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public final Function1<TextLayoutResult, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    public final void setOnTextLayout(Function1<? super TextLayoutResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onTextLayout = function1;
    }

    public final Selectable getSelectable() {
        return this.selectable;
    }

    public final void setSelectable(Selectable selectable2) {
        this.selectable = selectable2;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final void setLayoutResult(TextLayoutResult textLayoutResult) {
        setDrawScopeInvalidation(Unit.INSTANCE);
        this.layoutResult = textLayoutResult;
    }

    /* renamed from: getPreviousGlobalPosition-F1C5BW0  reason: not valid java name */
    public final long m972getPreviousGlobalPositionF1C5BW0() {
        return this.previousGlobalPosition;
    }

    /* renamed from: setPreviousGlobalPosition-k-4lQ0M  reason: not valid java name */
    public final void m974setPreviousGlobalPositionk4lQ0M(long j) {
        this.previousGlobalPosition = j;
    }

    /* renamed from: getSelectionBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m973getSelectionBackgroundColor0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    /* renamed from: setSelectionBackgroundColor-8_81llA  reason: not valid java name */
    public final void m975setSelectionBackgroundColor8_81llA(long j) {
        this.selectionBackgroundColor = j;
    }

    private final void setDrawScopeInvalidation(Unit unit) {
        this.drawScopeInvalidation$delegate.setValue(unit);
    }

    public final Unit getDrawScopeInvalidation() {
        this.drawScopeInvalidation$delegate.getValue();
        return Unit.INSTANCE;
    }
}
