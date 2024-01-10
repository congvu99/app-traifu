package com.intercom.composer.input.iconbar;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.composer.R;

public class InputIconRecyclerDecoration extends RecyclerView.ItemDecoration {
    final int startSpacing;

    public InputIconRecyclerDecoration(Context context) {
        this.startSpacing = context.getResources().getDimensionPixelSize(R.dimen.intercom_composer_icon_bar_left_spacing);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.set(this.startSpacing, 0, 0, 0);
        }
    }
}
