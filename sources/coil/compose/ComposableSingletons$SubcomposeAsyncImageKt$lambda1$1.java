package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcoil/compose/SubcomposeAsyncImageScope;", "invoke", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: coil.compose.ComposableSingletons$SubcomposeAsyncImageKt$lambda-1$1  reason: invalid class name */
/* compiled from: SubcomposeAsyncImage.kt */
final class ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1 extends Lambda implements Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1 INSTANCE = new ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1();

    ComposableSingletons$SubcomposeAsyncImageKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SubcomposeAsyncImageScope subcomposeAsyncImageScope, Composer composer, int i) {
        if ((i & 14) == 0) {
            i |= composer.changed((Object) subcomposeAsyncImageScope) ? 4 : 2;
        }
        if (((i & 91) ^ 18) != 0 || !composer.getSkipping()) {
            SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, (Modifier) null, (Painter) null, (String) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, i & 14, 127);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
