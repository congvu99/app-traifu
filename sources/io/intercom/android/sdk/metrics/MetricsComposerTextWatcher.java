package io.intercom.android.sdk.metrics;

import android.text.Editable;
import android.text.TextUtils;
import io.intercom.android.sdk.utilities.SimpleTextWatcher;

public class MetricsComposerTextWatcher extends SimpleTextWatcher {
    private final String closedConversationId;
    private String conversationId;
    private boolean hasTrackedEvent;
    private final MetricTracker metricTracker;

    public MetricsComposerTextWatcher(MetricTracker metricTracker2, String str) {
        this.metricTracker = metricTracker2;
        this.closedConversationId = str;
    }

    public void afterTextChanged(Editable editable) {
        if (!this.hasTrackedEvent && editable.length() != 0) {
            if (!TextUtils.isEmpty(this.conversationId)) {
                this.metricTracker.typeInConversation(this.conversationId);
            } else if (TextUtils.isEmpty(this.closedConversationId)) {
                this.metricTracker.typeInNewConversation();
            } else {
                this.metricTracker.typeInNewFollowUpConversation(this.closedConversationId);
            }
            this.hasTrackedEvent = true;
        }
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void reset() {
        this.hasTrackedEvent = false;
    }
}
