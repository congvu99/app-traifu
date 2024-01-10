package androidx.compose.ui.node;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\bø\u0001\u0000\u001aH\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\tH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"modifierElementOf", "Landroidx/compose/ui/Modifier;", "T", "Landroidx/compose/ui/Modifier$Node;", "create", "Lkotlin/Function0;", "params", "", "update", "Lkotlin/Function1;", "", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModifierNodeElement.kt */
public final class ModifierNodeElementKt {
    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(Object obj, Function0<? extends T> function0, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.needClassReification();
        return new ModifierNodeElementKt$modifierElementOf$1(obj, function0, function1);
    }

    @ExperimentalComposeUiApi
    public static final /* synthetic */ <T extends Modifier.Node> Modifier modifierElementOf(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "create");
        Intrinsics.needClassReification();
        return new ModifierNodeElementKt$modifierElementOf$2(function0);
    }
}
