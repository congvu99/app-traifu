package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@JvmInline
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 $2\u00020\u0001:\u0001$B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0013\u0010\u000bJ!\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u000bJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0017J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/ui/unit/IntSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)I", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "div", "other", "div-YEO4UFw", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "times", "times-YEO4UFw", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IntSize.kt */
public final class IntSize {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Zero = m4859constructorimpl(0);
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ IntSize m4856boximpl(long j) {
        return new IntSize(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m4859constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4861equalsimpl(long j, Object obj) {
        return (obj instanceof IntSize) && j == ((IntSize) obj).m4868unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4862equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    /* renamed from: getHeight-impl  reason: not valid java name */
    public static final int m4863getHeightimpl(long j) {
        return (int) (j & 4294967295L);
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: getWidth-impl  reason: not valid java name */
    public static final int m4864getWidthimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4865hashCodeimpl(long j) {
        return C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m4861equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4865hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m4868unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ IntSize(long j) {
        this.packedValue = j;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final int m4857component1impl(long j) {
        return m4864getWidthimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final int m4858component2impl(long j) {
        return m4863getHeightimpl(j);
    }

    /* renamed from: times-YEO4UFw  reason: not valid java name */
    public static final long m4866timesYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m4864getWidthimpl(j) * i, m4863getHeightimpl(j) * i);
    }

    /* renamed from: div-YEO4UFw  reason: not valid java name */
    public static final long m4860divYEO4UFw(long j, int i) {
        return IntSizeKt.IntSize(m4864getWidthimpl(j) / i, m4863getHeightimpl(j) / i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4867toStringimpl(long j) {
        return m4864getWidthimpl(j) + " x " + m4863getHeightimpl(j);
    }

    public String toString() {
        return m4867toStringimpl(this.packedValue);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, d2 = {"Landroidx/compose/ui/unit/IntSize$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntSize;", "getZero-YbymL2g", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: IntSize.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-YbymL2g  reason: not valid java name */
        public final long m4869getZeroYbymL2g() {
            return IntSize.Zero;
        }
    }
}
