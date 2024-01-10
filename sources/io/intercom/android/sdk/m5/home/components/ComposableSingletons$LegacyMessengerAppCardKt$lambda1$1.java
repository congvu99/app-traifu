package io.intercom.android.sdk.m5.home.components;

import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.intercom.android.sdk.m5.home.components.ComposableSingletons$LegacyMessengerAppCardKt$lambda-1$1  reason: invalid class name */
/* compiled from: LegacyMessengerAppCard.kt */
final class ComposableSingletons$LegacyMessengerAppCardKt$lambda1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$LegacyMessengerAppCardKt$lambda1$1 INSTANCE = new ComposableSingletons$LegacyMessengerAppCardKt$lambda1$1();

    ComposableSingletons$LegacyMessengerAppCardKt$lambda1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if ((i & 11) != 2 || !composer.getSkipping()) {
            ProgressIndicatorKt.m1359CircularProgressIndicatoraMcp0Q((Modifier) null, 0, 0.0f, composer, 0, 7);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
