package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.Saver;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/properties/ReadOnlyProperty;", "", "T", "<anonymous parameter 0>", "property", "Lkotlin/reflect/KProperty;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
final class SavedStateHandleSaverKt$saveable$2 implements PropertyDelegateProvider<Object, ReadOnlyProperty<? super Object, ? extends T>> {
    final /* synthetic */ Function0<T> $init;
    final /* synthetic */ Saver<T, ? extends Object> $saver;
    final /* synthetic */ SavedStateHandle $this_saveable;

    SavedStateHandleSaverKt$saveable$2(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, Function0<? extends T> function0) {
        this.$this_saveable = savedStateHandle;
        this.$saver = saver;
        this.$init = function0;
    }

    public final ReadOnlyProperty<Object, T> provideDelegate(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return new SavedStateHandleSaverKt$saveable$2$provideDelegate$1(SavedStateHandleSaverKt.saveable(this.$this_saveable, kProperty.getName(), this.$saver, this.$init));
    }
}
