package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import coil.compose.AsyncImagePainter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcoil/compose/SubcomposeAsyncImageScope;", "invoke", "(Lcoil/compose/SubcomposeAsyncImageScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class SubcomposeAsyncImageKt$contentOf$1 extends Lambda implements Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit> {
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> $error;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> $loading;
    final /* synthetic */ Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> $success;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeAsyncImageKt$contentOf$1(Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Loading, ? super Composer, ? super Integer, Unit> function4, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Success, ? super Composer, ? super Integer, Unit> function42, Function4<? super SubcomposeAsyncImageScope, ? super AsyncImagePainter.State.Error, ? super Composer, ? super Integer, Unit> function43) {
        super(3);
        this.$loading = function4;
        this.$success = function42;
        this.$error = function43;
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
            boolean z = true;
            AsyncImagePainter.State state = subcomposeAsyncImageScope.getPainter().getState();
            if (state instanceof AsyncImagePainter.State.Loading) {
                composer.startReplaceableGroup(-418307549);
                Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Loading, Composer, Integer, Unit> function4 = this.$loading;
                if (function4 != null) {
                    function4.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i & 14) | 64));
                    Unit unit = Unit.INSTANCE;
                    z = false;
                }
                composer.endReplaceableGroup();
            } else if (state instanceof AsyncImagePainter.State.Success) {
                composer.startReplaceableGroup(-418307455);
                Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Success, Composer, Integer, Unit> function42 = this.$success;
                if (function42 != null) {
                    function42.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i & 14) | 64));
                    Unit unit2 = Unit.INSTANCE;
                    z = false;
                }
                composer.endReplaceableGroup();
            } else if (state instanceof AsyncImagePainter.State.Error) {
                composer.startReplaceableGroup(-418307363);
                Function4<SubcomposeAsyncImageScope, AsyncImagePainter.State.Error, Composer, Integer, Unit> function43 = this.$error;
                if (function43 != null) {
                    function43.invoke(subcomposeAsyncImageScope, state, composer, Integer.valueOf((i & 14) | 64));
                    Unit unit3 = Unit.INSTANCE;
                    z = false;
                }
                composer.endReplaceableGroup();
            } else if (state instanceof AsyncImagePainter.State.Empty) {
                composer.startReplaceableGroup(-418307275);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-418307215);
                composer.endReplaceableGroup();
            }
            if (z) {
                SubcomposeAsyncImageKt.SubcomposeAsyncImageContent(subcomposeAsyncImageScope, (Modifier) null, (Painter) null, (String) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, i & 14, 127);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
