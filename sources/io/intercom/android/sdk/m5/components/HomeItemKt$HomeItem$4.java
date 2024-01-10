package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: HomeItem.kt */
final class HomeItemKt$HomeItem$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Integer $icon;
    final /* synthetic */ Integer $messagesUnread;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $subtitle;
    final /* synthetic */ Integer $text;
    final /* synthetic */ String $textString;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeItemKt$HomeItem$4(Modifier modifier, Integer num, Integer num2, String str, String str2, Integer num3, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$icon = num;
        this.$text = num2;
        this.$textString = str;
        this.$subtitle = str2;
        this.$messagesUnread = num3;
        this.$onClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HomeItemKt.HomeItem(this.$modifier, this.$icon, this.$text, this.$textString, this.$subtitle, this.$messagesUnread, this.$onClick, composer, this.$$changed | 1, this.$$default);
    }
}
