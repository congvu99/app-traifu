package com.uploadcare.android.library.upload;

import java.io.BufferedInputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* compiled from: UploadUtils.kt */
final class UploadUtils$Companion$chunkedSequence$2 extends Lambda implements Function0<byte[]> {
    final /* synthetic */ byte[] $buffer;
    final /* synthetic */ BufferedInputStream $input;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UploadUtils$Companion$chunkedSequence$2(BufferedInputStream bufferedInputStream, byte[] bArr) {
        super(0);
        this.$input = bufferedInputStream;
        this.$buffer = bArr;
    }

    public final byte[] invoke() {
        int read = this.$input.read(this.$buffer);
        if (read >= 0) {
            byte[] copyOf = Arrays.copyOf(this.$buffer, read);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            return copyOf;
        }
        this.$input.close();
        return null;
    }
}
