package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\rH\u0002J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\u001bH\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J!\u00107\u001a\u0002H8\"\u0004\b\u0000\u001082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H80:H\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020?H\u0002J\u0010\u0010A\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020?H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006D"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "lexer", "Lkotlinx/serialization/json/internal/JsonLexer;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/JsonLexer;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "currentIndex", "", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "checkLeadingComma", "", "coerceInputValue", "", "index", "decodeBoolean", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInt", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "decodeStringKey", "endStructure", "handleUnknown", "key", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: StreamingJsonDecoder.kt */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    private final JsonConfiguration configuration = this.json.getConfiguration();
    private int currentIndex = -1;
    private final Json json;
    public final JsonLexer lexer;
    private final WriteMode mode;
    private final SerializersModule serializersModule;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: StreamingJsonDecoder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            iArr[WriteMode.LIST.ordinal()] = 1;
            iArr[WriteMode.MAP.ordinal()] = 2;
            iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            iArr[WriteMode.OBJ.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Void decodeNull() {
        return null;
    }

    public final Json getJson() {
        return this.json;
    }

    public StreamingJsonDecoder(Json json2, WriteMode writeMode, JsonLexer jsonLexer) {
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(writeMode, "mode");
        Intrinsics.checkNotNullParameter(jsonLexer, "lexer");
        this.json = json2;
        this.mode = writeMode;
        this.lexer = jsonLexer;
        this.serializersModule = json2.getSerializersModule();
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        return PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializationStrategy);
    }

    public CompositeDecoder beginStructure(SerialDescriptor serialDescriptor) {
        StreamingJsonDecoder streamingJsonDecoder;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        WriteMode switchMode = WriteModeKt.switchMode(this.json, serialDescriptor);
        this.lexer.consumeNextToken(switchMode.begin);
        checkLeadingComma();
        int i = WhenMappings.$EnumSwitchMapping$0[switchMode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new StreamingJsonDecoder(this.json, switchMode, this.lexer);
        }
        if (this.mode == switchMode) {
            streamingJsonDecoder = this;
        } else {
            streamingJsonDecoder = new StreamingJsonDecoder(this.json, switchMode, this.lexer);
        }
        return streamingJsonDecoder;
    }

    public void endStructure(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        this.lexer.consumeNextToken(this.mode.end);
    }

    public boolean decodeNotNullMark() {
        return this.lexer.tryConsumeNotNull();
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() == 4) {
            JsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int decodeElementIndex(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 2) {
            return decodeMapIndex();
        }
        if (i != 4) {
            return decodeListIndex();
        }
        return decodeObjectIndex(serialDescriptor);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int decodeMapIndex() {
        /*
            r7 = this;
            int r0 = r7.currentIndex
            r1 = 2
            int r0 = r0 % r1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            r4 = -1
            if (r0 == 0) goto L_0x0019
            int r5 = r7.currentIndex
            if (r5 == r4) goto L_0x0020
            kotlinx.serialization.json.internal.JsonLexer r5 = r7.lexer
            boolean r5 = r5.tryConsumeComma()
            goto L_0x0021
        L_0x0019:
            kotlinx.serialization.json.internal.JsonLexer r5 = r7.lexer
            r6 = 58
            r5.consumeNextToken((char) r6)
        L_0x0020:
            r5 = 0
        L_0x0021:
            kotlinx.serialization.json.internal.JsonLexer r6 = r7.lexer
            boolean r6 = r6.canConsumeValue()
            if (r6 == 0) goto L_0x005c
            if (r0 == 0) goto L_0x0055
            int r0 = r7.currentIndex
            if (r0 != r4) goto L_0x0043
            kotlinx.serialization.json.internal.JsonLexer r0 = r7.lexer
            r1 = r5 ^ 1
            int r3 = r0.currentPosition
            if (r1 == 0) goto L_0x0038
            goto L_0x0055
        L_0x0038:
            java.lang.String r1 = "Unexpected trailing comma"
            r0.fail(r1, r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0043:
            kotlinx.serialization.json.internal.JsonLexer r0 = r7.lexer
            int r1 = r0.currentPosition
            if (r5 == 0) goto L_0x004a
            goto L_0x0055
        L_0x004a:
            java.lang.String r2 = "Expected comma after the key-value pair"
            r0.fail(r2, r1)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0055:
            int r0 = r7.currentIndex
            int r4 = r0 + 1
            r7.currentIndex = r4
            goto L_0x005e
        L_0x005c:
            if (r5 != 0) goto L_0x005f
        L_0x005e:
            return r4
        L_0x005f:
            kotlinx.serialization.json.internal.JsonLexer r0 = r7.lexer
            r2 = 0
            java.lang.String r4 = "Expected '}', but had ',' instead"
            kotlinx.serialization.json.internal.JsonLexer.fail$default(r0, r4, r3, r1, r2)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeMapIndex():int");
    }

    private final boolean coerceInputValue(SerialDescriptor serialDescriptor, int i) {
        String peekString;
        Json json2 = this.json;
        SerialDescriptor elementDescriptor = serialDescriptor.getElementDescriptor(i);
        if (elementDescriptor.isNullable() || !(!this.lexer.tryConsumeNotNull())) {
            if (!Intrinsics.areEqual((Object) elementDescriptor.getKind(), (Object) SerialKind.ENUM.INSTANCE) || (peekString = this.lexer.peekString(this.configuration.isLenient())) == null || JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json2, peekString) != -3) {
                return false;
            }
            this.lexer.consumeString();
        }
        return true;
    }

    private final int decodeObjectIndex(SerialDescriptor serialDescriptor) {
        int jsonNameIndex;
        boolean z;
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        while (true) {
            boolean z2 = false;
            if (this.lexer.canConsumeValue()) {
                String decodeStringKey = decodeStringKey();
                this.lexer.consumeNextToken((char) JsonLexerKt.COLON);
                jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(serialDescriptor, this.json, decodeStringKey);
                if (jsonNameIndex == -3) {
                    z = false;
                    z2 = true;
                } else if (!this.configuration.getCoerceInputValues() || !coerceInputValue(serialDescriptor, jsonNameIndex)) {
                    return jsonNameIndex;
                } else {
                    z = this.lexer.tryConsumeComma();
                }
                tryConsumeComma = z2 ? handleUnknown(decodeStringKey) : z;
            } else if (!tryConsumeComma) {
                return -1;
            } else {
                JsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return jsonNameIndex;
    }

    private final boolean handleUnknown(String str) {
        if (this.configuration.getIgnoreUnknownKeys()) {
            this.lexer.skipElement(this.configuration.isLenient());
        } else {
            this.lexer.failOnUnknownKey(str);
        }
        return this.lexer.tryConsumeComma();
    }

    private final int decodeListIndex() {
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            if (this.currentIndex == -1 || tryConsumeComma) {
                int i = this.currentIndex + 1;
                this.currentIndex = i;
                return i;
            }
            JsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!tryConsumeComma) {
            return -1;
        } else {
            JsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public boolean decodeBoolean() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeBooleanLenient();
        }
        return this.lexer.consumeBoolean();
    }

    public byte decodeByte() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        byte b = (byte) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) b)) {
            return b;
        }
        JsonLexer jsonLexer = this.lexer;
        JsonLexer.fail$default(jsonLexer, "Failed to parse byte for input '" + consumeNumericLiteral + '\'', 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public short decodeShort() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        short s = (short) ((int) consumeNumericLiteral);
        if (consumeNumericLiteral == ((long) s)) {
            return s;
        }
        JsonLexer jsonLexer = this.lexer;
        JsonLexer.fail$default(jsonLexer, "Failed to parse short for input '" + consumeNumericLiteral + '\'', 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public int decodeInt() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        int i = (int) consumeNumericLiteral;
        if (consumeNumericLiteral == ((long) i)) {
            return i;
        }
        JsonLexer jsonLexer = this.lexer;
        JsonLexer.fail$default(jsonLexer, "Failed to parse int for input '" + consumeNumericLiteral + '\'', 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    public float decodeFloat() {
        JsonLexer jsonLexer = this.lexer;
        String consumeStringLenient = jsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            float parseFloat = Float.parseFloat(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z = true;
                }
                if (!z) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            JsonLexer.fail$default(jsonLexer, "Failed to parse type '" + "float" + "' for input '" + consumeStringLenient + '\'', 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public double decodeDouble() {
        JsonLexer jsonLexer = this.lexer;
        String consumeStringLenient = jsonLexer.consumeStringLenient();
        boolean z = false;
        try {
            double parseDouble = Double.parseDouble(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z = true;
                }
                if (!z) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            JsonLexer.fail$default(jsonLexer, "Failed to parse type '" + "double" + "' for input '" + consumeStringLenient + '\'', 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public char decodeChar() {
        String consumeStringLenient = this.lexer.consumeStringLenient();
        if (consumeStringLenient.length() == 1) {
            return consumeStringLenient.charAt(0);
        }
        JsonLexer jsonLexer = this.lexer;
        JsonLexer.fail$default(jsonLexer, "Expected single char, but got '" + consumeStringLenient + '\'', 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String decodeStringKey() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    public String decodeString() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    public Decoder decodeInline(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(this.lexer, this.json);
        }
        return super.decodeInline(serialDescriptor);
    }

    public int decodeEnum(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(serialDescriptor, this.json, decodeString());
    }
}
