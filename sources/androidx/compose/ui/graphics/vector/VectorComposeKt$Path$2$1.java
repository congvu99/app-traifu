package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$1 extends Lambda implements Function2<PathComponent, String, Unit> {
    public static final VectorComposeKt$Path$2$1 INSTANCE = new VectorComposeKt$Path$2$1();

    VectorComposeKt$Path$2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PathComponent) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(PathComponent pathComponent, String str) {
        Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
        Intrinsics.checkNotNullParameter(str, "it");
        pathComponent.setName(str);
    }
}
