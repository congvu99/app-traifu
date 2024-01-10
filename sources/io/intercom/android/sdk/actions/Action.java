package io.intercom.android.sdk.actions;

public final class Action<V> {
    private final Type type;
    private final V value;

    public enum Type {
        ACTIVITY_PAUSED,
        ACTIVITY_READY_FOR_VIEW_ATTACHMENT,
        ACTIVITY_STOPPED,
        APP_ENTERED_BACKGROUND,
        APP_ENTERED_FOREGROUND,
        BASE_RESPONSE_RECEIVED,
        BOT_INTRO_UPDATED,
        SURVEY_UPDATED,
        SURVEY_DISMISSED,
        COMPOSER_TYPED_IN,
        COMPOSER_INPUT_CHANGED,
        COMPOSER_CLEARED,
        COMPOSER_SEND_BUTTON_PRESSED,
        CONVERSATION_CLOSED,
        CONVERSATION_OPENED,
        CONVERSATION_MARKED_AS_DISMISSED,
        CONVERSATION_MARKED_AS_READ,
        CONVERSATION_REPLY_SUCCESS,
        FETCH_INBOX_REQUEST,
        FETCH_INBOX_BEFORE_DATE_REQUEST,
        FETCH_INBOX_SUCCESS,
        FETCH_INBOX_FAILED,
        FETCH_CONVERSATION_SUCCESS,
        HARD_RESET,
        INBOX_OPENED,
        HOME_OPENED,
        NEW_COMMENT_EVENT_RECEIVED,
        NEW_CONVERSATION_SCREEN_OPENED,
        NEW_CONVERSATION_SUCCESS,
        SESSION_STARTED,
        SET_LAUNCHER_VISIBILITY,
        SET_IN_APP_NOTIFICATION_VISIBILITY,
        SET_BOTTOM_PADDING,
        SOFT_RESET,
        TEAM_PRESENCE_UPDATED,
        UNREAD_CONVERSATIONS_SUCCESS,
        FETCH_HOME_CARDS_SUCCESS,
        COMPOSER_SUGGESTIONS_UPDATED,
        COMPOSER_SUGGESTION_SELECTED,
        CAROUSEL_UPDATED,
        CAROUSEL_DISMISSED,
        OPEN_PROGRAMMATIC_CAROUSEL,
        PROGRAMMATIC_CAROUSEL_LOADING,
        PROGRAMMATIC_CAROUSEL_SUCCESS,
        PROGRAMMATIC_CAROUSEL_ERROR,
        MESSENGER_OPENED,
        MESSENGER_CLOSED
    }

    Action(Type type2, V v) {
        this.type = type2;
        this.value = v;
    }

    public Type type() {
        return this.type;
    }

    public V value() {
        return this.value;
    }

    public String toString() {
        return this.type.toString() + ": " + this.value.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Action action = (Action) obj;
        if (this.type != action.type) {
            return false;
        }
        return this.value.equals(action.value);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.value.hashCode();
    }
}
