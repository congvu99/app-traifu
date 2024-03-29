package kotlinx.serialization.json.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\fH\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "coerceInputValue", "", "index", "tag", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "elementName", "desc", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private final SerialDescriptor polyDescriptor;
    private final String polyDiscriminator;
    private int position;
    private final JsonObject value;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : serialDescriptor);
    }

    public JsonObject getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(json, jsonObject, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(jsonObject, "value");
        this.value = jsonObject;
        this.polyDiscriminator = str;
        this.polyDescriptor = serialDescriptor;
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor, int i, String str) {
        Json json = getJson();
        SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i);
        if (!elementDescriptor.isNullable() && (currentElement(str) instanceof JsonNull)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) elementDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE)) {
            JsonElement currentElement = currentElement(str);
            String str2 = null;
            JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
            if (jsonPrimitive != null) {
                str2 = JsonElementKt.getContentOrNull(jsonPrimitive);
            }
            if (str2 != null && JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json, str2) == -3) {
                return true;
            }
        }
        return false;
    }

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        while (this.position < serialDescriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String tag = getTag(serialDescriptor, i);
            if (getValue().containsKey(tag) && (!this.configuration.getCoerceInputValues() || !coerceInputValue(serialDescriptor, this.position - 1, tag))) {
                return this.position - 1;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public String elementName(SerialDescriptor serialDescriptor, int i) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        String elementName = serialDescriptor.getElementName(i);
        if (!this.configuration.getUseAlternativeNames() || getValue().keySet().contains(elementName)) {
            return elementName;
        }
        Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).getOrPut(serialDescriptor, JsonNamesMapKt.getJsonAlternativeNamesKey(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(serialDescriptor));
        Iterator it = getValue().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) map.get((String) obj);
            if (num != null && num.intValue() == i) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        String str = (String) obj;
        return str == null ? elementName : str;
    }

    /* access modifiers changed from: protected */
    public JsonElement currentElement(String str) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        return (JsonElement) MapsKt.getValue(getValue(), str);
    }

    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (serialDescriptor == this.polyDescriptor) {
            return this;
        }
        return super.beginStructure(serialDescriptor);
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Set<String> set;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        if (!this.configuration.getIgnoreUnknownKeys() && !(serialDescriptor.getKind() instanceof PolymorphicKind)) {
            if (!this.configuration.getUseAlternativeNames()) {
                set = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor);
            } else {
                Set jsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(serialDescriptor);
                Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).get(serialDescriptor, JsonNamesMapKt.getJsonAlternativeNamesKey());
                Set keySet = map == null ? null : map.keySet();
                if (keySet == null) {
                    keySet = SetsKt.emptySet();
                }
                set = SetsKt.plus(jsonCachedSerialNames, keySet);
            }
            for (String next : getValue().keySet()) {
                if (!set.contains(next) && !Intrinsics.areEqual((Object) next, (Object) this.polyDiscriminator)) {
                    throw JsonExceptionsKt.UnknownKeyException(next, getValue().toString());
                }
            }
        }
    }
}
