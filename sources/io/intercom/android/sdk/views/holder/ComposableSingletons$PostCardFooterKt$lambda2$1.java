package io.intercom.android.sdk.views.holder;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import io.intercom.android.sdk.m5.IntercomThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.views.holder.ComposableSingletons$PostCardFooterKt$lambda-2$1  reason: invalid class name */
/* compiled from: PostCardFooter.kt */
final class ComposableSingletons$PostCardFooterKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$PostCardFooterKt$lambda2$1 INSTANCE = new ComposableSingletons$PostCardFooterKt$lambda2$1();

    ComposableSingletons$PostCardFooterKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            IntercomThemeKt.IntercomTheme((Colors) null, (Shapes) null, (Typography) null, ComposableSingletons$PostCardFooterKt.INSTANCE.m5414getLambda1$intercom_sdk_base_release(), composer, 3072, 7);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
