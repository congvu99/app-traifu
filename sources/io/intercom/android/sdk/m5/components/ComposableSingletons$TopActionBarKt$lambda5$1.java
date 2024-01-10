package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.core.view.PointerIconCompat;
import io.intercom.android.sdk.models.Avatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.components.ComposableSingletons$TopActionBarKt$lambda-5$1  reason: invalid class name */
/* compiled from: TopActionBar.kt */
final class ComposableSingletons$TopActionBarKt$lambda5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$TopActionBarKt$lambda5$1 INSTANCE = new ComposableSingletons$TopActionBarKt$lambda5$1();

    ComposableSingletons$TopActionBarKt$lambda5$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            TopActionBarKt.m5180TopActionBar6oU6zVQ((Modifier) null, "Hannah", (String) null, (List<? extends Avatar>) null, (Function0<Unit>) null, (Painter) null, false, 0, 0, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) null, composer, 48, PointerIconCompat.TYPE_GRABBING);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
