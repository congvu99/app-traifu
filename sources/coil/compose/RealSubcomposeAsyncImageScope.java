package coil.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0002HÂ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fHÆ\u0003JS\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\u0015\u0010,\u001a\u00020-*\u00020-2\u0006\u0010\b\u001a\u00020\tH\u0001J\r\u0010.\u001a\u00020-*\u00020-H\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcoil/compose/RealSubcomposeAsyncImageScope;", "Lcoil/compose/SubcomposeAsyncImageScope;", "Landroidx/compose/foundation/layout/BoxScope;", "parentScope", "painter", "Lcoil/compose/AsyncImagePainter;", "contentDescription", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/foundation/layout/BoxScope;Lcoil/compose/AsyncImagePainter;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentDescription", "()Ljava/lang/String;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Lcoil/compose/AsyncImagePainter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "align", "Landroidx/compose/ui/Modifier;", "matchParentSize", "coil-compose-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeAsyncImage.kt */
final class RealSubcomposeAsyncImageScope implements SubcomposeAsyncImageScope, BoxScope {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final String contentDescription;
    private final ContentScale contentScale;
    private final AsyncImagePainter painter;
    private final BoxScope parentScope;

    private final BoxScope component1() {
        return this.parentScope;
    }

    public static /* synthetic */ RealSubcomposeAsyncImageScope copy$default(RealSubcomposeAsyncImageScope realSubcomposeAsyncImageScope, BoxScope boxScope, AsyncImagePainter asyncImagePainter, String str, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2, int i, Object obj) {
        if ((i & 1) != 0) {
            boxScope = realSubcomposeAsyncImageScope.parentScope;
        }
        if ((i & 2) != 0) {
            asyncImagePainter = realSubcomposeAsyncImageScope.getPainter();
        }
        AsyncImagePainter asyncImagePainter2 = asyncImagePainter;
        if ((i & 4) != 0) {
            str = realSubcomposeAsyncImageScope.getContentDescription();
        }
        String str2 = str;
        if ((i & 8) != 0) {
            alignment2 = realSubcomposeAsyncImageScope.getAlignment();
        }
        Alignment alignment3 = alignment2;
        if ((i & 16) != 0) {
            contentScale2 = realSubcomposeAsyncImageScope.getContentScale();
        }
        ContentScale contentScale3 = contentScale2;
        if ((i & 32) != 0) {
            f = realSubcomposeAsyncImageScope.getAlpha();
        }
        float f2 = f;
        if ((i & 64) != 0) {
            colorFilter2 = realSubcomposeAsyncImageScope.getColorFilter();
        }
        return realSubcomposeAsyncImageScope.copy(boxScope, asyncImagePainter2, str2, alignment3, contentScale3, f2, colorFilter2);
    }

    public Modifier align(Modifier modifier, Alignment alignment2) {
        return this.parentScope.align(modifier, alignment2);
    }

    public final AsyncImagePainter component2() {
        return getPainter();
    }

    public final String component3() {
        return getContentDescription();
    }

    public final Alignment component4() {
        return getAlignment();
    }

    public final ContentScale component5() {
        return getContentScale();
    }

    public final float component6() {
        return getAlpha();
    }

    public final ColorFilter component7() {
        return getColorFilter();
    }

    public final RealSubcomposeAsyncImageScope copy(BoxScope boxScope, AsyncImagePainter asyncImagePainter, String str, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        return new RealSubcomposeAsyncImageScope(boxScope, asyncImagePainter, str, alignment2, contentScale2, f, colorFilter2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealSubcomposeAsyncImageScope)) {
            return false;
        }
        RealSubcomposeAsyncImageScope realSubcomposeAsyncImageScope = (RealSubcomposeAsyncImageScope) obj;
        return Intrinsics.areEqual((Object) this.parentScope, (Object) realSubcomposeAsyncImageScope.parentScope) && Intrinsics.areEqual((Object) getPainter(), (Object) realSubcomposeAsyncImageScope.getPainter()) && Intrinsics.areEqual((Object) getContentDescription(), (Object) realSubcomposeAsyncImageScope.getContentDescription()) && Intrinsics.areEqual((Object) getAlignment(), (Object) realSubcomposeAsyncImageScope.getAlignment()) && Intrinsics.areEqual((Object) getContentScale(), (Object) realSubcomposeAsyncImageScope.getContentScale()) && Intrinsics.areEqual((Object) Float.valueOf(getAlpha()), (Object) Float.valueOf(realSubcomposeAsyncImageScope.getAlpha())) && Intrinsics.areEqual((Object) getColorFilter(), (Object) realSubcomposeAsyncImageScope.getColorFilter());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.parentScope.hashCode() * 31) + getPainter().hashCode()) * 31) + (getContentDescription() == null ? 0 : getContentDescription().hashCode())) * 31) + getAlignment().hashCode()) * 31) + getContentScale().hashCode()) * 31) + Float.floatToIntBits(getAlpha())) * 31;
        if (getColorFilter() != null) {
            i = getColorFilter().hashCode();
        }
        return hashCode + i;
    }

    public Modifier matchParentSize(Modifier modifier) {
        return this.parentScope.matchParentSize(modifier);
    }

    public String toString() {
        return "RealSubcomposeAsyncImageScope(parentScope=" + this.parentScope + ", painter=" + getPainter() + ", contentDescription=" + getContentDescription() + ", alignment=" + getAlignment() + ", contentScale=" + getContentScale() + ", alpha=" + getAlpha() + ", colorFilter=" + getColorFilter() + ')';
    }

    public RealSubcomposeAsyncImageScope(BoxScope boxScope, AsyncImagePainter asyncImagePainter, String str, Alignment alignment2, ContentScale contentScale2, float f, ColorFilter colorFilter2) {
        this.parentScope = boxScope;
        this.painter = asyncImagePainter;
        this.contentDescription = str;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f;
        this.colorFilter = colorFilter2;
    }

    public AsyncImagePainter getPainter() {
        return this.painter;
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public ContentScale getContentScale() {
        return this.contentScale;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }
}
