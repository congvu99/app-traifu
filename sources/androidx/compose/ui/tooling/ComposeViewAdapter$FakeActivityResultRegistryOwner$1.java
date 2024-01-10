package androidx.compose.ui.tooling;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0002\u0000\u0003\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/activity/result/ActivityResultRegistryOwner;", "activityResultRegistry", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1;", "getActivityResultRegistry", "Landroidx/activity/result/ActivityResultRegistry;", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter$FakeActivityResultRegistryOwner$1 implements ActivityResultRegistryOwner {
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1();

    ComposeViewAdapter$FakeActivityResultRegistryOwner$1() {
    }

    public ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }
}
