package io.intercom.android.nexus;

import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum NexusEventType {
    NewComment {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    NewContent {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    ConversationSeen {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.FromUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    UserIsTyping {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.FromUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    AdminIsTyping {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            optJSONObject.put("adminName", nexusEvent.getEventData().optString("adminName"));
            optJSONObject.put("adminId", nexusEvent.getEventData().optString("adminId"));
            optJSONObject.put("adminAvatar", nexusEvent.getEventData().optString("adminAvatar"));
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    AdminIsTypingANote {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            optJSONObject.put("adminName", nexusEvent.getEventData().optString("adminName"));
            optJSONObject.put("adminId", nexusEvent.getEventData().optString("adminId"));
            optJSONObject.put("adminAvatar", nexusEvent.getEventData().optString("adminAvatar"));
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    NewNote {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.optJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    ConversationAssigned {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            optJSONObject.put("adminId", nexusEvent.getEventData().optString("adminId"));
            optJSONObject.put("assigneeId", nexusEvent.getEventData().optString("assigneeId"));
            return jsonObject;
        }
    },
    ConversationClosed {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.optJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    ConversationReopened {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.getJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    UserPresence {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("eventGuid", UUID.randomUUID().toString());
            jSONObject.put("eventName", "nx." + name());
            jSONObject.put("eventData", jSONObject2);
            return jSONObject;
        }
    },
    UserContentSeenByAdmin {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    Subscribe {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("eventName", "nx." + name());
            return jsonObject;
        }
    },
    Unsubscribe {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("eventName", "nx." + name());
            return jsonObject;
        }
    },
    ThreadAssigned {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            JSONObject optJSONObject = jsonObject.optJSONObject("eventData");
            optJSONObject.put("adminId", nexusEvent.getEventData().optString("adminId"));
            optJSONObject.put("assigneeId", nexusEvent.getEventData().optString("assigneeId"));
            return jsonObject;
        }
    },
    ThreadClosed {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.optJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    ThreadReopened {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.getJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    ThreadUpdated {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.getJSONObject("eventData").put("adminId", nexusEvent.getEventData().optString("adminId"));
            return jsonObject;
        }
    },
    ThreadCreated {
        /* access modifiers changed from: protected */
        public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
            JSONObject jsonObject = NexusEventType.super.toJsonObject(nexusEvent);
            jsonObject.put("nx.ToUser", nexusEvent.getUserId());
            return jsonObject;
        }
    },
    UNKNOWN {
        /* access modifiers changed from: protected */
        public String toStringEncodedJsonObject(NexusEvent nexusEvent) {
            return "";
        }
    };

    /* access modifiers changed from: protected */
    public String toStringEncodedJsonObject(NexusEvent nexusEvent) {
        try {
            return toJsonObject(nexusEvent).toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject toJsonObject(NexusEvent nexusEvent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("conversationId", nexusEvent.getEventData().optString("conversationId"));
        jSONObject.put("eventGuid", nexusEvent.getGuid());
        jSONObject.put("eventName", name());
        jSONObject.put("eventData", jSONObject2);
        List<String> topics = nexusEvent.getTopics();
        if (!topics.isEmpty()) {
            jSONObject.put("nx.Topics", new JSONArray(topics));
        }
        return jSONObject;
    }

    public static NexusEventType safeValueOf(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return UNKNOWN;
        }
    }
}
