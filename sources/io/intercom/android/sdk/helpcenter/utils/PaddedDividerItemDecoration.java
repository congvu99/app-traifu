package io.intercom.android.sdk.helpcenter.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import io.intercom.android.sdk.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/intercom/android/sdk/helpcenter/utils/PaddedDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dividerDrawable", "Landroid/graphics/drawable/Drawable;", "padding", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "intercom-sdk-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PaddedDividerItemDecoration.kt */
public final class PaddedDividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Context context;
    private Drawable dividerDrawable = ContextCompat.getDrawable(this.context, R.drawable.intercom_list_divider);
    private final int padding;

    public PaddedDividerItemDecoration(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.padding = (int) TypedValue.applyDimension(1, 16.0f, context2.getResources().getDisplayMetrics());
    }

    public final Context getContext() {
        return this.context;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int paddingLeft = recyclerView.getPaddingLeft() + this.padding;
        int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.padding;
        if (recyclerView.getAdapter() != null) {
            int childCount = recyclerView.getChildCount() - 1;
            int i = 0;
            while (i < childCount) {
                View childAt = recyclerView.getChildAt(i);
                if (recyclerView.getChildAdapterPosition(childAt) != -1) {
                    int bottom = childAt.getBottom();
                    Drawable drawable = this.dividerDrawable;
                    int intrinsicHeight = (drawable != null ? drawable.getIntrinsicHeight() : 0) + bottom;
                    Drawable drawable2 = this.dividerDrawable;
                    if (drawable2 != null) {
                        drawable2.setBounds(paddingLeft, bottom, width, intrinsicHeight);
                    }
                    Drawable drawable3 = this.dividerDrawable;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
