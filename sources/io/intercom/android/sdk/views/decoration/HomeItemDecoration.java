package io.intercom.android.sdk.views.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.intercom.commons.utilities.ScreenUtils;
import java.util.List;

public class HomeItemDecoration extends RecyclerView.ItemDecoration {
    private static final int SPACING_DP = 8;
    private final List<Object> cards;
    private final int spacing;

    public HomeItemDecoration(Context context, List<Object> list) {
        this.cards = list;
        this.spacing = ScreenUtils.dpToPx(8.0f, context);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition != -1 && childLayoutPosition < this.cards.size()) {
            rect.set(0, topSpacingForPartAtPosition(childLayoutPosition), 0, this.spacing);
        }
    }

    private int topSpacingForPartAtPosition(int i) {
        if (i == 0) {
            return this.spacing;
        }
        return 0;
    }
}
