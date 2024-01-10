package com.intercom.input.gallery;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class HeadingMarginDecoration extends RecyclerView.ItemDecoration {
    private final int heightRes;

    public HeadingMarginDecoration(int i) {
        this.heightRes = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int integer = recyclerView.getResources().getInteger(R.integer.intercom_composer_expanded_column_count);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition >= 0 && childAdapterPosition < integer) {
            rect.set(0, recyclerView.getResources().getDimensionPixelOffset(this.heightRes), 0, 0);
        }
    }
}
