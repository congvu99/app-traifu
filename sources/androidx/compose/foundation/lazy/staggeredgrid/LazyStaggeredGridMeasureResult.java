package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002Bv\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u0017J\t\u00106\u001a\u000207H\u0001R\u0014\u0010\u0016\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\r0\u001bX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0015\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0012\u0010(\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0014\u0010\u0014\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u001f\u0010\u0011\u001a\u00020\u0012X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0014\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b5\u0010\u0019\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00068"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "canScrollForward", "", "canScrollBackward", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "([I[IFLandroidx/compose/ui/layout/MeasureResult;ZZILjava/util/List;JIIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "getBeforeContentPadding", "getCanScrollBackward", "()Z", "getCanScrollForward", "getConsumedScroll", "()F", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "height", "getHeight", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final boolean canScrollBackward;
    private final boolean canScrollForward;
    private final float consumedScroll;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final MeasureResult measureResult;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridItemInfo> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, int i, List list, long j, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2, f, measureResult2, z, z2, i, list, j, i2, i3, i4, i5);
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    private LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, int i, List<? extends LazyStaggeredGridItemInfo> list, long j, int i2, int i3, int i4, int i5) {
        this.firstVisibleItemIndices = iArr;
        this.firstVisibleItemScrollOffsets = iArr2;
        this.consumedScroll = f;
        this.measureResult = measureResult2;
        this.canScrollForward = z;
        this.canScrollBackward = z2;
        this.totalItemsCount = i;
        this.visibleItemsInfo = list;
        this.viewportSize = j;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final boolean getCanScrollBackward() {
        return this.canScrollBackward;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public List<LazyStaggeredGridItemInfo> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m812getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }
}
