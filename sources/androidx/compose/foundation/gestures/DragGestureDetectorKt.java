package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015HHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\u0019\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012\u001ag\u0010\u001b\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a_\u0010'\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0012\u001a]\u0010-\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00162\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u001fHHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a_\u00103\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b4\u0010*\u001a'\u00105\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0012\u001ag\u00107\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d26\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b8\u0010&\u001a_\u00109\u001a\u0004\u0018\u00010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001026\u0010(\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b:\u0010*\u001a\u0001\u0010;\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010D\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010A\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u001100¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010E\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010F\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a\u0001\u0010G\u001a\u00020$*\u00020<2\u0014\b\u0002\u0010=\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020$0\u00152\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020$0?2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020$0?26\u0010H\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020$0\u001fH@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010C\u001a9\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0018\u001aa\u0010I\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00152\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u0015HHø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a9\u0010O\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010\u0018\u001a!\u0010Q\u001a\u00020\u0016*\u00020R2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a!\u0010U\u001a\u00020\u000b*\u00020V2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u00020\u0001*\u00020ZH\u0000\u001a9\u0010[\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0015H@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\\\u0010\u0018\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u0013\u0010\t\u001a\u00020\u0007X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006]"}, d2 = {"HorizontalPointerDirectionConfig", "Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "getHorizontalPointerDirectionConfig", "()Landroidx/compose/foundation/gestures/PointerDirectionConfig;", "VerticalPointerDirectionConfig", "getVerticalPointerDirectionConfig", "defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "awaitPointerSlopOrCancellation", "pointerDirectionConfig", "triggerOnMainAxisSlop", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-wtdNQyU", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/PointerDirectionConfig;ZLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "toPointerDirectionConfig", "Landroidx/compose/foundation/gestures/Orientation;", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt {
    private static final PointerDirectionConfig HorizontalPointerDirectionConfig = new DragGestureDetectorKt$HorizontalPointerDirectionConfig$1();
    private static final PointerDirectionConfig VerticalPointerDirectionConfig = new DragGestureDetectorKt$VerticalPointerDirectionConfig$1();
    private static final float defaultTouchSlop;
    private static final float mouseSlop = Dp.m4704constructorimpl((float) 0.125d);
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0112 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m279awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r22, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            r0 = r20
            r2 = r23
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x008b
            if (r5 == r9) goto L_0x0064
            if (r5 != r6) goto L_0x005c
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r11 = r3.I$0
            java.lang.Object r12 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            java.lang.Object r14 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            java.lang.Object r15 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r15 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r15
            java.lang.Object r7 = r3.L$0
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r14
            r8 = 2
            r14 = r11
            r11 = r15
            r18 = r3
            r3 = r1
            r1 = r7
            r7 = r4
            r4 = r5
            r5 = r18
            goto L_0x01c1
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0064:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r7 = r3.I$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r3
            r3 = r0
            r0 = r12
            r12 = r11
            r11 = r4
            r4 = r1
            r1 = r14
            r14 = r7
            r7 = r18
            goto L_0x00e3
        L_0x008b:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m3509getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = HorizontalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r7 = r19.getCurrentEvent()
            boolean r7 = m286isPointerUpDmW0f2w(r7, r0)
            if (r7 == 0) goto L_0x00a2
            goto L_0x0201
        L_0x00a2:
            androidx.compose.ui.platform.ViewConfiguration r7 = r19.getViewConfiguration()
            float r2 = m287pointerSlopE8SPZFQ(r7, r2)
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            r7.element = r0
            r0 = r19
            r1 = r22
            r11 = r5
            r12 = r7
            r13 = 0
            r5 = r3
            r7 = r4
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x00bd:
            r5.L$0 = r1
            r5.L$1 = r11
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r10
            r5.I$0 = r13
            r5.F$0 = r4
            r5.F$1 = r3
            r5.F$2 = r2
            r5.label = r9
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r10, r5, r9, r10)
            if (r14 != r7) goto L_0x00d8
            return r7
        L_0x00d8:
            r18 = r3
            r3 = r2
            r2 = r14
            r14 = r13
            r13 = r11
            r11 = r7
            r7 = r5
            r5 = r4
            r4 = r18
        L_0x00e3:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r8 = r15.size()
            r9 = 0
        L_0x00ee:
            if (r9 >= r8) goto L_0x0112
            java.lang.Object r16 = r15.get(r9)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r19 = r11
            long r10 = r17.m3428getIdJ3iCeTQ()
            r20 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r10, r6)
            if (r6 == 0) goto L_0x0109
            goto L_0x0118
        L_0x0109:
            int r9 = r9 + 1
            r11 = r19
            r7 = r20
            r6 = 2
            r10 = 0
            goto L_0x00ee
        L_0x0112:
            r20 = r7
            r19 = r11
            r16 = 0
        L_0x0118:
            r6 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x0120
            goto L_0x01c7
        L_0x0120:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0128
            goto L_0x01c7
        L_0x0128:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0165
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0137:
            if (r7 >= r6) goto L_0x014a
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0147
            goto L_0x014b
        L_0x0147:
            int r7 = r7 + 1
            goto L_0x0137
        L_0x014a:
            r8 = 0
        L_0x014b:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0151
            goto L_0x01c7
        L_0x0151:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r12.element = r6
            r7 = r19
            r2 = r3
            r3 = r4
            r4 = r5
            r11 = r13
            r13 = r14
            r6 = 2
            r9 = 1
            r10 = 0
            r5 = r20
            goto L_0x00bd
        L_0x0165:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r13.m313mainAxisDeltak4lQ0M(r7)
            float r11 = r13.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r11
            float r7 = r13.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r13.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r4
            float r3 = r3 + r7
            if (r14 == 0) goto L_0x0188
            float r4 = java.lang.Math.abs(r2)
            goto L_0x0190
        L_0x0188:
            long r7 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x0190:
            int r7 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x01d0
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r7 = r20
            r7.L$0 = r1
            r7.L$1 = r13
            r7.L$2 = r0
            r7.L$3 = r12
            r7.L$4 = r6
            r7.I$0 = r14
            r7.F$0 = r5
            r7.F$1 = r2
            r7.F$2 = r3
            r8 = 2
            r7.label = r8
            java.lang.Object r4 = r0.awaitPointerEvent(r4, r7)
            r9 = r19
            if (r4 != r9) goto L_0x01b6
            return r9
        L_0x01b6:
            r4 = r5
            r5 = r7
            r7 = r9
            r11 = r13
            r13 = r12
            r12 = r6
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x01c1:
            boolean r6 = r12.isConsumed()
            if (r6 == 0) goto L_0x01c9
        L_0x01c7:
            r10 = 0
            goto L_0x0201
        L_0x01c9:
            r12 = r13
            r13 = r14
        L_0x01cb:
            r6 = 2
            r9 = 1
            r10 = 0
            goto L_0x00bd
        L_0x01d0:
            r9 = r19
            r7 = r20
            r8 = 2
            if (r14 == 0) goto L_0x01e3
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r5
            float r2 = r2 - r4
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            goto L_0x01f3
        L_0x01e3:
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            long r10 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r2, r4)
            long r10 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r10, r5)
            long r2 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r2, r10)
        L_0x01f3:
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m1672boximpl(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x0202
            r10 = r6
        L_0x0201:
            return r10
        L_0x0202:
            r4 = r5
            r5 = r7
            r7 = r9
            r11 = r13
            r13 = r14
            r2 = 0
            r3 = 0
            goto L_0x01cb
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m279awaitTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m284dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L_0x004c
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003f:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m270awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0056
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L_0x0056:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L_0x0061
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L_0x0061:
            r7.invoke(r8)
            long r5 = r8.m3428getIdJ3iCeTQ()
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cc, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L_0x00ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m270awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m286isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m3428getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r7
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r7
            goto L_0x00ce
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
            r8 = 0
        L_0x00a8:
            if (r8 >= r5) goto L_0x00bb
            java.lang.Object r10 = r2.get(r8)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = r12.getPressed()
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            int r8 = r8 + 1
            goto L_0x00a8
        L_0x00bb:
            r10 = r7
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00c1
            goto L_0x00ce
        L_0x00c1:
            long r8 = r10.m3428getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00dc
        L_0x00c8:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11)
            if (r2 == 0) goto L_0x00dc
        L_0x00ce:
            if (r11 == 0) goto L_0x00d7
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r6 = 0
        L_0x00d8:
            if (r6 == 0) goto L_0x00db
            r7 = r11
        L_0x00db:
            return r7
        L_0x00dc:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m270awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGestures$4.INSTANCE;
        }
        return detectDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, (Continuation<? super DragGestureDetectorKt$detectDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$4.INSTANCE;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function02, function1, function0, function2, (Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0111 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0147 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m282awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r21
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0088
            if (r5 == r8) goto L_0x0061
            if (r5 != r6) goto L_0x0059
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            java.lang.Object r15 = r3.L$0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r13
            r13 = r14
            r8 = 2
            r14 = r10
            r10 = r4
            r4 = r5
            r5 = r3
            r3 = r1
            r1 = r15
            goto L_0x01b9
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r3
            r3 = r0
            r0 = r12
            r12 = r11
            r11 = r4
            r4 = r1
            r1 = r14
            r14 = r10
            r10 = r19
            goto L_0x00e0
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m3509getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = VerticalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r10 = r20.getCurrentEvent()
            boolean r10 = m286isPointerUpDmW0f2w(r10, r0)
            if (r10 == 0) goto L_0x009f
            goto L_0x01fb
        L_0x009f:
            androidx.compose.ui.platform.ViewConfiguration r10 = r20.getViewConfiguration()
            float r2 = m287pointerSlopE8SPZFQ(r10, r2)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r0
            r0 = r20
            r1 = r23
            r11 = r5
            r12 = r10
            r13 = 1
            r5 = r3
            r10 = r4
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x00ba:
            r5.L$0 = r1
            r5.L$1 = r11
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r9
            r5.I$0 = r13
            r5.F$0 = r4
            r5.F$1 = r3
            r5.F$2 = r2
            r5.label = r8
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r14 != r10) goto L_0x00d5
            return r10
        L_0x00d5:
            r19 = r3
            r3 = r2
            r2 = r14
            r14 = r13
            r13 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r19
        L_0x00e0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r7 = r15.size()
            r16 = 0
            r8 = 0
        L_0x00ed:
            if (r8 >= r7) goto L_0x0111
            java.lang.Object r17 = r15.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r20 = r7
            long r6 = r18.m3428getIdJ3iCeTQ()
            r21 = r10
            long r9 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r6, r9)
            if (r6 == 0) goto L_0x0108
            goto L_0x0115
        L_0x0108:
            int r8 = r8 + 1
            r7 = r20
            r10 = r21
            r6 = 2
            r9 = 0
            goto L_0x00ed
        L_0x0111:
            r21 = r10
            r17 = 0
        L_0x0115:
            r6 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x011d
            goto L_0x01bf
        L_0x011d:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0125
            goto L_0x01bf
        L_0x0125:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0161
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0134:
            if (r7 >= r6) goto L_0x0147
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0144
            goto L_0x0148
        L_0x0144:
            int r7 = r7 + 1
            goto L_0x0134
        L_0x0147:
            r8 = 0
        L_0x0148:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x014e
            goto L_0x01bf
        L_0x014e:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r12.element = r6
            r2 = r3
            r3 = r4
            r4 = r5
            r10 = r11
            r11 = r13
            r13 = r14
            r6 = 2
            r8 = 1
            r9 = 0
            r5 = r21
            goto L_0x00ba
        L_0x0161:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r13.m313mainAxisDeltak4lQ0M(r7)
            float r15 = r13.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r15
            float r7 = r13.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r13.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r4
            float r3 = r3 + r7
            if (r14 == 0) goto L_0x0184
            float r4 = java.lang.Math.abs(r2)
            goto L_0x018c
        L_0x0184:
            long r7 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x018c:
            int r7 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x01c8
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r7 = r21
            r7.L$0 = r1
            r7.L$1 = r13
            r7.L$2 = r0
            r7.L$3 = r12
            r7.L$4 = r6
            r7.I$0 = r14
            r7.F$0 = r5
            r7.F$1 = r2
            r7.F$2 = r3
            r8 = 2
            r7.label = r8
            java.lang.Object r4 = r0.awaitPointerEvent(r4, r7)
            if (r4 != r11) goto L_0x01b0
            return r11
        L_0x01b0:
            r4 = r5
            r5 = r7
            r10 = r11
            r11 = r6
            r19 = r3
            r3 = r2
            r2 = r19
        L_0x01b9:
            boolean r6 = r11.isConsumed()
            if (r6 == 0) goto L_0x01c1
        L_0x01bf:
            r9 = 0
            goto L_0x01fb
        L_0x01c1:
            r11 = r13
            r13 = r14
        L_0x01c3:
            r6 = 2
            r8 = 1
            r9 = 0
            goto L_0x00ba
        L_0x01c8:
            r7 = r21
            r8 = 2
            if (r14 == 0) goto L_0x01d9
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r5
            float r2 = r2 - r4
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            goto L_0x01e9
        L_0x01d9:
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            long r9 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r2, r4)
            long r9 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r9, r5)
            long r2 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r2, r9)
        L_0x01e9:
            float r2 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r2)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x01fc
            r9 = r6
        L_0x01fb:
            return r9
        L_0x01fc:
            r4 = r5
            r5 = r7
            r10 = r11
            r11 = r13
            r13 = r14
            r2 = 0
            r3 = 0
            goto L_0x01c3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m282awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m281awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r26) {
        /*
            r0 = r22
            r2 = r26
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x008c
            if (r5 == r8) goto L_0x0061
            if (r5 != r6) goto L_0x0059
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            java.lang.Object r15 = r3.L$0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r6 = r5
            r0 = r13
            r7 = 2
            r5 = r3
            r13 = r10
            r3 = r1
            r10 = r4
            r4 = r14
            r1 = r15
            goto L_0x01b3
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r3
            r3 = r0
            r0 = r12
            r12 = r11
            r11 = r5
            r5 = r19
            r20 = r4
            r4 = r1
            r1 = r14
            r14 = r10
            r10 = r20
            goto L_0x00dd
        L_0x008c:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.PointerDirectionConfig r2 = VerticalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r5 = r21.getCurrentEvent()
            boolean r5 = m286isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x009d
            goto L_0x01f4
        L_0x009d:
            androidx.compose.ui.platform.ViewConfiguration r5 = r21.getViewConfiguration()
            r10 = r24
            float r5 = m287pointerSlopE8SPZFQ(r5, r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r0
            r0 = r21
            r1 = r25
            r11 = r5
            r12 = r10
            r13 = 1
            r5 = r3
            r10 = r4
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x00ba:
            r5.L$0 = r1
            r5.L$1 = r4
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r9
            r5.I$0 = r13
            r5.F$0 = r11
            r5.F$1 = r3
            r5.F$2 = r2
            r5.label = r8
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r14 != r10) goto L_0x00d5
            return r10
        L_0x00d5:
            r19 = r3
            r3 = r2
            r2 = r14
            r14 = r13
            r13 = r4
            r4 = r19
        L_0x00dd:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r7 = r15.size()
            r16 = 0
            r8 = 0
        L_0x00ea:
            if (r8 >= r7) goto L_0x010e
            java.lang.Object r17 = r15.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r21 = r10
            long r9 = r18.m3428getIdJ3iCeTQ()
            r22 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r9, r6)
            if (r6 == 0) goto L_0x0105
            goto L_0x0112
        L_0x0105:
            int r8 = r8 + 1
            r7 = r22
            r6 = 2
            r9 = 0
            r10 = r21
            goto L_0x00ea
        L_0x010e:
            r21 = r10
            r17 = 0
        L_0x0112:
            r6 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x011a
            goto L_0x01b9
        L_0x011a:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0122
            goto L_0x01b9
        L_0x0122:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0158
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0131:
            if (r7 >= r6) goto L_0x0144
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0141
            goto L_0x0145
        L_0x0141:
            int r7 = r7 + 1
            goto L_0x0131
        L_0x0144:
            r8 = 0
        L_0x0145:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x014b
            goto L_0x01b9
        L_0x014b:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r12.element = r6
            r10 = r21
            r2 = r3
            r3 = r4
            r4 = r13
            r13 = r14
            goto L_0x01bc
        L_0x0158:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r13.m313mainAxisDeltak4lQ0M(r7)
            float r15 = r13.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r15
            float r7 = r13.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r13.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r4
            float r3 = r3 + r7
            if (r14 == 0) goto L_0x017b
            float r4 = java.lang.Math.abs(r2)
            goto L_0x0183
        L_0x017b:
            long r7 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x0183:
            int r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x01c1
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r1
            r5.L$1 = r13
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r6
            r5.I$0 = r14
            r5.F$0 = r11
            r5.F$1 = r2
            r5.F$2 = r3
            r7 = 2
            r5.label = r7
            java.lang.Object r4 = r0.awaitPointerEvent(r4, r5)
            r10 = r21
            if (r4 != r10) goto L_0x01a7
            return r10
        L_0x01a7:
            r4 = r13
            r13 = r14
            r19 = r3
            r3 = r2
            r2 = r19
            r20 = r11
            r11 = r6
            r6 = r20
        L_0x01b3:
            boolean r8 = r11.isConsumed()
            if (r8 == 0) goto L_0x01bb
        L_0x01b9:
            r9 = 0
            goto L_0x01f4
        L_0x01bb:
            r11 = r6
        L_0x01bc:
            r6 = 2
            r8 = 1
            r9 = 0
            goto L_0x00ba
        L_0x01c1:
            r10 = r21
            r7 = 2
            if (r14 == 0) goto L_0x01d2
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r11
            float r2 = r2 - r4
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            goto L_0x01e2
        L_0x01d2:
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            long r8 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r2, r4)
            long r8 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r8, r11)
            long r2 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r2, r8)
        L_0x01e2:
            float r2 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r2)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x01f5
            r9 = r6
        L_0x01f4:
            return r9
        L_0x01f5:
            r4 = r13
            r13 = r14
            r2 = 0
            r3 = 0
            goto L_0x01bc
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m281awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1684getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m288verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 != r6) goto L_0x0045
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r1.L$0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r2
            r2 = r1
            r1 = r9
            r9 = r7
            r7 = r16
            goto L_0x0089
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r18.getCurrentEvent()
            r7 = r19
            boolean r0 = m286isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x0062
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0116
        L_0x0062:
            r0 = r18
            r3 = r2
            r2 = r1
            r1 = r21
        L_0x0068:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r8 = r0
            r7 = r3
            r3 = r9
        L_0x0072:
            r2.L$0 = r1
            r2.L$1 = r0
            r2.L$2 = r8
            r2.L$3 = r3
            r2.label = r6
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r8, r4, r2, r6, r4)
            if (r9 != r7) goto L_0x0083
            return r7
        L_0x0083:
            r16 = r8
            r8 = r0
            r0 = r9
            r9 = r16
        L_0x0089:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r10 = r0.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0094:
            if (r12 >= r11) goto L_0x00af
            java.lang.Object r13 = r10.get(r12)
            r14 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            long r14 = r14.m3428getIdJ3iCeTQ()
            long r4 = r3.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r14, r4)
            if (r4 == 0) goto L_0x00aa
            goto L_0x00b0
        L_0x00aa:
            int r12 = r12 + 1
            r4 = 0
            r5 = 0
            goto L_0x0094
        L_0x00af:
            r13 = 0
        L_0x00b0:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L_0x00b6
            r13 = 0
            goto L_0x00f8
        L_0x00b6:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r4 == 0) goto L_0x00e5
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00c5:
            if (r5 >= r4) goto L_0x00d8
            java.lang.Object r10 = r0.get(r5)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x00d8:
            r10 = 0
        L_0x00d9:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00de
            goto L_0x00f8
        L_0x00de:
            long r4 = r10.m3428getIdJ3iCeTQ()
            r3.element = r4
            goto L_0x0128
        L_0x00e5:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)
            float r0 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00f4
            r0 = 1
            goto L_0x00f5
        L_0x00f4:
            r0 = 0
        L_0x00f5:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0128
        L_0x00f8:
            if (r13 != 0) goto L_0x0100
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0116
        L_0x0100:
            r0 = 0
            boolean r3 = r13.isConsumed()
            if (r3 == 0) goto L_0x010c
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0116
        L_0x010c:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r3 == 0) goto L_0x0117
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0116:
            return r0
        L_0x0117:
            r1.invoke(r13)
            long r3 = r13.m3428getIdJ3iCeTQ()
            r0 = r8
            r5 = 0
            r16 = r3
            r3 = r7
            r7 = r16
            r4 = 0
            goto L_0x0068
        L_0x0128:
            r0 = 0
            r0 = r8
            r8 = r9
            r4 = 0
            r5 = 0
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m288verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d9, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1684getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L_0x00db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m280awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m286isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m3428getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r6
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r6
            goto L_0x00db
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
            r8 = 0
        L_0x00a8:
            if (r8 >= r5) goto L_0x00bb
            java.lang.Object r10 = r2.get(r8)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = r12.getPressed()
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            int r8 = r8 + 1
            goto L_0x00a8
        L_0x00bb:
            r10 = r6
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00c1
            goto L_0x00db
        L_0x00c1:
            long r8 = r10.m3428getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e9
        L_0x00c8:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m1684getYimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d7
            r2 = 1
            goto L_0x00d8
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x00e9
        L_0x00db:
            if (r11 == 0) goto L_0x00e4
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            r7 = 0
        L_0x00e5:
            if (r7 == 0) goto L_0x00e8
            r6 = r11
        L_0x00e8:
            return r6
        L_0x00e9:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m280awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectVerticalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectVerticalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectVerticalDragGestures$4.INSTANCE;
        }
        return detectVerticalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectVerticalDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0111 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0147 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m274awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r21
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0088
            if (r5 == r8) goto L_0x0061
            if (r5 != r6) goto L_0x0059
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            java.lang.Object r15 = r3.L$0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r13
            r13 = r14
            r8 = 2
            r14 = r10
            r10 = r4
            r4 = r5
            r5 = r3
            r3 = r1
            r1 = r15
            goto L_0x01b9
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r3
            r3 = r0
            r0 = r12
            r12 = r11
            r11 = r4
            r4 = r1
            r1 = r14
            r14 = r10
            r10 = r19
            goto L_0x00e0
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m3509getTouchT8wyACA()
            androidx.compose.foundation.gestures.PointerDirectionConfig r5 = HorizontalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r10 = r20.getCurrentEvent()
            boolean r10 = m286isPointerUpDmW0f2w(r10, r0)
            if (r10 == 0) goto L_0x009f
            goto L_0x01fb
        L_0x009f:
            androidx.compose.ui.platform.ViewConfiguration r10 = r20.getViewConfiguration()
            float r2 = m287pointerSlopE8SPZFQ(r10, r2)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r0
            r0 = r20
            r1 = r23
            r11 = r5
            r12 = r10
            r13 = 1
            r5 = r3
            r10 = r4
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x00ba:
            r5.L$0 = r1
            r5.L$1 = r11
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r9
            r5.I$0 = r13
            r5.F$0 = r4
            r5.F$1 = r3
            r5.F$2 = r2
            r5.label = r8
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r14 != r10) goto L_0x00d5
            return r10
        L_0x00d5:
            r19 = r3
            r3 = r2
            r2 = r14
            r14 = r13
            r13 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r19
        L_0x00e0:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r7 = r15.size()
            r16 = 0
            r8 = 0
        L_0x00ed:
            if (r8 >= r7) goto L_0x0111
            java.lang.Object r17 = r15.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r20 = r7
            long r6 = r18.m3428getIdJ3iCeTQ()
            r21 = r10
            long r9 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r6, r9)
            if (r6 == 0) goto L_0x0108
            goto L_0x0115
        L_0x0108:
            int r8 = r8 + 1
            r7 = r20
            r10 = r21
            r6 = 2
            r9 = 0
            goto L_0x00ed
        L_0x0111:
            r21 = r10
            r17 = 0
        L_0x0115:
            r6 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x011d
            goto L_0x01bf
        L_0x011d:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0125
            goto L_0x01bf
        L_0x0125:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0161
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0134:
            if (r7 >= r6) goto L_0x0147
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0144
            goto L_0x0148
        L_0x0144:
            int r7 = r7 + 1
            goto L_0x0134
        L_0x0147:
            r8 = 0
        L_0x0148:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x014e
            goto L_0x01bf
        L_0x014e:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r12.element = r6
            r2 = r3
            r3 = r4
            r4 = r5
            r10 = r11
            r11 = r13
            r13 = r14
            r6 = 2
            r8 = 1
            r9 = 0
            r5 = r21
            goto L_0x00ba
        L_0x0161:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r13.m313mainAxisDeltak4lQ0M(r7)
            float r15 = r13.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r15
            float r7 = r13.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r13.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r4
            float r3 = r3 + r7
            if (r14 == 0) goto L_0x0184
            float r4 = java.lang.Math.abs(r2)
            goto L_0x018c
        L_0x0184:
            long r7 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x018c:
            int r7 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x01c8
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r7 = r21
            r7.L$0 = r1
            r7.L$1 = r13
            r7.L$2 = r0
            r7.L$3 = r12
            r7.L$4 = r6
            r7.I$0 = r14
            r7.F$0 = r5
            r7.F$1 = r2
            r7.F$2 = r3
            r8 = 2
            r7.label = r8
            java.lang.Object r4 = r0.awaitPointerEvent(r4, r7)
            if (r4 != r11) goto L_0x01b0
            return r11
        L_0x01b0:
            r4 = r5
            r5 = r7
            r10 = r11
            r11 = r6
            r19 = r3
            r3 = r2
            r2 = r19
        L_0x01b9:
            boolean r6 = r11.isConsumed()
            if (r6 == 0) goto L_0x01c1
        L_0x01bf:
            r9 = 0
            goto L_0x01fb
        L_0x01c1:
            r11 = r13
            r13 = r14
        L_0x01c3:
            r6 = 2
            r8 = 1
            r9 = 0
            goto L_0x00ba
        L_0x01c8:
            r7 = r21
            r8 = 2
            if (r14 == 0) goto L_0x01d9
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r5
            float r2 = r2 - r4
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            goto L_0x01e9
        L_0x01d9:
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            long r9 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r2, r4)
            long r9 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r9, r5)
            long r2 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r2, r9)
        L_0x01e9:
            float r2 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r2)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x01fc
            r9 = r6
        L_0x01fb:
            return r9
        L_0x01fc:
            r4 = r5
            r5 = r7
            r10 = r11
            r11 = r13
            r13 = r14
            r2 = 0
            r3 = 0
            goto L_0x01c3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m274awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m273awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r26) {
        /*
            r0 = r22
            r2 = r26
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x008c
            if (r5 == r8) goto L_0x0061
            if (r5 != r6) goto L_0x0059
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r13 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r13
            java.lang.Object r14 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            java.lang.Object r15 = r3.L$0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r6 = r5
            r0 = r13
            r7 = 2
            r5 = r3
            r13 = r10
            r3 = r1
            r10 = r4
            r4 = r14
            r1 = r15
            goto L_0x01b3
        L_0x0059:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            int r10 = r3.I$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r3
            r3 = r0
            r0 = r12
            r12 = r11
            r11 = r5
            r5 = r19
            r20 = r4
            r4 = r1
            r1 = r14
            r14 = r10
            r10 = r20
            goto L_0x00dd
        L_0x008c:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.foundation.gestures.PointerDirectionConfig r2 = HorizontalPointerDirectionConfig
            androidx.compose.ui.input.pointer.PointerEvent r5 = r21.getCurrentEvent()
            boolean r5 = m286isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x009d
            goto L_0x01f4
        L_0x009d:
            androidx.compose.ui.platform.ViewConfiguration r5 = r21.getViewConfiguration()
            r10 = r24
            float r5 = m287pointerSlopE8SPZFQ(r5, r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            r10.element = r0
            r0 = r21
            r1 = r25
            r11 = r5
            r12 = r10
            r13 = 1
            r5 = r3
            r10 = r4
            r3 = 0
            r4 = r2
            r2 = 0
        L_0x00ba:
            r5.L$0 = r1
            r5.L$1 = r4
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r9
            r5.I$0 = r13
            r5.F$0 = r11
            r5.F$1 = r3
            r5.F$2 = r2
            r5.label = r8
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r5, r8, r9)
            if (r14 != r10) goto L_0x00d5
            return r10
        L_0x00d5:
            r19 = r3
            r3 = r2
            r2 = r14
            r14 = r13
            r13 = r4
            r4 = r19
        L_0x00dd:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r7 = r15.size()
            r16 = 0
            r8 = 0
        L_0x00ea:
            if (r8 >= r7) goto L_0x010e
            java.lang.Object r17 = r15.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r21 = r10
            long r9 = r18.m3428getIdJ3iCeTQ()
            r22 = r7
            long r6 = r12.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r9, r6)
            if (r6 == 0) goto L_0x0105
            goto L_0x0112
        L_0x0105:
            int r8 = r8 + 1
            r7 = r22
            r6 = 2
            r9 = 0
            r10 = r21
            goto L_0x00ea
        L_0x010e:
            r21 = r10
            r17 = 0
        L_0x0112:
            r6 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x011a
            goto L_0x01b9
        L_0x011a:
            boolean r7 = r6.isConsumed()
            if (r7 == 0) goto L_0x0122
            goto L_0x01b9
        L_0x0122:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0158
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0131:
            if (r7 >= r6) goto L_0x0144
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0141
            goto L_0x0145
        L_0x0141:
            int r7 = r7 + 1
            goto L_0x0131
        L_0x0144:
            r8 = 0
        L_0x0145:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x014b
            goto L_0x01b9
        L_0x014b:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r12.element = r6
            r10 = r21
            r2 = r3
            r3 = r4
            r4 = r13
            r13 = r14
            goto L_0x01bc
        L_0x0158:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r13.m313mainAxisDeltak4lQ0M(r7)
            float r15 = r13.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r15
            float r7 = r13.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r13.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r4
            float r3 = r3 + r7
            if (r14 == 0) goto L_0x017b
            float r4 = java.lang.Math.abs(r2)
            goto L_0x0183
        L_0x017b:
            long r7 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            float r4 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x0183:
            int r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x01c1
            androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r1
            r5.L$1 = r13
            r5.L$2 = r0
            r5.L$3 = r12
            r5.L$4 = r6
            r5.I$0 = r14
            r5.F$0 = r11
            r5.F$1 = r2
            r5.F$2 = r3
            r7 = 2
            r5.label = r7
            java.lang.Object r4 = r0.awaitPointerEvent(r4, r5)
            r10 = r21
            if (r4 != r10) goto L_0x01a7
            return r10
        L_0x01a7:
            r4 = r13
            r13 = r14
            r19 = r3
            r3 = r2
            r2 = r19
            r20 = r11
            r11 = r6
            r6 = r20
        L_0x01b3:
            boolean r8 = r11.isConsumed()
            if (r8 == 0) goto L_0x01bb
        L_0x01b9:
            r9 = 0
            goto L_0x01f4
        L_0x01bb:
            r11 = r6
        L_0x01bc:
            r6 = 2
            r8 = 1
            r9 = 0
            goto L_0x00ba
        L_0x01c1:
            r10 = r21
            r7 = 2
            if (r14 == 0) goto L_0x01d2
            float r4 = java.lang.Math.signum(r2)
            float r4 = r4 * r11
            float r2 = r2 - r4
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            goto L_0x01e2
        L_0x01d2:
            long r2 = r13.m314offsetFromChangesdBAh8RU(r2, r3)
            long r8 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r2, r4)
            long r8 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r8, r11)
            long r2 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r2, r8)
        L_0x01e2:
            float r2 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r2)
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x01f5
            r9 = r6
        L_0x01f4:
            return r9
        L_0x01f5:
            r4 = r13
            r13 = r14
            r2 = 0
            r3 = 0
            goto L_0x01bc
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m273awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1683getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)) == 0.0f)) != false) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00af A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m285horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x004d
            if (r3 != r6) goto L_0x0045
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$2
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            java.lang.Object r8 = r1.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            java.lang.Object r9 = r1.L$0
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r16 = r2
            r2 = r1
            r1 = r9
            r9 = r7
            r7 = r16
            goto L_0x0089
        L_0x0045:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r18.getCurrentEvent()
            r7 = r19
            boolean r0 = m286isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x0062
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0116
        L_0x0062:
            r0 = r18
            r3 = r2
            r2 = r1
            r1 = r21
        L_0x0068:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r8 = r0
            r7 = r3
            r3 = r9
        L_0x0072:
            r2.L$0 = r1
            r2.L$1 = r0
            r2.L$2 = r8
            r2.L$3 = r3
            r2.label = r6
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r8, r4, r2, r6, r4)
            if (r9 != r7) goto L_0x0083
            return r7
        L_0x0083:
            r16 = r8
            r8 = r0
            r0 = r9
            r9 = r16
        L_0x0089:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r10 = r0.getChanges()
            int r11 = r10.size()
            r12 = 0
        L_0x0094:
            if (r12 >= r11) goto L_0x00af
            java.lang.Object r13 = r10.get(r12)
            r14 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
            long r14 = r14.m3428getIdJ3iCeTQ()
            long r4 = r3.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r14, r4)
            if (r4 == 0) goto L_0x00aa
            goto L_0x00b0
        L_0x00aa:
            int r12 = r12 + 1
            r4 = 0
            r5 = 0
            goto L_0x0094
        L_0x00af:
            r13 = 0
        L_0x00b0:
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            if (r13 != 0) goto L_0x00b6
            r13 = 0
            goto L_0x00f8
        L_0x00b6:
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r4 == 0) goto L_0x00e5
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00c5:
            if (r5 >= r4) goto L_0x00d8
            java.lang.Object r10 = r0.get(r5)
            r11 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00d5
            goto L_0x00d9
        L_0x00d5:
            int r5 = r5 + 1
            goto L_0x00c5
        L_0x00d8:
            r10 = 0
        L_0x00d9:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00de
            goto L_0x00f8
        L_0x00de:
            long r4 = r10.m3428getIdJ3iCeTQ()
            r3.element = r4
            goto L_0x0128
        L_0x00e5:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r13)
            float r0 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00f4
            r0 = 1
            goto L_0x00f5
        L_0x00f4:
            r0 = 0
        L_0x00f5:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0128
        L_0x00f8:
            if (r13 != 0) goto L_0x0100
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0116
        L_0x0100:
            r0 = 0
            boolean r3 = r13.isConsumed()
            if (r3 == 0) goto L_0x010c
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0116
        L_0x010c:
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r13)
            if (r3 == 0) goto L_0x0117
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0116:
            return r0
        L_0x0117:
            r1.invoke(r13)
            long r3 = r13.m3428getIdJ3iCeTQ()
            r0 = r8
            r5 = 0
            r16 = r3
            r3 = r7
            r7 = r16
            r4 = 0
            goto L_0x0068
        L_0x0128:
            r0 = 0
            r0 = r8
            r8 = r9
            r4 = 0
            r5 = 0
            goto L_0x0072
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m285horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d9, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1683getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L_0x00db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m272awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m286isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0092
            java.lang.Object r11 = r5.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m3428getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r10 = r10 + 1
            goto L_0x0079
        L_0x0092:
            r11 = r6
        L_0x0093:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0099
            r11 = r6
            goto L_0x00db
        L_0x0099:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
            r8 = 0
        L_0x00a8:
            if (r8 >= r5) goto L_0x00bb
            java.lang.Object r10 = r2.get(r8)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = r12.getPressed()
            if (r12 == 0) goto L_0x00b8
            goto L_0x00bc
        L_0x00b8:
            int r8 = r8 + 1
            goto L_0x00a8
        L_0x00bb:
            r10 = r6
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x00c1
            goto L_0x00db
        L_0x00c1:
            long r8 = r10.m3428getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e9
        L_0x00c8:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r2 = androidx.compose.ui.geometry.Offset.m1683getXimpl(r12)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d7
            r2 = 1
            goto L_0x00d8
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            r2 = r2 ^ r7
            if (r2 == 0) goto L_0x00e9
        L_0x00db:
            if (r11 == 0) goto L_0x00e4
            boolean r0 = r11.isConsumed()
            if (r0 != 0) goto L_0x00e4
            goto L_0x00e5
        L_0x00e4:
            r7 = 0
        L_0x00e5:
            if (r7 == 0) goto L_0x00e8
            r6 = r11
        L_0x00e8:
            return r6
        L_0x00e9:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m272awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectHorizontalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectHorizontalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectHorizontalDragGestures$4.INSTANCE;
        }
        return detectHorizontalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    private static final Object m283dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Float> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super Boolean> continuation) {
        PointerInputChange pointerInputChange;
        long j2 = j;
        if (m286isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return false;
        }
        while (true) {
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
            Object awaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i);
                if (PointerId.m3414equalsimpl0(pointerInputChange.m3428getIdJ3iCeTQ(), j2)) {
                    break;
                }
                i++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 != null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            break;
                        }
                        PointerInputChange pointerInputChange4 = changes2.get(i2);
                        if (pointerInputChange4.getPressed()) {
                            pointerInputChange2 = pointerInputChange4;
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange5 = pointerInputChange2;
                    if (pointerInputChange5 == null) {
                        Function1<? super PointerInputChange, Float> function14 = function12;
                    } else {
                        j2 = pointerInputChange5.m3428getIdJ3iCeTQ();
                    }
                } else {
                    if (!(!(function12.invoke(pointerInputChange3).floatValue() == 0.0f))) {
                        continue;
                    }
                }
                pointerInputChange2 = pointerInputChange3;
            } else {
                Function1<? super PointerInputChange, Float> function15 = function12;
            }
            if (pointerInputChange2 == null || function13.invoke(pointerInputChange2).booleanValue()) {
                return false;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return true;
            }
            function1.invoke(pointerInputChange2);
            j2 = pointerInputChange2.m3428getIdJ3iCeTQ();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m271awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        while (true) {
            int i = 0;
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            Object awaitPointerEvent$default = AwaitPointerEventScope.CC.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (PointerId.m3414equalsimpl0(pointerInputChange.m3428getIdJ3iCeTQ(), j)) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (pointerInputChange4.getPressed()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                j = pointerInputChange5.m3428getIdJ3iCeTQ();
            } else if (function1.invoke(pointerInputChange3).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m276awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope r21, long r22, int r24, androidx.compose.foundation.gestures.PointerDirectionConfig r25, boolean r26, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r28) {
        /*
            r0 = r22
            r2 = r28
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x008d
            if (r5 == r8) goto L_0x0062
            if (r5 != r6) goto L_0x005a
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            boolean r10 = r3.Z$0
            java.lang.Object r11 = r3.L$4
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            java.lang.Object r12 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r3.L$2
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            java.lang.Object r14 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r14 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r14
            java.lang.Object r15 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r15 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r10
            r7 = 2
            r10 = r5
            r5 = r1
            r1 = r14
            r14 = r12
            r12 = r3
            r3 = r13
            r13 = r4
            r4 = r0
            r0 = r15
            goto L_0x01a9
        L_0x005a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0062:
            float r0 = r3.F$2
            float r1 = r3.F$1
            float r5 = r3.F$0
            boolean r10 = r3.Z$0
            java.lang.Object r11 = r3.L$3
            kotlin.jvm.internal.Ref$LongRef r11 = (kotlin.jvm.internal.Ref.LongRef) r11
            java.lang.Object r12 = r3.L$2
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            java.lang.Object r13 = r3.L$1
            androidx.compose.foundation.gestures.PointerDirectionConfig r13 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r13
            java.lang.Object r14 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r19 = r4
            r4 = r0
            r0 = r14
            r14 = r11
            r11 = r5
            r5 = r1
            r1 = r13
            r13 = r19
            r20 = r12
            r12 = r3
            r3 = r20
            goto L_0x00de
        L_0x008d:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r21.getCurrentEvent()
            boolean r2 = m286isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x009b
            return r9
        L_0x009b:
            androidx.compose.ui.platform.ViewConfiguration r2 = r21.getViewConfiguration()
            r5 = r24
            float r2 = m287pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r21
            r1 = r25
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r4 = 0
            r5 = 0
            r2 = r26
            r3 = r27
        L_0x00ba:
            r11.L$0 = r0
            r11.L$1 = r1
            r11.L$2 = r3
            r11.L$3 = r13
            r11.L$4 = r9
            r11.Z$0 = r2
            r11.F$0 = r10
            r11.F$1 = r5
            r11.F$2 = r4
            r11.label = r8
            java.lang.Object r14 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r9, r11, r8, r9)
            if (r14 != r12) goto L_0x00d5
            return r12
        L_0x00d5:
            r19 = r10
            r10 = r2
            r2 = r14
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r19
        L_0x00de:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r15 = r2.getChanges()
            int r7 = r15.size()
            r16 = 0
            r8 = 0
        L_0x00eb:
            if (r8 >= r7) goto L_0x010f
            java.lang.Object r17 = r15.get(r8)
            r18 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r18 = (androidx.compose.ui.input.pointer.PointerInputChange) r18
            r21 = r7
            long r6 = r18.m3428getIdJ3iCeTQ()
            r22 = r10
            long r9 = r14.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r6, r9)
            if (r6 == 0) goto L_0x0106
            goto L_0x0113
        L_0x0106:
            int r8 = r8 + 1
            r7 = r21
            r10 = r22
            r6 = 2
            r9 = 0
            goto L_0x00eb
        L_0x010f:
            r22 = r10
            r17 = 0
        L_0x0113:
            r6 = r17
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x011b
            r7 = 0
            return r7
        L_0x011b:
            r7 = 0
            boolean r8 = r6.isConsumed()
            if (r8 == 0) goto L_0x0123
            return r7
        L_0x0123:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0156
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r7 = 0
        L_0x0132:
            if (r7 >= r6) goto L_0x0145
            java.lang.Object r8 = r2.get(r7)
            r9 = r8
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = r9.getPressed()
            if (r9 == 0) goto L_0x0142
            goto L_0x0146
        L_0x0142:
            int r7 = r7 + 1
            goto L_0x0132
        L_0x0145:
            r8 = 0
        L_0x0146:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x014c
            r2 = 0
            return r2
        L_0x014c:
            long r6 = r8.m3428getIdJ3iCeTQ()
            r14.element = r6
            r2 = r22
            r10 = r11
            goto L_0x01b1
        L_0x0156:
            long r7 = r6.m3429getPositionF1C5BW0()
            long r9 = r6.m3430getPreviousPositionF1C5BW0()
            float r2 = r1.m313mainAxisDeltak4lQ0M(r7)
            float r15 = r1.m313mainAxisDeltak4lQ0M(r9)
            float r2 = r2 - r15
            float r7 = r1.m312crossAxisDeltak4lQ0M(r7)
            float r8 = r1.m312crossAxisDeltak4lQ0M(r9)
            float r7 = r7 - r8
            float r2 = r2 + r5
            float r4 = r4 + r7
            if (r22 == 0) goto L_0x0179
            float r5 = java.lang.Math.abs(r2)
            goto L_0x0181
        L_0x0179:
            long r7 = r1.m314offsetFromChangesdBAh8RU(r2, r4)
            float r5 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r7)
        L_0x0181:
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x01b9
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r12.L$0 = r0
            r12.L$1 = r1
            r12.L$2 = r3
            r12.L$3 = r14
            r12.L$4 = r6
            r10 = r22
            r12.Z$0 = r10
            r12.F$0 = r11
            r12.F$1 = r2
            r12.F$2 = r4
            r7 = 2
            r12.label = r7
            java.lang.Object r5 = r0.awaitPointerEvent(r5, r12)
            if (r5 != r13) goto L_0x01a5
            return r13
        L_0x01a5:
            r5 = r2
            r2 = r10
            r10 = r11
            r11 = r6
        L_0x01a9:
            boolean r6 = r11.isConsumed()
            if (r6 == 0) goto L_0x01b1
            r8 = 0
            return r8
        L_0x01b1:
            r11 = r12
            r12 = r13
            r13 = r14
        L_0x01b4:
            r6 = 2
            r8 = 1
            r9 = 0
            goto L_0x00ba
        L_0x01b9:
            r10 = r22
            r7 = 2
            r8 = 0
            if (r10 == 0) goto L_0x01cb
            float r5 = java.lang.Math.signum(r2)
            float r5 = r5 * r11
            float r2 = r2 - r5
            long r4 = r1.m314offsetFromChangesdBAh8RU(r2, r4)
            goto L_0x01db
        L_0x01cb:
            long r7 = r1.m314offsetFromChangesdBAh8RU(r2, r4)
            long r4 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r7, r5)
            long r4 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r4, r11)
            long r4 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r7, r4)
        L_0x01db:
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m1672boximpl(r4)
            r3.invoke(r6, r2)
            boolean r2 = r6.isConsumed()
            if (r2 == 0) goto L_0x01e9
            return r6
        L_0x01e9:
            r2 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r4 = 0
            r5 = 0
            goto L_0x01b4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m276awaitPointerSlopOrCancellationwtdNQyU(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ef, code lost:
        if (r3 == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f1, code lost:
        r9 = r2.m314offsetFromChangesdBAh8RU(r10 - (java.lang.Math.signum(r10) * r23), r11);
        r5 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ff, code lost:
        r9 = r2.m314offsetFromChangesdBAh8RU(r10, r11);
        r11 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r9, r5);
        r5 = r23;
        r9 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r9, androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r11, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0111, code lost:
        r24.invoke(r4, androidx.compose.ui.geometry.Offset.m1672boximpl(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011e, code lost:
        if (r4.isConsumed() == false) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0120, code lost:
        return r4;
     */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$default  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object m278awaitPointerSlopOrCancellationwtdNQyU$default(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, int r21, androidx.compose.foundation.gestures.PointerDirectionConfig r22, boolean r23, kotlin.jvm.functions.Function2 r24, kotlin.coroutines.Continuation r25, int r26, java.lang.Object r27) {
        /*
            r0 = r18
            r1 = r25
            r2 = r26 & 4
            if (r2 == 0) goto L_0x000d
            androidx.compose.foundation.gestures.PointerDirectionConfig r2 = getHorizontalPointerDirectionConfig()
            goto L_0x000f
        L_0x000d:
            r2 = r22
        L_0x000f:
            r3 = r26 & 8
            r4 = 1
            if (r3 == 0) goto L_0x0016
            r3 = 1
            goto L_0x0018
        L_0x0016:
            r3 = r23
        L_0x0018:
            androidx.compose.ui.input.pointer.PointerEvent r5 = r18.getCurrentEvent()
            r6 = r19
            boolean r5 = m286isPointerUpDmW0f2w(r5, r6)
            r8 = 0
            if (r5 == 0) goto L_0x0026
            return r8
        L_0x0026:
            androidx.compose.ui.platform.ViewConfiguration r5 = r18.getViewConfiguration()
            r9 = r21
            float r5 = m287pointerSlopE8SPZFQ(r5, r9)
        L_0x0030:
            r10 = 0
            r11 = 0
        L_0x0032:
            r12 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r12)
            java.lang.Object r13 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r8, r1, r4, r8)
            kotlin.jvm.internal.InlineMarker.mark((int) r4)
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.util.List r14 = r13.getChanges()
            int r15 = r14.size()
            r9 = 0
        L_0x0048:
            if (r9 >= r15) goto L_0x0065
            java.lang.Object r16 = r14.get(r9)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r23 = r5
            long r4 = r17.m3428getIdJ3iCeTQ()
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r4, r6)
            if (r4 == 0) goto L_0x005f
            goto L_0x0069
        L_0x005f:
            int r9 = r9 + 1
            r5 = r23
            r4 = 1
            goto L_0x0048
        L_0x0065:
            r23 = r5
            r16 = r8
        L_0x0069:
            r4 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            if (r4 == 0) goto L_0x0125
            boolean r5 = r4.isConsumed()
            if (r5 == 0) goto L_0x0076
            return r8
        L_0x0076:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r4)
            if (r5 == 0) goto L_0x00a5
            java.util.List r4 = r13.getChanges()
            int r5 = r4.size()
        L_0x0084:
            if (r12 >= r5) goto L_0x0097
            java.lang.Object r6 = r4.get(r12)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            boolean r7 = r7.getPressed()
            if (r7 == 0) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            int r12 = r12 + 1
            goto L_0x0084
        L_0x0097:
            r6 = r8
        L_0x0098:
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            if (r6 != 0) goto L_0x009d
            return r8
        L_0x009d:
            long r6 = r6.m3428getIdJ3iCeTQ()
            r5 = r23
            r4 = 1
            goto L_0x0032
        L_0x00a5:
            long r13 = r4.m3429getPositionF1C5BW0()
            long r8 = r4.m3430getPreviousPositionF1C5BW0()
            float r5 = r2.m313mainAxisDeltak4lQ0M(r13)
            float r15 = r2.m313mainAxisDeltak4lQ0M(r8)
            float r5 = r5 - r15
            float r13 = r2.m312crossAxisDeltak4lQ0M(r13)
            float r8 = r2.m312crossAxisDeltak4lQ0M(r8)
            float r13 = r13 - r8
            float r10 = r10 + r5
            float r11 = r11 + r13
            if (r3 == 0) goto L_0x00c8
            float r5 = java.lang.Math.abs(r10)
            goto L_0x00d0
        L_0x00c8:
            long r8 = r2.m314offsetFromChangesdBAh8RU(r10, r11)
            float r5 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r8)
        L_0x00d0:
            int r8 = (r5 > r23 ? 1 : (r5 == r23 ? 0 : -1))
            if (r8 >= 0) goto L_0x00ee
            androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            kotlin.jvm.internal.InlineMarker.mark((int) r12)
            r0.awaitPointerEvent(r5, r1)
            r8 = 1
            kotlin.jvm.internal.InlineMarker.mark((int) r8)
            boolean r4 = r4.isConsumed()
            if (r4 == 0) goto L_0x00e8
            r4 = 0
            return r4
        L_0x00e8:
            r5 = r23
            r4 = 1
            r8 = 0
            goto L_0x0032
        L_0x00ee:
            r8 = 1
            if (r3 == 0) goto L_0x00ff
            float r5 = java.lang.Math.signum(r10)
            float r5 = r5 * r23
            float r10 = r10 - r5
            long r9 = r2.m314offsetFromChangesdBAh8RU(r10, r11)
            r5 = r23
            goto L_0x0111
        L_0x00ff:
            long r9 = r2.m314offsetFromChangesdBAh8RU(r10, r11)
            long r11 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r9, r5)
            r5 = r23
            long r11 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r11, r5)
            long r9 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r9, r11)
        L_0x0111:
            androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m1672boximpl(r9)
            r10 = r24
            r10.invoke(r4, r9)
            boolean r9 = r4.isConsumed()
            if (r9 == 0) goto L_0x0121
            return r4
        L_0x0121:
            r4 = 1
            r8 = 0
            goto L_0x0030
        L_0x0125:
            r4 = r8
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m278awaitPointerSlopOrCancellationwtdNQyU$default(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d2, code lost:
        if (r23 == false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d4, code lost:
        r8 = r1.m314offsetFromChangesdBAh8RU(r8 - (java.lang.Math.signum(r8) * r3), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e0, code lost:
        r8 = r1.m314offsetFromChangesdBAh8RU(r8, r9);
        r8 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r8, androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r8, r11), r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f0, code lost:
        r24.invoke(r10, androidx.compose.ui.geometry.Offset.m1672boximpl(r8));
     */
    /* renamed from: awaitPointerSlopOrCancellation-wtdNQyU$$forInline  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.Object m277awaitPointerSlopOrCancellationwtdNQyU$$forInline(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, long r19, int r21, androidx.compose.foundation.gestures.PointerDirectionConfig r22, boolean r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r18
            r1 = r22
            r2 = r25
            androidx.compose.ui.input.pointer.PointerEvent r3 = r18.getCurrentEvent()
            r4 = r19
            boolean r3 = m286isPointerUpDmW0f2w(r3, r4)
            r6 = 0
            if (r3 == 0) goto L_0x0014
            return r6
        L_0x0014:
            androidx.compose.ui.platform.ViewConfiguration r3 = r18.getViewConfiguration()
            r7 = r21
            float r3 = m287pointerSlopE8SPZFQ(r3, r7)
            r7 = 0
        L_0x001f:
            r8 = 0
            r9 = 0
        L_0x0021:
            r10 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r10)
            r11 = 1
            java.lang.Object r12 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r0, r6, r2, r11, r6)
            kotlin.jvm.internal.InlineMarker.mark((int) r11)
            androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
            java.util.List r13 = r12.getChanges()
            int r14 = r13.size()
            r15 = 0
        L_0x0038:
            if (r15 >= r14) goto L_0x0052
            java.lang.Object r16 = r13.get(r15)
            r17 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r10 = r17.m3428getIdJ3iCeTQ()
            boolean r10 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r10, r4)
            if (r10 == 0) goto L_0x004d
            goto L_0x0054
        L_0x004d:
            int r15 = r15 + 1
            r10 = 0
            r11 = 1
            goto L_0x0038
        L_0x0052:
            r16 = r6
        L_0x0054:
            r10 = r16
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 == 0) goto L_0x0100
            boolean r11 = r10.isConsumed()
            if (r11 == 0) goto L_0x0061
            return r6
        L_0x0061:
            boolean r11 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r11 == 0) goto L_0x008e
            java.util.List r4 = r12.getChanges()
            int r5 = r4.size()
            r10 = 0
        L_0x0070:
            if (r10 >= r5) goto L_0x0083
            java.lang.Object r11 = r4.get(r10)
            r12 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            boolean r12 = r12.getPressed()
            if (r12 == 0) goto L_0x0080
            goto L_0x0084
        L_0x0080:
            int r10 = r10 + 1
            goto L_0x0070
        L_0x0083:
            r11 = r6
        L_0x0084:
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            if (r11 != 0) goto L_0x0089
            return r6
        L_0x0089:
            long r4 = r11.m3428getIdJ3iCeTQ()
            goto L_0x0021
        L_0x008e:
            long r11 = r10.m3429getPositionF1C5BW0()
            long r13 = r10.m3430getPreviousPositionF1C5BW0()
            float r15 = r1.m313mainAxisDeltak4lQ0M(r11)
            float r16 = r1.m313mainAxisDeltak4lQ0M(r13)
            float r15 = r15 - r16
            float r11 = r1.m312crossAxisDeltak4lQ0M(r11)
            float r12 = r1.m312crossAxisDeltak4lQ0M(r13)
            float r11 = r11 - r12
            float r8 = r8 + r15
            float r9 = r9 + r11
            if (r23 == 0) goto L_0x00b2
            float r11 = java.lang.Math.abs(r8)
            goto L_0x00ba
        L_0x00b2:
            long r11 = r1.m314offsetFromChangesdBAh8RU(r8, r9)
            float r11 = androidx.compose.ui.geometry.Offset.m1681getDistanceimpl(r11)
        L_0x00ba:
            int r12 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d2
            androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r12 = 0
            kotlin.jvm.internal.InlineMarker.mark((int) r12)
            r0.awaitPointerEvent(r11, r2)
            r11 = 1
            kotlin.jvm.internal.InlineMarker.mark((int) r11)
            boolean r10 = r10.isConsumed()
            if (r10 == 0) goto L_0x0021
            return r6
        L_0x00d2:
            if (r23 == 0) goto L_0x00e0
            float r11 = java.lang.Math.signum(r8)
            float r11 = r11 * r3
            float r8 = r8 - r11
            long r8 = r1.m314offsetFromChangesdBAh8RU(r8, r9)
            goto L_0x00f0
        L_0x00e0:
            long r8 = r1.m314offsetFromChangesdBAh8RU(r8, r9)
            long r11 = androidx.compose.ui.geometry.Offset.m1678divtuRUvjQ(r8, r11)
            long r11 = androidx.compose.ui.geometry.Offset.m1690timestuRUvjQ(r11, r3)
            long r8 = androidx.compose.ui.geometry.Offset.m1687minusMKHz9U(r8, r11)
        L_0x00f0:
            androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m1672boximpl(r8)
            r9 = r24
            r9.invoke(r10, r8)
            boolean r8 = r10.isConsumed()
            if (r8 == 0) goto L_0x001f
            return r10
        L_0x0100:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m277awaitPointerSlopOrCancellationwtdNQyU$$forInline(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, androidx.compose.foundation.gestures.PointerDirectionConfig, boolean, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static {
        float r0 = Dp.m4704constructorimpl((float) 18);
        defaultTouchSlop = r0;
        mouseToTouchSlopRatio = mouseSlop / r0;
    }

    public static final PointerDirectionConfig getHorizontalPointerDirectionConfig() {
        return HorizontalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig getVerticalPointerDirectionConfig() {
        return VerticalPointerDirectionConfig;
    }

    public static final PointerDirectionConfig toPointerDirectionConfig(Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<this>");
        if (orientation == Orientation.Vertical) {
            return VerticalPointerDirectionConfig;
        }
        return HorizontalPointerDirectionConfig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitLongPressOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m275awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, long r10, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ PointerEventTimeoutCancellationException -> 0x0033 }
            goto L_0x00a0
        L_0x0033:
            goto L_0x00a4
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            boolean r12 = m286isPointerUpDmW0f2w(r12, r10)
            if (r12 == 0) goto L_0x004c
            return r4
        L_0x004c:
            androidx.compose.ui.input.pointer.PointerEvent r12 = r9.getCurrentEvent()
            java.util.List r12 = r12.getChanges()
            r2 = 0
            int r5 = r12.size()
        L_0x0059:
            if (r2 >= r5) goto L_0x0070
            java.lang.Object r6 = r12.get(r2)
            r7 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r7 = r7.m3428getIdJ3iCeTQ()
            boolean r7 = androidx.compose.ui.input.pointer.PointerId.m3414equalsimpl0(r7, r10)
            if (r7 == 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            int r2 = r2 + 1
            goto L_0x0059
        L_0x0070:
            r6 = r4
        L_0x0071:
            r10 = r6
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            if (r10 != 0) goto L_0x0077
            return r4
        L_0x0077:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef
            r12.<init>()
            r12.element = r10
            androidx.compose.ui.platform.ViewConfiguration r2 = r9.getViewConfiguration()
            long r5 = r2.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r2 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            r2.<init>(r12, r11, r4)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            r0.L$0 = r10     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            r0.L$1 = r11     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            r0.label = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            java.lang.Object r9 = r9.withTimeout(r5, r2, r0)     // Catch:{ PointerEventTimeoutCancellationException -> 0x00a3 }
            if (r9 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r9 = r11
        L_0x00a0:
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4     // Catch:{ PointerEventTimeoutCancellationException -> 0x0033 }
            goto L_0x00ad
        L_0x00a3:
            r9 = r11
        L_0x00a4:
            T r9 = r9.element
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00ac
            r4 = r10
            goto L_0x00ad
        L_0x00ac:
            r4 = r9
        L_0x00ad:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m275awaitLongPressOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m286isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m3414equalsimpl0(pointerInputChange.m3428getIdJ3iCeTQ(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m287pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "$this$pointerSlop");
        if (PointerType.m3502equalsimpl0(i, PointerType.Companion.m3507getMouseT8wyACA())) {
            return viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return viewConfiguration.getTouchSlop();
    }
}
