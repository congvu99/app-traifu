package com.trainerfu.utils;

import com.trainerfu.android.FavoriteType;
import java.util.Date;
import java.util.HashMap;
import org.apache.http.Header;
import org.json.JSONObject;

public class FavoriteUtil {
    public static void updateFavorite(boolean z, FavoriteType favoriteType, Date date) {
        HashMap hashMap = new HashMap();
        hashMap.put("favorite_type", Integer.valueOf(favoriteType.getMask()));
        hashMap.put("owner_id", "myself");
        hashMap.put("entity_id", DateUtils.getISOFormattedDate(date));
        hashMap.put("like", Boolean.valueOf(z));
        new BaseHttpClient().post("/favorites", hashMap, new BaseResponseHandler() {
            public boolean handleFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
                return true;
            }

            public boolean handleSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
                return true;
            }
        });
    }
}
