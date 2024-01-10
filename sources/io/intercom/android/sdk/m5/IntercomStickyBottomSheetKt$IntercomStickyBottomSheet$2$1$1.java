package io.intercom.android.sdk.m5;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.SwipeableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomStickyBottomSheet.kt */
final class IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onSheetDismissed;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ ModalBottomSheetState $sheetState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$1$1(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, Function0<Unit> function0) {
        super(0);
        this.$scope = coroutineScope;
        this.$sheetState = modalBottomSheetState;
        this.$onSheetDismissed = function0;
    }

    public final void invoke() {
        CoroutineScope coroutineScope = this.$scope;
        final ModalBottomSheetState modalBottomSheetState = this.$sheetState;
        final Function0<Unit> function0 = this.$onSheetDismissed;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$1$1$1", f = "IntercomStickyBottomSheet.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.intercom.android.sdk.m5.IntercomStickyBottomSheetKt$IntercomStickyBottomSheet$2$1$1$1  reason: invalid class name */
    /* compiled from: IntercomStickyBottomSheet.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(modalBottomSheetState, function0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SwipeableState.animateTo$default(modalBottomSheetState, ModalBottomSheetValue.Hidden, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0.invoke();
            return Unit.INSTANCE;
        }
    }
}
