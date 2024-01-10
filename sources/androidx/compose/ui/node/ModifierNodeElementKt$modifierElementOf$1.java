package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\r\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/compose/ui/node/ModifierNodeElementKt$modifierElementOf$1", "Landroidx/compose/ui/node/ModifierNodeElement;", "create", "()Landroidx/compose/ui/Modifier$Node;", "update", "node", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* compiled from: ModifierNodeElement.kt */
public final class ModifierNodeElementKt$modifierElementOf$1 extends ModifierNodeElement<T> {
    final /* synthetic */ Function0<T> $create;
    final /* synthetic */ Function1<T, Unit> $update;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifierNodeElementKt$modifierElementOf$1(Object obj, Function0<? extends T> function0, Function1<? super T, Unit> function1) {
        super(obj);
        this.$create = function0;
        this.$update = function1;
    }

    public T create() {
        return (Modifier.Node) this.$create.invoke();
    }

    public T update(T t) {
        Intrinsics.checkNotNullParameter(t, "node");
        this.$update.invoke(t);
        return t;
    }
}
