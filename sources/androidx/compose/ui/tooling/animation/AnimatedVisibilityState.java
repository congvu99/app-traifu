package androidx.compose.ui.tooling.animation;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState;", "", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
/* compiled from: ComposeAnimationParser.kt */
public final class AnimatedVisibilityState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String Enter = m4598constructorimpl(ReactEditTextInputConnectionWrapper.ENTER_KEY_VALUE);
    /* access modifiers changed from: private */
    public static final String Exit = m4598constructorimpl("Exit");
    private final String value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ AnimatedVisibilityState m4597boximpl(String str) {
        return new AnimatedVisibilityState(str);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static String m4598constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4599equalsimpl(String str, Object obj) {
        return (obj instanceof AnimatedVisibilityState) && Intrinsics.areEqual((Object) str, (Object) ((AnimatedVisibilityState) obj).m4603unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4600equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4601hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4602toStringimpl(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        return m4599equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4601hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m4603unboximpl() {
        return this.value;
    }

    private /* synthetic */ AnimatedVisibilityState(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return m4602toStringimpl(this.value);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState$Companion;", "", "()V", "Enter", "Landroidx/compose/ui/tooling/animation/AnimatedVisibilityState;", "getEnter-q9NwIk0", "()Ljava/lang/String;", "Ljava/lang/String;", "Exit", "getExit-q9NwIk0", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ComposeAnimationParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEnter-q9NwIk0  reason: not valid java name */
        public final String m4604getEnterq9NwIk0() {
            return AnimatedVisibilityState.Enter;
        }

        /* renamed from: getExit-q9NwIk0  reason: not valid java name */
        public final String m4605getExitq9NwIk0() {
            return AnimatedVisibilityState.Exit;
        }
    }
}
