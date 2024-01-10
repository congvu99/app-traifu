package io.intercom.android.sdk.m5.inbox;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import io.intercom.android.sdk.inbox.IntercomInboxViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InboxScreen.kt */
final class InboxScreenKt$InboxScreen$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ IntercomInboxViewModel $viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InboxScreenKt$InboxScreen$1(LifecycleOwner lifecycleOwner, IntercomInboxViewModel intercomInboxViewModel) {
        super(1);
        this.$lifecycleOwner = lifecycleOwner;
        this.$viewModel = intercomInboxViewModel;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        $$Lambda$InboxScreenKt$InboxScreen$1$TDuxU1rQemP55neVzvGH4gg0S8 r0 = new LifecycleEventObserver() {
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                InboxScreenKt$InboxScreen$1.m5256invoke$lambda0(IntercomInboxViewModel.this, lifecycleOwner, event);
            }
        };
        this.$lifecycleOwner.getLifecycle().addObserver(r0);
        return new InboxScreenKt$InboxScreen$1$invoke$$inlined$onDispose$1(this.$lifecycleOwner, r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m5256invoke$lambda0(IntercomInboxViewModel intercomInboxViewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(intercomInboxViewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_RESUME) {
            IntercomInboxViewModel.fetchInboxData$default(intercomInboxViewModel, (Long) null, 1, (Object) null);
        }
    }
}
