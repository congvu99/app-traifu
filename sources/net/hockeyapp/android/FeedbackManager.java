package net.hockeyapp.android;

import android.content.Context;
import android.content.Intent;

public class FeedbackManager {
    private static String identifier;
    private static FeedbackManagerListener lastListener;
    private static String urlString;

    public static void register(Context context, String str) {
        register(context, str, (FeedbackManagerListener) null);
    }

    public static void register(Context context, String str, FeedbackManagerListener feedbackManagerListener) {
        register(context, Constants.BASE_URL, str, feedbackManagerListener);
    }

    public static void register(Context context, String str, String str2, FeedbackManagerListener feedbackManagerListener) {
        if (context != null) {
            identifier = str2;
            urlString = str;
            lastListener = feedbackManagerListener;
            Constants.loadFromContext(context);
        }
    }

    public static void unregister() {
        lastListener = null;
    }

    public static void showFeedbackActivity(Context context) {
        if (context != null) {
            Class cls = null;
            FeedbackManagerListener feedbackManagerListener = lastListener;
            if (feedbackManagerListener != null) {
                cls = feedbackManagerListener.getFeedbackActivityClass();
            }
            if (cls == null) {
                cls = FeedbackActivity.class;
            }
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setClass(context, cls);
            intent.putExtra("url", getURLString(context));
            context.startActivity(intent);
        }
    }

    private static String getURLString(Context context) {
        return urlString + "api/2/apps/" + identifier + "/feedback/";
    }

    public static FeedbackManagerListener getLastListener() {
        return lastListener;
    }
}
