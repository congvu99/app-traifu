package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000J\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\t\u0012\u0004\u0012\u00020\n0\bH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a7\u0010\f\u001a\u00020\r2'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e¢\u0006\u0002\b\u0011ø\u0001\u0001¢\u0006\u0002\u0010\u0012\u001a2\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u001a \u0010\u0019\u001a\u00020\n*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\bø\u0001\u0000\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"awaitUiResult", "R", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "awaitUiResultWithPending", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "launchOnUiThread", "Lkotlinx/coroutines/Job;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "startCoroutineTimer", "delayMillis", "", "repeatMillis", "runActionOnUiThread", "", "postToUi", "storage_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoroutineExt.kt */
public final class CoroutineExtKt {
    public static /* synthetic */ Job startCoroutineTimer$default(long j, long j2, boolean z, Function0 function0, int i, Object obj) {
        return startCoroutineTimer((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? 0 : j2, (i & 4) != 0 ? false : z, function0);
    }

    public static final Job startCoroutineTimer(long j, long j2, boolean z, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        return BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new CoroutineExtKt$startCoroutineTimer$1(j, j2, z, function0, (Continuation<? super CoroutineExtKt$startCoroutineTimer$1>) null), 3, (Object) null);
    }

    public static final Job launchOnUiThread(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, function2, 2, (Object) null);
    }

    public static final <R> R awaitUiResultWithPending(CoroutineScope coroutineScope, Function1<? super CancellableContinuation<? super R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "uiScope");
        Intrinsics.checkNotNullParameter(function1, "action");
        return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new CoroutineExtKt$awaitUiResultWithPending$1(coroutineScope, function1, (Continuation<? super CoroutineExtKt$awaitUiResultWithPending$1>) null), 1, (Object) null);
    }

    public static final <R> R awaitUiResult(CoroutineScope coroutineScope, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(coroutineScope, "uiScope");
        Intrinsics.checkNotNullParameter(function0, "action");
        return BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new CoroutineExtKt$awaitUiResult$1(coroutineScope, function0, (Continuation<? super CoroutineExtKt$awaitUiResult$1>) null), 1, (Object) null);
    }

    public static final void postToUi(CoroutineScope coroutineScope, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new CoroutineExtKt$postToUi$1(function0, (Continuation<? super CoroutineExtKt$postToUi$1>) null), 2, (Object) null);
    }
}
