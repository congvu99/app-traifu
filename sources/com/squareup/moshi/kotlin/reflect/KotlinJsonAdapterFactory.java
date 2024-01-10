package com.squareup.moshi.kotlin.reflect;

import com.squareup.moshi.JsonAdapter;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 4, 0})
/* compiled from: KotlinJsonAdapter.kt */
public final class KotlinJsonAdapterFactory implements JsonAdapter.Factory {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.util.LinkedHashMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: java.util.List} */
    /* JADX WARNING: type inference failed for: r14v12, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.moshi.JsonAdapter<?> create(java.lang.reflect.Type r30, java.util.Set<? extends java.lang.annotation.Annotation> r31, com.squareup.moshi.Moshi r32) {
        /*
            r29 = this;
            r1 = r30
            r0 = r31
            r2 = r32
            java.lang.String r3 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "annotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "moshi"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r3 = 1
            r0 = r0 ^ r3
            r4 = 0
            if (r0 == 0) goto L_0x0021
            return r4
        L_0x0021:
            java.lang.Class r5 = com.squareup.moshi._MoshiKotlinTypesExtensionsKt.getRawType(r30)
            boolean r0 = r5.isInterface()
            if (r0 == 0) goto L_0x002c
            return r4
        L_0x002c:
            boolean r0 = r5.isEnum()
            if (r0 == 0) goto L_0x0033
            return r4
        L_0x0033:
            java.lang.Class r0 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterKt.KOTLIN_METADATA
            boolean r0 = r5.isAnnotationPresent(r0)
            if (r0 != 0) goto L_0x003e
            return r4
        L_0x003e:
            boolean r0 = com.squareup.moshi.internal.Util.isPlatformType(r5)
            if (r0 == 0) goto L_0x0045
            return r4
        L_0x0045:
            com.squareup.moshi.JsonAdapter r0 = com.squareup.moshi.internal.Util.generatedAdapter(r2, r1, r5)     // Catch:{ RuntimeException -> 0x004c }
            if (r0 == 0) goto L_0x0056
            return r0
        L_0x004c:
            r0 = move-exception
            r6 = r0
            java.lang.Throwable r0 = r6.getCause()
            boolean r0 = r0 instanceof java.lang.ClassNotFoundException
            if (r0 == 0) goto L_0x0423
        L_0x0056:
            boolean r0 = r5.isLocalClass()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0402
            kotlin.reflect.KClass r0 = kotlin.jvm.JvmClassMappingKt.getKotlinClass(r5)
            boolean r6 = r0.isAbstract()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03e1
            boolean r6 = r0.isInner()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x03c0
            java.lang.Object r6 = r0.getObjectInstance()
            r7 = 0
            if (r6 != 0) goto L_0x0078
            r6 = 1
            goto L_0x0079
        L_0x0078:
            r6 = 0
        L_0x0079:
            if (r6 == 0) goto L_0x039f
            boolean r6 = r0.isSealed()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0379
            kotlin.reflect.KFunction r6 = kotlin.reflect.full.KClasses.getPrimaryConstructor(r0)
            if (r6 == 0) goto L_0x0377
            java.util.List r8 = r6.getParameters()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 10
            int r10 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r9)
            int r10 = kotlin.collections.MapsKt.mapCapacity(r10)
            r11 = 16
            int r10 = kotlin.ranges.RangesKt.coerceAtLeast((int) r10, (int) r11)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>(r10)
            java.util.Map r11 = (java.util.Map) r11
            java.util.Iterator r8 = r8.iterator()
        L_0x00a9:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00be
            java.lang.Object r10 = r8.next()
            r12 = r10
            kotlin.reflect.KParameter r12 = (kotlin.reflect.KParameter) r12
            java.lang.String r12 = r12.getName()
            r11.put(r12, r10)
            goto L_0x00a9
        L_0x00be:
            r8 = r6
            kotlin.reflect.KCallable r8 = (kotlin.reflect.KCallable) r8
            kotlin.reflect.jvm.KCallablesJvm.setAccessible(r8, r3)
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.Collection r0 = kotlin.reflect.full.KClasses.getMemberProperties(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x00d1:
            boolean r10 = r0.hasNext()
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            if (r10 == 0) goto L_0x027e
            java.lang.Object r10 = r0.next()
            kotlin.reflect.KProperty1 r10 = (kotlin.reflect.KProperty1) r10
            java.lang.String r13 = r10.getName()
            java.lang.Object r13 = r11.get(r13)
            r15 = r13
            kotlin.reflect.KParameter r15 = (kotlin.reflect.KParameter) r15
            r13 = r10
            kotlin.reflect.KProperty r13 = (kotlin.reflect.KProperty) r13
            java.lang.reflect.Field r13 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaField(r13)
            if (r13 == 0) goto L_0x00f8
            int r13 = r13.getModifiers()
            goto L_0x00f9
        L_0x00f8:
            r13 = 0
        L_0x00f9:
            boolean r13 = java.lang.reflect.Modifier.isTransient(r13)
            if (r13 == 0) goto L_0x012c
            if (r15 == 0) goto L_0x010a
            boolean r10 = r15.isOptional()
            if (r10 == 0) goto L_0x0108
            goto L_0x010a
        L_0x0108:
            r10 = 0
            goto L_0x010b
        L_0x010a:
            r10 = 1
        L_0x010b:
            if (r10 == 0) goto L_0x010f
            goto L_0x0228
        L_0x010f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No default value for transient constructor "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x012c:
            if (r15 == 0) goto L_0x013f
            kotlin.reflect.KType r13 = r15.getType()
            kotlin.reflect.KType r14 = r10.getReturnType()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x013d
            goto L_0x013f
        L_0x013d:
            r13 = 0
            goto L_0x0140
        L_0x013f:
            r13 = 1
        L_0x0140:
            if (r13 == 0) goto L_0x023b
            boolean r13 = r10 instanceof kotlin.reflect.KMutableProperty1
            if (r13 != 0) goto L_0x014a
            if (r15 != 0) goto L_0x014a
            goto L_0x0228
        L_0x014a:
            r13 = r10
            kotlin.reflect.KCallable r13 = (kotlin.reflect.KCallable) r13
            kotlin.reflect.jvm.KCallablesJvm.setAccessible(r13, r3)
            java.util.List r13 = r10.getAnnotations()
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.List r13 = kotlin.collections.CollectionsKt.toMutableList(r13)
            r14 = r10
            kotlin.reflect.KAnnotatedElement r14 = (kotlin.reflect.KAnnotatedElement) r14
            java.util.List r14 = r14.getAnnotations()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x0167:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x017c
            java.lang.Object r16 = r14.next()
            r3 = r16
            java.lang.annotation.Annotation r3 = (java.lang.annotation.Annotation) r3
            boolean r3 = r3 instanceof com.squareup.moshi.Json
            if (r3 == 0) goto L_0x017a
            goto L_0x017e
        L_0x017a:
            r3 = 1
            goto L_0x0167
        L_0x017c:
            r16 = r4
        L_0x017e:
            com.squareup.moshi.Json r16 = (com.squareup.moshi.Json) r16
            java.lang.annotation.Annotation r16 = (java.lang.annotation.Annotation) r16
            com.squareup.moshi.Json r16 = (com.squareup.moshi.Json) r16
            if (r15 == 0) goto L_0x01be
            r3 = r13
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r14 = r15.getAnnotations()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            kotlin.collections.CollectionsKt.addAll(r3, r14)
            if (r16 != 0) goto L_0x01be
            r3 = r15
            kotlin.reflect.KAnnotatedElement r3 = (kotlin.reflect.KAnnotatedElement) r3
            java.util.List r3 = r3.getAnnotations()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x01a1:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x01b5
            java.lang.Object r14 = r3.next()
            r4 = r14
            java.lang.annotation.Annotation r4 = (java.lang.annotation.Annotation) r4
            boolean r4 = r4 instanceof com.squareup.moshi.Json
            if (r4 == 0) goto L_0x01b3
            goto L_0x01b6
        L_0x01b3:
            r4 = 0
            goto L_0x01a1
        L_0x01b5:
            r14 = 0
        L_0x01b6:
            com.squareup.moshi.Json r14 = (com.squareup.moshi.Json) r14
            java.lang.annotation.Annotation r14 = (java.lang.annotation.Annotation) r14
            r16 = r14
            com.squareup.moshi.Json r16 = (com.squareup.moshi.Json) r16
        L_0x01be:
            if (r16 == 0) goto L_0x01c7
            java.lang.String r3 = r16.name()
            if (r3 == 0) goto L_0x01c7
            goto L_0x01cb
        L_0x01c7:
            java.lang.String r3 = r10.getName()
        L_0x01cb:
            r14 = r3
            kotlin.reflect.KType r3 = r10.getReturnType()
            java.lang.reflect.Type r3 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(r3)
            java.lang.reflect.Type r3 = com.squareup.moshi.internal.Util.resolve(r1, r5, r3)
            java.util.Collection r13 = (java.util.Collection) r13
            java.lang.annotation.Annotation[] r4 = new java.lang.annotation.Annotation[r7]
            java.lang.Object[] r4 = r13.toArray(r4)
            if (r4 == 0) goto L_0x0235
            java.lang.annotation.Annotation[] r4 = (java.lang.annotation.Annotation[]) r4
            java.util.Set r4 = com.squareup.moshi.internal.Util.jsonAnnotations((java.lang.annotation.Annotation[]) r4)
            java.lang.String r12 = r10.getName()
            com.squareup.moshi.JsonAdapter r3 = r2.adapter(r3, r4, r12)
            r4 = r8
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r12 = r10.getName()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r13 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding
            if (r16 == 0) goto L_0x0202
            java.lang.String r16 = r16.name()
            if (r16 == 0) goto L_0x0202
            goto L_0x0204
        L_0x0202:
            r16 = r14
        L_0x0204:
            java.lang.String r7 = "adapter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            if (r10 == 0) goto L_0x022d
            if (r15 == 0) goto L_0x0215
            int r7 = r15.getIndex()
            r19 = r7
            r7 = r13
            goto L_0x0219
        L_0x0215:
            r7 = -1
            r7 = r13
            r19 = -1
        L_0x0219:
            r13 = r7
            r18 = r15
            r15 = r16
            r16 = r3
            r17 = r10
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r4.put(r12, r7)
        L_0x0228:
            r3 = 1
            r4 = 0
            r7 = 0
            goto L_0x00d1
        L_0x022d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>"
            r0.<init>(r1)
            throw r0
        L_0x0235:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r12)
            throw r0
        L_0x023b:
            r18 = r15
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 39
            r0.append(r1)
            java.lang.String r1 = r10.getName()
            r0.append(r1)
            java.lang.String r1 = "' has a constructor parameter of type "
            r0.append(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r18)
            kotlin.reflect.KType r1 = r18.getType()
            r0.append(r1)
            java.lang.String r1 = " but a property of type "
            r0.append(r1)
            kotlin.reflect.KType r1 = r10.getReturnType()
            r0.append(r1)
            r1 = 46
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x027e:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r6.getParameters()
            java.util.Iterator r1 = r1.iterator()
        L_0x028b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x02da
            java.lang.Object r2 = r1.next()
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2
            r3 = r8
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r4 = r2.getName()
            java.util.Map r3 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r3)
            java.lang.Object r3 = r3.remove(r4)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r3 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r3
            if (r3 != 0) goto L_0x02b3
            boolean r4 = r2.isOptional()
            if (r4 == 0) goto L_0x02b1
            goto L_0x02b3
        L_0x02b1:
            r4 = 0
            goto L_0x02b4
        L_0x02b3:
            r4 = 1
        L_0x02b4:
            if (r4 == 0) goto L_0x02bd
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            r2.add(r3)
            goto L_0x028b
        L_0x02bd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No property for required constructor "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x02da:
            int r1 = r0.size()
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r2 = r8.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x02e8:
            r26 = r1
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L_0x0319
            java.lang.Object r1 = r2.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.Object r1 = r1.getValue()
            r20 = r1
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r20 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r20
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            int r1 = r26 + 1
            r27 = 31
            r28 = 0
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r4 = com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding.copy$default(r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r3.add(r4)
            goto L_0x02e8
        L_0x0319:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.List r1 = kotlin.collections.CollectionsKt.filterNotNull(r1)
            r2 = r1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r9)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0332:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0346
            java.lang.Object r4 = r2.next()
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter$Binding r4 = (com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter.Binding) r4
            java.lang.String r4 = r4.getName()
            r3.add(r4)
            goto L_0x0332
        L_0x0346:
            java.util.List r3 = (java.util.List) r3
            java.util.Collection r3 = (java.util.Collection) r3
            r2 = 0
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r2 = r3.toArray(r2)
            if (r2 == 0) goto L_0x0371
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String[] r2 = (java.lang.String[]) r2
            com.squareup.moshi.JsonReader$Options r2 = com.squareup.moshi.JsonReader.Options.of(r2)
            com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter r3 = new com.squareup.moshi.kotlin.reflect.KotlinJsonAdapter
            java.util.List r0 = (java.util.List) r0
            java.lang.String r4 = "options"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r3.<init>(r6, r0, r1, r2)
            com.squareup.moshi.JsonAdapter r0 = r3.nullSafe()
            return r0
        L_0x0371:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r12)
            throw r0
        L_0x0377:
            r1 = r4
            return r1
        L_0x0379:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot reflectively serialize sealed class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r1 = ". Please register an adapter."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x039f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize object declaration "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x03c0:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize inner class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x03e1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize abstract class "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0402:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot serialize local class or object expression "
            r0.append(r1)
            java.lang.String r1 = r5.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0423:
            r0 = r6
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory.create(java.lang.reflect.Type, java.util.Set, com.squareup.moshi.Moshi):com.squareup.moshi.JsonAdapter");
    }
}
