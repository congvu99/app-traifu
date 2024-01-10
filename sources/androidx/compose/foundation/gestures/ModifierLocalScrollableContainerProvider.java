package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0002XD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/ModifierLocalScrollableContainerProvider;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "", "()V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Boolean;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scrollable.kt */
final class ModifierLocalScrollableContainerProvider implements ModifierLocalProvider<Boolean> {
    public static final ModifierLocalScrollableContainerProvider INSTANCE = new ModifierLocalScrollableContainerProvider();
    private static final ProvidableModifierLocal<Boolean> key = ScrollableKt.getModifierLocalScrollableContainer();
    private static final boolean value = true;

    public /* synthetic */ boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    public /* synthetic */ boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    public /* synthetic */ <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldIn(this, r, function2);
    }

    public /* synthetic */ <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return Modifier.Element.CC.$default$foldOut(this, r, function2);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    private ModifierLocalScrollableContainerProvider() {
    }

    public ProvidableModifierLocal<Boolean> getKey() {
        return key;
    }

    public Boolean getValue() {
        return Boolean.valueOf(value);
    }
}
