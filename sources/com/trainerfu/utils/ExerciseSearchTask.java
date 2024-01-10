package com.trainerfu.utils;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class ExerciseSearchTask extends AsyncTask<Tuple<String, ArrayList<JSONObject>>, Integer, Tuple<String, ArrayList<JSONObject>>> {
    private SearchResultHandler handler;

    public interface SearchResultHandler {
        void handleSearchResult(Tuple<String, ArrayList<JSONObject>> tuple);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
    }

    public ExerciseSearchTask(SearchResultHandler searchResultHandler) {
        this.handler = searchResultHandler;
    }

    /* access modifiers changed from: protected */
    public Tuple<String, ArrayList<JSONObject>> doInBackground(Tuple<String, ArrayList<JSONObject>>... tupleArr) {
        Tuple<String, ArrayList<JSONObject>> tuple = tupleArr[0];
        String str = (String) tuple.x;
        ArrayList arrayList = (ArrayList) tuple.y;
        ArrayList arrayList2 = new ArrayList();
        if (arrayList == null || str == null || str.trim().length() == 0) {
            return new Tuple<>("", new ArrayList());
        }
        String[] split = str.trim().split("\\s+");
        Pattern[] patternArr = new Pattern[split.length];
        for (int i = 0; i < split.length; i++) {
            patternArr[i] = Pattern.compile("\\b" + Pattern.quote(split[i]), 2);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (isCancelled()) {
                return new Tuple<>("", new ArrayList());
            }
            if (isAMatch(patternArr, (JSONObject) arrayList.get(i2))) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        return new Tuple<>(str, arrayList2);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Tuple<String, ArrayList<JSONObject>> tuple) {
        SearchResultHandler searchResultHandler = this.handler;
        if (searchResultHandler != null) {
            searchResultHandler.handleSearchResult(tuple);
        }
    }

    private boolean isAMatch(Pattern[] patternArr, JSONObject jSONObject) {
        int i = 0;
        while (i < patternArr.length) {
            try {
                if (!patternArr[i].matcher(jSONObject.getString("name")).find()) {
                    return false;
                }
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
