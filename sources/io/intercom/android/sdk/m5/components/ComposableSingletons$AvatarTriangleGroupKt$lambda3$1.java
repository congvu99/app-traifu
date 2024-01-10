package io.intercom.android.sdk.m5.components;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import io.intercom.android.sdk.models.Avatar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.components.ComposableSingletons$AvatarTriangleGroupKt$lambda-3$1  reason: invalid class name */
/* compiled from: AvatarTriangleGroup.kt */
final class ComposableSingletons$AvatarTriangleGroupKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$AvatarTriangleGroupKt$lambda3$1 INSTANCE = new ComposableSingletons$AvatarTriangleGroupKt$lambda3$1();

    ComposableSingletons$AvatarTriangleGroupKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            AvatarTriangleGroupKt.m5127AvatarTriangleGroupjt2gSs(CollectionsKt.listOf(Avatar.create("", "SK"), Avatar.create("", "RS"), Avatar.create("", "VR")), (Modifier) null, (Shape) null, 0.0f, composer, 8, 14);
            return;
        }
        composer.skipToGroupEnd();
    }
}
