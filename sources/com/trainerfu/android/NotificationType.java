package com.trainerfu.android;

public enum NotificationType {
    WORKOUT_LOG_UPDATED(1),
    WORKOUT_PLAN_UPDATED(2),
    MEAL_LOG_UPDATED(3),
    FAVOURITED(4),
    ACHIEVEMENT_UNLOACKED(5),
    WORKOUT_LOG_COMMENT_ADDED(6),
    INTERESTING_STATS_FOUND(7),
    PHOTO_LOG_COMMENT_ADDED(8),
    WORKOUT_LOG_COMMENT_ADDED_2(9),
    NEW_MESSAGE(10),
    NEW_LEAD(11),
    STORY_LIKED(12),
    STORY_COMMENT_ADDED(13),
    POST_STORY_ADDED(14),
    MFP_CONNECT_DISABLED(15),
    MFP_CONNECT_FAILED(16),
    CLIENT_IGNORED_INVITE(17),
    CLIENT_FIRST_LOGIN(18),
    TEST_DRIVE_CLIENT_APP(19),
    TEST_DRIVE_MOBILE_APP(20),
    TEST_DRIVE_WEB_APP(21),
    NEW_CLIENT_SIGNUP(22),
    TRAINERFU_ENGAGEMENT_MESSAGE(23),
    PLAN_TEMPLATE_COPIED(24),
    GMAIL_API_TOKEN_EXPIRED(25),
    CLIENT_CANCELLED_SUBSCRIPTION(26),
    DELETE_CLIENT_ACCOUNT_REQUEST(27),
    CLIENT_ACCOUNT_DEACTIVATED_IAP(28),
    CLIENT_ACCOUNT_ACCESS_EXTENDED_IAP(29),
    CLIENT_ACCOUNT_REACTIVATED_IAP(30),
    IAP_EXPIRED_CLIENT_ACCOUNT_NOT_DEACTIVATED(31);
    
    private final int mask;

    private NotificationType(int i) {
        this.mask = i;
    }

    public int getMask() {
        return this.mask;
    }

    public static NotificationType getNotificationType(int i) {
        if (i == 1) {
            return WORKOUT_LOG_UPDATED;
        }
        if (i == 2) {
            return WORKOUT_PLAN_UPDATED;
        }
        if (i == 3) {
            return MEAL_LOG_UPDATED;
        }
        if (i == 4) {
            return FAVOURITED;
        }
        if (i == 5) {
            return ACHIEVEMENT_UNLOACKED;
        }
        if (i == 6) {
            return WORKOUT_LOG_COMMENT_ADDED;
        }
        if (i == 7) {
            return INTERESTING_STATS_FOUND;
        }
        if (i == 8) {
            return PHOTO_LOG_COMMENT_ADDED;
        }
        if (i == 9) {
            return WORKOUT_LOG_COMMENT_ADDED_2;
        }
        if (i == 10) {
            return NEW_MESSAGE;
        }
        if (i == 11) {
            return NEW_LEAD;
        }
        if (i == 12) {
            return STORY_LIKED;
        }
        if (i == 13) {
            return STORY_COMMENT_ADDED;
        }
        if (i == 14) {
            return POST_STORY_ADDED;
        }
        if (i == 15) {
            return MFP_CONNECT_DISABLED;
        }
        if (i == 16) {
            return MFP_CONNECT_FAILED;
        }
        if (i == 17) {
            return CLIENT_IGNORED_INVITE;
        }
        if (i == 18) {
            return CLIENT_FIRST_LOGIN;
        }
        if (i == 19) {
            return TEST_DRIVE_CLIENT_APP;
        }
        if (i == 20) {
            return TEST_DRIVE_MOBILE_APP;
        }
        if (i == 21) {
            return TEST_DRIVE_WEB_APP;
        }
        if (i == 22) {
            return NEW_CLIENT_SIGNUP;
        }
        if (i == 23) {
            return TRAINERFU_ENGAGEMENT_MESSAGE;
        }
        if (i == 24) {
            return PLAN_TEMPLATE_COPIED;
        }
        if (i == 25) {
            return GMAIL_API_TOKEN_EXPIRED;
        }
        if (i == 26) {
            return CLIENT_CANCELLED_SUBSCRIPTION;
        }
        if (i == 27) {
            return DELETE_CLIENT_ACCOUNT_REQUEST;
        }
        if (i == 28) {
            return CLIENT_ACCOUNT_DEACTIVATED_IAP;
        }
        if (i == 29) {
            return CLIENT_ACCOUNT_ACCESS_EXTENDED_IAP;
        }
        if (i == 30) {
            return CLIENT_ACCOUNT_REACTIVATED_IAP;
        }
        if (i == 31) {
            return IAP_EXPIRED_CLIENT_ACCOUNT_NOT_DEACTIVATED;
        }
        return null;
    }
}
