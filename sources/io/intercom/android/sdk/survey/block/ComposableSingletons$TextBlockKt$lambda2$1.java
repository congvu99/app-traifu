package io.intercom.android.sdk.survey.block;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.survey.block.ComposableSingletons$TextBlockKt$lambda-2$1  reason: invalid class name */
/* compiled from: TextBlock.kt */
final class ComposableSingletons$TextBlockKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TextBlockKt$lambda2$1 INSTANCE = new ComposableSingletons$TextBlockKt$lambda2$1();

    ComposableSingletons$TextBlockKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            SurfaceKt.m1419SurfaceFjzlyU((Modifier) null, (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableSingletons$TextBlockKt.INSTANCE.m5300getLambda1$intercom_sdk_base_release(), composer, 1572864, 63);
        } else {
            composer.skipToGroupEnd();
        }
    }
}