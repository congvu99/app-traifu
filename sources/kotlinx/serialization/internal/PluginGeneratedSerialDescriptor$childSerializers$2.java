package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/KSerializer;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: PluginGeneratedSerialDescriptor.kt */
final class PluginGeneratedSerialDescriptor$childSerializers$2 extends Lambda implements Function0<KSerializer<?>[]> {
    final /* synthetic */ PluginGeneratedSerialDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PluginGeneratedSerialDescriptor$childSerializers$2(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        super(0);
        this.this$0 = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] invoke() {
        GeneratedSerializer access$getGeneratedSerializer$p = this.this$0.generatedSerializer;
        KSerializer<?>[] childSerializers = access$getGeneratedSerializer$p == null ? null : access$getGeneratedSerializer$p.childSerializers();
        return childSerializers == null ? new KSerializer[0] : childSerializers;
    }
}
