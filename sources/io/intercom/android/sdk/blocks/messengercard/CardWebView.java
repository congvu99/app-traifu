package io.intercom.android.sdk.blocks.messengercard;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import io.intercom.android.sdk.models.events.CardUpdatedEvent;

public class CardWebView extends WebView {
    private Bus bus;

    public CardWebView(Context context) {
        super(context);
    }

    public CardWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setUp(Bus bus2) {
        this.bus = bus2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Bus bus2 = this.bus;
        if (bus2 != null) {
            bus2.register(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bus bus2 = this.bus;
        if (bus2 != null) {
            bus2.unregister(this);
        }
    }

    @Subscribe
    public void onCardUpdated(CardUpdatedEvent cardUpdatedEvent) {
        reload();
    }
}
