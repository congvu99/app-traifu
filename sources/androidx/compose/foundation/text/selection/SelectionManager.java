package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010f\u001a\u00020L2\u0006\u0010g\u001a\u00020\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010\"J'\u0010i\u001a\u0004\u0018\u00010\u00162\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u0016H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ\r\u0010n\u001a\u00020LH\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0000¢\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\u000f\u0010w\u001a\u0004\u0018\u00010xH\u0000¢\u0006\u0002\byJ\u000e\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020?J\r\u0010}\u001a\u00020LH\u0000¢\u0006\u0002\b~J\u0006\u0010\u001a\u00020LJ\u000f\u0010\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0003\b\u0001JA\u0010\u0001\u001a\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020\u00070\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u0001J2\u0010\u0001\u001a\u00020L2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020LH\u0002JE\u0010\u0001\u001a\u00020?2\u0006\u0010Y\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00162\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J<\u0010\u0001\u001a\u00020?2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00162\b\u0010Q\u001a\u0004\u0018\u00010\u00162\u0006\u0010|\u001a\u00020?2\b\u0010\u0001\u001a\u00030\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020LH\u0002J0\u0010\u0001\u001a\u00020L*\u00030\u00012\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020L0KH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u00020G*\u00020G2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020L0\u0001H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R8\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR4\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R4\u0010$\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R/\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0015\u001a\u0004\u0018\u00010(8F@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R8\u0010/\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001d\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R+\u0010@\u001a\u00020?2\u0006\u0010\u0015\u001a\u00020?8F@FX\u0002¢\u0006\u0012\n\u0004\bE\u0010\u001d\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0011\u0010F\u001a\u00020G8F¢\u0006\u0006\u001a\u0004\bH\u0010IR(\u0010J\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020L0KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0019\u0010Q\u001a\u0004\u0018\u00010\u0016X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010R\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\f\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020?8BX\u0004¢\u0006\u0006\u001a\u0004\bX\u0010BR8\u0010Y\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\\\u0010\u001d\u001a\u0004\bZ\u0010\u0019\"\u0004\b[\u0010\u001bR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010c\u001a\u00020?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010B\"\u0004\be\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_selection", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onSelectionChange", "Lkotlin/Function1;", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchMode", "getTouchMode", "setTouchMode", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-Q7Q5hAU", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)Landroidx/compose/ui/geometry/Offset;", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateHandleOffsets", "updateSelection", "previousHandlePosition", "updateSelection-3R_-tFg$foundation_release", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-RHHTvR4$foundation_release", "updateSelectionToolbarPosition", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager {
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    private final MutableState currentDragPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragBeginPosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1672boximpl(Offset.Companion.m1699getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState dragTotalDistance$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1672boximpl(Offset.Companion.m1699getZeroF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState draggingHandle$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState endHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private FocusRequester focusRequester = new FocusRequester();
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function1<? super Selection, Unit> onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
    private Offset previousPosition;
    /* access modifiers changed from: private */
    public final SelectionRegistrarImpl selectionRegistrar;
    private final MutableState startHandlePosition$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private TextToolbar textToolbar;
    private boolean touchMode = true;

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        Intrinsics.checkNotNullParameter(selectionRegistrarImpl, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrarImpl;
        this.selectionRegistrar.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001a
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001a
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001a
                    r0 = 1
                    goto L_0x001b
                L_0x001a:
                    r0 = 0
                L_0x001b:
                    if (r0 != 0) goto L_0x0037
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0034
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0034
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0034
                    goto L_0x0035
                L_0x0034:
                    r1 = 0
                L_0x0035:
                    if (r1 == 0) goto L_0x0041
                L_0x0037:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.updateHandleOffsets()
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.updateSelectionToolbarPosition()
                L_0x0041:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass1.invoke(long):void");
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m1049invoked4ec7I((LayoutCoordinates) obj, ((Offset) obj2).m1693unboximpl(), (SelectionAdjustment) obj3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I  reason: not valid java name */
            public final void m1049invoked4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                Offset r3 = this.this$0.m1034convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j);
                if (r3 != null) {
                    this.this$0.m1040startSelection9KIMszo(r3.m1693unboximpl(), false, selectionAdjustment);
                    this.this$0.getFocusRequester().requestFocus();
                    this.this$0.hideSelectionToolbar$foundation_release();
                }
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                SelectionManager selectionManager = this.this$0;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(j, selectionManager.getSelection());
                Selection component1 = selectAll$foundation_release.component1();
                Map component2 = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual((Object) component1, (Object) this.this$0.getSelection())) {
                    this.this$0.selectionRegistrar.setSubselections(component2);
                    this.this$0.getOnSelectionChange().invoke(component1);
                }
                this.this$0.getFocusRequester().requestFocus();
                this.this$0.hideSelectionToolbar$foundation_release();
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return m1050invoke5iVPX68((LayoutCoordinates) obj, ((Offset) obj2).m1693unboximpl(), ((Offset) obj3).m1693unboximpl(), ((Boolean) obj4).booleanValue(), (SelectionAdjustment) obj5);
            }

            /* renamed from: invoke-5iVPX68  reason: not valid java name */
            public final Boolean m1050invoke5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                return Boolean.valueOf(this.this$0.m1048updateSelectionRHHTvR4$foundation_release(this.this$0.m1034convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j), this.this$0.m1034convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j2), z, selectionAdjustment));
            }
        });
        this.selectionRegistrar.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.showSelectionToolbar$foundation_release();
                this.this$0.setDraggingHandle((Handle) null);
                this.this$0.m1035setCurrentDragPosition_kEHs6E((Offset) null);
            }
        });
        this.selectionRegistrar.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    this.this$0.onRelease();
                    this.this$0.setSelection((Selection) null);
                }
            }
        });
        this.selectionRegistrar.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 == 0) goto L_0x001a
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 == 0) goto L_0x001a
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x001a
                    r0 = 1
                    goto L_0x001b
                L_0x001a:
                    r0 = 0
                L_0x001b:
                    if (r0 != 0) goto L_0x0037
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 == 0) goto L_0x0034
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 == 0) goto L_0x0034
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0034
                    goto L_0x0035
                L_0x0034:
                    r1 = 0
                L_0x0035:
                    if (r1 == 0) goto L_0x0042
                L_0x0037:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r7 = 0
                    r6.m1039setStartHandlePosition_kEHs6E(r7)
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.m1038setEndHandlePosition_kEHs6E(r7)
                L_0x0042:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass7.invoke(long):void");
            }
        });
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        Intrinsics.checkNotNullParameter(focusRequester2, "<set-?>");
        this.focusRequester = focusRequester2;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.Companion, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, (MutableInteractionSource) null, 3, (Object) null), new SelectionManager$modifier$4(this)).then(getShouldShowMagnifier() ? SelectionManager_androidKt.selectionMagnifier(Modifier.Companion, this) : Modifier.Companion);
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (getHasFocus() && getSelection() != null) {
            Offset r3 = layoutCoordinates != null ? Offset.m1672boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
            if (!Intrinsics.areEqual((Object) this.previousPosition, (Object) r3)) {
                this.previousPosition = r3;
                updateHandleOffsets();
                updateSelectionToolbarPosition();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M  reason: not valid java name */
    public final void m1036setDragBeginPositionk4lQ0M(long j) {
        this.dragBeginPosition$delegate.setValue(Offset.m1672boximpl(j));
    }

    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1043getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition$delegate.getValue()).m1693unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M  reason: not valid java name */
    public final void m1037setDragTotalDistancek4lQ0M(long j) {
        this.dragTotalDistance$delegate.setValue(Offset.m1672boximpl(j));
    }

    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release  reason: not valid java name */
    public final long m1044getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance$delegate.getValue()).m1693unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1039setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getStartHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1046getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m1038setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getEndHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m1045getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1035setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1042getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    private final boolean getShouldShowMagnifier() {
        return getDraggingHandle() != null;
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchor");
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(anchorInfo.getSelectableId()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r3 = r0.getStart();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateHandleOffsets() {
        /*
            r9 = this;
            androidx.compose.foundation.text.selection.Selection r0 = r9.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r9.containerLayoutCoordinates
            r2 = 0
            if (r0 == 0) goto L_0x0014
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r0.getStart()
            if (r3 == 0) goto L_0x0014
            androidx.compose.foundation.text.selection.Selectable r3 = r9.getAnchorSelectable$foundation_release(r3)
            goto L_0x0015
        L_0x0014:
            r3 = r2
        L_0x0015:
            if (r0 == 0) goto L_0x0022
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r0.getEnd()
            if (r4 == 0) goto L_0x0022
            androidx.compose.foundation.text.selection.Selectable r4 = r9.getAnchorSelectable$foundation_release(r4)
            goto L_0x0023
        L_0x0022:
            r4 = r2
        L_0x0023:
            if (r3 == 0) goto L_0x002a
            androidx.compose.ui.layout.LayoutCoordinates r5 = r3.getLayoutCoordinates()
            goto L_0x002b
        L_0x002a:
            r5 = r2
        L_0x002b:
            if (r4 == 0) goto L_0x0032
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L_0x0033
        L_0x0032:
            r6 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x0075
            if (r1 == 0) goto L_0x0075
            boolean r7 = r1.isAttached()
            if (r7 == 0) goto L_0x0075
            if (r5 == 0) goto L_0x0075
            if (r6 != 0) goto L_0x0042
            goto L_0x0075
        L_0x0042:
            r7 = 1
            long r7 = r3.m995getHandlePositiondBAh8RU(r0, r7)
            long r7 = r1.m3612localPositionOfR5De75A(r5, r7)
            r3 = 0
            long r3 = r4.m995getHandlePositiondBAh8RU(r0, r3)
            long r3 = r1.m3612localPositionOfR5De75A(r6, r3)
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r1)
            boolean r1 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1057containsInclusiveUv8p0NA(r0, r7)
            if (r1 == 0) goto L_0x0063
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1672boximpl(r7)
            goto L_0x0064
        L_0x0063:
            r1 = r2
        L_0x0064:
            r9.m1039setStartHandlePosition_kEHs6E(r1)
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1057containsInclusiveUv8p0NA(r0, r3)
            if (r0 == 0) goto L_0x0071
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m1672boximpl(r3)
        L_0x0071:
            r9.m1038setEndHandlePosition_kEHs6E(r2)
            return
        L_0x0075:
            r9.m1039setStartHandlePosition_kEHs6E(r2)
            r9.m1038setEndHandlePosition_kEHs6E(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (!(layoutCoordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long j, Selection selection) {
        HapticFeedback hapticFeedback;
        Map linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == j ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selection2 = SelectionManagerKt.merge(selection2, selectAllSelection);
        }
        if (!Intrinsics.areEqual((Object) selection2, (Object) selection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m2657performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2666getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection2, linkedHashMap);
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        AnnotatedString plus;
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection = getSelection();
        AnnotatedString annotatedString = null;
        if (selection == null) {
            return null;
        }
        int size = sort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = sort.get(i);
            if (selectable.getSelectableId() == selection.getStart().getSelectableId() || selectable.getSelectableId() == selection.getEnd().getSelectableId() || annotatedString != null) {
                AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection);
                if (!(annotatedString == null || (plus = annotatedString.plus(currentSelectedText)) == null)) {
                    currentSelectedText = plus;
                }
                if ((selectable.getSelectableId() == selection.getEnd().getSelectableId() && !selection.getHandlesCrossed()) || (selectable.getSelectableId() == selection.getStart().getSelectableId() && selection.getHandlesCrossed())) {
                    return currentSelectedText;
                }
                annotatedString = currentSelectedText;
            }
        }
        return annotatedString;
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager2;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null && (clipboardManager2 = this.clipboardManager) != null) {
            clipboardManager2.setText(selectedText$foundation_release);
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus() && getSelection() != null && (textToolbar2 = this.textToolbar) != null) {
            TextToolbar.CC.showMenu$default(textToolbar2, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus()) {
            TextToolbar textToolbar3 = this.textToolbar;
            if ((textToolbar3 != null ? textToolbar3.getStatus() : null) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
                textToolbar2.hide();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 != null ? textToolbar2.getStatus() : null) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection selection = getSelection();
        if (selection == null) {
            return Rect.Companion.getZero();
        }
        Selectable anchorSelectable$foundation_release = getAnchorSelectable$foundation_release(selection.getStart());
        Selectable anchorSelectable$foundation_release2 = getAnchorSelectable$foundation_release(selection.getEnd());
        if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        if (anchorSelectable$foundation_release2 == null || (layoutCoordinates2 = anchorSelectable$foundation_release2.getLayoutCoordinates()) == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long r6 = layoutCoordinates3.m3612localPositionOfR5De75A(layoutCoordinates, anchorSelectable$foundation_release.m995getHandlePositiondBAh8RU(selection, true));
        long r8 = layoutCoordinates3.m3612localPositionOfR5De75A(layoutCoordinates2, anchorSelectable$foundation_release2.m995getHandlePositiondBAh8RU(selection, false));
        long r62 = layoutCoordinates3.m3613localToRootMKHz9U(r6);
        long r82 = layoutCoordinates3.m3613localToRootMKHz9U(r8);
        float min = Math.min(Offset.m1683getXimpl(r62), Offset.m1683getXimpl(r82));
        float max = Math.max(Offset.m1683getXimpl(r62), Offset.m1683getXimpl(r82));
        long r13 = layoutCoordinates3.m3612localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release.getBoundingBox(selection.getStart().getOffset()).getTop()));
        long r0 = layoutCoordinates3.m3612localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, anchorSelectable$foundation_release2.getBoundingBox(selection.getEnd().getOffset()).getTop()));
        return new Rect(min, Math.min(Offset.m1684getYimpl(layoutCoordinates3.m3613localToRootMKHz9U(r13)), Offset.m1684getYimpl(layoutCoordinates3.m3613localToRootMKHz9U(r0))), max, Math.max(Offset.m1684getYimpl(r62), Offset.m1684getYimpl(r82)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m2657performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2666getTextHandleMove5zf0vsI());
            }
        }
    }

    public final TextDragObserver handleDragObserver(boolean z) {
        return new SelectionManager$handleDragObserver$1(this, z);
    }

    /* access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new SelectionManager$detectNonConsumingTap$2(function1, (Continuation<? super SelectionManager$detectNonConsumingTap$2>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionManager$onClearSelectionRequested$1(this, function0, (Continuation<? super SelectionManager$onClearSelectionRequested$1>) null)) : modifier;
    }

    /* access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU  reason: not valid java name */
    public final Offset m1034convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.m1672boximpl(requireContainerCoordinates$foundation_release().m3612localPositionOfR5De75A(layoutCoordinates, j));
    }

    /* access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo  reason: not valid java name */
    public final void m1040startSelection9KIMszo(long j, boolean z, SelectionAdjustment selectionAdjustment) {
        m1047updateSelection3R_tFg$foundation_release(j, j, (Offset) null, z, selectionAdjustment);
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release  reason: not valid java name */
    public final boolean m1048updateSelectionRHHTvR4$foundation_release(Offset offset, Offset offset2, boolean z, SelectionAdjustment selectionAdjustment) {
        Selection selection;
        long j;
        Offset offset3;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (offset == null || (selection = getSelection()) == null) {
            return false;
        }
        if (z) {
            j = selection.getEnd().getSelectableId();
        } else {
            j = selection.getStart().getSelectableId();
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(j));
        if (selectable == null) {
            offset3 = null;
        } else {
            LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
            Intrinsics.checkNotNull(layoutCoordinates);
            offset3 = m1034convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m1017getAdjustedCoordinatesk4lQ0M(selectable.m995getHandlePositiondBAh8RU(selection, !z)));
        }
        if (offset3 == null) {
            return false;
        }
        long r0 = offset3.m1693unboximpl();
        long r2 = z ? offset.m1693unboximpl() : r0;
        if (!z) {
            r0 = offset.m1693unboximpl();
        }
        return m1047updateSelection3R_tFg$foundation_release(r2, r0, offset2, z, selectionAdjustment);
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release  reason: not valid java name */
    public final boolean m1047updateSelection3R_tFg$foundation_release(long j, long j2, Offset offset, boolean z, SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
        m1035setCurrentDragPosition_kEHs6E(z ? Offset.m1672boximpl(j) : Offset.m1672boximpl(j2));
        Map linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection = null;
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            Selectable selectable = sort.get(i);
            int i2 = i;
            Selection selection2 = selection;
            Pair<Selection, Boolean> r1 = selectable.m997updateSelectionqCDeeow(j, j2, offset, z, requireContainerCoordinates$foundation_release(), selectionAdjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection component1 = r1.component1();
            z2 = z2 || r1.component2().booleanValue();
            if (component1 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), component1);
            }
            selection = SelectionManagerKt.merge(selection2, component1);
            i = i2 + 1;
        }
        Selection selection3 = selection;
        if (!Intrinsics.areEqual((Object) selection3, (Object) getSelection())) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m2657performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2666getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection3);
        }
        return z2;
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M  reason: not valid java name */
    public final void m1041contextMenuOpenAdjustmentk4lQ0M(long j) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m4214getCollapsedimpl(selection.m999toTextRanged9O1mEE()) : true) {
            m1040startSelection9KIMszo(j, true, SelectionAdjustment.Companion.getWord());
        }
    }
}
