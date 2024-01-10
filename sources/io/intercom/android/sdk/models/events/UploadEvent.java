package io.intercom.android.sdk.models.events;

import io.intercom.android.sdk.models.Upload;

public class UploadEvent {
    private final long size;
    private final String tempPartId;
    private final int tempPartPosition;
    private final Upload upload;

    public UploadEvent(Upload upload2, long j, int i, String str) {
        this.upload = upload2;
        this.size = j;
        this.tempPartPosition = i;
        this.tempPartId = str;
    }

    public Upload getUpload() {
        return this.upload;
    }

    public long getSize() {
        return this.size;
    }

    public int getTempPartPosition() {
        return this.tempPartPosition;
    }

    public String getTempPartId() {
        return this.tempPartId;
    }
}
