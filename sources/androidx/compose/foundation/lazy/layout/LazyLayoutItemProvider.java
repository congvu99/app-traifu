package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H'¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "", "itemCount", "", "getItemCount", "()I", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: LazyLayoutItemProvider.kt */
public interface LazyLayoutItemProvider {
    void Item(int i, Composer composer, int i2);

    Object getContentType(int i);

    int getItemCount();

    Object getKey(int i);

    Map<Object, Integer> getKeyToIndexMap();

    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider$-CC  reason: invalid class name */
    /* compiled from: LazyLayoutItemProvider.kt */
    public final /* synthetic */ class CC {
        public static Object $default$getContentType(LazyLayoutItemProvider lazyLayoutItemProvider, int i) {
            return null;
        }

        public static Object $default$getKey(LazyLayoutItemProvider _this, int i) {
            return Lazy_androidKt.getDefaultLazyLayoutKey(i);
        }

        public static Map $default$getKeyToIndexMap(LazyLayoutItemProvider _this) {
            return MapsKt.emptyMap();
        }
    }
}
