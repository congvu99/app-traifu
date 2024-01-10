package androidx.constraintlayout.core.parser;

import com.facebook.internal.ServerProtocol;
import kotlinx.serialization.json.internal.JsonLexerKt;

public class CLToken extends CLElement {
    int index = 0;
    char[] tokenFalse = "false".toCharArray();
    char[] tokenNull = JsonLexerKt.NULL.toCharArray();
    char[] tokenTrue = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.toCharArray();
    Type type = Type.UNKNOWN;

    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public boolean getBoolean() throws CLParsingException {
        if (this.type == Type.TRUE) {
            return true;
        }
        if (this.type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public boolean isNull() throws CLParsingException {
        if (this.type == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    public CLToken(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    /* access modifiers changed from: protected */
    public String toJSON() {
        if (!CLParser.DEBUG) {
            return content();
        }
        return "<" + content() + ">";
    }

    /* access modifiers changed from: protected */
    public String toFormattedJSON(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    public Type getType() {
        return this.type;
    }

    /* renamed from: androidx.constraintlayout.core.parser.CLToken$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.parser.CLToken$Type[] r0 = androidx.constraintlayout.core.parser.CLToken.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type = r0
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.TRUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.FALSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.parser.CLToken$Type r1 = androidx.constraintlayout.core.parser.CLToken.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.parser.CLToken.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean validate(char c, long j) {
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$parser$CLToken$Type[this.type.ordinal()];
        boolean z = false;
        if (i == 1) {
            if (this.tokenTrue[this.index] == c) {
                z = true;
            }
            if (z && this.index + 1 == this.tokenTrue.length) {
                setEnd(j);
            }
        } else if (i == 2) {
            if (this.tokenFalse[this.index] == c) {
                z = true;
            }
            if (z && this.index + 1 == this.tokenFalse.length) {
                setEnd(j);
            }
        } else if (i == 3) {
            if (this.tokenNull[this.index] == c) {
                z = true;
            }
            if (z && this.index + 1 == this.tokenNull.length) {
                setEnd(j);
            }
        } else if (i == 4) {
            char[] cArr = this.tokenTrue;
            int i2 = this.index;
            if (cArr[i2] == c) {
                this.type = Type.TRUE;
            } else if (this.tokenFalse[i2] == c) {
                this.type = Type.FALSE;
            } else if (this.tokenNull[i2] == c) {
                this.type = Type.NULL;
            }
            z = true;
        }
        this.index++;
        return z;
    }
}
