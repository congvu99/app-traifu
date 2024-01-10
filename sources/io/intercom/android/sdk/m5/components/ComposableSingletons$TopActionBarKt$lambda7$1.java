package io.intercom.android.sdk.m5.components;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.IconButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.components.ComposableSingletons$TopActionBarKt$lambda-7$1  reason: invalid class name */
/* compiled from: TopActionBar.kt */
final class ComposableSingletons$TopActionBarKt$lambda7$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$TopActionBarKt$lambda7$1 INSTANCE = new ComposableSingletons$TopActionBarKt$lambda7$1();

    ComposableSingletons$TopActionBarKt$lambda7$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TopActionBar");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            IconButtonKt.IconButton(AnonymousClass1.INSTANCE, (Modifier) null, false, (MutableInteractionSource) null, ComposableSingletons$TopActionBarKt.INSTANCE.m5176getLambda6$intercom_sdk_base_release(), composer, 24582, 14);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
