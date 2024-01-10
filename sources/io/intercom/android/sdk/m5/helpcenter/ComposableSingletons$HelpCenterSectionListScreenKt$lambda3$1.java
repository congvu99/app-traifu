package io.intercom.android.sdk.m5.helpcenter;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.helpcenter.components.BrowseAllHelpTopicsComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/lazy/LazyItemScope;", "invoke", "(Landroidx/compose/foundation/lazy/LazyItemScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.helpcenter.ComposableSingletons$HelpCenterSectionListScreenKt$lambda-3$1  reason: invalid class name */
/* compiled from: HelpCenterSectionListScreen.kt */
final class ComposableSingletons$HelpCenterSectionListScreenKt$lambda3$1 extends Lambda implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$HelpCenterSectionListScreenKt$lambda3$1 INSTANCE = new ComposableSingletons$HelpCenterSectionListScreenKt$lambda3$1();

    ComposableSingletons$HelpCenterSectionListScreenKt$lambda3$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((LazyItemScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope lazyItemScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyItemScope, "$this$item");
        if ((i & 81) != 16 || !composer.getSkipping()) {
            BrowseAllHelpTopicsComponentKt.BrowseAllHelpTopicsComponent(PaddingKt.m514paddingqDBjuR0$default(Modifier.Companion, 0.0f, Dp.m4704constructorimpl((float) 24), 0.0f, 0.0f, 13, (Object) null), composer, 6, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
