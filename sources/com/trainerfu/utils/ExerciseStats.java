package com.trainerfu.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseStats {
    private static ExerciseStats mInstance;
    private Map<Integer, JSONObject> recentlyLogged = new HashMap();
    private Map<Integer, JSONObject> recentlyPlanned = new HashMap();

    public interface ExerciseStatsResponseHandler {
        void handleRecentlyLoggedStats(int i, int i2, JSONObject jSONObject);

        void handleRecentlyPlannedStats(int i, int i2, JSONObject jSONObject);
    }

    private ExerciseStats() {
    }

    public static ExerciseStats getInstance() {
        if (mInstance == null) {
            mInstance = new ExerciseStats();
        }
        return mInstance;
    }

    private boolean containsRecentlyLoggedStats(int i) {
        return this.recentlyLogged.containsKey(Integer.valueOf(i));
    }

    private boolean containsRecentlyPlannedStats(int i) {
        return this.recentlyPlanned.containsKey(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public void putRecentlyLoggedStats(int i, JSONObject jSONObject) {
        this.recentlyLogged.put(Integer.valueOf(i), jSONObject);
    }

    /* access modifiers changed from: private */
    public void putRecentlyPlannedStats(int i, JSONObject jSONObject) {
        this.recentlyPlanned.put(Integer.valueOf(i), jSONObject);
    }

    public void getRecentlyLoggedStats(final int i, final int i2, final ExerciseStatsResponseHandler exerciseStatsResponseHandler) {
        if (containsRecentlyLoggedStats(i)) {
            exerciseStatsResponseHandler.handleRecentlyLoggedStats(i, i2, getRecentStats(this.recentlyLogged, i, i2));
            return;
        }
        new BaseHttpClient().get(String.format("/users/%s/exercise_stats/recently_logged", new Object[]{Util.getUserIdForUrl(i)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    ExerciseStats.this.putRecentlyLoggedStats(i, jSONObject.getJSONObject("recent"));
                    ExerciseStats.this.getRecentlyLoggedStats(i, i2, exerciseStatsResponseHandler);
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void getRecentlyPlannedStats(final int i, final int i2, final ExerciseStatsResponseHandler exerciseStatsResponseHandler) {
        if (containsRecentlyPlannedStats(i)) {
            exerciseStatsResponseHandler.handleRecentlyPlannedStats(i, i2, getRecentStats(this.recentlyPlanned, i, i2));
            return;
        }
        new BaseHttpClient().get(String.format("/users/%s/exercise_stats/recently_planned_for_user", new Object[]{Util.getUserIdForUrl(i)}), (Map<String, Object>) null, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                try {
                    ExerciseStats.this.putRecentlyPlannedStats(i, jSONObject.getJSONObject("recent"));
                    ExerciseStats.this.getRecentlyPlannedStats(i, i2, exerciseStatsResponseHandler);
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public JSONObject getRecentStats(Map<Integer, JSONObject> map, int i, int i2) {
        JSONObject jSONObject = map.get(Integer.valueOf(i));
        if (!jSONObject.has(String.valueOf(i2))) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(String.valueOf(i2));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSerializedExerciseHistory(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (Integer.parseInt(next) == i) {
                    return jSONObject.getJSONArray(next).toString();
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
