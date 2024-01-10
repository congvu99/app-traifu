package androidx.compose.material.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/unit/IntRect;", "invoke-KMgbckE", "(Landroidx/compose/ui/geometry/Offset;Landroidx/compose/ui/unit/IntRect;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
final class PopupLayout$dismissOnOutsideClick$1 extends Lambda implements Function2<Offset, IntRect, Boolean> {
    public static final PopupLayout$dismissOnOutsideClick$1 INSTANCE = new PopupLayout$dismissOnOutsideClick$1();

    PopupLayout$dismissOnOutsideClick$1() {
        super(2);
    }

    /* renamed from: invoke-KMgbckE  reason: not valid java name */
    public final Boolean invoke(Offset offset, IntRect intRect) {
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        boolean z = false;
        if (offset != null && (Offset.m1683getXimpl(offset.m1693unboximpl()) < ((float) intRect.getLeft()) || Offset.m1683getXimpl(offset.m1693unboximpl()) > ((float) intRect.getRight()) || Offset.m1684getYimpl(offset.m1693unboximpl()) < ((float) intRect.getTop()) || Offset.m1684getYimpl(offset.m1693unboximpl()) > ((float) intRect.getBottom()))) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
