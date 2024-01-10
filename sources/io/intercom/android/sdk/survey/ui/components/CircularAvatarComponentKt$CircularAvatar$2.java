package io.intercom.android.sdk.survey.ui.components;

import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CircularAvatarComponent.kt */
final class CircularAvatarComponentKt$CircularAvatar$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ float $size;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CircularAvatarComponentKt$CircularAvatar$2(Avatar avatar, long j, float f, int i, int i2) {
        super(2);
        this.$avatar = avatar;
        this.$backgroundColor = j;
        this.$size = f;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CircularAvatarComponentKt.m5309CircularAvataraMcp0Q(this.$avatar, this.$backgroundColor, this.$size, composer, this.$$changed | 1, this.$$default);
    }
}
