package androidx.navigation.compose;

import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DialogHost.kt */
final class DialogHostKt$DialogHost$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ DialogNavigator $dialogNavigator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DialogHostKt$DialogHost$1$1(DialogNavigator dialogNavigator, NavBackStackEntry navBackStackEntry) {
        super(0);
        this.$dialogNavigator = dialogNavigator;
        this.$backStackEntry = navBackStackEntry;
    }

    public final void invoke() {
        this.$dialogNavigator.dismiss$navigation_compose_release(this.$backStackEntry);
    }
}
