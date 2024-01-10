package androidx.compose.ui.platform;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: DisposableSaveableStateRegistry.android.kt */
final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1 implements SavedStateRegistry.SavedStateProvider {
    final /* synthetic */ SaveableStateRegistry $saveableStateRegistry;

    DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$registered$1(SaveableStateRegistry saveableStateRegistry) {
        this.$saveableStateRegistry = saveableStateRegistry;
    }

    public final Bundle saveState() {
        return DisposableSaveableStateRegistry_androidKt.toBundle(this.$saveableStateRegistry.performSave());
    }
}
