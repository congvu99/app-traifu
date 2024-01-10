package io.intercom.android.sdk.models;

import io.intercom.android.sdk.models.ComposerSuggestions;
import io.intercom.android.sdk.models.TeamPresence;
import io.intercom.android.sdk.models.UsersResponse;
import io.intercom.android.sdk.models.carousel.Carousel;
import io.intercom.android.sdk.survey.model.SurveyData;

public class UpdateUserResponse extends UsersResponse {
    private final BotIntro botIntro;
    private final Carousel carousel;
    private final ComposerSuggestions composerSuggestions;
    private final SurveyData surveyData;
    private final TeamPresence teamPresence;

    UpdateUserResponse(Builder builder) {
        super(builder);
        TeamPresence teamPresence2;
        ComposerSuggestions composerSuggestions2;
        if (builder.team_presence == null) {
            teamPresence2 = new TeamPresence.Builder().build();
        } else {
            teamPresence2 = builder.team_presence.build();
        }
        this.teamPresence = teamPresence2;
        if (builder.composer_suggestions == null) {
            composerSuggestions2 = new ComposerSuggestions.Builder().build();
        } else {
            composerSuggestions2 = builder.composer_suggestions.build();
        }
        this.composerSuggestions = composerSuggestions2;
        this.carousel = (builder.carousel == null ? new Carousel.Builder() : builder.carousel).build();
        this.botIntro = builder.bot_intro == null ? BotIntro.BOT_INTRO_NULL : builder.bot_intro;
        this.surveyData = builder.survey == null ? SurveyData.Companion.getNULL() : builder.survey;
    }

    public TeamPresence getTeamPresence() {
        return this.teamPresence;
    }

    public ComposerSuggestions getComposerSuggestions() {
        return this.composerSuggestions;
    }

    public Carousel getCarousel() {
        return this.carousel;
    }

    public BotIntro getBotIntro() {
        return this.botIntro;
    }

    public SurveyData getSurveyData() {
        return this.surveyData;
    }

    public static final class Builder extends UsersResponse.Builder {
        BotIntro bot_intro;
        Carousel.Builder carousel;
        ComposerSuggestions.Builder composer_suggestions;
        SurveyData survey;
        TeamPresence.Builder team_presence;

        public UpdateUserResponse build() {
            return new UpdateUserResponse(this);
        }
    }
}
