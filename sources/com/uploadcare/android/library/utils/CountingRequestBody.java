package com.uploadcare.android.library.utils;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012:\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000b¢\u0006\u0002\u0010\fJ\b\u0010\t\u001a\u00020\u0005H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J!\u0010\u000f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016RB\u0010\u0003\u001a6\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/uploadcare/android/library/utils/CountingRequestBody;", "Lokhttp3/RequestBody;", "requestBody", "onProgressUpdate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "bytesWritten", "contentLength", "", "Lcom/uploadcare/android/library/utils/CountingRequestListener;", "(Lokhttp3/RequestBody;Lkotlin/jvm/functions/Function2;)V", "contentType", "Lokhttp3/MediaType;", "reportProgress", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeTo", "sink", "Lokio/BufferedSink;", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: CountingRequestBody.kt */
public final class CountingRequestBody extends RequestBody {
    /* access modifiers changed from: private */
    public final Function2<Long, Long, Unit> onProgressUpdate;
    /* access modifiers changed from: private */
    public final RequestBody requestBody;

    public CountingRequestBody(RequestBody requestBody2, Function2<? super Long, ? super Long, Unit> function2) {
        Intrinsics.checkNotNullParameter(requestBody2, "requestBody");
        Intrinsics.checkNotNullParameter(function2, "onProgressUpdate");
        this.requestBody = requestBody2;
        this.onProgressUpdate = function2;
    }

    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        BufferedSink buffer = Okio.buffer((Sink) new CountingSink(bufferedSink, new CountingRequestBody$writeTo$countingSink$1(this)));
        this.requestBody.writeTo(buffer);
        buffer.flush();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object reportProgress(long j, long j2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CountingRequestBody$reportProgress$2(this, j, j2, (Continuation) null), continuation);
        if (withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }
}
