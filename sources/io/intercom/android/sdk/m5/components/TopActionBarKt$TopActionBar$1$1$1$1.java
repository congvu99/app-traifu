package io.intercom.android.sdk.m5.components;

import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.StringResources_androidKt;
import io.intercom.android.sdk.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopActionBar.kt */
final class TopActionBarKt$TopActionBar$1$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Painter $navIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopActionBarKt$TopActionBar$1$1$1$1(Painter painter, long j, int i) {
        super(2);
        this.$navIcon = painter;
        this.$contentColor = j;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            IconKt.m1313Iconww6aTOc(this.$navIcon, StringResources_androidKt.stringResource(R.string.intercom_navigation_back, composer, 0), (Modifier) null, this.$contentColor, composer, ((this.$$dirty >> 15) & 7168) | 8, 4);
            return;
        }
        composer.skipToGroupEnd();
    }
}
