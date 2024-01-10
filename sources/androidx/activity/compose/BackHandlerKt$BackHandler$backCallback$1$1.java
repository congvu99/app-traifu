package androidx.activity.compose;

import androidx.activity.OnBackPressedCallback;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackHandler.kt */
public final class BackHandlerKt$BackHandler$backCallback$1$1 extends OnBackPressedCallback {
    final /* synthetic */ State<Function0<Unit>> $currentOnBack$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackHandlerKt$BackHandler$backCallback$1$1(boolean z, State<? extends Function0<Unit>> state) {
        super(z);
        this.$currentOnBack$delegate = state;
    }

    public void handleOnBackPressed() {
        BackHandlerKt.m4BackHandler$lambda0(this.$currentOnBack$delegate).invoke();
    }
}
