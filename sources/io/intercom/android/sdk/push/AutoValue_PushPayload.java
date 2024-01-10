package io.intercom.android.sdk.push;

final class AutoValue_PushPayload extends PushPayload {
    private final String appName;
    private final String authorName;
    private final String body;
    private final String contentImageUrl;
    private final String conversationId;
    private final String conversationPartType;
    private final String imageUrl;
    private final String instanceId;
    private final String intercomPushType;
    private final String message;
    private final int priority;
    private final String pushOnlyConversationId;
    private final String receiver;
    private final String title;
    private final String uri;

    AutoValue_PushPayload(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i) {
        if (str != null) {
            this.conversationId = str;
            if (str2 != null) {
                this.message = str2;
                if (str3 != null) {
                    this.body = str3;
                    if (str4 != null) {
                        this.authorName = str4;
                        if (str5 != null) {
                            this.imageUrl = str5;
                            if (str6 != null) {
                                this.contentImageUrl = str6;
                                if (str7 != null) {
                                    this.appName = str7;
                                    if (str8 != null) {
                                        this.receiver = str8;
                                        if (str9 != null) {
                                            this.conversationPartType = str9;
                                            if (str10 != null) {
                                                this.intercomPushType = str10;
                                                if (str11 != null) {
                                                    this.uri = str11;
                                                    if (str12 != null) {
                                                        this.pushOnlyConversationId = str12;
                                                        if (str13 != null) {
                                                            this.instanceId = str13;
                                                            if (str14 != null) {
                                                                this.title = str14;
                                                                this.priority = i;
                                                                return;
                                                            }
                                                            throw new NullPointerException("Null title");
                                                        }
                                                        throw new NullPointerException("Null instanceId");
                                                    }
                                                    throw new NullPointerException("Null pushOnlyConversationId");
                                                }
                                                throw new NullPointerException("Null uri");
                                            }
                                            throw new NullPointerException("Null intercomPushType");
                                        }
                                        throw new NullPointerException("Null conversationPartType");
                                    }
                                    throw new NullPointerException("Null receiver");
                                }
                                throw new NullPointerException("Null appName");
                            }
                            throw new NullPointerException("Null contentImageUrl");
                        }
                        throw new NullPointerException("Null imageUrl");
                    }
                    throw new NullPointerException("Null authorName");
                }
                throw new NullPointerException("Null body");
            }
            throw new NullPointerException("Null message");
        }
        throw new NullPointerException("Null conversationId");
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getBody() {
        return this.body;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getContentImageUrl() {
        return this.contentImageUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getConversationPartType() {
        return this.conversationPartType;
    }

    public String getIntercomPushType() {
        return this.intercomPushType;
    }

    public String getUri() {
        return this.uri;
    }

    public String getPushOnlyConversationId() {
        return this.pushOnlyConversationId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPriority() {
        return this.priority;
    }

    public String toString() {
        return "PushPayload{conversationId=" + this.conversationId + ", message=" + this.message + ", body=" + this.body + ", authorName=" + this.authorName + ", imageUrl=" + this.imageUrl + ", contentImageUrl=" + this.contentImageUrl + ", appName=" + this.appName + ", receiver=" + this.receiver + ", conversationPartType=" + this.conversationPartType + ", intercomPushType=" + this.intercomPushType + ", uri=" + this.uri + ", pushOnlyConversationId=" + this.pushOnlyConversationId + ", instanceId=" + this.instanceId + ", title=" + this.title + ", priority=" + this.priority + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushPayload)) {
            return false;
        }
        PushPayload pushPayload = (PushPayload) obj;
        if (!this.conversationId.equals(pushPayload.getConversationId()) || !this.message.equals(pushPayload.getMessage()) || !this.body.equals(pushPayload.getBody()) || !this.authorName.equals(pushPayload.getAuthorName()) || !this.imageUrl.equals(pushPayload.getImageUrl()) || !this.contentImageUrl.equals(pushPayload.getContentImageUrl()) || !this.appName.equals(pushPayload.getAppName()) || !this.receiver.equals(pushPayload.getReceiver()) || !this.conversationPartType.equals(pushPayload.getConversationPartType()) || !this.intercomPushType.equals(pushPayload.getIntercomPushType()) || !this.uri.equals(pushPayload.getUri()) || !this.pushOnlyConversationId.equals(pushPayload.getPushOnlyConversationId()) || !this.instanceId.equals(pushPayload.getInstanceId()) || !this.title.equals(pushPayload.getTitle()) || this.priority != pushPayload.getPriority()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((this.conversationId.hashCode() ^ 1000003) * 1000003) ^ this.message.hashCode()) * 1000003) ^ this.body.hashCode()) * 1000003) ^ this.authorName.hashCode()) * 1000003) ^ this.imageUrl.hashCode()) * 1000003) ^ this.contentImageUrl.hashCode()) * 1000003) ^ this.appName.hashCode()) * 1000003) ^ this.receiver.hashCode()) * 1000003) ^ this.conversationPartType.hashCode()) * 1000003) ^ this.intercomPushType.hashCode()) * 1000003) ^ this.uri.hashCode()) * 1000003) ^ this.pushOnlyConversationId.hashCode()) * 1000003) ^ this.instanceId.hashCode()) * 1000003) ^ this.title.hashCode()) * 1000003) ^ this.priority;
    }
}
