package io.intercom.android.sdk.state;

import android.app.Activity;
import io.intercom.android.sdk.Intercom;
import io.intercom.android.sdk.models.Conversation;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.state.AutoValue_OverlayState;
import io.intercom.android.sdk.survey.model.SurveyData;
import java.util.List;
import java.util.Set;

public abstract class OverlayState {

    public static abstract class Builder {
        public abstract Builder bottomPadding(int i);

        public abstract OverlayState build();

        public abstract Builder carousel(Carousel carousel);

        public abstract Builder conversations(List<Conversation> list);

        public abstract Builder dismissedPartIds(Set<String> set);

        public abstract Builder launcherVisibility(Intercom.Visibility visibility);

        public abstract Builder notificationVisibility(Intercom.Visibility visibility);

        public abstract Builder pausedHostActivity(Activity activity);

        public abstract Builder resumedHostActivity(Activity activity);

        public abstract Builder survey(SurveyData surveyData);
    }

    public abstract int bottomPadding();

    public abstract Carousel carousel();

    public abstract List<Conversation> conversations();

    public abstract Set<String> dismissedPartIds();

    public abstract Intercom.Visibility launcherVisibility();

    public abstract Intercom.Visibility notificationVisibility();

    public abstract Activity pausedHostActivity();

    public abstract Activity resumedHostActivity();

    public abstract SurveyData survey();

    public abstract Builder toBuilder();

    public static OverlayState create(List<Conversation> list, Set<String> set, Intercom.Visibility visibility, Intercom.Visibility visibility2, Activity activity, Activity activity2, int i, Carousel carousel, SurveyData surveyData) {
        return builder().conversations(list).dismissedPartIds(set).notificationVisibility(visibility).launcherVisibility(visibility2).bottomPadding(i).resumedHostActivity(activity).pausedHostActivity(activity2).carousel(carousel).survey(surveyData).build();
    }

    public static Builder builder() {
        return new AutoValue_OverlayState.Builder();
    }
}
