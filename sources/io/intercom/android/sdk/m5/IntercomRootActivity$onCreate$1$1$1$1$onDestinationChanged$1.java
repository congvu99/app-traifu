package io.intercom.android.sdk.m5;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.SwipeableState;
import androidx.navigation.NavDestination;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.intercom.android.sdk.m5.IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1", f = "IntercomRootActivity.kt", i = {}, l = {87, 88, 91}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IntercomRootActivity.kt */
final class IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavDestination $destination;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1(NavDestination navDestination, ModalBottomSheetState modalBottomSheetState, Continuation<? super IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1> continuation) {
        super(2, continuation);
        this.$destination = navDestination;
        this.$sheetState = modalBottomSheetState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1(this.$destination, this.$sheetState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomRootActivity$onCreate$1$1$1$1$onDestinationChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual((Object) this.$destination.getRoute(), (Object) IntercomDestination.HOME.name())) {
                this.label = 3;
                if (SwipeableState.animateTo$default(this.$sheetState, ModalBottomSheetValue.Expanded, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (this.$sheetState.getCurrentValue() != ModalBottomSheetValue.Expanded) {
                this.label = 1;
                if (DelayKt.delay(300, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 2;
        if (SwipeableState.animateTo$default(this.$sheetState, ModalBottomSheetValue.HalfExpanded, (AnimationSpec) null, this, 2, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
