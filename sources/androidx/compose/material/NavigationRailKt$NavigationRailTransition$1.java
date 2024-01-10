package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRailTransition$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ State<Float> $animationProgress$delegate;
    final /* synthetic */ Function3<Float, Composer, Integer, Unit> $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRailTransition$1(Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, int i, State<Float> state) {
        super(2);
        this.$content = function3;
        this.$$dirty = i;
        this.$animationProgress$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C243@10259L26:NavigationRail.kt#jmzs0o");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            this.$content.invoke(Float.valueOf(NavigationRailKt.m1343NavigationRailTransition_Klgx_Pg$lambda3(this.$animationProgress$delegate)), composer, Integer.valueOf((this.$$dirty >> 6) & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
