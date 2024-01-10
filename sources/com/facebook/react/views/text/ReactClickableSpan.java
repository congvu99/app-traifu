package com.facebook.react.views.text;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ViewGroupClickEvent;

class ReactClickableSpan extends ClickableSpan implements ReactSpan {
    private final int mForegroundColor;
    private final int mReactTag;

    ReactClickableSpan(int i, int i2) {
        this.mReactTag = i;
        this.mForegroundColor = i2;
    }

    public void onClick(View view) {
        ReactContext reactContext = (ReactContext) view.getContext();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, this.mReactTag);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId((Context) reactContext), this.mReactTag));
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.mForegroundColor);
        textPaint.setUnderlineText(false);
    }

    public int getReactTag() {
        return this.mReactTag;
    }
}
