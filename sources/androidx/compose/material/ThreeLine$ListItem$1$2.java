package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ThreeLine$ListItem$1$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $overlineText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $secondaryText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ThreeLine$ListItem$1$2(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$overlineText = function2;
        this.$$dirty = i;
        this.$text = function22;
        this.$secondaryText = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C326@12261L6,327@12284L15:ListItem.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            composer.startReplaceableGroup(-755940677);
            ComposerKt.sourceInformation(composer, "325@12230L14");
            Function2<Composer, Integer, Unit> function2 = this.$overlineText;
            if (function2 != null) {
                function2.invoke(composer, Integer.valueOf((this.$$dirty >> 12) & 14));
            }
            composer.endReplaceableGroup();
            this.$text.invoke(composer, Integer.valueOf((this.$$dirty >> 6) & 14));
            this.$secondaryText.invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
            return;
        }
        composer.skipToGroupEnd();
    }
}
