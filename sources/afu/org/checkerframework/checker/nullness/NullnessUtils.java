package afu.org.checkerframework.checker.nullness;

import afu.org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class NullnessUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @EnsuresNonNull({"#1"})
    public static <T> T castNonNull(T t) {
        return t;
    }

    private NullnessUtils() {
        throw new AssertionError("shouldn't be instantiated");
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullDeep(T[] tArr) {
        return castNonNullArray(tArr);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][] castNonNullDeep(T[][] tArr) {
        return (Object[][]) castNonNullArray(tArr);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][] castNonNullDeep(T[][][] tArr) {
        return (Object[][][]) castNonNullArray(tArr);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][][] castNonNullDeep(T[][][][] tArr) {
        return (Object[][][][]) castNonNullArray(tArr);
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[][][][][] castNonNullDeep(T[][][][][] tArr) {
        return (Object[][][][][]) castNonNullArray(tArr);
    }

    private static <T> T[] castNonNullArray(T[] tArr) {
        for (T checkIfArray : tArr) {
            checkIfArray(checkIfArray);
        }
        return (Object[]) tArr;
    }

    private static void checkIfArray(Object obj) {
        Class<?> componentType = obj.getClass().getComponentType();
        if (componentType != null && !componentType.isPrimitive()) {
            castNonNullArray((Object[]) obj);
        }
    }
}
