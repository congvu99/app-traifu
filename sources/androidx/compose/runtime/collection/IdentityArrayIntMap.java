package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\fJ&\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001fH\bø\u0001\u0000J\u0012\u0010 \u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\"\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010#\u001a\u00020\fH\u0002J&\u0010$\u001a\u00020%2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020%0\u001fH\bø\u0001\u0000J\u0011\u0010'\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0001J&\u0010)\u001a\u00020%2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001d0\u001fH\bø\u0001\u0000R.\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\n\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0002\u0007\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "", "()V", "keys", "", "getKeys$annotations", "getKeys", "()[Ljava/lang/Object;", "setKeys", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "values", "", "getValues$annotations", "getValues", "()[I", "setValues", "([I)V", "add", "key", "value", "any", "", "predicate", "Lkotlin/Function2;", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "", "block", "get", "remove", "removeValueIf", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityArrayIntMap.kt */
public final class IdentityArrayIntMap {
    private Object[] keys = new Object[4];
    private int size;
    private int[] values = new int[4];

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    public final void setKeys(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final int[] getValues() {
        return this.values;
    }

    public final void setValues(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.values = iArr;
    }

    public final int get(Object obj) {
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        int find = find(obj);
        if (find >= 0) {
            return this.values[find];
        }
        throw new IllegalStateException("Key not found".toString());
    }

    public final int add(Object obj, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        if (this.size > 0) {
            i2 = find(obj);
            if (i2 >= 0) {
                int[] iArr = this.values;
                int i3 = iArr[i2];
                iArr[i2] = i;
                return i3;
            }
        } else {
            i2 = -1;
        }
        int i4 = -(i2 + 1);
        int i5 = this.size;
        Object[] objArr = this.keys;
        if (i5 == objArr.length) {
            Object[] objArr2 = new Object[(objArr.length * 2)];
            int[] iArr2 = new int[(objArr.length * 2)];
            int i6 = i4 + 1;
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, i6, i4, i5);
            ArraysKt.copyInto(this.values, iArr2, i6, i4, this.size);
            int i7 = i4;
            ArraysKt.copyInto$default(this.keys, objArr2, 0, 0, i7, 6, (Object) null);
            ArraysKt.copyInto$default(this.values, iArr2, 0, 0, i7, 6, (Object) null);
            this.keys = objArr2;
            this.values = iArr2;
        } else {
            int i8 = i4 + 1;
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i8, i4, i5);
            int[] iArr3 = this.values;
            ArraysKt.copyInto(iArr3, iArr3, i8, i4, this.size);
        }
        this.keys[i4] = obj;
        this.values[i4] = i;
        this.size++;
        return -1;
    }

    public final boolean remove(Object obj) {
        Intrinsics.checkNotNullParameter(obj, SDKConstants.PARAM_KEY);
        int find = find(obj);
        if (find < 0) {
            return false;
        }
        int i = this.size;
        if (find < i - 1) {
            Object[] objArr = this.keys;
            int i2 = find + 1;
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, find, i2, i);
            int[] iArr = this.values;
            ArraysKt.copyInto(iArr, iArr, find, i2, this.size);
        }
        int i3 = this.size - 1;
        this.size = i3;
        this.keys[i3] = null;
        return true;
    }

    public final void removeValueIf(Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size2 = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = getKeys()[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            int i3 = getValues()[i2];
            if (!function2.invoke(obj, Integer.valueOf(i3)).booleanValue()) {
                if (i != i2) {
                    getKeys()[i] = obj;
                    getValues()[i] = i3;
                }
                i++;
            }
        }
        int size3 = getSize();
        for (int i4 = i; i4 < size3; i4++) {
            getKeys()[i4] = null;
        }
        setSize(i);
    }

    public final boolean any(Function2<Object, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            Object obj = getKeys()[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            if (function2.invoke(obj, Integer.valueOf(getValues()[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void forEach(Function2<Object, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            Object obj = getKeys()[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
            function2.invoke(obj, Integer.valueOf(getValues()[i]));
        }
    }

    private final int find(Object obj) {
        int i = this.size - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            Object obj2 = this.keys[i3];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i2 = i3 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                i = i3 - 1;
            } else if (obj2 == obj) {
                return i3;
            } else {
                return findExactIndex(i3, obj, identityHashCode);
            }
        }
        return -(i2 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj2 = this.keys[i3];
            if (obj2 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj2) != i2) {
                break;
            }
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (true) {
            if (i4 >= i5) {
                i4 = this.size;
                break;
            }
            Object obj3 = this.keys[i4];
            if (obj3 == obj) {
                return i4;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
            i4++;
        }
        return -(i4 + 1);
    }
}
