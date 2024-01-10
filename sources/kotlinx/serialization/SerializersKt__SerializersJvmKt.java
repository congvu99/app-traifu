package kotlinx.serialization;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;
import org.apache.http.message.TokenParser;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a)\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u000b\u001a\u0015\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r*\u00020\u0004H\u0002¢\u0006\u0002\b\u000e\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a+\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u0010\u001a\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a-\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\b\u0013¨\u0006\u0014"}, d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "", "type", "Ljava/lang/reflect/Type;", "serializerOrNull", "genericArraySerializer", "Lkotlinx/serialization/modules/SerializersModule;", "Ljava/lang/reflect/GenericArrayType;", "failOnMissingTypeArgSerializer", "", "genericArraySerializer$SerializersKt__SerializersJvmKt", "kclass", "Lkotlin/reflect/KClass;", "kclass$SerializersKt__SerializersJvmKt", "serializerByJavaTypeImpl", "serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt", "typeSerializer", "Ljava/lang/Class;", "typeSerializer$SerializersKt__SerializersJvmKt", "kotlinx-serialization-core"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* compiled from: SerializersJvm.kt */
final /* synthetic */ class SerializersKt__SerializersJvmKt {
    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleKt.getEmptySerializersModule(), type);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializerOrNull(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleKt.getEmptySerializersModule(), type);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt = serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, true);
        if (serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt != null) {
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt;
        }
        Platform_commonKt.serializerNotRegistered(kclass$SerializersKt__SerializersJvmKt(type));
        throw new KotlinNothingValueException();
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, Type type) {
        Intrinsics.checkNotNullParameter(serializersModule, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, false);
    }

    static /* synthetic */ KSerializer serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(SerializersModule serializersModule, Type type, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(serializersModule, type, z);
    }

    private static final KSerializer<Object> serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Type type, boolean z) {
        Collection collection;
        if (type instanceof GenericArrayType) {
            return genericArraySerializer$SerializersKt__SerializersJvmKt(serializersModule, (GenericArrayType) type, z);
        }
        if (type instanceof Class) {
            return typeSerializer$SerializersKt__SerializersJvmKt(serializersModule, (Class) type, z);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (rawType != null) {
                Class cls = (Class) rawType;
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "args");
                if (z) {
                    collection = new ArrayList(actualTypeArguments.length);
                    for (Type type2 : actualTypeArguments) {
                        Intrinsics.checkNotNullExpressionValue(type2, "it");
                        collection.add(SerializersKt.serializer(serializersModule, type2));
                    }
                } else {
                    collection = new ArrayList(actualTypeArguments.length);
                    for (Type type3 : actualTypeArguments) {
                        Intrinsics.checkNotNullExpressionValue(type3, "it");
                        KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull(serializersModule, type3);
                        if (serializerOrNull == null) {
                            return null;
                        }
                        collection.add(serializerOrNull);
                    }
                }
                List list = (List) collection;
                if (Set.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.SetSerializer((KSerializer) list.get(0));
                }
                if (List.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.ListSerializer((KSerializer) list.get(0));
                }
                if (Map.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.MapSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
                }
                if (Map.Entry.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.MapEntrySerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
                }
                if (Pair.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.PairSerializer((KSerializer) list.get(0), (KSerializer) list.get(1));
                }
                if (Triple.class.isAssignableFrom(cls)) {
                    return BuiltinSerializersKt.TripleSerializer((KSerializer) list.get(0), (KSerializer) list.get(1), (KSerializer) list.get(2));
                }
                Iterable<KSerializer> iterable = list;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (KSerializer add : iterable) {
                    arrayList.add(add);
                }
                List list2 = (List) arrayList;
                KClass kotlinClass = JvmClassMappingKt.getKotlinClass(cls);
                Object[] array = list2.toArray(new KSerializer[0]);
                if (array != null) {
                    KSerializer[] kSerializerArr = (KSerializer[]) array;
                    KSerializer<Object> constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(kotlinClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
                    if (!(constructSerializerForGivenTypeArgs instanceof KSerializer)) {
                        constructSerializerForGivenTypeArgs = null;
                    }
                    return constructSerializerForGivenTypeArgs == null ? SerializersKt.reflectiveOrContextual(serializersModule, JvmClassMappingKt.getKotlinClass(cls), list2) : constructSerializerForGivenTypeArgs;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "type.upperBounds");
            Object first = ArraysKt.first((T[]) (Object[]) upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "type.upperBounds.first()");
            return serializerByJavaTypeImpl$SerializersKt__SerializersJvmKt$default(serializersModule, (Type) first, false, 2, (Object) null);
        } else {
            throw new IllegalArgumentException("typeToken should be an instance of Class<?>, GenericArray, ParametrizedType or WildcardType, but actual type is " + type + TokenParser.SP + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
    }

    private static final KSerializer<Object> typeSerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, Class<?> cls, boolean z) {
        KSerializer<Object> kSerializer;
        if (!cls.isArray()) {
            return SerializersKt.reflectiveOrContextual(serializersModule, JvmClassMappingKt.getKotlinClass(cls), CollectionsKt.emptyList());
        }
        Class<?> componentType = cls.getComponentType();
        Intrinsics.checkNotNullExpressionValue(componentType, "type.componentType");
        if (z) {
            kSerializer = SerializersKt.serializer(serializersModule, (Type) componentType);
        } else {
            kSerializer = SerializersKt.serializerOrNull(serializersModule, (Type) componentType);
            if (kSerializer == null) {
                return null;
            }
        }
        return BuiltinSerializersKt.ArraySerializer(JvmClassMappingKt.getKotlinClass(componentType), kSerializer);
    }

    private static final KSerializer<Object> genericArraySerializer$SerializersKt__SerializersJvmKt(SerializersModule serializersModule, GenericArrayType genericArrayType, boolean z) {
        KSerializer<Object> kSerializer;
        KClass kClass;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) genericComponentType).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "it.upperBounds");
            genericComponentType = (Type) ArraysKt.first((T[]) (Object[]) upperBounds);
        }
        Intrinsics.checkNotNullExpressionValue(genericComponentType, "eType");
        if (z) {
            kSerializer = SerializersKt.serializer(serializersModule, genericComponentType);
        } else {
            kSerializer = SerializersKt.serializerOrNull(serializersModule, genericComponentType);
            if (kSerializer == null) {
                return null;
            }
        }
        if (genericComponentType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) genericComponentType).getRawType();
            if (rawType != null) {
                kClass = JvmClassMappingKt.getKotlinClass((Class) rawType);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
        } else if (genericComponentType instanceof KClass) {
            kClass = (KClass) genericComponentType;
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("unsupported type in GenericArray: ", Reflection.getOrCreateKotlinClass(genericComponentType.getClass())));
        }
        return BuiltinSerializersKt.ArraySerializer(kClass, kSerializer);
    }

    private static final KClass<?> kclass$SerializersKt__SerializersJvmKt(Type type) {
        if (type instanceof KClass) {
            return (KClass) type;
        }
        if (type instanceof Class) {
            return JvmClassMappingKt.getKotlinClass((Class) type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Intrinsics.checkNotNullExpressionValue(rawType, "it.rawType");
            return kclass$SerializersKt__SerializersJvmKt(rawType);
        } else if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds, "it.upperBounds");
            Object first = ArraysKt.first((T[]) (Object[]) upperBounds);
            Intrinsics.checkNotNullExpressionValue(first, "it.upperBounds.first()");
            return kclass$SerializersKt__SerializersJvmKt((Type) first);
        } else if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "it.genericComponentType");
            return kclass$SerializersKt__SerializersJvmKt(genericComponentType);
        } else {
            throw new IllegalArgumentException("typeToken should be an instance of Class<?>, GenericArray, ParametrizedType or WildcardType, but actual type is " + type + TokenParser.SP + Reflection.getOrCreateKotlinClass(type.getClass()));
        }
    }
}
