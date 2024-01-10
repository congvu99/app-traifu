package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> $content;
    final /* synthetic */ SnackbarData $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$2$1$1(Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, SnackbarData snackbarData, int i) {
        super(2);
        this.$content = function3;
        this.$item = snackbarData;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C320@11640L15:SnackbarHost.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Function3<SnackbarData, Composer, Integer, Unit> function3 = this.$content;
            SnackbarData snackbarData = this.$item;
            Intrinsics.checkNotNull(snackbarData);
            function3.invoke(snackbarData, composer, Integer.valueOf((this.$$dirty >> 3) & 112));
            return;
        }
        composer.skipToGroupEnd();
    }
}
