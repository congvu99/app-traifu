package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KType;", "kotlin.jvm.PlatformType", "", "current", "getNeighbors"}, k = 3, mv = {1, 4, 0})
/* compiled from: KClasses.kt */
final class KClasses$allSupertypes$1<N> implements DFS.Neighbors<KType> {
    public static final KClasses$allSupertypes$1 INSTANCE = new KClasses$allSupertypes$1();

    KClasses$allSupertypes$1() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.util.List<kotlin.reflect.KType>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Iterable<kotlin.reflect.KType> getNeighbors(kotlin.reflect.KType r9) {
        /*
            r8 = this;
            kotlin.reflect.KClassifier r0 = r9.getClassifier()
            boolean r1 = r0 instanceof kotlin.reflect.KClass
            r2 = 0
            if (r1 != 0) goto L_0x000a
            r0 = r2
        L_0x000a:
            kotlin.reflect.KClass r0 = (kotlin.reflect.KClass) r0
            if (r0 == 0) goto L_0x00a4
            java.util.List r0 = r0.getSupertypes()
            java.util.List r1 = r9.getArguments()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x001e
            goto L_0x009b
        L_0x001e:
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl"
            if (r9 == 0) goto L_0x009e
            r3 = r9
            kotlin.reflect.jvm.internal.KTypeImpl r3 = (kotlin.reflect.jvm.internal.KTypeImpl) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r3 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create((kotlin.reflect.jvm.internal.impl.types.KotlinType) r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r0 = r0.iterator()
        L_0x0040:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0098
            java.lang.Object r5 = r0.next()
            kotlin.reflect.KType r5 = (kotlin.reflect.KType) r5
            if (r5 == 0) goto L_0x0092
            r6 = r5
            kotlin.reflect.jvm.internal.KTypeImpl r6 = (kotlin.reflect.jvm.internal.KTypeImpl) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r7 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r3.substitute(r6, r7)
            if (r6 == 0) goto L_0x006c
            java.lang.String r5 = "substitutor.substitute((…: $supertype ($current)\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            kotlin.reflect.jvm.internal.KTypeImpl r5 = new kotlin.reflect.jvm.internal.KTypeImpl
            r7 = 2
            r5.<init>(r6, r2, r7, r2)
            r4.add(r5)
            goto L_0x0040
        L_0x006c:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Type substitution failed: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " ("
            r1.append(r2)
            r1.append(r9)
            r9 = 41
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L_0x0092:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r1)
            throw r9
        L_0x0098:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
        L_0x009b:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            return r0
        L_0x009e:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r1)
            throw r9
        L_0x00a4:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Supertype not a class: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KClasses$allSupertypes$1.getNeighbors(kotlin.reflect.KType):java.lang.Iterable");
    }
}
