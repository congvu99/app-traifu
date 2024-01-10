package io.intercom.android.sdk.models.events.failure;

public class NewConversationFailedEvent {
    private final String partId;
    private final int position;

    public NewConversationFailedEvent(int i, String str) {
        this.position = i;
        this.partId = str;
    }

    public String getPartId() {
        return this.partId;
    }

    public int getPosition() {
        return this.position;
    }
}
