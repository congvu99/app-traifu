package androidx.compose.material;

import androidx.compose.runtime.RecomposeScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
final class SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$FadeInFadeOutWithScale$1$1$opacity$1(SnackbarData snackbarData, FadeInFadeOutState<SnackbarData> fadeInFadeOutState) {
        super(0);
        this.$key = snackbarData;
        this.$state = fadeInFadeOutState;
    }

    public final void invoke() {
        if (!Intrinsics.areEqual((Object) this.$key, this.$state.getCurrent())) {
            List<FadeInFadeOutAnimationItem<SnackbarData>> items = this.$state.getItems();
            final SnackbarData snackbarData = this.$key;
            CollectionsKt.removeAll(items, new Function1<FadeInFadeOutAnimationItem<SnackbarData>, Boolean>() {
                public final Boolean invoke(FadeInFadeOutAnimationItem<SnackbarData> fadeInFadeOutAnimationItem) {
                    Intrinsics.checkNotNullParameter(fadeInFadeOutAnimationItem, "it");
                    return Boolean.valueOf(Intrinsics.areEqual((Object) fadeInFadeOutAnimationItem.getKey(), (Object) snackbarData));
                }
            });
            RecomposeScope scope = this.$state.getScope();
            if (scope != null) {
                scope.invalidate();
            }
        }
    }
}
