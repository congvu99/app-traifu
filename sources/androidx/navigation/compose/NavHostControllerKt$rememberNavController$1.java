package androidx.navigation.compose;

import android.content.Context;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavHostController.kt */
final class NavHostControllerKt$rememberNavController$1 extends Lambda implements Function0<NavHostController> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavHostControllerKt$rememberNavController$1(Context context) {
        super(0);
        this.$context = context;
    }

    public final NavHostController invoke() {
        return NavHostControllerKt.createNavController(this.$context);
    }
}
