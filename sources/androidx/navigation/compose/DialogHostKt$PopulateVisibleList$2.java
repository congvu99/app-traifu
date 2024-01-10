package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.navigation.NavBackStackEntry;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$PopulateVisibleList$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ List<NavBackStackEntry> $this_PopulateVisibleList;
    final /* synthetic */ Collection<NavBackStackEntry> $transitionsInProgress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$PopulateVisibleList$2(List<NavBackStackEntry> list, Collection<NavBackStackEntry> collection, int i) {
        super(2);
        this.$this_PopulateVisibleList = list;
        this.$transitionsInProgress = collection;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DialogHostKt.PopulateVisibleList(this.$this_PopulateVisibleList, this.$transitionsInProgress, composer, this.$$changed | 1);
    }
}
