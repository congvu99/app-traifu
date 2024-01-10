package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.ExperimentalComposeUiApi;
import com.github.mikephil.charting.utils.Utils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@ExperimentalComposeUiApi
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J1\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\f\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\rH\u0002J=\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "compatibleTypes", "", "methodTypes", "", "Ljava/lang/Class;", "actualTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "defaultParamCount", "invokeComposable", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDeclaredCompatibleMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposableInvoker.kt */
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 15;

    private ComposableInvoker() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean compatibleTypes(java.lang.Class<?>[] r9, java.lang.Class<?>[] r10) {
        /*
            r8 = this;
            int r0 = r9.length
            int r1 = r10.length
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0055
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r9.length
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            int r1 = r9.length
            r4 = 0
            r5 = 0
        L_0x0011:
            if (r4 >= r1) goto L_0x0028
            r6 = r9[r4]
            int r7 = r5 + 1
            r5 = r10[r5]
            boolean r5 = r6.isAssignableFrom(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r0.add(r5)
            int r4 = r4 + 1
            r5 = r7
            goto L_0x0011
        L_0x0028:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r9 = r0 instanceof java.util.Collection
            if (r9 == 0) goto L_0x003b
            r9 = r0
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x003b
        L_0x0039:
            r9 = 1
            goto L_0x0052
        L_0x003b:
            java.util.Iterator r9 = r0.iterator()
        L_0x003f:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0039
            java.lang.Object r10 = r9.next()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x003f
            r9 = 0
        L_0x0052:
            if (r9 == 0) goto L_0x0055
            r2 = 1
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.compatibleTypes(java.lang.Class[], java.lang.Class[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041 A[EDGE_INSN: B:17:0x0041->B:11:0x0041 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d A[LOOP:0: B:1:0x0015->B:9:0x003d, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method getDeclaredCompatibleMethod(java.lang.Class<?> r8, java.lang.String r9, java.lang.Class<?>... r10) {
        /*
            r7 = this;
            int r0 = r10.length
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r0)
            java.lang.Class[] r10 = (java.lang.Class[]) r10
            java.lang.reflect.Method[] r8 = r8.getDeclaredMethods()
            java.lang.String r0 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x0015:
            if (r2 >= r0) goto L_0x0040
            r3 = r8[r2]
            r4 = r3
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            java.lang.String r5 = r4.getName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0039
            androidx.compose.ui.tooling.ComposableInvoker r5 = INSTANCE
            java.lang.Class[] r4 = r4.getParameterTypes()
            java.lang.String r6 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            boolean r4 = r5.compatibleTypes(r4, r10)
            if (r4 == 0) goto L_0x0039
            r4 = 1
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            if (r4 == 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0040:
            r3 = 0
        L_0x0041:
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x0046
            return r3
        L_0x0046:
            java.lang.NoSuchMethodException r8 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            java.lang.String r9 = " not found"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.getDeclaredCompatibleMethod(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private final /* synthetic */ <T> T[] dup(T t, int i) {
        Iterable intRange = new IntRange(0, i);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        T[] array = ((List) arrayList).toArray(new Object[0]);
        if (array != null) {
            return (Object[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|(1:(2:29|(2:46|31)(1:32))(2:47|33))|34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r11 = r9.getDeclaredMethods();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "declaredMethods");
        r11 = (java.lang.Object[]) r11;
        r2 = r11.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        if (r1 < r2) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        r3 = r11[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3.getName(), (java.lang.Object) r10) != false) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b8, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b9, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bc, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        r11 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
        r11 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x009b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.reflect.Method findComposableMethod(java.lang.Class<?> r9, java.lang.String r10, java.lang.Object... r11) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r2 = r11.length     // Catch:{ ReflectiveOperationException -> 0x009b }
            int r2 = r8.changedParamCount(r2, r1)     // Catch:{ ReflectiveOperationException -> 0x009b }
            kotlin.jvm.internal.SpreadBuilder r3 = new kotlin.jvm.internal.SpreadBuilder     // Catch:{ ReflectiveOperationException -> 0x009b }
            r4 = 4
            r3.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x009b }
            r4.<init>()     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ ReflectiveOperationException -> 0x009b }
            int r5 = r11.length     // Catch:{ ReflectiveOperationException -> 0x009b }
            r6 = 0
        L_0x0016:
            if (r6 >= r5) goto L_0x002a
            r7 = r11[r6]     // Catch:{ ReflectiveOperationException -> 0x009b }
            if (r7 == 0) goto L_0x0021
            java.lang.Class r7 = r7.getClass()     // Catch:{ ReflectiveOperationException -> 0x009b }
            goto L_0x0022
        L_0x0021:
            r7 = r0
        L_0x0022:
            if (r7 == 0) goto L_0x0027
            r4.add(r7)     // Catch:{ ReflectiveOperationException -> 0x009b }
        L_0x0027:
            int r6 = r6 + 1
            goto L_0x0016
        L_0x002a:
            java.util.List r4 = (java.util.List) r4     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Object[] r11 = r4.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            if (r11 == 0) goto L_0x0095
            r3.addSpread(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class<androidx.compose.runtime.Composer> r11 = androidx.compose.runtime.Composer.class
            r3.add(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ ReflectiveOperationException -> 0x009b }
            r3.add(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ ReflectiveOperationException -> 0x009b }
            kotlin.ranges.IntRange r5 = new kotlin.ranges.IntRange     // Catch:{ ReflectiveOperationException -> 0x009b }
            r5.<init>(r1, r2)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ ReflectiveOperationException -> 0x009b }
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r6)     // Catch:{ ReflectiveOperationException -> 0x009b }
            r2.<init>(r6)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ ReflectiveOperationException -> 0x009b }
        L_0x005f:
            boolean r6 = r5.hasNext()     // Catch:{ ReflectiveOperationException -> 0x009b }
            if (r6 == 0) goto L_0x006f
            r6 = r5
            kotlin.collections.IntIterator r6 = (kotlin.collections.IntIterator) r6     // Catch:{ ReflectiveOperationException -> 0x009b }
            r6.nextInt()     // Catch:{ ReflectiveOperationException -> 0x009b }
            r2.add(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            goto L_0x005f
        L_0x006f:
            java.util.List r2 = (java.util.List) r2     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class[] r11 = new java.lang.Class[r1]     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Object[] r11 = r2.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            if (r11 == 0) goto L_0x008f
            r3.addSpread(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            int r11 = r3.size()     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class[] r11 = new java.lang.Class[r11]     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Object[] r11 = r3.toArray(r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.Class[] r11 = (java.lang.Class[]) r11     // Catch:{ ReflectiveOperationException -> 0x009b }
            java.lang.reflect.Method r11 = r8.getDeclaredCompatibleMethod(r9, r10, r11)     // Catch:{ ReflectiveOperationException -> 0x009b }
            goto L_0x00c4
        L_0x008f:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ ReflectiveOperationException -> 0x009b }
            r11.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x009b }
            throw r11     // Catch:{ ReflectiveOperationException -> 0x009b }
        L_0x0095:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException     // Catch:{ ReflectiveOperationException -> 0x009b }
            r11.<init>(r4)     // Catch:{ ReflectiveOperationException -> 0x009b }
            throw r11     // Catch:{ ReflectiveOperationException -> 0x009b }
        L_0x009b:
            java.lang.reflect.Method[] r11 = r9.getDeclaredMethods()     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            java.lang.String r2 = "declaredMethods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            java.lang.Object[] r11 = (java.lang.Object[]) r11     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            int r2 = r11.length     // Catch:{ ReflectiveOperationException -> 0x00c1 }
        L_0x00a7:
            if (r1 >= r2) goto L_0x00bc
            r3 = r11[r1]     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            r4 = r3
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            java.lang.String r4 = r4.getName()     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r10)     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            if (r4 == 0) goto L_0x00b9
            goto L_0x00bd
        L_0x00b9:
            int r1 = r1 + 1
            goto L_0x00a7
        L_0x00bc:
            r3 = r0
        L_0x00bd:
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3     // Catch:{ ReflectiveOperationException -> 0x00c1 }
            r11 = r3
            goto L_0x00c4
        L_0x00c1:
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            r11 = r0
        L_0x00c4:
            if (r11 == 0) goto L_0x00c7
            return r11
        L_0x00c7:
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = r9.getName()
            r0.append(r9)
            r9 = 46
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            r11.<init>(r9)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposableInvoker.findComposableMethod(java.lang.Class, java.lang.String, java.lang.Object[]):java.lang.reflect.Method");
    }

    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.valueOf(Utils.DOUBLE_EPSILON);
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return 0;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return (byte) 0;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return '0';
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return 0L;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return false;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.valueOf(0.0f);
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return (short) 0;
                    }
                    break;
            }
        }
        return null;
    }

    private final Object invokeComposableMethod(Method method, Object obj, Composer composer, Object... objArr) {
        int i;
        int i2;
        Class[] parameterTypes = method.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        Object[] objArr2 = (Object[]) parameterTypes;
        int i3 = -1;
        int length = objArr2.length - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                if (Intrinsics.areEqual((Object) (Class) objArr2[length], (Object) Composer.class)) {
                    i3 = length;
                    break;
                } else if (i4 < 0) {
                    break;
                } else {
                    length = i4;
                }
            }
        }
        int i5 = i3 + 1;
        int changedParamCount = changedParamCount(i3, obj != null ? 1 : 0) + i5;
        int length2 = method.getParameterTypes().length;
        if (length2 != changedParamCount) {
            i = defaultParamCount(i3);
        } else {
            i = 0;
        }
        if (i + changedParamCount == length2) {
            Object[] objArr3 = new Object[length2];
            int i6 = 0;
            while (i6 < length2) {
                if (i6 >= 0 && i6 < i3) {
                    if (i6 < 0 || i6 > ArraysKt.getLastIndex((T[]) objArr)) {
                        ComposableInvoker composableInvoker = INSTANCE;
                        Class cls = method.getParameterTypes()[i6];
                        Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                        i2 = composableInvoker.getDefaultValue(cls);
                    } else {
                        i2 = objArr[i6];
                    }
                } else if (i6 == i3) {
                    i2 = composer;
                } else {
                    if (i5 <= i6 && i6 < changedParamCount) {
                        i2 = 0;
                    } else {
                        if (changedParamCount <= i6 && i6 < length2) {
                            i2 = 2097151;
                        } else {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                    }
                }
                objArr3[i6] = i2;
                i6++;
            }
            return method.invoke(obj, Arrays.copyOf(objArr3, length2));
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final int changedParamCount(int i, int i2) {
        if (i == 0) {
            return 1;
        }
        return (int) Math.ceil(((double) (i + i2)) / 15.0d);
    }

    private final int defaultParamCount(int i) {
        return (int) Math.ceil(((double) i) / 31.0d);
    }

    @ExperimentalComposeUiApi
    public final void invokeComposable(String str, String str2, Composer composer, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(objArr, "args");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "composableClass");
            Method findComposableMethod = findComposableMethod(cls, str2, Arrays.copyOf(objArr, objArr.length));
            findComposableMethod.setAccessible(true);
            if (Modifier.isStatic(findComposableMethod.getModifiers())) {
                invokeComposableMethod(findComposableMethod, (Object) null, composer, Arrays.copyOf(objArr, objArr.length));
            } else {
                invokeComposableMethod(findComposableMethod, cls.getConstructor(new Class[0]).newInstance(new Object[0]), composer, Arrays.copyOf(objArr, objArr.length));
            }
        } catch (ReflectiveOperationException e) {
            throw new ClassNotFoundException("Composable Method '" + str + '.' + str2 + "' not found", e);
        }
    }
}
