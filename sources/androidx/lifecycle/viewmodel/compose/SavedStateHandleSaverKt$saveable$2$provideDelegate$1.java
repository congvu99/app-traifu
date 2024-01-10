package androidx.lifecycle.viewmodel.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\n"}, d2 = {"<anonymous>", "T", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "Lkotlin/reflect/KProperty;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
final class SavedStateHandleSaverKt$saveable$2$provideDelegate$1 implements ReadOnlyProperty<Object, T> {
    final /* synthetic */ T $value;

    SavedStateHandleSaverKt$saveable$2$provideDelegate$1(T t) {
        this.$value = t;
    }

    public final T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<anonymous parameter 1>");
        return this.$value;
    }
}
