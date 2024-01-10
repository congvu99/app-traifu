package kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.modules.ContextualProvider;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B´\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012&\u0010\b\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\n\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000bj\u0006\u0012\u0002\b\u0003`\u00100\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J:\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0007\"\b\b\u0000\u0010\u0017*\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u001bH\u0016J7\u0010\u001c\u001a\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u001d\"\b\b\u0000\u0010\u0017*\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00170\u00042\u0006\u0010\u001f\u001a\u0002H\u0017H\u0016¢\u0006\u0002\u0010 J6\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0017\u0018\u00010\u000f\"\b\b\u0000\u0010\u0017*\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00170\u00042\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000RI\u0010\n\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000bj\u0006\u0012\u0002\b\u0003`\u00100\u0003X\u0004¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2NamedSerializers", "", "polyBase2DefaultProvider", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicProvider;", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "getContextual", "T", "", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerializersModule.kt */
public final class SerialModuleImpl extends SerializersModule {
    private final Map<KClass<?>, ContextualProvider> class2ContextualFactory;
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultProvider;
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> map, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> map2, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> map3, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> map4) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(map, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(map2, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(map3, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(map4, "polyBase2DefaultProvider");
        this.class2ContextualFactory = map;
        this.polyBase2Serializers = map2;
        this.polyBase2NamedSerializers = map3;
        this.polyBase2DefaultProvider = map4;
    }

    public <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> kClass, T t) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(t, "value");
        if (!PlatformKt.isInstanceOf(t, kClass)) {
            return null;
        }
        Map map = this.polyBase2Serializers.get(kClass);
        KSerializer kSerializer = map == null ? null : (KSerializer) map.get(Reflection.getOrCreateKotlinClass(t.getClass()));
        if (kSerializer instanceof SerializationStrategy) {
            return kSerializer;
        }
        return null;
    }

    public <T> DeserializationStrategy<? extends T> getPolymorphic(KClass<? super T> kClass, String str) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Map map = this.polyBase2NamedSerializers.get(kClass);
        KSerializer kSerializer = map == null ? null : (KSerializer) map.get(str);
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function1 = this.polyBase2DefaultProvider.get(kClass);
        Function1 function12 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function12 == null) {
            return null;
        }
        return (DeserializationStrategy) function12.invoke(str);
    }

    public <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        KSerializer<?> invoke = contextualProvider == null ? null : contextualProvider.invoke(list);
        if (invoke instanceof KSerializer) {
            return invoke;
        }
        return null;
    }

    public void dumpTo(SerializersModuleCollector serializersModuleCollector) {
        Intrinsics.checkNotNullParameter(serializersModuleCollector, "collector");
        for (Map.Entry next : this.class2ContextualFactory.entrySet()) {
            KClass kClass = (KClass) next.getKey();
            ContextualProvider contextualProvider = (ContextualProvider) next.getValue();
            if (contextualProvider instanceof ContextualProvider.Argless) {
                serializersModuleCollector.contextual(kClass, ((ContextualProvider.Argless) contextualProvider).getSerializer());
            } else if (contextualProvider instanceof ContextualProvider.WithTypeArguments) {
                serializersModuleCollector.contextual(kClass, (Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>>) ((ContextualProvider.WithTypeArguments) contextualProvider).getProvider());
            }
        }
        for (Map.Entry next2 : this.polyBase2Serializers.entrySet()) {
            KClass kClass2 = (KClass) next2.getKey();
            for (Map.Entry entry : ((Map) next2.getValue()).entrySet()) {
                serializersModuleCollector.polymorphic(kClass2, (KClass) entry.getKey(), (KSerializer) entry.getValue());
            }
        }
        for (Map.Entry next3 : this.polyBase2DefaultProvider.entrySet()) {
            serializersModuleCollector.polymorphicDefault((KClass) next3.getKey(), (Function1) next3.getValue());
        }
    }
}
