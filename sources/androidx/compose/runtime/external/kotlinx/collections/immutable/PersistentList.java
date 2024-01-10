package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b`\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "clear", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "retainAll", "set", "Builder", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImmutableList.kt */
public interface PersistentList<E> extends ImmutableList<E>, PersistentCollection<E> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "E", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImmutableList.kt */
    public interface Builder<E> extends List<E>, PersistentCollection.Builder<E>, KMutableList {
        PersistentList<E> build();
    }

    PersistentList<E> add(int i, E e);

    PersistentList<E> add(E e);

    PersistentList<E> addAll(int i, Collection<? extends E> collection);

    PersistentList<E> addAll(Collection<? extends E> collection);

    Builder<E> builder();

    PersistentList<E> clear();

    PersistentList<E> remove(E e);

    PersistentList<E> removeAll(Collection<? extends E> collection);

    PersistentList<E> removeAll(Function1<? super E, Boolean> function1);

    PersistentList<E> removeAt(int i);

    PersistentList<E> retainAll(Collection<? extends E> collection);

    PersistentList<E> set(int i, E e);
}
