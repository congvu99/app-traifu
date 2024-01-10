package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
final class MaterialThemeKt$MaterialTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Typography $typography;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialThemeKt$MaterialTheme$1(Typography typography, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$typography = typography;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3849L97:MaterialTheme.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TextStyle body1 = this.$typography.getBody1();
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            final int i2 = this.$$dirty;
            TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda(composer, 181426554, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C81@3906L30:MaterialTheme.kt#jmzs0o");
                    if ((i & 11) != 2 || !composer.getSkipping()) {
                        MaterialTheme_androidKt.PlatformMaterialTheme(function2, composer, (i2 >> 9) & 14);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, 48);
            return;
        }
        composer.skipToGroupEnd();
    }
}
