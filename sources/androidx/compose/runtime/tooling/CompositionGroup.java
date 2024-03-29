package androidx.compose.runtime.tooling;

import androidx.compose.runtime.tooling.CompositionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/tooling/CompositionData;", "data", "", "", "getData", "()Ljava/lang/Iterable;", "identity", "getIdentity", "()Ljava/lang/Object;", "key", "getKey", "node", "getNode", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CompositionData.kt */
public interface CompositionGroup extends CompositionData {

    /* renamed from: androidx.compose.runtime.tooling.CompositionGroup$-CC  reason: invalid class name */
    /* compiled from: CompositionData.kt */
    public final /* synthetic */ class CC {
        public static Object $default$getIdentity(CompositionGroup compositionGroup) {
            return null;
        }
    }

    Iterable<Object> getData();

    Object getIdentity();

    Object getKey();

    Object getNode();

    String getSourceInfo();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CompositionData.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static CompositionGroup find(CompositionGroup compositionGroup, Object obj) {
            Intrinsics.checkNotNullParameter(obj, "identityToFind");
            return CompositionData.CC.$default$find(compositionGroup, obj);
        }

        @Deprecated
        public static Object getIdentity(CompositionGroup compositionGroup) {
            return CC.$default$getIdentity(compositionGroup);
        }
    }
}
