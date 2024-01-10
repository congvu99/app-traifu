package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.apache.http.message.TokenParser;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0016H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0017H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0018H\u0016J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", "", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "<set-?>", "", "writingFirst", "getWritingFirst", "()Z", "indent", "", "nextItem", "print", "v", "", "", "", "", "", "", "", "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Composers.kt */
public class Composer {
    public final Json json;
    private int level;
    public final JsonStringBuilder sb;
    private boolean writingFirst = true;

    public Composer(JsonStringBuilder jsonStringBuilder, Json json2) {
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        Intrinsics.checkNotNullParameter(json2, "json");
        this.sb = jsonStringBuilder;
        this.json = json2;
    }

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public final void indent() {
        this.writingFirst = true;
        this.level++;
    }

    public final void unIndent() {
        this.level--;
    }

    public final void nextItem() {
        this.writingFirst = false;
        if (this.json.getConfiguration().getPrettyPrint()) {
            print(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            int i = this.level;
            for (int i2 = 0; i2 < i; i2++) {
                print(this.json.getConfiguration().getPrettyPrintIndent());
            }
        }
    }

    public final void space() {
        if (this.json.getConfiguration().getPrettyPrint()) {
            print((char) TokenParser.SP);
        }
    }

    public final void print(char c) {
        this.sb.append(c);
    }

    public final void print(String str) {
        Intrinsics.checkNotNullParameter(str, "v");
        this.sb.append(str);
    }

    public void print(float f) {
        this.sb.append(String.valueOf(f));
    }

    public void print(double d) {
        this.sb.append(String.valueOf(d));
    }

    public void print(byte b) {
        this.sb.append((long) b);
    }

    public void print(short s) {
        this.sb.append((long) s);
    }

    public void print(int i) {
        this.sb.append((long) i);
    }

    public void print(long j) {
        this.sb.append(j);
    }

    public void print(boolean z) {
        this.sb.append(String.valueOf(z));
    }

    public final void printQuoted(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.sb.appendQuoted(str);
    }
}
