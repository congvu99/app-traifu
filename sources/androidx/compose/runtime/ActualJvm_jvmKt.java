package androidx.compose.runtime;

import androidx.navigation.compose.ComposeNavigator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0000\u001a(\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\r\u001a.\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u0002H\u000f0\u000b¢\u0006\u0002\b\fH\u0000¢\u0006\u0002\u0010\u0010\u001a-\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u000bH\bø\u0001\u0000¢\u0006\u0002\u0010\u0015*\u001e\b\u0000\u0010\u0016\u001a\u0004\b\u0000\u0010\u0017\"\b\u0012\u0004\u0012\u0002H\u00170\u00182\b\u0012\u0004\u0012\u0002H\u00170\u0018*\f\b\u0000\u0010\u0019\"\u00020\u001a2\u00020\u001a\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"ensureMutable", "", "it", "", "identityHashCode", "", "instance", "invokeComposable", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", "invokeComposableForResult", "T", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "synchronized", "R", "lock", "block", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "AtomicReference", "V", "Ljava/util/concurrent/atomic/AtomicReference;", "TestOnly", "Lorg/jetbrains/annotations/TestOnly;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActualJvm.jvm.kt */
public final class ActualJvm_jvmKt {
    public static final void ensureMutable(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
    }

    public static final int identityHashCode(Object obj) {
        return System.identityHashCode(obj);
    }

    /* renamed from: synchronized  reason: not valid java name */
    public static final <R> R m1528synchronized(Object obj, Function0<? extends R> function0) {
        R invoke;
        Intrinsics.checkNotNullParameter(obj, "lock");
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (obj) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final void invokeComposable(Composer composer, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(function2, ComposeNavigator.NAME);
        ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }

    public static final <T> T invokeComposableForResult(Composer composer, Function2<? super Composer, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(function2, ComposeNavigator.NAME);
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(composer, 1);
    }
}
