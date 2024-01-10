package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import kotlinx.serialization.json.internal.JsonLexerKt;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Collections2 {
    private Collections2() {
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof FilteredCollection) {
            return ((FilteredCollection) collection).createCombined(predicate);
        }
        return new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    static boolean safeContains(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean safeRemove(Collection<?> collection, @NullableDecl Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static class FilteredCollection<E> extends AbstractCollection<E> {
        final Predicate<? super E> predicate;
        final Collection<E> unfiltered;

        FilteredCollection(Collection<E> collection, Predicate<? super E> predicate2) {
            this.unfiltered = collection;
            this.predicate = predicate2;
        }

        /* access modifiers changed from: package-private */
        public FilteredCollection<E> createCombined(Predicate<? super E> predicate2) {
            return new FilteredCollection<>(this.unfiltered, Predicates.and(this.predicate, predicate2));
        }

        public boolean add(E e) {
            Preconditions.checkArgument(this.predicate.apply(e));
            return this.unfiltered.add(e);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (Object apply : collection) {
                Preconditions.checkArgument(this.predicate.apply(apply));
            }
            return this.unfiltered.addAll(collection);
        }

        public void clear() {
            Iterables.removeIf(this.unfiltered, this.predicate);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (Collections2.safeContains(this.unfiltered, obj)) {
                return this.predicate.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return Collections2.containsAllImpl(this, collection);
        }

        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered, this.predicate);
        }

        public Iterator<E> iterator() {
            return Iterators.filter(this.unfiltered.iterator(), this.predicate);
        }

        public Spliterator<E> spliterator() {
            return CollectSpliterators.filter(this.unfiltered.spliterator(), this.predicate);
        }

        public void forEach(Consumer<? super E> consumer) {
            Preconditions.checkNotNull(consumer);
            this.unfiltered.forEach(new Consumer(consumer) {
                public final /* synthetic */ Consumer f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    Collections2.FilteredCollection.this.lambda$forEach$0$Collections2$FilteredCollection(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ void lambda$forEach$0$Collections2$FilteredCollection(Consumer consumer, Object obj) {
            if (this.predicate.test(obj)) {
                consumer.accept(obj);
            }
        }

        public boolean remove(Object obj) {
            return contains(obj) && this.unfiltered.remove(obj);
        }

        public boolean removeAll(Collection<?> collection) {
            collection.getClass();
            return removeIf(new java.util.function.Predicate(collection) {
                public final /* synthetic */ Collection f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return this.f$0.contains(obj);
                }
            });
        }

        static /* synthetic */ boolean lambda$retainAll$1(Collection collection, Object obj) {
            return !collection.contains(obj);
        }

        public boolean retainAll(Collection<?> collection) {
            return removeIf(new java.util.function.Predicate(collection) {
                public final /* synthetic */ Collection f$0;

                {
                    this.f$0 = r1;
                }

                public final boolean test(Object obj) {
                    return Collections2.FilteredCollection.lambda$retainAll$1(this.f$0, obj);
                }
            });
        }

        public boolean removeIf(java.util.function.Predicate<? super E> predicate2) {
            Preconditions.checkNotNull(predicate2);
            return this.unfiltered.removeIf(new java.util.function.Predicate(predicate2) {
                public final /* synthetic */ java.util.function.Predicate f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return Collections2.FilteredCollection.this.lambda$removeIf$2$Collections2$FilteredCollection(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ boolean lambda$removeIf$2$Collections2$FilteredCollection(java.util.function.Predicate predicate2, Object obj) {
            return this.predicate.apply(obj) && predicate2.test(obj);
        }

        public int size() {
            int i = 0;
            for (E apply : this.unfiltered) {
                if (this.predicate.apply(apply)) {
                    i++;
                }
            }
            return i;
        }

        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Collection<F> fromCollection;
        final Function<? super F, ? extends T> function;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function2) {
            this.fromCollection = (Collection) Preconditions.checkNotNull(collection);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromCollection.clear();
        }

        public boolean isEmpty() {
            return this.fromCollection.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.transform(this.fromCollection.iterator(), this.function);
        }

        public Spliterator<T> spliterator() {
            return CollectSpliterators.map(this.fromCollection.spliterator(), this.function);
        }

        public void forEach(Consumer<? super T> consumer) {
            Preconditions.checkNotNull(consumer);
            this.fromCollection.forEach(new Consumer(consumer) {
                public final /* synthetic */ Consumer f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    Collections2.TransformedCollection.this.lambda$forEach$0$Collections2$TransformedCollection(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ void lambda$forEach$0$Collections2$TransformedCollection(Consumer consumer, Object obj) {
            consumer.accept(this.function.apply(obj));
        }

        public boolean removeIf(java.util.function.Predicate<? super T> predicate) {
            Preconditions.checkNotNull(predicate);
            return this.fromCollection.removeIf(new java.util.function.Predicate(predicate) {
                public final /* synthetic */ java.util.function.Predicate f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return Collections2.TransformedCollection.this.lambda$removeIf$1$Collections2$TransformedCollection(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ boolean lambda$removeIf$1$Collections2$TransformedCollection(java.util.function.Predicate predicate, Object obj) {
            return predicate.test(this.function.apply(obj));
        }

        public int size() {
            return this.fromCollection.size();
        }
    }

    static boolean containsAllImpl(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    static String toStringImpl(Collection<?> collection) {
        StringBuilder newStringBuilderForCollection = newStringBuilderForCollection(collection.size());
        newStringBuilderForCollection.append(JsonLexerKt.BEGIN_LIST);
        boolean z = true;
        for (Object next : collection) {
            if (!z) {
                newStringBuilderForCollection.append(", ");
            }
            z = false;
            if (next == collection) {
                newStringBuilderForCollection.append("(this Collection)");
            } else {
                newStringBuilderForCollection.append(next);
            }
        }
        newStringBuilderForCollection.append(JsonLexerKt.END_LIST);
        return newStringBuilderForCollection.toString();
    }

    static StringBuilder newStringBuilderForCollection(int i) {
        CollectPreconditions.checkNonnegative(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, 1073741824));
    }

    static <T> Collection<T> cast(Iterable<T> iterable) {
        return (Collection) iterable;
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }

    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final Comparator<? super E> comparator;
        final ImmutableList<E> inputList;
        final int size;

        public boolean isEmpty() {
            return false;
        }

        OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator2) {
            ImmutableList<E> sortedCopyOf = ImmutableList.sortedCopyOf(comparator2, iterable);
            this.inputList = sortedCopyOf;
            this.comparator = comparator2;
            this.size = calculateSize(sortedCopyOf, comparator2);
        }

        private static <E> int calculateSize(List<E> list, Comparator<? super E> comparator2) {
            int i = 1;
            int i2 = 1;
            int i3 = 1;
            while (i < list.size()) {
                if (comparator2.compare(list.get(i - 1), list.get(i)) < 0) {
                    i2 = IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
                    i3 = 0;
                    if (i2 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                i++;
                i3++;
            }
            return IntMath.saturatedMultiply(i2, IntMath.binomial(i, i3));
        }

        public int size() {
            return this.size;
        }

        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.inputList, this.comparator);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        public String toString() {
            return "orderedPermutationCollection(" + this.inputList + ")";
        }
    }

    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        final Comparator<? super E> comparator;
        @NullableDecl
        List<E> nextPermutation;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator2) {
            this.nextPermutation = Lists.newArrayList(list);
            this.comparator = comparator2;
        }

        /* access modifiers changed from: protected */
        public List<E> computeNext() {
            List<E> list = this.nextPermutation;
            if (list == null) {
                return (List) endOfData();
            }
            ImmutableList<E> copyOf = ImmutableList.copyOf(list);
            calculateNextPermutation();
            return copyOf;
        }

        /* access modifiers changed from: package-private */
        public void calculateNextPermutation() {
            int findNextJ = findNextJ();
            if (findNextJ == -1) {
                this.nextPermutation = null;
                return;
            }
            Collections.swap(this.nextPermutation, findNextJ, findNextL(findNextJ));
            Collections.reverse(this.nextPermutation.subList(findNextJ + 1, this.nextPermutation.size()));
        }

        /* access modifiers changed from: package-private */
        public int findNextJ() {
            for (int size = this.nextPermutation.size() - 2; size >= 0; size--) {
                if (this.comparator.compare(this.nextPermutation.get(size), this.nextPermutation.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int findNextL(int i) {
            E e = this.nextPermutation.get(i);
            for (int size = this.nextPermutation.size() - 1; size > i; size--) {
                if (this.comparator.compare(e, this.nextPermutation.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.copyOf(collection));
    }

    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> inputList;

        public boolean isEmpty() {
            return false;
        }

        PermutationCollection(ImmutableList<E> immutableList) {
            this.inputList = immutableList;
        }

        public int size() {
            return IntMath.factorial(this.inputList.size());
        }

        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.inputList);
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.isPermutation(this.inputList, (List) obj);
        }

        public String toString() {
            return "permutations(" + this.inputList + ")";
        }
    }

    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final int[] c;
        int j = Integer.MAX_VALUE;
        final List<E> list;
        final int[] o;

        PermutationIterator(List<E> list2) {
            this.list = new ArrayList(list2);
            int size = list2.size();
            int[] iArr = new int[size];
            this.c = iArr;
            this.o = new int[size];
            Arrays.fill(iArr, 0);
            Arrays.fill(this.o, 1);
        }

        /* access modifiers changed from: protected */
        public List<E> computeNext() {
            if (this.j <= 0) {
                return (List) endOfData();
            }
            ImmutableList<E> copyOf = ImmutableList.copyOf(this.list);
            calculateNextPermutation();
            return copyOf;
        }

        /* access modifiers changed from: package-private */
        public void calculateNextPermutation() {
            int size = this.list.size() - 1;
            this.j = size;
            if (size != -1) {
                int i = 0;
                while (true) {
                    int[] iArr = this.c;
                    int i2 = this.j;
                    int i3 = iArr[i2] + this.o[i2];
                    if (i3 < 0) {
                        switchDirection();
                    } else if (i3 != i2 + 1) {
                        Collections.swap(this.list, (i2 - iArr[i2]) + i, (i2 - i3) + i);
                        this.c[this.j] = i3;
                        return;
                    } else if (i2 != 0) {
                        i++;
                        switchDirection();
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void switchDirection() {
            int[] iArr = this.o;
            int i = this.j;
            iArr[i] = -iArr[i];
            this.j = i - 1;
        }
    }

    /* access modifiers changed from: private */
    public static boolean isPermutation(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        return HashMultiset.create(list).equals(HashMultiset.create(list2));
    }
}
