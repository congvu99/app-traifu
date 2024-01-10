package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MediaFile.kt */
final class MediaFile$copyFileStream$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ FileCallback $callback;
    final /* synthetic */ long $srcSize;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaFile$copyFileStream$1(Ref.LongRef longRef, long j, Ref.IntRef intRef, FileCallback fileCallback) {
        super(0);
        this.$bytesMoved = longRef;
        this.$srcSize = j;
        this.$writeSpeed = intRef;
        this.$callback = fileCallback;
    }

    public final void invoke() {
        FileCallback.Report report = new FileCallback.Report((((float) this.$bytesMoved.element) * 100.0f) / ((float) this.$srcSize), this.$bytesMoved.element, this.$writeSpeed.element);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), (CoroutineStart) null, new MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1((Continuation) null, this.$callback, report), 2, (Object) null);
        this.$writeSpeed.element = 0;
    }
}
