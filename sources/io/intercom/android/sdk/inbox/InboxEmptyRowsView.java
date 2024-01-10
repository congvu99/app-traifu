package io.intercom.android.sdk.inbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import io.intercom.android.sdk.R;

public class InboxEmptyRowsView extends View {
    private static final int CIRCLE_RADIUS = 24;
    private static final int CIRCLE_TOP_PADDING = 20;
    private static final int ITEM_HEIGHT = 68;
    private static final int LINE_CORNER_RADIUS = 4;
    private static final int LINE_LEFT_X = 80;
    private static final int LOWER_LINE_BOTTOM_Y = 64;
    private static final int LOWER_LINE_TOP_Y = 52;
    private static final int NUMBER_OF_ROWS = 3;
    private static final int PADDING_X = 16;
    private static final int UPPER_LINE_BOTTOM_Y = 40;
    private static final int UPPER_LINE_TOP_Y = 28;
    private static final int UPPER_LINE_WIDTH = 116;
    private final float density;
    private final Paint paint;
    private final RectF rect;

    public InboxEmptyRowsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public InboxEmptyRowsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        this.rect = new RectF();
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(ContextCompat.getColor(context, R.color.intercom_error_state_empty_avatar));
        this.density = getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < 3; i++) {
            int i2 = i * 68;
            canvas.drawCircle(dpToPx(40), dpToPx(i2 + 44), dpToPx(24), this.paint);
            this.rect.set(dpToPx(80), dpToPx(i2 + 28), dpToPx(196), dpToPx(i2 + 40));
            canvas.drawRoundRect(this.rect, dpToPx(4), dpToPx(4), this.paint);
            this.rect.set(dpToPx(80), dpToPx(i2 + 52), ((float) getWidth()) - dpToPx(16), dpToPx(i2 + 64));
            canvas.drawRoundRect(this.rect, dpToPx(4), dpToPx(4), this.paint);
        }
    }

    private float dpToPx(int i) {
        return ((float) i) * this.density;
    }
}
