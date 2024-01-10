package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a8\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"LocalSaveableStateRegistry", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getLocalSaveableStateRegistry", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SaveableStateRegistry", "restoredValues", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "runtime-saveable_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SaveableStateRegistry.kt */
public final class SaveableStateRegistryKt {
    private static final ProvidableCompositionLocal<SaveableStateRegistry> LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf(SaveableStateRegistryKt$LocalSaveableStateRegistry$1.INSTANCE);

    public static final SaveableStateRegistry SaveableStateRegistry(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "canBeSaved");
        return new SaveableStateRegistryImpl(map, function1);
    }

    public static final ProvidableCompositionLocal<SaveableStateRegistry> getLocalSaveableStateRegistry() {
        return LocalSaveableStateRegistry;
    }
}
