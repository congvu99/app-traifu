package kotlinx.serialization.json.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b3\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0014J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J)\u0010\u001f\u001a\u00020\b\"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\"2\u0006\u0010#\u001a\u0002H H\u0016¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0013H\u0014J\u0018\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020(H\u0014J\u0018\u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020*H\u0014J\u0018\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020,H\u0014J \u0010-\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0014J\u0018\u00101\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u000202H\u0014J\u0018\u00103\u001a\u0002042\u0006\u0010&\u001a\u00020\u00192\u0006\u00105\u001a\u00020\u0017H\u0014J\u0018\u00106\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u000200H\u0014J\u0018\u00107\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0019H\u0014J\u0018\u0010:\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020;H\u0014J\u0018\u0010<\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0019H\u0014J\u0018\u0010=\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010#\u001a\u00020>H\u0014J\u0010\u0010?\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010@\u001a\u00020\u0007H&J\u0018\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0007H&J\u0018\u0010C\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010D\u001a\u000200H\u0016R\u0010\u0010\n\u001a\u00020\u000b8\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000\u0001\u0003EFG¨\u0006H"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeEncoder;", "Lkotlinx/serialization/internal/NamedValueEncoder;", "Lkotlinx/serialization/json/JsonEncoder;", "json", "Lkotlinx/serialization/json/Json;", "nodeConsumer", "Lkotlin/Function1;", "Lkotlinx/serialization/json/JsonElement;", "", "(Lkotlinx/serialization/json/Json;Lkotlin/jvm/functions/Function1;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "writePolymorphic", "", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "encodeJsonElement", "element", "encodeNull", "encodeSerializableValue", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeTaggedBoolean", "tag", "encodeTaggedByte", "", "encodeTaggedChar", "", "encodeTaggedDouble", "", "encodeTaggedEnum", "enumDescriptor", "ordinal", "", "encodeTaggedFloat", "", "encodeTaggedInline", "Lkotlinx/serialization/encoding/Encoder;", "inlineDescriptor", "encodeTaggedInt", "encodeTaggedLong", "", "encodeTaggedNull", "encodeTaggedShort", "", "encodeTaggedString", "encodeTaggedValue", "", "endEncode", "getCurrent", "putElement", "key", "shouldEncodeElementDefault", "index", "Lkotlinx/serialization/json/internal/JsonPrimitiveEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeEncoder;", "Lkotlinx/serialization/json/internal/JsonTreeListEncoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
@ExperimentalSerializationApi
/* compiled from: TreeJsonEncoder.kt */
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final Function1<JsonElement, Unit> nodeConsumer;
    private boolean writePolymorphic;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json2, function1);
    }

    /* access modifiers changed from: protected */
    public String composeName(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        return str2;
    }

    public abstract JsonElement getCurrent();

    public abstract void putElement(String str, JsonElement jsonElement);

    public static final /* synthetic */ String access$getCurrentTag(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        return (String) abstractJsonTreeEncoder.getCurrentTag();
    }

    public final Json getJson() {
        return this.json;
    }

    private AbstractJsonTreeEncoder(Json json2, Function1<? super JsonElement, Unit> function1) {
        this.json = json2;
        this.nodeConsumer = function1;
        this.configuration = json2.getConfiguration();
    }

    public final SerializersModule getSerializersModule() {
        return this.json.getSerializersModule();
    }

    public void encodeJsonElement(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "element");
        encodeSerializableValue(JsonElementSerializer.INSTANCE, jsonElement);
    }

    public boolean shouldEncodeElementDefault(SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    public void encodeNull() {
        String str = (String) getCurrentTagOrNull();
        if (str == null) {
            this.nodeConsumer.invoke(JsonNull.INSTANCE);
        } else {
            encodeTaggedNull(str);
        }
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedNull(String str) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonNull.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Integer.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedByte(String str, byte b) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Byte.valueOf(b)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedShort(String str, short s) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Short.valueOf(s)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Long.valueOf(j)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedFloat(String str, float f) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Float.valueOf(f)));
        if (!this.configuration.getAllowSpecialFloatingPointValues()) {
            if (!(!Float.isInfinite(f) && !Float.isNaN(f))) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Float.valueOf(f), str, getCurrent().toString());
            }
        }
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        if (getCurrentTagOrNull() != null || (!(serializationStrategy.getDescriptor().getKind() instanceof PrimitiveKind) && serializationStrategy.getDescriptor().getKind() != SerialKind.ENUM.INSTANCE)) {
            JsonEncoder jsonEncoder = this;
            if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || jsonEncoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
                serializationStrategy.serialize(jsonEncoder, t);
            } else if (t != null) {
                SerializationStrategy access$findActualSerializer = PolymorphicKt.findActualSerializer(jsonEncoder, serializationStrategy, t);
                this.writePolymorphic = true;
                access$findActualSerializer.serialize(jsonEncoder, t);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
            }
        } else {
            JsonPrimitiveEncoder jsonPrimitiveEncoder = new JsonPrimitiveEncoder(this.json, this.nodeConsumer);
            jsonPrimitiveEncoder.encodeSerializableValue(serializationStrategy, t);
            jsonPrimitiveEncoder.endEncode(serializationStrategy.getDescriptor());
        }
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedDouble(String str, double d) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive((Number) Double.valueOf(d)));
        if (!this.configuration.getAllowSpecialFloatingPointValues()) {
            if (!(!Double.isInfinite(d) && !Double.isNaN(d))) {
                throw JsonExceptionsKt.InvalidFloatingPointEncoded(Double.valueOf(d), str, getCurrent().toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive(Boolean.valueOf(z)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedChar(String str, char c) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        putElement(str, JsonElementKt.JsonPrimitive(String.valueOf(c)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, "value");
        putElement(str, JsonElementKt.JsonPrimitive(str2));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedEnum(String str, SerialDescriptor serialDescriptor, int i) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        putElement(str, JsonElementKt.JsonPrimitive(serialDescriptor.getElementName(i)));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedValue(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(obj, "value");
        putElement(str, JsonElementKt.JsonPrimitive(obj.toString()));
    }

    /* access modifiers changed from: protected */
    public Encoder encodeTaggedInline(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new AbstractJsonTreeEncoder$encodeTaggedInline$1(this, str);
        }
        return super.encodeTaggedInline(str, serialDescriptor);
    }

    public CompositeEncoder beginStructure(SerialDescriptor serialDescriptor) {
        Function1<JsonElement, Unit> function1;
        AbstractJsonTreeEncoder abstractJsonTreeEncoder;
        AbstractJsonTreeEncoder abstractJsonTreeEncoder2;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (getCurrentTagOrNull() == null) {
            function1 = this.nodeConsumer;
        } else {
            function1 = new AbstractJsonTreeEncoder$beginStructure$consumer$1(this);
        }
        SerialKind kind = serialDescriptor.getKind();
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            abstractJsonTreeEncoder = new JsonTreeListEncoder(this.json, function1);
        } else if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.INSTANCE)) {
            Json json2 = this.json;
            SerialDescriptor carrierDescriptor = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), json2.getSerializersModule());
            SerialKind kind2 = carrierDescriptor.getKind();
            if ((kind2 instanceof PrimitiveKind) || Intrinsics.areEqual((Object) kind2, (Object) SerialKind.ENUM.INSTANCE)) {
                abstractJsonTreeEncoder2 = new JsonTreeMapEncoder(getJson(), function1);
            } else if (json2.getConfiguration().getAllowStructuredMapKeys()) {
                abstractJsonTreeEncoder2 = new JsonTreeListEncoder(getJson(), function1);
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(carrierDescriptor);
            }
            abstractJsonTreeEncoder = abstractJsonTreeEncoder2;
        } else {
            abstractJsonTreeEncoder = new JsonTreeEncoder(this.json, function1);
        }
        if (this.writePolymorphic) {
            this.writePolymorphic = false;
            abstractJsonTreeEncoder.putElement(this.configuration.getClassDiscriminator(), JsonElementKt.JsonPrimitive(serialDescriptor.getSerialName()));
        }
        return abstractJsonTreeEncoder;
    }

    /* access modifiers changed from: protected */
    public void endEncode(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.nodeConsumer.invoke(getCurrent());
    }
}
