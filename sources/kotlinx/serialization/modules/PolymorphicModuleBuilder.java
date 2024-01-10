package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B'\b\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001J5\u0010\u0013\u001a\u00020\u00102-\u0010\b\u001a)\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b0\tJ,\u0010\u0017\u001a\u00020\u0010\"\b\b\u0001\u0010\u0018*\u00028\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0006R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R0\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u000e0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", "", "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "defaultSerializerProvider", "Lkotlin/Function1;", "", "Lkotlinx/serialization/DeserializationStrategy;", "subclasses", "", "Lkotlin/Pair;", "buildTo", "", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "default", "Lkotlin/ParameterName;", "name", "className", "subclass", "T", "serializer", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PolymorphicModuleBuilder.kt */
public final class PolymorphicModuleBuilder<Base> {
    private final KClass<Base> baseClass;
    private final KSerializer<Base> baseSerializer;
    private Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultSerializerProvider;
    private final List<Pair<KClass<? extends Base>, KSerializer<? extends Base>>> subclasses;

    public PolymorphicModuleBuilder(KClass<Base> kClass, KSerializer<Base> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PolymorphicModuleBuilder(KClass kClass, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? null : kSerializer);
    }

    public final <T extends Base> void subclass(KClass<T> kClass, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "subclass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.subclasses.add(TuplesKt.to(kClass, kSerializer));
    }

    /* renamed from: default  reason: not valid java name */
    public final void m6997default(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        if (this.defaultSerializerProvider == null) {
            this.defaultSerializerProvider = function1;
            return;
        }
        throw new IllegalArgumentException(("Default serializer provider is already registered for class " + this.baseClass + ": " + this.defaultSerializerProvider).toString());
    }

    public final void buildTo(SerializersModuleBuilder serializersModuleBuilder) {
        Intrinsics.checkNotNullParameter(serializersModuleBuilder, "builder");
        KSerializer<Base> kSerializer = this.baseSerializer;
        if (kSerializer != null) {
            KClass<Base> kClass = this.baseClass;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(serializersModuleBuilder, kClass, kClass, kSerializer, false, 8, (Object) null);
        }
        for (Pair pair : this.subclasses) {
            SerializersModuleBuilder serializersModuleBuilder2 = serializersModuleBuilder;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(serializersModuleBuilder2, this.baseClass, (KClass) pair.component1(), (KSerializer) pair.component2(), false, 8, (Object) null);
        }
        Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1 = this.defaultSerializerProvider;
        if (function1 != null) {
            serializersModuleBuilder.registerDefaultPolymorphicSerializer(this.baseClass, function1, false);
        }
    }
}
