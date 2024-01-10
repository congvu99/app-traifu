package com.trainerfu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseDataset {
    private static ExerciseDataset mInstance;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> allExercises = null;
    /* access modifiers changed from: private */
    public ArrayList<JSONObject> recentExercises = null;
    /* access modifiers changed from: private */
    public String youtubeApiKey = "";

    public interface ExerciseDatasetFetchedResponder {
        void allExercisesFetched(ArrayList<JSONObject> arrayList);

        void recentExercisesFetched(ArrayList<JSONObject> arrayList);
    }

    private ExerciseDataset() {
    }

    public static ExerciseDataset getInstance() {
        if (mInstance == null) {
            mInstance = new ExerciseDataset();
        }
        return mInstance;
    }

    public ArrayList<JSONObject> getAllExercises() {
        return this.allExercises;
    }

    public String getApiKey() {
        return this.youtubeApiKey;
    }

    public ArrayList<JSONObject> getRecentExercises() {
        return this.recentExercises;
    }

    public void putRecentExercise(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                int i = jSONObject.getInt("id");
                int i2 = 0;
                while (true) {
                    if (i2 >= this.recentExercises.size()) {
                        i2 = -1;
                        break;
                    } else if (this.recentExercises.get(i2).getInt("id") == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    this.recentExercises.remove(i2);
                }
                this.recentExercises.add(0, jSONObject);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fetchAllExercises(ExerciseDatasetFetchedResponder exerciseDatasetFetchedResponder) {
        fetchExercises(false, exerciseDatasetFetchedResponder);
    }

    public void fetchRecentExercises(ExerciseDatasetFetchedResponder exerciseDatasetFetchedResponder) {
        fetchExercises(true, exerciseDatasetFetchedResponder);
    }

    public void removeExercise(JSONObject jSONObject) {
        removeExercise(this.allExercises, jSONObject);
        removeExercise(this.recentExercises, jSONObject);
    }

    private static void removeExercise(ArrayList<JSONObject> arrayList, JSONObject jSONObject) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                try {
                    if (i >= arrayList.size()) {
                        i = -1;
                        break;
                    } else if (arrayList.get(i).getInt("id") == jSONObject.getInt("id")) {
                        break;
                    } else {
                        i++;
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            if (i > -1) {
                arrayList.remove(i);
            }
        }
    }

    private void fetchExercises(final boolean z, final ExerciseDatasetFetchedResponder exerciseDatasetFetchedResponder) {
        BaseHttpClient baseHttpClient = new BaseHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("include_overrides", true);
        hashMap.put("include_instructions", true);
        if (z) {
            hashMap.put("recent", "1");
        }
        baseHttpClient.get("/exercises", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("exercises");
                    String unused = ExerciseDataset.this.youtubeApiKey = jSONObject.getString("yt_api_key");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add((JSONObject) jSONArray.get(i2));
                    }
                    if (z) {
                        ArrayList unused2 = ExerciseDataset.this.recentExercises = arrayList;
                        if (exerciseDatasetFetchedResponder == null) {
                            return true;
                        }
                        exerciseDatasetFetchedResponder.recentExercisesFetched(arrayList);
                        return true;
                    }
                    ArrayList unused3 = ExerciseDataset.this.allExercises = arrayList;
                    if (exerciseDatasetFetchedResponder == null) {
                        return true;
                    }
                    exerciseDatasetFetchedResponder.allExercisesFetched(arrayList);
                    return true;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
