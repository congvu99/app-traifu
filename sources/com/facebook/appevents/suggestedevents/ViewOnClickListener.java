package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import com.brentvatne.react.ReactVideoView;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class ViewOnClickListener implements View.OnClickListener {
    private static final String API_ENDPOINT = "%s/suggested_events";
    public static final String OTHER_EVENT = "other";
    private static final String TAG = ViewOnClickListener.class.getCanonicalName();
    private static final Set<Integer> viewsAttachedListener = new HashSet();
    private String activityName;
    private View.OnClickListener baseListener;
    private WeakReference<View> hostViewWeakReference;
    private WeakReference<View> rootViewWeakReference;

    static /* synthetic */ void access$000(String str, String str2, float[] fArr) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                processPredictedResult(str, str2, fArr);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    static /* synthetic */ String access$100(ViewOnClickListener viewOnClickListener) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return viewOnClickListener.activityName;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    static void attachListener(View view, View view2, String str) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                int hashCode = view.hashCode();
                if (!viewsAttachedListener.contains(Integer.valueOf(hashCode))) {
                    ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str));
                    viewsAttachedListener.add(Integer.valueOf(hashCode));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.hostViewWeakReference = new WeakReference<>(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.activityName = str.toLowerCase().replace("activity", "");
    }

    public void onClick(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                if (this.baseListener != null) {
                    this.baseListener.onClick(view);
                }
                process();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view = (View) this.rootViewWeakReference.get();
                View view2 = (View) this.hostViewWeakReference.get();
                if (view != null && view2 != null) {
                    try {
                        String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                        String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                        if (pathID != null && !queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ViewHierarchyConstants.VIEW_KEY, SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                            jSONObject.put(ViewHierarchyConstants.SCREEN_NAME_KEY, this.activityName);
                            predictAndProcess(pathID, textOfViewRecursively, jSONObject);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private static boolean queryHistoryAndProcess(String str, final String str2) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            final String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (queryEvent.equals("other")) {
                return true;
            }
            Utility.runOnNonUiThread(new Runnable() {
                public void run() {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            ViewOnClickListener.access$000(queryEvent, str2, new float[0]);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    private void predictAndProcess(final String str, final String str2, final JSONObject jSONObject) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Utility.runOnNonUiThread(new Runnable() {
                    public void run() {
                        String[] predict;
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            try {
                                String lowerCase = Utility.getAppName(FacebookSdk.getApplicationContext()).toLowerCase();
                                float[] denseFeatures = FeatureExtractor.getDenseFeatures(jSONObject, lowerCase);
                                String textFeature = FeatureExtractor.getTextFeature(str2, ViewOnClickListener.access$100(ViewOnClickListener.this), lowerCase);
                                if (denseFeatures != null && (predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature})) != null) {
                                    String str = predict[0];
                                    PredictionHistoryManager.addPrediction(str, str);
                                    if (!str.equals("other")) {
                                        ViewOnClickListener.access$000(str, str2, denseFeatures);
                                    }
                                }
                            } catch (Exception unused) {
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private static void processPredictedResult(String str, String str2, float[] fArr) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (SuggestedEventsManager.isProductionEvents(str)) {
                    new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
                } else if (SuggestedEventsManager.isEligibleEvents(str)) {
                    sendPredictedResult(str, str2, fArr);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private static void sendPredictedResult(String str, String str2, float[] fArr) {
        Class<ViewOnClickListener> cls = ViewOnClickListener.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Bundle bundle = new Bundle();
                try {
                    bundle.putString("event_name", str);
                    JSONObject jSONObject = new JSONObject();
                    StringBuilder sb = new StringBuilder();
                    for (float append : fArr) {
                        sb.append(append);
                        sb.append(",");
                    }
                    jSONObject.put("dense", sb.toString());
                    jSONObject.put("button_text", str2);
                    bundle.putString(ReactVideoView.EVENT_PROP_METADATA, jSONObject.toString());
                    GraphRequest newPostRequest = GraphRequest.newPostRequest((AccessToken) null, String.format(Locale.US, API_ENDPOINT, new Object[]{FacebookSdk.getApplicationId()}), (JSONObject) null, (GraphRequest.Callback) null);
                    newPostRequest.setParameters(bundle);
                    newPostRequest.executeAndWait();
                } catch (JSONException unused) {
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
