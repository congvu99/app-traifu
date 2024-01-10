package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001aO\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\t\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0000\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\rH\u0000\u001aM\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\r2\"\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0011\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\u000b*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\rH\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u000b*\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\rH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\rH\u0000\u001a$\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\rH\u0002\u001aK\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\b\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010 *\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H 0!j\b\u0012\u0004\u0012\u0002H `\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH\u0000¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"findObjectSerializer", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "invokeSerializerOnCompanion", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isInstanceOf", "kclass", "isNotAnnotated", "platformSpecificSerializerNotRegistered", "", "polymorphicSerializer", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Platform.kt */
public final class PlatformKt {
    public static final <T> T getChecked(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[i];
    }

    public static final boolean getChecked(boolean[] zArr, int i) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[i];
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return constructSerializerForGivenTypeArgs(kClass, new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> arrayList, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass(kClass), arrayList.size());
        if (newInstance != null) {
            E[] array = arrayList.toArray((Object[]) newInstance);
            Intrinsics.checkNotNullExpressionValue(array, "toArray(java.lang.reflect.Array.newInstance(eClass.java, size) as Array<E>)");
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r3 == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r4 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[Catch:{ NoSuchFieldException -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.KSerializer<T> constructSerializerForGivenTypeArgs(kotlin.reflect.KClass<T> r8, kotlinx.serialization.KSerializer<java.lang.Object>... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Class r0 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r8)
            boolean r1 = r0.isEnum()
            if (r1 == 0) goto L_0x001f
            boolean r1 = isNotAnnotated(r0)
            if (r1 == 0) goto L_0x001f
            kotlinx.serialization.KSerializer r8 = createEnumSerializer(r0)
            return r8
        L_0x001f:
            boolean r1 = r0.isInterface()
            if (r1 == 0) goto L_0x002a
            kotlinx.serialization.KSerializer r8 = interfaceSerializer(r8)
            return r8
        L_0x002a:
            int r1 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r1)
            kotlinx.serialization.KSerializer[] r9 = (kotlinx.serialization.KSerializer[]) r9
            kotlinx.serialization.KSerializer r9 = invokeSerializerOnCompanion(r0, r9)
            if (r9 == 0) goto L_0x0038
            return r9
        L_0x0038:
            kotlinx.serialization.KSerializer r9 = findObjectSerializer(r0)
            if (r9 != 0) goto L_0x0091
            r9 = 0
            java.lang.Class[] r0 = r0.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x0087 }
            java.lang.String r1 = "jClass.declaredClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ NoSuchFieldException -> 0x0087 }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ NoSuchFieldException -> 0x0087 }
            int r1 = r0.length     // Catch:{ NoSuchFieldException -> 0x0087 }
            r2 = 0
            r4 = r9
            r3 = 0
        L_0x004e:
            if (r2 >= r1) goto L_0x0069
            r5 = r0[r2]     // Catch:{ NoSuchFieldException -> 0x0087 }
            r6 = r5
            java.lang.Class r6 = (java.lang.Class) r6     // Catch:{ NoSuchFieldException -> 0x0087 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x0087 }
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ NoSuchFieldException -> 0x0087 }
            if (r6 == 0) goto L_0x0066
            if (r3 == 0) goto L_0x0064
            goto L_0x006b
        L_0x0064:
            r3 = 1
            r4 = r5
        L_0x0066:
            int r2 = r2 + 1
            goto L_0x004e
        L_0x0069:
            if (r3 != 0) goto L_0x006c
        L_0x006b:
            r4 = r9
        L_0x006c:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ NoSuchFieldException -> 0x0087 }
            if (r4 != 0) goto L_0x0072
        L_0x0070:
            r0 = r9
            goto L_0x007f
        L_0x0072:
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch:{ NoSuchFieldException -> 0x0087 }
            if (r0 != 0) goto L_0x007b
            goto L_0x0070
        L_0x007b:
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NoSuchFieldException -> 0x0087 }
        L_0x007f:
            boolean r1 = r0 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x0087 }
            if (r1 == 0) goto L_0x0089
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch:{ NoSuchFieldException -> 0x0087 }
            r9 = r0
            goto L_0x0089
        L_0x0087:
            kotlinx.serialization.KSerializer r9 = (kotlinx.serialization.KSerializer) r9
        L_0x0089:
            if (r9 == 0) goto L_0x008c
            return r9
        L_0x008c:
            kotlinx.serialization.KSerializer r8 = polymorphicSerializer(r8)
            return r8
        L_0x0091:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.constructSerializerForGivenTypeArgs(kotlin.reflect.KClass, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    private static final <T> boolean isNotAnnotated(Class<T> cls) {
        return cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> KSerializer<T> polymorphicSerializer(KClass<T> kClass) {
        Class<T> javaClass = JvmClassMappingKt.getJavaClass(kClass);
        if (javaClass.getAnnotation(Polymorphic.class) != null) {
            return new PolymorphicSerializer<>(kClass);
        }
        Serializable serializable = (Serializable) javaClass.getAnnotation(Serializable.class);
        if (serializable == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return null;
        }
        return new PolymorphicSerializer<>(kClass);
    }

    private static final <T> KSerializer<T> interfaceSerializer(KClass<T> kClass) {
        Serializable serializable = (Serializable) JvmClassMappingKt.getJavaClass(kClass).getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer<>(kClass);
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        Class[] clsArr;
        Object companionOrNull = companionOrNull(cls);
        if (companionOrNull == null) {
            return null;
        }
        try {
            if (kSerializerArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i = 0; i < length; i++) {
                    clsArr2[i] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = companionOrNull.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(companionOrNull, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e;
        }
    }

    private static final Object companionOrNull(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "canonicalName");
        if (enumConstants != null) {
            EnumSerializer enumSerializer = new EnumSerializer(canonicalName, (Enum[]) enumConstants);
            if (enumSerializer instanceof KSerializer) {
                return enumSerializer;
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r5 == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
        if (r5 == false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r12) {
        /*
            java.lang.reflect.Field[] r0 = r12.getDeclaredFields()
            java.lang.String r1 = "jClass.declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r3
            r4 = 0
            r5 = 0
        L_0x0011:
            r7 = 1
            if (r4 >= r1) goto L_0x0046
            r8 = r0[r4]
            r9 = r8
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "INSTANCE"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x003b
            java.lang.Class r10 = r9.getType()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r12)
            if (r10 == 0) goto L_0x003b
            int r9 = r9.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x003b
            r9 = 1
            goto L_0x003c
        L_0x003b:
            r9 = 0
        L_0x003c:
            if (r9 == 0) goto L_0x0043
            if (r5 == 0) goto L_0x0041
            goto L_0x0048
        L_0x0041:
            r6 = r8
            r5 = 1
        L_0x0043:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0046:
            if (r5 != 0) goto L_0x0049
        L_0x0048:
            r6 = r3
        L_0x0049:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L_0x004e
            return r3
        L_0x004e:
            java.lang.Object r0 = r6.get(r3)
            java.lang.reflect.Method[] r12 = r12.getMethods()
            java.lang.String r1 = "jClass.methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            int r1 = r12.length
            r6 = r3
            r4 = 0
            r5 = 0
        L_0x0061:
            if (r4 >= r1) goto L_0x00a0
            r8 = r12[r4]
            r9 = r8
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9
            java.lang.String r10 = r9.getName()
            java.lang.String r11 = "serializer"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x0095
            java.lang.Class[] r10 = r9.getParameterTypes()
            java.lang.String r11 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            int r10 = r10.length
            if (r10 != 0) goto L_0x0084
            r10 = 1
            goto L_0x0085
        L_0x0084:
            r10 = 0
        L_0x0085:
            if (r10 == 0) goto L_0x0095
            java.lang.Class r9 = r9.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0095
            r9 = 1
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            if (r9 == 0) goto L_0x009d
            if (r5 == 0) goto L_0x009b
            goto L_0x00a2
        L_0x009b:
            r6 = r8
            r5 = 1
        L_0x009d:
            int r4 = r4 + 1
            goto L_0x0061
        L_0x00a0:
            if (r5 != 0) goto L_0x00a3
        L_0x00a2:
            r6 = r3
        L_0x00a3:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x00a8
            return r3
        L_0x00a8:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Object r12 = r6.invoke(r0, r12)
            boolean r0 = r12 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto L_0x00b5
            r3 = r12
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
        L_0x00b5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final boolean isInstanceOf(Object obj, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kclass");
        return JvmClassMappingKt.getJavaObjectType(kClass).isInstance(obj);
    }

    public static final boolean isReferenceArray(KClass<Object> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(kClass).isArray();
    }
}
