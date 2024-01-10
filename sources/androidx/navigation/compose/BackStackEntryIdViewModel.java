package androidx.navigation.compose;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/navigation/compose/BackStackEntryIdViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "IdKey", "", "id", "Ljava/util/UUID;", "getId", "()Ljava/util/UUID;", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "getSaveableStateHolder", "()Landroidx/compose/runtime/saveable/SaveableStateHolder;", "setSaveableStateHolder", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "onCleared", "", "navigation-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavBackStackEntryProvider.kt */
public final class BackStackEntryIdViewModel extends ViewModel {
    private final String IdKey = "SaveableStateHolder_BackStackEntryKey";
    private final UUID id;
    private SaveableStateHolder saveableStateHolder;

    public BackStackEntryIdViewModel(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        UUID uuid = (UUID) savedStateHandle.get("SaveableStateHolder_BackStackEntryKey");
        if (uuid == null) {
            uuid = UUID.randomUUID();
            savedStateHandle.set(this.IdKey, uuid);
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().also { handle.set(IdKey, it) }");
        }
        this.id = uuid;
    }

    public final UUID getId() {
        return this.id;
    }

    public final SaveableStateHolder getSaveableStateHolder() {
        return this.saveableStateHolder;
    }

    public final void setSaveableStateHolder(SaveableStateHolder saveableStateHolder2) {
        this.saveableStateHolder = saveableStateHolder2;
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        SaveableStateHolder saveableStateHolder2 = this.saveableStateHolder;
        if (saveableStateHolder2 != null) {
            saveableStateHolder2.removeState(this.id);
        }
    }
}
