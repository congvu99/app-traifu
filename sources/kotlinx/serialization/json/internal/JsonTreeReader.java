package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeReader;", "", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "lexer", "Lkotlinx/serialization/json/internal/JsonLexer;", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/JsonLexer;)V", "isLenient", "", "read", "Lkotlinx/serialization/json/JsonElement;", "readArray", "readObject", "readValue", "Lkotlinx/serialization/json/JsonPrimitive;", "isString", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonTreeReader.kt */
public final class JsonTreeReader {
    private final boolean isLenient;
    private final JsonLexer lexer;

    public JsonTreeReader(JsonConfiguration jsonConfiguration, JsonLexer jsonLexer) {
        Intrinsics.checkNotNullParameter(jsonConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(jsonLexer, "lexer");
        this.lexer = jsonLexer;
        this.isLenient = jsonConfiguration.isLenient();
    }

    private final JsonElement readObject() {
        byte consumeNextToken = this.lexer.consumeNextToken((byte) 6);
        if (this.lexer.peekNextToken() != 4) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (this.lexer.canConsumeValue()) {
                String consumeStringLenient = this.isLenient ? this.lexer.consumeStringLenient() : this.lexer.consumeString();
                this.lexer.consumeNextToken((byte) 5);
                linkedHashMap.put(consumeStringLenient, read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4 && consumeNextToken != 7) {
                    JsonLexer.fail$default(this.lexer, "Expected end of the object or comma", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            if (consumeNextToken == 6) {
                this.lexer.consumeNextToken((byte) 7);
            } else if (consumeNextToken == 4) {
                JsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonObject(linkedHashMap);
        }
        JsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final JsonElement readArray() {
        byte consumeNextToken = this.lexer.consumeNextToken();
        if (this.lexer.peekNextToken() != 4) {
            ArrayList arrayList = new ArrayList();
            while (this.lexer.canConsumeValue()) {
                arrayList.add(read());
                consumeNextToken = this.lexer.consumeNextToken();
                if (consumeNextToken != 4) {
                    JsonLexer jsonLexer = this.lexer;
                    boolean z = consumeNextToken == 9;
                    int i = jsonLexer.currentPosition;
                    if (!z) {
                        jsonLexer.fail("Expected end of the array or comma", i);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (consumeNextToken == 8) {
                this.lexer.consumeNextToken((byte) 9);
            } else if (consumeNextToken == 4) {
                JsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            return new JsonArray(arrayList);
        }
        JsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final JsonPrimitive readValue(boolean z) {
        String str;
        if (this.isLenient || !z) {
            str = this.lexer.consumeStringLenient();
        } else {
            str = this.lexer.consumeString();
        }
        if (z || !Intrinsics.areEqual((Object) str, (Object) JsonLexerKt.NULL)) {
            return new JsonLiteral(str, z);
        }
        return JsonNull.INSTANCE;
    }

    public final JsonElement read() {
        byte peekNextToken = this.lexer.peekNextToken();
        if (peekNextToken == 1) {
            return readValue(true);
        }
        if (peekNextToken == 0) {
            return readValue(false);
        }
        if (peekNextToken == 6) {
            return readObject();
        }
        if (peekNextToken == 8) {
            return readArray();
        }
        JsonLexer.fail$default(this.lexer, "Can't begin reading element, unexpected token", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }
}
