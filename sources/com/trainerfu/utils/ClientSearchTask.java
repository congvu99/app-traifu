package com.trainerfu.utils;

import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientSearchTask extends AsyncTask<ClientTuple<String, JSONArray, ArrayList<Integer>>, Integer, ClientTuple<String, JSONArray, ArrayList<Integer>>> {
    private SearchResultHandler handler;

    public interface SearchResultHandler {
        void handleSearchResult(ClientTuple<String, JSONArray, ArrayList<Integer>> clientTuple);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
    }

    public ClientSearchTask(SearchResultHandler searchResultHandler) {
        this.handler = searchResultHandler;
    }

    /* access modifiers changed from: protected */
    public ClientTuple<String, JSONArray, ArrayList<Integer>> doInBackground(ClientTuple<String, JSONArray, ArrayList<Integer>>... clientTupleArr) {
        ClientTuple<String, JSONArray, ArrayList<Integer>> clientTuple = clientTupleArr[0];
        String str = (String) clientTuple.x;
        JSONArray jSONArray = (JSONArray) clientTuple.y;
        ArrayList arrayList = (ArrayList) clientTuple.z;
        JSONArray jSONArray2 = new JSONArray();
        ArrayList arrayList2 = new ArrayList();
        if (jSONArray == null || str == null || str.trim().length() == 0) {
            return new ClientTuple<>("", new JSONArray(), new ArrayList());
        }
        String[] split = str.trim().split("\\s+");
        Pattern[] patternArr = new Pattern[split.length];
        for (int i = 0; i < split.length; i++) {
            patternArr[i] = Pattern.compile("\\b" + Pattern.quote(split[i]), 2);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (isCancelled()) {
                return new ClientTuple<>("", new JSONArray(), new ArrayList());
            }
            try {
                if (isAMatch(patternArr, (JSONObject) jSONArray.get(((Integer) arrayList.get(i2)).intValue()))) {
                    arrayList2.add(arrayList.get(i2));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new ClientTuple<>(str, jSONArray2, arrayList2);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(ClientTuple<String, JSONArray, ArrayList<Integer>> clientTuple) {
        SearchResultHandler searchResultHandler = this.handler;
        if (searchResultHandler != null) {
            searchResultHandler.handleSearchResult(clientTuple);
        }
    }

    private boolean isAMatch(Pattern[] patternArr, JSONObject jSONObject) {
        int i = 0;
        while (i < patternArr.length) {
            Pattern pattern = patternArr[i];
            try {
                String string = jSONObject.getString("first_name");
                String string2 = jSONObject.getString("last_name");
                if (!pattern.matcher(string).find() && !pattern.matcher(string2).find()) {
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
