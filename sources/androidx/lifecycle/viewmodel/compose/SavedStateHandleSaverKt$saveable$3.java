package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.Saver;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\n"}, d2 = {"<anonymous>", "Lkotlin/properties/ReadWriteProperty;", "", "T", "M", "Landroidx/compose/runtime/MutableState;", "<anonymous parameter 0>", "property", "Lkotlin/reflect/KProperty;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
final class SavedStateHandleSaverKt$saveable$3 implements PropertyDelegateProvider<Object, ReadWriteProperty<? super Object, T>> {
    final /* synthetic */ Function0<M> $init;
    final /* synthetic */ Saver<T, ? extends Object> $stateSaver;
    final /* synthetic */ SavedStateHandle $this_saveable;

    SavedStateHandleSaverKt$saveable$3(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, Function0<? extends M> function0) {
        this.$this_saveable = savedStateHandle;
        this.$stateSaver = saver;
        this.$init = function0;
    }

    public final ReadWriteProperty<Object, T> provideDelegate(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return new SavedStateHandleSaverKt$saveable$3$provideDelegate$1(SavedStateHandleSaverKt.saveable(this.$this_saveable, kProperty.getName(), this.$stateSaver, this.$init));
    }
}
