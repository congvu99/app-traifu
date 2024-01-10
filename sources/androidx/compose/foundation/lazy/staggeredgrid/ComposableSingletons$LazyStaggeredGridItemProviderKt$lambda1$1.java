package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u000b¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "interval", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "index", "", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;ILandroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: androidx.compose.foundation.lazy.staggeredgrid.ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda-1$1  reason: invalid class name */
/* compiled from: LazyStaggeredGridItemProvider.kt */
final class ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda1$1 extends Lambda implements Function4<LazyStaggeredGridIntervalContent, Integer, Composer, Integer, Unit> {
    public static final ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda1$1 INSTANCE = new ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda1$1();

    ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda1$1() {
        super(4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke((LazyStaggeredGridIntervalContent) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyStaggeredGridIntervalContent lazyStaggeredGridIntervalContent, int i, Composer composer, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridIntervalContent, "interval");
        ComposerKt.sourceInformation(composer, "CP(1)46@1950L45:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if ((i2 & 14) == 0) {
            i3 = (composer.changed((Object) lazyStaggeredGridIntervalContent) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composer.changed(i) ? 32 : 16;
        }
        if ((i3 & 731) != 146 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-932966533, i3, -1, "androidx.compose.foundation.lazy.staggeredgrid.ComposableSingletons$LazyStaggeredGridItemProviderKt.lambda-1.<anonymous> (LazyStaggeredGridItemProvider.kt:45)");
            }
            lazyStaggeredGridIntervalContent.getItem().invoke(LazyStaggeredGridItemScopeImpl.INSTANCE, Integer.valueOf(i), composer, Integer.valueOf((i3 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
