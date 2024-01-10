package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarGroup.kt */
final class AvatarGroupKt$AvatarGroup$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ float $avatarSize;
    final /* synthetic */ List<Avatar> $avatars;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $placeHolderTextSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarGroupKt$AvatarGroup$2(List<? extends Avatar> list, Modifier modifier, float f, long j, int i, int i2) {
        super(2);
        this.$avatars = list;
        this.$modifier = modifier;
        this.$avatarSize = f;
        this.$placeHolderTextSize = j;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AvatarGroupKt.m5121AvatarGroupJ8mCjc(this.$avatars, this.$modifier, this.$avatarSize, this.$placeHolderTextSize, composer, this.$$changed | 1, this.$$default);
    }
}
