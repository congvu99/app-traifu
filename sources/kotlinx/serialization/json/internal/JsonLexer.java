package kotlinx.serialization.json.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0006\u0010\u001a\u001a\u00020\u0017J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0003J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020\u0003J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010(\u001a\u00020\u0013J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001fH\u0002J\u0018\u0010)\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\u0003J\u0018\u00100\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020!H\u0002J\u0006\u00103\u001a\u00020\u001fJ\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0017J1\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000308H\bø\u0001\u0000¢\u0006\u0002\b9J\u000e\u0010:\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0017J\b\u0010<\u001a\u00020\u0006H\u0002J\b\u0010=\u001a\u00020\u0003H\u0002J\b\u0010>\u001a\u00020\u0003H\u0016J\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020\u0017J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bj\u0002`\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006B"}, d2 = {"Lkotlinx/serialization/json/internal/JsonLexer;", "", "source", "", "(Ljava/lang/String;)V", "currentPosition", "", "escapedString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "peekedString", "appendEsc", "startPosition", "appendEscape", "lastPosition", "current", "appendHex", "startPos", "appendRange", "", "fromIndex", "toIndex", "canConsumeValue", "", "consumeBoolean", "start", "consumeBooleanLenient", "consumeBooleanLiteral", "literalSuffix", "consumeKeyString", "consumeNextToken", "", "expected", "", "consumeNumericLiteral", "", "consumeString", "consumeStringLenient", "consumeStringLenientNotNull", "decodedString", "expectEof", "fail", "expectedToken", "", "message", "position", "failOnUnknownKey", "key", "fromHexChar", "isValidValueStart", "c", "peekNextToken", "peekString", "isLenient", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_json", "skipElement", "allowLenientStrings", "skipWhitespaces", "takePeeked", "toString", "tryConsumeComma", "tryConsumeNotNull", "unexpectedToken", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonLexer.kt */
public final class JsonLexer {
    public int currentPosition;
    private StringBuilder escapedString = new StringBuilder();
    private String peekedString;
    private final String source;

    private final boolean isValidValueStart(char c) {
        boolean z = false;
        if (((c == '}' || c == ']') || c == ':') || c == ',') {
            z = true;
        }
        return !z;
    }

    public JsonLexer(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
    }

    public final void expectEof() {
        if (consumeNextToken() != 10) {
            fail$default(this, "Expected EOF, but had " + this.source.charAt(this.currentPosition - 1) + " instead", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public final boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == this.source.length() || this.source.charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    public final boolean canConsumeValue() {
        int i = this.currentPosition;
        while (i < this.source.length()) {
            char charAt = this.source.charAt(i);
            if (charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9) {
                i++;
            } else {
                this.currentPosition = i;
                return isValidValueStart(charAt);
            }
        }
        this.currentPosition = i;
        return false;
    }

    public final byte consumeNextToken(byte b) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken != b) {
            fail(b);
        }
        return consumeNextToken;
    }

    public final void consumeNextToken(char c) {
        String str = this.source;
        while (this.currentPosition < str.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            char charAt = str.charAt(i);
            if (!(charAt == ' ' || charAt == 10 || charAt == 13 || charAt == 9)) {
                if (charAt != c) {
                    unexpectedToken(c);
                } else {
                    return;
                }
            }
        }
        unexpectedToken(c);
    }

    private final void unexpectedToken(char c) {
        this.currentPosition--;
        if (c != '\"' || !Intrinsics.areEqual((Object) consumeStringLenient(), (Object) JsonLexerKt.NULL)) {
            fail(JsonLexerKt.charToTokenClass(c));
        } else {
            fail("Expected string literal but 'null' literal was found.\nUse 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.", this.currentPosition - 4);
            throw new KotlinNothingValueException();
        }
    }

    private final void fail(byte b) {
        int i;
        String str = b == 1 ? "quotation mark '\"'" : b == 4 ? "comma ','" : b == 5 ? "semicolon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : "valid token";
        String valueOf = (this.currentPosition == this.source.length() || (i = this.currentPosition) <= 0) ? "EOF" : String.valueOf(this.source.charAt(i - 1));
        fail("Expected " + str + ", but had '" + valueOf + "' instead", this.currentPosition - 1);
        throw new KotlinNothingValueException();
    }

    public final byte peekNextToken() {
        String str = this.source;
        while (this.currentPosition < str.length()) {
            char charAt = str.charAt(this.currentPosition);
            if (charAt != ' ' && charAt != 10 && charAt != 13 && charAt != 9) {
                return JsonLexerKt.charToTokenClass(charAt);
            }
            this.currentPosition++;
        }
        return 10;
    }

    public final byte consumeNextToken() {
        String str = this.source;
        while (this.currentPosition < str.length()) {
            int i = this.currentPosition;
            this.currentPosition = i + 1;
            byte charToTokenClass = JsonLexerKt.charToTokenClass(str.charAt(i));
            if (charToTokenClass != 3) {
                return charToTokenClass;
            }
        }
        return 10;
    }

    public final boolean tryConsumeNotNull() {
        int skipWhitespaces = skipWhitespaces();
        int length = this.source.length() - skipWhitespaces;
        if (length < 4) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (JsonLexerKt.NULL.charAt(i) != this.source.charAt(i + skipWhitespaces)) {
                return true;
            }
            if (i2 <= 3) {
                i = i2;
            } else if (length > 4 && JsonLexerKt.charToTokenClass(this.source.charAt(skipWhitespaces + 4)) == 0) {
                return true;
            } else {
                this.currentPosition = skipWhitespaces + 4;
                return false;
            }
        }
    }

    private final int skipWhitespaces() {
        int i = this.currentPosition;
        while (i < this.source.length() && ((r1 = this.source.charAt(i)) == ' ' || r1 == 10 || r1 == 13 || r1 == 9)) {
            i++;
        }
        this.currentPosition = i;
        return i;
    }

    public final String peekString(boolean z) {
        String str;
        byte peekNextToken = peekNextToken();
        if (z) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            str = consumeStringLenient();
        } else if (peekNextToken != 1) {
            return null;
        } else {
            str = consumeString();
        }
        this.peekedString = str;
        return str;
    }

    public final String consumeKeyString() {
        consumeNextToken('\"');
        int i = this.currentPosition;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.source, '\"', i, false, 4, (Object) null);
        if (indexOf$default == -1) {
            fail((byte) 1);
        }
        if (i < indexOf$default) {
            int i2 = i;
            while (true) {
                int i3 = i2 + 1;
                if (this.source.charAt(i2) == '\\') {
                    return consumeString(this.currentPosition, i2);
                }
                if (i3 >= indexOf$default) {
                    break;
                }
                i2 = i3;
            }
        }
        this.currentPosition = indexOf$default + 1;
        String str = this.source;
        if (str != null) {
            String substring = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    private final String consumeString(int i, int i2) {
        String str;
        String str2 = this.source;
        char charAt = str2.charAt(i2);
        int i3 = i;
        while (charAt != '\"') {
            if (charAt == '\\') {
                i3 = appendEscape(i3, i2);
                i2 = i3;
            } else {
                i2++;
                if (i2 >= str2.length()) {
                    fail("EOF", i2);
                    throw new KotlinNothingValueException();
                }
            }
            charAt = str2.charAt(i2);
        }
        if (i3 != i) {
            str = decodedString(i3, i2);
        } else if (str2 != null) {
            str = str2.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        this.currentPosition = i2 + 1;
        return str;
    }

    private final int appendEscape(int i, int i2) {
        this.escapedString.append(this.source, i, i2);
        return appendEsc(i2 + 1);
    }

    private final String decodedString(int i, int i2) {
        appendRange(i, i2);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "escapedString.toString()");
        this.escapedString.setLength(0);
        return sb;
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual((Object) consumeStringLenient, (Object) JsonLexerKt.NULL)) {
            return consumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final String consumeStringLenient() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces < this.source.length()) {
            byte charToTokenClass = JsonLexerKt.charToTokenClass(this.source.charAt(skipWhitespaces));
            if (charToTokenClass == 1) {
                return consumeString();
            }
            if (charToTokenClass == 0) {
                while (skipWhitespaces < this.source.length() && JsonLexerKt.charToTokenClass(this.source.charAt(skipWhitespaces)) == 0) {
                    skipWhitespaces++;
                }
                String str = this.source;
                int i = this.currentPosition;
                if (str != null) {
                    String substring = str.substring(i, skipWhitespaces);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    this.currentPosition = skipWhitespaces;
                    return substring;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            fail$default(this, Intrinsics.stringPlus("Expected beginning of the string, but got ", Character.valueOf(this.source.charAt(skipWhitespaces))), 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        fail("EOF", skipWhitespaces);
        throw new KotlinNothingValueException();
    }

    private final void appendRange(int i, int i2) {
        this.escapedString.append(this.source, i, i2);
    }

    private final int appendEsc(int i) {
        int i2 = i + 1;
        char charAt = this.source.charAt(i);
        if (charAt == 'u') {
            return appendHex(this.source, i2);
        }
        char escapeToChar = JsonLexerKt.escapeToChar(charAt);
        if (escapeToChar != 0) {
            this.escapedString.append(escapeToChar);
            return i2;
        }
        fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final int appendHex(String str, int i) {
        int i2 = i + 4;
        if (i2 < str.length()) {
            this.escapedString.append((char) ((fromHexChar(str, i) << 12) + (fromHexChar(str, i + 1) << 8) + (fromHexChar(str, i + 2) << 4) + fromHexChar(str, i + 3)));
            return i2;
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final int fromHexChar(String str, int i) {
        char charAt = str.charAt(i);
        boolean z = true;
        if ('0' <= charAt && charAt <= '9') {
            return charAt - '0';
        }
        char c = 'a';
        if (!('a' <= charAt && charAt <= 'f')) {
            c = 'A';
            if ('A' > charAt || charAt > 'F') {
                z = false;
            }
            if (!z) {
                fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        }
        return (charAt - c) + 10;
    }

    public final void skipElement(boolean z) {
        List arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken == 8 || peekNextToken == 6) {
            while (true) {
                byte peekNextToken2 = peekNextToken();
                boolean z2 = true;
                if (peekNextToken2 != 1) {
                    if (!(peekNextToken2 == 8 || peekNextToken2 == 6)) {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(Byte.valueOf(peekNextToken2));
                    } else if (peekNextToken2 == 9) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 8) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of }", this.source);
                        }
                    } else if (peekNextToken2 == 7) {
                        if (((Number) CollectionsKt.last(arrayList)).byteValue() == 6) {
                            CollectionsKt.removeLast(arrayList);
                        } else {
                            throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ]", this.source);
                        }
                    } else if (peekNextToken2 == 10) {
                        fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                    consumeNextToken();
                    if (arrayList.size() == 0) {
                        return;
                    }
                } else if (z) {
                    consumeStringLenient();
                } else {
                    consumeKeyString();
                }
            }
        } else {
            consumeStringLenient();
        }
    }

    public String toString() {
        return "JsonReader(source='" + this.source + "', currentPosition=" + this.currentPosition + ')';
    }

    public final void failOnUnknownKey(String str) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_KEY);
        String str2 = this.source;
        int i = this.currentPosition;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str2.substring(0, i);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring, str, 0, false, 6, (Object) null);
        fail("Encountered an unknown key '" + str + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.", lastIndexOf$default);
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void fail$default(JsonLexer jsonLexer, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = jsonLexer.currentPosition;
        }
        return jsonLexer.fail(str, i);
    }

    public final Void fail(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        throw JsonExceptionsKt.JsonDecodingException(i, str, this.source);
    }

    public static /* synthetic */ void require$kotlinx_serialization_json$default(JsonLexer jsonLexer, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = jsonLexer.currentPosition;
        }
        Intrinsics.checkNotNullParameter(function0, "message");
        if (!z) {
            jsonLexer.fail((String) function0.invoke(), i);
            throw new KotlinNothingValueException();
        }
    }

    public final void require$kotlinx_serialization_json(boolean z, int i, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "message");
        if (!z) {
            fail(function0.invoke(), i);
            throw new KotlinNothingValueException();
        }
    }

    public final long consumeNumericLiteral() {
        boolean z;
        int skipWhitespaces = skipWhitespaces();
        Object obj = null;
        int i = 2;
        if (skipWhitespaces != this.source.length()) {
            if (this.source.charAt(skipWhitespaces) == '\"') {
                skipWhitespaces++;
                if (skipWhitespaces != this.source.length()) {
                    z = true;
                } else {
                    fail$default(this, "EOF", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            } else {
                z = false;
            }
            int i2 = skipWhitespaces;
            boolean z2 = true;
            boolean z3 = false;
            long j = 0;
            while (z2) {
                char charAt = this.source.charAt(i2);
                if (charAt == '-') {
                    if (i2 == skipWhitespaces) {
                        i2++;
                        z3 = true;
                    } else {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, i, obj);
                        throw new KotlinNothingValueException();
                    }
                } else if (JsonLexerKt.charToTokenClass(charAt) != 0) {
                    break;
                } else {
                    i2++;
                    z2 = i2 != this.source.length();
                    int i3 = charAt - '0';
                    if (i3 >= 0 && i3 <= 9) {
                        j = (j * ((long) 10)) - ((long) i3);
                        if (j <= 0) {
                            obj = null;
                            i = 2;
                        } else {
                            fail$default(this, "Numeric value overflow", 0, 2, (Object) null);
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            if (skipWhitespaces == i2 || (z3 && skipWhitespaces == i2 - 1)) {
                fail$default(this, "Expected numeric literal", 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
            if (z) {
                if (!z2) {
                    fail$default(this, "EOF", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (this.source.charAt(i2) == '\"') {
                    i2++;
                } else {
                    fail$default(this, "Expected closing quotation mark", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            this.currentPosition = i2;
            if (z3) {
                return j;
            }
            if (j != Long.MIN_VALUE) {
                return -j;
            }
            fail$default(this, "Numeric value overflow", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
        fail$default(this, "EOF", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    public final boolean consumeBoolean() {
        return consumeBoolean(skipWhitespaces());
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces != this.source.length()) {
            if (this.source.charAt(skipWhitespaces) == '\"') {
                skipWhitespaces++;
                z = true;
            } else {
                z = false;
            }
            boolean consumeBoolean = consumeBoolean(skipWhitespaces);
            if (z) {
                if (this.currentPosition == this.source.length()) {
                    fail$default(this, "EOF", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                } else if (this.source.charAt(this.currentPosition) == '\"') {
                    this.currentPosition++;
                } else {
                    fail$default(this, "Expected closing quotation mark", 0, 2, (Object) null);
                    throw new KotlinNothingValueException();
                }
            }
            return consumeBoolean;
        }
        fail$default(this, "EOF", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final boolean consumeBoolean(int i) {
        if (i != this.source.length()) {
            int i2 = i + 1;
            char charAt = this.source.charAt(i) | TokenParser.SP;
            if (charAt == 't') {
                consumeBooleanLiteral("rue", i2);
                return true;
            } else if (charAt == 'f') {
                consumeBooleanLiteral("alse", i2);
                return false;
            } else {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, 2, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else {
            fail$default(this, "EOF", 0, 2, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final void consumeBooleanLiteral(String str, int i) {
        if (this.source.length() - i >= str.length()) {
            int length = str.length() - 1;
            if (length >= 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (str.charAt(i2) != (this.source.charAt(i2 + i) | TokenParser.SP)) {
                        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, 2, (Object) null);
                        throw new KotlinNothingValueException();
                    } else if (i3 > length) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
            this.currentPosition = i + str.length();
            return;
        }
        fail$default(this, "Unexpected end of boolean literal", 0, 2, (Object) null);
        throw new KotlinNothingValueException();
    }
}
