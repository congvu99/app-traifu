package net.hockeyapp.android.listeners;

import net.hockeyapp.android.StringListener;
import net.hockeyapp.android.tasks.SendFeedbackTask;

public abstract class SendFeedbackListener extends StringListener {
    public void feedbackFailed(SendFeedbackTask sendFeedbackTask, Boolean bool) {
    }

    public void feedbackSuccessful(SendFeedbackTask sendFeedbackTask) {
    }
}
