package io.intercom.android.sdk.conversation.attribute;

import android.animation.Animator;
import com.squareup.otto.Bus;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.events.ConversationEvent;

public class AttributeAnimateEndListener implements Animator.AnimatorListener {
    private final Bus bus;
    private final Conversation conversation;

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public AttributeAnimateEndListener(Conversation conversation2, Bus bus2) {
        this.conversation = conversation2;
        this.bus = bus2;
    }

    public void onAnimationEnd(Animator animator) {
        this.bus.post(new ConversationEvent.Builder(this.conversation).isAttributeUpdated(true).build());
    }
}
