package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 implements LifecycleEventObserver {
    final /* synthetic */ PausableMonotonicFrameClock $pausableClock;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ CoroutineScope $runRecomposeScope;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WindowRecomposer.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 5;
            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 6;
            iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2(CoroutineScope coroutineScope, PausableMonotonicFrameClock pausableMonotonicFrameClock, Recomposer recomposer, Ref.ObjectRef<MotionDurationScaleImpl> objectRef, View view) {
        this.$runRecomposeScope = coroutineScope;
        this.$pausableClock = pausableMonotonicFrameClock;
        this.$recomposer = recomposer;
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$runRecomposeScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1(this.$systemDurationScaleSettingConsumer, this.$recomposer, lifecycleOwner, this, this.$this_createLifecycleAwareWindowRecomposer, (Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2$onStateChanged$1>) null), 1, (Object) null);
        } else if (i == 2) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock = this.$pausableClock;
            if (pausableMonotonicFrameClock != null) {
                pausableMonotonicFrameClock.resume();
            }
        } else if (i == 3) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = this.$pausableClock;
            if (pausableMonotonicFrameClock2 != null) {
                pausableMonotonicFrameClock2.pause();
            }
        } else if (i == 4) {
            this.$recomposer.cancel();
        }
    }
}
