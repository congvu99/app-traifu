package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptors.kt */
final class SerialDescriptorImpl$toString$1 extends Lambda implements Function1<Integer, CharSequence> {
    final /* synthetic */ SerialDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SerialDescriptorImpl$toString$1(SerialDescriptorImpl serialDescriptorImpl) {
        super(1);
        this.this$0 = serialDescriptorImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final CharSequence invoke(int i) {
        return this.this$0.getElementName(i) + ": " + this.this$0.getElementDescriptor(i).getSerialName();
    }
}
