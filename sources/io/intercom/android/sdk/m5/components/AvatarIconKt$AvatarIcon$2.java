package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarIcon.kt */
final class AvatarIconKt$AvatarIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Avatar $avatar;
    final /* synthetic */ Color $customBackgroundColor;
    final /* synthetic */ boolean $isActive;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $placeHolderTextSize;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarIconKt$AvatarIcon$2(Avatar avatar, Modifier modifier, Shape shape, boolean z, long j, Color color, int i, int i2) {
        super(2);
        this.$avatar = avatar;
        this.$modifier = modifier;
        this.$shape = shape;
        this.$isActive = z;
        this.$placeHolderTextSize = j;
        this.$customBackgroundColor = color;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AvatarIconKt.m5124AvatarIconRd90Nhg(this.$avatar, this.$modifier, this.$shape, this.$isActive, this.$placeHolderTextSize, this.$customBackgroundColor, composer, this.$$changed | 1, this.$$default);
    }
}
