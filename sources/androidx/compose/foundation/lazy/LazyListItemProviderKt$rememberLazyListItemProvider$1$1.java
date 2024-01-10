package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
public final class LazyListItemProviderKt$rememberLazyListItemProvider$1$1 implements LazyListItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
    final /* synthetic */ State<LazyListItemProviderImpl> $itemProviderState;

    public void Item(int i, Composer composer, int i2) {
        composer.startReplaceableGroup(1610124706);
        ComposerKt.sourceInformation(composer, "C(Item)-1@-2:LazyListItemProvider.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1610124706, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProvider.<anonymous>.<no name provided>.Item (LazyListItemProvider.kt:-1)");
        }
        this.$$delegate_0.Item(i, composer, i2 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public Object getContentType(int i) {
        return this.$$delegate_0.getContentType(i);
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    public Object getKey(int i) {
        return this.$$delegate_0.getKey(i);
    }

    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }

    LazyListItemProviderKt$rememberLazyListItemProvider$1$1(State<LazyListItemProviderImpl> state) {
        this.$itemProviderState = state;
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider(state);
    }

    public List<Integer> getHeaderIndexes() {
        return this.$itemProviderState.getValue().getHeaderIndexes();
    }

    public LazyItemScopeImpl getItemScope() {
        return this.$itemProviderState.getValue().getItemScope();
    }
}
