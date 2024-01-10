package io.intercom.android.sdk.models.events.failure;

public class FormSubmitFailedEvent {
    private final String attributeIdentifier;
    private final String partId;

    public FormSubmitFailedEvent(String str, String str2) {
        this.partId = str;
        this.attributeIdentifier = str2;
    }

    public String getPartId() {
        return this.partId;
    }

    public String getAttributeIdentifier() {
        return this.attributeIdentifier;
    }
}
