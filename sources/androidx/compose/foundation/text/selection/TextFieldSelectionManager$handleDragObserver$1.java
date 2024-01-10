package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    TextFieldSelectionManager$handleDragObserver$1(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        this.this$0 = textFieldSelectionManager;
        this.$isStartHandle = z;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1090onDownk4lQ0M(long j) {
        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.m1081setCurrentDragPosition_kEHs6E(Offset.m1672boximpl(SelectionHandlesKt.m1017getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1086getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle))));
    }

    public void onUp() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1081setCurrentDragPosition_kEHs6E((Offset) null);
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1092onStartk4lQ0M(long j) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m1017getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1086getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle));
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        textFieldSelectionManager2.m1081setCurrentDragPosition_kEHs6E(Offset.m1672boximpl(textFieldSelectionManager2.dragBeginPosition));
        this.this$0.dragTotalDistance = Offset.Companion.m1699getZeroF1C5BW0();
        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(false);
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1091onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int i;
        int i2;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragTotalDistance = Offset.m1688plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null)) {
            TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
            boolean z = this.$isStartHandle;
            textFieldSelectionManager2.m1081setCurrentDragPosition_kEHs6E(Offset.m1672boximpl(Offset.m1688plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
            if (z) {
                Offset r9 = textFieldSelectionManager2.m1084getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r9);
                i = value.m4195getOffsetForPositionk4lQ0M(r9.m1693unboximpl());
            } else {
                i = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4220getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m4422getSelectiond9O1mEE()));
            }
            int i3 = i;
            if (z) {
                i2 = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m4215getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m4422getSelectiond9O1mEE()));
            } else {
                Offset r92 = textFieldSelectionManager2.m1084getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r92);
                i2 = value.m4195getOffsetForPositionk4lQ0M(r92.m1693unboximpl());
            }
            textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), i3, i2, z, SelectionAdjustment.Companion.getCharacter());
        }
        TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(false);
        }
    }

    public void onStop() {
        TextToolbarStatus textToolbarStatus = null;
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1081setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if (textToolbar != null) {
            textToolbarStatus = textToolbar.getStatus();
        }
        if (textToolbarStatus == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
    }
}
