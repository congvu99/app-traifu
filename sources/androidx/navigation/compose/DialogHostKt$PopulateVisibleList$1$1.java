package androidx.navigation.compose;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$PopulateVisibleList$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ NavBackStackEntry $entry;
    final /* synthetic */ List<NavBackStackEntry> $this_PopulateVisibleList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$PopulateVisibleList$1$1(NavBackStackEntry navBackStackEntry, List<NavBackStackEntry> list) {
        super(1);
        this.$entry = navBackStackEntry;
        this.$this_PopulateVisibleList = list;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        $$Lambda$DialogHostKt$PopulateVisibleList$1$1$j9y19_U5_D1cFwohkNl95Oq_lno r1 = new LifecycleEventObserver(this.$this_PopulateVisibleList, this.$entry) {
            public final /* synthetic */ List f$0;
            public final /* synthetic */ NavBackStackEntry f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                DialogHostKt$PopulateVisibleList$1$1.m4977invoke$lambda0(this.f$0, this.f$1, lifecycleOwner, event);
            }
        };
        this.$entry.getLifecycle().addObserver(r1);
        return new DialogHostKt$PopulateVisibleList$1$1$invoke$$inlined$onDispose$1(this.$entry, r1);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m4977invoke$lambda0(List list, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(list, "$this_PopulateVisibleList");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "$entry");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_START && !list.contains(navBackStackEntry)) {
            list.add(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_STOP) {
            list.remove(navBackStackEntry);
        }
    }
}
