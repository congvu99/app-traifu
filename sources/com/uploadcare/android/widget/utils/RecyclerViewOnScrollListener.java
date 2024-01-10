package com.uploadcare.android.widget.utils;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0006J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/uploadcare/android/widget/utils/RecyclerViewOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "loadMoreObserver", "Lkotlin/Function0;", "", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;Lkotlin/jvm/functions/Function0;)V", "firstVisibleItem", "", "gridLayoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "loading", "", "previousTotal", "totalItemCount", "visibleItemCount", "visibleThreshold", "clear", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: RecyclerViewOnScrollListener.kt */
public final class RecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
    private int firstVisibleItem;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager linearLayoutManager;
    private final Function0<Unit> loadMoreObserver;
    private boolean loading;
    private int previousTotal;
    private int totalItemCount;
    private int visibleItemCount;
    private int visibleThreshold;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecyclerViewOnScrollListener(RecyclerView.LayoutManager layoutManager, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutManager, (i & 2) != 0 ? null : function0);
    }

    public RecyclerViewOnScrollListener(RecyclerView.LayoutManager layoutManager, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        this.loadMoreObserver = function0;
        this.loading = true;
        this.visibleThreshold = 20;
        if (layoutManager instanceof GridLayoutManager) {
            this.gridLayoutManager = (GridLayoutManager) layoutManager;
        } else {
            this.linearLayoutManager = (LinearLayoutManager) layoutManager;
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        this.visibleItemCount = recyclerView.getChildCount();
        GridLayoutManager gridLayoutManager2 = this.gridLayoutManager;
        if (gridLayoutManager2 != null) {
            this.totalItemCount = gridLayoutManager2.getItemCount();
            this.firstVisibleItem = gridLayoutManager2.findFirstVisibleItemPosition();
        }
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 != null) {
            this.totalItemCount = linearLayoutManager2.getItemCount();
            this.firstVisibleItem = linearLayoutManager2.findFirstVisibleItemPosition();
        }
        if (this.loading && (i3 = this.totalItemCount) > this.previousTotal) {
            this.loading = false;
            this.previousTotal = i3;
        }
        if (!this.loading && this.totalItemCount - this.visibleItemCount <= this.firstVisibleItem + this.visibleThreshold) {
            Function0<Unit> function0 = this.loadMoreObserver;
            if (function0 != null) {
                function0.invoke();
            }
            this.loading = true;
        }
    }

    public final void clear() {
        this.previousTotal = 0;
        this.loading = false;
    }
}
