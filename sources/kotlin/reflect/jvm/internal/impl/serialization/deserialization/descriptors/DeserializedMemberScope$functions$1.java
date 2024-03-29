package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$functions$1 extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$functions$1(DeserializedMemberScope deserializedMemberScope) {
        super(1);
        this.this$0 = deserializedMemberScope;
    }

    public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
        Intrinsics.checkNotNullParameter(name, "it");
        return this.this$0.computeFunctions(name);
    }
}
