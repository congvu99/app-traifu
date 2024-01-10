package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyScopeAdapter.kt */
final class LazyScopeAdapter$lazyScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ Function0 $getScope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyScopeAdapter$lazyScope$1(Function0 function0) {
        super(0);
        this.$getScope = function0;
    }

    public final MemberScope invoke() {
        MemberScope memberScope = (MemberScope) this.$getScope.invoke();
        return memberScope instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) memberScope).getActualScope() : memberScope;
    }
}
