package net.hockeyapp.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import net.hockeyapp.android.objects.FeedbackResponse;
import net.hockeyapp.android.utils.FeedbackParser;

public class ParseFeedbackTask extends AsyncTask<Void, Void, FeedbackResponse> {
    private Context context;
    private String feedbackResponse;
    private Handler handler;

    public ParseFeedbackTask(Context context2, String str, Handler handler2) {
        this.context = context2;
        this.feedbackResponse = str;
        this.handler = handler2;
    }

    /* access modifiers changed from: protected */
    public FeedbackResponse doInBackground(Void... voidArr) {
        if (this.context == null || this.feedbackResponse == null) {
            return null;
        }
        return FeedbackParser.getInstance().parseFeedbackResponse(this.feedbackResponse);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(FeedbackResponse feedbackResponse2) {
        if (feedbackResponse2 != null && this.handler != null) {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putSerializable("parse_feedback_response", feedbackResponse2);
            message.setData(bundle);
            this.handler.sendMessage(message);
        }
    }
}
