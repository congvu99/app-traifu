package androidx.compose.runtime.saveable;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SaveableStateHolder.kt */
final class SaveableStateHolderImpl$SaveableStateProvider$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Object $key;
    final /* synthetic */ SaveableStateHolderImpl.RegistryHolder $registryHolder;
    final /* synthetic */ SaveableStateHolderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveableStateHolderImpl$SaveableStateProvider$1$1(SaveableStateHolderImpl saveableStateHolderImpl, Object obj, SaveableStateHolderImpl.RegistryHolder registryHolder) {
        super(1);
        this.this$0 = saveableStateHolderImpl;
        this.$key = obj;
        this.$registryHolder = registryHolder;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        boolean z = !this.this$0.registryHolders.containsKey(this.$key);
        Object obj = this.$key;
        if (z) {
            this.this$0.savedStates.remove(this.$key);
            this.this$0.registryHolders.put(this.$key, this.$registryHolder);
            return new SaveableStateHolderImpl$SaveableStateProvider$1$1$invoke$$inlined$onDispose$1(this.$registryHolder, this.this$0, this.$key);
        }
        throw new IllegalArgumentException(("Key " + obj + " was used multiple times ").toString());
    }
}
