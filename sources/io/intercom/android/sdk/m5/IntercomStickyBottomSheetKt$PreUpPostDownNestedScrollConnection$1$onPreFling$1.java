package io.intercom.android.sdk.m5;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1", f = "IntercomStickyBottomSheet.kt", i = {0}, l = {222}, m = "onPreFling-QWom1Mo", n = {"available"}, s = {"J$0"})
/* compiled from: IntercomStickyBottomSheet.kt */
final class IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1 intercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1, Continuation<? super IntercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = intercomStickyBottomSheetKt$PreUpPostDownNestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m5115onPreFlingQWom1Mo(0, this);
    }
}
