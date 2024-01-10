package com.facebook.share.internal;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenGraphJSONUtility {

    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    public static JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        Class<OpenGraphJSONUtility> cls = OpenGraphJSONUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : shareOpenGraphAction.keySet()) {
                jSONObject.put(next, toJSONValue(shareOpenGraphAction.get(next), photoJSONProcessor));
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static JSONObject toJSONObject(ShareOpenGraphObject shareOpenGraphObject, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        Class<OpenGraphJSONUtility> cls = OpenGraphJSONUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String next : shareOpenGraphObject.keySet()) {
                jSONObject.put(next, toJSONValue(shareOpenGraphObject.get(next), photoJSONProcessor));
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private static JSONArray toJSONArray(List list, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        Class<OpenGraphJSONUtility> cls = OpenGraphJSONUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object jSONValue : list) {
                jSONArray.put(toJSONValue(jSONValue, photoJSONProcessor));
            }
            return jSONArray;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static Object toJSONValue(Object obj, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        Class<OpenGraphJSONUtility> cls = OpenGraphJSONUtility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        if (obj == null) {
            try {
                return JSONObject.NULL;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
                return null;
            }
        } else {
            if (!(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer)) {
                if (!(obj instanceof Long)) {
                    if (obj instanceof SharePhoto) {
                        if (photoJSONProcessor != null) {
                            return photoJSONProcessor.toJSONObject((SharePhoto) obj);
                        }
                        return null;
                    } else if (obj instanceof ShareOpenGraphObject) {
                        return toJSONObject((ShareOpenGraphObject) obj, photoJSONProcessor);
                    } else {
                        if (obj instanceof List) {
                            return toJSONArray((List) obj, photoJSONProcessor);
                        }
                        throw new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
                    }
                }
            }
            return obj;
        }
    }

    private OpenGraphJSONUtility() {
    }
}
