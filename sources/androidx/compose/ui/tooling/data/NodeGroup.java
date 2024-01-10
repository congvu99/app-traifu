package androidx.compose.ui.tooling.data;

import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\rR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/data/NodeGroup;", "Landroidx/compose/ui/tooling/data/Group;", "key", "", "node", "box", "Landroidx/compose/ui/unit/IntRect;", "data", "", "modifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "children", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/ui/unit/IntRect;Ljava/util/Collection;Ljava/util/List;Ljava/util/Collection;)V", "getModifierInfo", "()Ljava/util/List;", "getNode", "()Ljava/lang/Object;", "ui-tooling-data_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@UiToolingDataApi
/* compiled from: SlotTree.kt */
public final class NodeGroup extends Group {
    public static final int $stable = 8;
    private final List<ModifierInfo> modifierInfo;
    private final Object node;

    public final Object getNode() {
        return this.node;
    }

    public List<ModifierInfo> getModifierInfo() {
        return this.modifierInfo;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NodeGroup(java.lang.Object r13, java.lang.Object r14, androidx.compose.ui.unit.IntRect r15, java.util.Collection<? extends java.lang.Object> r16, java.util.List<androidx.compose.ui.layout.ModifierInfo> r17, java.util.Collection<? extends androidx.compose.ui.tooling.data.Group> r18) {
        /*
            r12 = this;
            r9 = r12
            r10 = r14
            r11 = r17
            java.lang.String r0 = "node"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "box"
            r5 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "data"
            r6 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "modifierInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "children"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r2 = 0
            r3 = 0
            r4 = 0
            r8 = 0
            r0 = r12
            r1 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.node = r10
            r9.modifierInfo = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.NodeGroup.<init>(java.lang.Object, java.lang.Object, androidx.compose.ui.unit.IntRect, java.util.Collection, java.util.List, java.util.Collection):void");
    }
}
