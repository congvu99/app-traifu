package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.unit.IntRect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0002\u0010\fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u001fJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Landroidx/compose/ui/tooling/ViewInfo;", "", "fileName", "", "lineNumber", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "children", "", "(Ljava/lang/String;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;)V", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/List;", "getFileName", "()Ljava/lang/String;", "getLineNumber", "()I", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "allChildren", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hasBounds", "hashCode", "toString", "ui-tooling_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
public final class ViewInfo {
    public static final int $stable = 8;
    private final IntRect bounds;
    private final List<ViewInfo> children;
    private final String fileName;
    private final int lineNumber;
    private final SourceLocation location;

    public static /* synthetic */ ViewInfo copy$default(ViewInfo viewInfo, String str, int i, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = viewInfo.fileName;
        }
        if ((i2 & 2) != 0) {
            i = viewInfo.lineNumber;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            intRect = viewInfo.bounds;
        }
        IntRect intRect2 = intRect;
        if ((i2 & 8) != 0) {
            sourceLocation = viewInfo.location;
        }
        SourceLocation sourceLocation2 = sourceLocation;
        if ((i2 & 16) != 0) {
            list = viewInfo.children;
        }
        return viewInfo.copy(str, i3, intRect2, sourceLocation2, list);
    }

    public final String component1() {
        return this.fileName;
    }

    public final int component2() {
        return this.lineNumber;
    }

    public final IntRect component3() {
        return this.bounds;
    }

    public final SourceLocation component4() {
        return this.location;
    }

    public final List<ViewInfo> component5() {
        return this.children;
    }

    public final ViewInfo copy(String str, int i, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        Intrinsics.checkNotNullParameter(list, "children");
        return new ViewInfo(str, i, intRect, sourceLocation, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        return Intrinsics.areEqual((Object) this.fileName, (Object) viewInfo.fileName) && this.lineNumber == viewInfo.lineNumber && Intrinsics.areEqual((Object) this.bounds, (Object) viewInfo.bounds) && Intrinsics.areEqual((Object) this.location, (Object) viewInfo.location) && Intrinsics.areEqual((Object) this.children, (Object) viewInfo.children);
    }

    public int hashCode() {
        int hashCode = ((((this.fileName.hashCode() * 31) + this.lineNumber) * 31) + this.bounds.hashCode()) * 31;
        SourceLocation sourceLocation = this.location;
        return ((hashCode + (sourceLocation == null ? 0 : sourceLocation.hashCode())) * 31) + this.children.hashCode();
    }

    public ViewInfo(String str, int i, IntRect intRect, SourceLocation sourceLocation, List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(intRect, "bounds");
        Intrinsics.checkNotNullParameter(list, "children");
        this.fileName = str;
        this.lineNumber = i;
        this.bounds = intRect;
        this.location = sourceLocation;
        this.children = list;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final IntRect getBounds() {
        return this.bounds;
    }

    public final SourceLocation getLocation() {
        return this.location;
    }

    public final List<ViewInfo> getChildren() {
        return this.children;
    }

    public final boolean hasBounds() {
        return (this.bounds.getBottom() == 0 || this.bounds.getRight() == 0) ? false : true;
    }

    public final List<ViewInfo> allChildren() {
        List<ViewInfo> list = this.children;
        Collection collection = list;
        Collection arrayList = new ArrayList();
        for (ViewInfo allChildren : list) {
            CollectionsKt.addAll(arrayList, allChildren.allChildren());
        }
        return CollectionsKt.plus(collection, (List) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x005d, code lost:
        if (r1 == null) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            java.lang.String r2 = r4.fileName
            r0.append(r2)
            r2 = 58
            r0.append(r2)
            int r2 = r4.lineNumber
            r0.append(r2)
            java.lang.String r2 = ",\n            |bounds=(top="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.bounds
            int r2 = r2.getTop()
            r0.append(r2)
            java.lang.String r2 = ", left="
            r0.append(r2)
            androidx.compose.ui.unit.IntRect r2 = r4.bounds
            int r2 = r2.getLeft()
            r0.append(r2)
            java.lang.String r2 = ",\n            |location="
            r0.append(r2)
            androidx.compose.ui.tooling.data.SourceLocation r2 = r4.location
            if (r2 == 0) goto L_0x005f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            int r1 = r2.getOffset()
            r3.append(r1)
            r1 = 76
            r3.append(r1)
            int r1 = r2.getLength()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            if (r1 != 0) goto L_0x0061
        L_0x005f:
            java.lang.String r1 = "<none>"
        L_0x0061:
            r0.append(r1)
            java.lang.String r1 = "\n            |bottom="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.bounds
            int r1 = r1.getBottom()
            r0.append(r1)
            java.lang.String r1 = ", right="
            r0.append(r1)
            androidx.compose.ui.unit.IntRect r1 = r4.bounds
            int r1 = r1.getRight()
            r0.append(r1)
            java.lang.String r1 = "),\n            |childrenCount="
            r0.append(r1)
            java.util.List<androidx.compose.ui.tooling.ViewInfo> r1 = r4.children
            int r1 = r1.size()
            r0.append(r1)
            r1 = 41
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            r2 = 0
            java.lang.String r0 = kotlin.text.StringsKt.trimMargin$default(r0, r2, r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ViewInfo.toString():java.lang.String");
    }
}
