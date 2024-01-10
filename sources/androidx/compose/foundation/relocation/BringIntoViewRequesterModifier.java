package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewRequesterModifier;", "Landroidx/compose/foundation/relocation/BringIntoViewChildModifier;", "defaultParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "(Landroidx/compose/foundation/relocation/BringIntoViewParent;)V", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterModifier extends BringIntoViewChildModifier {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterModifier(BringIntoViewParent bringIntoViewParent) {
        super(bringIntoViewParent);
        Intrinsics.checkNotNullParameter(bringIntoViewParent, "defaultParent");
    }

    public final Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        BringIntoViewParent parent = getParent();
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return Unit.INSTANCE;
        }
        Object bringChildIntoView = parent.bringChildIntoView(layoutCoordinates, new BringIntoViewRequesterModifier$bringIntoView$2(rect, this), continuation);
        return bringChildIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringChildIntoView : Unit.INSTANCE;
    }
}
