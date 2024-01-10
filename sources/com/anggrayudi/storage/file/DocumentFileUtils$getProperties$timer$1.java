package com.anggrayudi.storage.file;

import com.anggrayudi.storage.file.FileProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentFileExt.kt */
final class DocumentFileUtils$getProperties$timer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FileProperties.CalculationCallback $callback;
    final /* synthetic */ FileProperties $properties;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUtils$getProperties$timer$1(FileProperties.CalculationCallback calculationCallback, FileProperties fileProperties) {
        super(0);
        this.$callback = calculationCallback;
        this.$properties = fileProperties;
    }

    public final void invoke() {
        CoroutineScope uiScope = this.$callback.getUiScope();
        FileProperties.CalculationCallback calculationCallback = this.$callback;
        FileProperties fileProperties = this.$properties;
        Job unused = BuildersKt__Builders_commonKt.launch$default(uiScope, Dispatchers.getMain(), (CoroutineStart) null, new DocumentFileUtils$getProperties$timer$1$invoke$$inlined$postToUi$1((Continuation) null, calculationCallback, fileProperties), 2, (Object) null);
    }
}
