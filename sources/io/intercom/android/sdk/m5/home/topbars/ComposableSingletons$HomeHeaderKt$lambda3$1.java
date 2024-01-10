package io.intercom.android.sdk.m5.home.topbars;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import io.intercom.android.sdk.m5.home.viewmodel.HeaderState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.home.topbars.ComposableSingletons$HomeHeaderKt$lambda-3$1  reason: invalid class name */
/* compiled from: HomeHeader.kt */
final class ComposableSingletons$HomeHeaderKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$HomeHeaderKt$lambda3$1 INSTANCE = new ComposableSingletons$HomeHeaderKt$lambda3$1();

    ComposableSingletons$HomeHeaderKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            HomeHeaderKt.m5233HomeHeader942rkJo((Modifier) null, new HeaderState.HeaderContent.Reduced("Hello there.", "#FFFFFF", "#000000"), Dp.m4704constructorimpl((float) 0), AnonymousClass1.INSTANCE, composer, 3456, 1);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
