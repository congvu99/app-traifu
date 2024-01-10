package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
final class PluginGeneratedSerialDescriptor$typeParameterDescriptors$2 extends Lambda implements Function0<SerialDescriptor[]> {
    final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.this$0 = pluginGeneratedSerialDescriptor;
    }

    public final SerialDescriptor[] invoke() {
        KSerializer[] typeParametersSerializers;
        GeneratedSerializer access$getGeneratedSerializer$p = this.this$0.generatedSerializer;
        List list = null;
        if (!(access$getGeneratedSerializer$p == null || (typeParametersSerializers = access$getGeneratedSerializer$p.typeParametersSerializers()) == null)) {
            Collection arrayList = new ArrayList(typeParametersSerializers.length);
            for (KSerializer descriptor : typeParametersSerializers) {
                arrayList.add(descriptor.getDescriptor());
            }
            list = (List) arrayList;
        }
        return Platform_commonKt.compactArray(list);
    }
}