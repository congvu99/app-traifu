package io.intercom.android.sdk.utilities;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import com.intercom.commons.utilities.TimeProvider;
import io.intercom.android.sdk.Injector;

public class TrackingLinkMovementMethod extends LinkMovementMethod {
    private boolean longClickActive = false;
    private boolean longClickPerformed = false;
    private long startClickTime;

    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int position = getPosition(motionEvent, textView);
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(position, position, URLSpan.class);
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1) {
                this.longClickActive = false;
                if (this.longClickPerformed) {
                    z = false;
                } else if (uRLSpanArr.length != 0) {
                    LinkOpener.handleUrl(uRLSpanArr[0].getURL(), textView.getContext(), Injector.get().getApi());
                } else {
                    Selection.removeSelection(spannable);
                    performClick((ViewGroup) textView.getParent());
                }
                this.longClickPerformed = false;
            } else if (action != 2 || !this.longClickActive) {
                return false;
            } else {
                if (TimeProvider.SYSTEM.currentTimeMillis() - this.startClickTime >= ((long) ViewConfiguration.getLongPressTimeout())) {
                    this.longClickActive = false;
                    performLongClick((ViewGroup) textView.getParent());
                    this.longClickPerformed = true;
                } else {
                    z = false;
                }
            }
            return z;
        }
        this.startClickTime = TimeProvider.SYSTEM.currentTimeMillis();
        if (!this.longClickActive) {
            this.longClickActive = true;
        }
        if (uRLSpanArr.length == 0) {
            return false;
        }
        Selection.setSelection(spannable, spannable.getSpanStart(uRLSpanArr[0]), spannable.getSpanEnd(uRLSpanArr[0]));
        return false;
    }

    private void performClick(ViewGroup viewGroup) {
        while (!viewGroup.performClick() && (viewGroup.getParent() instanceof ViewGroup)) {
            viewGroup = (ViewGroup) viewGroup.getParent();
        }
    }

    private void performLongClick(ViewGroup viewGroup) {
        while (!viewGroup.performLongClick() && (viewGroup.getParent() instanceof ViewGroup)) {
            viewGroup = (ViewGroup) viewGroup.getParent();
        }
    }

    private int getPosition(MotionEvent motionEvent, TextView textView) {
        int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
        int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
        int scrollX = x + textView.getScrollX();
        Layout layout = textView.getLayout();
        return layout.getOffsetForHorizontal(layout.getLineForVertical(y + textView.getScrollY()), (float) scrollX);
    }
}
