package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TopActionBar.kt */
final class TopActionBarKt$TopActionBar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ List<Avatar> $avatars;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ boolean $isActive;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $menuItems;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Painter $navIcon;
    final /* synthetic */ Function0<Unit> $onBackClick;
    final /* synthetic */ String $subtitle;
    final /* synthetic */ String $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopActionBarKt$TopActionBar$2(Modifier modifier, String str, String str2, List<? extends Avatar> list, Function0<Unit> function0, Painter painter, boolean z, long j, long j2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$title = str;
        this.$subtitle = str2;
        this.$avatars = list;
        this.$onBackClick = function0;
        this.$navIcon = painter;
        this.$isActive = z;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$menuItems = function3;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TopActionBarKt.m5180TopActionBar6oU6zVQ(this.$modifier, this.$title, this.$subtitle, this.$avatars, this.$onBackClick, this.$navIcon, this.$isActive, this.$backgroundColor, this.$contentColor, this.$menuItems, composer, this.$$changed | 1, this.$$default);
    }
}
