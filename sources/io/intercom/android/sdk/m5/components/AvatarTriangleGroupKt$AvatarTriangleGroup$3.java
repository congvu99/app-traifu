package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AvatarTriangleGroup.kt */
final class AvatarTriangleGroupKt$AvatarTriangleGroup$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Shape $avatarShape;
    final /* synthetic */ List<Avatar> $avatars;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $size;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarTriangleGroupKt$AvatarTriangleGroup$3(List<? extends Avatar> list, Modifier modifier, Shape shape, float f, int i, int i2) {
        super(2);
        this.$avatars = list;
        this.$modifier = modifier;
        this.$avatarShape = shape;
        this.$size = f;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        AvatarTriangleGroupKt.m5127AvatarTriangleGroupjt2gSs(this.$avatars, this.$modifier, this.$avatarShape, this.$size, composer, this.$$changed | 1, this.$$default);
    }
}
