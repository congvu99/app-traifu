package io.intercom.android.sdk.m5.inbox;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import io.intercom.android.sdk.inbox.InboxScreenEffects;
import io.intercom.android.sdk.inbox.InboxScreenState;
import io.intercom.android.sdk.inbox.IntercomInboxViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"InboxScreen", "", "viewModel", "Lio/intercom/android/sdk/inbox/IntercomInboxViewModel;", "onSendMessageButtonClick", "Lkotlin/Function0;", "onBrowseHelpCenterButtonClick", "onBackButtonClick", "onConversationClicked", "Lkotlin/Function1;", "Lio/intercom/android/sdk/inbox/InboxScreenEffects$NavigateToConversation;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lio/intercom/android/sdk/inbox/IntercomInboxViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/lifecycle/LifecycleOwner;Landroidx/compose/runtime/Composer;II)V", "intercom-sdk-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
public final class InboxScreenKt {
    public static final void InboxScreen(IntercomInboxViewModel intercomInboxViewModel, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function1<? super InboxScreenEffects.NavigateToConversation, Unit> function1, LifecycleOwner lifecycleOwner, Composer composer, int i, int i2) {
        LifecycleOwner lifecycleOwner2;
        int i3;
        IntercomInboxViewModel intercomInboxViewModel2 = intercomInboxViewModel;
        Function0<Unit> function04 = function0;
        Function0<Unit> function05 = function03;
        Function1<? super InboxScreenEffects.NavigateToConversation, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(intercomInboxViewModel2, "viewModel");
        Intrinsics.checkNotNullParameter(function04, "onSendMessageButtonClick");
        Intrinsics.checkNotNullParameter(function02, "onBrowseHelpCenterButtonClick");
        Intrinsics.checkNotNullParameter(function05, "onBackButtonClick");
        Intrinsics.checkNotNullParameter(function12, "onConversationClicked");
        Composer startRestartGroup = composer.startRestartGroup(-1795663269);
        if ((i2 & 32) != 0) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            i3 = i & -458753;
            lifecycleOwner2 = (LifecycleOwner) consume;
        } else {
            lifecycleOwner2 = lifecycleOwner;
            i3 = i;
        }
        LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
        EffectsKt.DisposableEffect((Object) lifecycleOwner2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new InboxScreenKt$InboxScreen$1(lifecycleOwner2, intercomInboxViewModel2), startRestartGroup, 8);
        EffectsKt.LaunchedEffect((Object) null, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new InboxScreenKt$InboxScreen$2(intercomInboxViewModel2, function12, rememberLazyListState, (Continuation<? super InboxScreenKt$InboxScreen$2>) null), startRestartGroup, 70);
        State collectAsState = SnapshotStateKt.collectAsState(intercomInboxViewModel.getUiState(), InboxScreenState.Initial.INSTANCE, (CoroutineContext) null, startRestartGroup, 56, 2);
        InboxScreenKt$InboxScreen$5 inboxScreenKt$InboxScreen$5 = r0;
        LifecycleOwner lifecycleOwner3 = lifecycleOwner2;
        Composer composer2 = startRestartGroup;
        InboxScreenKt$InboxScreen$5 inboxScreenKt$InboxScreen$52 = new InboxScreenKt$InboxScreen$5(rememberLazyListState, collectAsState, intercomInboxViewModel, function0, function02);
        ScaffoldKt.m1388Scaffold27mzLpw((Modifier) null, (ScaffoldState) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1568218912, true, new InboxScreenKt$InboxScreen$3(function05, i3)), (Function2<? super Composer, ? super Integer, Unit>) null, (Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit>) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1552153891, true, new InboxScreenKt$InboxScreen$4(collectAsState, function04, i3)), 0, false, (Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit>) null, false, (Shape) null, 0.0f, 0, 0, 0, 0, 0, ComposableLambdaKt.composableLambda(composer2, -1319019111, true, inboxScreenKt$InboxScreen$5), composer2, 196992, 12582912, 131035);
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InboxScreenKt$InboxScreen$6(intercomInboxViewModel, function0, function02, function03, function1, lifecycleOwner3, i, i2));
        }
    }
}
