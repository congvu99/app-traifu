package com.anggrayudi.storage.file;

import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@¨\u0006\u0003"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1", f = "DocumentFileExt.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CoroutineExt.kt */
public final class DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ FileCallback $callback$inlined;
    final /* synthetic */ DocumentFile $this_moveFileTo$inlined;
    final /* synthetic */ Thread $thread$inlined;
    final /* synthetic */ CoroutineScope $uiScope;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1(CoroutineScope coroutineScope, Continuation continuation, FileCallback fileCallback, DocumentFile documentFile, Thread thread) {
        super(2, continuation);
        this.$uiScope = coroutineScope;
        this.$callback$inlined = fileCallback;
        this.$this_moveFileTo$inlined = documentFile;
        this.$thread$inlined = thread;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1(this.$uiScope, continuation, this.$callback$inlined, this.$this_moveFileTo$inlined, this.$thread$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;", "com/anggrayudi/storage/extension/CoroutineExtKt$awaitUiResult$1$1$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1$1", f = "DocumentFileExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$moveFileTo$$inlined$awaitUiResult$1$1  reason: invalid class name */
    /* compiled from: CoroutineExt.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(cancellableContinuation, continuation, fileCallback, documentFile, thread);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CancellableContinuation cancellableContinuation = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                FileCallback fileCallback = fileCallback;
                DocumentFile documentFile = documentFile;
                Intrinsics.checkNotNullExpressionValue(thread, "thread");
                cancellableContinuation.resumeWith(Result.m5428constructorimpl(Boxing.boxLong(fileCallback.onStart(documentFile, thread))));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.$uiScope;
            this.L$0 = coroutineScope;
            this.label = 1;
            Continuation continuation = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            final FileCallback fileCallback = this.$callback$inlined;
            final DocumentFile documentFile = this.$this_moveFileTo$inlined;
            final Thread thread = this.$thread$inlined;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new AnonymousClass1((Continuation) null), 2, (Object) null);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
