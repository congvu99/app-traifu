package io.intercom.android.sdk.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EndlessRecyclerScrollListener extends RecyclerView.OnScrollListener {
    final EndlessScrollListener endlessScrollListener;
    private final LinearLayoutManager layoutManager;
    private boolean morePagesAvailable = true;

    public EndlessRecyclerScrollListener(LinearLayoutManager linearLayoutManager, EndlessScrollListener endlessScrollListener2) {
        this.layoutManager = linearLayoutManager;
        this.endlessScrollListener = endlessScrollListener2;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        int childCount = recyclerView.getChildCount();
        if (this.layoutManager.getItemCount() - childCount <= this.layoutManager.findFirstVisibleItemPosition() && this.morePagesAvailable) {
            recyclerView.post(new Runnable() {
                public void run() {
                    EndlessRecyclerScrollListener.this.endlessScrollListener.onLoadMore();
                }
            });
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.endlessScrollListener.setOverScrollColour();
    }

    public void setMorePagesAvailable(boolean z) {
        this.morePagesAvailable = z;
    }
}
