package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
final class TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1 extends Lambda implements Function1<LayoutNode, Unit> {
    final /* synthetic */ Function1<TestModifierUpdater, Unit> $onAttached;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(Function1<? super TestModifierUpdater, Unit> function1) {
        super(1);
        this.$onAttached = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "$this$init");
        this.$onAttached.invoke(new TestModifierUpdater(layoutNode));
    }
}
