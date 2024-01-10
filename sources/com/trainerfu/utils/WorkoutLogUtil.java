package com.trainerfu.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.trainerfu.android.CompletionHandler;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class WorkoutLogUtil {

    public static class ResponseHandler extends BaseResponseHandler {
        private CompletionHandler completionHandler;

        public ResponseHandler(CompletionHandler completionHandler2) {
            this.completionHandler = completionHandler2;
        }

        public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
            CompletionHandler completionHandler2 = this.completionHandler;
            if (completionHandler2 != null) {
                return completionHandler2.complete(true, jSONObject);
            }
            return true;
        }

        public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
            CompletionHandler completionHandler2 = this.completionHandler;
            if (completionHandler2 != null) {
                return completionHandler2.complete(false, jSONObject);
            }
            return false;
        }
    }

    public static void logNewWorkout(int i, Date date, Activity activity, CompletionHandler completionHandler) {
        Object[] objArr = new Object[2];
        boolean z = false;
        objArr[0] = i == 0 ? "myself" : String.valueOf(i);
        objArr[1] = DateUtils.getISOFormattedDate(date);
        String format = String.format("/users/%s/day_logs/%s/new", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("exercise_id", 1);
        hashMap.put("rest_time", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_activity_drill", true);
        hashMap.put(ExifInterface.GPS_MEASUREMENT_2D, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("4", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("8", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("is_public", true);
        if (activity != null) {
            z = true;
        }
        new BaseHttpClient(Boolean.valueOf(z), activity).put(format, hashMap, new ResponseHandler(completionHandler));
    }

    public static void updateWorkoutLogVisibility(boolean z, int i, Date date, Activity activity, CompletionHandler completionHandler) {
        Object[] objArr = new Object[2];
        boolean z2 = false;
        objArr[0] = i == 0 ? "myself" : String.valueOf(i);
        objArr[1] = DateUtils.getISOFormattedDate(date);
        String format = String.format("/users/%s/day_logs/%s/visibility", objArr);
        HashMap hashMap = new HashMap();
        hashMap.put("is_public", Boolean.valueOf(z));
        if (activity != null) {
            z2 = true;
        }
        new BaseHttpClient(Boolean.valueOf(z2), activity).post(format, hashMap, new ResponseHandler(completionHandler));
    }

    public static void addNoteToWorkoutLog(int i, Date date, String str, boolean z, Activity activity, CompletionHandler completionHandler) {
        boolean z2 = false;
        String format = String.format("/users/%s/day_logs/%s/comments/new", new Object[]{i <= 0 ? "myself" : String.valueOf(i), DateUtils.getISOFormattedDate(date)});
        HashMap hashMap = new HashMap();
        hashMap.put("comment", str);
        hashMap.put("is_featured", true);
        hashMap.put("append", Boolean.valueOf(z));
        if (activity != null) {
            z2 = true;
        }
        new BaseHttpClient(Boolean.valueOf(z2), activity).put(format, hashMap, new ResponseHandler(completionHandler));
    }

    public static void saveWorkoutLogPhoto(int i, Date date, Bitmap bitmap, boolean z, Activity activity, CompletionHandler completionHandler) {
        String str;
        BaseHttpClient baseHttpClient = new BaseHttpClient(Boolean.valueOf(activity != null), activity);
        HashMap hashMap = new HashMap();
        hashMap.put("photo_type", 2);
        hashMap.put("is_public", Boolean.valueOf(z));
        hashMap.put("date", DateUtils.getISOFormattedDate(date));
        Object[] objArr = new Object[1];
        if (i == 0) {
            str = "myself";
        } else {
            str = String.valueOf(i);
        }
        objArr[0] = str;
        baseHttpClient.postWithImage(String.format("/users/%s/photos/new", objArr), hashMap, bitmap, new ResponseHandler(completionHandler));
    }
}
