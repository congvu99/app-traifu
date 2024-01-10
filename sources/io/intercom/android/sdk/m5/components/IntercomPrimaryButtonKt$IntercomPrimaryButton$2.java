package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntercomPrimaryButton.kt */
final class IntercomPrimaryButtonKt$IntercomPrimaryButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $text;
    final /* synthetic */ Integer $trailingIconId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntercomPrimaryButtonKt$IntercomPrimaryButton$2(String str, Modifier modifier, Integer num, Function0<Unit> function0, int i, int i2) {
        super(2);
        this.$text = str;
        this.$modifier = modifier;
        this.$trailingIconId = num;
        this.$onClick = function0;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        IntercomPrimaryButtonKt.IntercomPrimaryButton(this.$text, this.$modifier, this.$trailingIconId, this.$onClick, composer, this.$$changed | 1, this.$$default);
    }
}
