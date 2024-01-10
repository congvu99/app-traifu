package com.uploadcare.android.widget.controller;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/uploadcare/android/widget/controller/SocialNetwork;", "", "rawValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "SOCIAL_NETWORK_FACEBOOK", "SOCIAL_NETWORK_INSTAGRAM", "SOCIAL_NETWORK_VK", "SOCIAL_NETWORK_BOX", "SOCIAL_NETWORK_HUDDLE", "SOCIAL_NETWORK_FLICKR", "SOCIAL_NETWORK_EVERNOTE", "SOCIAL_NETWORK_SKYDRIVE", "SOCIAL_NETWORK_ONEDRIVE", "SOCIAL_NETWORK_DROPBOX", "SOCIAL_NETWORK_GDRIVE", "SOCIAL_NETWORK_GPHOTOS", "SOCIAL_NETWORK_VIDEOCAM", "SOCIAL_NETWORK_CAMERA", "SOCIAL_NETWORK_FILE", "widget_release"}, k = 1, mv = {1, 4, 0})
/* compiled from: UploadcareWidget.kt */
public enum SocialNetwork {
    SOCIAL_NETWORK_FACEBOOK("facebook"),
    SOCIAL_NETWORK_INSTAGRAM("instagram"),
    SOCIAL_NETWORK_VK("vk"),
    SOCIAL_NETWORK_BOX("box"),
    SOCIAL_NETWORK_HUDDLE("huddle"),
    SOCIAL_NETWORK_FLICKR("flickr"),
    SOCIAL_NETWORK_EVERNOTE("evernote"),
    SOCIAL_NETWORK_SKYDRIVE("skydrive"),
    SOCIAL_NETWORK_ONEDRIVE("onedrive"),
    SOCIAL_NETWORK_DROPBOX("dropbox"),
    SOCIAL_NETWORK_GDRIVE("gdrive"),
    SOCIAL_NETWORK_GPHOTOS("gphotos"),
    SOCIAL_NETWORK_VIDEOCAM("video"),
    SOCIAL_NETWORK_CAMERA("image"),
    SOCIAL_NETWORK_FILE("file");
    
    private final String rawValue;

    private SocialNetwork(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
