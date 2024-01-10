package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bd\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010&\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001aJ\u0019\u0010(\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001aJ\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u0019\u0010+\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010\u001aJ\u0019\u0010-\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001aJ\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\u0019\u00101\u001a\u00020\u000eHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010#J\t\u00103\u001a\u00020\nHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u00020\n2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020;HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001c\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0013\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b!\u0010\u001aR\u001c\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "pressure", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "issuesEnterExit", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "(JJJJZFIZLjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "getIssuesEnterExit", "getPosition-F1C5BW0", "getPositionOnScreen-F1C5BW0", "getPressure", "()F", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptime", "component1", "component1-J3iCeTQ", "component10", "component10-F1C5BW0", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component7", "component7-T8wyACA", "component8", "component9", "copy", "copy-gYeeOSc", "(JJJJZFIZLjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InternalPointerInput.kt */
public final class PointerInputEventData {
    private final boolean down;
    private final List<HistoricalChange> historical;
    private final long id;
    private final boolean issuesEnterExit;
    private final long position;
    private final long positionOnScreen;
    private final float pressure;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, f, i, z2, list, j5);
    }

    /* renamed from: copy-gYeeOSc$default  reason: not valid java name */
    public static /* synthetic */ PointerInputEventData m3435copygYeeOSc$default(PointerInputEventData pointerInputEventData, long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List list, long j5, int i2, Object obj) {
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        int i3 = i2;
        return pointerInputEventData.m3441copygYeeOSc((i3 & 1) != 0 ? pointerInputEventData2.id : j, (i3 & 2) != 0 ? pointerInputEventData2.uptime : j2, (i3 & 4) != 0 ? pointerInputEventData2.positionOnScreen : j3, (i3 & 8) != 0 ? pointerInputEventData2.position : j4, (i3 & 16) != 0 ? pointerInputEventData2.down : z, (i3 & 32) != 0 ? pointerInputEventData2.pressure : f, (i3 & 64) != 0 ? pointerInputEventData2.type : i, (i3 & 128) != 0 ? pointerInputEventData2.issuesEnterExit : z2, (i3 & 256) != 0 ? pointerInputEventData2.historical : list, (i3 & 512) != 0 ? pointerInputEventData2.scrollDelta : j5);
    }

    /* renamed from: component1-J3iCeTQ  reason: not valid java name */
    public final long m3436component1J3iCeTQ() {
        return this.id;
    }

    /* renamed from: component10-F1C5BW0  reason: not valid java name */
    public final long m3437component10F1C5BW0() {
        return this.scrollDelta;
    }

    public final long component2() {
        return this.uptime;
    }

    /* renamed from: component3-F1C5BW0  reason: not valid java name */
    public final long m3438component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: component4-F1C5BW0  reason: not valid java name */
    public final long m3439component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    public final float component6() {
        return this.pressure;
    }

    /* renamed from: component7-T8wyACA  reason: not valid java name */
    public final int m3440component7T8wyACA() {
        return this.type;
    }

    public final boolean component8() {
        return this.issuesEnterExit;
    }

    public final List<HistoricalChange> component9() {
        return this.historical;
    }

    /* renamed from: copy-gYeeOSc  reason: not valid java name */
    public final PointerInputEventData m3441copygYeeOSc(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5) {
        long j6 = j;
        Intrinsics.checkNotNullParameter(list, "historical");
        return new PointerInputEventData(j, j2, j3, j4, z, f, i, z2, list, j5, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m3414equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m1680equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m1680equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && Intrinsics.areEqual((Object) Float.valueOf(this.pressure), (Object) Float.valueOf(pointerInputEventData.pressure)) && PointerType.m3502equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual((Object) this.historical, (Object) pointerInputEventData.historical) && Offset.m1680equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta);
    }

    public int hashCode() {
        int r0 = ((((((PointerId.m3415hashCodeimpl(this.id) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.uptime)) * 31) + Offset.m1685hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m1685hashCodeimpl(this.position)) * 31;
        boolean z = this.down;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int floatToIntBits = (((((r0 + (z ? 1 : 0)) * 31) + Float.floatToIntBits(this.pressure)) * 31) + PointerType.m3503hashCodeimpl(this.type)) * 31;
        boolean z3 = this.issuesEnterExit;
        if (!z3) {
            z2 = z3;
        }
        return ((((floatToIntBits + (z2 ? 1 : 0)) * 31) + this.historical.hashCode()) * 31) + Offset.m1685hashCodeimpl(this.scrollDelta);
    }

    public String toString() {
        return "PointerInputEventData(id=" + PointerId.m3416toStringimpl(this.id) + ", uptime=" + this.uptime + ", positionOnScreen=" + Offset.m1691toStringimpl(this.positionOnScreen) + ", position=" + Offset.m1691toStringimpl(this.position) + ", down=" + this.down + ", pressure=" + this.pressure + ", type=" + PointerType.m3504toStringimpl(this.type) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + Offset.m1691toStringimpl(this.scrollDelta) + ')';
    }

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, float f, int i, boolean z2, List<HistoricalChange> list, long j5) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.pressure = f;
        this.type = i;
        this.issuesEnterExit = z2;
        this.historical = list;
        this.scrollDelta = j5;
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m3442getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
    public final long m3444getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m3443getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getDown() {
        return this.down;
    }

    public final float getPressure() {
        return this.pressure;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m3446getTypeT8wyACA() {
        return this.type;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputEventData(long r20, long r22, long r24, long r26, boolean r28, float r29, int r30, boolean r31, java.util.List r32, long r33, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r14 = 0
            goto L_0x000b
        L_0x0009:
            r14 = r31
        L_0x000b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0018
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r15 = r1
            goto L_0x001a
        L_0x0018:
            r15 = r32
        L_0x001a:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0027
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m1699getZeroF1C5BW0()
            r16 = r0
            goto L_0x0029
        L_0x0027:
            r16 = r33
        L_0x0029:
            r18 = 0
            r2 = r19
            r3 = r20
            r5 = r22
            r7 = r24
            r9 = r26
            r11 = r28
            r12 = r29
            r13 = r30
            r2.<init>(r3, r5, r7, r9, r11, r12, r13, r14, r15, r16, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventData.<init>(long, long, long, long, boolean, float, int, boolean, java.util.List, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m3445getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }
}
