package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    public void onCancel() {
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1097onDownk4lQ0M(long j) {
    }

    public void onUp() {
    }

    TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager textFieldSelectionManager) {
        this.this$0 = textFieldSelectionManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r0 = r0.getLayoutResult();
     */
    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1099onStartk4lQ0M(long r9) {
        /*
            r8 = this;
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd
            r0.setDraggingHandle(r1)
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r0.hideSelectionToolbar$foundation_release()
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002d
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 == 0) goto L_0x002d
            boolean r0 = r0.m969isPositionOnTextk4lQ0M(r9)
            if (r0 != r1) goto L_0x002d
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 != 0) goto L_0x0080
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 == 0) goto L_0x0080
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 == 0) goto L_0x0080
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = r8.this$0
            androidx.compose.ui.text.input.OffsetMapping r3 = r1.getOffsetMapping$foundation_release()
            float r9 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r9)
            int r9 = r0.getLineForVerticalPosition(r9)
            r10 = 2
            r4 = 0
            int r9 = androidx.compose.foundation.text.TextLayoutResultProxy.getLineEnd$default(r0, r9, r2, r10, r4)
            int r9 = r3.transformedToOriginal(r9)
            androidx.compose.ui.hapticfeedback.HapticFeedback r10 = r1.getHapticFeedBack()
            if (r10 == 0) goto L_0x0065
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r0 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion
            int r0 = r0.m2666getTextHandleMove5zf0vsI()
            r10.m2657performHapticFeedbackCdsT49E(r0)
        L_0x0065:
            androidx.compose.ui.text.input.TextFieldValue r10 = r1.getValue$foundation_release()
            androidx.compose.ui.text.AnnotatedString r10 = r10.getAnnotatedString()
            long r2 = androidx.compose.ui.text.TextRangeKt.TextRange(r9, r9)
            androidx.compose.ui.text.input.TextFieldValue r9 = r1.m1079createTextFieldValueFDrldGo(r10, r2)
            r1.enterSelectionMode$foundation_release()
            kotlin.jvm.functions.Function1 r10 = r1.getOnValueChange$foundation_release()
            r10.invoke(r9)
            return
        L_0x0080:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.ui.text.input.TextFieldValue r0 = r0.getValue$foundation_release()
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r1 = 0
        L_0x0094:
            if (r1 == 0) goto L_0x0097
            return
        L_0x0097:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r0.enterSelectionMode$foundation_release()
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 == 0) goto L_0x00cc
            androidx.compose.foundation.text.TextLayoutResultProxy r1 = r0.getLayoutResult()
            if (r1 == 0) goto L_0x00cc
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r4 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            int r1 = androidx.compose.foundation.text.TextLayoutResultProxy.m966getOffsetForPosition3MmeM6k$default(r1, r2, r4, r5, r6)
            androidx.compose.ui.text.input.TextFieldValue r3 = r0.getValue$foundation_release()
            r6 = 0
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r2 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r7 = r2.getWord()
            r2 = r0
            r4 = r1
            r5 = r1
            r2.updateSelection(r3, r4, r5, r6, r7)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.dragBeginOffsetInText = r1
        L_0x00cc:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r8.this$0
            r0.dragBeginPosition = r9
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r9 = r8.this$0
            long r0 = r9.dragBeginPosition
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m1672boximpl(r0)
            r9.m1081setCurrentDragPosition_kEHs6E(r10)
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r9 = r8.this$0
            androidx.compose.ui.geometry.Offset$Companion r10 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r10.m1699getZeroF1C5BW0()
            r9.dragTotalDistance = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.m1099onStartk4lQ0M(long):void");
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1098onDragk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        if (!(this.this$0.getValue$foundation_release().getText().length() == 0)) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            textFieldSelectionManager.dragTotalDistance = Offset.m1688plusMKHz9U(textFieldSelectionManager.dragTotalDistance, j);
            TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1081setCurrentDragPosition_kEHs6E(Offset.m1672boximpl(Offset.m1688plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager2.dragBeginOffsetInText;
                int intValue = access$getDragBeginOffsetInText$p != null ? access$getDragBeginOffsetInText$p.intValue() : layoutResult.m968getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                Offset r10 = textFieldSelectionManager2.m1084getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r10);
                textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), intValue, layoutResult.m968getOffsetForPosition3MmeM6k(r10.m1693unboximpl(), false), false, SelectionAdjustment.Companion.getWord());
            }
            TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2.setShowFloatingToolbar(false);
            }
        }
    }

    public void onStop() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1081setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
        this.this$0.dragBeginOffsetInText = null;
    }
}
