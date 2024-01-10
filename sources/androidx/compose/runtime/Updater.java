package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0019\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u001a\u0010\u0018JI\u0010\u001b\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b!\u0010\"JK\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\bø\u0001\u0001¢\u0006\u0004\b!\u0010#J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'JI\u0010(\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b)\u0010\"JK\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\bø\u0001\u0001¢\u0006\u0004\b)\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0001\u0003\u0001\u00020\u0004ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", "V", "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
/* compiled from: Composer.kt */
public final class Updater<T> {
    private final Composer composer;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Updater m1542boximpl(Composer composer2) {
        return new Updater(composer2);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Composer m1543constructorimpl(Composer composer2) {
        Intrinsics.checkNotNullParameter(composer2, "composer");
        return composer2;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1544equalsimpl(Composer composer2, Object obj) {
        return (obj instanceof Updater) && Intrinsics.areEqual((Object) composer2, (Object) ((Updater) obj).m1554unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1545equalsimpl0(Composer composer2, Composer composer3) {
        return Intrinsics.areEqual((Object) composer2, (Object) composer3);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1546hashCodeimpl(Composer composer2) {
        return composer2.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1551toStringimpl(Composer composer2) {
        return "Updater(composer=" + composer2 + ')';
    }

    public boolean equals(Object obj) {
        return m1544equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m1546hashCodeimpl(this.composer);
    }

    public String toString() {
        return m1551toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Composer m1554unboximpl() {
        return this.composer;
    }

    private /* synthetic */ Updater(Composer composer2) {
        this.composer = composer2;
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m1549setimpl(Composer composer2, int i, Function2<? super T, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), (Object) Integer.valueOf(i))) {
            composer2.updateRememberedValue(Integer.valueOf(i));
            composer2.apply(Integer.valueOf(i), function2);
        }
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final <V> void m1550setimpl(Composer composer2, V v, Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), (Object) v)) {
            composer2.updateRememberedValue(v);
            composer2.apply(v, function2);
        }
    }

    /* renamed from: update-impl  reason: not valid java name */
    public static final void m1552updateimpl(Composer composer2, int i, Function2<? super T, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        boolean inserting = composer2.getInserting();
        if (inserting || !Intrinsics.areEqual(composer2.rememberedValue(), (Object) Integer.valueOf(i))) {
            composer2.updateRememberedValue(Integer.valueOf(i));
            if (!inserting) {
                composer2.apply(Integer.valueOf(i), function2);
            }
        }
    }

    /* renamed from: update-impl  reason: not valid java name */
    public static final <V> void m1553updateimpl(Composer composer2, V v, Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        boolean inserting = composer2.getInserting();
        if (inserting || !Intrinsics.areEqual(composer2.rememberedValue(), (Object) v)) {
            composer2.updateRememberedValue(v);
            if (!inserting) {
                composer2.apply(v, function2);
            }
        }
    }

    /* renamed from: init-impl  reason: not valid java name */
    public static final void m1547initimpl(Composer composer2, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (composer2.getInserting()) {
            composer2.apply(Unit.INSTANCE, new Updater$init$1(function1));
        }
    }

    /* renamed from: reconcile-impl  reason: not valid java name */
    public static final void m1548reconcileimpl(Composer composer2, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        composer2.apply(Unit.INSTANCE, new Updater$reconcile$1(function1));
    }
}
