package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0017J0\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020$H\u0014J\u0018\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020\u0013H\u0017J\b\u0010,\u001a\u00020\u000fH\u0016R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006-"}, d2 = {"Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "holderToLayoutNode", "Ljava/util/HashMap;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/collections/HashMap;", "getHolderToLayoutNode", "()Ljava/util/HashMap;", "layoutNodeToHolder", "getLayoutNodeToHolder", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "drawView", "", "view", "canvas", "Landroid/graphics/Canvas;", "invalidateChildInParent", "", "location", "", "dirty", "Landroid/graphics/Rect;", "onDescendantInvalidated", "child", "Landroid/view/View;", "target", "onLayout", "changed", "l", "", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidViewsHandler.android.kt */
public final class AndroidViewsHandler extends ViewGroup {
    private final HashMap<AndroidViewHolder, LayoutNode> holderToLayoutNode = new HashMap<>();
    private final HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = new HashMap<>();

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public Void invalidateChildInParent(int[] iArr, Rect rect) {
        return null;
    }

    public void onDescendantInvalidated(View view, View view2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewsHandler(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
    }

    public final HashMap<AndroidViewHolder, LayoutNode> getHolderToLayoutNode() {
        return this.holderToLayoutNode;
    }

    public final HashMap<LayoutNode, AndroidViewHolder> getLayoutNodeToHolder() {
        return this.layoutNodeToHolder;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        boolean z = true;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                z = false;
            }
            if (z) {
                setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
                Set<AndroidViewHolder> keySet = this.holderToLayoutNode.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "holderToLayoutNode.keys");
                for (AndroidViewHolder remeasure : keySet) {
                    remeasure.remeasure();
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Set<AndroidViewHolder> keySet = this.holderToLayoutNode.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "holderToLayoutNode.keys");
        for (AndroidViewHolder androidViewHolder : keySet) {
            androidViewHolder.layout(androidViewHolder.getLeft(), androidViewHolder.getTop(), androidViewHolder.getRight(), androidViewHolder.getBottom());
        }
    }

    public final void drawView(AndroidViewHolder androidViewHolder, Canvas canvas) {
        Intrinsics.checkNotNullParameter(androidViewHolder, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        androidViewHolder.draw(canvas);
    }

    public void requestLayout() {
        cleanupLayoutState(this);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutNode layoutNode = (LayoutNode) this.holderToLayoutNode.get(childAt);
            if (childAt.isLayoutRequested() && layoutNode != null) {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, 1, (Object) null);
            }
        }
    }
}
