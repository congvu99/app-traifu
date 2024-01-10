package io.intercom.android.sdk.m5.helpcenter.components;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.IconButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HelpCenterTopBar.kt */
final class HelpCenterTopBarKt$HelpCenterTopBar$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function0<Unit> $onSearchClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HelpCenterTopBarKt$HelpCenterTopBar$1(Function0<Unit> function0, int i) {
        super(3);
        this.$onSearchClick = function0;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TopActionBar");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            IconButtonKt.IconButton(this.$onSearchClick, (Modifier) null, false, (MutableInteractionSource) null, ComposableSingletons$HelpCenterTopBarKt.INSTANCE.m5205getLambda1$intercom_sdk_base_release(), composer, ((this.$$dirty >> 3) & 14) | 24576, 14);
            return;
        }
        composer.skipToGroupEnd();
    }
}
