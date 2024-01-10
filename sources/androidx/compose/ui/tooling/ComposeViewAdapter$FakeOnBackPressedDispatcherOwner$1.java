package androidx.compose.ui.tooling;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/activity/OnBackPressedDispatcherOwner;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getOnBackPressedDispatcher", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 implements OnBackPressedDispatcherOwner {
    private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
    final /* synthetic */ ComposeViewAdapter this$0;

    ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(ComposeViewAdapter composeViewAdapter) {
        this.this$0 = composeViewAdapter;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public Lifecycle getLifecycle() {
        return this.this$0.FakeSavedStateRegistryOwner.getLifecycle();
    }
}
