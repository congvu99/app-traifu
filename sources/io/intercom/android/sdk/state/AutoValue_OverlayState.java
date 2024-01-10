package io.intercom.android.sdk.state;

import android.app.Activity;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.state.OverlayState;
import io.intercom.android.sdk.survey.model.SurveyData;
import java.util.List;
import java.util.Set;

final class AutoValue_OverlayState extends OverlayState {
    private final int bottomPadding;
    private final Carousel carousel;
    private final List<Conversation> conversations;
    private final Set<String> dismissedPartIds;
    private final Intercom.Visibility launcherVisibility;
    private final Intercom.Visibility notificationVisibility;
    private final Activity pausedHostActivity;
    private final Activity resumedHostActivity;
    private final SurveyData survey;

    private AutoValue_OverlayState(List<Conversation> list, Set<String> set, Intercom.Visibility visibility, Intercom.Visibility visibility2, int i, Activity activity, Activity activity2, Carousel carousel2, SurveyData surveyData) {
        this.conversations = list;
        this.dismissedPartIds = set;
        this.notificationVisibility = visibility;
        this.launcherVisibility = visibility2;
        this.bottomPadding = i;
        this.resumedHostActivity = activity;
        this.pausedHostActivity = activity2;
        this.carousel = carousel2;
        this.survey = surveyData;
    }

    public List<Conversation> conversations() {
        return this.conversations;
    }

    public Set<String> dismissedPartIds() {
        return this.dismissedPartIds;
    }

    public Intercom.Visibility notificationVisibility() {
        return this.notificationVisibility;
    }

    public Intercom.Visibility launcherVisibility() {
        return this.launcherVisibility;
    }

    public int bottomPadding() {
        return this.bottomPadding;
    }

    public Activity resumedHostActivity() {
        return this.resumedHostActivity;
    }

    public Activity pausedHostActivity() {
        return this.pausedHostActivity;
    }

    public Carousel carousel() {
        return this.carousel;
    }

    public SurveyData survey() {
        return this.survey;
    }

    public String toString() {
        return "OverlayState{conversations=" + this.conversations + ", dismissedPartIds=" + this.dismissedPartIds + ", notificationVisibility=" + this.notificationVisibility + ", launcherVisibility=" + this.launcherVisibility + ", bottomPadding=" + this.bottomPadding + ", resumedHostActivity=" + this.resumedHostActivity + ", pausedHostActivity=" + this.pausedHostActivity + ", carousel=" + this.carousel + ", survey=" + this.survey + "}";
    }

    public boolean equals(Object obj) {
        Activity activity;
        Activity activity2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OverlayState)) {
            return false;
        }
        OverlayState overlayState = (OverlayState) obj;
        if (!this.conversations.equals(overlayState.conversations()) || !this.dismissedPartIds.equals(overlayState.dismissedPartIds()) || !this.notificationVisibility.equals(overlayState.notificationVisibility()) || !this.launcherVisibility.equals(overlayState.launcherVisibility()) || this.bottomPadding != overlayState.bottomPadding() || ((activity = this.resumedHostActivity) != null ? !activity.equals(overlayState.resumedHostActivity()) : overlayState.resumedHostActivity() != null) || ((activity2 = this.pausedHostActivity) != null ? !activity2.equals(overlayState.pausedHostActivity()) : overlayState.pausedHostActivity() != null) || !this.carousel.equals(overlayState.carousel()) || !this.survey.equals(overlayState.survey())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((this.conversations.hashCode() ^ 1000003) * 1000003) ^ this.dismissedPartIds.hashCode()) * 1000003) ^ this.notificationVisibility.hashCode()) * 1000003) ^ this.launcherVisibility.hashCode()) * 1000003) ^ this.bottomPadding) * 1000003;
        Activity activity = this.resumedHostActivity;
        int i = 0;
        int hashCode2 = (hashCode ^ (activity == null ? 0 : activity.hashCode())) * 1000003;
        Activity activity2 = this.pausedHostActivity;
        if (activity2 != null) {
            i = activity2.hashCode();
        }
        return ((((hashCode2 ^ i) * 1000003) ^ this.carousel.hashCode()) * 1000003) ^ this.survey.hashCode();
    }

    public OverlayState.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends OverlayState.Builder {
        private Integer bottomPadding;
        private Carousel carousel;
        private List<Conversation> conversations;
        private Set<String> dismissedPartIds;
        private Intercom.Visibility launcherVisibility;
        private Intercom.Visibility notificationVisibility;
        private Activity pausedHostActivity;
        private Activity resumedHostActivity;
        private SurveyData survey;

        Builder() {
        }

        private Builder(OverlayState overlayState) {
            this.conversations = overlayState.conversations();
            this.dismissedPartIds = overlayState.dismissedPartIds();
            this.notificationVisibility = overlayState.notificationVisibility();
            this.launcherVisibility = overlayState.launcherVisibility();
            this.bottomPadding = Integer.valueOf(overlayState.bottomPadding());
            this.resumedHostActivity = overlayState.resumedHostActivity();
            this.pausedHostActivity = overlayState.pausedHostActivity();
            this.carousel = overlayState.carousel();
            this.survey = overlayState.survey();
        }

        public OverlayState.Builder conversations(List<Conversation> list) {
            if (list != null) {
                this.conversations = list;
                return this;
            }
            throw new NullPointerException("Null conversations");
        }

        public OverlayState.Builder dismissedPartIds(Set<String> set) {
            if (set != null) {
                this.dismissedPartIds = set;
                return this;
            }
            throw new NullPointerException("Null dismissedPartIds");
        }

        public OverlayState.Builder notificationVisibility(Intercom.Visibility visibility) {
            if (visibility != null) {
                this.notificationVisibility = visibility;
                return this;
            }
            throw new NullPointerException("Null notificationVisibility");
        }

        public OverlayState.Builder launcherVisibility(Intercom.Visibility visibility) {
            if (visibility != null) {
                this.launcherVisibility = visibility;
                return this;
            }
            throw new NullPointerException("Null launcherVisibility");
        }

        public OverlayState.Builder bottomPadding(int i) {
            this.bottomPadding = Integer.valueOf(i);
            return this;
        }

        public OverlayState.Builder resumedHostActivity(Activity activity) {
            this.resumedHostActivity = activity;
            return this;
        }

        public OverlayState.Builder pausedHostActivity(Activity activity) {
            this.pausedHostActivity = activity;
            return this;
        }

        public OverlayState.Builder carousel(Carousel carousel2) {
            if (carousel2 != null) {
                this.carousel = carousel2;
                return this;
            }
            throw new NullPointerException("Null carousel");
        }

        public OverlayState.Builder survey(SurveyData surveyData) {
            if (surveyData != null) {
                this.survey = surveyData;
                return this;
            }
            throw new NullPointerException("Null survey");
        }

        public OverlayState build() {
            String str = "";
            if (this.conversations == null) {
                str = str + " conversations";
            }
            if (this.dismissedPartIds == null) {
                str = str + " dismissedPartIds";
            }
            if (this.notificationVisibility == null) {
                str = str + " notificationVisibility";
            }
            if (this.launcherVisibility == null) {
                str = str + " launcherVisibility";
            }
            if (this.bottomPadding == null) {
                str = str + " bottomPadding";
            }
            if (this.carousel == null) {
                str = str + " carousel";
            }
            if (this.survey == null) {
                str = str + " survey";
            }
            if (str.isEmpty()) {
                return new AutoValue_OverlayState(this.conversations, this.dismissedPartIds, this.notificationVisibility, this.launcherVisibility, this.bottomPadding.intValue(), this.resumedHostActivity, this.pausedHostActivity, this.carousel, this.survey);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
