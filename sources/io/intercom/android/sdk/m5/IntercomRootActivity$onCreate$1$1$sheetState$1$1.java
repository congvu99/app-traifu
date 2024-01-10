package io.intercom.android.sdk.m5;

import androidx.compose.material.ModalBottomSheetValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$sheetState$1$1 extends Lambda implements Function1<ModalBottomSheetValue, Boolean> {
    final /* synthetic */ IntercomRootActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$sheetState$1$1(IntercomRootActivity intercomRootActivity) {
        super(1);
        this.this$0 = intercomRootActivity;
    }

    public final Boolean invoke(ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return Boolean.valueOf(this.this$0.confirmStateChange(modalBottomSheetValue));
    }
}
