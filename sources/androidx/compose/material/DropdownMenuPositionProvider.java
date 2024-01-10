package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\fJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JF\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/material/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Menu.kt */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density2, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density2, function2);
    }

    /* renamed from: copy-rOJDEFc$default  reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1275copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density2, Function2<IntRect, IntRect, Unit> function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density2 = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1278copyrOJDEFc(j, density2, function2);
    }

    /* renamed from: component1-RKDOV3M  reason: not valid java name */
    public final long m1277component1RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    /* renamed from: copy-rOJDEFc  reason: not valid java name */
    public final DropdownMenuPositionProvider m1278copyrOJDEFc(long j, Density density2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(function2, "onPositionCalculated");
        return new DropdownMenuPositionProvider(j, density2, function2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m4764equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual((Object) this.density, (Object) dropdownMenuPositionProvider.density) && Intrinsics.areEqual((Object) this.onPositionCalculated, (Object) dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((DpOffset.m4769hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.m4772toStringimpl(this.contentOffset) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    private DropdownMenuPositionProvider(long j, Density density2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density2;
        this.onPositionCalculated = function2;
    }

    /* renamed from: getContentOffset-RKDOV3M  reason: not valid java name */
    public final long m1279getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density2, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density2, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function2, (DefaultConstructorMarker) null);
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m1276calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect r15, long r16, androidx.compose.ui.unit.LayoutDirection r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r18
            java.lang.String r3 = "anchorBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
            java.lang.String r3 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.compose.ui.unit.Density r3 = r0.density
            float r4 = androidx.compose.material.MenuKt.getMenuVerticalMargin()
            int r3 = r3.m4643roundToPx0680j_4(r4)
            androidx.compose.ui.unit.Density r4 = r0.density
            long r5 = r0.contentOffset
            float r5 = androidx.compose.ui.unit.DpOffset.m4765getXD9Ej5fM(r5)
            int r4 = r4.m4643roundToPx0680j_4(r5)
            androidx.compose.ui.unit.Density r5 = r0.density
            long r6 = r0.contentOffset
            float r6 = androidx.compose.ui.unit.DpOffset.m4767getYD9Ej5fM(r6)
            int r5 = r5.m4643roundToPx0680j_4(r6)
            int r6 = r15.getLeft()
            int r6 = r6 + r4
            int r7 = r15.getRight()
            int r7 = r7 - r4
            int r4 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r19)
            int r7 = r7 - r4
            int r4 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r16)
            int r8 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r19)
            int r4 = r4 - r8
            androidx.compose.ui.unit.LayoutDirection r8 = androidx.compose.ui.unit.LayoutDirection.Ltr
            r9 = 3
            r10 = 2
            r11 = 1
            r12 = 0
            if (r2 != r8) goto L_0x0071
            java.lang.Integer[] r2 = new java.lang.Integer[r9]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r12] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r2[r11] = r6
            int r6 = r15.getLeft()
            if (r6 < 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r10] = r4
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt.sequenceOf(r2)
            goto L_0x0094
        L_0x0071:
            java.lang.Integer[] r2 = new java.lang.Integer[r9]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r2[r12] = r8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r11] = r6
            int r6 = r15.getRight()
            int r8 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r16)
            if (r6 > r8) goto L_0x008a
            r4 = 0
        L_0x008a:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r10] = r4
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt.sequenceOf(r2)
        L_0x0094:
            java.util.Iterator r2 = r2.iterator()
        L_0x0098:
            boolean r4 = r2.hasNext()
            r6 = 0
            if (r4 == 0) goto L_0x00bd
            java.lang.Object r4 = r2.next()
            r8 = r4
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 < 0) goto L_0x00b9
            int r13 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r19)
            int r8 = r8 + r13
            int r13 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r16)
            if (r8 > r13) goto L_0x00b9
            r8 = 1
            goto L_0x00ba
        L_0x00b9:
            r8 = 0
        L_0x00ba:
            if (r8 == 0) goto L_0x0098
            goto L_0x00be
        L_0x00bd:
            r4 = r6
        L_0x00be:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L_0x00c6
            int r7 = r4.intValue()
        L_0x00c6:
            int r2 = r15.getBottom()
            int r2 = r2 + r5
            int r2 = java.lang.Math.max(r2, r3)
            int r4 = r15.getTop()
            int r4 = r4 - r5
            int r5 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r19)
            int r4 = r4 - r5
            int r5 = r15.getTop()
            int r8 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r19)
            int r8 = r8 / r10
            int r5 = r5 - r8
            int r8 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r16)
            int r13 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r19)
            int r8 = r8 - r13
            int r8 = r8 - r3
            r13 = 4
            java.lang.Integer[] r13 = new java.lang.Integer[r13]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r13[r12] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r13[r11] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r13[r10] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r13[r9] = r2
            kotlin.sequences.Sequence r2 = kotlin.sequences.SequencesKt.sequenceOf(r13)
            java.util.Iterator r2 = r2.iterator()
        L_0x0110:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0135
            java.lang.Object r5 = r2.next()
            r8 = r5
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            if (r8 < r3) goto L_0x0131
            int r9 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r19)
            int r8 = r8 + r9
            int r9 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r16)
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0131
            r8 = 1
            goto L_0x0132
        L_0x0131:
            r8 = 0
        L_0x0132:
            if (r8 == 0) goto L_0x0110
            r6 = r5
        L_0x0135:
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x013d
            int r4 = r6.intValue()
        L_0x013d:
            kotlin.jvm.functions.Function2<androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect, kotlin.Unit> r2 = r0.onPositionCalculated
            androidx.compose.ui.unit.IntRect r3 = new androidx.compose.ui.unit.IntRect
            int r5 = androidx.compose.ui.unit.IntSize.m4864getWidthimpl(r19)
            int r5 = r5 + r7
            int r6 = androidx.compose.ui.unit.IntSize.m4863getHeightimpl(r19)
            int r6 = r6 + r4
            r3.<init>(r7, r4, r5, r6)
            r2.invoke(r15, r3)
            long r1 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r7, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DropdownMenuPositionProvider.m1276calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect, long, androidx.compose.ui.unit.LayoutDirection, long):long");
    }
}
