package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/SnackbarHostState;", "", "()V", "<set-?>", "Landroidx/compose/material/SnackbarData;", "currentSnackbarData", "getCurrentSnackbarData", "()Landroidx/compose/material/SnackbarData;", "setCurrentSnackbarData", "(Landroidx/compose/material/SnackbarData;)V", "currentSnackbarData$delegate", "Landroidx/compose/runtime/MutableState;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "showSnackbar", "Landroidx/compose/material/SnackbarResult;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SnackbarDataImpl", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnackbarHost.kt */
public final class SnackbarHostState {
    private final MutableState currentSnackbarData$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    /* access modifiers changed from: private */
    public final void setCurrentSnackbarData(SnackbarData snackbarData) {
        this.currentSnackbarData$delegate.setValue(snackbarData);
    }

    public final SnackbarData getCurrentSnackbarData() {
        return (SnackbarData) this.currentSnackbarData$delegate.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: androidx.compose.material.SnackbarDuration} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bc A[Catch:{ all -> 0x00cc }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x00c5=Splitter:B:28:0x00c5, B:34:0x00ce=Splitter:B:34:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showSnackbar(java.lang.String r9, java.lang.String r10, androidx.compose.material.SnackbarDuration r11, kotlin.coroutines.Continuation<? super androidx.compose.material.SnackbarResult> r12) {
        /*
            r8 = this;
            boolean r0 = r12 instanceof androidx.compose.material.SnackbarHostState$showSnackbar$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r0 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r0 = new androidx.compose.material.SnackbarHostState$showSnackbar$1
            r0.<init>(r8, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0070
            if (r2 == r4) goto L_0x0052
            if (r2 != r3) goto L_0x004a
            java.lang.Object r9 = r0.L$5
            androidx.compose.material.SnackbarHostState$showSnackbar$1 r9 = (androidx.compose.material.SnackbarHostState$showSnackbar$1) r9
            java.lang.Object r9 = r0.L$4
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$3
            androidx.compose.material.SnackbarDuration r10 = (androidx.compose.material.SnackbarDuration) r10
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$0
            androidx.compose.material.SnackbarHostState r10 = (androidx.compose.material.SnackbarHostState) r10
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0047 }
            goto L_0x00c5
        L_0x0047:
            r11 = move-exception
            goto L_0x00ce
        L_0x004a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0052:
            java.lang.Object r9 = r0.L$4
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$3
            r11 = r10
            androidx.compose.material.SnackbarDuration r11 = (androidx.compose.material.SnackbarDuration) r11
            java.lang.Object r10 = r0.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.L$0
            androidx.compose.material.SnackbarHostState r6 = (androidx.compose.material.SnackbarHostState) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r9
            r9 = r2
            r2 = r11
            r11 = r10
            r10 = r6
            goto L_0x008b
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.sync.Mutex r12 = r8.mutex
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.L$4 = r12
            r0.label = r4
            java.lang.Object r2 = r12.lock(r5, r0)
            if (r2 != r1) goto L_0x0088
            return r1
        L_0x0088:
            r2 = r11
            r11 = r10
            r10 = r8
        L_0x008b:
            r0.L$0 = r10     // Catch:{ all -> 0x00cc }
            r0.L$1 = r9     // Catch:{ all -> 0x00cc }
            r0.L$2 = r11     // Catch:{ all -> 0x00cc }
            r0.L$3 = r2     // Catch:{ all -> 0x00cc }
            r0.L$4 = r12     // Catch:{ all -> 0x00cc }
            r0.L$5 = r0     // Catch:{ all -> 0x00cc }
            r0.label = r3     // Catch:{ all -> 0x00cc }
            kotlinx.coroutines.CancellableContinuationImpl r3 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00cc }
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch:{ all -> 0x00cc }
            r3.<init>(r6, r4)     // Catch:{ all -> 0x00cc }
            r3.initCancellability()     // Catch:{ all -> 0x00cc }
            r4 = r3
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4     // Catch:{ all -> 0x00cc }
            androidx.compose.material.SnackbarHostState$SnackbarDataImpl r6 = new androidx.compose.material.SnackbarHostState$SnackbarDataImpl     // Catch:{ all -> 0x00cc }
            r6.<init>(r9, r11, r2, r4)     // Catch:{ all -> 0x00cc }
            androidx.compose.material.SnackbarData r6 = (androidx.compose.material.SnackbarData) r6     // Catch:{ all -> 0x00cc }
            r10.setCurrentSnackbarData(r6)     // Catch:{ all -> 0x00cc }
            java.lang.Object r9 = r3.getResult()     // Catch:{ all -> 0x00cc }
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00cc }
            if (r9 != r11) goto L_0x00bf
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x00cc }
        L_0x00bf:
            if (r9 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            r7 = r12
            r12 = r9
            r9 = r7
        L_0x00c5:
            r10.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00d2 }
            r9.unlock(r5)
            return r12
        L_0x00cc:
            r11 = move-exception
            r9 = r12
        L_0x00ce:
            r10.setCurrentSnackbarData(r5)     // Catch:{ all -> 0x00d2 }
            throw r11     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r10 = move-exception
            r9.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarHostState.showSnackbar(java.lang.String, java.lang.String, androidx.compose.material.SnackbarDuration, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object showSnackbar$default(SnackbarHostState snackbarHostState, String str, String str2, SnackbarDuration snackbarDuration, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            snackbarDuration = SnackbarDuration.Short;
        }
        return snackbarHostState.showSnackbar(str, str2, snackbarDuration, continuation);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SnackbarHostState$SnackbarDataImpl;", "Landroidx/compose/material/SnackbarData;", "message", "", "actionLabel", "duration", "Landroidx/compose/material/SnackbarDuration;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Landroidx/compose/material/SnackbarResult;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/material/SnackbarDuration;Lkotlinx/coroutines/CancellableContinuation;)V", "getActionLabel", "()Ljava/lang/String;", "getDuration", "()Landroidx/compose/material/SnackbarDuration;", "getMessage", "dismiss", "", "performAction", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SnackbarHost.kt */
    private static final class SnackbarDataImpl implements SnackbarData {
        private final String actionLabel;
        private final CancellableContinuation<SnackbarResult> continuation;
        private final SnackbarDuration duration;
        private final String message;

        public SnackbarDataImpl(String str, String str2, SnackbarDuration snackbarDuration, CancellableContinuation<? super SnackbarResult> cancellableContinuation) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(snackbarDuration, "duration");
            Intrinsics.checkNotNullParameter(cancellableContinuation, "continuation");
            this.message = str;
            this.actionLabel = str2;
            this.duration = snackbarDuration;
            this.continuation = cancellableContinuation;
        }

        public String getMessage() {
            return this.message;
        }

        public String getActionLabel() {
            return this.actionLabel;
        }

        public SnackbarDuration getDuration() {
            return this.duration;
        }

        public void performAction() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m5428constructorimpl(SnackbarResult.ActionPerformed));
            }
        }

        public void dismiss() {
            if (this.continuation.isActive()) {
                Result.Companion companion = Result.Companion;
                this.continuation.resumeWith(Result.m5428constructorimpl(SnackbarResult.Dismissed));
            }
        }
    }
}
