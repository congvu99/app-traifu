package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.saveable.Saver;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.TuplesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "T", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
final class SavedStateHandleSaverKt$saveable$1 implements SavedStateRegistry.SavedStateProvider {
    final /* synthetic */ Saver<T, ? extends Object> $saver;
    final /* synthetic */ T $value;

    SavedStateHandleSaverKt$saveable$1(Saver<T, ? extends Object> saver, T t) {
        this.$saver = saver;
        this.$value = t;
    }

    public final Bundle saveState() {
        return BundleKt.bundleOf(TuplesKt.to("value", this.$saver.save(new SavedStateHandleSaverKt$saveable$1$saveState$1$1(SavedStateHandle.Companion), this.$value)));
    }
}
