package io.intercom.android.sdk.models.carousel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ActionType {
    public static final String CAMERA_PERMISSION = "camera_permission";
    public static final String CONTINUE = "continue";
    public static final String DISMISS = "dismiss";
    public static final String LINK = "link";
    public static final String LOCATION_PERMISSION = "location_permission";
    public static final String MICROPHONE_PERMISSION = "microphone_permission";
    public static final String PHOTOS_PERMISSION = "photos_permission";
    public static final String SKIP = "skip";
    public static final String START_CHAT = "start_chat";
}
