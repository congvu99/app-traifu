package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarIcon.kt */
final class AvatarIconKt$AvatarPlaceholder$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $textColor;
    final /* synthetic */ long $textSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarIconKt$AvatarPlaceholder$2(Modifier modifier, Avatar avatar, long j, long j2, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$avatar = avatar;
        this.$textColor = j;
        this.$textSize = j2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AvatarIconKt.m5125AvatarPlaceholdermhOCef0(this.$modifier, this.$avatar, this.$textColor, this.$textSize, composer, this.$$changed | 1, this.$$default);
    }
}
