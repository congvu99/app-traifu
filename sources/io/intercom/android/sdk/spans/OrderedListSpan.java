package io.intercom.android.sdk.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public class OrderedListSpan implements LeadingMarginSpan {
    private final int gapWidth;
    private final String number;

    public OrderedListSpan(int i, String str) {
        this.gapWidth = i;
        this.number = str;
    }

    public int getLeadingMargin(boolean z) {
        return (int) (new Paint().measureText(this.number) + ((float) this.gapWidth));
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (((Spanned) charSequence).getSpanStart(this) == i6) {
            Paint.Style style = paint.getStyle();
            paint.setStyle(Paint.Style.FILL);
            canvas.drawText(this.number + " ", (float) (i + i2), (float) i4, paint);
            paint.setStyle(style);
        }
    }
}
