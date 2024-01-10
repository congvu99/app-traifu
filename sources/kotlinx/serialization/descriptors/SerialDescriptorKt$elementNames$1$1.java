package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", "", "", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SerialDescriptor.kt */
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {
    final /* synthetic */ SerialDescriptor $this_elementNames;
    private int elementsLeft = this.$this_elementNames.getElementsCount();

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    SerialDescriptorKt$elementNames$1$1(SerialDescriptor serialDescriptor) {
        this.$this_elementNames = serialDescriptor;
    }

    public boolean hasNext() {
        return this.elementsLeft > 0;
    }

    public String next() {
        SerialDescriptor serialDescriptor = this.$this_elementNames;
        int elementsCount = serialDescriptor.getElementsCount();
        int i = this.elementsLeft;
        this.elementsLeft = i - 1;
        return serialDescriptor.getElementName(elementsCount - i);
    }
}
