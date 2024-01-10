package io.intercom.android.sdk.m5;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$2$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ MutableState<Float> $sheetHeightAsState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$2$1(MutableState<Float> mutableState) {
        super(1);
        this.$sheetHeightAsState = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        this.$sheetHeightAsState.setValue(Float.valueOf((float) IntSize.m4863getHeightimpl(layoutCoordinates.m3611getSizeYbymL2g())));
    }
}
