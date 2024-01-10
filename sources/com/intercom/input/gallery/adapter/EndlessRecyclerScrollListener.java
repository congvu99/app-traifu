package com.intercom.input.gallery.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EndlessRecyclerScrollListener extends RecyclerView.OnScrollListener {
    private final EndlessScrollListener endlessScrollListener;
    private final LinearLayoutManager layoutManager;
    private int maxCount = Integer.MIN_VALUE;

    public EndlessRecyclerScrollListener(LinearLayoutManager linearLayoutManager, EndlessScrollListener endlessScrollListener2) {
        this.layoutManager = linearLayoutManager;
        this.endlessScrollListener = endlessScrollListener2;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        int childCount = recyclerView.getChildCount();
        int itemCount = this.layoutManager.getItemCount();
        if (itemCount - childCount <= this.layoutManager.findFirstVisibleItemPosition() && itemCount < this.maxCount) {
            this.endlessScrollListener.onLoadMore();
        }
    }

    public void setMaxCount(int i) {
        this.maxCount = i;
    }
}
