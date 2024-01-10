package io.intercom.android.sdk.models.events.failure;

public class ReplyFailedEvent {
    private final boolean isUpload;
    private final String partId;
    private final int position;

    public ReplyFailedEvent(int i, boolean z, String str) {
        this.position = i;
        this.partId = str;
        this.isUpload = z;
    }

    public String getPartId() {
        return this.partId;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isUpload() {
        return this.isUpload;
    }
}
