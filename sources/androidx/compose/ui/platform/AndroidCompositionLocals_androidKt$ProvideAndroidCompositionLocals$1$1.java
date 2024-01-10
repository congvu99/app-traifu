package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidCompositionLocals.android.kt */
final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 extends Lambda implements Function1<Configuration, Unit> {
    final /* synthetic */ MutableState<Configuration> $configuration$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(MutableState<Configuration> mutableState) {
        super(1);
        this.$configuration$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Configuration) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "it");
        AndroidCompositionLocals_androidKt.m3995ProvideAndroidCompositionLocals$lambda2(this.$configuration$delegate, configuration);
    }
}
