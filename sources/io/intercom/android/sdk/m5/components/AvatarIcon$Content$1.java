package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
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
final class AvatarIcon$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ AvatarIcon this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarIcon$Content$1(AvatarIcon avatarIcon) {
        super(2);
        this.this$0 = avatarIcon;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            Avatar avatar = this.this$0.getAvatar();
            Modifier r1 = SizeKt.m582size3ABfNKs(Modifier.Companion, this.this$0.m5122getSizeD9Ej5fM());
            Shape shape = this.this$0.getShape();
            if (shape == null) {
                shape = MaterialTheme.INSTANCE.getShapes(composer, 8).getSmall();
            }
            AvatarIconKt.m5124AvatarIconRd90Nhg(avatar, r1, shape, this.this$0.isActive(), 0, (Color) null, composer, 8, 48);
            return;
        }
        composer.skipToGroupEnd();
    }
}
