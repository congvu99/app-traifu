package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/MappedKeys;", "", "()V", "A", "Landroidx/compose/ui/input/key/Key;", "getA-EK5gGoQ", "()J", "J", "Backslash", "getBackslash-EK5gGoQ", "Backspace", "getBackspace-EK5gGoQ", "C", "getC-EK5gGoQ", "Cut", "getCut-EK5gGoQ", "Delete", "getDelete-EK5gGoQ", "DirectionDown", "getDirectionDown-EK5gGoQ", "DirectionLeft", "getDirectionLeft-EK5gGoQ", "DirectionRight", "getDirectionRight-EK5gGoQ", "DirectionUp", "getDirectionUp-EK5gGoQ", "Enter", "getEnter-EK5gGoQ", "H", "getH-EK5gGoQ", "Insert", "getInsert-EK5gGoQ", "MoveEnd", "getMoveEnd-EK5gGoQ", "MoveHome", "getMoveHome-EK5gGoQ", "PageDown", "getPageDown-EK5gGoQ", "PageUp", "getPageUp-EK5gGoQ", "Paste", "getPaste-EK5gGoQ", "Tab", "getTab-EK5gGoQ", "V", "getV-EK5gGoQ", "X", "getX-EK5gGoQ", "Z", "getZ-EK5gGoQ", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeyMapping.android.kt */
public final class MappedKeys {
    private static final long A = Key_androidKt.Key(29);
    private static final long Backslash = Key_androidKt.Key(73);
    private static final long Backspace = Key_androidKt.Key(67);
    private static final long C = Key_androidKt.Key(31);
    private static final long Cut = Key_androidKt.Key(277);
    private static final long Delete = Key_androidKt.Key(112);
    private static final long DirectionDown = Key_androidKt.Key(20);
    private static final long DirectionLeft = Key_androidKt.Key(21);
    private static final long DirectionRight = Key_androidKt.Key(22);
    private static final long DirectionUp = Key_androidKt.Key(19);
    private static final long Enter = Key_androidKt.Key(66);
    private static final long H = Key_androidKt.Key(36);
    public static final MappedKeys INSTANCE = new MappedKeys();
    private static final long Insert = Key_androidKt.Key(124);
    private static final long MoveEnd = Key_androidKt.Key(123);
    private static final long MoveHome = Key_androidKt.Key(122);
    private static final long PageDown = Key_androidKt.Key(93);
    private static final long PageUp = Key_androidKt.Key(92);
    private static final long Paste = Key_androidKt.Key(279);
    private static final long Tab = Key_androidKt.Key(61);
    private static final long V = Key_androidKt.Key(50);
    private static final long X = Key_androidKt.Key(52);
    private static final long Z = Key_androidKt.Key(54);

    private MappedKeys() {
    }

    /* renamed from: getA-EK5gGoQ  reason: not valid java name */
    public final long m900getAEK5gGoQ() {
        return A;
    }

    /* renamed from: getC-EK5gGoQ  reason: not valid java name */
    public final long m903getCEK5gGoQ() {
        return C;
    }

    /* renamed from: getH-EK5gGoQ  reason: not valid java name */
    public final long m911getHEK5gGoQ() {
        return H;
    }

    /* renamed from: getV-EK5gGoQ  reason: not valid java name */
    public final long m919getVEK5gGoQ() {
        return V;
    }

    /* renamed from: getX-EK5gGoQ  reason: not valid java name */
    public final long m920getXEK5gGoQ() {
        return X;
    }

    /* renamed from: getZ-EK5gGoQ  reason: not valid java name */
    public final long m921getZEK5gGoQ() {
        return Z;
    }

    /* renamed from: getBackslash-EK5gGoQ  reason: not valid java name */
    public final long m901getBackslashEK5gGoQ() {
        return Backslash;
    }

    /* renamed from: getDirectionLeft-EK5gGoQ  reason: not valid java name */
    public final long m907getDirectionLeftEK5gGoQ() {
        return DirectionLeft;
    }

    /* renamed from: getDirectionRight-EK5gGoQ  reason: not valid java name */
    public final long m908getDirectionRightEK5gGoQ() {
        return DirectionRight;
    }

    /* renamed from: getDirectionUp-EK5gGoQ  reason: not valid java name */
    public final long m909getDirectionUpEK5gGoQ() {
        return DirectionUp;
    }

    /* renamed from: getDirectionDown-EK5gGoQ  reason: not valid java name */
    public final long m906getDirectionDownEK5gGoQ() {
        return DirectionDown;
    }

    /* renamed from: getPageUp-EK5gGoQ  reason: not valid java name */
    public final long m916getPageUpEK5gGoQ() {
        return PageUp;
    }

    /* renamed from: getPageDown-EK5gGoQ  reason: not valid java name */
    public final long m915getPageDownEK5gGoQ() {
        return PageDown;
    }

    /* renamed from: getMoveHome-EK5gGoQ  reason: not valid java name */
    public final long m914getMoveHomeEK5gGoQ() {
        return MoveHome;
    }

    /* renamed from: getMoveEnd-EK5gGoQ  reason: not valid java name */
    public final long m913getMoveEndEK5gGoQ() {
        return MoveEnd;
    }

    /* renamed from: getInsert-EK5gGoQ  reason: not valid java name */
    public final long m912getInsertEK5gGoQ() {
        return Insert;
    }

    /* renamed from: getEnter-EK5gGoQ  reason: not valid java name */
    public final long m910getEnterEK5gGoQ() {
        return Enter;
    }

    /* renamed from: getBackspace-EK5gGoQ  reason: not valid java name */
    public final long m902getBackspaceEK5gGoQ() {
        return Backspace;
    }

    /* renamed from: getDelete-EK5gGoQ  reason: not valid java name */
    public final long m905getDeleteEK5gGoQ() {
        return Delete;
    }

    /* renamed from: getPaste-EK5gGoQ  reason: not valid java name */
    public final long m917getPasteEK5gGoQ() {
        return Paste;
    }

    /* renamed from: getCut-EK5gGoQ  reason: not valid java name */
    public final long m904getCutEK5gGoQ() {
        return Cut;
    }

    /* renamed from: getTab-EK5gGoQ  reason: not valid java name */
    public final long m918getTabEK5gGoQ() {
        return Tab;
    }
}
