package androidx.compose.ui.tooling;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/savedstate/SavedStateRegistryOwner;", "controller", "Landroidx/savedstate/SavedStateRegistryController;", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ComposeViewAdapter$FakeSavedStateRegistryOwner$1 implements SavedStateRegistryOwner {
    private final SavedStateRegistryController controller;
    private final LifecycleRegistry lifecycle;

    ComposeViewAdapter$FakeSavedStateRegistryOwner$1() {
        LifecycleRegistry createUnsafe = LifecycleRegistry.createUnsafe(this);
        Intrinsics.checkNotNullExpressionValue(createUnsafe, "createUnsafe(this)");
        this.lifecycle = createUnsafe;
        SavedStateRegistryController create = SavedStateRegistryController.Companion.create(this);
        create.performRestore(new Bundle());
        this.controller = create;
        this.lifecycle.setCurrentState(Lifecycle.State.RESUMED);
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.controller.getSavedStateRegistry();
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }
}
