package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WindowInsets.kt */
final class PaddingValuesInsets implements WindowInsets {
    private final PaddingValues paddingValues;

    public PaddingValuesInsets(PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.paddingValues = paddingValues2;
    }

    public int getLeft(Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        return density.m4643roundToPx0680j_4(this.paddingValues.m521calculateLeftPaddingu2uoSUM(layoutDirection));
    }

    public int getTop(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.m4643roundToPx0680j_4(this.paddingValues.m523calculateTopPaddingD9Ej5fM());
    }

    public int getRight(Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, ViewProps.LAYOUT_DIRECTION);
        return density.m4643roundToPx0680j_4(this.paddingValues.m522calculateRightPaddingu2uoSUM(layoutDirection));
    }

    public int getBottom(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.m4643roundToPx0680j_4(this.paddingValues.m520calculateBottomPaddingD9Ej5fM());
    }

    public String toString() {
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        float r1 = this.paddingValues.m521calculateLeftPaddingu2uoSUM(layoutDirection);
        float r2 = this.paddingValues.m523calculateTopPaddingD9Ej5fM();
        float r0 = this.paddingValues.m522calculateRightPaddingu2uoSUM(layoutDirection);
        float r3 = this.paddingValues.m520calculateBottomPaddingD9Ej5fM();
        return "PaddingValues(" + Dp.m4715toStringimpl(r1) + ", " + Dp.m4715toStringimpl(r2) + ", " + Dp.m4715toStringimpl(r0) + ", " + Dp.m4715toStringimpl(r3) + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingValuesInsets)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((PaddingValuesInsets) obj).paddingValues, (Object) this.paddingValues);
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }
}
