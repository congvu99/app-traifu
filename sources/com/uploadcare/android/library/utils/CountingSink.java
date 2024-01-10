package com.uploadcare.android.library.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R-\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/uploadcare/android/library/utils/CountingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "onSinkUpdate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bytesWritten", "", "Lcom/uploadcare/android/library/utils/CountingSinkListener;", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "write", "source", "Lokio/Buffer;", "byteCount", "library_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: CountingRequestBody.kt */
public final class CountingSink extends ForwardingSink {
    private long bytesWritten;
    private final Function1<Long, Unit> onSinkUpdate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountingSink(Sink sink, Function1<? super Long, Unit> function1) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(function1, "onSinkUpdate");
        this.onSinkUpdate = function1;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        super.write(buffer, j);
        long j2 = this.bytesWritten + j;
        this.bytesWritten = j2;
        this.onSinkUpdate.invoke(Long.valueOf(j2));
    }
}
